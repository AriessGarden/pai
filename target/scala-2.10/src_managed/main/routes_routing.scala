// @SOURCE:/home/aries/git/pai_mongodb/conf/routes
// @HASH:04e0e9e4e6c13369bbd47eb4d8b44da39f67a416
// @DATE:Tue Feb 25 13:55:27 CST 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Assets_at0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:10
private[this] lazy val com_pencho_pai_controllers_Application_index1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:11
private[this] lazy val com_pencho_pai_controllers_Application_user2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user"))))
        

// @LINE:12
private[this] lazy val com_pencho_pai_controllers_Application_MyStatus3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("MyStatus"))))
        

// @LINE:13
private[this] lazy val com_pencho_pai_controllers_Application_login4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:14
private[this] lazy val com_pencho_pai_controllers_Application_logout5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:15
private[this] lazy val com_pencho_pai_controllers_Application_file6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("file"))))
        

// @LINE:16
private[this] lazy val com_pencho_pai_controllers_Application_comment7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment"))))
        

// @LINE:17
private[this] lazy val com_pencho_pai_controllers_Application_product8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("product"))))
        

// @LINE:18
private[this] lazy val com_pencho_pai_controllers_Application_news9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("news"))))
        

// @LINE:19
private[this] lazy val com_pencho_pai_controllers_Application_post10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post"))))
        

// @LINE:20
private[this] lazy val com_pencho_pai_controllers_Application_help11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("help"))))
        

// @LINE:21
private[this] lazy val com_pencho_pai_controllers_Application_shop12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("shop"))))
        

// @LINE:22
private[this] lazy val com_pencho_pai_controllers_Application_search13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("search"))))
        

// @LINE:23
private[this] lazy val com_pencho_pai_controllers_Application_message14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("message"))))
        

// @LINE:24
private[this] lazy val com_pencho_pai_controllers_Application_snapShot15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("snapShot"))))
        

// @LINE:25
private[this] lazy val com_pencho_pai_controllers_Application_share16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("share"))))
        

// @LINE:26
private[this] lazy val com_pencho_pai_controllers_Application_wardrobe17 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("wardrobe"))))
        

// @LINE:27
private[this] lazy val com_pencho_pai_controllers_Application_wholeSale18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("wholeSale"))))
        

// @LINE:31
private[this] lazy val com_pencho_pai_controllers_FileManager_createFile19 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("file/"),DynamicPart("filesType", """[^/]+""",true),StaticPart("/new"))))
        

// @LINE:32
private[this] lazy val com_pencho_pai_controllers_FileManager_destroyFile20 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("file/"),DynamicPart("filesType", """[^/]+""",true),StaticPart("/destroy/"),DynamicPart("file", """.+""",false))))
        

// @LINE:33
private[this] lazy val com_pencho_pai_controllers_FileManager_getMyFile21 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("file/"),DynamicPart("filesType", """[^/]+""",true),StaticPart("/mine"))))
        

// @LINE:34
private[this] lazy val com_pencho_pai_controllers_FileManager_getFile22 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("file/"),DynamicPart("filesType", """[^/]+""",true),StaticPart("/"),DynamicPart("file", """.+""",false))))
        

// @LINE:38
private[this] lazy val com_pencho_pai_controllers_UserController_sendSMS23 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/sendSMS"))))
        

// @LINE:39
private[this] lazy val com_pencho_pai_controllers_UserController_resendSMS24 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/resendSMS"))))
        

// @LINE:40
private[this] lazy val com_pencho_pai_controllers_UserController_doValidateSMS25 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/doValidateSMS"))))
        

// @LINE:41
private[this] lazy val com_pencho_pai_controllers_UserController_redoValidateSMS26 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/redoValidateSMS"))))
        

// @LINE:42
private[this] lazy val com_pencho_pai_controllers_UserController_createPsw27 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/createPsw"))))
        

// @LINE:43
private[this] lazy val com_pencho_pai_controllers_UserController_recreatePsw28 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/recreatePsw"))))
        

// @LINE:44
private[this] lazy val com_pencho_pai_controllers_UserController_createProfile29 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/createProfile"))))
        

// @LINE:45
private[this] lazy val com_pencho_pai_controllers_UserController_getStarOfTheDay30 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/getStarOfTheDay"))))
        

// @LINE:46
private[this] lazy val com_pencho_pai_controllers_UserController_replyFriendRequest31 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/replyFriendRequest"))))
        

// @LINE:47
private[this] lazy val com_pencho_pai_controllers_UserController_update32 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/update"))))
        

// @LINE:48
private[this] lazy val com_pencho_pai_controllers_UserController_addFriend33 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/addFriend"))))
        

// @LINE:49
private[this] lazy val com_pencho_pai_controllers_UserController_add2BlackList34 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/add2BlackList"))))
        

// @LINE:50
private[this] lazy val com_pencho_pai_controllers_UserController_deleteUserFromBlackList35 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/deleteUserFromBlackList"))))
        

// @LINE:51
private[this] lazy val com_pencho_pai_controllers_UserController_deleteUserFromFriendList36 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/deleteUserFromFriendList"))))
        

// @LINE:52
private[this] lazy val com_pencho_pai_controllers_UserController_getBlackList37 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/getBlackList"))))
        

// @LINE:53
private[this] lazy val com_pencho_pai_controllers_UserController_findFriendsUnaudited38 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/findFriendsUnaudited"))))
        

// @LINE:54
private[this] lazy val com_pencho_pai_controllers_UserController_find39 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/find"))))
        

// @LINE:55
private[this] lazy val com_pencho_pai_controllers_UserController_findFriends40 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/findFriends"))))
        

// @LINE:56
private[this] lazy val com_pencho_pai_controllers_UserController_findUserByID41 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/findUserByID"))))
        

// @LINE:57
private[this] lazy val com_pencho_pai_controllers_UserController_follow42 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/follow"))))
        

// @LINE:58
private[this] lazy val com_pencho_pai_controllers_UserController_whoFollowMe43 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/whoFollowMe"))))
        

// @LINE:59
private[this] lazy val com_pencho_pai_controllers_UserController_whoIFollowed44 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/whoIFollowed"))))
        

// @LINE:60
private[this] lazy val com_pencho_pai_controllers_UserController_whoShopIFollowed45 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/whoShopIFollowed"))))
        

// @LINE:61
private[this] lazy val com_pencho_pai_controllers_UserController_findByUsername46 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/findByUsername"))))
        

// @LINE:62
private[this] lazy val com_pencho_pai_controllers_UserController_unfollow47 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/unfollow"))))
        

// @LINE:63
private[this] lazy val com_pencho_pai_controllers_UserController_myUserLevel48 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/myUserLevel"))))
        

// @LINE:64
private[this] lazy val com_pencho_pai_controllers_UserController_myInformations49 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/myInformations"))))
        

// @LINE:70
private[this] lazy val com_pencho_pai_controllers_CommentController_create50 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment/create"))))
        

// @LINE:71
private[this] lazy val com_pencho_pai_controllers_CommentController_delete51 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment/delete"))))
        

// @LINE:72
private[this] lazy val com_pencho_pai_controllers_CommentController_edit52 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment/edit"))))
        

// @LINE:73
private[this] lazy val com_pencho_pai_controllers_CommentController_findByUserID53 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment/findByUserID"))))
        

// @LINE:74
private[this] lazy val com_pencho_pai_controllers_CommentController_findByHelpID54 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment/findByHelpID"))))
        

// @LINE:75
private[this] lazy val com_pencho_pai_controllers_CommentController_findByPostID55 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment/findByPostID"))))
        

// @LINE:76
private[this] lazy val com_pencho_pai_controllers_CommentController_findByProductID56 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("comment/findByProductID"))))
        

// @LINE:81
private[this] lazy val com_pencho_pai_controllers_FashionNewsController_create57 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("news/create"))))
        

// @LINE:82
private[this] lazy val com_pencho_pai_controllers_FashionNewsController_get58 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("news/get"))))
        

// @LINE:83
private[this] lazy val com_pencho_pai_controllers_FashionNewsController_like59 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("news/like"))))
        

// @LINE:87
private[this] lazy val com_pencho_pai_controllers_FashionHelpController_create60 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("help/create"))))
        

// @LINE:88
private[this] lazy val com_pencho_pai_controllers_FashionHelpController_edit61 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("help/edit"))))
        

// @LINE:89
private[this] lazy val com_pencho_pai_controllers_FashionHelpController_delete62 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("help/delete"))))
        

// @LINE:90
private[this] lazy val com_pencho_pai_controllers_FashionHelpController_get63 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("help/get"))))
        

// @LINE:91
private[this] lazy val com_pencho_pai_controllers_FashionHelpController_saveHelp64 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("help/saveHelp"))))
        

// @LINE:92
private[this] lazy val com_pencho_pai_controllers_FashionHelpController_unsaveHelp65 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("help/unsaveHelp"))))
        

