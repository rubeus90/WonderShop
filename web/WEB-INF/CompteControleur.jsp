<%-- 
    Document   : CompteControleur
    Created on : 23 mars 2014, 00:00:09
    Author     : Martin
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Compte</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="screen" href="css/header.css" type="text/css" />
        <link rel="stylesheet" media="screen" href="css/compte.css" type="text/css" />
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
                <div id="logo"><a href="/ECommerce">
                    <img src="icon/logo.png" alt="logo">
                    <h1>WonderSHOP</h1>
                </a></div>
            </div>
        </header>

        <c:set var="idCommande" value="${ 0 }" scope="request" />
        <c:set var="idCommande" value="${ commande.getIdCommande() }" scope="request" />
        <section class="hidden">
            <ul>
        <c:forEach var="commande" items="${listCommande}">
            <c:if test="${ requestScope.date != commande.getDateCreation() }">
            <p id="total"><c:out value="${ requestScope.prix }"/>€</p>
            <c:set var="prix" value="${ 0 }" scope="request" />
            </ul>
        </section>
            
        <section>
            <p>Commande du : <c:out value="${ commande.getDateCreation() }"/></p>
            <ul>
            </c:if>
                    <li>
                        <img src="${commande.getArticle().getUrl_image()}" alt="article"/>
                        <h2><c:out value="${ commande.getArticle().getAlbum() }"/> - <c:out value="${ commande.getArticle().getArtiste() }"/> (<c:out value="${ commande.getQuantite() }"/>)</h2>
                        <div>
                            <p><c:out value="${ commande.getArticle().getPrix() }"/>€</p>
                        </div>
                    </li> 
                    <c:set var="date" value="${ commande.getDateCreation() }" scope="request" />
                    <c:set var="prix" value="${ requestScope.prix + commande.getArticle().getPrix() * commande.getQuantite() }" scope="request" />
        </c:forEach>
            <p id="total"><c:out value="${ requestScope.prix }"/>€</p>
            </ul>
        </section>
    </body>
</html>
