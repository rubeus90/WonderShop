<%-- 
    Document   : CompteConnexion
    Created on : 23 mars 2014, 12:30:05
    Author     : Martin
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>WonderShop</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="screen" href="/ECommerce/css/header.css" type="text/css" />
        <link rel="stylesheet" media="screen" href="/ECommerce/css/CompteConnexion.css" type="text/css" />
    </head>
    <body>
	<%@ include file="header.jsp" %>

        <section>
            <div class="info">
                <p>Mauvais email ou mot de passe</p>
            </div>
            <h2>Se Connecter</h2>
            <div class="content">
                <form method="post" action="/ECommerce/MonCompte">
                    <fieldset>
                        <input type="text" name="email" placeholder="Email">
                        <input type="password" name="password" placeholder="Mot de passe">
                    </fieldset>	
                    <input type="submit" name="connexion" value="Continuer">
                </form>
            </div>
        </section>
    </body>
</html>
