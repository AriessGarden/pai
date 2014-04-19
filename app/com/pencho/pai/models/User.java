package com.pencho.pai.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import play.libs.Json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 
 * @author Aries
 * 
 */
public class User {

	@org.mongojack.ObjectId
	@JsonProperty("_id")
	private String id;

	private String phone;
	private String name;
	private Boolean validated = false;// for account validation
	private Boolean reValidated = false;
	private Boolean signup = false;
	private String profilePictureID;
	private String coverPictureID;
	private String createTime;
	private String password;
	private Set<String> wishSet = new HashSet<String>();
	private Boolean superUser = false;

	private String status;
	private String sms;
	private String gender;
	private String birthday = "1970-01-01";
	private String age;
	private Double star = 0.;
	private String shopID;
	
	//PAI LEVEL FASHION ATTRIBUTE
	private int numberOfPostCreated = 0;//TODO decrease when delete a post but delete function not implemented yet
	private int numberOfLike = 0;
	private int numberOfFollower = 0;//TODO decrease when delete a post but delete function not implemented yet
	private int numberOfShare = 0;
	
	//DIVA = LVL9
	static final private int DIVA_POST_USER = 18888;
	static final private int DIVA_LIKE_USER = 88888;
	static final private int DIVA_FOLLOWER_USER = 1888;
	static final private int DIVA_SHARES_USER = 6888;
	//GLITTERATI = LVL8
	static final private int GLITTERATI_POST_USER = 9000;
	static final private int GLITTERATI_LIKE_USER = 25000;
	static final private int GLITTERATI_FOLLOWER_USER = 1500;
	static final private int GLITTERATI_SHARES_USER = 3500;
	//DESIGNER = LVL7
	static final private int DESIGNER_POST_USER = 5000;
	static final private int DESIGNER_LIKE_USER = 9000;
	static final private int DESIGNER_FOLLOWER_USER = 900;
	static final private int DESIGNER_SHARES_USER = 1500;
	//TRENDSETTER = LVL6
	static final private int TRENDSETTER_POST_USER = 2000;
	static final private int TRENDSETTER_LIKE_USER = 5000;
	static final private int TRENDSETTER_FOLLOWER_USER = 500;
	static final private int TRENDSETTER_SHARES_USER = 900;
	//STYLIST = LVL5
	static final private int STYLIST_POST_USER = 900;
	static final private int STYLIST_LIKE_USER = 3500;
	static final private int STYLIST_FOLLOWER_USER = 80;
	static final private int STYLIST_SHARES_USER = 150;
	//WOWZER = LVL4
	static final private int WOWZER_POST_USER = 300;
	static final private int WOWZER_LIKE_USER = 1500;
	static final private int WOWZER_FOLLOWER_USER = 50;
	static final private int WOWZER_SHARES_USER = 90;
	//MODEL = LVL3
	static final private int MODEL_POST_USER = 90;
	static final private int MODEL_LIKE_USER = 450;
	static final private int MODEL_FOLLOWER_USER = 20;
	static final private int MODEL_SHARES_USER = 30;
	//CHIC = LVL2
	static final private int CHIC_POST_USER = 6;
	static final private int CHIC_LIKE_USER = 10;
	static final private int CHIC_FOLLOWER_USER = 2;
	static final private int CHIC_SHARES_USER = 0;
	//FASHIONBLOGGER = LVL1
	static final private int FASHIONBLOGGER_POST_USER = 5;
	static final private int FASHIONBLOGGER_LIKE_USER = 10;
	static final private int FASHIONBLOGGER_FOLLOWER_USER = 1;
	static final private int FASHIONBLOGGER_SHARES_USER = 0;


	
	private Set<String> shopsIShared = new HashSet<String>();
	private Set<String> shopsILike = new HashSet<String>();
	private Set<String> shopsIFollow = new HashSet<String>();

	// people who follow me
	private String followUserID;
	private Set<String> followUserIDSet = new HashSet<String>();

	// people who i followed
	private String bFollowedUserID;
	private Set<String> bFollowedUserIDSet = new HashSet<String>();

	private String friend;
	// Map<String(userID),String(true)>
	private Map<String, String> friends = new HashMap<String, String>();

	public String getCoverPictureID() {
		return coverPictureID;
	}

	public void setCoverPictureID(String coverPictureID) {
		this.coverPictureID = coverPictureID;
	}

	private String aversion;
	private List<String> blackList = new ArrayList<String>();

	private Set<String> fashionHelpSaved = new HashSet<String>();

