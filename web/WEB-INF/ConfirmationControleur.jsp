<%-- 
    Document   : ConfirmationControleur
    Created on : Mar 21, 2014, 4:53:09 PM
    Author     : rubeus
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Panier</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="screen" href="css/header.css" type="text/css" />
        <link rel="stylesheet" media="screen" href="css/validation.css" type="text/css" />
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
                <div id="logo"><a href="">
                    <img src="/ECommerce/icon/logo.png" alt="logo">
                    <h1>WonderSHOP</h1>
                </a></div>
            </div>
        </header>
        
        <section>
            <div>
                <h3>Confirmation de votre commande :</h3>
                <p>Vous recevrez dans quelques instants votre lien de téléchargement à l'adresse suivante : <c:out value="${ sessionScope.client.getEmail() }"/></p>
            </div>
            <p>Récapitulatif de votre commande : </p>
            <ul>
                <c:forEach var="article" items="${sessionScope.listArticle}">
                <li>
                    <img src="${article.getUrl_image()}" alt="article"/>
                    <h2><c:out value="${ article.getAlbum() }"/> - <c:out value="${ article.getArtiste() }"/> (<c:out value="${sessionScope.panier.getMap().get(article) }"/>)</h2>
                    <div>
                        <p><c:out value="${ article.getPrix() }"/>€</p>
                    </div>
                </li>
                </c:forEach>
            </ul>
           <a href="/ECommerce/">Retour à l'acceuil</a>
        </section> 
                
    </body>
</html>
