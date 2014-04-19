package com.pencho.pai.models;

import play.libs.Json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pencho.pai.controllers.UserController;

/**
 * 
 * @author sandy
 * 
 */
public class Message {

	@org.mongojack.ObjectId
	@JsonProperty("_id")
	private String id;
	private String fromUserID;
	private String toUserID;
	private String userPictureID = "";
	private String userName = "";

	private String pictureID = "";
	private String audioID = "";
	private String description = "";

	private String createTime;
	
	private String productID = "";// for shop send product

	/**
	 * @author sandy
	 * @return
	 */
	public ObjectNode toJson() {
		ObjectNode data = Json.newObject();
		data.put("id", id);
		data.put("fromUserID", fromUserID);
		data.put("toUserID", toUserID);

		User user = UserController.userCollectionJackson.findOneById(fromUserID);
		data.put("userPictureID", user.getProfilePictureID());
		data.put("userName", user.getName());
		
		data.put("pictureID", pictureID);
		data.put("audioID", audioID);
		data.put("description", description);
		data.put("createTime", createTime);
		data.put("productID", productID);
		return data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPictureID() {
		return pictureID;
	}

	public void setPictureID(String pictureID) {
		this.pictureID = pictureID;
	}

	public String getAudioID() {
		return audioID;
	}

	public void setAudioID(String audioID) {
		this.audioID = audioID;
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

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getFromUserID() {
		return fromUserID;
	}

	public void setFromUserID(String fromUserID) {
		this.fromUserID = fromUserID;
	}

	public String getToUserID() {
		return toUserID;
	}

	public void setToUserID(String toUserID) {
		this.toUserID = toUserID;
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

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}
}