	/**
	 * return json user
	 * 
	 * @author Aries
	 * @return
	 */
	public ObjectNode toJson() {
		if (!superUser) // exclude the master user
		{
			ObjectNode data = Json.newObject();
			data.put("id", id);
			data.put("name", name);
			data.put("gender", gender);
			data.put("phone", phone);
			data.put("shopID", shopID);
			data.put("profilePictureID", profilePictureID);
			data.put("coverPictureID", coverPictureID);
			data.put("status", status);
			data.put("gender", gender);
			data.put("age", age);
			data.put("gender", gender);
			data.put("numberOfFollower", numberOfFollower);
			data.put("shopID", shopID);
			data.put("numberOfFollower", numberOfFollower);

			data.put("createTime", createTime);
			data.put("friends", friends.toString());
			return data;
		}
		return null;
	}

	// private String sharedMoment;
	// private List<String> sharedMoments = new ArrayList<String>();
	// private String collectedMoment;
	// private List<String> collectedMoments = new ArrayList<String>();
	// private String sharedProject;
	// private List<String> sharedProjects = new ArrayList<String>();
	// private String collectedProject;
	// private List<String> collectedProjects = new ArrayList<String>();
	// private String collectedCloset;
	// private List<String> collectedClosets = new ArrayList<String>();
	// private String sharedCloset;
	// private List<String> sharedClosets = new ArrayList<String>();
	// private Map<String, String[]> answerProjects = new HashMap<String,
	// String[]>();
	// private String sharedClassifieds;
	// private List<String> sharedClassifiedss = new ArrayList<String>();
	// private String collectedClassifieds;
	// private List<String> collectedClassifiedss = new ArrayList<String>();
	// private String sharedIdea;
	// private List<String> sharedIdeas = new ArrayList<String>();
	// private String collectedIdea;
	// private List<String> collectedIdeas = new ArrayList<String>();
	// private String sharedJob;
	// private List<String> sharedJobs = new ArrayList<String>();
	// private String collectedJob;
	// private List<String> collectedJobs = new ArrayList<String>();

	// private String location;
	// private String profession;
	// private String email;
	// private String job;
	// private String degree;
	// private String university;
	// private String self_evaluation;

	public Boolean getSuperUser() {
		return superUser;
	}

