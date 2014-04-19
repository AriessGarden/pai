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
public class Wardrobe {

	@org.mongojack.ObjectId
	@JsonProperty("_id")
	private String id;
	private String userID = "";
	private String pictureID = "";

	private String isPublic = "true";
	private String isOnlyMe = "false";


	private Set<String> peopleWhoLike = new HashSet<String>();
	private String isLike;// only for bind like value
	private Double like = 0.;
	private Double share = 0.;

	private String categoryTag = "";
	private String brandTag = "";
	private Set<String> colors = new HashSet<String>();
	private String tag;// not usefull
	private String tag1 = "";
	private String tag2 = "";
	private String tag3 = "";
	private Set<String> tags = new HashSet<String>();

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
		data.put("isOnlyMe", isOnlyMe);
		data.put("like", like);
		
		if(peopleWhoLike.contains(UserController.session().get("id")))
			data.put("ilikeit", "true");
		else
			data.put("ilikeit", "false");
		
		data.put("share", share);
		data.put("categoryTag", categoryTag);
		data.put("brandTag", brandTag);
		data.put("colors", colors.toString());
		data.put("tags", tags.toString());
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
	 * @param share
	 *            the share to set
	 */
	public void setShare(Double share) {
		this.share = share;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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

	/**
	 * @return the isOnlyMe
	 */
	public String getIsOnlyMe() {
		return isOnlyMe;
	}

	/**
	 * @param isOnlyMe
	 *            the isOnlyMe to set
	 */
	public void setIsOnlyMe(String isOnlyMe) {
		this.isOnlyMe = isOnlyMe;
	}

	public Set<String> getPeopleWhoLike() {
		return peopleWhoLike;
	}

	public void setPeopleWhoLike(Set<String> peopleWhoLike) {
		this.peopleWhoLike = peopleWhoLike;
	}

	public String getCategoryTag() {
		return categoryTag;
	}

	public void setCategoryTag(String categoryTag) {
		this.categoryTag = categoryTag;
	}

	public String getBrandTag() {
		return brandTag;
	}

	public void setBrandTag(String brandTag) {
		this.brandTag = brandTag;
	}

	public Set<String> getColors() {
		return colors;
	}

	public void setColors(Set<String> colors) {
		this.colors = colors;
	}

}
