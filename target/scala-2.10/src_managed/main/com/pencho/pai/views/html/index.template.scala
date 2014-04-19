
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

<h1>--INDEX--</h1>

<!--------------------------------------------------------------------------------------------------------------------------File-->	
	<li>
		<a href='/file' > File </a>
	</li>
<!--------------------------------------------------------------------------------------------------------------------------User-->
	<li>	
		<a href='/user' > User </a>
	</li>
<!--------------------------------------------------------------------------------------------------------------------------Comment-->
	<li>	
		<a href='/comment' > Comment </a>
	</li>
<!--------------------------------------------------------------------------------------------------------------------------Product-->
	<li>	
		<a href='/product' > Product </a>
	</li>
<!--------------------------------------------------------------------------------------------------------------------------News-->
	<li>	
		<a href='/news' > News </a>
	</li>
<!--------------------------------------------------------------------------------------------------------------------------Post-->
	<li>	
		<a href='/post' > Post </a>
	</li>
<!--------------------------------------------------------------------------------------------------------------------------Help-->
	<li>	
		<a href='/help' > Help </a>
	</li>
<!--------------------------------------------------------------------------------------------------------------------------Shop-->
	<li>	
		<a href='/shop' > Shop </a>
	</li>
<!--------------------------------------------------------------------------------------------------------------------------Message-->
	<li>	
		<a href='/message' > Message </a>
	</li>
<!--------------------------------------------------------------------------------------------------------------------------SnapShot-->
	<li>	
		<a href='/snapShot' > SnapShot </a>
	</li>
<!--------------------------------------------------------------------------------------------------------------------------Share-->
	<li>	
		<a href='/share' > Share </a>
	</li>
<!--------------------------------------------------------------------------------------------------------------------------Share-->
	<li>	
		<a href='/search' > Search </a>
	</li>
<!--------------------------------------------------------------------------------------------------------------------------Wardrobe-->
	<li>	
		<a href='/wardrobe' > Wardrobe </a>
	</li>
<!--------------------------------------------------------------------------------------------------------------------------WholeSale-->
	<li>	
		<a href='/wholeSale' > WholeSale ( Will come maybe !!! ) </a>
	</li>






















------------------------------------------------------------------------------------------------------------------------------------------------------<a href='' > Top </a>

"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Feb 24 09:58:27 CST 2014
                    SOURCE: /home/aries/git/pai_mongodb/app/com/pencho/pai/views/index.scala.html
                    HASH: 7105c6bc85e854bb6d1fb2a104758e1cf66e39c7
                    MATRIX: 789->1|900->18
                    LINES: 26->1|29->1
                    -- GENERATED --
                */
            