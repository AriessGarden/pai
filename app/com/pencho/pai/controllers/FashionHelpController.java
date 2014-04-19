package com.pencho.pai.controllers;

import static play.data.Form.form;

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
import com.mongodb.DBCollection;
import com.pencho.pai.dao.DAO;
import com.pencho.pai.models.FashionHelp;
import com.pencho.pai.models.User;

public class FashionHelpController extends Controller {
	public static final DBCollection helpsCollection = DAO.database
			.getCollection("fashionHelps");

	public static final JacksonDBCollection<FashionHelp, String> helpCollectionJackson = JacksonDBCollection
			.wrap(helpsCollection, FashionHelp.class, String.class);

	/**
	 * @author Bill
	 * 
	 * @return
	 */
	public static Result create() {

		// if u login
		/*
		 * if (!SecurityUtil.isLogin()) return ok(DataFormatUtil.toJsend("fail",
		 * "4"));
		 */

		Form<FashionHelp> fashionHelpsForm = Form.form(FashionHelp.class);
		FashionHelp fashionHelp = fashionHelpsForm.bindFromRequest().get();

		if ("".equals(fashionHelp.getDescription().trim()))
			return ok(DataFormatUtil.toJsend("fail",
					"Please input fashionHelp Text is necessary!"));

		// add user info
		User user = UserController.userCollectionJackson.findOneById(session()
				.get("id"));
		fashionHelp.setUserID(session().get("id"));
		fashionHelp.setUserPictureID(user.getProfilePictureID());
		fashionHelp.setUserName(user.getName());

		WriteResult<FashionHelp, String> result = helpCollectionJackson
				.insert(fashionHelp);
		return ok(DataFormatUtil.toJsend("success", result.getSavedId()));
	}

	/**
	 * @author Bill
	 * 
	 * @return
	 */
	public static Result delete() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<FashionHelp> postParameter = Form.form(FashionHelp.class)
				.bindFromRequest();

		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		FashionHelp post = postParameter.get();

