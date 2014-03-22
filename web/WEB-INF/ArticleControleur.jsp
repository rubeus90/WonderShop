<%-- 
    Document   : ArticleControleur
    Created on : 22 mars 2014, 19:49:41
    Author     : Martin
--%>
<%@page import="pkgEntities.Article"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>WonderShop</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="screen" href="/ECommerce/css/header.css" type="text/css" />
        <link rel="stylesheet" media="screen" href="/ECommerce/css/article.css" type="text/css" />
    </head>
    <body>
        <%@ include file="header.jsp" %>
        
        <section>
            <article>
                <img src="/ECommerce/${ article.getUrl_image() }" alt="article"/>
                <aside>
                    <h2><c:out value="${ article.getAlbum() }"/></h2>
                    <p>Par <c:out value="${ article.getArtiste() }"/> ( <c:out value="${ article.getDate_creation() }"/> )</p>
                    <p class="prix"><c:out value="${ article.getPrix() }"/>€</p>
                    <form action="" method="post">
                        <input type="hidden" value="${ article.getId() }">
                        <button>
                            <img src="/ECommerce/icon/add.png">
                            Ajouter au panier
                        </button>
                </aside>
            </article>
        </section>
    </body>
</html>
