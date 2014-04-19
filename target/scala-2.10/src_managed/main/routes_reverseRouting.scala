// @SOURCE:/home/aries/git/pai_mongodb/conf/routes
// @HASH:04e0e9e4e6c13369bbd47eb4d8b44da39f67a416
// @DATE:Tue Feb 25 13:55:27 CST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:6
package controllers {

// @LINE:6
class ReverseAssets {
    

// @LINE:6
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  

// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:165
// @LINE:162
// @LINE:161
// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:156
// @LINE:155
// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
// @LINE:143
// @LINE:142
// @LINE:141
// @LINE:140
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:131
// @LINE:130
// @LINE:129
// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:104
// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
package com.pencho.pai.controllers {

// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:89
// @LINE:88
// @LINE:87
class ReverseFashionHelpController {
    

// @LINE:89
def delete(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "help/delete")
}
                                                

// @LINE:91
def saveHelp(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "help/saveHelp")
}
                                                

// @LINE:88
def edit(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "help/edit")
}
                                                

// @LINE:87
def create(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "help/create")
}
                                                

// @LINE:94
def like(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "help/like")
}
                                                

// @LINE:93
def getSavedHelp(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "help/getSavedHelp")
}
                                                

// @LINE:90
def get(start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "help/get" + queryString(List(if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                

// @LINE:92
def unsaveHelp(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "help/unsaveHelp")
}
                                                
    
}
                          

// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
class ReverseWardrobeController {
    

// @LINE:173
def create(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "wardrobe/create")
}
                                                

// @LINE:175
def like(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "wardrobe/like")
}
                                                

// @LINE:176
def destroy(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "wardrobe/destroy")
}
                                                

// @LINE:174
def getByUserID(userID:String, start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "wardrobe/getByUserID" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("userID", userID)), if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                

// @LINE:177
def get(wardrobeID:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "wardrobe/get" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("wardrobeID", wardrobeID)))))
}
                                                
    
}
                          

// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
class ReverseSnapShotController {
    

// @LINE:147
def create(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "snapshot/create")
}
                                                

// @LINE:149
def like(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "snapshot/like")
}
                                                

// @LINE:150
def destroy(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "snapshot/destroy")
}
                                                

// @LINE:148
def getByUserID(userID:String, start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "snapshot/getByUserID" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("userID", userID)), if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                

// @LINE:151
def get(snapshotID:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "snapshot/get" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("snapshotID", snapshotID)))))
}
                                                
    
}
                          

// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:104
// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
class ReverseProductController {
    

// @LINE:100
def delete(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "product/delete")
}
                                                

// @LINE:107
def wishListOfUserID(userID:String, start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "product/wishListOfUserID" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("userID", userID)), if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                

// @LINE:99
def edit(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "product/edit")
}
                                                

// @LINE:108
def removeFromWishList(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "product/removeFromWishList")
}
                                                

// @LINE:98
def create(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "product/create")
}
                                                

// @LINE:103
def like(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "product/like")
}
                                                

// @LINE:105
def findByID(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "product/findByID")
}
                                                

// @LINE:104
def getHot(start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "product/getHot" + queryString(List(if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                

// @LINE:101
def findByShopID(start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "product/findByShopID" + queryString(List(if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                

// @LINE:102
def findTrendyStyleByShopID(shopID:String, start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "product/findTrendyStyleByShopID" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("shopID", shopID)), if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                

// @LINE:106
def add2WishList(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "product/add2WishList")
}
                                                
    
}
                          

// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
class ReverseUserController {
    

// @LINE:53
def findFriendsUnaudited(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/findFriendsUnaudited")
}
                                                

// @LINE:54
def find(phone:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/find" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("phone", phone)))))
}
                                                

// @LINE:41
def redoValidateSMS(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/redoValidateSMS")
}
                                                

// @LINE:42
def createPsw(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/createPsw")
}
                                                

// @LINE:52
def getBlackList(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/getBlackList")
}
                                                

// @LINE:58
def whoFollowMe(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/whoFollowMe" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("id", id)))))
}
                                                

// @LINE:55
def findFriends(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/findFriends")
}
                                                

// @LINE:44
def createProfile(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/createProfile")
}
                                                

// @LINE:63
def myUserLevel(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/myUserLevel")
}
                                                

// @LINE:38
def sendSMS(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/sendSMS")
}
                                                

// @LINE:51
def deleteUserFromFriendList(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/deleteUserFromFriendList")
}
                                                

// @LINE:57
def follow(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/follow")
}
                                                

// @LINE:59
def whoIFollowed(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/whoIFollowed" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("id", id)))))
}
                                                

// @LINE:48
def addFriend(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/addFriend")
}
                                                

// @LINE:49
def add2BlackList(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/add2BlackList")
}
                                                

// @LINE:60
def whoShopIFollowed(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/whoShopIFollowed" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("id", id)))))
}
                                                

// @LINE:61
def findByUsername(username:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/findByUsername" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("username", username)))))
}
                                                

// @LINE:43
def recreatePsw(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/recreatePsw")
}
                                                

// @LINE:56
def findUserByID(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/findUserByID")
}
                                                

// @LINE:40
def doValidateSMS(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/doValidateSMS")
}
                                                

// @LINE:62
def unfollow(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/unfollow")
}
                                                

// @LINE:45
def getStarOfTheDay(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/getStarOfTheDay")
}
                                                

// @LINE:46
def replyFriendRequest(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/replyFriendRequest")
}
                                                

// @LINE:64
def myInformations(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/myInformations")
}
                                                

// @LINE:47
def update(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/update")
}
                                                

// @LINE:39
def resendSMS(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user/resendSMS")
}
                                                

// @LINE:50
def deleteUserFromBlackList(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/deleteUserFromBlackList")
}
                                                
    
}
                          

// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
class ReverseFileManager {
    

// @LINE:34
def getFile(filesType:String, file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "file/" + implicitly[PathBindable[String]].unbind("filesType", dynamicString(filesType)) + "/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                

// @LINE:32
def destroyFile(filesType:String, file:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "file/" + implicitly[PathBindable[String]].unbind("filesType", dynamicString(filesType)) + "/destroy/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                

// @LINE:31
def createFile(filesType:String, width:Integer = 256, length:Integer = 144, width2:Integer = 512, length2:Integer = 288): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "file/" + implicitly[PathBindable[String]].unbind("filesType", dynamicString(filesType)) + "/new" + queryString(List(if(width == 256) None else Some(implicitly[QueryStringBindable[Integer]].unbind("width", width)), if(length == 144) None else Some(implicitly[QueryStringBindable[Integer]].unbind("length", length)), if(width2 == 512) None else Some(implicitly[QueryStringBindable[Integer]].unbind("width2", width2)), if(length2 == 288) None else Some(implicitly[QueryStringBindable[Integer]].unbind("length2", length2)))))
}
                                                

// @LINE:33
def getMyFile(filesType:String, page:Integer = 1, nbObjectByPage:Integer = 50): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "file/" + implicitly[PathBindable[String]].unbind("filesType", dynamicString(filesType)) + "/mine" + queryString(List(if(page == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("page", page)), if(nbObjectByPage == 50) None else Some(implicitly[QueryStringBindable[Integer]].unbind("nbObjectByPage", nbObjectByPage)))))
}
                                                
    
}
                          

// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseApplication {
    

// @LINE:20
def help(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "help")
}
                                                

// @LINE:18
def news(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "news")
}
                                                

// @LINE:26
def wardrobe(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "wardrobe")
}
                                                

// @LINE:25
def share(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "share")
}
                                                

// @LINE:19
def post(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "post")
}
                                                

// @LINE:23
def message(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "message")
}
                                                

// @LINE:12
def MyStatus(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "MyStatus")
}
                                                

// @LINE:17
def product(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "product")
}
                                                

// @LINE:21
def shop(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "shop")
}
                                                

// @LINE:11
def user(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "user")
}
                                                

// @LINE:14
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:16
def comment(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "comment")
}
                                                

// @LINE:24
def snapShot(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "snapShot")
}
                                                

