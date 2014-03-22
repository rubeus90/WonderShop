<%-- 
    Document   : PanierControleur
    Created on : 20 mars 2014, 16:51:59
    Author     : 
--%>

<%@page import="pkgFormManager.Panier"%>
<%@page import="pkgEntities.Article"%>
<%@page import="pkgFormManager.Panier"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Panier</title>
        <meta charset="utf-8">
        <link rel="stylesheet" media="screen" href="/ECommerce/css/header.css" type="text/css" />
        <link rel="stylesheet" media="screen" href="/ECommerce/css/cart.css" type="text/css" />
    </head>
    <body>
        <%@ include file="header.jsp" %>

        <section>    
            <!-- JSTL -->
            <ul>
                <c:forEach var="article" items="${sessionScope.panier.getMap().keySet()}">
                <li>
                    <img src="${article.getUrl_image()}" alt="article"/>
                    <form action="PanierControleur" method="post">
                        <h2><c:out value="${ article.getAlbum() }"/> - <c:out value="${ article.getArtiste() }"/> (<c:out value="${sessionScope.panier.getMap().get(article) }"/>)</h2>
                        <input type="hidden" name="article_id" value="${article.getId()}"/>
                        <input type="submit" name="action" value="Supprimer" />
                        <input type="submit" name="action" value="Ajouter" />
                    </form>
                    <div>
                        <p><c:out value="${ article.getPrix() }"/>€</p>
                    </div>
                </li>
                </c:forEach>
            </ul>
        
            <p id="total"><c:out value="${ sessionScope.panier.getPrix() }"/>€</p>
            
            
            <c:if test="${ sessionScope.panier.getEffectif() != 0 }">
                <div id="buy"><a href="ConnexionControleur">
                    <img src="/ECommerce/icon/buy.png" alt="buy"/>
                    <p>Valider mon panier</p>
                </a></div>
            </c:if>         
        </section>    
    </body>
</html>
