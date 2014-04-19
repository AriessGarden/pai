package com.pencho.pai.controllers;


import static play.data.Form.form;

import java.util.Collection;
import java.util.Iterator;

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
import com.pencho.pai.models.Post;
import com.pencho.pai.models.SnapShot;
import com.pencho.pai.models.User;
import com.pencho.pai.models.Wardrobe;

public class SnapShotController extends Controller {
	public static final DBCollection snapshotCollection = DAO.database
			.getCollection("snapshot");
	public static final JacksonDBCollection<SnapShot, String> snapshotCollectionJackson = JacksonDBCollection
			.wrap(snapshotCollection, SnapShot.class, String.class);
	
	/**
	 * Create a snapshot
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result create() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		Form<SnapShot> postParameter = form(SnapShot.class).bindFromRequest();
		
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		SnapShot snapshot = postParameter.get();

		if ("".equals(snapshot.getIsPublic().trim()))
			snapshot.setIsPublic("false");
		
		snapshot.setUserID(session().get("id"));
		snapshot.setCreateTime(DataFormatUtil.getNow());
		WriteResult<SnapShot, String> saved = snapshotCollectionJackson
				.insert(snapshot);

		return ok(DataFormatUtil.toJsend("success", saved.getSavedId()));
	}
	
	/**
	 * get snapshot of userID
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result getByUserID(String userID, int start, int end) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		start -= 1;
		
		if("".contentEquals(userID))
			userID = session().get("id");

		ArrayNode result = new ArrayNode(null);
			DBCursor<SnapShot> snapShotList = snapshotCollectionJackson.find(DBQuery.is("userID", userID))
				.sort(new BasicDBObject("createTime", -1)).limit(start + end)
				.skip(start);

			User dbUser = UserController.userCollectionJackson.findOneById(session().get("id"));
			Collection<String> userFriend = dbUser.getFriends().values();
			if(dbUser.getId().equalsIgnoreCase(userID) || userFriend.contains(userID) )
				while (snapShotList.hasNext()) 
					result.add(snapShotList.next().toJson());
			else
				while (snapShotList.hasNext()) {
					SnapShot snapShot = snapShotList.next();
					if("true".equalsIgnoreCase(snapShot.getIsPublic()))
						result.add(snapShot.toJson());
				}
			
		return ok(DataFormatUtil.toJsend("success", "snapshot", result));
	}
	
	/**
	 * like this SnapShot or not
	 * 
	 * @author sandy
	 * @return
	 */
	public static Result like() {
		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<SnapShot> postParameter = Form.form(SnapShot.class)
				.bindFromRequest();
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "Wrong parameter"));
		String snapShotID = postParameter.get().getId();
		if (!ObjectId.isValid(snapShotID))
			return ok(DataFormatUtil.toJsend("fail", "wrong product id"));
		SnapShot dbSnapshot = snapshotCollectionJackson.findOneById(postParameter.get().getId());
		if (dbSnapshot == null)
			return ok(DataFormatUtil.toJsend("fail",
					"this product is not exist"));

		User dbUser = UserController.userCollectionJackson.findOneById(dbSnapshot
				.getUserID());
		if(dbSnapshot.getPeopleWhoLike().add(session().get("id"))){
			dbSnapshot.setLike(dbSnapshot.getLike() + 1);
			dbUser.setStar(dbUser.getStar() + 1);
		} else {
			dbSnapshot.getPeopleWhoLike().remove(session().get("id"));
			dbSnapshot.setLike(dbSnapshot.getLike() - 1);
			dbUser.setStar(dbUser.getStar() - 1);
		}
		UserController.userCollectionJackson.updateById(dbSnapshot.getUserID(), dbUser);
		snapshotCollectionJackson.updateById(snapShotID, dbSnapshot);

		return ok(DataFormatUtil.toJsend("success", ""));
	}
	
	/**
	 * destroy snapshot
	 * 
	 * @author sandy
	 * @return
	 */
	public static Result destroy() { 

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));
		
		Form<SnapShot> SnapshotParameter = form(SnapShot.class).bindFromRequest();
		if (SnapshotParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		SnapShot snapshot = SnapshotParameter.get();
		if (snapshot != null) {
			snapshotCollectionJackson.removeById(snapshot.getId());
			return ok(DataFormatUtil.toJsend("success", ""));
		}
		else
			return ok(DataFormatUtil.toJsend("fail", "no Wardrobe to delete"));
	}
	
	/**
	 * get snapshot
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result get(String postID) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		SnapShot snapshot = snapshotCollectionJackson.findOneById(postID);

		return ok(DataFormatUtil.toJsend("success", "snapshot", snapshot.toJson() ));
	}
}