// @LINE:93
private[this] lazy val com_pencho_pai_controllers_FashionHelpController_getSavedHelp66 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("help/getSavedHelp"))))
        

// @LINE:94
private[this] lazy val com_pencho_pai_controllers_FashionHelpController_like67 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("help/like"))))
        

// @LINE:98
private[this] lazy val com_pencho_pai_controllers_ProductController_create68 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("product/create"))))
        

// @LINE:99
private[this] lazy val com_pencho_pai_controllers_ProductController_edit69 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("product/edit"))))
        

// @LINE:100
private[this] lazy val com_pencho_pai_controllers_ProductController_delete70 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("product/delete"))))
        

// @LINE:101
private[this] lazy val com_pencho_pai_controllers_ProductController_findByShopID71 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("product/findByShopID"))))
        

// @LINE:102
private[this] lazy val com_pencho_pai_controllers_ProductController_findTrendyStyleByShopID72 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("product/findTrendyStyleByShopID"))))
        

// @LINE:103
private[this] lazy val com_pencho_pai_controllers_ProductController_like73 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("product/like"))))
        

// @LINE:104
private[this] lazy val com_pencho_pai_controllers_ProductController_getHot74 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("product/getHot"))))
        

// @LINE:105
private[this] lazy val com_pencho_pai_controllers_ProductController_findByID75 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("product/findByID"))))
        

// @LINE:106
private[this] lazy val com_pencho_pai_controllers_ProductController_add2WishList76 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("product/add2WishList"))))
        

// @LINE:107
private[this] lazy val com_pencho_pai_controllers_ProductController_wishListOfUserID77 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("product/wishListOfUserID"))))
        

// @LINE:108
private[this] lazy val com_pencho_pai_controllers_ProductController_removeFromWishList78 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("product/removeFromWishList"))))
        

// @LINE:112
private[this] lazy val com_pencho_pai_controllers_PostController_create79 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post/create"))))
        

// @LINE:113
private[this] lazy val com_pencho_pai_controllers_PostController_edit80 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post/edit"))))
        

// @LINE:114
private[this] lazy val com_pencho_pai_controllers_PostController_delete81 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post/delete"))))
        

// @LINE:115
private[this] lazy val com_pencho_pai_controllers_PostController_get82 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post/get"))))
        

// @LINE:116
private[this] lazy val com_pencho_pai_controllers_PostController_getPublic83 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post/getPublic"))))
        

// @LINE:117
private[this] lazy val com_pencho_pai_controllers_PostController_getFollower84 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post/getFollower"))))
        

// @LINE:118
private[this] lazy val com_pencho_pai_controllers_PostController_getFriend85 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post/getFriend"))))
        

// @LINE:119
private[this] lazy val com_pencho_pai_controllers_PostController_getShowOff86 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post/getShowOff"))))
        

// @LINE:120
private[this] lazy val com_pencho_pai_controllers_PostController_getAllFromUserID87 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post/getAllFromUserID"))))
        

// @LINE:121
private[this] lazy val com_pencho_pai_controllers_PostController_like88 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("post/like"))))
        

// @LINE:125
private[this] lazy val com_pencho_pai_controllers_ShopController_set89 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("shop/set"))))
        

// @LINE:126
private[this] lazy val com_pencho_pai_controllers_ShopController_getMine90 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("shop/getMine"))))
        

// @LINE:127
private[this] lazy val com_pencho_pai_controllers_ShopController_getShopById91 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("shop/getShopById"))))
        

// @LINE:128
private[this] lazy val com_pencho_pai_controllers_ShopController_drop92 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("shop/drop"))))
        

// @LINE:129
private[this] lazy val com_pencho_pai_controllers_ShopController_revert93 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("shop/revert"))))
        

// @LINE:130
private[this] lazy val com_pencho_pai_controllers_ShopController_like94 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("shop/like"))))
        

// @LINE:131
private[this] lazy val com_pencho_pai_controllers_ShopController_getShopAround95 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("shop/getShopAround"))))
        

// @LINE:132
private[this] lazy val com_pencho_pai_controllers_ShopController_follow96 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("shop/follow"))))
        

// @LINE:133
private[this] lazy val com_pencho_pai_controllers_ShopController_unfollow97 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("shop/unfollow"))))
        

// @LINE:134
private[this] lazy val com_pencho_pai_controllers_ShopController_myShopLevel98 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("shop/myShopLevel"))))
        

// @LINE:135
private[this] lazy val com_pencho_pai_controllers_ShopController_share99 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("shop/share"))))
        

// @LINE:140
private[this] lazy val com_pencho_pai_controllers_MessageController_create100 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("message/create"))))
        

// @LINE:141
private[this] lazy val com_pencho_pai_controllers_MessageController_getMy101 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("message/getMy"))))
        

// @LINE:142
private[this] lazy val com_pencho_pai_controllers_MessageController_getMessageSend102 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("message/getMessageSend"))))
        

// @LINE:143
private[this] lazy val com_pencho_pai_controllers_MessageController_destroy103 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("message/destroy"))))
        

// @LINE:147
private[this] lazy val com_pencho_pai_controllers_SnapShotController_create104 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("snapshot/create"))))
        

// @LINE:148
private[this] lazy val com_pencho_pai_controllers_SnapShotController_getByUserID105 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("snapshot/getByUserID"))))
        

// @LINE:149
private[this] lazy val com_pencho_pai_controllers_SnapShotController_like106 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("snapshot/like"))))
        

// @LINE:150
private[this] lazy val com_pencho_pai_controllers_SnapShotController_destroy107 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("snapshot/destroy"))))
        

// @LINE:151
private[this] lazy val com_pencho_pai_controllers_SnapShotController_get108 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("snapshot/get"))))
        

// @LINE:155
private[this] lazy val com_pencho_pai_controllers_SearchController_findProductBy109 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("search/product"))))
        

// @LINE:156
private[this] lazy val com_pencho_pai_controllers_SearchController_findShopBy110 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("search/shop"))))
        

// @LINE:157
private[this] lazy val com_pencho_pai_controllers_SearchController_findUserBy111 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("search/user"))))
        

// @LINE:158
private[this] lazy val com_pencho_pai_controllers_SearchController_findUserByGender112 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("search/sortUserByGender"))))
        

// @LINE:159
private[this] lazy val com_pencho_pai_controllers_SearchController_findFriendBy113 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("search/friend"))))
        

// @LINE:160
private[this] lazy val com_pencho_pai_controllers_SearchController_findFriendByGender114 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("search/friendByGender"))))
        

// @LINE:161
private[this] lazy val com_pencho_pai_controllers_SearchController_findWishlistBy115 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("search/wishlist"))))
        

// @LINE:162
private[this] lazy val com_pencho_pai_controllers_SearchController_findFashionHelpBy116 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("search/fashionHelp"))))
        

// @LINE:165
private[this] lazy val com_pencho_pai_controllers_ShareController_getByUserID117 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("share/getByUserID"))))
        

// @LINE:166
private[this] lazy val com_pencho_pai_controllers_ShareController_shareOfPost118 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("share/post"))))
        

// @LINE:167
private[this] lazy val com_pencho_pai_controllers_ShareController_shareOfProduct119 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("share/product"))))
        

// @LINE:168
private[this] lazy val com_pencho_pai_controllers_ShareController_shareOfSnapShot120 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("share/snapshot"))))
        

// @LINE:169
private[this] lazy val com_pencho_pai_controllers_ShareController_shareOfWardrobe121 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("share/wardrobe"))))
        

// @LINE:173
private[this] lazy val com_pencho_pai_controllers_WardrobeController_create122 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("wardrobe/create"))))
        

// @LINE:174
private[this] lazy val com_pencho_pai_controllers_WardrobeController_getByUserID123 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("wardrobe/getByUserID"))))
        

// @LINE:175
private[this] lazy val com_pencho_pai_controllers_WardrobeController_like124 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("wardrobe/like"))))
        

// @LINE:176
private[this] lazy val com_pencho_pai_controllers_WardrobeController_destroy125 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("wardrobe/destroy"))))
        

