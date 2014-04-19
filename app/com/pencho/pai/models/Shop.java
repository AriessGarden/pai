package com.pencho.pai.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pencho.pai.controllers.UserController;

/**
 * 
 * @author aries
 * 
 */
public class Shop {

	// just for test git
	@org.mongojack.ObjectId
	@JsonProperty("_id")
	private String id;
	
	private String name;
	private String userID;
	private String createTime;
	private String location;
	private double[] loc = {};
	private double longitude;
	private double latitude;
	private String categories;

	private String tag;
	private Set<String> tags = new HashSet<String>();
	//add phone, by Bill
	private String phone;
	private String description;
	private boolean exist = false;
	private Set<String> peopleWhoLike = new HashSet<String>();
	private String isLike;
	private Double like = 0.;
	private String isShare;
	private Double share = 0.;
	private List<String> pictureIDList = new ArrayList<String>();
	private List<String> videoIDList = new ArrayList<String>();
	
	public Shop() {}

	//PAI LEVEL FASHION ATTRIBUTE
	private int numberOfLike = 0;//TODO   decrement numberOfLike variable 
	private int numberOfFollower = 0;//TODO  decrement numberOfFollower variable when delete
	private int numberOfShare = 0;//TODO   decrement numberOfShare variable 


	//DIVA = LVL9
	static final private int DIVA_LIKE_SHOP = 88888;
	static final private int DIVA_FOLLOWER_SHOP = 5888;
	static final private int DIVA_SHARES_SHOP = 18888;
	//GLITTERATI = LVL8
	static final private int GLITTERATI_LIKE_SHOP = 55550;
	static final private int GLITTERATI_FOLLOWER_SHOP = 5000;
	static final private int GLITTERATI_SHARES_SHOP = 5500;
	//DESIGNER = LVL7
	static final private int DESIGNER_LIKE_SHOP = 13550;
	static final private int DESIGNER_FOLLOWER_SHOP = 1300;
	static final private int DESIGNER_SHARES_SHOP = 3550;
	//TRENDSETTER = LVL6
	static final private int TRENDSETTER_LIKE_SHOP = 7550;
	static final private int TRENDSETTER_FOLLOWER_SHOP = 600;
	static final private int TRENDSETTER_SHARES_SHOP = 1550;
	//STYLIST = LVL5
	static final private int STYLIST_LIKE_SHOP = 4500;
	static final private int STYLIST_FOLLOWER_SHOP = 150;
	static final private int STYLIST_SHARES_SHOP = 350;
	//WOWZER = LVL4
	static final private int WOWZER_LIKE_SHOP = 1550;
	static final private int WOWZER_FOLLOWER_SHOP = 90;
	static final private int WOWZER_SHARES_SHOP = 150;
	//MODEL = LVL3
	static final private int MODEL_LIKE_SHOP = 500;
	static final private int MODEL_FOLLOWER_SHOP = 60;
	static final private int MODEL_SHARES_SHOP = 60;
	//CHIC = LVL2
	static final private int CHIC_LIKE_SHOP = 50;
	static final private int CHIC_FOLLOWER_SHOP = 10;
	static final private int CHIC_SHARES_SHOP = 1;
	//FASHIONBLOGGER = LVL1
	static final private int FASHIONBLOGGER_LIKE_SHOP = 10;
	static final private int FASHIONBLOGGER_FOLLOWER_SHOP = 1;
	static final private int FASHIONBLOGGER_SHARES_SHOP = 0;

	// people who followe me
	private String followShopID;
	private Set<String> followShopIDSet = new HashSet<String>();
	
	// people who i followed
	private String bFollowedShopID;
	private Set<String> bFollowedShopIDSet = new HashSet<String>();

	/**
	 * @author aries
	 * @return
	 */
	
	// search shop by area/tags/description/phone/name
	
