package com.pencho.pai.controllers;

import static play.data.Form.form;

import java.util.Collection;
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

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.pencho.pai.dao.DAO;
import com.pencho.pai.models.User;
import com.pencho.pai.models.Wardrobe;

public class WardrobeController extends Controller {
	public static final DBCollection wardrobeCollection = DAO.database
			.getCollection("wardrobe");
	public static final JacksonDBCollection<Wardrobe, String> wardrobeCollectionJackson = JacksonDBCollection
			.wrap(wardrobeCollection, Wardrobe.class, String.class);

	/**
	 * Create a wardrobe
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result create() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		Form<Wardrobe> postParameter = form(Wardrobe.class).bindFromRequest();

		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		Wardrobe wardrobe = postParameter.get();

		if ("".equals(wardrobe.getIsPublic().trim()))
			wardrobe.setIsPublic("false");
		if ("".equals(wardrobe.getIsOnlyMe().trim()))
			wardrobe.setIsOnlyMe("false");

		Set<String> tags = wardrobe.getTags();
		if (!"".equals(wardrobe.getTag1()))
			tags.add(wardrobe.getTag1());
		if (!"".equals(wardrobe.getTag2()))
			tags.add(wardrobe.getTag1());
		if (!"".equals(wardrobe.getTag3()))
			tags.add(wardrobe.getTag1());
		if (tags.size() != 0)
			wardrobe.setTags(tags);

		wardrobe.setUserID(session().get("id"));
		wardrobe.setCreateTime(DataFormatUtil.getNow());
		WriteResult<Wardrobe, String> saved = wardrobeCollectionJackson
				.insert(wardrobe);

		return ok(DataFormatUtil.toJsend("success", saved.getSavedId()));
	}

	/**
	 * get wardrobe of userID
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result getByUserID(String userID, int start, int end) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		start -= 1;

		if ("".contentEquals(userID))
			userID = session().get("id");

		ArrayNode result = new ArrayNode(null);
		DBCursor<Wardrobe> wardrobeList = wardrobeCollectionJackson
				.find(DBQuery.is("userID", userID))
				.sort(new BasicDBObject("createTime", -1)).limit(start + end)
				.skip(start);

		User dbUser = UserController.userCollectionJackson
				.findOneById(session().get("id"));
		Collection<String> userFriend = dbUser.getFriends().values();
		if (userFriend.contains(userID)) // your friend
			while (wardrobeList.hasNext()) {
				Wardrobe wardrobe = wardrobeList.next();
				if ("false".equalsIgnoreCase(wardrobe.getIsOnlyMe()))
					result.add(wardrobeList.next().toJson());
			}
		else if (dbUser.getId().equalsIgnoreCase(userID)) // is you
			while (wardrobeList.hasNext()) {
				result.add(wardrobeList.next().toJson());
			}
		else
			while (wardrobeList.hasNext()) { // is someone else
				Wardrobe wardrobe = wardrobeList.next();
				if ("false".equalsIgnoreCase(wardrobe.getIsOnlyMe()))
					if ("true".equalsIgnoreCase(wardrobe.getIsPublic()))
						result.add(wardrobe.toJson());
			}

		return ok(DataFormatUtil.toJsend("success", "wardrobe", result));
	}

	/**
	 * like this wardrobe or not
	 * 
	 * @author sandy
	 * @return
	 */
	public static Result like() {
		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<Wardrobe> postParameter = Form.form(Wardrobe.class)
				.bindFromRequest();
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "Wrong parameter"));
		String wardrobeID = postParameter.get().getId();
		if (!ObjectId.isValid(wardrobeID))
			return ok(DataFormatUtil.toJsend("fail", "wrong product id"));
		Wardrobe dbWardrobe = wardrobeCollectionJackson
				.findOneById(postParameter.get().getId());
		if (dbWardrobe == null)
			return ok(DataFormatUtil.toJsend("fail",
					"this product is not exist"));

		User dbUser = UserController.userCollectionJackson.findOneById(dbWardrobe
				.getUserID());
		if(dbWardrobe.getPeopleWhoLike().add(session().get("id"))){
			dbWardrobe.setLike(dbWardrobe.getLike() + 1);
			dbUser.setStar(dbUser.getStar() + 1);
		} else {
			dbWardrobe.getPeopleWhoLike().remove(session().get("id"));
			dbWardrobe.setLike(dbWardrobe.getLike() - 1);
			dbUser.setStar(dbUser.getStar() - 1);
		}
		UserController.userCollectionJackson.updateById(dbWardrobe.getUserID(),
				dbUser);
		wardrobeCollectionJackson.updateById(wardrobeID, dbWardrobe);

		return ok(DataFormatUtil.toJsend("success", dbWardrobe.getLike() + ""));
	}

	/**
	 * destroy wardrobe
	 * 
	 * @author sandy
	 * @return
	 */
	public static Result destroy() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<Wardrobe> WardrobeParameter = form(Wardrobe.class)
				.bindFromRequest();
		if (WardrobeParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		Wardrobe wardrobe = WardrobeParameter.get();
		if (wardrobe != null) {
			wardrobeCollectionJackson.removeById(wardrobe.getId());
			return ok(DataFormatUtil.toJsend("success", ""));
		} else
			return ok(DataFormatUtil.toJsend("fail", "no Wardrobe to delete"));
	}

	/**
	 * get wardrobe
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result get(String postID) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		Wardrobe wardrobe = wardrobeCollectionJackson.findOneById(postID);

		return ok(DataFormatUtil.toJsend("success", "wardrobe",
				wardrobe.toJson()));
	}

}