// @LINE:177
private[this] lazy val com_pencho_pai_controllers_WardrobeController_get126 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("wardrobe/get"))))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix,"""com.pencho.pai.controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user""","""com.pencho.pai.controllers.Application.user()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """MyStatus""","""com.pencho.pai.controllers.Application.MyStatus()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""com.pencho.pai.controllers.Application.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""com.pencho.pai.controllers.Application.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """file""","""com.pencho.pai.controllers.Application.file()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment""","""com.pencho.pai.controllers.Application.comment()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """product""","""com.pencho.pai.controllers.Application.product()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """news""","""com.pencho.pai.controllers.Application.news()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post""","""com.pencho.pai.controllers.Application.post()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """help""","""com.pencho.pai.controllers.Application.help()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """shop""","""com.pencho.pai.controllers.Application.shop()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """search""","""com.pencho.pai.controllers.Application.search()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """message""","""com.pencho.pai.controllers.Application.message()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """snapShot""","""com.pencho.pai.controllers.Application.snapShot()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """share""","""com.pencho.pai.controllers.Application.share()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """wardrobe""","""com.pencho.pai.controllers.Application.wardrobe()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """wholeSale""","""com.pencho.pai.controllers.Application.wholeSale()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """file/$filesType<[^/]+>/new""","""com.pencho.pai.controllers.FileManager.createFile(filesType:String, width:Integer ?= 256, length:Integer ?= 144, width2:Integer ?= 512, length2:Integer ?= 288)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """file/$filesType<[^/]+>/destroy/$file<.+>""","""com.pencho.pai.controllers.FileManager.destroyFile(filesType:String, file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """file/$filesType<[^/]+>/mine""","""com.pencho.pai.controllers.FileManager.getMyFile(filesType:String, page:Integer ?= 1, nbObjectByPage:Integer ?= 50)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """file/$filesType<[^/]+>/$file<.+>""","""com.pencho.pai.controllers.FileManager.getFile(filesType:String, file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/sendSMS""","""com.pencho.pai.controllers.UserController.sendSMS()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/resendSMS""","""com.pencho.pai.controllers.UserController.resendSMS()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/doValidateSMS""","""com.pencho.pai.controllers.UserController.doValidateSMS()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/redoValidateSMS""","""com.pencho.pai.controllers.UserController.redoValidateSMS()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/createPsw""","""com.pencho.pai.controllers.UserController.createPsw()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/recreatePsw""","""com.pencho.pai.controllers.UserController.recreatePsw()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/createProfile""","""com.pencho.pai.controllers.UserController.createProfile()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/getStarOfTheDay""","""com.pencho.pai.controllers.UserController.getStarOfTheDay()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/replyFriendRequest""","""com.pencho.pai.controllers.UserController.replyFriendRequest()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/update""","""com.pencho.pai.controllers.UserController.update()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/addFriend""","""com.pencho.pai.controllers.UserController.addFriend()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/add2BlackList""","""com.pencho.pai.controllers.UserController.add2BlackList()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/deleteUserFromBlackList""","""com.pencho.pai.controllers.UserController.deleteUserFromBlackList()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/deleteUserFromFriendList""","""com.pencho.pai.controllers.UserController.deleteUserFromFriendList()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/getBlackList""","""com.pencho.pai.controllers.UserController.getBlackList()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/findFriendsUnaudited""","""com.pencho.pai.controllers.UserController.findFriendsUnaudited()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/find""","""com.pencho.pai.controllers.UserController.find(page:Integer = 1, nbObjectByPagepage:Integer = 1, phone:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/findFriends""","""com.pencho.pai.controllers.UserController.findFriends()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/findUserByID""","""com.pencho.pai.controllers.UserController.findUserByID()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/follow""","""com.pencho.pai.controllers.UserController.follow()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/whoFollowMe""","""com.pencho.pai.controllers.UserController.whoFollowMe(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/whoIFollowed""","""com.pencho.pai.controllers.UserController.whoIFollowed(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/whoShopIFollowed""","""com.pencho.pai.controllers.UserController.whoShopIFollowed(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/findByUsername""","""com.pencho.pai.controllers.UserController.findByUsername(username:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/unfollow""","""com.pencho.pai.controllers.UserController.unfollow()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/myUserLevel""","""com.pencho.pai.controllers.UserController.myUserLevel()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/myInformations""","""com.pencho.pai.controllers.UserController.myInformations()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment/create""","""com.pencho.pai.controllers.CommentController.create()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment/delete""","""com.pencho.pai.controllers.CommentController.delete()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment/edit""","""com.pencho.pai.controllers.CommentController.edit()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment/findByUserID""","""com.pencho.pai.controllers.CommentController.findByUserID(start:Integer ?= 1, end:Integer ?= 16)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment/findByHelpID""","""com.pencho.pai.controllers.CommentController.findByHelpID(helpID:String, start:Integer ?= 1, end:Integer ?= 16)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment/findByPostID""","""com.pencho.pai.controllers.CommentController.findByPostID(postID:String, start:Integer ?= 1, end:Integer ?= 16)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """comment/findByProductID""","""com.pencho.pai.controllers.CommentController.findByProductID(productID:String, start:Integer ?= 1, end:Integer ?= 16)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """news/create""","""com.pencho.pai.controllers.FashionNewsController.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """news/get""","""com.pencho.pai.controllers.FashionNewsController.get(start:Integer ?= 1, end:Integer ?= 16)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """news/like""","""com.pencho.pai.controllers.FashionNewsController.like()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """help/create""","""com.pencho.pai.controllers.FashionHelpController.create()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """help/edit""","""com.pencho.pai.controllers.FashionHelpController.edit()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """help/delete""","""com.pencho.pai.controllers.FashionHelpController.delete()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """help/get""","""com.pencho.pai.controllers.FashionHelpController.get(start:Integer ?= 1, end:Integer ?= 16)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """help/saveHelp""","""com.pencho.pai.controllers.FashionHelpController.saveHelp()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """help/unsaveHelp""","""com.pencho.pai.controllers.FashionHelpController.unsaveHelp()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """help/getSavedHelp""","""com.pencho.pai.controllers.FashionHelpController.getSavedHelp()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """help/like""","""com.pencho.pai.controllers.FashionHelpController.like()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """product/create""","""com.pencho.pai.controllers.ProductController.create()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """product/edit""","""com.pencho.pai.controllers.ProductController.edit()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """product/delete""","""com.pencho.pai.controllers.ProductController.delete()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """product/findByShopID""","""com.pencho.pai.controllers.ProductController.findByShopID(start:Integer ?= 1, end:Integer ?= 16)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """product/findTrendyStyleByShopID""","""com.pencho.pai.controllers.ProductController.findTrendyStyleByShopID(shopID:String, start:Integer ?= 1, end:Integer ?= 16)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """product/like""","""com.pencho.pai.controllers.ProductController.like()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """product/getHot""","""com.pencho.pai.controllers.ProductController.getHot(start:Integer ?= 1, end:Integer ?= 16)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """product/findByID""","""com.pencho.pai.controllers.ProductController.findByID()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """product/add2WishList""","""com.pencho.pai.controllers.ProductController.add2WishList()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """product/wishListOfUserID""","""com.pencho.pai.controllers.ProductController.wishListOfUserID(userID:String, start:Integer ?= 1, end:Integer ?= 16)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """product/removeFromWishList""","""com.pencho.pai.controllers.ProductController.removeFromWishList"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post/create""","""com.pencho.pai.controllers.PostController.create()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post/edit""","""com.pencho.pai.controllers.PostController.edit()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post/delete""","""com.pencho.pai.controllers.PostController.delete()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post/get""","""com.pencho.pai.controllers.PostController.get(postID:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post/getPublic""","""com.pencho.pai.controllers.PostController.getPublic(start:Integer ?= 1, end:Integer ?= 16)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post/getFollower""","""com.pencho.pai.controllers.PostController.getFollower(start:Integer ?= 1, end:Integer ?= 16)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post/getFriend""","""com.pencho.pai.controllers.PostController.getFriend(start:Integer ?= 1, end:Integer ?= 16)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post/getShowOff""","""com.pencho.pai.controllers.PostController.getShowOff(userID:String, start:Integer ?= 1, end:Integer ?= 16)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post/getAllFromUserID""","""com.pencho.pai.controllers.PostController.getAllFromUserID(userID:String, start:Integer ?= 1, end:Integer ?= 16)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """post/like""","""com.pencho.pai.controllers.PostController.like()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """shop/set""","""com.pencho.pai.controllers.ShopController.set(pic1:String ?= "", pic2:String ?= "", video1:String ?= "", video2:String ?= "", video3:String ?= "", video4:String ?= "", video5:String ?= "", video6:String ?= "")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """shop/getMine""","""com.pencho.pai.controllers.ShopController.getMine()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """shop/getShopById""","""com.pencho.pai.controllers.ShopController.getShopById()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """shop/drop""","""com.pencho.pai.controllers.ShopController.drop()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """shop/revert""","""com.pencho.pai.controllers.ShopController.revert()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """shop/like""","""com.pencho.pai.controllers.ShopController.like()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """shop/getShopAround""","""com.pencho.pai.controllers.ShopController.getShopAround(radius:Double ?= 1, longitude:Double ?= 50, latitude:Double ?= 50)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """shop/follow""","""com.pencho.pai.controllers.ShopController.follow()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """shop/unfollow""","""com.pencho.pai.controllers.ShopController.unfollow()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """shop/myShopLevel""","""com.pencho.pai.controllers.ShopController.myShopLevel()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """shop/share""","""com.pencho.pai.controllers.ShopController.share()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """message/create""","""com.pencho.pai.controllers.MessageController.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """message/getMy""","""com.pencho.pai.controllers.MessageController.getMy(start:Integer ?= 1, end:Integer ?= 16)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """message/getMessageSend""","""com.pencho.pai.controllers.MessageController.getMessageSend(start:Integer ?= 1, end:Integer ?= 16)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """message/destroy""","""com.pencho.pai.controllers.MessageController.destroy()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """snapshot/create""","""com.pencho.pai.controllers.SnapShotController.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """snapshot/getByUserID""","""com.pencho.pai.controllers.SnapShotController.getByUserID(userID:String, start:Integer ?= 1, end:Integer ?= 16)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """snapshot/like""","""com.pencho.pai.controllers.SnapShotController.like()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """snapshot/destroy""","""com.pencho.pai.controllers.SnapShotController.destroy()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """snapshot/get""","""com.pencho.pai.controllers.SnapShotController.get(snapshotID:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """search/product""","""com.pencho.pai.controllers.SearchController.findProductBy(productProperty:String ?= "", lowPrice:String ?= "", highPrice:String ?= "", priceOrder:String ?= "")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """search/shop""","""com.pencho.pai.controllers.SearchController.findShopBy(shopProperty:String ?= "")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """search/user""","""com.pencho.pai.controllers.SearchController.findUserBy(userProperty:String ?= "")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """search/sortUserByGender""","""com.pencho.pai.controllers.SearchController.findUserByGender(genderStr:String ?= "")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """search/friend""","""com.pencho.pai.controllers.SearchController.findFriendBy(friendProperty:String ?= "")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """search/friendByGender""","""com.pencho.pai.controllers.SearchController.findFriendByGender(genderStr:String ?= "")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """search/wishlist""","""com.pencho.pai.controllers.SearchController.findWishlistBy(wishlistProperty:String ?= "")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """search/fashionHelp""","""com.pencho.pai.controllers.SearchController.findFashionHelpBy(fashionHelpProperty:String ?= "")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """share/getByUserID""","""com.pencho.pai.controllers.ShareController.getByUserID(userID:String ?= "", theType:String ?= "")"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """share/post""","""com.pencho.pai.controllers.ShareController.shareOfPost()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """share/product""","""com.pencho.pai.controllers.ShareController.shareOfProduct()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """share/snapshot""","""com.pencho.pai.controllers.ShareController.shareOfSnapShot()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """share/wardrobe""","""com.pencho.pai.controllers.ShareController.shareOfWardrobe()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """wardrobe/create""","""com.pencho.pai.controllers.WardrobeController.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """wardrobe/getByUserID""","""com.pencho.pai.controllers.WardrobeController.getByUserID(userID:String, start:Integer ?= 1, end:Integer ?= 16)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """wardrobe/like""","""com.pencho.pai.controllers.WardrobeController.like()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """wardrobe/destroy""","""com.pencho.pai.controllers.WardrobeController.destroy()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """wardrobe/get""","""com.pencho.pai.controllers.WardrobeController.get(wardrobeID:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Assets_at0(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:10
case com_pencho_pai_controllers_Application_index1(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.Application.index(), HandlerDef(this, "com.pencho.pai.controllers.Application", "index", Nil,"GET", """ >>>>>>>>>>>>>>>>>>>
 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>HTML
 HTML""", Routes.prefix + """"""))
   }
}
        

// @LINE:11
case com_pencho_pai_controllers_Application_user2(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.Application.user(), HandlerDef(this, "com.pencho.pai.controllers.Application", "user", Nil,"GET", """""", Routes.prefix + """user"""))
   }
}
        

