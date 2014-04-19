package com.pencho.pai.models;

import play.libs.Json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pencho.pai.controllers.UserController;

/**
 * 
 * @author aries
 * 
 */
public class Comment {

	@org.mongojack.ObjectId
	@JsonProperty("_id")
	private String id;
	private String userID;
	private String userPictureID;
	private String userName;
	private String productID;
	private String postID;
	private String helpID;
	// TODO:Maybe there is not only one pic/vid/aud/text,so it will b changed
	// bellow.
	// TODO:Map<String,String> or List<String>
	private String pictureID;
	private String videoID;
	private String audioID;
	private String description;

	private String createTime;

	/**
	 * @author aries
	 * @return
	 */
	public ObjectNode toJson() {
		ObjectNode data = Json.newObject();
		data.put("id", id);
		data.put("userID", userID);
		User user = UserController.userCollectionJackson.findOneById(userID);
		data.put("userPictureID", user.getProfilePictureID());
		data.put("userName", user.getName());
		
		data.put("productID", productID);
		data.put("postID", postID);
		data.put("helpID", helpID);
		data.put("pictureID", pictureID);
		data.put("videoID", videoID);
		data.put("audioID", audioID);
		data.put("description", description);
		data.put("createTime", createTime);
		return data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPostID() {
		return postID;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getHelpID() {
		return helpID;
	}

	public void setHelpID(String helpID) {
		this.helpID = helpID;
	}

	/**
	 * @return the userPictureID
	 */
	public String getUserPictureID() {
		return userPictureID;
	}

	/**
	 * @param userPictureID the userPictureID to set
	 */
	public void setUserPictureID(String userPictureID) {
		this.userPictureID = userPictureID;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
