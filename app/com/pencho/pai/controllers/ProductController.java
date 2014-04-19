package com.pencho.pai.controllers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.bson.types.ObjectId;
import org.mongojack.DBCursor;
import org.mongojack.DBQuery;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import play.Logger;
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
import com.pencho.pai.models.Product;
import com.pencho.pai.models.User;

/**
 * 
 * @author aries
 * 
 */
public class ProductController extends Controller {
	public static final DBCollection productCollection = DAO.database
			.getCollection("product");
	public static final JacksonDBCollection<Product, String> productCollectionJackson = JacksonDBCollection
			.wrap(productCollection, Product.class, String.class);

	/**
	 * create product
	 * 
	 * @author aries
	 * @return
	 */
	public static Result create() {
		// if u login
		if (!SecurityUtil.isLogin())

			return ok(DataFormatUtil.toJsend("fail", "Login first!"));
		Form<Product> postParameter = Form.form(Product.class)
				.bindFromRequest();

		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		Product post = postParameter.get();
		post.setUserID(session().get("id"));
		// add user info
		User user = UserController.userCollectionJackson.findOneById(session()
				.get("id"));
		post.setUserID(session().get("id"));
		post.setUserPictureID(user.getProfilePictureID());
		post.setUserName(user.getName());
		post.setShopID(user.getShopID());
		post.setCreateTime(DataFormatUtil.getNow());

		Set<String> tags = new HashSet<String>();
		if ("" != post.getTag1().trim())
			tags.add(post.getTag1().trim());
		if ("" != post.getTag2().trim())
			tags.add(post.getTag2().trim());
		if ("" != post.getTag3().trim())
			tags.add(post.getTag3().trim());
		post.setTags(tags);

		WriteResult<Product, String> saved = productCollectionJackson
				.insert(post);

		return ok(DataFormatUtil.toJsend("success", saved.getSavedId()));
	}

	/**
	 * delete your product
	 * 
	 * @author sandy
	 * @return
	 */
	public static Result delete() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<Product> postParameter = Form.form(Product.class)
				.bindFromRequest();

		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		Product post = postParameter.get();