// @LINE:12
case com_pencho_pai_controllers_Application_MyStatus3(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.Application.MyStatus(), HandlerDef(this, "com.pencho.pai.controllers.Application", "MyStatus", Nil,"GET", """""", Routes.prefix + """MyStatus"""))
   }
}
        

// @LINE:13
case com_pencho_pai_controllers_Application_login4(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.Application.login(), HandlerDef(this, "com.pencho.pai.controllers.Application", "login", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:14
case com_pencho_pai_controllers_Application_logout5(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.Application.logout(), HandlerDef(this, "com.pencho.pai.controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:15
case com_pencho_pai_controllers_Application_file6(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.Application.file(), HandlerDef(this, "com.pencho.pai.controllers.Application", "file", Nil,"GET", """""", Routes.prefix + """file"""))
   }
}
        

// @LINE:16
case com_pencho_pai_controllers_Application_comment7(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.Application.comment(), HandlerDef(this, "com.pencho.pai.controllers.Application", "comment", Nil,"GET", """""", Routes.prefix + """comment"""))
   }
}
        

// @LINE:17
case com_pencho_pai_controllers_Application_product8(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.Application.product(), HandlerDef(this, "com.pencho.pai.controllers.Application", "product", Nil,"GET", """""", Routes.prefix + """product"""))
   }
}
        

// @LINE:18
case com_pencho_pai_controllers_Application_news9(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.Application.news(), HandlerDef(this, "com.pencho.pai.controllers.Application", "news", Nil,"GET", """""", Routes.prefix + """news"""))
   }
}
        

// @LINE:19
case com_pencho_pai_controllers_Application_post10(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.Application.post(), HandlerDef(this, "com.pencho.pai.controllers.Application", "post", Nil,"GET", """""", Routes.prefix + """post"""))
   }
}
        

// @LINE:20
case com_pencho_pai_controllers_Application_help11(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.Application.help(), HandlerDef(this, "com.pencho.pai.controllers.Application", "help", Nil,"GET", """""", Routes.prefix + """help"""))
   }
}
        

// @LINE:21
case com_pencho_pai_controllers_Application_shop12(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.Application.shop(), HandlerDef(this, "com.pencho.pai.controllers.Application", "shop", Nil,"GET", """""", Routes.prefix + """shop"""))
   }
}
        

// @LINE:22
case com_pencho_pai_controllers_Application_search13(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.Application.search(), HandlerDef(this, "com.pencho.pai.controllers.Application", "search", Nil,"GET", """""", Routes.prefix + """search"""))
   }
}
        

// @LINE:23
case com_pencho_pai_controllers_Application_message14(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.Application.message(), HandlerDef(this, "com.pencho.pai.controllers.Application", "message", Nil,"GET", """""", Routes.prefix + """message"""))
   }
}
        

// @LINE:24
case com_pencho_pai_controllers_Application_snapShot15(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.Application.snapShot(), HandlerDef(this, "com.pencho.pai.controllers.Application", "snapShot", Nil,"GET", """""", Routes.prefix + """snapShot"""))
   }
}
        

// @LINE:25
case com_pencho_pai_controllers_Application_share16(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.Application.share(), HandlerDef(this, "com.pencho.pai.controllers.Application", "share", Nil,"GET", """""", Routes.prefix + """share"""))
   }
}
        

// @LINE:26
case com_pencho_pai_controllers_Application_wardrobe17(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.Application.wardrobe(), HandlerDef(this, "com.pencho.pai.controllers.Application", "wardrobe", Nil,"GET", """""", Routes.prefix + """wardrobe"""))
   }
}
        

// @LINE:27
case com_pencho_pai_controllers_Application_wholeSale18(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.Application.wholeSale(), HandlerDef(this, "com.pencho.pai.controllers.Application", "wholeSale", Nil,"GET", """""", Routes.prefix + """wholeSale"""))
   }
}
        

