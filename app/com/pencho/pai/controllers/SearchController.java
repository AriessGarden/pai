package com.pencho.pai.controllers;

import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.mongojack.DBCursor;
import org.mongojack.DBQuery;
import org.mongojack.DBSort;

import play.mvc.Controller;
import play.mvc.Result;
import utils.DataFormatUtil;
import utils.SecurityUtil;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.pencho.pai.models.FashionHelp;
import com.pencho.pai.models.Product;
import com.pencho.pai.models.Shop;
import com.pencho.pai.models.User;

public class SearchController extends Controller {

	/**
	 * a tool for product search
	 * 
	 */

	public static Result findProductBy(String productProperty, String lowPrice, String highPrice, String priceOrder) {

		// if u login
//		if (!SecurityUtil.isLogin())
//			return ok(DataFormatUtil.toJsend("fail", "login first"));

		ArrayNode result = new ArrayNode(null);
		
		String[] fields = {"tags", "name", "description"};

		DBCursor<Product> productList = null;
		
		//get the low and high price range
		Double lowPri, highPri;
		
		if(lowPrice.equals("")){
			lowPri = 0.0;
		} else lowPri = Double.parseDouble(lowPrice);
		
		if(highPrice.equals("")){
			//select max(price) from product 
			highPri = 1000.0;
		}else highPri = Double.parseDouble(highPrice);
		
		// the main query body
		for (String field : fields) {

			if(priceOrder.equals("asc")){
				productList = ProductController.productCollectionJackson.find(DBQuery.and(
						 DBQuery.regex(field, Pattern.compile(".*" + productProperty + ".*")),
						 DBQuery.greaterThanEquals("price", lowPri),
						 DBQuery.lessThanEquals("price", highPri))).sort(DBSort.asc("price"));
				
			}else {
				productList = ProductController.productCollectionJackson.find(DBQuery.and(
						 DBQuery.regex(field, Pattern.compile(".*" + productProperty + ".*")),
						 DBQuery.greaterThanEquals("price", lowPri),
						 DBQuery.lessThanEquals("price", highPri))).sort(DBSort.desc("price"));
			}
			
			while (productList.hasNext()) {
				result.add(productList.next().toJson());
			}
		}

		return ok(DataFormatUtil.toJsend("success", "products", result));

	}
	
	
	/**
	 * utility method, find product by shop
	 */
	
	public static DBCursor<Product> findProductByShop(String shopID) {

		DBCursor<Product> productList = null;
		
		productList = ProductController.productCollectionJackson.find().is("shopID",shopID);
		
			//.sort(DBSort.asc("price"));
		return productList;
	}


	/**
	 * a tool for shop search
	 * 
	 */

	public static Result findShopBy(String shopProperty) {

		// // if u login
		// // if (!SecurityUtil.isLogin())
		// // return ok(DataFormatUtil.toJsend("fail", "login first"));

		ArrayNode result = new ArrayNode(null);

		String[] fields = {"tags", "description", "phone", "name"};

		DBCursor<Shop> shopList = null;

		// search shop by area/tags/description/phone/name
		
		for (String field : fields) {
			
			shopList = ShopController.shopCollectionJackson.find(
					DBQuery.regex(field, Pattern.compile(".*" + shopProperty + ".*"))
					);

			while (shopList.hasNext()) {
				result.add(shopList.next().toJson());
			}
		}

		return ok(DataFormatUtil.toJsend("success", "shops", result));
	}
	
	/**
	 * 
	 * 
	 */
	
	//find user by gender
	
	public static Result findUserByGender(String GenderStr) {
		

		// // if u login
//		if (!SecurityUtil.isLogin())
//		return ok(DataFormatUtil.toJsend("fail", "login first"));

		ArrayNode result = new ArrayNode(null);

		DBCursor<User> userList = null;
		
		if(GenderStr.equals("male")){
			userList = UserController.userCollectionJackson.find(DBQuery.is("gender", "male"));
		}else if (GenderStr.equals("female")){
			userList = UserController.userCollectionJackson.find(DBQuery.is("gender", "female"));
		}else{
			userList = UserController.userCollectionJackson.find();
		}

		while (userList.hasNext()) {
			result.add(userList.next().toJson());
		}

		return ok(DataFormatUtil.toJsend("success", "users", result));
	}
	
	
	public static Result findUserBy(String userProperty) {

		// // if u login
//		if (!SecurityUtil.isLogin())
//		return ok(DataFormatUtil.toJsend("fail", "login first"));

		ArrayNode result = new ArrayNode(null);

		// search shop by area/tags/description/phone/name/"gender",
		
		String[] fields = {"area", "phone", "name"};

		DBCursor<User> userList = null;

		for (String field : fields) {

			userList = UserController.userCollectionJackson.find(
					DBQuery.regex(field, Pattern.compile(".*" + userProperty + ".*"))
					);
		}
		
		while (userList.hasNext()) {
			result.add(userList.next().toJson());
		}

		return ok(DataFormatUtil.toJsend("success", "users", result));
	}
	
	
	