// @LINE:15
def file(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "file")
}
                                                

// @LINE:22
def search(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "search")
}
                                                

// @LINE:10
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:13
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:27
def wholeSale(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "wholeSale")
}
                                                
    
}
                          

// @LINE:143
// @LINE:142
// @LINE:141
// @LINE:140
class ReverseMessageController {
    

// @LINE:143
def destroy(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "message/destroy")
}
                                                

// @LINE:140
def create(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "message/create")
}
                                                

// @LINE:141
def getMy(start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "message/getMy" + queryString(List(if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                

// @LINE:142
def getMessageSend(start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "message/getMessageSend" + queryString(List(if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                
    
}
                          

// @LINE:162
// @LINE:161
// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:156
// @LINE:155
class ReverseSearchController {
    

// @LINE:161
def findWishlistBy(wishlistProperty:String = ""): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "search/wishlist" + queryString(List(if(wishlistProperty == "") None else Some(implicitly[QueryStringBindable[String]].unbind("wishlistProperty", wishlistProperty)))))
}
                                                

// @LINE:156
def findShopBy(shopProperty:String = ""): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "search/shop" + queryString(List(if(shopProperty == "") None else Some(implicitly[QueryStringBindable[String]].unbind("shopProperty", shopProperty)))))
}
                                                

// @LINE:157
def findUserBy(userProperty:String = ""): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "search/user" + queryString(List(if(userProperty == "") None else Some(implicitly[QueryStringBindable[String]].unbind("userProperty", userProperty)))))
}
                                                

// @LINE:159
def findFriendBy(friendProperty:String = ""): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "search/friend" + queryString(List(if(friendProperty == "") None else Some(implicitly[QueryStringBindable[String]].unbind("friendProperty", friendProperty)))))
}
                                                

// @LINE:158
def findUserByGender(genderStr:String = ""): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "search/sortUserByGender" + queryString(List(if(genderStr == "") None else Some(implicitly[QueryStringBindable[String]].unbind("genderStr", genderStr)))))
}
                                                

// @LINE:160
def findFriendByGender(genderStr:String = ""): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "search/friendByGender" + queryString(List(if(genderStr == "") None else Some(implicitly[QueryStringBindable[String]].unbind("genderStr", genderStr)))))
}
                                                

// @LINE:155
def findProductBy(productProperty:String = "", lowPrice:String = "", highPrice:String = "", priceOrder:String = ""): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "search/product" + queryString(List(if(productProperty == "") None else Some(implicitly[QueryStringBindable[String]].unbind("productProperty", productProperty)), if(lowPrice == "") None else Some(implicitly[QueryStringBindable[String]].unbind("lowPrice", lowPrice)), if(highPrice == "") None else Some(implicitly[QueryStringBindable[String]].unbind("highPrice", highPrice)), if(priceOrder == "") None else Some(implicitly[QueryStringBindable[String]].unbind("priceOrder", priceOrder)))))
}
                                                

// @LINE:162
def findFashionHelpBy(fashionHelpProperty:String = ""): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "search/fashionHelp" + queryString(List(if(fashionHelpProperty == "") None else Some(implicitly[QueryStringBindable[String]].unbind("fashionHelpProperty", fashionHelpProperty)))))
}
                                                
    
}
                          

// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
class ReversePostController {
    

// @LINE:114
def delete(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "post/delete")
}
                                                

// @LINE:120
def getAllFromUserID(userID:String, start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "post/getAllFromUserID" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("userID", userID)), if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                

// @LINE:113
def edit(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "post/edit")
}
                                                

// @LINE:112
def create(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "post/create")
}
                                                

// @LINE:121
def like(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "post/like")
}
                                                

// @LINE:116
def getPublic(start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "post/getPublic" + queryString(List(if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                

// @LINE:117
def getFollower(start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "post/getFollower" + queryString(List(if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                

// @LINE:119
def getShowOff(userID:String, start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "post/getShowOff" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("userID", userID)), if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                

// @LINE:118
def getFriend(start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "post/getFriend" + queryString(List(if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                

// @LINE:115
def get(postID:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "post/get" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("postID", postID)))))
}
                                                
    
}
                          

// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:131
// @LINE:130
// @LINE:129
// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:125
class ReverseShopController {
    

// @LINE:128
def drop(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "shop/drop")
}
                                                

// @LINE:135
def share(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "shop/share")
}
                                                

// @LINE:130
def like(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "shop/like")
}
                                                

// @LINE:132
def follow(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "shop/follow")
}
                                                

// @LINE:127
def getShopById(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "shop/getShopById")
}
                                                

// @LINE:126
def getMine(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "shop/getMine")
}
                                                

// @LINE:129
def revert(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "shop/revert")
}
                                                

// @LINE:125
def set(pic1:String = "", pic2:String = "", video1:String = "", video2:String = "", video3:String = "", video4:String = "", video5:String = "", video6:String = ""): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "shop/set" + queryString(List(if(pic1 == "") None else Some(implicitly[QueryStringBindable[String]].unbind("pic1", pic1)), if(pic2 == "") None else Some(implicitly[QueryStringBindable[String]].unbind("pic2", pic2)), if(video1 == "") None else Some(implicitly[QueryStringBindable[String]].unbind("video1", video1)), if(video2 == "") None else Some(implicitly[QueryStringBindable[String]].unbind("video2", video2)), if(video3 == "") None else Some(implicitly[QueryStringBindable[String]].unbind("video3", video3)), if(video4 == "") None else Some(implicitly[QueryStringBindable[String]].unbind("video4", video4)), if(video5 == "") None else Some(implicitly[QueryStringBindable[String]].unbind("video5", video5)), if(video6 == "") None else Some(implicitly[QueryStringBindable[String]].unbind("video6", video6)))))
}
                                                

// @LINE:133
def unfollow(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "shop/unfollow")
}
                                                

// @LINE:134
def myShopLevel(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "shop/myShopLevel")
}
                                                

// @LINE:131
def getShopAround(radius:Double = 1, longitude:Double = 50, latitude:Double = 50): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "shop/getShopAround" + queryString(List(if(radius == 1) None else Some(implicitly[QueryStringBindable[Double]].unbind("radius", radius)), if(longitude == 50) None else Some(implicitly[QueryStringBindable[Double]].unbind("longitude", longitude)), if(latitude == 50) None else Some(implicitly[QueryStringBindable[Double]].unbind("latitude", latitude)))))
}
                                                
    
}
                          

// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
class ReverseCommentController {
    

// @LINE:71
def delete(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "comment/delete")
}
                                                

// @LINE:72
def edit(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "comment/edit")
}
                                                

// @LINE:70
def create(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "comment/create")
}
                                                

// @LINE:76
def findByProductID(productID:String, start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "comment/findByProductID" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("productID", productID)), if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                

// @LINE:74
def findByHelpID(helpID:String, start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "comment/findByHelpID" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("helpID", helpID)), if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                

// @LINE:73
def findByUserID(start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "comment/findByUserID" + queryString(List(if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                

// @LINE:75
def findByPostID(postID:String, start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "comment/findByPostID" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("postID", postID)), if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                
    
}
                          

// @LINE:83
// @LINE:82
// @LINE:81
class ReverseFashionNewsController {
    

// @LINE:82
def get(start:Integer = 1, end:Integer = 16): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "news/get" + queryString(List(if(start == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("start", start)), if(end == 16) None else Some(implicitly[QueryStringBindable[Integer]].unbind("end", end)))))
}
                                                

// @LINE:81
def create(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "news/create")
}
                                                

// @LINE:83
def like(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "news/like")
}
                                                
    
}
                          

// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:165
class ReverseShareController {
    

// @LINE:168
def shareOfSnapShot(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "share/snapshot")
}
                                                

// @LINE:169
def shareOfWardrobe(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "share/wardrobe")
}
                                                

// @LINE:167
def shareOfProduct(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "share/product")
}
                                                

// @LINE:165
def getByUserID(userID:String = "", theType:String = ""): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "share/getByUserID" + queryString(List(if(userID == "") None else Some(implicitly[QueryStringBindable[String]].unbind("userID", userID)), if(theType == "") None else Some(implicitly[QueryStringBindable[String]].unbind("theType", theType)))))
}
                                                