// @LINE:31
case com_pencho_pai_controllers_FileManager_createFile19(params) => {
   call(params.fromPath[String]("filesType", None), params.fromQuery[Integer]("width", Some(256)), params.fromQuery[Integer]("length", Some(144)), params.fromQuery[Integer]("width2", Some(512)), params.fromQuery[Integer]("length2", Some(288))) { (filesType, width, length, width2, length2) =>
        invokeHandler(com.pencho.pai.controllers.FileManager.createFile(filesType, width, length, width2, length2), HandlerDef(this, "com.pencho.pai.controllers.FileManager", "createFile", Seq(classOf[String], classOf[Integer], classOf[Integer], classOf[Integer], classOf[Integer]),"POST", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>File
# File""", Routes.prefix + """file/$filesType<[^/]+>/new"""))
   }
}
        

// @LINE:32
case com_pencho_pai_controllers_FileManager_destroyFile20(params) => {
   call(params.fromPath[String]("filesType", None), params.fromPath[String]("file", None)) { (filesType, file) =>
        invokeHandler(com.pencho.pai.controllers.FileManager.destroyFile(filesType, file), HandlerDef(this, "com.pencho.pai.controllers.FileManager", "destroyFile", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """file/$filesType<[^/]+>/destroy/$file<.+>"""))
   }
}
        

// @LINE:33
case com_pencho_pai_controllers_FileManager_getMyFile21(params) => {
   call(params.fromPath[String]("filesType", None), params.fromQuery[Integer]("page", Some(1)), params.fromQuery[Integer]("nbObjectByPage", Some(50))) { (filesType, page, nbObjectByPage) =>
        invokeHandler(com.pencho.pai.controllers.FileManager.getMyFile(filesType, page, nbObjectByPage), HandlerDef(this, "com.pencho.pai.controllers.FileManager", "getMyFile", Seq(classOf[String], classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """file/$filesType<[^/]+>/mine"""))
   }
}
        

// @LINE:34
case com_pencho_pai_controllers_FileManager_getFile22(params) => {
   call(params.fromPath[String]("filesType", None), params.fromPath[String]("file", None)) { (filesType, file) =>
        invokeHandler(com.pencho.pai.controllers.FileManager.getFile(filesType, file), HandlerDef(this, "com.pencho.pai.controllers.FileManager", "getFile", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """file/$filesType<[^/]+>/$file<.+>"""))
   }
}
        

// @LINE:38
case com_pencho_pai_controllers_UserController_sendSMS23(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.sendSMS(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "sendSMS", Nil,"GET", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>User
# User""", Routes.prefix + """user/sendSMS"""))
   }
}
        

// @LINE:39
case com_pencho_pai_controllers_UserController_resendSMS24(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.resendSMS(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "resendSMS", Nil,"GET", """""", Routes.prefix + """user/resendSMS"""))
   }
}
        

// @LINE:40
case com_pencho_pai_controllers_UserController_doValidateSMS25(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.doValidateSMS(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "doValidateSMS", Nil,"POST", """""", Routes.prefix + """user/doValidateSMS"""))
   }
}
        

// @LINE:41
case com_pencho_pai_controllers_UserController_redoValidateSMS26(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.redoValidateSMS(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "redoValidateSMS", Nil,"POST", """""", Routes.prefix + """user/redoValidateSMS"""))
   }
}
        

// @LINE:42
case com_pencho_pai_controllers_UserController_createPsw27(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.createPsw(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "createPsw", Nil,"POST", """""", Routes.prefix + """user/createPsw"""))
   }
}
        

// @LINE:43
case com_pencho_pai_controllers_UserController_recreatePsw28(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.recreatePsw(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "recreatePsw", Nil,"POST", """""", Routes.prefix + """user/recreatePsw"""))
   }
}
        

// @LINE:44
case com_pencho_pai_controllers_UserController_createProfile29(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.createProfile(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "createProfile", Nil,"POST", """""", Routes.prefix + """user/createProfile"""))
   }
}
        

// @LINE:45
case com_pencho_pai_controllers_UserController_getStarOfTheDay30(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.getStarOfTheDay(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "getStarOfTheDay", Nil,"GET", """""", Routes.prefix + """user/getStarOfTheDay"""))
   }
}
        

// @LINE:46
case com_pencho_pai_controllers_UserController_replyFriendRequest31(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.replyFriendRequest(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "replyFriendRequest", Nil,"POST", """""", Routes.prefix + """user/replyFriendRequest"""))
   }
}
        

// @LINE:47
case com_pencho_pai_controllers_UserController_update32(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.update(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "update", Nil,"POST", """""", Routes.prefix + """user/update"""))
   }
}
        

// @LINE:48
case com_pencho_pai_controllers_UserController_addFriend33(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.addFriend(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "addFriend", Nil,"POST", """""", Routes.prefix + """user/addFriend"""))
   }
}
        

// @LINE:49
case com_pencho_pai_controllers_UserController_add2BlackList34(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.add2BlackList(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "add2BlackList", Nil,"POST", """""", Routes.prefix + """user/add2BlackList"""))
   }
}
        

// @LINE:50
case com_pencho_pai_controllers_UserController_deleteUserFromBlackList35(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.deleteUserFromBlackList(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "deleteUserFromBlackList", Nil,"POST", """""", Routes.prefix + """user/deleteUserFromBlackList"""))
   }
}
        

// @LINE:51
case com_pencho_pai_controllers_UserController_deleteUserFromFriendList36(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.deleteUserFromFriendList(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "deleteUserFromFriendList", Nil,"POST", """""", Routes.prefix + """user/deleteUserFromFriendList"""))
   }
}
        

// @LINE:52
case com_pencho_pai_controllers_UserController_getBlackList37(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.getBlackList(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "getBlackList", Nil,"GET", """""", Routes.prefix + """user/getBlackList"""))
   }
}
        

// @LINE:53
case com_pencho_pai_controllers_UserController_findFriendsUnaudited38(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.findFriendsUnaudited(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "findFriendsUnaudited", Nil,"GET", """""", Routes.prefix + """user/findFriendsUnaudited"""))
   }
}
        

// @LINE:54
case com_pencho_pai_controllers_UserController_find39(params) => {
   call(Param[Integer]("page", Right(1)), Param[Integer]("nbObjectByPagepage", Right(1)), params.fromQuery[String]("phone", None)) { (page, nbObjectByPagepage, phone) =>
        invokeHandler(com.pencho.pai.controllers.UserController.find(page, nbObjectByPagepage, phone), HandlerDef(this, "com.pencho.pai.controllers.UserController", "find", Seq(classOf[Integer], classOf[Integer], classOf[String]),"GET", """""", Routes.prefix + """user/find"""))
   }
}
        

// @LINE:55
case com_pencho_pai_controllers_UserController_findFriends40(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.findFriends(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "findFriends", Nil,"GET", """""", Routes.prefix + """user/findFriends"""))
   }
}
        

// @LINE:56
case com_pencho_pai_controllers_UserController_findUserByID41(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.findUserByID(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "findUserByID", Nil,"GET", """""", Routes.prefix + """user/findUserByID"""))
   }
}
        

// @LINE:57
case com_pencho_pai_controllers_UserController_follow42(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.follow(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "follow", Nil,"POST", """""", Routes.prefix + """user/follow"""))
   }
}
        

// @LINE:58
case com_pencho_pai_controllers_UserController_whoFollowMe43(params) => {
   call(params.fromQuery[String]("id", None)) { (id) =>
        invokeHandler(com.pencho.pai.controllers.UserController.whoFollowMe(id), HandlerDef(this, "com.pencho.pai.controllers.UserController", "whoFollowMe", Seq(classOf[String]),"GET", """""", Routes.prefix + """user/whoFollowMe"""))
   }
}
        

// @LINE:59
case com_pencho_pai_controllers_UserController_whoIFollowed44(params) => {
   call(params.fromQuery[String]("id", None)) { (id) =>
        invokeHandler(com.pencho.pai.controllers.UserController.whoIFollowed(id), HandlerDef(this, "com.pencho.pai.controllers.UserController", "whoIFollowed", Seq(classOf[String]),"GET", """""", Routes.prefix + """user/whoIFollowed"""))
   }
}
        

// @LINE:60
case com_pencho_pai_controllers_UserController_whoShopIFollowed45(params) => {
   call(params.fromQuery[String]("id", None)) { (id) =>
        invokeHandler(com.pencho.pai.controllers.UserController.whoShopIFollowed(id), HandlerDef(this, "com.pencho.pai.controllers.UserController", "whoShopIFollowed", Seq(classOf[String]),"GET", """""", Routes.prefix + """user/whoShopIFollowed"""))
   }
}
        

// @LINE:61
case com_pencho_pai_controllers_UserController_findByUsername46(params) => {
   call(params.fromQuery[String]("username", None)) { (username) =>
        invokeHandler(com.pencho.pai.controllers.UserController.findByUsername(username), HandlerDef(this, "com.pencho.pai.controllers.UserController", "findByUsername", Seq(classOf[String]),"GET", """""", Routes.prefix + """user/findByUsername"""))
   }
}
        

// @LINE:62
case com_pencho_pai_controllers_UserController_unfollow47(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.unfollow(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "unfollow", Nil,"POST", """""", Routes.prefix + """user/unfollow"""))
   }
}
        

// @LINE:63
case com_pencho_pai_controllers_UserController_myUserLevel48(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.myUserLevel(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "myUserLevel", Nil,"GET", """""", Routes.prefix + """user/myUserLevel"""))
   }
}
        

// @LINE:64
case com_pencho_pai_controllers_UserController_myInformations49(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.UserController.myInformations(), HandlerDef(this, "com.pencho.pai.controllers.UserController", "myInformations", Nil,"GET", """""", Routes.prefix + """user/myInformations"""))
   }
}
        

// @LINE:70
case com_pencho_pai_controllers_CommentController_create50(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.CommentController.create(), HandlerDef(this, "com.pencho.pai.controllers.CommentController", "create", Nil,"POST", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Comment
# Comment""", Routes.prefix + """comment/create"""))
   }
}
        