	/**
	 * a tool for friend search
	 * 
	 */

	public static Result findFriendBy(String friendProperty) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		User user = UserController.userCollectionJackson.findOneById(session().get("id"));

		Map<String, String> friends = user.getFriends();
		Set<String> friendIDset = friends.keySet();

		ArrayNode result = new ArrayNode(null);

		// gender|area|phone|name
		//"gender", "area",

		String[] fields = {"phone", "name", "gender"};

		DBCursor<User> friendList = null;
		
		for (String field : fields) {
			
//			if (field.equals("gender")){
//				
//				if(friendProperty.equals("male")){
//					friendList = UserController.userCollectionJackson.find(DBQuery.is("gender", "male"));
//				}else if (friendProperty.equals("female")){
//					friendList = UserController.userCollectionJackson.find(DBQuery.is("gender", "female"));
//				}
//			}
			
			// select phone/gender/name from user where userid in friendIDset
			friendList = UserController.userCollectionJackson.find(DBQuery.and(
					//DBQuery.is(field, friendProperty),
					DBQuery.regex(field, Pattern.compile(".*" + friendProperty + ".*")),
					DBQuery.in("_id", friendIDset)
					));
					
					//is(field, friendProperty).where(" {_id : { $in: " + friendIDset + "}}"));

			while (friendList.hasNext()) {
				result.add(friendList.next().toJson());
			}
		}

		return ok(DataFormatUtil.toJsend("success", "friends", result));
	}
	
	
	/**
	 * find friend by gender
	 */
	
	public static Result findFriendByGender(String GenderStr) {

		 // if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));
		
		User user = UserController.userCollectionJackson.findOneById(session().get("id"));

		Map<String, String> friends = user.getFriends();
		Set<String> friendIDset = friends.keySet();

		ArrayNode result = new ArrayNode(null);

		DBCursor<User> friendList = null;
		
//		friendList = UserController.userCollectionJackson.find(DBQuery.and(
//				//DBQuery.is(field, friendProperty),
//				DBQuery.regex(field, Pattern.compile(".*" + friendProperty + ".*")),
//				DBQuery.in("_id", friendIDset)
//				));
		
		if(GenderStr.equals("male")){
			friendList = UserController.userCollectionJackson.find(DBQuery.and(
				DBQuery.is("gender", "male"),
				DBQuery.in("_id", friendIDset)
				));

		}else if (GenderStr.equals("female")){
			friendList = UserController.userCollectionJackson.find(DBQuery.is("gender", "female"));
		}else{
			friendList = UserController.userCollectionJackson.find();
		}

		while (friendList.hasNext()) {
			result.add(friendList.next().toJson());
		}

		return ok(DataFormatUtil.toJsend("success", "users", result));
	}
	
	
	/**
	 * a tool for wishlist search
	 * @param wishlistProperty
	 * @return
	 */

	public static Result findWishlistBy(String wishlistProperty) {

		// if u login
		if (!SecurityUtil.isLogin())
			return ok(DataFormatUtil.toJsend("fail", "login first"));

		User user = UserController.userCollectionJackson.findOneById(session().get("id"));
		Set<String> wishlistIDs = user.getWishSet();
		System.out.println(wishlistIDs);

		ArrayNode result = new ArrayNode(null);

		// area|tag|description

		String[] fields = { "area", "tag", "name", "description" };
		
		DBCursor<Product> wishList = null;

		for (String field : fields) {

			wishList = ProductController.productCollectionJackson.find(DBQuery.and(
					//DBQuery.is(field, wishlistProperty),
					DBQuery.regex(field, Pattern.compile(".*" + wishlistProperty + ".*")),
					DBQuery.in("_id", wishlistIDs)
					));

			while (wishList.hasNext()) {
				result.add(wishList.next().toJson());
			}
		}

//		System.out.println(result);

		return ok(DataFormatUtil.toJsend("success", "wishlist", result));

	}
	
	/**
	 * a tool for FashionHelp search
	 * 
	 */

	public static Result findFashionHelpBy(String fashionHelpProperty) {

		// // if u login
		// // if (!SecurityUtil.isLogin())
		// // return ok(DataFormatUtil.toJsend("fail", "login first"));

		ArrayNode result = new ArrayNode(null);

		String[] fields = {"userName", "description"};

		DBCursor<FashionHelp> fashionHelpList = null;

		// search shop by area/tags/description/phone/name
		
		for (String field : fields) {
			
			fashionHelpList = FashionHelpController.helpCollectionJackson.find(
					DBQuery.regex(field, Pattern.compile(".*" + fashionHelpProperty + ".*"))
					);

			while (fashionHelpList.hasNext()) {
				result.add(fashionHelpList.next().toJson());
			}
		}

		return ok(DataFormatUtil.toJsend("success", "FashionHelp", result));
	}
}