// @LINE:166
def shareOfPost(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "share/post")
}
                                                
    
}
                          
}
                  


// @LINE:6
package controllers.javascript {

// @LINE:6
class ReverseAssets {
    

// @LINE:6
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              
}
        

// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:165
// @LINE:162
// @LINE:161
// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:156
// @LINE:155
// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
// @LINE:143
// @LINE:142
// @LINE:141
// @LINE:140
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:131
// @LINE:130
// @LINE:129
// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:104
// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
package com.pencho.pai.controllers.javascript {

// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:89
// @LINE:88
// @LINE:87
class ReverseFashionHelpController {
    

// @LINE:89
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.FashionHelpController.delete",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "help/delete"})
      }
   """
)
                        

// @LINE:91
def saveHelp : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.FashionHelpController.saveHelp",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "help/saveHelp"})
      }
   """
)
                        

// @LINE:88
def edit : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.FashionHelpController.edit",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "help/edit"})
      }
   """
)
                        

// @LINE:87
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.FashionHelpController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "help/create"})
      }
   """
)
                        

// @LINE:94
def like : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.FashionHelpController.like",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "help/like"})
      }
   """
)
                        

// @LINE:93
def getSavedHelp : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.FashionHelpController.getSavedHelp",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "help/getSavedHelp"})
      }
   """
)
                        

// @LINE:90
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.FashionHelpController.get",
   """
      function(start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "help/get" + _qS([(start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        

// @LINE:92
def unsaveHelp : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.FashionHelpController.unsaveHelp",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "help/unsaveHelp"})
      }
   """
)
                        
    
}
              

// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
class ReverseWardrobeController {
    

// @LINE:173
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.WardrobeController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "wardrobe/create"})
      }
   """
)
                        

// @LINE:175
def like : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.WardrobeController.like",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "wardrobe/like"})
      }
   """
)
                        

// @LINE:176
def destroy : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.WardrobeController.destroy",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "wardrobe/destroy"})
      }
   """
)
                        

// @LINE:174
def getByUserID : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.WardrobeController.getByUserID",
   """
      function(userID,start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "wardrobe/getByUserID" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("userID", userID), (start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        

// @LINE:177
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.WardrobeController.get",
   """
      function(wardrobeID) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "wardrobe/get" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("wardrobeID", wardrobeID)])})
      }
   """
)
                        
    
}
              

// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
class ReverseSnapShotController {
    

// @LINE:147
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.SnapShotController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "snapshot/create"})
      }
   """
)
                        

// @LINE:149
def like : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.SnapShotController.like",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "snapshot/like"})
      }
   """
)
                        

// @LINE:150
def destroy : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.SnapShotController.destroy",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "snapshot/destroy"})
      }
   """
)
                        

// @LINE:148
def getByUserID : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.SnapShotController.getByUserID",
   """
      function(userID,start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "snapshot/getByUserID" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("userID", userID), (start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        

// @LINE:151
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.SnapShotController.get",
   """
      function(snapshotID) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "snapshot/get" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("snapshotID", snapshotID)])})
      }
   """
)
                        
    
}
              

// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:104
// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
class ReverseProductController {
    

// @LINE:100
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ProductController.delete",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "product/delete"})
      }
   """
)
                        

// @LINE:107
def wishListOfUserID : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ProductController.wishListOfUserID",
   """
      function(userID,start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product/wishListOfUserID" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("userID", userID), (start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        

// @LINE:99
def edit : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ProductController.edit",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "product/edit"})
      }
   """
)
                        

// @LINE:108
def removeFromWishList : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ProductController.removeFromWishList",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "product/removeFromWishList"})
      }
   """
)
                        

// @LINE:98
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ProductController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "product/create"})
      }
   """
)
                        

// @LINE:103
def like : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ProductController.like",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "product/like"})
      }
   """
)
                        

// @LINE:105
def findByID : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ProductController.findByID",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product/findByID"})
      }
   """
)
                        

// @LINE:104
def getHot : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ProductController.getHot",
   """
      function(start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product/getHot" + _qS([(start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        

// @LINE:101
def findByShopID : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ProductController.findByShopID",
   """
      function(start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product/findByShopID" + _qS([(start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        

// @LINE:102
def findTrendyStyleByShopID : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ProductController.findTrendyStyleByShopID",
   """
      function(shopID,start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product/findTrendyStyleByShopID" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("shopID", shopID), (start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        

// @LINE:106
def add2WishList : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ProductController.add2WishList",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "product/add2WishList"})
      }
   """
)
                        
    
}
              

// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
class ReverseUserController {
    

// @LINE:53
def findFriendsUnaudited : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.findFriendsUnaudited",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/findFriendsUnaudited"})
      }
   """
)
                        

// @LINE:54
def find : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.find",
   """
      function(phone) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/find" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("phone", phone)])})
      }
   """
)
                        

// @LINE:41
def redoValidateSMS : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.redoValidateSMS",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/redoValidateSMS"})
      }
   """
)
                        

// @LINE:42
def createPsw : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.createPsw",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/createPsw"})
      }
   """
)
                        

// @LINE:52
def getBlackList : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.getBlackList",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/getBlackList"})
      }
   """
)
                        

// @LINE:58
def whoFollowMe : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.whoFollowMe",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/whoFollowMe" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:55
def findFriends : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.findFriends",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/findFriends"})
      }
   """
)
                        

// @LINE:44
def createProfile : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.createProfile",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/createProfile"})
      }
   """
)
                        

// @LINE:63
def myUserLevel : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.myUserLevel",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/myUserLevel"})
      }
   """
)
                        

// @LINE:38
def sendSMS : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.sendSMS",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/sendSMS"})
      }
   """
)
                        

// @LINE:51
def deleteUserFromFriendList : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.deleteUserFromFriendList",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/deleteUserFromFriendList"})
      }
   """
)
                        

// @LINE:57
def follow : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.follow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/follow"})
      }
   """
)
                        

// @LINE:59
def whoIFollowed : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.whoIFollowed",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/whoIFollowed" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:48
def addFriend : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.addFriend",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/addFriend"})
      }
   """
)
                        

// @LINE:49
def add2BlackList : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.add2BlackList",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/add2BlackList"})
      }
   """
)
                        

// @LINE:60
def whoShopIFollowed : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.whoShopIFollowed",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/whoShopIFollowed" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:61
def findByUsername : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.findByUsername",
   """
      function(username) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/findByUsername" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("username", username)])})
      }
   """
)
                        

// @LINE:43
def recreatePsw : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.recreatePsw",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/recreatePsw"})
      }
   """
)
                        

// @LINE:56
def findUserByID : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.findUserByID",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/findUserByID"})
      }
   """
)
                        

// @LINE:40
def doValidateSMS : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.doValidateSMS",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/doValidateSMS"})
      }
   """
)
                        

// @LINE:62
def unfollow : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.unfollow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/unfollow"})
      }
   """
)
                        

// @LINE:45
def getStarOfTheDay : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.getStarOfTheDay",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/getStarOfTheDay"})
      }
   """
)
                        

// @LINE:46
def replyFriendRequest : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.replyFriendRequest",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/replyFriendRequest"})
      }
   """
)
                        

// @LINE:64
def myInformations : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.myInformations",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/myInformations"})
      }
   """
)
                        

// @LINE:47
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.update",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/update"})
      }
   """
)
                        

// @LINE:39
def resendSMS : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.resendSMS",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/resendSMS"})
      }
   """
)
                        

