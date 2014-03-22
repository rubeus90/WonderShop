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
         
        <h2>Se Connecter</h2>
        <section>
            <div class="content">
                <h3>Je possède un compte</h3>
                <form method="post" action="/Connexion">
                        <fieldset>
                                <input type="text" name="login" placeholder="Identifiant">
                                <input type="password" name="mdp" placeholder="Mot de passe">
                        </fieldset>	
                        <input type="submit" name="connexion" value="Continuer">
                </form>
            </div>

            <div class="content">
                <h3>Je ne possède pas de compte</h3>
                <a href="">M'inscrire</a>
            </div>
        </section>
    </body>
</html>