// @LINE:71
case com_pencho_pai_controllers_CommentController_delete51(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.CommentController.delete(), HandlerDef(this, "com.pencho.pai.controllers.CommentController", "delete", Nil,"POST", """""", Routes.prefix + """comment/delete"""))
   }
}
        

// @LINE:72
case com_pencho_pai_controllers_CommentController_edit52(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.CommentController.edit(), HandlerDef(this, "com.pencho.pai.controllers.CommentController", "edit", Nil,"POST", """""", Routes.prefix + """comment/edit"""))
   }
}
        

// @LINE:73
case com_pencho_pai_controllers_CommentController_findByUserID53(params) => {
   call(params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (start, end) =>
        invokeHandler(com.pencho.pai.controllers.CommentController.findByUserID(start, end), HandlerDef(this, "com.pencho.pai.controllers.CommentController", "findByUserID", Seq(classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """comment/findByUserID"""))
   }
}
        

// @LINE:74
case com_pencho_pai_controllers_CommentController_findByHelpID54(params) => {
   call(params.fromQuery[String]("helpID", None), params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (helpID, start, end) =>
        invokeHandler(com.pencho.pai.controllers.CommentController.findByHelpID(helpID, start, end), HandlerDef(this, "com.pencho.pai.controllers.CommentController", "findByHelpID", Seq(classOf[String], classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """comment/findByHelpID"""))
   }
}
        

// @LINE:75
case com_pencho_pai_controllers_CommentController_findByPostID55(params) => {
   call(params.fromQuery[String]("postID", None), params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (postID, start, end) =>
        invokeHandler(com.pencho.pai.controllers.CommentController.findByPostID(postID, start, end), HandlerDef(this, "com.pencho.pai.controllers.CommentController", "findByPostID", Seq(classOf[String], classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """comment/findByPostID"""))
   }
}
        

// @LINE:76
case com_pencho_pai_controllers_CommentController_findByProductID56(params) => {
   call(params.fromQuery[String]("productID", None), params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (productID, start, end) =>
        invokeHandler(com.pencho.pai.controllers.CommentController.findByProductID(productID, start, end), HandlerDef(this, "com.pencho.pai.controllers.CommentController", "findByProductID", Seq(classOf[String], classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """comment/findByProductID"""))
   }
}
        

// @LINE:81
case com_pencho_pai_controllers_FashionNewsController_create57(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.FashionNewsController.create(), HandlerDef(this, "com.pencho.pai.controllers.FashionNewsController", "create", Nil,"POST", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>News
# News
 only create by pencho server""", Routes.prefix + """news/create"""))
   }
}
        

// @LINE:82
case com_pencho_pai_controllers_FashionNewsController_get58(params) => {
   call(params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (start, end) =>
        invokeHandler(com.pencho.pai.controllers.FashionNewsController.get(start, end), HandlerDef(this, "com.pencho.pai.controllers.FashionNewsController", "get", Seq(classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """news/get"""))
   }
}
        

// @LINE:83
case com_pencho_pai_controllers_FashionNewsController_like59(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.FashionNewsController.like(), HandlerDef(this, "com.pencho.pai.controllers.FashionNewsController", "like", Nil,"POST", """""", Routes.prefix + """news/like"""))
   }
}
        

// @LINE:87
case com_pencho_pai_controllers_FashionHelpController_create60(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.FashionHelpController.create(), HandlerDef(this, "com.pencho.pai.controllers.FashionHelpController", "create", Nil,"POST", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Help
# Help """, Routes.prefix + """help/create"""))
   }
}
        

// @LINE:88
case com_pencho_pai_controllers_FashionHelpController_edit61(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.FashionHelpController.edit(), HandlerDef(this, "com.pencho.pai.controllers.FashionHelpController", "edit", Nil,"POST", """""", Routes.prefix + """help/edit"""))
   }
}
        

// @LINE:89
case com_pencho_pai_controllers_FashionHelpController_delete62(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.FashionHelpController.delete(), HandlerDef(this, "com.pencho.pai.controllers.FashionHelpController", "delete", Nil,"POST", """""", Routes.prefix + """help/delete"""))
   }
}
        

// @LINE:90
case com_pencho_pai_controllers_FashionHelpController_get63(params) => {
   call(params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (start, end) =>
        invokeHandler(com.pencho.pai.controllers.FashionHelpController.get(start, end), HandlerDef(this, "com.pencho.pai.controllers.FashionHelpController", "get", Seq(classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """help/get"""))
   }
}
        

// @LINE:91
case com_pencho_pai_controllers_FashionHelpController_saveHelp64(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.FashionHelpController.saveHelp(), HandlerDef(this, "com.pencho.pai.controllers.FashionHelpController", "saveHelp", Nil,"POST", """""", Routes.prefix + """help/saveHelp"""))
   }
}
        

// @LINE:92
case com_pencho_pai_controllers_FashionHelpController_unsaveHelp65(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.FashionHelpController.unsaveHelp(), HandlerDef(this, "com.pencho.pai.controllers.FashionHelpController", "unsaveHelp", Nil,"POST", """""", Routes.prefix + """help/unsaveHelp"""))
   }
}
        

// @LINE:93
case com_pencho_pai_controllers_FashionHelpController_getSavedHelp66(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.FashionHelpController.getSavedHelp(), HandlerDef(this, "com.pencho.pai.controllers.FashionHelpController", "getSavedHelp", Nil,"GET", """""", Routes.prefix + """help/getSavedHelp"""))
   }
}
        

// @LINE:94
case com_pencho_pai_controllers_FashionHelpController_like67(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.FashionHelpController.like(), HandlerDef(this, "com.pencho.pai.controllers.FashionHelpController", "like", Nil,"POST", """""", Routes.prefix + """help/like"""))
   }
}
        

// @LINE:98
case com_pencho_pai_controllers_ProductController_create68(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ProductController.create(), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "create", Nil,"POST", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Product
# Product""", Routes.prefix + """product/create"""))
   }
}
        

// @LINE:99
case com_pencho_pai_controllers_ProductController_edit69(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ProductController.edit(), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "edit", Nil,"POST", """""", Routes.prefix + """product/edit"""))
   }
}
        

// @LINE:100
case com_pencho_pai_controllers_ProductController_delete70(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ProductController.delete(), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "delete", Nil,"POST", """""", Routes.prefix + """product/delete"""))
   }
}
        

// @LINE:101
case com_pencho_pai_controllers_ProductController_findByShopID71(params) => {
   call(params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (start, end) =>
        invokeHandler(com.pencho.pai.controllers.ProductController.findByShopID(start, end), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "findByShopID", Seq(classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """product/findByShopID"""))
   }
}
        

// @LINE:102
case com_pencho_pai_controllers_ProductController_findTrendyStyleByShopID72(params) => {
   call(params.fromQuery[String]("shopID", None), params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (shopID, start, end) =>
        invokeHandler(com.pencho.pai.controllers.ProductController.findTrendyStyleByShopID(shopID, start, end), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "findTrendyStyleByShopID", Seq(classOf[String], classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """product/findTrendyStyleByShopID"""))
   }
}
        

// @LINE:103
case com_pencho_pai_controllers_ProductController_like73(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ProductController.like(), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "like", Nil,"POST", """""", Routes.prefix + """product/like"""))
   }
}
        

// @LINE:104
case com_pencho_pai_controllers_ProductController_getHot74(params) => {
   call(params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (start, end) =>
        invokeHandler(com.pencho.pai.controllers.ProductController.getHot(start, end), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "getHot", Seq(classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """product/getHot"""))
   }
}
        

// @LINE:105
case com_pencho_pai_controllers_ProductController_findByID75(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ProductController.findByID(), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "findByID", Nil,"GET", """""", Routes.prefix + """product/findByID"""))
   }
}
        

// @LINE:106
case com_pencho_pai_controllers_ProductController_add2WishList76(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ProductController.add2WishList(), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "add2WishList", Nil,"POST", """""", Routes.prefix + """product/add2WishList"""))
   }
}
        

// @LINE:107
case com_pencho_pai_controllers_ProductController_wishListOfUserID77(params) => {
   call(params.fromQuery[String]("userID", None), params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (userID, start, end) =>
        invokeHandler(com.pencho.pai.controllers.ProductController.wishListOfUserID(userID, start, end), HandlerDef(this, "com.pencho.pai.controllers.ProductController", "wishListOfUserID", Seq(classOf[String], classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """product/wishListOfUserID"""))
   }
}
        

// @LINE:108
case com_pencho_pai_controllers_ProductController_removeFromWishList78(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ProductController.removeFromWishList, HandlerDef(this, "com.pencho.pai.controllers.ProductController", "removeFromWishList", Nil,"POST", """""", Routes.prefix + """product/removeFromWishList"""))
   }
}
        

// @LINE:112
case com_pencho_pai_controllers_PostController_create79(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.PostController.create(), HandlerDef(this, "com.pencho.pai.controllers.PostController", "create", Nil,"POST", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Post
# Post""", Routes.prefix + """post/create"""))
   }
}
        

