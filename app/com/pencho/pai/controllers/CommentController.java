package com.pencho.pai.controllers;

import static play.data.Form.form;

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

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.pencho.pai.dao.DAO;
import com.pencho.pai.models.Comment;
import com.pencho.pai.models.FashionHelp;
import com.pencho.pai.models.User;

public class CommentController extends Controller {
	public static final DBCollection commentCollection = DAO.database
			.getCollection("comment");
	public static final JacksonDBCollection<Comment, String> commentCollectionJackson = JacksonDBCollection
			.wrap(commentCollection, Comment.class, String.class);

	/**
	 * Create a comment
	 * 
	 * @author Aries
	 * @return status/create time
	 */
	public static Result create() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		Form<Comment> postParameter = form(Comment.class).bindFromRequest();
		Comment request = postParameter.get();

		// add star to the one which b commented
		User user = UserController.userCollectionJackson.findOneById(session()
				.get("id"));
		if (user != null) {
			user.setStar(user.getStar() + 1);
			UserController.userCollectionJackson.updateById(
					session().get("id"), user);
		}else{
			return ok(DataFormatUtil.toJsend("fail", "u are not an user"));
		}

		// add number of comment
		if (!"".equals(request.getHelpID())) {
			FashionHelp help = FashionHelpController.helpCollectionJackson
					.findOneById(request.getHelpID());
			if (help != null) {
				help.setNumberOfComments(help.getNumberOfComments() + 1);
				FashionHelpController.helpCollectionJackson.updateById(
						request.getHelpID(), help);
			}

		}
		// add user info
		request.setUserID(session().get("id"));
		if (user.getProfilePictureID() != null)
			request.setUserPictureID(user.getProfilePictureID());
		request.setUserName(user.getName());
		request.setCreateTime(DataFormatUtil.getNow());
		WriteResult<Comment, String> result = commentCollectionJackson
				.insert(request);
		return ok(DataFormatUtil.toJsend("success", result.getSavedId()));
	}

	/**
	 * Edit a comment
	 * 
	 * @author Aries
	 * @return status
	 */
	public static Result edit() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		Form<Comment> postParameter = form(Comment.class).bindFromRequest();
		Comment request = postParameter.get();

		Comment dbComment;
		if (ObjectId.isValid(request.getId())) {
			dbComment = commentCollectionJackson.findOneById(request.getId());
			if (dbComment.getUserID() == null)
				return ok(DataFormatUtil.toJsend("fail", "Wrong id"));
			if (dbComment.getUserID().equals(session().get("id"))) {

				if (!"".equals(request.getHelpID().trim()))
					dbComment.setHelpID(request.getHelpID());

				if (!"".equals(request.getProductID().trim()))
					dbComment.setProductID(request.getProductID());

				if (!"".equals(request.getPictureID().trim()))
					dbComment.setProductID(request.getPictureID());

				if (!"".equals(request.getPostID().trim()))
					dbComment.setPostID(request.getPostID());

				if (!"".equals(request.getVideoID().trim()))
					dbComment.setVideoID(request.getVideoID());

				if (!"".equals(request.getAudioID().trim()))
					dbComment.setAudioID(request.getAudioID());

				if (!"".equals(request.getDescription().trim()))
					dbComment.setDescription(request.getDescription());
				commentCollectionJackson.updateById(request.getId(), dbComment);
				return ok(DataFormatUtil.toJsend("success", ""));
			} else
				return ok(DataFormatUtil.toJsend("fail", "is this ur comment?"));
		}
		return ok(DataFormatUtil.toJsend("fail", "Wrong id"));
	}

	/**
	 * Delete comment
	 * 
	 * @author aries
	 * @return status
	 */
	public static Result delete() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		Form<Comment> postParameter = form(Comment.class).bindFromRequest();
		Comment request = postParameter.get();

		Comment dbComment;

		if (ObjectId.isValid(request.getId())) {
			dbComment = commentCollectionJackson.findOneById(request.getId());
			if (dbComment.getUserID() == null)
				return ok(DataFormatUtil.toJsend("fail", "Wrong id"));
			if (dbComment.getUserID().equals(session().get("id"))) {
				commentCollectionJackson.removeById(request.getId());
				return ok(DataFormatUtil.toJsend("success", ""));
			} else
				return ok(DataFormatUtil.toJsend("fail", "is this ur comment?"));
		} else
			return ok(DataFormatUtil.toJsend("fail", "Wrong id"));
	}

	/**
	 * a tool for find
	 * 
	 * @author Aries
	 * @param idKey
	 * @return result
	 */
	public static Result findBy(String field, String idKey, int start, int end) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		if (!ObjectId.isValid(idKey))
			return ok(DataFormatUtil.toJsend("fail", "wrong id"));
		start -= 1;
		ArrayNode result = new ArrayNode(null);
		DBCursor<Comment> commentList = commentCollectionJackson
				.find(DBQuery.is(field, idKey))
				.sort(new BasicDBObject("createTime", -1)).limit(start + end)
				.skip(start);
		while (commentList.hasNext()) {
			result.add(commentList.next().toJson());
		}
		return ok(DataFormatUtil.toJsend("success", "comments", result));
	}

	/**
	 * 
	 * Find all my comments
	 * 
	 * @author Aries
	 * @return All my comments
	 */
	public static Result findByUserID(int start, int end) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		return findBy("userID", session().get("id"), start, end);
	}

	/**
	 * 
	 * Find all comments of a Help
	 * 
	 * @author sandy
	 * @return All comments of Help
	 */
	public static Result findByHelpID(String helpID, int start, int end) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		return findBy("helpID", helpID, start, end);
	}
	
	/**
	 * 
	 * Find all comments of a post
	 * 
	 * @author Aries
	 * @return All comments of post
	 */
	public static Result findByPostID(String postID, int start, int end) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		return findBy("postID", postID, start, end);
	}
	

	/**
	 * 
	 * Find all comments of a Product
	 * 
	 * @author sandy
	 * @return All comments of Help
	 */
	public static Result findByProductID(String productID, int start, int end) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		return findBy("productID", productID, start, end);
	}
}
