
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
object message extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!-- >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Message -->
<h1>--------------------------------------------->>> Message >>></h1>


<h4> 	>>Create Message</h4>
<br/>	>>URL :POST	/message/create
<br/>	>>Required Parameter :
<br/>	>>Return value :Post information
<br/>	>>Description :
<br/>
Create Post :	
		<form method="POST" action="/message/create">
toUserID:	
			<input type="text" name="toUserID">
pictureID:
			<input type="text" name="pictureID"> 
audioID:
			<input type="text" name="audioID"> 
description:
			<input type="text" name="description"> 
			

productID: for shop send product
			<input type="text" name="productID"> 
			
			<input type="submit" value="Create" >
		</form>

	
getMy message
<h4> 	>>get my message</h4>
<br/>	>>URL :GET	/message/getMy
<br/>	>>Required Parameter :
<br/>	>>Return value :
<br/>	>>Description :
<br/>
get my message :	
		<form method="GET" action="/message/getMy">
start:		<input type="text" name="start">
end:		<input type="text" name="end">	
			<input type="submit" name="get" >
		</form>
		
		

getMy message send
<h4> 	>>get my message send</h4>
<br/>	>>URL :GET	/message/getMessageSend
<br/>	>>Required Parameter :
<br/>	>>Return value :
<br/>	>>Description :
<br/>
get my message send :	
		<form method="GET" action="/message/getMessageSend">
start:		<input type="text" name="start">
end:		<input type="text" name="end">	
			<input type="submit" name="get" >
		</form>
		
delete message
<h4> 	>>delete message</h4>
<br/>	>>URL :POST	/message/delete
<br/>	>>Required Parameter :
<br/>	>>Return value : information
<br/>	>>Description :
<br/>
delete message :	
		<form method="GET" action="/message/delete">
messageID:		<input type="text" name="id">
			<input type="submit" name="delete" >
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
                    SOURCE: /home/aries/git/pai_mongodb/app/com/pencho/pai/views/message.scala.html
                    HASH: a24033277a12902300288d3b5ee5be66a27206d0
                    MATRIX: 872->0
                    LINES: 29->1
                    -- GENERATED --
                */
            