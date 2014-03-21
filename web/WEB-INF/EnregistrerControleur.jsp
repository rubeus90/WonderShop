<%-- 
    Document   : EnregistrerControleur
    Created on : 21 mars 2014, 17:10:04
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
        <link rel="stylesheet" media="screen" href="css/formulaire.css" type="text/css" />
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
            <div id="cart"><a href="/ECommerce/PanierControleur">
                <div id="shop">
                    <img src="/ECommerce/icon/cart.png" alt="cart">
                    <span>
                        <%
                        Panier panier = (Panier) session.getAttribute("panier");
                        out.println( "("+ panier.getEffectif() +")" );
                        %>
                    </span>
                </div>
            </a></div>
        </header>

        <section>
            <form action="ClientEnregistre" method="post">
                <fieldset>
                        <legend><span class="form-step">1</span>Votre identité</legend>
                        <input type="text" name="nom" placeholder="Nom">
                        <input type="text" name="prenom" placeholder="Prenom">
                        <input type="text" name="telephone" placeholder="Telephone">
                        <input type="password" name="password" placeholder="Mot de passe">
                        <input type="password" name=passwordv placeholder="Vérification de mot de passe">
                </fieldset>	

                <fieldset>
                        <legend><span class="form-step">2</span>Votre E-mail</legend>
                        <input type="email" name="email" placeholder="Mail">
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
