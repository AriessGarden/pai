package com.pencho.pai.models;

import java.util.HashSet;
import java.util.Set;

import play.libs.Json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pencho.pai.controllers.UserController;

/**
 * 
 * @author sandy
 * 
 */
public class SnapShot {

	@org.mongojack.ObjectId
	@JsonProperty("_id")
	private String id;
	private String userID = "";
	private String pictureID = "";

	private String isPublic = "true";

	private Set<String> peopleWhoLike = new HashSet<String>();
	private String isLike;// only for bind like value
	private Double like = 0.;
	private Double share = 0.;

	private String createTime;

	/**
	 * @author sandy
	 * @return
	 */
	public ObjectNode toJson() {
		ObjectNode data = Json.newObject();
		data.put("id", id);
		data.put("userID", userID);
		data.put("pictureID", pictureID);
		data.put("isPublic", isPublic);
		data.put("like", like);
		if(peopleWhoLike.contains(UserController.session().get("id")))
			data.put("ilikeit", "true");
		else
			data.put("ilikeit", "false");
		
		data.put("share", share);
		data.put("createTime", createTime);
		return data;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
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

	public Double getLike() {
		return like;
	}

	public void setLike(Double like) {
		this.like = like;
	}

	public String getCreateTime() {
		return createTime;
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

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

	/**
	 * @return the share
	 */
	public Double getShare() {
		return share;
	}

	/**
	 * @param share the share to set
	 */
	public void setShare(Double share) {
		this.share = share;
	}

	public Set<String> getPeopleWhoLike() {
		return peopleWhoLike;
	}

	public void setPeopleWhoLike(Set<String> peopleWhoLike) {
		this.peopleWhoLike = peopleWhoLike;
	}

}