// @LINE:113
case com_pencho_pai_controllers_PostController_edit80(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.PostController.edit(), HandlerDef(this, "com.pencho.pai.controllers.PostController", "edit", Nil,"POST", """""", Routes.prefix + """post/edit"""))
   }
}
        

// @LINE:114
case com_pencho_pai_controllers_PostController_delete81(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.PostController.delete(), HandlerDef(this, "com.pencho.pai.controllers.PostController", "delete", Nil,"POST", """""", Routes.prefix + """post/delete"""))
   }
}
        

// @LINE:115
case com_pencho_pai_controllers_PostController_get82(params) => {
   call(params.fromQuery[String]("postID", None)) { (postID) =>
        invokeHandler(com.pencho.pai.controllers.PostController.get(postID), HandlerDef(this, "com.pencho.pai.controllers.PostController", "get", Seq(classOf[String]),"GET", """""", Routes.prefix + """post/get"""))
   }
}
        

// @LINE:116
case com_pencho_pai_controllers_PostController_getPublic83(params) => {
   call(params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (start, end) =>
        invokeHandler(com.pencho.pai.controllers.PostController.getPublic(start, end), HandlerDef(this, "com.pencho.pai.controllers.PostController", "getPublic", Seq(classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """post/getPublic"""))
   }
}
        

// @LINE:117
case com_pencho_pai_controllers_PostController_getFollower84(params) => {
   call(params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (start, end) =>
        invokeHandler(com.pencho.pai.controllers.PostController.getFollower(start, end), HandlerDef(this, "com.pencho.pai.controllers.PostController", "getFollower", Seq(classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """post/getFollower"""))
   }
}
        

// @LINE:118
case com_pencho_pai_controllers_PostController_getFriend85(params) => {
   call(params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (start, end) =>
        invokeHandler(com.pencho.pai.controllers.PostController.getFriend(start, end), HandlerDef(this, "com.pencho.pai.controllers.PostController", "getFriend", Seq(classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """post/getFriend"""))
   }
}
        

// @LINE:119
case com_pencho_pai_controllers_PostController_getShowOff86(params) => {
   call(params.fromQuery[String]("userID", None), params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (userID, start, end) =>
        invokeHandler(com.pencho.pai.controllers.PostController.getShowOff(userID, start, end), HandlerDef(this, "com.pencho.pai.controllers.PostController", "getShowOff", Seq(classOf[String], classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """post/getShowOff"""))
   }
}
        

// @LINE:120
case com_pencho_pai_controllers_PostController_getAllFromUserID87(params) => {
   call(params.fromQuery[String]("userID", None), params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (userID, start, end) =>
        invokeHandler(com.pencho.pai.controllers.PostController.getAllFromUserID(userID, start, end), HandlerDef(this, "com.pencho.pai.controllers.PostController", "getAllFromUserID", Seq(classOf[String], classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """post/getAllFromUserID"""))
   }
}
        

// @LINE:121
case com_pencho_pai_controllers_PostController_like88(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.PostController.like(), HandlerDef(this, "com.pencho.pai.controllers.PostController", "like", Nil,"POST", """""", Routes.prefix + """post/like"""))
   }
}
        

// @LINE:125
case com_pencho_pai_controllers_ShopController_set89(params) => {
   call(params.fromQuery[String]("pic1", Some("")), params.fromQuery[String]("pic2", Some("")), params.fromQuery[String]("video1", Some("")), params.fromQuery[String]("video2", Some("")), params.fromQuery[String]("video3", Some("")), params.fromQuery[String]("video4", Some("")), params.fromQuery[String]("video5", Some("")), params.fromQuery[String]("video6", Some(""))) { (pic1, pic2, video1, video2, video3, video4, video5, video6) =>
        invokeHandler(com.pencho.pai.controllers.ShopController.set(pic1, pic2, video1, video2, video3, video4, video5, video6), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "set", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]),"GET", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Shop
# Shop""", Routes.prefix + """shop/set"""))
   }
}
        

// @LINE:126
case com_pencho_pai_controllers_ShopController_getMine90(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ShopController.getMine(), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "getMine", Nil,"GET", """""", Routes.prefix + """shop/getMine"""))
   }
}
        

// @LINE:127
case com_pencho_pai_controllers_ShopController_getShopById91(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ShopController.getShopById(), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "getShopById", Nil,"GET", """""", Routes.prefix + """shop/getShopById"""))
   }
}
        

// @LINE:128
case com_pencho_pai_controllers_ShopController_drop92(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ShopController.drop(), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "drop", Nil,"POST", """""", Routes.prefix + """shop/drop"""))
   }
}
        

// @LINE:129
case com_pencho_pai_controllers_ShopController_revert93(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ShopController.revert(), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "revert", Nil,"POST", """""", Routes.prefix + """shop/revert"""))
   }
}
        

// @LINE:130
case com_pencho_pai_controllers_ShopController_like94(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ShopController.like(), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "like", Nil,"POST", """""", Routes.prefix + """shop/like"""))
   }
}
        

// @LINE:131
case com_pencho_pai_controllers_ShopController_getShopAround95(params) => {
   call(params.fromQuery[Double]("radius", Some(1)), params.fromQuery[Double]("longitude", Some(50)), params.fromQuery[Double]("latitude", Some(50))) { (radius, longitude, latitude) =>
        invokeHandler(com.pencho.pai.controllers.ShopController.getShopAround(radius, longitude, latitude), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "getShopAround", Seq(classOf[Double], classOf[Double], classOf[Double]),"GET", """""", Routes.prefix + """shop/getShopAround"""))
   }
}
        

// @LINE:132
case com_pencho_pai_controllers_ShopController_follow96(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ShopController.follow(), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "follow", Nil,"POST", """""", Routes.prefix + """shop/follow"""))
   }
}
        

// @LINE:133
case com_pencho_pai_controllers_ShopController_unfollow97(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ShopController.unfollow(), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "unfollow", Nil,"POST", """""", Routes.prefix + """shop/unfollow"""))
   }
}
        

// @LINE:134
case com_pencho_pai_controllers_ShopController_myShopLevel98(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ShopController.myShopLevel(), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "myShopLevel", Nil,"GET", """""", Routes.prefix + """shop/myShopLevel"""))
   }
}
        

// @LINE:135
case com_pencho_pai_controllers_ShopController_share99(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ShopController.share(), HandlerDef(this, "com.pencho.pai.controllers.ShopController", "share", Nil,"POST", """""", Routes.prefix + """shop/share"""))
   }
}
        

// @LINE:140
case com_pencho_pai_controllers_MessageController_create100(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.MessageController.create(), HandlerDef(this, "com.pencho.pai.controllers.MessageController", "create", Nil,"POST", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Message
# Message""", Routes.prefix + """message/create"""))
   }
}
        

// @LINE:141
case com_pencho_pai_controllers_MessageController_getMy101(params) => {
   call(params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (start, end) =>
        invokeHandler(com.pencho.pai.controllers.MessageController.getMy(start, end), HandlerDef(this, "com.pencho.pai.controllers.MessageController", "getMy", Seq(classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """message/getMy"""))
   }
}
        

// @LINE:142
case com_pencho_pai_controllers_MessageController_getMessageSend102(params) => {
   call(params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (start, end) =>
        invokeHandler(com.pencho.pai.controllers.MessageController.getMessageSend(start, end), HandlerDef(this, "com.pencho.pai.controllers.MessageController", "getMessageSend", Seq(classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """message/getMessageSend"""))
   }
}
        

// @LINE:143
case com_pencho_pai_controllers_MessageController_destroy103(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.MessageController.destroy(), HandlerDef(this, "com.pencho.pai.controllers.MessageController", "destroy", Nil,"POST", """""", Routes.prefix + """message/destroy"""))
   }
}
        

// @LINE:147
case com_pencho_pai_controllers_SnapShotController_create104(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.SnapShotController.create(), HandlerDef(this, "com.pencho.pai.controllers.SnapShotController", "create", Nil,"POST", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Snapshot
# Snapshot""", Routes.prefix + """snapshot/create"""))
   }
}
        

// @LINE:148
case com_pencho_pai_controllers_SnapShotController_getByUserID105(params) => {
   call(params.fromQuery[String]("userID", None), params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (userID, start, end) =>
        invokeHandler(com.pencho.pai.controllers.SnapShotController.getByUserID(userID, start, end), HandlerDef(this, "com.pencho.pai.controllers.SnapShotController", "getByUserID", Seq(classOf[String], classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """snapshot/getByUserID"""))
   }
}
        

// @LINE:149
case com_pencho_pai_controllers_SnapShotController_like106(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.SnapShotController.like(), HandlerDef(this, "com.pencho.pai.controllers.SnapShotController", "like", Nil,"POST", """""", Routes.prefix + """snapshot/like"""))
   }
}
        