		FashionHelp helpdb = helpCollectionJackson.findOneById(post.getId());
		if (session().get("id").contains(helpdb.getUserID())) {
			if (helpdb != null)
				helpCollectionJackson.removeById(post.getId());
			return ok(DataFormatUtil.toJsend("success", ""));
		}
		return ok(DataFormatUtil.toJsend("success",
				"you can not delete this is not yours"));
	}

	/**
	 * @author Bill
	 * 
	 * @return
	 */
	public static Result edit() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<FashionHelp> postParameter = Form.form(FashionHelp.class)
				.bindFromRequest();

		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		FashionHelp post = postParameter.get();

		if ("" == post.getId())
			return ok(DataFormatUtil.toJsend("fail", "id don't exist"));
		FashionHelp helpdb = helpCollectionJackson.findOneById(post.getId());
		if (null == helpdb)
			return ok(DataFormatUtil.toJsend("fail", "product don't exist"));

		if (session().get("id").contains(helpdb.getUserID())) {

			if ("" != post.getPictureID())
				helpdb.setPictureID(post.getPictureID());
			if ("" != post.getDescription())
				helpdb.setDescription(post.getDescription());

			Object result = helpCollectionJackson.updateById(helpdb.getId(),
					helpdb);
			return ok(DataFormatUtil.toJsend("success", "update successfully"));
		}
		return ok(DataFormatUtil.toJsend("success",
				"you can not edit this is not yours"));
	}

	public static Result update(String idValue, String pictureID,
			String description) {

		FashionHelp fashionHelp = helpCollectionJackson.find(
				DBQuery.is("helpID", idValue)).next();
		fashionHelp.setPictureID(pictureID);
		fashionHelp.setDescription(description);

		return ok("Successfully updated the Fashion Help!");
	}

	public static Result delete(String idValue) {
		helpCollectionJackson.find(DBQuery.is("helpID", idValue)).remove();
		return TODO;
	}

	public static Result get(int start, int end) {

		// if u login
		// if (!SecurityUtil.isLogin())
		// return ok(DataFormatUtil.toJsend("fail", "login first"));

		// if(!ObjectId.isValid(idKey))
		// return

		start -= 1;

		ArrayNode result = new ArrayNode(null);
		DBCursor<FashionHelp> newsList = helpCollectionJackson.find()
				.limit(end + start).skip(start);

		while (newsList.hasNext()) {
			result.add(newsList.next().toJson());
		}

		return ok(DataFormatUtil.toJsend("success", "help", result));
	}

	/**
	 * save help
	 * 
	 * @author sandy
	 * @param helpID
	 * @return
	 */
	public static Result saveHelp() {

		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		Form<FashionHelp> postParameter = form(FashionHelp.class)
				.bindFromRequest();
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		FashionHelp help = postParameter.get();

		boolean flag = false;
		User dbUser = UserController.userCollectionJackson
				.findOneById(session().get("id"));

		Set<String> fashionHelpSaved = dbUser.getFashionHelpSaved();
		flag = fashionHelpSaved.add(help.getId());
		dbUser.setFashionHelpSaved(fashionHelpSaved);
		UserController.userCollectionJackson.updateById(dbUser.getId(), dbUser);

		if (flag)
			return ok(DataFormatUtil.toJsend("success", ""));
		return ok(DataFormatUtil.toJsend("fail", "help already save"));
	}

	/**
	 * delete help from savedHelp
	 * 
	 * @author Aries
	 * @param helpID
	 * @return
	 */
	public static Result unsaveHelp() {

		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		Form<FashionHelp> postParameter = form(FashionHelp.class)
				.bindFromRequest();
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		FashionHelp help = postParameter.get();

		User dbUser = UserController.userCollectionJackson
				.findOneById(session().get("id"));

		Set<String> fashionHelpSaved = dbUser.getFashionHelpSaved();
		boolean flag = fashionHelpSaved.remove(help.getId());

		if (flag) {
			dbUser.setFashionHelpSaved(fashionHelpSaved);
			UserController.userCollectionJackson.updateById(dbUser.getId(),
					dbUser);
			return ok(DataFormatUtil.toJsend("success", ""));
		} else

			return ok(DataFormatUtil.toJsend("fail", "help is not in ur list"));
	}

	/**
	 * get saved help
	 * 
	 * @author sandy
	 * @return
	 */
	public static Result getSavedHelp() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		User dbUser = UserController.userCollectionJackson
				.findOneById(session().get("id"));
		Set<String> fashionHelpSaved = dbUser.getFashionHelpSaved();

		ArrayNode result = new ArrayNode(null);
		for (Iterator<String> iterator = fashionHelpSaved.iterator(); iterator
				.hasNext();) {
			FashionHelp help = helpCollectionJackson.findOneById(iterator
					.next());
			if (help != null)
				result.add(help.toJson());
		}
		return ok(DataFormatUtil.toJsend("success", "help", result));
	}

	/**
	 * if u like this help
	 * 
	 * @author Aries
	 * @return
	 */
	public static Result like() {
		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<FashionHelp> postParameter = Form.form(FashionHelp.class)
				.bindFromRequest();
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "Wrong parameter"));
		String FashionHelpID = postParameter.get().getId();
		if (!ObjectId.isValid(FashionHelpID))
			return ok(DataFormatUtil.toJsend("fail", "wrong help id"));
		FashionHelp dbFashionHelp = helpCollectionJackson
				.findOneById(FashionHelpID);
		if (dbFashionHelp == null)
			return ok(DataFormatUtil.toJsend("fail", "this help is not exist"));

		UsersAuthorityUtil.inBlockListAction(dbFashionHelp.getUserID());

		User dbUser = UserController.userCollectionJackson
				.findOneById(dbFashionHelp.getUserID());
		if (dbFashionHelp.getPeopleWhoLike().add(session().get("id"))) {
			dbFashionHelp.setLike(dbFashionHelp.getLike() + 1);
			dbUser.setStar(dbUser.getStar() + 1);
		} else {
			dbFashionHelp.getPeopleWhoLike().remove(session().get("id"));
			dbFashionHelp.setLike(dbFashionHelp.getLike() - 1);
			dbUser.setStar(dbUser.getStar() - 1);
		}
		UserController.userCollectionJackson.updateById(
				dbFashionHelp.getUserID(), dbUser);
		helpCollectionJackson.updateById(FashionHelpID, dbFashionHelp);

		return ok(DataFormatUtil.toJsend("success", dbFashionHelp.getLike()
				+ ""));
	}

}
