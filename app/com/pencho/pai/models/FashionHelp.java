package com.pencho.pai.models;

import java.util.HashSet;
import java.util.Set;

import play.libs.Json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pencho.pai.controllers.UserController;

/**
 * 
 * @author Bill
 * 
 */
public class FashionHelp {

	@org.mongojack.ObjectId
	@JsonProperty("_id")
	private String id;
	
	private String userID;
	private String userPictureID = ""; 
	private String userName = "";
	private String isLike;
	private Double like = 0.;
	private Set<String> peopleWhoLike = new HashSet<String>();
	private String pictureID = "";
	private String description = "";
	//change data type of numberOfComments to int
	private Double numberOfComments = 0.;

	
	public ObjectNode toJson() {
		ObjectNode data = Json.newObject();
		data.put("id", id);
		data.put("userID", userID);
		User user = UserController.userCollectionJackson.findOneById(userID);
		data.put("userPictureID", user.getProfilePictureID());
		data.put("userName", user.getName());
		data.put("pictureID", pictureID);
		data.put("description",description);
		data.put("peopleWhoLike", peopleWhoLike.toString());
		data.put("theNumberOfLike", like);
		data.put("numberOfComments", numberOfComments);
		return data;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getPictureID() {
		return pictureID;
	}
	public void setPictureID(String pictureID) {
		this.pictureID = pictureID;
	}
	public String getDescription() {
		return description;
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

	public Set<String> getPeopleWhoLike() {
		return peopleWhoLike;
	}

	public void setPeopleWhoLike(Set<String> peopleWhoLike) {
		this.peopleWhoLike = peopleWhoLike;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getNumberOfComments() {
		return numberOfComments;
	}

	public void setNumberOfComments(Double numberOfComments) {
		this.numberOfComments = numberOfComments;
	}
}
