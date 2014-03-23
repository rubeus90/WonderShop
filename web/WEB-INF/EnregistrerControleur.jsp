<%-- 
    Document   : EnregistrerControleur
    Created on : 21 mars 2014, 17:10:04
    Author     : Alexandre
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="pkgFormManager.Panier"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>WonderShop</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="screen" href="css/header.css" type="text/css" />
        <link rel="stylesheet" media="screen" href="css/formulaire.css" type="text/css" />
    </head>
    <body>
        <%@ include file="header.jsp" %>

        <section>
            <c:if test="${ sessionScope.text != null }">
                <div class="info">
                    <p><c:out value="${ sessionScope.text }"/></p>
                </div>
            </c:if>
            <form action="/ECommerce/ClientEnregistre" method="post">
                <fieldset>
                        <legend><span class="form-step">1</span>Votre identité</legend>
                        <input type="text" name="nom" placeholder="Nom">
                        <input type="text" name="prenom" placeholder="Prenom">
                        <input type="text" name="telephone" placeholder="Telephone">
                        <input type="password" name="password" placeholder="Mot de passe" required>
                        <input type="password" name=passwordv placeholder="Vérification de mot de passe" required>
                </fieldset>	

                <fieldset>
                        <legend><span class="form-step">2</span>Votre E-mail</legend>
                        <input type="email" name="email" placeholder="Mail" required>
                </fieldset>	

                <fieldset>
                        <legend><span class="form-step">3</span>Votre adresse</legend>
                        <input type="text" name="adresse" placeholder="Adresse">
                        <input type="numeric" name="code_postal" placeholder="Code Postal">
                        <input type="text" name="Ville" placeholder="Ville">
                </fieldset>	
		<button>
                    <img src="/ECommerce/icon/check.png">
                    S'enregistrer
                </button>
	</form>
    </section>
</body>
</html>
