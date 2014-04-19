package com.pencho.pai.controllers;

import static play.data.Form.form;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.mongojack.DBCursor;
import org.mongojack.DBQuery;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utils.DataFormatUtil;
import utils.SecurityUtil;
import utils.UsersAuthorityUtil;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.pencho.pai.dao.DAO;
import com.pencho.pai.models.Shop;
import com.pencho.pai.models.User;

public class ShopController extends Controller {
	public static final DBCollection shopCollection = DAO.database
			.getCollection("shop");
	public static final JacksonDBCollection<Shop, String> shopCollectionJackson = JacksonDBCollection
			.wrap(shopCollection, Shop.class, String.class);

	/**
	 * Create and update shop
	 * 
	 * @author aries
	 * @param pic1
	 * @param pic2
	 * @param video1
	 * @param video2
	 * @param video3
	 * @param video4
	 * @param video5
	 * @param video6
	 * @return
	 */
	public static Result set(String pic1, String pic2, String video1,
			String video2, String video3, String video4, String video5,
			String video6) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));
		User dbUser = null;

		// if u signed up
		dbUser = UserController.userCollectionJackson.findOneById(session()
				.get("id"));
		if (dbUser == null || !dbUser.getSignup())
			return ok(DataFormatUtil.toJsend("fail", "Sign up first"));

		Form<Shop> postParameter = form(Shop.class).bindFromRequest();
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "Wrong parameter"));

		Shop postShop = postParameter.get();

		if (postShop.getLatitude() > 180 || postShop.getLatitude() < -180
				|| postShop.getLongitude() > 180
				|| postShop.getLongitude() < -180)
			return ok(DataFormatUtil.toJsend("fail",
					"longitude and latitude need to be  min -180 max 180 "));
		Shop dbShop = shopCollectionJackson.findOne(DBQuery.is("userID",
				session().get("id")));

		WriteResult<Shop, String> result = null;
		// if user don't have shop,create.

		// TODO:setLoc

		if (dbShop == null || !dbShop.isExist()) {
			if (dbShop != null && !dbShop.isExist())
				shopCollectionJackson.removeById(dbShop.getId());
			dbShop = new Shop();
			dbShop.setCategories(postShop.getCategories());
			dbShop.setCreateTime(DataFormatUtil.getNow());
			dbShop.setLocation(postShop.getLocation());
			dbShop.setName(postShop.getName());
			dbShop.setDescription(postShop.getDescription());

			dbShop.setUserID(session().get("id"));
			User duser = UserController.userCollectionJackson.findOneById(session()
					.get("id"));
			dbShop.setPhone(duser.getPhone());
			ArrayList<String> picIDList = new ArrayList<String>();
			picIDList.add(pic1);
			picIDList.add(pic2);
			dbShop.setPictureIDList(picIDList);
			ArrayList<String> videoIDList = new ArrayList<String>();
			videoIDList.add(video1);
			videoIDList.add(video2);
			videoIDList.add(video3);
			videoIDList.add(video4);
			videoIDList.add(video5);
			videoIDList.add(video6);
			dbShop.setVideoIDList(videoIDList);
			dbShop.setExist(true);
			Set<String> tags = new HashSet<String>();
			tags.add(postShop.getTag());
			dbShop.setTags(tags);
			dbShop.setLoc(new double[] { postShop.getLongitude(),
					postShop.getLatitude() });
			result = shopCollectionJackson.insert(dbShop);
			// save shop id in user
			dbUser.setShopID(result.getSavedId());

			UserController.userCollectionJackson.updateById(
					session().get("id"), dbUser);
			// .update( DBQuery.is("phone", session().get("phone")),
			// dbUser.setShopID);
			return ok(DataFormatUtil.toJsend("success",
					"Create: " + result.getSavedId()));
		} else {
			postShop.setUserID(session().get("id"));
			List<String> picIDList = postShop.getPictureIDList();

			if (!"".equals(pic1))
				picIDList.set(0, pic1);
			if (!"".equals(pic2))
				picIDList.set(1, pic2);
			postShop.setPictureIDList(picIDList);

			Set<String> tags = postShop.getTags();
			if (!"".equals(postShop.getTag()))
				tags.add(postShop.getTag());
			postShop.setTags(tags);

			List<String> videoIDList = postShop.getVideoIDList();
			if (!"".equals(video1))
				videoIDList.add(video1);
			if (!"".equals(video2))
				videoIDList.add(video2);
			if (!"".equals(video3))
				videoIDList.add(video3);
			if (!"".equals(video4))
				videoIDList.add(video4);
			if (!"".equals(video5))
				videoIDList.add(video5);
			if (!"".equals(video6))
				videoIDList.add(video6);
			postShop.setVideoIDList(videoIDList);

			postShop.setExist(true);

			postShop.setLoc(new double[] { postShop.getLongitude(),
					postShop.getLatitude() });

			result = shopCollectionJackson.updateById(dbShop.getId(), postShop);
			return ok(DataFormatUtil.toJsend("success", "update successfully"));
		}
	}

	/**
	 * like this shop or not
	 * 
	 * @author Aries/pottier
	 * @return
	 */
	public static Result like() {
		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<Shop> postParameter = Form.form(Shop.class).bindFromRequest();
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "Wrong parameter"));
		String shopID = postParameter.get().getId();
		if (!ObjectId.isValid(shopID))
			return ok(DataFormatUtil.toJsend("fail", "wrong shop id"));
		Shop dbShop = shopCollectionJackson.findOneById(shopID);
		if (dbShop == null)
			return ok(DataFormatUtil.toJsend("fail", "this shop is not exist"));

		UsersAuthorityUtil.inBlockListAction(dbShop.getUserID());

		User dbUser = UserController.userCollectionJackson.findOneById(dbShop
				.getUserID());
		Set<String> shopsILike = dbUser.getShopsILike();
		if(dbShop.getPeopleWhoLike().add(session().get("id"))){
			dbShop.setLike(dbShop.getLike() + 1);
			dbShop.setNumberOfLike(dbShop.getNumberOfLike() + 1);
			dbUser.setStar(dbUser.getStar() + 1);
			shopsILike.add(shopID);
			dbUser.setShopsILike(shopsILike);
		} else {
			dbShop.getPeopleWhoLike().remove(session().get("id"));
			dbShop.setLike(dbShop.getLike() - 1);
			dbShop.setNumberOfLike(dbShop.getNumberOfLike() - 1);

			dbUser.setStar(dbUser.getStar() - 1);
			shopsILike.remove(shopID);
			dbUser.setShopsILike(shopsILike);
		}
		UserController.userCollectionJackson.updateById(dbShop.getUserID(),
				dbUser);
		shopCollectionJackson.updateById(shopID, dbShop);

		return ok(DataFormatUtil.toJsend("success", dbShop.getLike() + ""));
	}

	/**
	 * share
	 * 
	 * @author Aries
	 * @return
	 */
	public static Result share() {
		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<Shop> postParameter = Form.form(Shop.class).bindFromRequest();
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "Wrong parameter"));
		String shopID = postParameter.get().getId();
		if (!ObjectId.isValid(shopID))
			return ok(DataFormatUtil.toJsend("fail", "wrong shop id"));
		Shop dbShop = shopCollectionJackson.findOneById(shopID);
		if (dbShop == null)
			return ok(DataFormatUtil.toJsend("fail", "this shop is not exist"));

		UsersAuthorityUtil.inBlockListAction(dbShop.getUserID());

		User dbUser = UserController.userCollectionJackson.findOneById(dbShop
				.getUserID());
		Set<String> shopsIShared = dbUser.getShopsIShared();
		dbShop.setLike(dbShop.getShare() + 1);
		dbShop.setNumberOfShare(dbShop.getNumberOfShare() + 1);
		dbUser.setStar(dbUser.getStar() + 1);
		shopsIShared.add(shopID);
		dbUser.setShopsIShared(shopsIShared);

		UserController.userCollectionJackson.updateById(dbShop.getUserID(),
				dbUser);
		shopCollectionJackson.updateById(shopID, dbShop);

		return ok(DataFormatUtil.toJsend("success", ""));
	}

	/**
	 * get my shop
	 * 
	 * @author aries
	 * @return
	 */
	public static Result getMine() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		Shop dbShop = shopCollectionJackson.findOne(DBQuery.is("userID",
				session().get("id")));
		if (dbShop == null) {
			return ok(DataFormatUtil.toJsend("fail", "u don't have shop"));
		}
		if (!dbShop.isExist())
			return ok(DataFormatUtil.toJsend("fail",
					"u delete shop,remember that?"));
		return ok(DataFormatUtil.toJsend("success", "shopInfo:",
				dbShop.toJson()));
	}

	/**
	 * get my shop
	 * 
	 * @author aries
	 * @return
	 */
	public static Result getShopById() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		Form<Shop> postParameter = Form.form(Shop.class).bindFromRequest();
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "Wrong parameter"));
		String shopID = postParameter.get().getId();
		if (!ObjectId.isValid(shopID))
			return ok(DataFormatUtil.toJsend("fail", "wrong shop id"));
		Shop dbShop = shopCollectionJackson.findOneById(shopID);
		if (dbShop == null)
			return ok(DataFormatUtil.toJsend("fail", "this shop is not exist"));

		if (!dbShop.isExist())
			return ok(DataFormatUtil.toJsend("fail", "Ower delete shop."));

		UsersAuthorityUtil.inBlockListAction(dbShop.getUserID());

		return ok(DataFormatUtil.toJsend("success", "shopInfo:",
				dbShop.toJson()));
	}

	/**
	 * drop shop(still exist)
	 * 
	 * @author aries
	 * @return
	 */
	public static Result drop() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		Shop dbShop = shopCollectionJackson.findOne(DBQuery.is("userID",
				session().get("id")));

		if (dbShop == null) {
			return ok(DataFormatUtil.toJsend("fail", "u don't have shop"));
		}
		if (!dbShop.isExist())
			return ok(DataFormatUtil.toJsend("fail",
					"u delete shop,remember that?"));
		dbShop.setExist(false);
		shopCollectionJackson.updateById(dbShop.getId(), dbShop);
		return ok(DataFormatUtil.toJsend("success", ""));
	}

	/**
	 * revert shop(restore shop) (may be won't use it)
	 * 
	 * @author aries
	 * @return
	 */
	public static Result revert() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		Shop dbShop = shopCollectionJackson.findOne(DBQuery.is("userID",
				session().get("id")));
		if (dbShop == null) {
			return ok(DataFormatUtil.toJsend("fail", "u don't have shop"));
		}
		if (dbShop.isExist())
			return ok(DataFormatUtil.toJsend("fail",
					"u have already been a shop keeper"));
		dbShop.setExist(true);
		shopCollectionJackson.updateById(dbShop.getId(), dbShop);
		return ok(DataFormatUtil
				.toJsend("success", "shopInfo", dbShop.toJson()));
	}

	// TODO:Delete shop completely
	/**
	 * Get moment around user by radius
	 * 
	 * @author Pottier
	 * @param radius
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	public static Result getShopAround(double radius, double latitude,
			double longitude) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		shopCollectionJackson.ensureIndex(new BasicDBObject("loc", "2d"),
				"geospacialIdx");
		LinkedList<Object> circle = new LinkedList<Object>();
		circle.addLast(new double[] { latitude, longitude });
		circle.addLast(radius / 111.12);
		ArrayNode temp = new ArrayNode(null);
		BasicDBObject query = new BasicDBObject("loc", new BasicDBObject(
				"$within", new BasicDBObject("$center", circle)));
		DBCursor<Shop> venue = shopCollectionJackson.find(query);
		while (venue.hasNext()) {
			temp.add(venue.next().toJson());
		}
		return ok(DataFormatUtil.toJsend("success", "shop-list", temp));
	}

	/**
	 * Compute my level
	 * 
	 * @author Pottier
	 * @param
	 * @return
	 */
	public static Result myShopLevel() {
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));
		int myLevel = 0;
		Shop dbShop = shopCollectionJackson.findOne(DBQuery.is("userID",
				session().get("id")));
		if(null == dbShop) return ok(DataFormatUtil.toJsend("fail", "no shop found"));
		int numberOfLike = dbShop.getNumberOfLike();
		int numberOfFollower = dbShop.getNumberOfFollower();
		int numberOfShare = dbShop.getNumberOfShare();

		if (numberOfLike > Shop.getDivaLikeShop()
				&& numberOfFollower > Shop.getDivaFollowerShop()
				&& numberOfShare > Shop.getDivaSharesShop())
			myLevel = 9;
		else if (numberOfLike > Shop.getGlitteratiLikeShop()
				&& numberOfFollower > Shop.getGlitteratiFollowerShop()
				&& numberOfShare > Shop.getGlitteratiSharesShop())
			myLevel = 8;
		else if (numberOfLike > Shop.getDesignerLikeShop()
				&& numberOfFollower > Shop.getDesignerFollowerShop()
				&& numberOfShare > Shop.getDesignerSharesShop())
			myLevel = 7;
		else if (numberOfLike > Shop.getTrendsetterLikeShop()
				&& numberOfFollower > Shop.getTrendsetterFollowerShop()
				&& numberOfShare > Shop.getTrendsetterSharesShop())
			myLevel = 6;
		else if (numberOfLike > Shop.getStylistLikeShop()
				&& numberOfFollower > Shop.getStylistFollowerShop()
				&& numberOfShare > Shop.getStylistSharesShop())
			myLevel = 5;
		else if (numberOfLike > Shop.getWowzerLikeShop()
				&& numberOfFollower > Shop.getWowzerFollowerShop()
				&& numberOfShare > Shop.getWowzerSharesShop())
			myLevel = 4;
		else if (numberOfLike > Shop.getModelLikeShop()
				&& numberOfFollower > Shop.getModelFollowerShop()
				&& numberOfShare > Shop.getModelSharesShop())
			myLevel = 3;
		else if (numberOfLike > Shop.getChicLikeShop()
				&& numberOfFollower > Shop.getChicFollowerShop()
				&& numberOfShare > Shop.getChicSharesShop())
			myLevel = 2;
		else if (numberOfLike > Shop.getFashionbloggerLikeShop()
				&& numberOfFollower > Shop.getFashionbloggerFollowerShop()
				&& numberOfShare > Shop.getFashionbloggerSharesShop())
			myLevel = 1;

		return ok(DataFormatUtil.toJsend("success", "" + myLevel));
	}

	/**
	 * Follow shop
	 * 
	 * @author Pottier
	 * @param shopID
	 * @return
	 */
	public static Result follow() {

		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		Form<Shop> postParameter = form(Shop.class).bindFromRequest();
		Shop postShop = postParameter.get();
		if (postShop == null || postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		String postId = postShop.getId(); // variable representing the user I
											// want to follow

		Shop dbPostShop = null;
		boolean flag = false;

		if (ObjectId.isValid(postId))
			dbPostShop = shopCollectionJackson.findOneById(postId);
		if (dbPostShop == null)
			return ok(DataFormatUtil.toJsend("fail", "shop doesnt exist"));
		User dbMe = UserController.userCollectionJackson.findOneById(session()
				.get("id"));

		// put the id of the user in the list of user who follow the shop within
		// shop object

		Set<String> followUserIDSet = dbPostShop.getFollowShopIDSet();
		flag = followUserIDSet.add(session().get("id"));
		dbPostShop.setNumberOfFollower(dbPostShop.getNumberOfFollower() + 1);
		dbPostShop.setFollowShopIDSet(followUserIDSet);
		shopCollectionJackson.updateById(postId, dbPostShop);

		// put the id of the shop in the list of shop followed by the user
		// within the user object

		Set<String> shopsIFollow = dbMe.getShopsIFollow();
		flag = shopsIFollow.add(postId);
		dbMe.setShopsIFollow(shopsIFollow);
		UserController.userCollectionJackson.updateById(session().get("id"),
				dbMe);

		if (flag)
			return ok(DataFormatUtil.toJsend("success", "..."));
		return ok(DataFormatUtil.toJsend("fail", "you already folow this shop"));
	}

	/**
	 * Unfollow shop
	 * 
	 * @author Pottier
	 * @param shopID
	 * @return
	 */
	public static Result unfollow() {

		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		Form<Shop> postParameter = form(Shop.class).bindFromRequest();
		Shop postShop = postParameter.get();
		if (postShop == null || postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		String postId = postShop.getId(); // variable representing the user I
											// want to follow

		Shop dbPostShop = null;
		boolean flag = false;

		if (ObjectId.isValid(postId))
			dbPostShop = shopCollectionJackson.findOneById(postId);
		if (dbPostShop == null)
			return ok(DataFormatUtil.toJsend("fail", "shop doesn t exist"));
		User dbMe = UserController.userCollectionJackson.findOneById(session()
				.get("id"));

		// remove the id of the user in the list of user who follow the shop
		// within shop object
		Set<String> followUserIDSet = dbPostShop.getFollowShopIDSet();
		flag = followUserIDSet.remove(session().get("id"));
		dbPostShop.setNumberOfFollower(dbPostShop.getNumberOfFollower() - 1);
		dbPostShop.setFollowShopIDSet(followUserIDSet);
		shopCollectionJackson.updateById(postId, dbPostShop);

		// remove the id of the shop in the list of shop followed by the user
		// within the user object

		Set<String> shopsIFollow = dbMe.getShopsIFollow();
		flag = shopsIFollow.remove(postId);
		dbMe.setShopsIFollow(shopsIFollow);
		UserController.userCollectionJackson.updateById(session().get("id"),
				dbMe);

		if (flag)
			return ok(DataFormatUtil.toJsend("success", "..."));
		return ok(DataFormatUtil.toJsend("fail",
				"you are not following this shop"));
	}

}