		Product productdb = productCollectionJackson.findOneById(post.getId());
		if (session().get("id").contains(productdb.getUserID())) {
			if (productdb != null)
				productCollectionJackson.removeById(post.getId());
			return ok(DataFormatUtil.toJsend("success", ""));
		}
		return ok(DataFormatUtil.toJsend("success",
				"you can not delete this is not yours"));

	}

	/**
	 * edit your product
	 * 
	 * @author sandy
	 * @return
	 */
	public static Result edit() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<Product> postParameter = Form.form(Product.class)
				.bindFromRequest();

		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		Product post = postParameter.get();

		if ("" == post.getId())
			return ok(DataFormatUtil.toJsend("fail", "id don't exist"));
		Product productdb = productCollectionJackson.findOneById(post.getId());
		if (null == productdb)
			return ok(DataFormatUtil.toJsend("fail", "product don't exist"));

		if (session().get("id").contains(productdb.getUserID())) {
			if ("" != post.getVideoID())
				productdb.setVideoID(post.getVideoID());
			if ("" != post.getAudioID())
				productdb.setAudioID(post.getAudioID());
			if ("" != post.getName())
				productdb.setName(post.getName());
			if ("" != post.getCategories())
				productdb.setCategories(post.getCategories());
			if ("" != post.getDescription())
				productdb.setDescription(post.getDescription());
			if ("" != post.getBrand())
				productdb.setBrand(post.getBrand());
			if ("" != post.getTrendyStyle())
				productdb.setTrendyStyle(post.getTrendyStyle());
			if (!post.getPrice().isNaN())
				productdb.setPrice(post.getPrice());
			Set<String> tags = new HashSet<String>();
			if ("" != post.getTag1())
				productdb.setTag1(post.getTag1());
			if ("" != post.getTag2())
				productdb.setTag2(post.getTag2());
			if ("" != post.getTag3())
				productdb.setTag3(post.getTag3());

			Object result = productCollectionJackson.updateById(
					productdb.getId(), productdb);
			return ok(DataFormatUtil.toJsend("success", "update successfully"));
		}
		return ok(DataFormatUtil.toJsend("success",
				"you can not edit this is not yours"));
	}

	/**
	 * find product by shopid
	 * 
	 * @author aries
	 * @return
	 */
	public static Result findByShopID(int start, int end) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<Product> postParameter = Form.form(Product.class)
				.bindFromRequest();

		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "wrong parameter"));
		Product post = postParameter.get();
		String shopID = post.getShopID();

		if (!ObjectId.isValid(shopID))
			return ok(DataFormatUtil.toJsend("fail", "wrong id"));
		if (ShopController.shopCollectionJackson.findOneById(shopID) == null)
			return ok(DataFormatUtil.toJsend("fail", "Shop is not exist"));

		start -= 1;
		ArrayNode result = new ArrayNode(null);
		DBCursor<Product> productList = productCollectionJackson.find(DBQuery
				.is("shopID", shopID));
		productList = productList.sort(new BasicDBObject("createTime", -1))
				.limit(start + end).skip(start);
		while (productList.hasNext()) {
			result.add(productList.next().toJson());
		}

		return ok(DataFormatUtil.toJsend("success", "Product", result));
	}

	/**
	 * find product by shopid
	 * 
	 * @author sandy
	 * @return
	 */
	public static Result findTrendyStyleByShopID(String shopID, int start,
			int end) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		if (!ObjectId.isValid(shopID))
			return ok(DataFormatUtil.toJsend("fail", "wrong id"));
		if (ShopController.shopCollectionJackson.findOneById(shopID) == null)
			return ok(DataFormatUtil.toJsend("fail", "Shop is not exist"));

		start -= 1;
		ArrayNode result = new ArrayNode(null);
		DBCursor<Product> productList = productCollectionJackson.find(DBQuery
				.is("shopID", shopID));
		productList = productList.sort(new BasicDBObject("createTime", -1))
				.limit(start + end).skip(start);
		while (productList.hasNext()) {
			Product prod = productList.next();
			if ("true".equals(prod.getTrendyStyle()))
				result.add(prod.toJson());
		}

		return ok(DataFormatUtil.toJsend("success", "Product", result));
	}

	/**
	 * like this product or not
	 * 
	 * @author sandy
	 * @return
	 */
	public static Result like() {
		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<Product> postParameter = Form.form(Product.class)
				.bindFromRequest();
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "Wrong parameter"));
		String pproductID = postParameter.get().getId();
		if (!ObjectId.isValid(pproductID))
			return ok(DataFormatUtil.toJsend("fail", "wrong product id"));
		Product dbProduct = productCollectionJackson.findOneById(pproductID);
		if (dbProduct == null)
			return ok(DataFormatUtil.toJsend("fail",
					"this product is not exist"));

		UsersAuthorityUtil.inBlockListAction(dbProduct.getUserID());

		User dbUser = UserController.userCollectionJackson
				.findOneById(dbProduct.getUserID());
		if (dbProduct.getPeopleWhoLike().add(session().get("id"))) {
			dbProduct.setLike(dbProduct.getLike() + 1);
			dbUser.setStar(dbUser.getStar() + 1);
		} else {
			dbProduct.getPeopleWhoLike().remove(session().get("id"));
			dbProduct.setLike(dbProduct.getLike() - 1);
			dbUser.setStar(dbUser.getStar() - 1);
		}
		UserController.userCollectionJackson.updateById(dbProduct.getUserID(),
				dbUser);
		productCollectionJackson.updateById(pproductID, dbProduct);

		return ok(DataFormatUtil.toJsend("success", dbProduct.getLike() + ""));
	}

	/**
	 * find product by product id
	 * 
	 * @author Aries
	 * @return
	 */
	public static Result findByID() {
		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<Product> postParameter = Form.form(Product.class)
				.bindFromRequest();
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "Wrong parameter"));
		String productID = postParameter.get().getId();
		if (!ObjectId.isValid(productID))
			return ok(DataFormatUtil.toJsend("fail", "wrong product id"));
		Product dbProduct = productCollectionJackson.findOneById(productID);
		if (dbProduct == null)
			return ok(DataFormatUtil.toJsend("fail",
					"this product is not exist"));
		return ok(DataFormatUtil.toJsend("success", "info", dbProduct.toJson()));
	}

	/**
	 * getHot product
	 * 
	 * @author sandy
	 * @return
	 */
	public static Result getHot(int start, int end) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		start -= 1;

		ArrayNode result = new ArrayNode(null);
		DBCursor<Product> productList = productCollectionJackson.find()
				.sort(new BasicDBObject("like", -1)).limit(start + end)
				.skip(start);

		while (productList.hasNext()) {
			result.add(productList.next().toJson());
		}
		return ok(DataFormatUtil.toJsend("success", "product", result));

	}

	/**
	 * add 2 wish list
	 * 
	 * @author Aries
	 * @return
	 */
	public static Result add2WishList() {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<Product> postParameter = Form.form(Product.class)
				.bindFromRequest();
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "Wrong parameter"));
		String productID = postParameter.get().getId();
		if (!ObjectId.isValid(productID))
			return ok(DataFormatUtil.toJsend("fail", "wrong product id"));

		User dbUser = UserController.userCollectionJackson
				.findOneById(session().get("id"));
		if (dbUser.getWishSet().add(productID)) {
			UserController.userCollectionJackson.updateById(
					session().get("id"), dbUser);
			return ok(DataFormatUtil.toJsend("success", ""));
		} else
			return ok(DataFormatUtil.toJsend("fail",
					"u have already keep this wish"));
	}

	/**
	 * remove a product from wish-list
	 * 
	 * @author aries
	 * @param product
	 *            id
	 * @return
	 */
	public static Result removeFromWishList() {
		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		Form<Product> postParameter = Form.form(Product.class)
				.bindFromRequest();
		if (postParameter.hasErrors())
			return ok(DataFormatUtil.toJsend("fail", "Wrong parameter"));
		String productID = postParameter.get().getId();
		if (!ObjectId.isValid(productID))
			return ok(DataFormatUtil.toJsend("fail", "wrong product id"));

		User dbUser = UserController.userCollectionJackson
				.findOneById(session().get("id"));
		Set<String> wishSet = dbUser.getWishSet();
		boolean flag = wishSet.remove(productID);

		if (flag) {
			dbUser.setWishSet(wishSet);
			UserController.userCollectionJackson.updateById(
					session().get("id"), dbUser);
			return ok(DataFormatUtil.toJsend("success", ""));
		}
		return ok(DataFormatUtil.toJsend("fail",
				"product is not in ur wish-list"));
	}

	/**
	 * get wish list
	 * 
	 * @author Sandy
	 * @return
	 */
	public static Result wishListOfUserID(String userID, int start, int end) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "Login first!"));

		start -= 1;

		User dbUser = UserController.userCollectionJackson.findOneById(userID);
		Set<String> wish = dbUser.getWishSet();
		ArrayNode result = new ArrayNode(null);

		for (Iterator<String> iterator = wish.iterator(); iterator.hasNext();) {
			String wishID = iterator.next();
			Product productList = productCollectionJackson.findOneById(wishID);
			if (productList != null)
				result.add(productList.toJson());
		}

		return ok(DataFormatUtil.toJsend("success", "product", result));
	}

}
