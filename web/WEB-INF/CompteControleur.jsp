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
                <div id="logo"><a href="">
                    <img src="icon/logo.png" alt="logo">
                    <h1>WonderSHOP</h1>
                </a></div>
            </div>
        </header>

        <section>
            <ul>
                <c:forEach var="commande" items="${sessionScope.listCommande}">
                    <p><c:out value="${ commande.getDateCreation() }"/></p>
                    <li>
                        <img src="${commande.getArticle().getDate_creation()}" alt="article"/>
                        <h2><c:out value="${ commande.getArticle().getAlbum() }"/> - <c:out value="${ commande.getArticle().getArtiste() }"/></h2>
                        <div>
                            <p><c:out value="${ commande.getArticle().getPrix() }"/></p>
                        </div>
                    </li>
                </c:forEach> 
            </ul>
        </section>

        <!--<section>
            <p>Commande du 16/09/10</p>
            <ul>
                <li>
                    <img src="img/magicman.jpg" alt="article"/>
                    <h2>Magic Man (1)</h2>
                    <div>
                        <p>150€</p>
                    </div>
                </li>
                <li>
                    <img src="img/magicman.jpg" alt="article"/>
                    <h2>Magic Man (1)</h2>
                    <div>
                        <p>150€</p>
                    </div>
                </li>
                <li>
                    <img src="img/magicman.jpg" alt="article"/>
                    <h2>Magic Man (1)</h2>
                    <div>
                        <p>300€</p>
                    </div>
                </li>
            </ul>
            <p id="total">600€</p>
        </section>-->
           
    </body>
</html>
