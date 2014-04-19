package com.pencho.pai.models;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;

import play.libs.Json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pencho.pai.controllers.ShopController;
import com.pencho.pai.controllers.UserController;

/**
 * 
 * @author aries
 * 
 */
public class Product {

	@org.mongojack.ObjectId
	@JsonProperty("_id")
	private String id;
	private String name;
	private String userID;
	private String userPictureID;
	private String userName;

	private String shopID;

	// TODO:Maybe there is not only one pic/vid/aud/text,so it will b changed
	// bellow.
	// TODO:Map<String,String> or List<String>
	private String pictureID = "";
	private String videoID = "";
	private String audioID = "";
	private String description = "";

	private String isSingleShop = "";
	private String secondShopID = "";

	private String isLike;// only for bind like value
	private Double like = 0.;
	private Double share = 0.;
	private Double price = 0.;
	private String trendyStyle = "false";// if trendy style true
	private Set<String> peopleWhoLike = new HashSet<String>();

	private String createTime;

	private String categories;
	private String brand;
	private String tag;// not usefull
	private String tag1;
	private String tag2;
	private String tag3;
	private Set<String> tags = new HashSet<String>();

	/**
	 * @author aries
	 * @return
	 */
	public ObjectNode toJson() {
		ObjectNode data = Json.newObject();
		data.put("id", id);
		data.put("name", name);
		// description
		data.put("description", description);
		data.put("userID", userID);
		User user = UserController.userCollectionJackson.findOneById(userID);
		data.put("userPictureID", user.getProfilePictureID());
		data.put("userName", user.getName());

		data.put("shopID", shopID);

		if (!"".equals(shopID) && ObjectId.isValid(shopID)) {
			Shop shop = ShopController.shopCollectionJackson
					.findOneById(shopID);
			if(shop != null)
			{
				if(!shop.getPictureIDList().isEmpty())
				data.put("shopPictureID", shop.getPictureIDList().get(0));
				data.put("shopName", shop.getName());
			}
		}
		data.put("pictureID", pictureID);
		data.put("videoID", videoID);
		data.put("audioID", audioID);
		data.put("isSingleShop", isSingleShop);
		data.put("secondShopID", secondShopID);
		data.put("like", like);

		if(peopleWhoLike.contains(UserController.session().get("id")))
			data.put("ilikeit", "true");
		else
			data.put("ilikeit", "false");

		data.put("share", share);
		data.put("price", price);
		data.put("tags", tags.toString());
		data.put("brand", brand);
		data.put("categories", categories);
		data.put("createTime", createTime);
		return data;
	}

	public Set<String> getPeopleWhoLike() {
		return peopleWhoLike;
	}

	public void setPeopleWhoLike(Set<String> peopleWhoLike) {
		this.peopleWhoLike = peopleWhoLike;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getShopID() {
		return shopID;
	}

	public void setShopID(String shopID) {
		this.shopID = shopID;
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

	public String getPictureID() {
		return pictureID;
	}

	public void setPictureID(String pictureID) {
		this.pictureID = pictureID;
	}

	public String getVideoID() {
		return videoID;
	}

	public void setVideoID(String videoID) {
		this.videoID = videoID;
	}

	public String getAudioID() {
		return audioID;
	}

	public void setAudioID(String audioID) {
		this.audioID = audioID;
	}

	public Double getLike() {
		return like;
	}

	public void setLike(Double like) {
		this.like = like;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTag1() {
		return tag1;
	}

	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}

	public String getTag2() {
		return tag2;
	}

	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}

	public String getTag3() {
		return tag3;
	}

	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public String getCreateTime() {
		return createTime;
	}

	public String getIsSingleShop() {
		return isSingleShop;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setIsSingleShop(String isSingleShop) {
		this.isSingleShop = isSingleShop;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getIsLike() {
		return isLike;
	}

	public void setIsLike(String isLike) {
		this.isLike = isLike;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUserPictureID() {
		return userPictureID;
	}

	public void setUserPictureID(String userPictureID) {
		this.userPictureID = userPictureID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSecondShopID() {
		return secondShopID;
	}

	public void setSecondShopID(String secondShopID) {
		this.secondShopID = secondShopID;
	}

	public String getTrendyStyle() {
		return trendyStyle;
	}

	public void setTrendyStyle(String trendyStyle) {
		this.trendyStyle = trendyStyle;
	}

	/**
	 * @return the share
	 */
	public Double getShare() {
		return share;
	}

	/**
	 * @param share
	 *            the share to set
	 */
	public void setShare(Double share) {
		this.share = share;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag
	 *            the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

}