	public ObjectNode toJson() {
		ObjectNode data = Json.newObject();
		data.put("id", id);
		data.put("name", name);
		//		data.put("userName",
//				UserController.userCollectionJackson.findOneById(userID)
//						.getName());
//		data.put("userID", userID);
		data.put("location", location);
		data.put("longitude", longitude);
		data.put("latitude", latitude);
		data.put("categories", categories);
		data.put("phone", phone);
		data.put("description", description);
		data.put("tags", tags.toString());
		try {
			data.put("picture", pictureIDList.get(0));
			data.put("coverPicture", pictureIDList.get(1));
		} catch (Exception e) {
			play.Logger.info("he/she don't have pic");
		}
		data.put("videoCount", videoIDList.size());
		data.put("videoIDList", videoIDList.toString());
		data.put("createTime", createTime);
		data.put("like", like);
		if(peopleWhoLike.contains(UserController.session().get("id")))
			data.put("ilikeit", "true");
		else
			data.put("ilikeit", "false");
		data.put("share", share);
		data.put("numbersOfFollower", UserController.userCollectionJackson
				.findOneById(Controller.session().get("id"))
				.getbFollowedUserIDSet().size());
		return data;
	}


	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLocation() {
		return location;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public List<String> getPictureIDList() {
		return pictureIDList;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public void setPictureIDList(List<String> pictureIDList) {
		this.pictureIDList = pictureIDList;
	}

	public String getIsLike() {
		return isLike;
	}

	public void setIsLike(String isLike) {
		this.isLike = isLike;
	}

	public Double getLike() {
		return like;
	}

	public void setLike(Double like) {
		this.like = like;
	}

	public String getIsShare() {
		return isShare;
	}

	public void setIsShare(String isShare) {
		this.isShare = isShare;
	}

	public Double getShare() {
		return share;
	}

	public void setShare(Double share) {
		this.share = share;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public List<String> getVideoIDList() {
		return videoIDList;
	}

	public void setVideoIDList(List<String> videoIDList) {
		this.videoIDList = videoIDList;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}



	public double[] getLoc() {
		return loc;
	}



	public void setLoc(double[] loc) {
		this.loc = loc;
	}



	public int getNumberOfLike() {
		return numberOfLike;
	}



	public void setNumberOfLike(int numberOfLike) {
		this.numberOfLike = numberOfLike;
	}



	public int getNumberOfFollower() {
		return numberOfFollower;
	}



	public void setNumberOfFollower(int numberOfFollower) {
		this.numberOfFollower = numberOfFollower;
	}



	public int getNumberOfShare() {
		return numberOfShare;
	}



	public void setNumberOfShare(int numberOfShare) {
		this.numberOfShare = numberOfShare;
	}



	public static int getDivaLikeShop() {
		return DIVA_LIKE_SHOP;
	}



	public static int getDivaFollowerShop() {
		return DIVA_FOLLOWER_SHOP;
	}



	public static int getDivaSharesShop() {
		return DIVA_SHARES_SHOP;
	}



	public static int getGlitteratiLikeShop() {
		return GLITTERATI_LIKE_SHOP;
	}



	public static int getGlitteratiFollowerShop() {
		return GLITTERATI_FOLLOWER_SHOP;
	}



	public static int getGlitteratiSharesShop() {
		return GLITTERATI_SHARES_SHOP;
	}



	public static int getDesignerLikeShop() {
		return DESIGNER_LIKE_SHOP;
	}



	public static int getDesignerFollowerShop() {
		return DESIGNER_FOLLOWER_SHOP;
	}



	public static int getDesignerSharesShop() {
		return DESIGNER_SHARES_SHOP;
	}



	public static int getTrendsetterLikeShop() {
		return TRENDSETTER_LIKE_SHOP;
	}



	public static int getTrendsetterFollowerShop() {
		return TRENDSETTER_FOLLOWER_SHOP;
	}



	public static int getTrendsetterSharesShop() {
		return TRENDSETTER_SHARES_SHOP;
	}



	public static int getStylistLikeShop() {
		return STYLIST_LIKE_SHOP;
	}



	public static int getStylistFollowerShop() {
		return STYLIST_FOLLOWER_SHOP;
	}



	public static int getStylistSharesShop() {
		return STYLIST_SHARES_SHOP;
	}



	public static int getWowzerLikeShop() {
		return WOWZER_LIKE_SHOP;
	}



	public static int getWowzerFollowerShop() {
		return WOWZER_FOLLOWER_SHOP;
	}



	public static int getWowzerSharesShop() {
		return WOWZER_SHARES_SHOP;
	}



	public static int getModelLikeShop() {
		return MODEL_LIKE_SHOP;
	}



	public static int getModelFollowerShop() {
		return MODEL_FOLLOWER_SHOP;
	}



	public static int getModelSharesShop() {
		return MODEL_SHARES_SHOP;
	}



	public static int getChicLikeShop() {
		return CHIC_LIKE_SHOP;
	}



	public static int getChicFollowerShop() {
		return CHIC_FOLLOWER_SHOP;
	}



	public static int getChicSharesShop() {
		return CHIC_SHARES_SHOP;
	}



	public static int getFashionbloggerLikeShop() {
		return FASHIONBLOGGER_LIKE_SHOP;
	}



	public static int getFashionbloggerFollowerShop() {
		return FASHIONBLOGGER_FOLLOWER_SHOP;
	}



	public static int getFashionbloggerSharesShop() {
		return FASHIONBLOGGER_SHARES_SHOP;
	}



	public String getbFollowedShopID() {
		return bFollowedShopID;
	}



	public void setbFollowedShopID(String bFollowedShopID) {
		this.bFollowedShopID = bFollowedShopID;
	}



	public Set<String> getbFollowedShopIDSet() {
		return bFollowedShopIDSet;
	}



	public void setbFollowedShopIDSet(Set<String> bFollowedShopIDSet) {
		this.bFollowedShopIDSet = bFollowedShopIDSet;
	}



	public String getFollowShopID() {
		return followShopID;
	}



	public void setFollowShopID(String followShopID) {
		this.followShopID = followShopID;
	}



	public Set<String> getFollowShopIDSet() {
		return followShopIDSet;
	}



	public void setFollowShopIDSet(Set<String> followShopIDSet) {
		this.followShopIDSet = followShopIDSet;
	}



	public Set<String> getPeopleWhoLike() {
		return peopleWhoLike;
	}



	public void setPeopleWhoLike(Set<String> peopleWhoLike) {
		this.peopleWhoLike = peopleWhoLike;
	}
	
	
}