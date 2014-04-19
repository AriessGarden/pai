package com.pencho.pai.controllers;

import static play.data.Form.form;

import java.util.Calendar;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.bson.types.ObjectId;
import org.mongojack.DBCursor;
import org.mongojack.DBQuery;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import scala.util.Random;
import utils.DataFormatUtil;
import utils.MsgUtil;
import utils.SecurityUtil;
import utils.UsersAuthorityUtil;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;
import com.pencho.pai.controllers.Application.Login;
import com.pencho.pai.dao.DAO;
import com.pencho.pai.models.Post;
import com.pencho.pai.models.Shop;
import com.pencho.pai.models.User;

public class UserController extends Controller {

	public static final DBCollection userCollection = DAO.database
			.getCollection("user");
	public static final JacksonDBCollection<User, String> userCollectionJackson = JacksonDBCollection
			.wrap(userCollection, User.class, String.class);
	public static final DBCollection postCollection = DAO.database
			.getCollection("post");
	public static final JacksonDBCollection<Post, String> postCollectionJackson = JacksonDBCollection
			.wrap(postCollection, Post.class, String.class);

	public static Result test(String key) {
		DBCursor<User> result = userCollectionJackson.find(DBQuery.regex(
				"phone", Pattern.compile(".*" + key + ".*")));
		ArrayNode limitResult = Json.newObject().arrayNode();
		while (result.hasNext()) {
			limitResult.add(result.next().toJson());
		}
		return ok(DataFormatUtil.toJsend("Success", "result", limitResult));
	}

