<%-- 
    Document   : CategorieControleur
    Created on : 21 mars 2014, 14:44:39
    Author     : Alexandre
--%>

<%@page import="pkgFormManager.Panier"%>
<%@page import="java.util.List"%>
<%@page import="pkgEntities.Article"%>
<%@page import="pkgEntities.Article"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>WonderShop</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="screen" href="/ECommerce/css/header.css" type="text/css" />
        <link rel="stylesheet" media="screen" href="/ECommerce/css/index.css" type="text/css" />
    </head>
    <body>
        <header>
            <div id="header">
                <ul>
                    <li><a href="/ECommerce/Categorie/Indie-Pop">Indie-Pop</a></li>
                    <li><a href="/ECommerce/Categorie/Pop-Rock">Pop-Rock</a></li>
                    <li><a href="/ECommerce/Categorie/Punk-Rock">Punk-Rock</a></li>
                    <li><a href="/ECommerce/Categorie/Alternatif">Alternatif</a></li>
                </ul>
                <div id="logo"><a href="/ECommerce/IndexControleur">
                    <img src="/ECommerce/icon/logo.png" alt="logo">
                    <h1>WonderSHOP</h1>
                </a></div>
            </div>
            <div id="cart"><a href="/ECommerce/PanierControleur">
                <div id="shop">
                    <img src="/ECommerce/icon/cart.png" alt="cart">
                    <span>
                        <%
                        Panier panier = (Panier) session.getAttribute("panier");
                        out.println( "("+ panier.getEffectif() +")" );
                        %>
                    </span>
                </div>
            </a></div>
        </header>

        <section>
            <%
                List<Article> listArticle = (List<Article>) session.getAttribute("listArticle");
                for(Article article: listArticle){
                    out.println("<article> <form acion=\"article.html\" method=\"post\">");
                    out.println("<a href=\"article.html\"><img src=\"/ECommerce/icon/add.png\"></a>");
                    out.println("<button type=\"submit\" name=\"action\" value=\"Ajouter\" >");
                    out.println("<img src=\"icon/add.png\" alt=\"article\">);
                    out.println("</button>");    
                    out.println("<h3>"+ article.getNom() +"</h3>");
                    out.println("<p>"+ article.getDescription() +"</p>");
                    out.println("<p>"+ article.getPrix() +"</p>");
                    out.println("</form></article>");
                }                
            %>
        </section>
    </body>
</html>
