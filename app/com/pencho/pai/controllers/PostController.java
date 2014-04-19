package com.pencho.pai.controllers;

import static play.data.Form.form;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
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
import com.pencho.pai.models.FashionHelp;
import com.pencho.pai.models.Post;
import com.pencho.pai.models.Product;
import com.pencho.pai.models.User;

public class PostController extends Controller {
	public static final DBCollection postCollection = DAO.database
			.getCollection("post");
	public static final JacksonDBCollection<Post, String> postCollectionJackson = JacksonDBCollection
			.wrap(postCollection, Post.class, String.class);

	/**
	 * Create a post
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result create() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		Form<Post> postParameter = form(Post.class).bindFromRequest();

		// if ("".equals(request.getDescription().trim()))
		// return ok(DataFormatUtil.toJsend("fail",
		// "Description is necessary!"));

		// add rate to the one which b commented
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		Post post = postParameter.get();

		if ("".equals(post.getIsPublic().trim()))
			post.setIsPublic("false");

		post.setUserID(session().get("id"));
		// add user info
		User user = UserController.userCollectionJackson.findOneById(session()
				.get("id"));
		post.setUserID(session().get("id"));
		if (user.getProfilePictureID() != null)
			post.setUserPictureID(user.getProfilePictureID());
		post.setUserName(user.getName());
		post.setCreateTime(DataFormatUtil.getNow());

		Set<String> tags = new HashSet<String>();
		if ("" != post.getTag1().trim())
			tags.add(post.getTag1().trim());
		if ("" != post.getTag2().trim())
			tags.add(post.getTag2().trim());
		if ("" != post.getTag3().trim())
			tags.add(post.getTag3().trim());
		post.setTags(tags);

		WriteResult<Post, String> saved = postCollectionJackson.insert(post);

		// increment numberOfPostCreated of the user who created the original
		// post.
		user.setNumberOfPostCreated(user.getNumberOfPostCreated() + 1);
		UserController.userCollectionJackson.updateById(user.getId(), user);

		return ok(DataFormatUtil.toJsend("success", saved.getSavedId()));

	}

	/**
	 * delete a post
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result delete() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<Post> postParameter = Form.form(Post.class).bindFromRequest();

		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		Post post = postParameter.get();

		Post postdb = postCollectionJackson.findOneById(post.getId());
		if (session().get("id").contains(postdb.getUserID())) {
			if (postdb != null)
				postCollectionJackson.removeById(post.getId());
			return ok(DataFormatUtil.toJsend("success", ""));
		}
		return ok(DataFormatUtil.toJsend("success",
				"you can not delete this is not yours"));
	}

	/**
	 * edit a post
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result edit() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<Post> postParameter = Form.form(Post.class).bindFromRequest();

		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		Post post = postParameter.get();

		if ("" == post.getId())
			return ok(DataFormatUtil.toJsend("fail", "id don't exist"));
		Post postdb = postCollectionJackson.findOneById(post.getId());
		if (null == postdb)
			return ok(DataFormatUtil.toJsend("fail", "post don't exist"));

		if (session().get("id").contains(postdb.getUserID())) {
			if ("" != post.getPictureID())
				postdb.setPictureID(post.getPictureID());
			if ("" != post.getVideoID())
				postdb.setVideoID(post.getVideoID());
			if ("" != post.getDescription())
				postdb.setDescription(post.getDescription());
			if ("" != post.getIsPublic())
				postdb.setIsPublic(post.getIsPublic());
			if ("" != post.getShowOff())
				postdb.setShowOff(post.getShowOff());
			if ("" != post.getCategories())
				postdb.setCategories(post.getCategories());
			if ("" != post.getBrand())
				postdb.setBrand(post.getBrand());
			Set<String> tags = new HashSet<String>();
			if ("" != post.getTag1())
				postdb.setTag1(post.getTag1());
			if ("" != post.getTag2())
				postdb.setTag2(post.getTag2());
			if ("" != post.getTag3())
				postdb.setTag3(post.getTag3());

			Object result = postCollectionJackson.updateById(postdb.getId(),
					postdb);
			return ok(DataFormatUtil.toJsend("success", "update successfully"));
		}
		return ok(DataFormatUtil.toJsend("success",
				"you can not edit this is not yours"));
	}

	/**
	 * get Public post
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result getPublic(int start, int end) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		start -= 1;

		ArrayNode result = new ArrayNode(null);
		DBCursor<Post> productList = postCollectionJackson
				.find(DBQuery.is("isPublic", "true"))
				.sort(new BasicDBObject("createTime", -1)).limit(start + end)
				.skip(start);

		while (productList.hasNext()) {
			result.add(productList.next().toJson());
		}
		return ok(DataFormatUtil.toJsend("success", "post", result));
	}

	/**
	 * get follower post
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result getFollower(int start, int end) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		start -= 1;

		ArrayNode result = new ArrayNode(null);
		// get your friend
		User user = UserController.userCollectionJackson.findOneById(session()
				.get("id"));
		Collection<String> userFollow = user.getbFollowedUserIDSet();
		// get post

		System.out.println(userFollow.toString());

		for (Iterator<String> iterator = userFollow.iterator(); iterator
				.hasNext();) {
			String friendID = iterator.next();
			DBCursor<Post> productList = postCollectionJackson
					.find(DBQuery.is("userID", friendID))
					.sort(new BasicDBObject("createTime", -1))
					.limit(start + end).skip(start);

			while (productList.hasNext()) {
				result.add(productList.next().toJson());
			}
		}
		return ok(DataFormatUtil.toJsend("success", "post", result));

	}

	/**
	 * get Friend post
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result getFriend(int start, int end) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		start -= 1;

		ArrayNode result = new ArrayNode(null);
		// get your friend
		User user = UserController.userCollectionJackson.findOneById(session()
				.get("id"));
		Collection<String> userFriend = user.getFriends().keySet();
		// get post
		for (Iterator<String> iterator = userFriend.iterator(); iterator
				.hasNext();) {
			String friendID = iterator.next();
			DBCursor<Post> productList = postCollectionJackson
					.find(DBQuery.is("userID", friendID))
					.sort(new BasicDBObject("createTime", -1))
					.limit(start + end).skip(start);

			while (productList.hasNext()) {
				result.add(productList.next().toJson());
			}
		}
		return ok(DataFormatUtil.toJsend("success", "post", result));
	}

	/**
	 * get show off post
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result getShowOff(String userID, int start, int end) {
		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		start -= 1;

		ArrayNode result = new ArrayNode(null);
		DBCursor<Post> productList = postCollectionJackson
				.find(DBQuery.is("userID", userID))
				.sort(new BasicDBObject("createTime", -1)).limit(start + end)
				.skip(start);

		while (productList.hasNext()) {
			Post post = productList.next();
			if ("true".equalsIgnoreCase(post.getShowOff()))
				result.add(post.toJson());
		}
		return ok(DataFormatUtil.toJsend("success", "post", result));
	}

	/**
	 * like this post or not
	 * 
	 * @author sandy/pottier
	 * @return
	 */
	public static Result like() {
		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<Post> postParameter = Form.form(Post.class).bindFromRequest();
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "Wrong parameter"));
		String postID = postParameter.get().getId();
		if (!ObjectId.isValid(postID))
			return ok(DataFormatUtil.toJsend("fail", "wrong product id"));
		Post dbPost = postCollectionJackson.findOneById(postParameter.get()
				.getId());
		if (dbPost == null)
			return ok(DataFormatUtil.toJsend("fail",
					"this product is not exist"));

		UsersAuthorityUtil.inBlockListAction(dbPost.getUserID());

		// update the number of like of the User
		User dbUser = UserController.userCollectionJackson.findOneById(dbPost
				.getUserID());

		if (dbPost.getPeopleWhoLike().add(session().get("id"))) {
			dbPost.setLike(dbPost.getLike() + 1);
			dbUser.setNumberOfLike(dbUser.getNumberOfLike() + 1);
		} else {
			dbPost.getPeopleWhoLike().remove(session().get("id"));
			dbPost.setLike(dbPost.getLike() - 1);
			dbUser.setNumberOfLike(dbUser.getNumberOfLike() - 1);
		}
		UserController.userCollectionJackson.updateById(dbPost.getUserID(),
				dbUser);
		postCollectionJackson.updateById(postID, dbPost);

		return ok(DataFormatUtil.toJsend("success", dbPost.getLike() + ""));
	}

	/**
	 * get my public post
	 * 
	 * @author sandy
	 * @return
	 */
	public static Result getMinePublic(int start, int end) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		start -= 1;

		ArrayNode result = new ArrayNode(null);
		DBCursor<Post> productList = postCollectionJackson
				.find(DBQuery.is("userID", session().get("id")))
				.sort(new BasicDBObject("createTime", -1)).limit(start + end)
				.skip(start);

		while (productList.hasNext()) {
			Post post = productList.next();
			if ("true".equalsIgnoreCase(post.getIsPublic()))
				result.add(post.toJson());
		}
		return ok(DataFormatUtil.toJsend("success", "post", result));
	}

	/**
	 * get all post from user if public and if (friend and private) or yourself
	 * if empty
	 * 
	 * @author sandy
	 * @return
	 */
	public static Result getAllFromUserID(String userID, int start, int end) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		start -= 1;

		User dbUser = UserController.userCollectionJackson
				.findOneById(session().get("id"));
		Collection<String> userFriend = dbUser.getFriends().values();

		if ("".contentEquals(userID))
			userID = session().get("id");

		ArrayNode result = new ArrayNode(null);
		DBCursor<Post> productList = postCollectionJackson
				.find(DBQuery.is("userID", userID))
				.sort(new BasicDBObject("createTime", -1)).limit(start + end)
				.skip(start);

		if (dbUser.getId().equalsIgnoreCase(userID)
				|| userFriend.contains(userID))
			while (productList.hasNext())
				result.add(productList.next().toJson());
		else
			while (productList.hasNext()) {
				Post post = productList.next();
				if ("true".equalsIgnoreCase(post.getIsPublic()))
					result.add(post.toJson());
			}

		return ok(DataFormatUtil.toJsend("success", "post", result));

	}

	/**
	 * get post
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result get(String postID) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		if (!ObjectId.isValid(postID))
			return ok(DataFormatUtil.toJsend("fail", "wrong id"));
		Post post = postCollectionJackson.findOneById(postID);
		if (post != null)
			return ok(DataFormatUtil.toJsend("success", "post", post.toJson()));
		else
			return ok(DataFormatUtil.toJsend("fail", "post not exist"));
	}
}
