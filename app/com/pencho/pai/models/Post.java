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
public class Post {

	@org.mongojack.ObjectId
	@JsonProperty("_id")
	private String id;
	private String userID;
	private String userPictureID;
	private String userName;

	// TODO:Maybe there is not only one pic/vid/aud/text,so it will b changed
	// bellow.
	// TODO:Map<String,String> or List<String>
	private String pictureID = ""; 
	private String videoID = "";
	private String audioID = "";
	private String description = "";

	private String isLike;// only for bind like value
	private Double like = 0.;
	private Double share = 0.;
	private Set<String> peopleWhoLike = new HashSet<String>();


	private String isPublic = "false";

	private String showOff = "false";
	private String createTime;

	private String shareOfPostID = "";
	private String shareOfProductID = "";
	private String shareOfSnapShotID = "";
	private String shareOfWardrobeID = "";

	private String categories;
	private String brand;
	private String tag1;
	private String tag2;
	private String tag3;
	private Set<String> tags = new HashSet<String>();
	
	
	
	/**
	 * @author sandy
	 * @return
	 */
	public ObjectNode toJson() {
		ObjectNode data = Json.newObject();
		data.put("id", id);
		data.put("userID", userID);
		User user = UserController.userCollectionJackson.findOneById(userID);
		data.put("userPictureID", user.getProfilePictureID());
		data.put("userName", user.getName());
		
		data.put("description", description);
		data.put("pictureID", pictureID);
		data.put("videoID", videoID);
		data.put("audioID", audioID);
		data.put("like", like);
		
		if(peopleWhoLike.contains(UserController.session().get("id")))
			data.put("ilikeit", "true");
		else
			data.put("ilikeit", "false");
		
		data.put("share", share);
		data.put("createTime", createTime);
		data.put("shareOfPostID", shareOfPostID);
		data.put("shareOfProductID", shareOfProductID);
		data.put("isPublic", isPublic);
		data.put("showOff", showOff);
		data.put("tags", tags.toString());
		data.put("brand", brand);
		data.put("categories", categories);
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

	public String getIsLike() {
		return isLike;
	}

	public void setIsLike(String isLike) {
		this.isLike = isLike;
	}

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getShowOff() {
		return showOff;
	}

	public void setShowOff(String showOff) {
		this.showOff = showOff;
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

	public String getShareOfPostID() {
		return shareOfPostID;
	}

	public void setShareOfPostID(String shareOfPostID) {
		this.shareOfPostID = shareOfPostID;
	}

	public String getShareOfProductID() {
		return shareOfProductID;
	}

	public void setShareOfProductID(String shareOfProductID) {
		this.shareOfProductID = shareOfProductID;
	}

	public String getShareOfSnapShotID() {
		return shareOfSnapShotID;
	}

	public void setShareOfSnapShotID(String shareOfSnapShotID) {
		this.shareOfSnapShotID = shareOfSnapShotID;
	}

	public String getShareOfWardrobeID() {
		return shareOfWardrobeID;
	}

	public void setShareOfWardrobeID(String shareOfWardrobeID) {
		this.shareOfWardrobeID = shareOfWardrobeID;
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

	/**
	 * @return the categories
	 */
	public String getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(String categories) {
		this.categories = categories;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the tag1
	 */
	public String getTag1() {
		return tag1;
	}

	/**
	 * @param tag1 the tag1 to set
	 */
	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}

	/**
	 * @return the tag2
	 */
	public String getTag2() {
		return tag2;
	}

	/**
	 * @param tag2 the tag2 to set
	 */
	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}

	/**
	 * @return the tag3
	 */
	public String getTag3() {
		return tag3;
	}

	/**
	 * @param tag3 the tag3 to set
	 */
	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}

	/**
	 * @return the tags
	 */
	public Set<String> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
}
