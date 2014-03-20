<%-- 
    Document   : PanierControleur
    Created on : 20 mars 2014, 16:51:59
    Author     : Alexandre
--%>

<%@page import="pkgEntities.Panier"%>
<%@page import="pkgEntities.Article"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Panier</title>
        <meta charset="utf-8">
        <link rel="stylesheet" media="screen" href="./css/cart.css" type="text/css" />
        <link rel="stylesheet" media="screen" href="./css/header.css" type="text/css" />
    </head>
    <body>
        <header>
            <div id="header">
                <ul>
                    <li><a href="">Indie-Pop</a></li>
                    <li><a href="">Pop-Rock</a></li>
                    <li><a href="">Punk-Rock</a></li>
                    <li><a href="">Alternatif</a></li>
                </ul>
                <div id="logo"><a href="index.html">
                    <img src="icon/logo.png" alt="logo">
                    <h1>WonderSHOP</h1>
                </a></div>
            </div>
            <div id="cart"><a href="panier.html">
                <div id="shop">
                    <img src="icon/cart.png" alt="cart">
                    <span>
                        (
                        <%
                        Panier panier = (Panier) session.getAttribute("panier");
                        out.println( ((Panier) session.getAttribute("panier")).getEffectif() );
                        %>
                        )
                    </span>
                </div>
            </a></div>
            
        </header>

        <section>
            <ul>         
                <%
                /* TEST : remplir le panier */
                Article test = new Article();
                test.setNom("Magic Man");
                test.setPrix("150");
                panier.addArticle(test);
                Article test1 = new Article();
                test1.setNom("Passe moi le savon");
                test1.setPrix("199");
                panier.addArticle(test1);
                /******************************/
                String html = "";
                for(Article article : panier.getMap().keySet()) {
                    html+="<li>";
                    html+="     <img src=\"img/magicman.jpg\" alt=\"article\"/>";
                    html+="     <form acion=\"\" method=\"post\">";
                    html+="         <p>"+article.getNom()+" ("+panier.getMap().get(article)+") </p>";
                    html+="         <input type=\"submit\" name=\"delete\" value=\"Supprimer\"/>";
                    html+="         <input type=\"submit\" name=\"add\" value=\"Ajouter\"/>";
                    html+="     </form>";
                    html+="     <div>";
                    html+="     <p>"+article.getPrix()+"€</p>";
                    html+="     </div>";
                    html+="</li>";
                }
                out.println(html);
                %>
        
            </ul>
            <p id="total"><%= panier.getPrix() %>€</p>
            <div id="buy"><a href="">
                <img src="icon/buy.png" alt="buy"/>
                <p>Valider mon panier</p>
            </a></div>
        </section>    
    </body>
</html>
