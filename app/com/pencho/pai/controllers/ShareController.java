package com.pencho.pai.controllers;

import static play.data.Form.form;

import java.util.Map;

import org.bson.types.ObjectId;
import org.mongojack.DBCursor;
import org.mongojack.DBQuery;
import org.mongojack.WriteResult;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utils.DataFormatUtil;
import utils.SecurityUtil;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.pencho.pai.models.Post;
import com.pencho.pai.models.Product;
import com.pencho.pai.models.SnapShot;
import com.pencho.pai.models.User;
import com.pencho.pai.models.Wardrobe;

public class ShareController extends Controller {

	/**
	 * Share a post
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result shareOfPost() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		Form<Post> postParameter = form(Post.class).bindFromRequest();

		// get the id of the post we want to share
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		String postid = postParameter.get().getId();

		// create a new post which is a shortcut to the original post.
		Post post = new Post();
		post.setShareOfPostID(postid);
		post.setIsPublic(postParameter.get().getIsPublic());

		// add user info
		User user = UserController.userCollectionJackson.findOneById(session()
				.get("id"));
		post.setUserID(session().get("id"));
		post.setUserPictureID(user.getProfilePictureID());
		post.setUserName(user.getName());
		post.setCreateTime(DataFormatUtil.getNow());

		// increment numberOfShare of the user who created the original post.
		Post dbPost = PostController.postCollectionJackson
				.findOneById(postParameter.get().getId());
		dbPost.setShare(dbPost.getShare() + 1);
		PostController.postCollectionJackson.updateById(postParameter.get()
				.getId(), dbPost);
		User dbUser = UserController.userCollectionJackson.findOneById(dbPost
				.getUserID());
		dbUser.setNumberOfShare(dbUser.getNumberOfShare() + 1);
		UserController.userCollectionJackson.updateById(dbPost.getUserID(),
				dbUser);

		// Insert the new post in the database
		WriteResult<Post, String> saved = PostController.postCollectionJackson
				.insert(post);

		return ok(DataFormatUtil.toJsend("success", dbPost.getShare() + ""));
	}

	/**
	 * Share a product
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result shareOfProduct() {

		Form<Post> postParameter = form(Post.class).bindFromRequest();

		// get the id of the post we want to share
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		String postid = postParameter.get().getId();

		Post post = new Post();
		post.setShareOfProductID(postid);
		post.setIsPublic(postParameter.get().getIsPublic());

		post.setUserID(session().get("id"));
		// add user info
		User user = UserController.userCollectionJackson.findOneById(session()
				.get("id"));
		post.setUserID(session().get("id"));
		post.setUserPictureID(user.getProfilePictureID());
		post.setUserName(user.getName());
		post.setCreateTime(DataFormatUtil.getNow());
		WriteResult<Post, String> saved = PostController.postCollectionJackson
				.insert(post);

		// increment numberOfShare of the user who created the original post.
		Product dbProduct = ProductController.productCollectionJackson
				.findOneById(postParameter.get().getId());
		dbProduct.setShare(dbProduct.getShare() + 1);
		ProductController.productCollectionJackson.updateById(postParameter
				.get().getId(), dbProduct);
		User dbUser = UserController.userCollectionJackson.findOneById(post
				.getUserID());
		dbUser.setNumberOfShare(dbUser.getNumberOfShare() + 1);
		UserController.userCollectionJackson.updateById(post.getUserID(),
				dbUser);

		return ok(DataFormatUtil.toJsend("success", dbProduct.getShare() + ""));
	}

	/**
	 * Share a product
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result shareOfSnapShot() {

		Form<Post> postParameter = form(Post.class).bindFromRequest();

		// get the id of the post we want to share
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		String postid = postParameter.get().getId();

		Post post = new Post();
		post.setShareOfSnapShotID(postid);
		post.setIsPublic(postParameter.get().getIsPublic());

		post.setUserID(session().get("id"));
		// add user info
		User user = UserController.userCollectionJackson.findOneById(session()
				.get("id"));
		post.setUserID(session().get("id"));
		post.setUserPictureID(user.getProfilePictureID());
		post.setUserName(user.getName());
		post.setCreateTime(DataFormatUtil.getNow());
		WriteResult<Post, String> saved = PostController.postCollectionJackson
				.insert(post);

		// increment numberOfShare of the user who created the original post.
		SnapShot dbSnapShot = SnapShotController.snapshotCollectionJackson
				.findOneById(postParameter.get().getId());
		dbSnapShot.setShare(dbSnapShot.getShare() + 1);
		SnapShotController.snapshotCollectionJackson.updateById(postParameter
				.get().getId(), dbSnapShot);
		User dbUser = UserController.userCollectionJackson.findOneById(post
				.getUserID());
		dbUser.setNumberOfShare(dbUser.getNumberOfShare() + 1);
		UserController.userCollectionJackson.updateById(post.getUserID(),
				dbUser);

		return ok(DataFormatUtil.toJsend("success", saved.getSavedId()));
	}

	/**
	 * Share a product
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result shareOfWardrobe() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		Form<Post> postParameter = form(Post.class).bindFromRequest();

		// get the id of the post we want to share
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		String postid = postParameter.get().getId();

		Post post = new Post();
		post.setShareOfWardrobeID(postid);
		post.setIsPublic(postParameter.get().getIsPublic());

		post.setUserID(session().get("id"));
		// add user info
		User user = UserController.userCollectionJackson.findOneById(session()
				.get("id"));
		post.setUserID(session().get("id"));
		post.setUserPictureID(user.getProfilePictureID());
		post.setUserName(user.getName());
		post.setCreateTime(DataFormatUtil.getNow());
		WriteResult<Post, String> saved = PostController.postCollectionJackson
				.insert(post);

		// increment numberOfShare of the user who created the original post.
		Wardrobe dbWardrobe = WardrobeController.wardrobeCollectionJackson
				.findOneById(postParameter.get().getId());
		dbWardrobe.setShare(dbWardrobe.getShare() + 1);
		WardrobeController.wardrobeCollectionJackson.updateById(postParameter
				.get().getId(), dbWardrobe);
		User dbUser = UserController.userCollectionJackson.findOneById(post
				.getUserID());
		dbUser.setNumberOfShare(dbUser.getNumberOfShare() + 1);
		UserController.userCollectionJackson.updateById(post.getUserID(),
				dbUser);

		return ok(DataFormatUtil.toJsend("success", dbWardrobe.getShare() + ""));
	}

	/**
	 * Get shared products/posts/snap-shots/wardrobes by user
	 * id(user/friend/stranger)
	 * 
	 * @author aries
	 */
	public static Result getByUserID(String userID, String theType) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first"));