// @LINE:150
case com_pencho_pai_controllers_SnapShotController_destroy107(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.SnapShotController.destroy(), HandlerDef(this, "com.pencho.pai.controllers.SnapShotController", "destroy", Nil,"POST", """""", Routes.prefix + """snapshot/destroy"""))
   }
}
        

// @LINE:151
case com_pencho_pai_controllers_SnapShotController_get108(params) => {
   call(params.fromQuery[String]("snapshotID", None)) { (snapshotID) =>
        invokeHandler(com.pencho.pai.controllers.SnapShotController.get(snapshotID), HandlerDef(this, "com.pencho.pai.controllers.SnapShotController", "get", Seq(classOf[String]),"GET", """""", Routes.prefix + """snapshot/get"""))
   }
}
        

// @LINE:155
case com_pencho_pai_controllers_SearchController_findProductBy109(params) => {
   call(params.fromQuery[String]("productProperty", Some("")), params.fromQuery[String]("lowPrice", Some("")), params.fromQuery[String]("highPrice", Some("")), params.fromQuery[String]("priceOrder", Some(""))) { (productProperty, lowPrice, highPrice, priceOrder) =>
        invokeHandler(com.pencho.pai.controllers.SearchController.findProductBy(productProperty, lowPrice, highPrice, priceOrder), HandlerDef(this, "com.pencho.pai.controllers.SearchController", "findProductBy", Seq(classOf[String], classOf[String], classOf[String], classOf[String]),"GET", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Search
# Search """, Routes.prefix + """search/product"""))
   }
}
        

// @LINE:156
case com_pencho_pai_controllers_SearchController_findShopBy110(params) => {
   call(params.fromQuery[String]("shopProperty", Some(""))) { (shopProperty) =>
        invokeHandler(com.pencho.pai.controllers.SearchController.findShopBy(shopProperty), HandlerDef(this, "com.pencho.pai.controllers.SearchController", "findShopBy", Seq(classOf[String]),"GET", """""", Routes.prefix + """search/shop"""))
   }
}
        

// @LINE:157
case com_pencho_pai_controllers_SearchController_findUserBy111(params) => {
   call(params.fromQuery[String]("userProperty", Some(""))) { (userProperty) =>
        invokeHandler(com.pencho.pai.controllers.SearchController.findUserBy(userProperty), HandlerDef(this, "com.pencho.pai.controllers.SearchController", "findUserBy", Seq(classOf[String]),"GET", """""", Routes.prefix + """search/user"""))
   }
}
        

// @LINE:158
case com_pencho_pai_controllers_SearchController_findUserByGender112(params) => {
   call(params.fromQuery[String]("genderStr", Some(""))) { (genderStr) =>
        invokeHandler(com.pencho.pai.controllers.SearchController.findUserByGender(genderStr), HandlerDef(this, "com.pencho.pai.controllers.SearchController", "findUserByGender", Seq(classOf[String]),"GET", """""", Routes.prefix + """search/sortUserByGender"""))
   }
}
        

// @LINE:159
case com_pencho_pai_controllers_SearchController_findFriendBy113(params) => {
   call(params.fromQuery[String]("friendProperty", Some(""))) { (friendProperty) =>
        invokeHandler(com.pencho.pai.controllers.SearchController.findFriendBy(friendProperty), HandlerDef(this, "com.pencho.pai.controllers.SearchController", "findFriendBy", Seq(classOf[String]),"GET", """""", Routes.prefix + """search/friend"""))
   }
}
        

// @LINE:160
case com_pencho_pai_controllers_SearchController_findFriendByGender114(params) => {
   call(params.fromQuery[String]("genderStr", Some(""))) { (genderStr) =>
        invokeHandler(com.pencho.pai.controllers.SearchController.findFriendByGender(genderStr), HandlerDef(this, "com.pencho.pai.controllers.SearchController", "findFriendByGender", Seq(classOf[String]),"GET", """""", Routes.prefix + """search/friendByGender"""))
   }
}
        

// @LINE:161
case com_pencho_pai_controllers_SearchController_findWishlistBy115(params) => {
   call(params.fromQuery[String]("wishlistProperty", Some(""))) { (wishlistProperty) =>
        invokeHandler(com.pencho.pai.controllers.SearchController.findWishlistBy(wishlistProperty), HandlerDef(this, "com.pencho.pai.controllers.SearchController", "findWishlistBy", Seq(classOf[String]),"GET", """""", Routes.prefix + """search/wishlist"""))
   }
}
        

// @LINE:162
case com_pencho_pai_controllers_SearchController_findFashionHelpBy116(params) => {
   call(params.fromQuery[String]("fashionHelpProperty", Some(""))) { (fashionHelpProperty) =>
        invokeHandler(com.pencho.pai.controllers.SearchController.findFashionHelpBy(fashionHelpProperty), HandlerDef(this, "com.pencho.pai.controllers.SearchController", "findFashionHelpBy", Seq(classOf[String]),"GET", """""", Routes.prefix + """search/fashionHelp"""))
   }
}
        

// @LINE:165
case com_pencho_pai_controllers_ShareController_getByUserID117(params) => {
   call(params.fromQuery[String]("userID", Some("")), params.fromQuery[String]("theType", Some(""))) { (userID, theType) =>
        invokeHandler(com.pencho.pai.controllers.ShareController.getByUserID(userID, theType), HandlerDef(this, "com.pencho.pai.controllers.ShareController", "getByUserID", Seq(classOf[String], classOf[String]),"GET", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Share
# Share""", Routes.prefix + """share/getByUserID"""))
   }
}
        

// @LINE:166
case com_pencho_pai_controllers_ShareController_shareOfPost118(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ShareController.shareOfPost(), HandlerDef(this, "com.pencho.pai.controllers.ShareController", "shareOfPost", Nil,"POST", """""", Routes.prefix + """share/post"""))
   }
}
        

// @LINE:167
case com_pencho_pai_controllers_ShareController_shareOfProduct119(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ShareController.shareOfProduct(), HandlerDef(this, "com.pencho.pai.controllers.ShareController", "shareOfProduct", Nil,"POST", """""", Routes.prefix + """share/product"""))
   }
}
        

// @LINE:168
case com_pencho_pai_controllers_ShareController_shareOfSnapShot120(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ShareController.shareOfSnapShot(), HandlerDef(this, "com.pencho.pai.controllers.ShareController", "shareOfSnapShot", Nil,"POST", """""", Routes.prefix + """share/snapshot"""))
   }
}
        

// @LINE:169
case com_pencho_pai_controllers_ShareController_shareOfWardrobe121(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.ShareController.shareOfWardrobe(), HandlerDef(this, "com.pencho.pai.controllers.ShareController", "shareOfWardrobe", Nil,"POST", """""", Routes.prefix + """share/wardrobe"""))
   }
}
        

// @LINE:173
case com_pencho_pai_controllers_WardrobeController_create122(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.WardrobeController.create(), HandlerDef(this, "com.pencho.pai.controllers.WardrobeController", "create", Nil,"POST", """ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Wardrobe
# Wardrobe""", Routes.prefix + """wardrobe/create"""))
   }
}
        

// @LINE:174
case com_pencho_pai_controllers_WardrobeController_getByUserID123(params) => {
   call(params.fromQuery[String]("userID", None), params.fromQuery[Integer]("start", Some(1)), params.fromQuery[Integer]("end", Some(16))) { (userID, start, end) =>
        invokeHandler(com.pencho.pai.controllers.WardrobeController.getByUserID(userID, start, end), HandlerDef(this, "com.pencho.pai.controllers.WardrobeController", "getByUserID", Seq(classOf[String], classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """wardrobe/getByUserID"""))
   }
}
        

// @LINE:175
case com_pencho_pai_controllers_WardrobeController_like124(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.WardrobeController.like(), HandlerDef(this, "com.pencho.pai.controllers.WardrobeController", "like", Nil,"POST", """""", Routes.prefix + """wardrobe/like"""))
   }
}
        

// @LINE:176
case com_pencho_pai_controllers_WardrobeController_destroy125(params) => {
   call { 
        invokeHandler(com.pencho.pai.controllers.WardrobeController.destroy(), HandlerDef(this, "com.pencho.pai.controllers.WardrobeController", "destroy", Nil,"POST", """""", Routes.prefix + """wardrobe/destroy"""))
   }
}
        

// @LINE:177
case com_pencho_pai_controllers_WardrobeController_get126(params) => {
   call(params.fromQuery[String]("wardrobeID", None)) { (wardrobeID) =>
        invokeHandler(com.pencho.pai.controllers.WardrobeController.get(wardrobeID), HandlerDef(this, "com.pencho.pai.controllers.WardrobeController", "get", Seq(classOf[String]),"GET", """""", Routes.prefix + """wardrobe/get"""))
   }
}
        
}

}
     