
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
object search extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> search -->
<h1>--------------------------------------------->>>PAI Search Engine >>></h1>


<h4> 	>>Search for Product</h4>
<br/>	>>URL :GET	/product
<br/>	>>Required Parameter : area|tags|title|description
<br/>	>>Return value :product information
<br/>	>>Description :
<br/>		
Find product :	
		<form  method="GET" action="/search/product">
product property:	
			<input type="text" name="productProperty">
price range:			
			<input type="text" name="lowPrice" />
			<input type="text" name="highPrice" /><br/>
Ascend: 	<input type="radio" name="priceOrder" value="asc" /><br/>
Descend�� 	<input type="radio" name="priceOrder" value="desc" /><br/>
			<input type="submit" value="Search" />
		</form>
<br/>

<h4> 	>>Search for Shop</h4>
<br/>	>>URL :GET	/shop
<br/>	>>Required Parameter : area|tags|description|phone|name
<br/>	>>Return value :shop information
<br/>	>>Description :
<br/>		
Find shop :	
		<form  method="GET" action="/search/shop">
shop property:	<input type="text" name="shopProperty">
			<input type="submit" value="Search Shop" >
		</form>
<br/>


<h4> 	>>Search User by gender</h4>
<br/>	>>URL :GET	/user
<br/>	>>Required Parameter : gender
<br/>	>>Return value :user information
<br/>	>>Description :
<br/>		
input gender :	
		<form  method="get" action="/search/sortUserByGender">
				Male: <input type="radio" name="genderStr" value="male" /><br/>
				Female�� <input type="radio" name="genderStr" value="female" /><br/>
				All�� <input type="radio" name="genderStr" value="all" /><br/>
				<input type="submit" value="Search" />
		</form>
		
<br/>

<h4> 	>>Search for User</h4>
<br/>	>>URL :GET	/user
<br/>	>>Required Parameter : area|gender|age|phone|name
<br/>	>>Return value :user information
<br/>	>>Description :
<br/>		
Find user :	
		<form  method="GET" action="/search/user">
user property:	<input type="text" name="userProperty">
			<input type="submit" value="Search User" >
		</form>
<br/>

<h4> 	>>Search for Friend</h4>
<br/>	>>URL :GET	/friend
<br/>	>>Required Parameter : gender|area|phone|name
<br/>	>>Return value :friend (user) information
<br/>	>>Description :
<br/>		
Find friend :	
		<form  method="GET" action="/search/friend">
friend property:	<input type="text" name="friendProperty">
			<input type="submit" value="Search Friend" >
		</form>
<br/>


<h4> 	>>Sort Friend by gender</h4>
<br/>	>>URL :GET	/friendByGender
<br/>	>>Required Parameter : gender
<br/>	>>Return value :friend (user) information
<br/>	>>Description :
<br/>		
Choose gender of friends:	
		<form  method="get" action="/search/friendByGender">
				Male: <input type="radio" name="genderStr" value="male" /><br/>
				Female�� <input type="radio" name="genderStr" value="female" /><br/>
				All�� <input type="radio" name="genderStr" value="all" /><br/>
				<input type="submit" value="Search" />
		</form>

<h4> 	>>Search for Wishlist</h4>
<br/>	>>URL :GET	/wishlist
<br/>	>>Required Parameter : area|tags|description
<br/>	>>Return value :wishlist (product) information
<br/>	>>Description :
<br/>		
Find wishlist :	
		<form  method="GET" action="/search/wishlist">
wishlist property:	<input type="text" name="wishlistProperty">
			<input type="submit" value="Search Wishlist" >
		</form>
<br/>


<h4> 	>>Search for FashionHelp</h4>
<br/>	>>URL :GET	/fashionHelp
<br/>	>>Required Parameter : userName|description
<br/>	>>Return value :FashionHelp information
<br/>	>>Description :
<br/>		
Find FashionHelp :	
		<form  method="GET" action="/search/fashionHelp">
FashionHelp Property:	<input type="text" name="fashionHelpProperty">
			<input type="submit" value="Search FashionHelp" >
		</form>
<br/>







"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Feb 24 09:58:27 CST 2014
                    SOURCE: /home/aries/git/pai_mongodb/app/com/pencho/pai/views/search.scala.html
                    HASH: 8fc2dee86fe9e03e6c44b19069effff2b6f1ccd2
                    MATRIX: 871->0
                    LINES: 29->1
                    -- GENERATED --
                */
            