// @LINE:50
def deleteUserFromBlackList : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.UserController.deleteUserFromBlackList",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/deleteUserFromBlackList"})
      }
   """
)
                        
    
}
              

// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
class ReverseFileManager {
    

// @LINE:34
def getFile : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.FileManager.getFile",
   """
      function(filesType,file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "file/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("filesType", encodeURIComponent(filesType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

// @LINE:32
def destroyFile : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.FileManager.destroyFile",
   """
      function(filesType,file) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "file/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("filesType", encodeURIComponent(filesType)) + "/destroy/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

// @LINE:31
def createFile : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.FileManager.createFile",
   """
      function(filesType,width,length,width2,length2) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "file/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("filesType", encodeURIComponent(filesType)) + "/new" + _qS([(width == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("width", width)), (length == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("length", length)), (width2 == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("width2", width2)), (length2 == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("length2", length2))])})
      }
   """
)
                        

// @LINE:33
def getMyFile : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.FileManager.getMyFile",
   """
      function(filesType,page,nbObjectByPage) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "file/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("filesType", encodeURIComponent(filesType)) + "/mine" + _qS([(page == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("page", page)), (nbObjectByPage == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("nbObjectByPage", nbObjectByPage))])})
      }
   """
)
                        
    
}
              

// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseApplication {
    

// @LINE:20
def help : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.Application.help",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "help"})
      }
   """
)
                        

// @LINE:18
def news : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.Application.news",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "news"})
      }
   """
)
                        

// @LINE:26
def wardrobe : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.Application.wardrobe",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "wardrobe"})
      }
   """
)
                        

// @LINE:25
def share : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.Application.share",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "share"})
      }
   """
)
                        

// @LINE:19
def post : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.Application.post",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post"})
      }
   """
)
                        

// @LINE:23
def message : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.Application.message",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message"})
      }
   """
)
                        

// @LINE:12
def MyStatus : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.Application.MyStatus",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "MyStatus"})
      }
   """
)
                        

// @LINE:17
def product : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.Application.product",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "product"})
      }
   """
)
                        

// @LINE:21
def shop : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.Application.shop",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "shop"})
      }
   """
)
                        

// @LINE:11
def user : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.Application.user",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user"})
      }
   """
)
                        

// @LINE:14
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:16
def comment : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.Application.comment",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "comment"})
      }
   """
)
                        

// @LINE:24
def snapShot : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.Application.snapShot",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "snapShot"})
      }
   """
)
                        

// @LINE:15
def file : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.Application.file",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "file"})
      }
   """
)
                        

// @LINE:22
def search : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.Application.search",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search"})
      }
   """
)
                        

// @LINE:10
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:13
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.Application.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:27
def wholeSale : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.Application.wholeSale",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "wholeSale"})
      }
   """
)
                        
    
}
              

// @LINE:143
// @LINE:142
// @LINE:141
// @LINE:140
class ReverseMessageController {
    

// @LINE:143
def destroy : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.MessageController.destroy",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "message/destroy"})
      }
   """
)
                        

// @LINE:140
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.MessageController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "message/create"})
      }
   """
)
                        

// @LINE:141
def getMy : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.MessageController.getMy",
   """
      function(start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message/getMy" + _qS([(start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        

// @LINE:142
def getMessageSend : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.MessageController.getMessageSend",
   """
      function(start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message/getMessageSend" + _qS([(start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        
    
}
              

// @LINE:162
// @LINE:161
// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:156
// @LINE:155
class ReverseSearchController {
    

// @LINE:161
def findWishlistBy : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.SearchController.findWishlistBy",
   """
      function(wishlistProperty) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search/wishlist" + _qS([(wishlistProperty == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("wishlistProperty", wishlistProperty))])})
      }
   """
)
                        

// @LINE:156
def findShopBy : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.SearchController.findShopBy",
   """
      function(shopProperty) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search/shop" + _qS([(shopProperty == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("shopProperty", shopProperty))])})
      }
   """
)
                        

// @LINE:157
def findUserBy : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.SearchController.findUserBy",
   """
      function(userProperty) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search/user" + _qS([(userProperty == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("userProperty", userProperty))])})
      }
   """
)
                        

// @LINE:159
def findFriendBy : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.SearchController.findFriendBy",
   """
      function(friendProperty) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search/friend" + _qS([(friendProperty == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("friendProperty", friendProperty))])})
      }
   """
)
                        

// @LINE:158
def findUserByGender : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.SearchController.findUserByGender",
   """
      function(genderStr) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search/sortUserByGender" + _qS([(genderStr == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("genderStr", genderStr))])})
      }
   """
)
                        

// @LINE:160
def findFriendByGender : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.SearchController.findFriendByGender",
   """
      function(genderStr) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search/friendByGender" + _qS([(genderStr == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("genderStr", genderStr))])})
      }
   """
)
                        

// @LINE:155
def findProductBy : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.SearchController.findProductBy",
   """
      function(productProperty,lowPrice,highPrice,priceOrder) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search/product" + _qS([(productProperty == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("productProperty", productProperty)), (lowPrice == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("lowPrice", lowPrice)), (highPrice == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("highPrice", highPrice)), (priceOrder == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("priceOrder", priceOrder))])})
      }
   """
)
                        

// @LINE:162
def findFashionHelpBy : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.SearchController.findFashionHelpBy",
   """
      function(fashionHelpProperty) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search/fashionHelp" + _qS([(fashionHelpProperty == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("fashionHelpProperty", fashionHelpProperty))])})
      }
   """
)
                        
    
}
              

// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
class ReversePostController {
    

// @LINE:114
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.PostController.delete",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/delete"})
      }
   """
)
                        

// @LINE:120
def getAllFromUserID : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.PostController.getAllFromUserID",
   """
      function(userID,start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post/getAllFromUserID" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("userID", userID), (start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        

// @LINE:113
def edit : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.PostController.edit",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/edit"})
      }
   """
)
                        

// @LINE:112
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.PostController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/create"})
      }
   """
)
                        

// @LINE:121
def like : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.PostController.like",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "post/like"})
      }
   """
)
                        

// @LINE:116
def getPublic : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.PostController.getPublic",
   """
      function(start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post/getPublic" + _qS([(start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        

// @LINE:117
def getFollower : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.PostController.getFollower",
   """
      function(start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post/getFollower" + _qS([(start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        

// @LINE:119
def getShowOff : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.PostController.getShowOff",
   """
      function(userID,start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post/getShowOff" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("userID", userID), (start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        

// @LINE:118
def getFriend : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.PostController.getFriend",
   """
      function(start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post/getFriend" + _qS([(start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        

// @LINE:115
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.PostController.get",
   """
      function(postID) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "post/get" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("postID", postID)])})
      }
   """
)
                        
    
}
              

// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:131
// @LINE:130
// @LINE:129
// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:125
class ReverseShopController {
    

// @LINE:128
def drop : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ShopController.drop",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "shop/drop"})
      }
   """
)
                        

// @LINE:135
def share : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ShopController.share",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "shop/share"})
      }
   """
)
                        

// @LINE:130
def like : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ShopController.like",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "shop/like"})
      }
   """
)
                        

// @LINE:132
def follow : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ShopController.follow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "shop/follow"})
      }
   """
)
                        

// @LINE:127
def getShopById : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ShopController.getShopById",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "shop/getShopById"})
      }
   """
)
                        

// @LINE:126
def getMine : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ShopController.getMine",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "shop/getMine"})
      }
   """
)
                        

// @LINE:129
def revert : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ShopController.revert",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "shop/revert"})
      }
   """
)
                        

// @LINE:125
def set : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ShopController.set",
   """
      function(pic1,pic2,video1,video2,video3,video4,video5,video6) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "shop/set" + _qS([(pic1 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("pic1", pic1)), (pic2 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("pic2", pic2)), (video1 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("video1", video1)), (video2 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("video2", video2)), (video3 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("video3", video3)), (video4 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("video4", video4)), (video5 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("video5", video5)), (video6 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("video6", video6))])})
      }
   """
)
                        

// @LINE:133
def unfollow : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ShopController.unfollow",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "shop/unfollow"})
      }
   """
)
                        

// @LINE:134
def myShopLevel : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ShopController.myShopLevel",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "shop/myShopLevel"})
      }
   """
)
                        

