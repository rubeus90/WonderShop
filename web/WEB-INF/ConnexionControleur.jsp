<%-- 
    Document   : ConnexionControleur
    Created on : 21 mars 2014, 15:29:53
    Author     : Alexandre
--%>

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
                    <img src="/ECommerce/icon/cart.png" alt="cart"><span>(0)</span>
                </div>
            </a></div>
        </header>
            <section>					
                <div class="info">
                    <div>
                        <h2>Authentification</h2>
                        <p>Merci d'entrer votre identifiant et votre mot de passe</p>
                    </div>
                </div>

                <form class="add" method="post" action="/ECommerce/Login">
                    <fieldset>
                            <input type="text" name="nom" placeholder="Email">
                            <input type="password" name="password" placeholder="Mot de passe">
                    </fieldset>	
                    <input type="submit" name="connexion">
                </form>
            </section>
	</body>
</html>
