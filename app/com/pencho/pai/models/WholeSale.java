package com.pencho.pai.models;

import play.libs.Json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 
 * @author aries
 * 
 */
public class WholeSale {

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
	private Double price;
	private String trendyStyle = "false";// if trendy style true

	private String createTime;

	/**
	 * @author aries
	 * @return
	 */
	public ObjectNode toJson() {
		ObjectNode data = Json.newObject();
		data.put("id", id);
		data.put("name", name);
		data.put("userID", userID);
		data.put("userPictureID", userPictureID);
		data.put("userName", userName);
		data.put("shopID", shopID);
		data.put("pictureID", pictureID);
		data.put("videoID", videoID);
		data.put("audioID", audioID);
		data.put("isSingleShop", isSingleShop);
		data.put("secondShopID", secondShopID);
		data.put("like", like);
		data.put("price", price);
		data.put("createTime", createTime);
		return data;
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

	public String getCreateTime() {
		return createTime;
	}


	public String getIsSingleShop() {
		return isSingleShop;
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
}