		ArrayNode result = new ArrayNode(null);
		if (userID.trim().equals("")) {
			result = judgeTheType(theType, session().get("id"), true);
			return ok(DataFormatUtil.toJsend("success", theType + "-List",
					result));
		} else if (!ObjectId.isValid(userID))
			return ok(DataFormatUtil.toJsend("fail", "Wrong userID"));
		else {
			// if userID is owner's friend
			User desUser = UserController.userCollectionJackson
					.findOneById(userID);
			Map<String, String> friendList = desUser.getFriends();
			if ("true".equalsIgnoreCase(friendList.get(session().get("id")))) {
				result = judgeTheType(theType, userID, true);

			} else
				result = judgeTheType(theType, userID, false);
			return ok(DataFormatUtil.toJsend("success", theType + "-List",
					result));
		}
	}

	/**
	 * judge theType for getByUserID in current class
	 * 
	 * @author aries
	 * @param theType
	 * @return result
	 */
	public static ArrayNode judgeTheType(String theType, String userID,
			boolean isPublic) {
		ArrayNode result = new ArrayNode(null);
		if (theType.trim().equals("")) {
			DBCursor<Post> list = PostController.postCollectionJackson
					.find(DBQuery.is("userID", userID));
			while (list.hasNext()) {
				if (isPublic)
					result.add(list.next().toJson());
				else {
					Post p = list.next();
					if ("true".equals(p.getIsPublic()))
						result.add(p.toJson());
				}
			}
			return result;
		} else if (theType.trim().equalsIgnoreCase("product")) {
			DBCursor<Product> list = ProductController.productCollectionJackson
					.find(DBQuery.is("userID", userID));
			while (list.hasNext())
				result.add(list.next().toJson());
			return result;
		} else if (theType.trim().equalsIgnoreCase("wardrobe")) {
			DBCursor<Wardrobe> list = WardrobeController.wardrobeCollectionJackson
					.find(DBQuery.is("userID", userID));
			while (list.hasNext())
				result.add(list.next().toJson());
			return result;
		} else if (theType.trim().equalsIgnoreCase("snapshot")) {
			DBCursor<SnapShot> list = SnapShotController.snapshotCollectionJackson
					.find(DBQuery.is("userID", userID));
			while (list.hasNext())
				result.add(list.next().toJson());
			return result;
		} else
			return null;
	}
}