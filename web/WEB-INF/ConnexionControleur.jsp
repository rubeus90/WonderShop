<%-- 
    Document   : ConnexionControleur
    Created on : 21 mars 2014, 15:29:53
    Author     : Alexandre
--%>

<%@page import="pkgFormManager.Panier"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>WonderShop</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="screen" href="css/header.css" type="text/css" />
        <link rel="stylesheet" media="screen" href="css/connexion.css" type="text/css" />
    </head>
    <body>
	 <%@ include file="header.jsp" %>
         
        <section>					
            <div class="info">
                <div>
                    <h2>Authentification</h2>
                    <p>Merci d'entrer votre identifiant et votre mot de passe</p>
                </div>
            </div>

            <form class="add" method="post" action="/ECommerce/Login">
                <fieldset>
                        <input type="text" name="email" placeholder="Email">
                        <input type="password" name="password" placeholder="Mot de passe">
                </fieldset>	
                <input type="submit" name="connexion">
            </form>
        </section>
    </body>
</html>