	public void setSuperUser(Boolean superUser) {
		this.superUser = superUser;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Boolean getSignup() {
		return signup;
	}

	public void setSignup(Boolean signup) {
		this.signup = signup;
	}

	public String getProfilePictureID() {
		return profilePictureID;
	}

	public void setProfilePictureID(String profilePictureID) {
		this.profilePictureID = profilePictureID;
	}

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public String getStatus() {
		return status;
	}

	public Set<String> getShopsIShared() {
		return shopsIShared;
	}

	public void setShopsIShared(Set<String> shopsIShared) {
		this.shopsIShared = shopsIShared;
	}

	public Set<String> getShopsILike() {
		return shopsILike;
	}

	public void setShopsILike(Set<String> shopsILike) {
		this.shopsILike = shopsILike;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFriend() {
		return friend;
	}

	public void setFriend(String friend) {
		this.friend = friend;
	}

	public Map<String, String> getFriends() {
//		ObjectMapper mapper = new ObjectMapper();
//		Map<String, String> friends = mapper.readValue(jsonSource, Map.class);
		return friends;
	}

	public void setFriends(Map<String, String> friends) {
		this.friends = friends;
	}
	

	public String getAversion() {
		return aversion;
	}

	public void setAversion(String aversion) {
		this.aversion = aversion;
	}

	public List<String> getBlackList() {
		return blackList;
	}

	public void setBlackList(List<String> blackList) {
		this.blackList = blackList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getValidated() {
		return validated;
	}

	public Set<String> getFashionHelpSaved() {
		return fashionHelpSaved;
	}

	public void setFashionHelpSaved(Set<String> fashionHelpSaved) {
		this.fashionHelpSaved = fashionHelpSaved;
	}

	public void setValidated(Boolean validated) {
		this.validated = validated;
	}

	public String getbFollowedUserID() {
		return bFollowedUserID;
	}

	public void setbFollowedUserID(String bFollowedUserID) {
		this.bFollowedUserID = bFollowedUserID;
	}

	public Double getStar() {
		return star;
	}

	public void setStar(Double star) {
		this.star = star;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreateTime() {
		return createTime;
	}

	public Boolean getReValidated() {
		return reValidated;
	}

	public void setReValidated(Boolean reValidated) {
		this.reValidated = reValidated;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getFollowUserID() {
		return followUserID;
	}

	public Set<String> getWishSet() {
		return wishSet;
	}

	public void setWishSet(Set<String> wishSet) {
		this.wishSet = wishSet;
	}

	public void setFollowUserID(String followUserID) {
		this.followUserID = followUserID;
	}

	public Set<String> getFollowUserIDSet() {
		return followUserIDSet;
	}

	public void setFollowUserIDSet(Set<String> followUserIDSet) {
		this.followUserIDSet = followUserIDSet;
	}

	public Set<String> getbFollowedUserIDSet() {
		return bFollowedUserIDSet;
	}

	public void setbFollowedUserIDSet(Set<String> bFollowedUserIDSet) {
		this.bFollowedUserIDSet = bFollowedUserIDSet;
	}

	public String getShopID() {
		return shopID;
	}

	public void setShopID(String shopID) {
		this.shopID = shopID;
	}

	public int getNumberOfPostCreated() {
		return numberOfPostCreated;
	}

	public void setNumberOfPostCreated(int numberOfPpostCreated) {
		this.numberOfPostCreated = numberOfPpostCreated;
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

	public static int getDivaPostUser() {
		return DIVA_POST_USER;
	}

	public static int getDivaLikeUser() {
		return DIVA_LIKE_USER;
	}

	public static int getDivaFollowerUser() {
		return DIVA_FOLLOWER_USER;
	}

	public static int getDivaSharesUser() {
		return DIVA_SHARES_USER;
	}

	public static int getGlitteratiPostUser() {
		return GLITTERATI_POST_USER;
	}

	public static int getGlitteratiLikeUser() {
		return GLITTERATI_LIKE_USER;
	}

	public static int getGlitteratiFollowerUser() {
		return GLITTERATI_FOLLOWER_USER;
	}

	public static int getGlitteratiSharesUser() {
		return GLITTERATI_SHARES_USER;
	}

	public static int getDesignerPostUser() {
		return DESIGNER_POST_USER;
	}

	public static int getDesignerLikeUser() {
		return DESIGNER_LIKE_USER;
	}

	public static int getDesignerFollowerUser() {
		return DESIGNER_FOLLOWER_USER;
	}

	public static int getDesignerSharesUser() {
		return DESIGNER_SHARES_USER;
	}

	public static int getTrendsetterPostUser() {
		return TRENDSETTER_POST_USER;
	}

	public static int getTrendsetterLikeUser() {
		return TRENDSETTER_LIKE_USER;
	}

	public static int getTrendsetterFollowerUser() {
		return TRENDSETTER_FOLLOWER_USER;
	}

	public static int getTrendsetterSharesUser() {
		return TRENDSETTER_SHARES_USER;
	}

	public static int getStylistPostUser() {
		return STYLIST_POST_USER;
	}

	public static int getStylistLikeUser() {
		return STYLIST_LIKE_USER;
	}

	public static int getStylistFollowerUser() {
		return STYLIST_FOLLOWER_USER;
	}

	public static int getStylistSharesUser() {
		return STYLIST_SHARES_USER;
	}

	public static int getWowzerPostUser() {
		return WOWZER_POST_USER;
	}

	public static int getWowzerLikeUser() {
		return WOWZER_LIKE_USER;
	}

	public static int getWowzerFollowerUser() {
		return WOWZER_FOLLOWER_USER;
	}

	public static int getWowzerSharesUser() {
		return WOWZER_SHARES_USER;
	}

	public static int getModelPostUser() {
		return MODEL_POST_USER;
	}

	public static int getModelLikeUser() {
		return MODEL_LIKE_USER;
	}

	public static int getModelFollowerUser() {
		return MODEL_FOLLOWER_USER;
	}

	public static int getModelSharesUser() {
		return MODEL_SHARES_USER;
	}

	public static int getChicPostUser() {
		return CHIC_POST_USER;
	}

	public static int getChicLikeUser() {
		return CHIC_LIKE_USER;
	}

	public static int getChicFollowerUser() {
		return CHIC_FOLLOWER_USER;
	}

	public static int getChicSharesUser() {
		return CHIC_SHARES_USER;
	}

	public static int getFashionbloggerPostUser() {
		return FASHIONBLOGGER_POST_USER;
	}

	public static int getFashionbloggerLikeUser() {
		return FASHIONBLOGGER_LIKE_USER;
	}

	public static int getFashionbloggerFollowerUser() {
		return FASHIONBLOGGER_FOLLOWER_USER;
	}

	public static int getFashionbloggerSharesUser() {
		return FASHIONBLOGGER_SHARES_USER;
	}

	public Set<String> getShopsIFollow() {
		return shopsIFollow;
	}

	public void setShopsIFollow(Set<String> shopsIFollow) {
		this.shopsIFollow = shopsIFollow;
	}
	
	
}