// @LINE:131
def getShopAround : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ShopController.getShopAround",
   """
      function(radius,longitude,latitude) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "shop/getShopAround" + _qS([(radius == null ? null : (""" + implicitly[QueryStringBindable[Double]].javascriptUnbind + """)("radius", radius)), (longitude == null ? null : (""" + implicitly[QueryStringBindable[Double]].javascriptUnbind + """)("longitude", longitude)), (latitude == null ? null : (""" + implicitly[QueryStringBindable[Double]].javascriptUnbind + """)("latitude", latitude))])})
      }
   """
)
                        
    
}
              

// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
class ReverseCommentController {
    

// @LINE:71
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.CommentController.delete",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "comment/delete"})
      }
   """
)
                        

// @LINE:72
def edit : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.CommentController.edit",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "comment/edit"})
      }
   """
)
                        

// @LINE:70
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.CommentController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "comment/create"})
      }
   """
)
                        

// @LINE:76
def findByProductID : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.CommentController.findByProductID",
   """
      function(productID,start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "comment/findByProductID" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("productID", productID), (start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        

// @LINE:74
def findByHelpID : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.CommentController.findByHelpID",
   """
      function(helpID,start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "comment/findByHelpID" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("helpID", helpID), (start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        

// @LINE:73
def findByUserID : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.CommentController.findByUserID",
   """
      function(start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "comment/findByUserID" + _qS([(start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        

// @LINE:75
def findByPostID : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.CommentController.findByPostID",
   """
      function(postID,start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "comment/findByPostID" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("postID", postID), (start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        
    
}
              

// @LINE:83
// @LINE:82
// @LINE:81
class ReverseFashionNewsController {
    

// @LINE:82
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.FashionNewsController.get",
   """
      function(start,end) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "news/get" + _qS([(start == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("start", start)), (end == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("end", end))])})
      }
   """
)
                        

// @LINE:81
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.FashionNewsController.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "news/create"})
      }
   """
)
                        

// @LINE:83
def like : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.FashionNewsController.like",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "news/like"})
      }
   """
)
                        
    
}
              

// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:165
class ReverseShareController {
    

// @LINE:168
def shareOfSnapShot : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ShareController.shareOfSnapShot",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "share/snapshot"})
      }
   """
)
                        

// @LINE:169
def shareOfWardrobe : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ShareController.shareOfWardrobe",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "share/wardrobe"})
      }
   """
)
                        

// @LINE:167
def shareOfProduct : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ShareController.shareOfProduct",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "share/product"})
      }
   """
)
                        

// @LINE:165
def getByUserID : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ShareController.getByUserID",
   """
      function(userID,theType) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "share/getByUserID" + _qS([(userID == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("userID", userID)), (theType == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("theType", theType))])})
      }
   """
)
                        

// @LINE:166
def shareOfPost : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.pencho.pai.controllers.ShareController.shareOfPost",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "share/post"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:6
package controllers.ref {


// @LINE:6
class ReverseAssets {
    

// @LINE:6
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
        

// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:165
// @LINE:162
// @LINE:161
// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:156
// @LINE:155
// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
// @LINE:143
// @LINE:142
// @LINE:141
// @LINE:140
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:131
// @LINE:130
// @LINE:129
// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:125
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:104
// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:83
// @LINE:82
// @LINE:81
// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
package com.pencho.pai.controllers.ref {


// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:91
// @LINE:90
// @LINE:89
// @LINE:88
// @LINE:87
class ReverseFashionHelpController {
    

// @LINE:89
def delete(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.FashionHelpController.delete(), HandlerDef(this, "com.pencho.pai.controllers.FashionHelpController", "delete", Seq(), "POST", """""", _prefix + """help/delete""")
)
                      

// @LINE:91
def saveHelp(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.FashionHelpController.saveHelp(), HandlerDef(this, "com.pencho.pai.controllers.FashionHelpController", "saveHelp", Seq(), "POST", """""", _prefix + """help/saveHelp""")
)
                      

// @LINE:88
def edit(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.FashionHelpController.edit(), HandlerDef(this, "com.pencho.pai.controllers.FashionHelpController", "edit", Seq(), "POST", """""", _prefix + """help/edit""")
)
                      

// @LINE:87
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.FashionHelpController.create(), HandlerDef(this, "com.pencho.pai.controllers.FashionHelpController", "create", Seq(), "POST", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Help
# Help """, _prefix + """help/create""")
)
                      

// @LINE:94
def like(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.FashionHelpController.like(), HandlerDef(this, "com.pencho.pai.controllers.FashionHelpController", "like", Seq(), "POST", """""", _prefix + """help/like""")
)
                      

// @LINE:93
def getSavedHelp(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.FashionHelpController.getSavedHelp(), HandlerDef(this, "com.pencho.pai.controllers.FashionHelpController", "getSavedHelp", Seq(), "GET", """""", _prefix + """help/getSavedHelp""")
)
                      

// @LINE:90
def get(start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.FashionHelpController.get(start, end), HandlerDef(this, "com.pencho.pai.controllers.FashionHelpController", "get", Seq(classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """help/get""")
)
                      

// @LINE:92
def unsaveHelp(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.FashionHelpController.unsaveHelp(), HandlerDef(this, "com.pencho.pai.controllers.FashionHelpController", "unsaveHelp", Seq(), "POST", """""", _prefix + """help/unsaveHelp""")
)
                      
    
}
                          

// @LINE:177
// @LINE:176
// @LINE:175
// @LINE:174
// @LINE:173
class ReverseWardrobeController {
    

// @LINE:173
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.WardrobeController.create(), HandlerDef(this, "com.pencho.pai.controllers.WardrobeController", "create", Seq(), "POST", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Wardrobe
# Wardrobe""", _prefix + """wardrobe/create""")
)
                      

// @LINE:175
def like(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.WardrobeController.like(), HandlerDef(this, "com.pencho.pai.controllers.WardrobeController", "like", Seq(), "POST", """""", _prefix + """wardrobe/like""")
)
                      

// @LINE:176
def destroy(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.WardrobeController.destroy(), HandlerDef(this, "com.pencho.pai.controllers.WardrobeController", "destroy", Seq(), "POST", """""", _prefix + """wardrobe/destroy""")
)
                      

// @LINE:174
def getByUserID(userID:String, start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.WardrobeController.getByUserID(userID, start, end), HandlerDef(this, "com.pencho.pai.controllers.WardrobeController", "getByUserID", Seq(classOf[String], classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """wardrobe/getByUserID""")
)
                      

// @LINE:177
def get(wardrobeID:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.WardrobeController.get(wardrobeID), HandlerDef(this, "com.pencho.pai.controllers.WardrobeController", "get", Seq(classOf[String]), "GET", """""", _prefix + """wardrobe/get""")
)
                      
    
}
                          

// @LINE:151
// @LINE:150
// @LINE:149
// @LINE:148
// @LINE:147
class ReverseSnapShotController {
    

// @LINE:147
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.SnapShotController.create(), HandlerDef(this, "com.pencho.pai.controllers.SnapShotController", "create", Seq(), "POST", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Snapshot
# Snapshot""", _prefix + """snapshot/create""")
)
                      

// @LINE:149
def like(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.SnapShotController.like(), HandlerDef(this, "com.pencho.pai.controllers.SnapShotController", "like", Seq(), "POST", """""", _prefix + """snapshot/like""")
)
                      

// @LINE:150
def destroy(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.SnapShotController.destroy(), HandlerDef(this, "com.pencho.pai.controllers.SnapShotController", "destroy", Seq(), "POST", """""", _prefix + """snapshot/destroy""")
)
                      

// @LINE:148
def getByUserID(userID:String, start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.SnapShotController.getByUserID(userID, start, end), HandlerDef(this, "com.pencho.pai.controllers.SnapShotController", "getByUserID", Seq(classOf[String], classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """snapshot/getByUserID""")
)
                      

// @LINE:151
def get(snapshotID:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.SnapShotController.get(snapshotID), HandlerDef(this, "com.pencho.pai.controllers.SnapShotController", "get", Seq(classOf[String]), "GET", """""", _prefix + """snapshot/get""")
)
                      
    
}
                          

// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:105
// @LINE:104
// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
class ReverseProductController {
    

// @LINE:100
def delete(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ProductController.delete(), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "delete", Seq(), "POST", """""", _prefix + """product/delete""")
)
                      

// @LINE:107
def wishListOfUserID(userID:String, start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ProductController.wishListOfUserID(userID, start, end), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "wishListOfUserID", Seq(classOf[String], classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """product/wishListOfUserID""")
)
                      

// @LINE:99
def edit(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ProductController.edit(), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "edit", Seq(), "POST", """""", _prefix + """product/edit""")
)
                      

// @LINE:108
def removeFromWishList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ProductController.removeFromWishList(), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "removeFromWishList", Seq(), "POST", """""", _prefix + """product/removeFromWishList""")
)
                      

// @LINE:98
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ProductController.create(), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "create", Seq(), "POST", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Product
# Product""", _prefix + """product/create""")
)
                      

// @LINE:103
def like(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ProductController.like(), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "like", Seq(), "POST", """""", _prefix + """product/like""")
)
                      

// @LINE:105
def findByID(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ProductController.findByID(), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "findByID", Seq(), "GET", """""", _prefix + """product/findByID""")
)
                      

