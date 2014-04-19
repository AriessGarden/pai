package com.pencho.pai.controllers;

import org.bson.types.ObjectId;
import org.mongojack.DBCursor;
import org.mongojack.JacksonDBCollection;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import utils.DataFormatUtil;
import utils.SecurityUtil;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.mongodb.DBCollection;
import com.pencho.pai.dao.DAO;
import com.pencho.pai.models.FashionNews;
import com.pencho.pai.models.User;

public class FashionNewsController extends Controller {
	public static final DBCollection newsCollection = DAO.database
			.getCollection("news");
	
	public static final JacksonDBCollection<FashionNews, String> jacksonNewsCollection = 
			JacksonDBCollection.wrap(newsCollection, FashionNews.class, String.class);
	
	/**
	 * @author Bill
	 * 
	 * @return
	 */
	public static Result create() {

		// if u login
		/*if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "4"));*/

		Form<FashionNews> newsForm = Form.form(FashionNews.class);
		FashionNews fashionNews = newsForm.bindFromRequest().get();
		
		if ("".equals(fashionNews.getNewsText().trim()))
			return ok(DataFormatUtil.toJsend("fail",
					"News Text is necessary!"));
		
		
		//WriteResult<FashionNews, String> result = 
				jacksonNewsCollection.insert(fashionNews);
		return ok(DataFormatUtil.toJsend("success", ""));
		//return ok(DataFormatUtil.toJsend("success", result.getSavedId()));
	}
	
	/**
	 * find news by page
	 * @param page number
	 * @return
	 */
	
	public static Result get(int start, int end) {
		
		/*// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));*/
		
		start -=1;
		
		ArrayNode result = new ArrayNode(null);
		DBCursor<FashionNews> newsList = 
				jacksonNewsCollection.find().limit(end + start).skip(start);
		
		while (newsList.hasNext()) {
			result.add(newsList.next().toJson());
		}
		
		
		return ok(DataFormatUtil.toJsend("success", "news", result));
	}
	
	/**
	 * like this post or not
	 */
	public static Result like() {
		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<FashionNews> postParameter = Form.form(FashionNews.class)
				.bindFromRequest();
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "Wrong parameter"));
		
		if (!ObjectId.isValid(postParameter.get().getId()))
			return ok(DataFormatUtil.toJsend("fail", "wrong product id"));
		FashionNews dbNews = jacksonNewsCollection.findOneById(postParameter.get().getId());
		if (dbNews == null)
			return ok(DataFormatUtil.toJsend("fail",
					"this product is not exist"));

		User dbUser = UserController.userCollectionJackson.findOneById(session().get("id"));
		if (dbNews.getPeopleWhoLike().add(session().get("id"))) {
			dbNews.setLike(dbNews.getLike() + 1);
			dbUser.setStar(dbUser.getStar() + 1);
		} else {
			dbNews.getPeopleWhoLike().remove(session().get("id"));
			dbNews.setLike(dbNews.getLike() - 1);
			dbUser.setStar(dbUser.getStar() - 1);
		}
		UserController.userCollectionJackson.updateById(session().get("id"), dbUser);
		jacksonNewsCollection.updateById(postParameter.get().getId(), dbNews);

		return ok(DataFormatUtil.toJsend("success", dbNews.getLike()+""));
		
	}
	
}
