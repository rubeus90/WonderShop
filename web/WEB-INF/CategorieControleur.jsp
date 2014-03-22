<%-- 
    Document   : CategorieControleur
    Created on : 21 mars 2014, 14:44:39
    Author     : Alexandre
--%>

<%@page import="pkgFormManager.Panier"%>
<%@page import="java.util.List"%>
<%@page import="pkgEntities.Article"%>
<%@page import="pkgEntities.Article"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>WonderShop</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="screen" href="/ECommerce/css/header.css" type="text/css" />
        <link rel="stylesheet" media="screen" href="/ECommerce/css/index.css" type="text/css" />
    </head>
    <body>
        <%@ include file="header.jsp" %>
        
        <!-- JSTL -->
        <section>
            <c:forEach var="article" items="${sessionScope.listArticle}">
                <article>
                    <form action="/ECommerce/Categorie/${sessionScope.categorie}" method="post">
                        <input type="hidden" name="article_id" value="${article.getId()}"/>
                        <img src="/ECommerce/${article.getUrl_image()}" alt="article"/>
                        <button type="submit" name="action" value="Ajouter" >
                            <img src="/ECommerce/icon/add.png" alt="article">
                        </button>
                        <h3><c:out value="${ article.getAlbum() }"/></h3>
                        <p><c:out value="${ article.getArtiste() }"/></p>
                        <p><c:out value="${ article.getPrix() }"/></p>
                    </form>
                </article>
            </c:forEach>         
        </section>
    </body>
</html>
