
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css"))),format.raw/*8.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("images/favicon.png"))),format.raw/*9.97*/("""">
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*10.74*/("""" type="text/javascript"></script>
    </head>
    <body>
        """),_display_(Seq[Any](/*13.10*/content)),format.raw/*13.17*/("""
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Feb 24 09:58:27 CST 2014
                    SOURCE: /home/aries/git/pai_mongodb/app/com/pencho/pai/views/main.scala.html
                    HASH: 269b46d0510c6906d1a4d27ca715f76cc91ac485
                    MATRIX: 793->1|917->31|1005->84|1031->89|1128->151|1142->157|1197->191|1293->252|1307->258|1360->290|1421->315|1436->321|1503->366|1606->433|1635->440
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|41->13|41->13
                    -- GENERATED --
                */
            