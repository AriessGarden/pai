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
import com.pencho.pai.models.Comment;
import com.pencho.pai.models.Message;
import com.pencho.pai.models.User;

public class MessageController extends Controller {
	public static final DBCollection MessageCollection = DAO.database
			.getCollection("message");
	public static final JacksonDBCollection<Message, String> messageCollectionJackson = JacksonDBCollection
			.wrap(MessageCollection, Message.class, String.class);
	
	/**
	 * Create a Message
	 * 
	 * @author sandy
	 * @return status/create time
	 */
	public static Result create() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));

		Form<Message> MessageParameter = form(Message.class).bindFromRequest();
		
//		if ("".equals(request.getDescription().trim()))
//			return ok(DataFormatUtil.toJsend("fail",
//					"Description is necessary!"));

		// add rate to the one which b commented
		if (MessageParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		Message message = MessageParameter.get();


		
		// add user info
		User user = UserController.userCollectionJackson
				.findOneById(session().get("id"));
		message.setFromUserID(session().get("id"));
		message.setUserPictureID(user.getProfilePictureID());
		message.setUserName(user.getName());
		message.setCreateTime(DataFormatUtil.getNow());
		WriteResult<Message, String> saved = messageCollectionJackson
				.insert(message);

		return ok(DataFormatUtil.toJsend("success", saved.getSavedId()));
	}

	
	/**
	 * get my Message
	 * 
	 * @author sandy
	 * @return
	 */
	public static Result getMy(int start, int end) { 

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		start -= 1;

		ArrayNode result = new ArrayNode(null);
		DBCursor<Message> productList = messageCollectionJackson.find(DBQuery.is("toUserID",
				session().get("id")))
				.sort(new BasicDBObject("createTime", -1)).limit(start + end)
				.skip(start);

		while (productList.hasNext()) {
				result.add(productList.next().toJson());
		}
		return ok(DataFormatUtil.toJsend("success", "Message", result));
	}
	
	
	/**
	 * get my Message send
	 * 
	 * @author sandy
	 * @return
	 */
	public static Result getMessageSend(int start, int end) { 

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		start -= 1;

		ArrayNode result = new ArrayNode(null);
		DBCursor<Message> productList = messageCollectionJackson.find(DBQuery.is("fromUserID",
				session().get("id")))
				.sort(new BasicDBObject("createTime", -1)).limit(start + end)
				.skip(start);

		while (productList.hasNext()) {
				result.add(productList.next().toJson());
		}
		return ok(DataFormatUtil.toJsend("success", "Message", result));
	}

	/**
	 * destroy message
	 * 
	 * @author sandy
	 * @return
	 */
	public static Result destroy() { 

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));
		
		Form<Message> MessageParameter = form(Message.class).bindFromRequest();
		if (MessageParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		Message message = MessageParameter.get();
		if (message != null) {
			messageCollectionJackson.removeById(message.getId());
			return ok(DataFormatUtil.toJsend("success", ""));
		}
		else
			return ok(DataFormatUtil.toJsend("fail", "no message to delete"));
	}
	
}