	/**
	 * Find user by id
	 * 
	 * @author aries
	 * @return
	 */
	public static Result findUserById() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		Form<User> postForm = form(User.class).bindFromRequest();
		if (postForm.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "in parameter"));

		User dbUser = userCollectionJackson.findOneById(postForm.get().getId());
		if (dbUser == null)
			return ok(DataFormatUtil.toJsend("fail", "user is not exist"));

		return ok(DataFormatUtil.toJsend("success", "Users", dbUser.toJson()));
	}

	/**
	 * a tool for Sending a sms with validation code in it
	 * 
	 * @author Aries
	 * @return
	 */
	public static Result SMS(String method) {

		Form<User> postParameter = form(User.class).bindFromRequest();
		String phone = postParameter.get().getPhone();

		// Judge the phone number
		if (postParameter.hasErrors()) {

			return ok(DataFormatUtil.toJsend("fail", "in parameter"));
		}
		// if phone is blank or the length is 11
		if (SecurityUtil.isBlank(postParameter.get().getPhone())
				|| postParameter.get().getPhone().trim().length() != 11) {
			return ok(DataFormatUtil.toJsend("fail",
					"the phone u input is blank or wrong length."));
		}
		// if phone is number
		try {
			Long.parseLong(postParameter.get().getPhone());
		} catch (Exception e) {
			return ok(DataFormatUtil.toJsend("fail", "Number,no letters,ok?"));
		}
		// if phone is exist
		if ("send".equals(method)) {
			if (exist(phone.trim())) {
				return ok(DataFormatUtil.toJsend("fail",
						"Phone is already exist!"));
			}
		} else if ("resend".equals(method)) {
			if (!exist(phone.trim())) {
				return ok(DataFormatUtil.toJsend("fail", "Phone is not exist!"));
			}
		}
		String sms;
		// create sms
		Random random = new Random();
		long num = random.nextInt(899999) + 100000;
		User newUser = new User();
		// set the due (3min)
		sms = num + ",due:" + SecurityUtil.getExpire(3);
		newUser.setSms(sms);
		newUser.setPhone(phone);
		newUser.setCreateTime(DataFormatUtil.getNow());
		session("phone", phone);
		User dbUser = findByPhone(phone);
		WriteResult<User, String> saved = null;

		// Judge phone was used or not
		if (dbUser != null) {
			if (!dbUser.getValidated() || "resend".equals(method)) {
				dbUser.setSms(sms);
				saved = userCollectionJackson.update(
						DBQuery.is("phone", phone), dbUser);

				// Sending
				// msg------------------------------------------------------------------------

				try {
					MsgUtil.send(phone, " 4 change " + num + " ");
				} catch (Exception e) {
					play.Logger.info("send msg fail");
				}

				return ok(DataFormatUtil.toJsend("success", sms));
			}
			return ok(DataFormatUtil
					.toJsend("fail",
							"u have validated already,please complete ur info as soon as possiable"));
		}

		// if ("resend".equals(method))
		// return ok(DataFormatUtil.toJsend("fail", "sign up first!"));
		saved = userCollectionJackson.insert(newUser);

		// Sending
		// msg------------------------------------------------------------------------------

		try {
			MsgUtil.send(phone, " 4 create " + num + " ");
		} catch (Exception e) {
			play.Logger.info("send msg fail");
		}

		return ok(DataFormatUtil.toJsend("success", sms));

	}

	/**
	 * Get sms
	 * 
	 * @author aries
	 * @return
	 */
	public static Result sendSMS() {
		return SMS("send");
	}

	/**
	 * Reget sms,for change psw
	 * 
	 * @author aries
	 * @return
	 */
	public static Result resendSMS() {
		return SMS("resend");
	}

	/**
	 * validate the phone tool
	 * 
	 * @author Aries
	 * @return
	 */
	public static Result validateSMS(String method) {
		User user = findByPhone(session().get("phone"));
		if (user == null)
			return ok(DataFormatUtil.toJsend("fail",
					"u need to get a code first"));
		if ("do".equals(method) && user.getValidated())
			return ok(DataFormatUtil.toJsend("fail",
					"u have already validated,try to sign up or login!"));
		else if ("redo".equals(method) && !user.getValidated()) {
			return ok(DataFormatUtil.toJsend("fail", "do validate,not redo"));
		}
		// If SMS is due
		if (user.getSms() != null && !"".equals(user.getSms().trim())
				&& user.getSms().length() == 30) {
			if (SecurityUtil.isExpire(user.getSms().substring(11))) {
				user.setSms("");
				return ok(DataFormatUtil.toJsend("fail", "Code is out of time"));
			}
		} else
			return ok(DataFormatUtil.toJsend("fail",
					"Get validation coad frist.(or coad has been used already"));

		Form<User> postParameter = form(User.class).bindFromRequest();

		if ("do".equals(method)) {
			if (!postParameter.get().getSms().trim()
					.equals(user.getSms().substring(0, 6)))
				return ok(DataFormatUtil.toJsend("fail", "Wrong sms"));
			user.setValidated(true);
		} else if ("redo".equals(method)) {
			if (!postParameter.get().getSms().trim()
					.equals(user.getSms().substring(0, 6)))
				return ok(DataFormatUtil.toJsend("fail", "Wrong sms"));
			user.setReValidated(true);
		}
		user.setSms("");
		userCollectionJackson.update(
				DBQuery.is("phone", session().get("phone")), user);

		return ok(DataFormatUtil.toJsend("success",
				"Complete ur info as soon as possiable"));
	}

	/**
	 * do validtate sms
	 * 
	 * @author aries
	 * @return
	 */
	public static Result doValidateSMS() {
		return validateSMS("do");

	}

	/**
	 * redo validate sms
	 * 
	 * @author aries
	 * @return
	 */
	public static Result redoValidateSMS() {
		return validateSMS("redo");
	}

	/**
	 * password tools
	 * 
	 * @author aries
	 * @return
	 */
	public static Result psw(String method) {

		// Validate user in database
		User user = findByPhone(session().get("phone"));
		// if user is null
		if (user == null)
			return ok(DataFormatUtil.toJsend("fail",
					"u need to validate ur phone first!"));
		if ("create".equals(method.trim())) {
			if (user.getSignup())
				return ok(DataFormatUtil.toJsend("fail",
						"u have already signed up!"));
			if (!user.getValidated())
				return ok(DataFormatUtil.toJsend("fail",
						"Validate ur phone first! create."));
			try {
				if (user.getPassword() != null
						&& !"".equals(user.getPassword()))
					return ok(DataFormatUtil.toJsend("fail",
							"u already have psw"));
			} catch (Exception e) {
				return ok(DataFormatUtil.toJsend("fail",
						"sb. who has psw wanted to creat psw again"));
			}
		} else if ("recreate".equals(method.trim())) {
			try {
				if (user.getPassword() == null && "".equals(user.getPassword()))
					return ok(DataFormatUtil
							.toJsend("fail", "u don't have psw"));
			} catch (Exception e) {
				return ok(DataFormatUtil.toJsend("fail",
						"sb. who has not psw wanted to recreat psw"));
			}
			if (!user.getReValidated())
				return ok(DataFormatUtil.toJsend("fail",
						"Validate ur phone first! recreate."));
		}

		// Validate the post parameter
		Form<User> postParameter = form(User.class).bindFromRequest();

		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "in parameter"));
		if (SecurityUtil.isBlank(postParameter.get().getPassword()))
			return ok(DataFormatUtil.toJsend("fail", "Wrong password"));
		if (postParameter.get().getPassword().trim().length() < 6
				|| postParameter.get().getPassword().trim().length() > 16)
			return ok(DataFormatUtil.toJsend("fail",
					"password should b 6 - 16 letters"));

		try {
			user.setPassword(SecurityUtil.createPassword(postParameter.get()
					.getPassword()));
			session("id", user.getId() + "");
			session("expire", SecurityUtil.getExpire(60 * 24 * 7));
			user.setReValidated(false);
			userCollectionJackson.update(
					DBQuery.is("phone", session().get("phone")), user);

			return ok(DataFormatUtil.toJsend("success", "..."));
		} catch (Exception e) {
			return ok(DataFormatUtil.toJsend("fail", "Server error"));
		}
	}

	/**
	 * Create password
	 * 
	 * @author aries
	 * @return
	 */
	public static Result createPsw() {
		return psw("create");
	}

	/**
	 * Change password
	 * 
	 * @author aries
	 * @return
	 */
	public static Result recreatePsw() {
		return psw("recreate");
	}

	/**
	 * Create Profile
	 * 
	 * @author aries
	 * @return status
	 */

	public static Result createProfile() {

		// Validate user in database
		User user = findByPhone(session().get("phone"));
		// if user is null
		if (user == null)
			return ok(DataFormatUtil.toJsend("fail",
					"u need to validate ur phone first!"));
		if (!user.getValidated())
			return ok(DataFormatUtil
					.toJsend("fail", "Validate ur phone first!"));
		if (user.getSignup())
			return ok(DataFormatUtil.toJsend("fail",
					"u have already signed up!"));
		if (user.getPassword() == null)
			return ok(DataFormatUtil.toJsend("fail", "Create password first!"));
		// Validate the post parameter
		Form<User> postParameter = form(User.class).bindFromRequest();
		if (postParameter.get().getName() == null
				|| "".equals(postParameter.get().getName().trim()))
			return ok(DataFormatUtil.toJsend("fail", "name is necessary!"));

		try {
			if (postParameter.get().getBirthday() != null
					&& !"".equals(postParameter.get().getBirthday())) {
				user.setAge(Calendar.getInstance().get(Calendar.YEAR)
						- Integer.parseInt(postParameter.get().getBirthday()
								.substring(0, 4)) + "");
				user.setBirthday(postParameter.get().getBirthday());
			} else
				user.setAge(Calendar.getInstance().get(Calendar.YEAR) - 1970
						+ "");
			// we add the user in the database
			// postParameter.get().setCreateTime(DataFormatUtil.getNow());

			user.setName(postParameter.get().getName());
			user.setValidated(true);
			user.setSignup(true);

			userCollectionJackson.update(
					DBQuery.is("phone", session().get("phone")), user);
			return ok(DataFormatUtil.toJsend("success", "..."));
		} catch (Exception e) {
			return ok(DataFormatUtil.toJsend("fail",
					"ask me to chack birthday."));
		}
	}

	/**
	 * 
	 * Find a star
	 * 
	 * @author Aries
	 * @return a star
	 */
	// TODO:Just find a guy.
	public static Result getStarOfTheDay() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		try {
			return ok(DataFormatUtil.toJsend("success", userCollectionJackson
					.find().sort(new BasicDBObject("star", -1)).limit(1).next()
					.toJson()));
		} catch (Exception e) {
			return ok(DataFormatUtil.toJsend("fail",
					"There's no data in db or Server exception."));
		}
		// DBCursor<DProduct> productList =
		// Product.productCollectionJackson.find(new DBQuery().is("userID",
		// session().get("id")));
		// int sum = 0;
		// while(productList.hasNext()){
		// sum += productList.next().getLike();
		// }
		// return TODO;
	}

	/**
	 * Delete user from friend list
	 * 
	 * @author Aries
	 * @return
	 */

	public static Result deleteUserFromFriendList() {

		// if user is login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		Form<User> postParameter = form(User.class).bindFromRequest();
		String friendID = postParameter.get().getFriend();
		// if friendID is ID
		if (!ObjectId.isValid(friendID))
			return ok(DataFormatUtil.toJsend("fail", "wrong ID"));
		User friendUser = userCollectionJackson.findOneById(friendID);
		if (friendUser == null)
			return ok(DataFormatUtil.toJsend("fail", "Wrong ID"));

		String currentUserID = session().get("id");
		User currentUser = userCollectionJackson.findOneById(currentUserID);
		if (!currentUser.getFriends().containsKey(friendID))
			return ok(DataFormatUtil.toJsend("fail",
					"his is not in ur friend list!"));
		currentUser.getFriends().remove(friendID);
		friendUser.getFriends().remove(currentUserID);
		userCollectionJackson.updateById(friendID, friendUser);
		userCollectionJackson.updateById(currentUserID, currentUser);
		return ok(DataFormatUtil.toJsend("success", "..."));
	}

	/**
	 * Delete user from black list
	 * 
	 * @author Aries
	 * @return
	 */

	public static Result deleteUserFromBlackList() {

		// if user is login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		Form<User> postParameter = form(User.class).bindFromRequest();
		String aversion = postParameter.get().getAversion();
		if (!ObjectId.isValid(aversion))
			return ok(DataFormatUtil.toJsend("fail", "wrong ID"));
		User aversionUser = userCollectionJackson.findOneById(aversion);
		if (aversionUser == null)
			return ok(DataFormatUtil.toJsend("fail", "Wrong ID"));

		String currentUserID = session().get("id");
		User currentUser = userCollectionJackson.findOneById(currentUserID);
		if (!currentUser.getBlackList().contains(aversion))
			return ok(DataFormatUtil.toJsend("fail",
					"hs is not in ur black list!"));
		currentUser.getBlackList().remove(aversion);
		userCollectionJackson.updateById(currentUserID, currentUser);
		return ok(DataFormatUtil.toJsend("success", "..."));
	}

	/**
	 * Add a user to blacklist
	 * 
	 * @author Aries
	 * @return
	 */

	public static Result add2BlackList() {

		// if user is login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		Form<User> postParameter = form(User.class).bindFromRequest();
		String aversion = postParameter.get().getAversion();
		if (!ObjectId.isValid(aversion))
			return ok(DataFormatUtil.toJsend("fail", "wrong ID"));
		User aversionUser = userCollectionJackson.findOneById(aversion);
		if (aversionUser == null)
			return ok(DataFormatUtil.toJsend("fail", "Wrong ID"));

		String currentUserID = session().get("id");
		User currentUser = userCollectionJackson.findOneById(currentUserID);
		if (currentUser.getBlackList().contains(aversion))
			return ok(DataFormatUtil
					.toJsend("faile",
							"he have been in ur black list already,why u hate him so much?"));
		currentUser.getBlackList().add(aversion);
		currentUser.getFriends().remove(aversion);
		aversionUser.getFriends().remove(aversion);
		userCollectionJackson.updateById(currentUserID, currentUser);
		userCollectionJackson.updateById(aversion, aversionUser);
		return ok(DataFormatUtil.toJsend("success", "..."));
	}

	/**
	 * Get my blackList
	 * 
	 * @author Aries
	 * @return black-list
	 */

	public static Result getBlackList() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		User currentUser = userCollectionJackson.findOneById(session()
				.get("id"));
		return ok(DataFormatUtil.toJsend("success", currentUser.getBlackList()
				.toString()));
	}

	/**
	 * Find a user by userID
	 * 
	 * @author Aries
	 * @return User Information
	 */

	public static Result findUserByID() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		Form<User> postParameter = form(User.class).bindFromRequest();
		User request = postParameter.get();

		if (ObjectId.isValid(request.getId())) {
			User result = userCollectionJackson.findOneById(request.getId());
			if (result != null)
				return ok(DataFormatUtil.toJsend("success", "userInfo",
						result.toJson()));
			else
				return ok(DataFormatUtil.toJsend("fail", request.getId()
						+ " is not exist!"));
		} else
			return ok(DataFormatUtil.toJsend("fail", "Wrong ID"));
	}

	/**
	 * Find friend of users
	 * 
	 * @author Aries
	 * @return FriendID-List
	 */

	public static Result findFriends() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		Form<User> postParameter = form(User.class).bindFromRequest();
		User request = postParameter.get();

		if (request != null) {
			ArrayNode result = getFriends(request.getId(), "true");
			return ok(DataFormatUtil.toJsend("success", "Friend-List", result));
		} else
			return ok(DataFormatUtil.toJsend("fail", "Bad request"));
	}

	/**
	 * Reply friend unaudited
	 * 
	 * @return
	 */
	public static Result findFriendsUnaudited() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		ArrayNode result = getFriends(session().get("id"), "false");
		return ok(DataFormatUtil.toJsend("success", "friendUnaudited-List",
				result));
	}

	/**
	 * Reply friend request
	 * 
	 * @author Aries
	 * @return status
	 */
	public static Result replyFriendRequest() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		Form<User> postParameter = form(User.class).bindFromRequest();
		String friendID = postParameter.get().getFriend();
		if (!ObjectId.isValid(friendID))
			return ok(DataFormatUtil.toJsend("faile", "Wrong ID"));
		ArrayNode result = getFriends(session().get("id"), "true");
		if (result.toString().contains(friendID))
			return ok(DataFormatUtil.toJsend("fail", friendID
					+ " is ur friend already!"));
		result = getFriends(session().get("id"), "false");
		if (!result.toString().contains(friendID))
			return ok(DataFormatUtil.toJsend("fail", friendID
					+ " didn't send a request"));

		User friend = userCollectionJackson.findOneById(friendID);
		Map<String, String> friends = friend.getFriends();
		friends.put(session().get("id"), "true");
		friend.setFriends(friends);
		userCollectionJackson.updateById(friendID, friend);

		User currentUser = userCollectionJackson.findOneById(session()
				.get("id"));
		Map<String, String> currentUserFriends = currentUser.getFriends();
		currentUserFriends.put(friendID, "true");
		currentUser.setFriends(currentUserFriends);
		userCollectionJackson.updateById(session().get("id"), currentUser);
		return ok(DataFormatUtil.toJsend("success", "..."));
	}

	/**
	 * Get friends ,apply or not
	 * 
	 * @author Aries
	 * @param flag
	 * @return
	 */

	public static ArrayNode getFriends(String userID, String flag) {

		if(!ObjectId.isValid(userID))
			return Json.newObject().arrayNode();
		User friendUser = userCollectionJackson.findOneById(userID);
		Map<String, String> friends = friendUser.getFriends();
		Set<String> keys = friends.keySet();
		ArrayNode result = Json.newObject().arrayNode();
		for (String key : keys)
			if (friends.get(key).equals(flag))
				result.add(userCollectionJackson.findOneById(key).toJson());
		return result;
	}

	/**
	 * Add a friend by userID Just 4 test,maybe list is more faster by this
	 * way,because it won't to look up DB too much.
	 * 
	 * @author Aries
	 * @return FriendID
	 */
	public static Result addFriend() {

		// if user is login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		Form<User> postParameter = form(User.class).bindFromRequest();
		String friendID = postParameter.get().getFriend();
		if (!ObjectId.isValid(friendID))
			return ok(DataFormatUtil.toJsend("fail", "wrong ID"));
		User friendUser = userCollectionJackson.findOneById(friendID);
		if (friendUser == null)
			return ok(DataFormatUtil.toJsend("fail", "Ur friend is not exist!"));

		UsersAuthorityUtil.inBlockListAction(friendID);

		String currentUserID = session().get("id");
		User currentUser = userCollectionJackson.findOneById(currentUserID);
		Map<String, String> currentFriends = currentUser.getFriends();
		if (currentFriends.containsKey(friendID))
			return ok(DataFormatUtil.toJsend("fail",
					"He is ur friend/or u have send a request already!"));
		currentUser.getFriends().put(friendID, "");
		friendUser.getFriends().put(currentUserID, "false");
		userCollectionJackson.updateById(currentUserID, currentUser);
		userCollectionJackson.updateById(friendID, friendUser);
		return ok(DataFormatUtil.toJsend("success", ""));
	}

	/**
	 * find list of user by keywords. 4 test
	 * 
	 * @author Aries
	 * @param page
	 * @param nbObjectByPage
	 * @param phone
	 * @return
	 */
	public static Result find(int page, int nbObjectByPage, String phone) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		Form<Login> loginForm = form(Login.class).bindFromRequest();
		if (loginForm.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "in parameter"));
		DBCursor<User> result = userCollectionJackson.find(DBQuery.regex(
				"phone", Pattern.compile("." + phone + ".")));

		// Another limit: check all recorders .skip(page)
		// .limit(nbObjectByPage);

		int pageNumberTemp = nbObjectByPage;
		ArrayNode dataOfArray = Json.newObject().arrayNode();
		while (result.hasNext() && pageNumberTemp-- >= page) {
			dataOfArray.add(result.next().toJson());
		}
		return ok(DataFormatUtil.toJsend("success", "Users", dataOfArray,
				"pageMax", nbObjectByPage));
	}

	/**
	 * reset current user's info
	 * 
	 * @author Aries
	 * @return
	 */
	public static Result update() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		String userID = session().get("id");
		Form<User> postParameter = form(User.class).bindFromRequest();
		User request = postParameter.get();

		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "in parameter"));
		User user = userCollectionJackson.findOneById(userID);

		// If the request parameter is not null,don't update
		if (request.getName() != null)
			if (!request.getName().trim().equals(""))
				user.setName(request.getName());
		if (request.getProfilePictureID() != null)
			if (!request.getProfilePictureID().trim().equals(""))
				user.setProfilePictureID(request.getProfilePictureID());
		if (request.getCoverPictureID() != null)
			if (!request.getCoverPictureID().trim().equals(""))
				user.setCoverPictureID(request.getCoverPictureID());
		if (request.getStatus() != null)
			if (!request.getStatus().trim().equals(""))
				user.setStatus(request.getStatus());
		if (request.getGender() != null)
			if (!request.getGender().trim().equals(""))
				user.setGender(request.getGender());
		if (request.getAge() != null)
			if (!request.getAge().trim().equals(""))
				user.setAge(request.getAge());
		userCollectionJackson.updateById(userID, user);
		return ok(DataFormatUtil.toJsend("success", ".."));
	}

	/**
	 * Retrieve one User from phone.
	 * 
	 * @author Aries
	 * @param phone
	 * @return
	 */
	public static User findByPhone(String phone) {

		DBCursor<User> result = userCollectionJackson.find(DBQuery.is("phone",
				phone));
		if (result.hasNext()) {
			return result.next();
		} else {
			return null;
		}
	}

	/**
	 * Authenticate a User.
	 * 
	 * @author Ari
	 * @param phone
	 * @param password
	 * @return
	 */
	public static User authenticate(String phone, String password) {

		User user = findByPhone(phone);
		if (user != null)
			if (SecurityUtil.checkPassword(password, user.getPassword()))
				return user;
		return null;
	}

	/**
	 * 
	 * @author ari
	 * @param password
	 */
	public void changePassword(String password) {

		String userID = session().get("id");
		User user = userCollectionJackson.findOneById(userID);
		user.setPassword(SecurityUtil.createPassword(password));
		userCollectionJackson.updateById(user.getId(), user);
	}

	/**
	 * if a User exist.
	 * 
	 * @author Aries
	 * @param phone
	 * @return
	 */
	public static boolean exist(String phone) {
		DBCursor<User> result = userCollectionJackson.find(DBQuery.is("phone",
				phone));
		if (!result.hasNext())
			return false;
		User r = result.next();
		return r.getValidated();
	}

	/**
	 * a tool 2 getting profilePictureID
	 * 
	 * @author Aries
	 * @param userID
	 * @return
	 */
	public static String getProfilePictureID(String userID) {
		User user = userCollectionJackson.findOneById(userID);
		if (user != null)
			return user.getProfilePictureID();
		else
			return null;
	}

	/**
	 * Follow user
	 * 
	 * @author Aries/pottier
	 * @param userID
	 * 
	 * @return
	 */
	public static Result follow() {

		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		Form<User> postParameter = form(User.class).bindFromRequest();
		User postUser = postParameter.get();
		if (postUser == null || postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		String postId = postUser.getId(); // variable representing the user I
		// want to follow

		User dbPostUser = null;
		boolean flag = false;

		if (ObjectId.isValid(postId)){
			dbPostUser = userCollectionJackson.findOneById(postId);
		    BasicDBObject whereQuery = new BasicDBObject();
		    whereQuery.put("userID", session().get("id"));
		    DBCursor<Post> cursor= postCollectionJackson.find(whereQuery);
		}
		if (dbPostUser == null)
			return ok(DataFormatUtil.toJsend("fail", "user is not exist"));
		User dbMe = userCollectionJackson.findOneById(session().get("id"));

		// remove the id of the user in the list of user who follow the user
		// within shop object

		Set<String> followUserIDSet = dbPostUser.getFollowUserIDSet();
		flag = followUserIDSet.add(session().get("id"));
		dbPostUser.setNumberOfFollower(dbPostUser.getNumberOfFollower() + 1);
		dbPostUser.setFollowUserIDSet(followUserIDSet);
		userCollectionJackson.updateById(postId, dbPostUser);
		// remove the id of the shop in the list of user followed by the user
		// within the user object

		Set<String> bFollowedUserIDSet = dbMe.getbFollowedUserIDSet();
		flag = bFollowedUserIDSet.add(postId);
		dbMe.setbFollowedUserIDSet(bFollowedUserIDSet);
		userCollectionJackson.updateById(session().get("id"), dbMe);

		if (flag)
			return ok(DataFormatUtil.toJsend("success", "..."));
		return ok(DataFormatUtil.toJsend("fail", "u already follow this user"));
	}

	/**
	 * Unfollow user
	 * 
	 * @author Pottier
	 * @param userID
	 * @return
	 */
	public static Result unfollow() {

		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		Form<User> postParameter = form(User.class).bindFromRequest();
		User postUser = postParameter.get();
		if (postUser == null || postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		String postId = postUser.getId(); // variable representing the user I
		// want to follow

		User dbPostUser = null;
		boolean flag = false;

		if (ObjectId.isValid(postId))
			dbPostUser = userCollectionJackson.findOneById(postId);
		if (dbPostUser == null)
			return ok(DataFormatUtil.toJsend("fail", "shop is not exist"));
		User dbMe = UserController.userCollectionJackson.findOneById(session()
				.get("id"));

		// remove the id of the user in the list of user who follow the user
		// within shop object
		Set<String> followUserIDSet = dbPostUser.getFollowUserIDSet();
		flag = followUserIDSet.remove(session().get("id"));
		dbPostUser.setNumberOfFollower(dbPostUser.getNumberOfFollower() - 1);
		dbPostUser.setFollowUserIDSet(followUserIDSet);
		userCollectionJackson.updateById(postId, dbPostUser);

		// remove the id of the shop in the list of user followed by the user
		// within the user object

		Set<String> userIFollow = dbMe.getbFollowedUserIDSet();
		flag = userIFollow.remove(postId);
		dbMe.setbFollowedUserIDSet(userIFollow);
		UserController.userCollectionJackson.updateById(session().get("id"),
				dbMe);

		if (flag)
			return ok(DataFormatUtil.toJsend("success", "..."));
		return ok(DataFormatUtil.toJsend("fail",
				"you are not following this user"));
	}

	/**
	 * Get all i followed(Only follow the user)
	 * 
	 * @author sandy
	 * @param
	 * @return
	 */
	public static Result whoIFollowed(String userid) {

		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		User dbUser = null;
		if (ObjectId.isValid(userid))
			dbUser = userCollectionJackson.findOneById(userid);
		if (dbUser == null)
			return ok(DataFormatUtil.toJsend("fail", "Wrong user id"));

		Set<String> list = dbUser.getbFollowedUserIDSet();
		ArrayNode result = Json.newObject().arrayNode();
		for (String id : list)
			result.add(userCollectionJackson.findOneById(id).toJson());
		return ok(DataFormatUtil.toJsend("success", "user", result));
	}

	/**
	 * Get all shop i followed(Only follow the user)
	 * 
	 * @author sandy
	 * @param
	 * @return
	 */
	public static Result whoShopIFollowed(String userid) {

		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		User dbUser = null;
		if (ObjectId.isValid(userid))
			dbUser = userCollectionJackson.findOneById(userid);
		if (dbUser == null)
			return ok(DataFormatUtil.toJsend("fail", "Wrong user id"));

		if (dbUser.getShopsIFollow() == null)
			return ok(DataFormatUtil.toJsend("success", "shop", ""));

		Set<String> list = dbUser.getShopsIFollow();
		ArrayNode result = Json.newObject().arrayNode();
		for (String id : list) {
			Shop shop = null;
			if (ObjectId.isValid(id))
				shop = ShopController.shopCollectionJackson.findOneById(id);
			if (shop != null) {
				ObjectNode s = ShopController.shopCollectionJackson
						.findOneById(id).toJson();
				result.add(s);
			}
		}
		return ok(DataFormatUtil.toJsend("success", "shop", result));
	}

	/**
	 * Get all that who follow me(Only follow the user)
	 * 
	 * @author Aries
	 * @param
	 * @return
	 */
	public static Result whoFollowMe(String userid) {

		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		User dbUser = null;
		if (ObjectId.isValid(userid))
			dbUser = userCollectionJackson.findOneById(userid);
		if (dbUser == null)
			return ok(DataFormatUtil.toJsend("fail", "Wrong user id"));

		Set<String> list = dbUser.getFollowUserIDSet();
		ArrayNode result = Json.newObject().arrayNode();
		for (String id : list)
			result.add(userCollectionJackson.findOneById(id).toJson());
		return ok(DataFormatUtil.toJsend("success", "user", result));
	}

	/**
	 * ???
	 * 
	 * @author bill
	 * @param
	 * @return
	 */
	public static Result findByUsername(String username) {

		return TODO;
	}

	/**
	 * Compute my level
	 * 
	 * @author Pottier
	 * @param
	 * @return
	 */
	public static Result myUserLevel() {
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));
		int myLevel = 0;
		User dbUser = userCollectionJackson.findOneById(session().get("id"));
		int numberOfPostCreated = dbUser.getNumberOfPostCreated();
		int numberOfLike = dbUser.getNumberOfLike();
		int numberOfFollower = dbUser.getNumberOfFollower();
		int numberOfShare = dbUser.getNumberOfShare();

		if (numberOfPostCreated >= User.getDivaPostUser()
				&& numberOfLike >= User.getDivaLikeUser()
				&& numberOfFollower >= User.getDivaFollowerUser()
				&& numberOfShare >= User.getDivaSharesUser())
			myLevel = 9;
		else if (numberOfPostCreated >= User.getGlitteratiPostUser()
				&& numberOfLike >= User.getGlitteratiLikeUser()
				&& numberOfFollower >= User.getGlitteratiFollowerUser()
				&& numberOfShare >= User.getGlitteratiSharesUser())
			myLevel = 8;
		else if (numberOfPostCreated >= User.getDesignerPostUser()
				&& numberOfLike >= User.getDesignerLikeUser()
				&& numberOfFollower >= User.getDesignerFollowerUser()
				&& numberOfShare >= User.getDesignerSharesUser())
			myLevel = 7;
		else if (numberOfPostCreated >= User.getTrendsetterPostUser()
				&& numberOfLike >= User.getTrendsetterLikeUser()
				&& numberOfFollower >= User.getTrendsetterFollowerUser()
				&& numberOfShare >= User.getTrendsetterSharesUser())
			myLevel = 6;
		else if (numberOfPostCreated > User.getStylistPostUser()
				&& numberOfLike > User.getStylistLikeUser()
				&& numberOfFollower > User.getStylistFollowerUser()
				&& numberOfShare > User.getStylistSharesUser())
			myLevel = 5;
		else if (numberOfPostCreated > User.getWowzerPostUser()
				&& numberOfLike > User.getWowzerLikeUser()
				&& numberOfFollower > User.getWowzerFollowerUser()
				&& numberOfShare > User.getWowzerSharesUser())
			myLevel = 4;
		else if (numberOfPostCreated >= User.getModelPostUser()
				&& numberOfLike >= User.getModelLikeUser()
				&& numberOfFollower >= User.getModelFollowerUser()
				&& numberOfShare >= User.getModelSharesUser())
			myLevel = 3;
		else if (numberOfPostCreated >= User.getChicPostUser()
				&& numberOfLike >= User.getChicLikeUser()
				&& numberOfFollower >= User.getChicFollowerUser()
				&& numberOfShare >= User.getChicSharesUser())
			myLevel = 2;
		else if (numberOfPostCreated >= User.getFashionbloggerPostUser()
				&& numberOfLike >= User.getFashionbloggerLikeUser()
				&& numberOfFollower >= User.getFashionbloggerFollowerUser()
				&& numberOfShare >= User.getFashionbloggerSharesUser())
			myLevel = 1;

		return ok(DataFormatUtil.toJsend("success", "" + myLevel));
	}

	public static Result myInformations() {
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));
		User dbUser = userCollectionJackson.findOneById(session().get("id"));
		if (dbUser == null)
			return ok(DataFormatUtil.toJsend("fail", "Wrong user id"));
		String res = "the number of like is  " + dbUser.getNumberOfLike()
				+ "the number of follower is  " + dbUser.getNumberOfFollower()
				+ "the number of post is  " + dbUser.getNumberOfPostCreated()
				+ " the post id are: ";
		BasicDBObject whereQuery = new BasicDBObject();
		whereQuery.put("userID", session().get("id"));
		DBCursor<Post> cursor = postCollectionJackson.find(whereQuery);
		res += cursor.toString();

		return ok(DataFormatUtil.toJsend("success", res));

	}

}