// @LINE:104
def getHot(start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ProductController.getHot(start, end), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "getHot", Seq(classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """product/getHot""")
)
                      

// @LINE:101
def findByShopID(start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ProductController.findByShopID(start, end), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "findByShopID", Seq(classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """product/findByShopID""")
)
                      

// @LINE:102
def findTrendyStyleByShopID(shopID:String, start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ProductController.findTrendyStyleByShopID(shopID, start, end), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "findTrendyStyleByShopID", Seq(classOf[String], classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """product/findTrendyStyleByShopID""")
)
                      

// @LINE:106
def add2WishList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ProductController.add2WishList(), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "add2WishList", Seq(), "POST", """""", _prefix + """product/add2WishList""")
)
                      
    
}
                          

// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
class ReverseUserController {
    

// @LINE:53
def findFriendsUnaudited(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.findFriendsUnaudited(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "findFriendsUnaudited", Seq(), "GET", """""", _prefix + """user/findFriendsUnaudited""")
)
                      

// @LINE:54
def find(page:Integer, nbObjectByPagepage:Integer, phone:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.find(page, nbObjectByPagepage, phone), HandlerDef(this, "com.pencho.pai.controllers.UserController", "find", Seq(classOf[Integer], classOf[Integer], classOf[String]), "GET", """""", _prefix + """user/find""")
)
                      

// @LINE:41
def redoValidateSMS(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.redoValidateSMS(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "redoValidateSMS", Seq(), "POST", """""", _prefix + """user/redoValidateSMS""")
)
                      

// @LINE:42
def createPsw(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.createPsw(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "createPsw", Seq(), "POST", """""", _prefix + """user/createPsw""")
)
                      

// @LINE:52
def getBlackList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.getBlackList(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "getBlackList", Seq(), "GET", """""", _prefix + """user/getBlackList""")
)
                      

// @LINE:58
def whoFollowMe(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.whoFollowMe(id), HandlerDef(this, "com.pencho.pai.controllers.UserController", "whoFollowMe", Seq(classOf[String]), "GET", """""", _prefix + """user/whoFollowMe""")
)
                      

// @LINE:55
def findFriends(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.findFriends(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "findFriends", Seq(), "GET", """""", _prefix + """user/findFriends""")
)
                      

// @LINE:44
def createProfile(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.createProfile(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "createProfile", Seq(), "POST", """""", _prefix + """user/createProfile""")
)
                      

// @LINE:63
def myUserLevel(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.myUserLevel(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "myUserLevel", Seq(), "GET", """""", _prefix + """user/myUserLevel""")
)
                      

// @LINE:38
def sendSMS(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.sendSMS(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "sendSMS", Seq(), "GET", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>User
# User""", _prefix + """user/sendSMS""")
)
                      

// @LINE:51
def deleteUserFromFriendList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.deleteUserFromFriendList(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "deleteUserFromFriendList", Seq(), "POST", """""", _prefix + """user/deleteUserFromFriendList""")
)
                      

// @LINE:57
def follow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.follow(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "follow", Seq(), "POST", """""", _prefix + """user/follow""")
)
                      

// @LINE:59
def whoIFollowed(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.whoIFollowed(id), HandlerDef(this, "com.pencho.pai.controllers.UserController", "whoIFollowed", Seq(classOf[String]), "GET", """""", _prefix + """user/whoIFollowed""")
)
                      

// @LINE:48
def addFriend(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.addFriend(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "addFriend", Seq(), "POST", """""", _prefix + """user/addFriend""")
)
                      

// @LINE:49
def add2BlackList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.add2BlackList(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "add2BlackList", Seq(), "POST", """""", _prefix + """user/add2BlackList""")
)
                      

// @LINE:60
def whoShopIFollowed(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.whoShopIFollowed(id), HandlerDef(this, "com.pencho.pai.controllers.UserController", "whoShopIFollowed", Seq(classOf[String]), "GET", """""", _prefix + """user/whoShopIFollowed""")
)
                      

// @LINE:61
def findByUsername(username:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.findByUsername(username), HandlerDef(this, "com.pencho.pai.controllers.UserController", "findByUsername", Seq(classOf[String]), "GET", """""", _prefix + """user/findByUsername""")
)
                      

// @LINE:43
def recreatePsw(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.recreatePsw(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "recreatePsw", Seq(), "POST", """""", _prefix + """user/recreatePsw""")
)
                      

// @LINE:56
def findUserByID(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.findUserByID(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "findUserByID", Seq(), "GET", """""", _prefix + """user/findUserByID""")
)
                      

// @LINE:40
def doValidateSMS(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.doValidateSMS(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "doValidateSMS", Seq(), "POST", """""", _prefix + """user/doValidateSMS""")
)
                      

// @LINE:62
def unfollow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.unfollow(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "unfollow", Seq(), "POST", """""", _prefix + """user/unfollow""")
)
                      

// @LINE:45
def getStarOfTheDay(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.getStarOfTheDay(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "getStarOfTheDay", Seq(), "GET", """""", _prefix + """user/getStarOfTheDay""")
)
                      

// @LINE:46
def replyFriendRequest(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.replyFriendRequest(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "replyFriendRequest", Seq(), "POST", """""", _prefix + """user/replyFriendRequest""")
)
                      

// @LINE:64
def myInformations(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.myInformations(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "myInformations", Seq(), "GET", """""", _prefix + """user/myInformations""")
)
                      

// @LINE:47
def update(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.update(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "update", Seq(), "POST", """""", _prefix + """user/update""")
)
                      

// @LINE:39
def resendSMS(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.resendSMS(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "resendSMS", Seq(), "GET", """""", _prefix + """user/resendSMS""")
)
                      

// @LINE:50
def deleteUserFromBlackList(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.UserController.deleteUserFromBlackList(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "deleteUserFromBlackList", Seq(), "POST", """""", _prefix + """user/deleteUserFromBlackList""")
)
                      
    
}
                          

// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
class ReverseFileManager {
    

// @LINE:34
def getFile(filesType:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.FileManager.getFile(filesType, file), HandlerDef(this, "com.pencho.pai.controllers.FileManager", "getFile", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """file/$filesType<[^/]+>/$file<.+>""")
)
                      

// @LINE:32
def destroyFile(filesType:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.FileManager.destroyFile(filesType, file), HandlerDef(this, "com.pencho.pai.controllers.FileManager", "destroyFile", Seq(classOf[String], classOf[String]), "POST", """""", _prefix + """file/$filesType<[^/]+>/destroy/$file<.+>""")
)
                      

// @LINE:31
def createFile(filesType:String, width:Integer, length:Integer, width2:Integer, length2:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.FileManager.createFile(filesType, width, length, width2, length2), HandlerDef(this, "com.pencho.pai.controllers.FileManager", "createFile", Seq(classOf[String], classOf[Integer], classOf[Integer], classOf[Integer], classOf[Integer]), "POST", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>File
# File""", _prefix + """file/$filesType<[^/]+>/new""")
)
                      

// @LINE:33
def getMyFile(filesType:String, page:Integer, nbObjectByPage:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.FileManager.getMyFile(filesType, page, nbObjectByPage), HandlerDef(this, "com.pencho.pai.controllers.FileManager", "getMyFile", Seq(classOf[String], classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """file/$filesType<[^/]+>/mine""")
)
                      
    
}
                          

// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
class ReverseApplication {
    

// @LINE:20
def help(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.Application.help(), HandlerDef(this, "com.pencho.pai.controllers.Application", "help", Seq(), "GET", """""", _prefix + """help""")
)
                      

// @LINE:18
def news(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.Application.news(), HandlerDef(this, "com.pencho.pai.controllers.Application", "news", Seq(), "GET", """""", _prefix + """news""")
)
                      

// @LINE:26
def wardrobe(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.Application.wardrobe(), HandlerDef(this, "com.pencho.pai.controllers.Application", "wardrobe", Seq(), "GET", """""", _prefix + """wardrobe""")
)
                      

// @LINE:25
def share(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.Application.share(), HandlerDef(this, "com.pencho.pai.controllers.Application", "share", Seq(), "GET", """""", _prefix + """share""")
)
                      

// @LINE:19
def post(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.Application.post(), HandlerDef(this, "com.pencho.pai.controllers.Application", "post", Seq(), "GET", """""", _prefix + """post""")
)
                      

// @LINE:23
def message(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.Application.message(), HandlerDef(this, "com.pencho.pai.controllers.Application", "message", Seq(), "GET", """""", _prefix + """message""")
)
                      

// @LINE:12
def MyStatus(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.Application.MyStatus(), HandlerDef(this, "com.pencho.pai.controllers.Application", "MyStatus", Seq(), "GET", """""", _prefix + """MyStatus""")
)
                      

// @LINE:17
def product(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.Application.product(), HandlerDef(this, "com.pencho.pai.controllers.Application", "product", Seq(), "GET", """""", _prefix + """product""")
)
                      

// @LINE:21
def shop(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.Application.shop(), HandlerDef(this, "com.pencho.pai.controllers.Application", "shop", Seq(), "GET", """""", _prefix + """shop""")
)
                      

// @LINE:11
def user(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.Application.user(), HandlerDef(this, "com.pencho.pai.controllers.Application", "user", Seq(), "GET", """""", _prefix + """user""")
)
                      

// @LINE:14
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.Application.logout(), HandlerDef(this, "com.pencho.pai.controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:16
def comment(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.Application.comment(), HandlerDef(this, "com.pencho.pai.controllers.Application", "comment", Seq(), "GET", """""", _prefix + """comment""")
)
                      

// @LINE:24
def snapShot(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.Application.snapShot(), HandlerDef(this, "com.pencho.pai.controllers.Application", "snapShot", Seq(), "GET", """""", _prefix + """snapShot""")
)
                      

// @LINE:15
def file(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.Application.file(), HandlerDef(this, "com.pencho.pai.controllers.Application", "file", Seq(), "GET", """""", _prefix + """file""")
)
                      

// @LINE:22
def search(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.Application.search(), HandlerDef(this, "com.pencho.pai.controllers.Application", "search", Seq(), "GET", """""", _prefix + """search""")
)
                      

// @LINE:10
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.Application.index(), HandlerDef(this, "com.pencho.pai.controllers.Application", "index", Seq(), "GET", """ >>>>>>>>>>>>>>>>>>>
 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>HTML
 HTML""", _prefix + """""")
)
                      

// @LINE:13
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.Application.login(), HandlerDef(this, "com.pencho.pai.controllers.Application", "login", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:27
def wholeSale(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.Application.wholeSale(), HandlerDef(this, "com.pencho.pai.controllers.Application", "wholeSale", Seq(), "GET", """""", _prefix + """wholeSale""")
)
                      
    
}
                          

// @LINE:143
// @LINE:142
// @LINE:141
// @LINE:140
class ReverseMessageController {
    

// @LINE:143
def destroy(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.MessageController.destroy(), HandlerDef(this, "com.pencho.pai.controllers.MessageController", "destroy", Seq(), "POST", """""", _prefix + """message/destroy""")
)
                      

// @LINE:140
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.MessageController.create(), HandlerDef(this, "com.pencho.pai.controllers.MessageController", "create", Seq(), "POST", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Message
# Message""", _prefix + """message/create""")
)
                      

// @LINE:141
def getMy(start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.MessageController.getMy(start, end), HandlerDef(this, "com.pencho.pai.controllers.MessageController", "getMy", Seq(classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """message/getMy""")
)
                      

// @LINE:142
def getMessageSend(start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.MessageController.getMessageSend(start, end), HandlerDef(this, "com.pencho.pai.controllers.MessageController", "getMessageSend", Seq(classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """message/getMessageSend""")
)
                      
    
}
                          

// @LINE:162
// @LINE:161
// @LINE:160
// @LINE:159
// @LINE:158
// @LINE:157
// @LINE:156
// @LINE:155
class ReverseSearchController {
    

// @LINE:161
def findWishlistBy(wishlistProperty:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.SearchController.findWishlistBy(wishlistProperty), HandlerDef(this, "com.pencho.pai.controllers.SearchController", "findWishlistBy", Seq(classOf[String]), "GET", """""", _prefix + """search/wishlist""")
)
                      

// @LINE:156
def findShopBy(shopProperty:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.SearchController.findShopBy(shopProperty), HandlerDef(this, "com.pencho.pai.controllers.SearchController", "findShopBy", Seq(classOf[String]), "GET", """""", _prefix + """search/shop""")
)
                      

// @LINE:157
def findUserBy(userProperty:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.SearchController.findUserBy(userProperty), HandlerDef(this, "com.pencho.pai.controllers.SearchController", "findUserBy", Seq(classOf[String]), "GET", """""", _prefix + """search/user""")
)
                      

// @LINE:159
def findFriendBy(friendProperty:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.SearchController.findFriendBy(friendProperty), HandlerDef(this, "com.pencho.pai.controllers.SearchController", "findFriendBy", Seq(classOf[String]), "GET", """""", _prefix + """search/friend""")
)
                      

// @LINE:158
def findUserByGender(genderStr:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.SearchController.findUserByGender(genderStr), HandlerDef(this, "com.pencho.pai.controllers.SearchController", "findUserByGender", Seq(classOf[String]), "GET", """""", _prefix + """search/sortUserByGender""")
)
                      

// @LINE:160
def findFriendByGender(genderStr:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.SearchController.findFriendByGender(genderStr), HandlerDef(this, "com.pencho.pai.controllers.SearchController", "findFriendByGender", Seq(classOf[String]), "GET", """""", _prefix + """search/friendByGender""")
)
                      

// @LINE:155
def findProductBy(productProperty:String, lowPrice:String, highPrice:String, priceOrder:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.SearchController.findProductBy(productProperty, lowPrice, highPrice, priceOrder), HandlerDef(this, "com.pencho.pai.controllers.SearchController", "findProductBy", Seq(classOf[String], classOf[String], classOf[String], classOf[String]), "GET", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Search
# Search """, _prefix + """search/product""")
)
                      

// @LINE:162
def findFashionHelpBy(fashionHelpProperty:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.SearchController.findFashionHelpBy(fashionHelpProperty), HandlerDef(this, "com.pencho.pai.controllers.SearchController", "findFashionHelpBy", Seq(classOf[String]), "GET", """""", _prefix + """search/fashionHelp""")
)
                      
    
}
                          

// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:118
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:113
// @LINE:112
class ReversePostController {
    

// @LINE:114
def delete(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.PostController.delete(), HandlerDef(this, "com.pencho.pai.controllers.PostController", "delete", Seq(), "POST", """""", _prefix + """post/delete""")
)
                      

// @LINE:120
def getAllFromUserID(userID:String, start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.PostController.getAllFromUserID(userID, start, end), HandlerDef(this, "com.pencho.pai.controllers.PostController", "getAllFromUserID", Seq(classOf[String], classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """post/getAllFromUserID""")
)
                      

// @LINE:113
def edit(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.PostController.edit(), HandlerDef(this, "com.pencho.pai.controllers.PostController", "edit", Seq(), "POST", """""", _prefix + """post/edit""")
)
                      

// @LINE:112
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.PostController.create(), HandlerDef(this, "com.pencho.pai.controllers.PostController", "create", Seq(), "POST", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Post
# Post""", _prefix + """post/create""")
)
                      

// @LINE:121
def like(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.PostController.like(), HandlerDef(this, "com.pencho.pai.controllers.PostController", "like", Seq(), "POST", """""", _prefix + """post/like""")
)
                      

// @LINE:116
def getPublic(start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.PostController.getPublic(start, end), HandlerDef(this, "com.pencho.pai.controllers.PostController", "getPublic", Seq(classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """post/getPublic""")
)
                      

// @LINE:117
def getFollower(start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.PostController.getFollower(start, end), HandlerDef(this, "com.pencho.pai.controllers.PostController", "getFollower", Seq(classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """post/getFollower""")
)
                      

// @LINE:119
def getShowOff(userID:String, start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.PostController.getShowOff(userID, start, end), HandlerDef(this, "com.pencho.pai.controllers.PostController", "getShowOff", Seq(classOf[String], classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """post/getShowOff""")
)
                      

// @LINE:118
def getFriend(start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.PostController.getFriend(start, end), HandlerDef(this, "com.pencho.pai.controllers.PostController", "getFriend", Seq(classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """post/getFriend""")
)
                      

// @LINE:115
def get(postID:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.PostController.get(postID), HandlerDef(this, "com.pencho.pai.controllers.PostController", "get", Seq(classOf[String]), "GET", """""", _prefix + """post/get""")
)
                      
    
}
                          

// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:132
// @LINE:131
// @LINE:130
// @LINE:129
// @LINE:128
// @LINE:127
// @LINE:126
// @LINE:125
class ReverseShopController {
    

// @LINE:128
def drop(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ShopController.drop(), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "drop", Seq(), "POST", """""", _prefix + """shop/drop""")
)
                      

// @LINE:135
def share(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ShopController.share(), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "share", Seq(), "POST", """""", _prefix + """shop/share""")
)
                      

// @LINE:130
def like(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ShopController.like(), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "like", Seq(), "POST", """""", _prefix + """shop/like""")
)
                      

// @LINE:132
def follow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ShopController.follow(), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "follow", Seq(), "POST", """""", _prefix + """shop/follow""")
)
                      

// @LINE:127
def getShopById(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ShopController.getShopById(), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "getShopById", Seq(), "GET", """""", _prefix + """shop/getShopById""")
)
                      

// @LINE:126
def getMine(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ShopController.getMine(), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "getMine", Seq(), "GET", """""", _prefix + """shop/getMine""")
)
                      

// @LINE:129
def revert(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ShopController.revert(), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "revert", Seq(), "POST", """""", _prefix + """shop/revert""")
)
                      

// @LINE:125
def set(pic1:String, pic2:String, video1:String, video2:String, video3:String, video4:String, video5:String, video6:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ShopController.set(pic1, pic2, video1, video2, video3, video4, video5, video6), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "set", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]), "GET", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Shop
# Shop""", _prefix + """shop/set""")
)
                      

// @LINE:133
def unfollow(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ShopController.unfollow(), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "unfollow", Seq(), "POST", """""", _prefix + """shop/unfollow""")
)
                      

// @LINE:134
def myShopLevel(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ShopController.myShopLevel(), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "myShopLevel", Seq(), "GET", """""", _prefix + """shop/myShopLevel""")
)
                      

