
package com.pencho.pai.views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object shop extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Shop -->
<h1>--------------------------------------------->>> Shop >>></h1>


<h4> 	>>Create shop</h4>
<br/>	>>URL :GET	/shop/set
<br/>	>>Required Parameter :
<br/>	>>Return value :shop id
<br/>	>>Description :
<br/>
set shop :	
		<form method="GET" action="/shop/set">
shopName:	
			<input type="text" name="name">
location:
			<input type="text" name="location">
longitude:
			<input type="text" name="longitude">
latitude:
			<input type="text" name="latitude">
categories:
			<input type="text" name="categories"> 
Tag:
			<input type="text" name="tag"> 
About us:
			<input type="text" name="description"> 
Picture:
			<input type="text" name="pic1"> 
CoverPicture:
			<input type="text" name="pic2"> 
videoID1:
			<input type="text" name="video1"> 
videoID2:
			<input type="text" name="video2"> 
videoID3:
			<input type="text" name="video3"> 
videoID4:
			<input type="text" name="video4"> 
videoID5:
			<input type="text" name="video5"> 
videoID6:
			<input type="text" name="video6"> 
			<input type="submit" value="set" >
		</form>


<h4> 	>>get my shop</h4>
<br/>	>>URL :GET	/shop/getMine
<br/>	>>Required Parameter :
<br/>	>>Return value :
<br/>	>>Description :
<br/>
		<form method="GET" action="/shop/getMine">
Get my shop:	
			<input type="submit" value="Get" >
		</form>
		

<h4> 	>>get one shop</h4>
<br/>	>>URL :GET	/shop/getShopById
<br/>	>>Required Parameter :
<br/>	>>Return value :
<br/>	>>Description :
<br/>
Get my shop:	
		<form method="GET" action="/shop/getShopById">
Shop id:	<input type="text" name="id">
			<input type="submit" value="Get" >
		</form>
		

<h4> 	>>drop my shop</h4>
<br/>	>>URL :POST	/shop/drop
<br/>	>>Required Parameter :
<br/>	>>Return value :
<br/>	>>Description :
<br/>
		<form method="POST" action="/shop/drop">
drop my shop:	
			<input type="submit" value="drop" >
		</form>


<h4> 	>>revert my shop</h4>
<br/>	>>URL :POST	/shop/revert
<br/>	>>Required Parameter :
<br/>	>>Return value :
<br/>	>>Description :
<br/>
		<form method="POST" action="/shop/revert">
revert my shop:	
			<input type="submit" value="revert" >
		</form>


		
<h4> 	>>if u like this shop or not</h4>
<br/>	>>URL :POST	/shop/like
<br/>	>>Required Parameter :
<br/>	>>Return value :shop information
<br/>	>>Description :like value 0 or 1
<br/>
Like	
		<form method="POST" action="/shop/like">
shopID:	<input type="text" name="id">
like:		<input type="text" name="isLike">
			<input type="submit" value="like/unlike" >
		</form>


<h4> 	>>share</h4>
<br/>	>>URL :POST	/shop/share
<br/>	>>Required Parameter :
<br/>	>>Return value :shop information
<br/>	>>Description :
<br/>
Share:
		<form method="POST" action="/shop/share">
shopID:		<input type="text" name="id">
			<input type="submit" value="share" >
		</form>


<h4> 	>>Get all shop around</h4>
<br/>	>>URL :GET	/shop/getShopAround	
<br/>	>>Required Parameter :radius,longitude,latitude
<br/>	>>Return value :Shop list
<br/>	>>Description :
<br/>
GET the moment around  :<form method="GET" action="/shop/getShopAround">
radius:						<input type="text" name="radius">
longitude:					<input type="text" name="longitude">
latitude:					<input type="text" name="latitude">
							<input type="submit" value="GetShopAround">
						</form>

						
						<h4> 	>>follow this shop</h4>
<br/>	>>URL :POST	/shop/follow
<br/>	>>Required Parameter :shopID
<br/>	>>Return value :
<br/>	>>Description :Follow the shopID.
<br/>
Follow shop:
		<form method="POST" action="/shop/follow">
shopID :	<input type="text" name="id" >		
			<input type="submit" value="follow" >
		</form>
		
		
								<h4> 	>>unfollow this shop</h4>
<br/>	>>URL :POST	/shop/unfollow
<br/>	>>Required Parameter :shopID
<br/>	>>Return value :
<br/>	>>Description :unfollow the shopID.
<br/>
Unfollow shop:
		<form method="POST" action="/shop/unfollow">
shopID :	<input type="text" name="id" >		
			<input type="submit" value="unfollow" >
		</form>
		
		
		
				<h4> 	>>My fashion level</h4>
<br/>	>>URL :GET user/myShopLevel
<br/>	>>Required Parameter :
<br/>	>>Return value :
<br/>	>>Description :
<br/>
		<form method="GET" action="/user/myShopLevel">
userId:
			
			<input type="submit" value="level" >
		</form>
		"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Feb 24 09:58:27 CST 2014
                    SOURCE: /home/aries/git/pai_mongodb/app/com/pencho/pai/views/shop.scala.html
                    HASH: 3b9fd41691ef13ee8200004d19ac453a154bef8a
                    MATRIX: 869->0
                    LINES: 29->1
                    -- GENERATED --
                */
            