
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
object wholeSale extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Product -->
<h1>--------------------------------------------->>> Product >>></h1>


<h4> 	>>Create product</h4>
<br/>	>>URL :POST	/product/create
<br/>	>>Required Parameter :
<br/>	>>Return value :product information
<br/>	>>Description :
<br/>
Create product :	
		<form method="POST" action="/product/create">
shopID:	
			<input type="text" name="shopID">
pictureID:
			<input type="text" name="pictureID"> 
videoID:
			<input type="text" name="videoID"> 
audioID:
			<input type="text" name="audioID"> 
description:
			<input type="text" name="description"> 
isSingleShop:	
			<input type="text" name="isSingleShop">
secondShopID:	
			<input type="text" name="secondShopID">
TrendyStyle: true or false
			<input type="text" name="trendyStyle">
price:			
			<input type="text" name="price">
			<input type="submit" value="Create" >
		</form>


<h4> 	>>find products by shopID</h4>
<br/>	>>URL :GET	/product/findByShopID
<br/>	>>Required Parameter :
<br/>	>>Return value :product information
<br/>	>>Description :
<br/>
Find product :	
		<form method="GET" action="/product/findByShopID">
shopID:	
			<input type="text" name="shopID">
start:		<input type="text" name="start">
end:		<input type="text" name="end">			
			<input type="submit" value="Get" >
		</form>


<h4> 	>>find products TrendyStyle by shopID</h4>
<br/>	>>URL :GET	/product/findTrendyStyleByShopID
<br/>	>>Required Parameter :
<br/>	>>Return value :product information
<br/>	>>Description :
<br/>
Find TrendyStyle product :	
		<form method="GET" action="/product/findTrendyStyleByShopID">
shopID:	
			<input type="text" name="shopID">
start:		<input type="text" name="start">
end:		<input type="text" name="end">			
			<input type="submit" value="Get" >
		</form>
		
		
<h4> 	>>if u like this product or not</h4>
<br/>	>>URL :"POST"	/product/like
<br/>	>>Required Parameter :
<br/>	>>Return value :product information
<br/>	>>Description :like value 0 or 1
<br/>
Find product :	
		<form method="POST" action="/product/like">
productID:	<input type="text" name="id">
like:		<input type="text" name="isLike">
			<input type="submit" value="like/unlike" >
		</form>


<h4> 	>>get product info</h4>
<br/>	>>URL :GET	/product/findByID
<br/>	>>Required Parameter :
<br/>	>>Return value :product information
<br/>	>>Description :
<br/>
Find product :	
		<form method="GET" action="/product/findByID">
productID:	<input type="text" name="id">
			<input type="submit" value="get" >
		</form>


<h4> 	>>get hot product</h4>
<br/>	>>URL :GET	/product/getHot
<br/>	>>Required Parameter :
<br/>	>>Return value :product information
<br/>	>>Description :
<br/>
get hot product :	
		<form method="GET" action="/product/getHot">
			<input type="submit" name="get" >
		</form>


<h4> 	>>add 2 my wishList</h4>
<br/>	>>URL :POST	/product/add2WishList
<br/>	>>Required Parameter :
<br/>	>>Return value :product information
<br/>	>>Description :
<br/>
		<form method="POST" action="/product/add2WishList">
add 2 my wishList :	
<br/>productID 	<input type="text" name="id">
			<input type="submit" value="Add" >
		</form>

<h4> 	>>find product in wish list by userID</h4>
<br/>	>>URL :GET	/product/WishListOfUserID
<br/>	>>Required Parameter :
<br/>	>>Return value :product information
<br/>	>>Description :
<br/>
Find product :	
		<form method="GET" action="/product/WishListOfUserID">
userID:	
			<input type="text" name="userID">
start:		<input type="text" name="start">
end:		<input type="text" name="end">			
			<input type="submit" value="Get" >
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
                    SOURCE: /home/aries/git/pai_mongodb/app/com/pencho/pai/views/wholeSale.scala.html
                    HASH: 6834547181069f126666b949a3bb076fa37aaffb
                    MATRIX: 874->0
                    LINES: 29->1
                    -- GENERATED --
                */
            