// @LINE:131
def getShopAround(radius:Double, longitude:Double, latitude:Double): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ShopController.getShopAround(radius, longitude, latitude), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "getShopAround", Seq(classOf[Double], classOf[Double], classOf[Double]), "GET", """""", _prefix + """shop/getShopAround""")
)
                      
    
}
                          

// @LINE:76
// @LINE:75
// @LINE:74
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:70
class ReverseCommentController {
    

// @LINE:71
def delete(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.CommentController.delete(), HandlerDef(this, "com.pencho.pai.controllers.CommentController", "delete", Seq(), "POST", """""", _prefix + """comment/delete""")
)
                      

// @LINE:72
def edit(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.CommentController.edit(), HandlerDef(this, "com.pencho.pai.controllers.CommentController", "edit", Seq(), "POST", """""", _prefix + """comment/edit""")
)
                      

// @LINE:70
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.CommentController.create(), HandlerDef(this, "com.pencho.pai.controllers.CommentController", "create", Seq(), "POST", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Comment
# Comment""", _prefix + """comment/create""")
)
                      

// @LINE:76
def findByProductID(productID:String, start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.CommentController.findByProductID(productID, start, end), HandlerDef(this, "com.pencho.pai.controllers.CommentController", "findByProductID", Seq(classOf[String], classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """comment/findByProductID""")
)
                      

// @LINE:74
def findByHelpID(helpID:String, start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.CommentController.findByHelpID(helpID, start, end), HandlerDef(this, "com.pencho.pai.controllers.CommentController", "findByHelpID", Seq(classOf[String], classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """comment/findByHelpID""")
)
                      

// @LINE:73
def findByUserID(start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.CommentController.findByUserID(start, end), HandlerDef(this, "com.pencho.pai.controllers.CommentController", "findByUserID", Seq(classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """comment/findByUserID""")
)
                      

// @LINE:75
def findByPostID(postID:String, start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.CommentController.findByPostID(postID, start, end), HandlerDef(this, "com.pencho.pai.controllers.CommentController", "findByPostID", Seq(classOf[String], classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """comment/findByPostID""")
)
                      
    
}
                          

// @LINE:83
// @LINE:82
// @LINE:81
class ReverseFashionNewsController {
    

// @LINE:82
def get(start:Integer, end:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.FashionNewsController.get(start, end), HandlerDef(this, "com.pencho.pai.controllers.FashionNewsController", "get", Seq(classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """news/get""")
)
                      

// @LINE:81
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.FashionNewsController.create(), HandlerDef(this, "com.pencho.pai.controllers.FashionNewsController", "create", Seq(), "POST", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>News
# News
 only create by pencho server""", _prefix + """news/create""")
)
                      

// @LINE:83
def like(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.FashionNewsController.like(), HandlerDef(this, "com.pencho.pai.controllers.FashionNewsController", "like", Seq(), "POST", """""", _prefix + """news/like""")
)
                      
    
}
                          

// @LINE:169
// @LINE:168
// @LINE:167
// @LINE:166
// @LINE:165
class ReverseShareController {
    

// @LINE:168
def shareOfSnapShot(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ShareController.shareOfSnapShot(), HandlerDef(this, "com.pencho.pai.controllers.ShareController", "shareOfSnapShot", Seq(), "POST", """""", _prefix + """share/snapshot""")
)
                      

// @LINE:169
def shareOfWardrobe(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ShareController.shareOfWardrobe(), HandlerDef(this, "com.pencho.pai.controllers.ShareController", "shareOfWardrobe", Seq(), "POST", """""", _prefix + """share/wardrobe""")
)
                      

// @LINE:167
def shareOfProduct(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ShareController.shareOfProduct(), HandlerDef(this, "com.pencho.pai.controllers.ShareController", "shareOfProduct", Seq(), "POST", """""", _prefix + """share/product""")
)
                      

// @LINE:165
def getByUserID(userID:String, theType:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ShareController.getByUserID(userID, theType), HandlerDef(this, "com.pencho.pai.controllers.ShareController", "getByUserID", Seq(classOf[String], classOf[String]), "GET", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Share
# Share""", _prefix + """share/getByUserID""")
)
                      

// @LINE:166
def shareOfPost(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.pencho.pai.controllers.ShareController.shareOfPost(), HandlerDef(this, "com.pencho.pai.controllers.ShareController", "shareOfPost", Seq(), "POST", """""", _prefix + """share/post""")
)
                      
    
}
                          
}
        
    