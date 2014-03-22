<%-- 
    Document   : IndexControleur
    Created on : 20 mars 2014, 15:50:15
    Author     : Alexandre
--%>

<%@page import="java.util.List"%>
<%@page import="pkgEntities.Article"%>
<%@page import="pkgFormManager.Panier"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" media="screen" href="/ECommerce/css/header.css" type="text/css" />
        <link rel="stylesheet" media="screen" href="/ECommerce/css/index.css" type="text/css" />
        <link rel="stylesheet" media="screen" href="/ECommerce/css/slider.css" type="text/css" />
        <title>WonderShop</title>
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

         <!-- SLIDER -->
        <div class="main">
            <div class="page_container">
                <div id="immersive_slider">
                    
                    <!-- PREMIER SLIDE -->
                    <div class="slide" data-blurred="/ECommerce/img/slide1_blurred.jpg">
                        <div class="image">
                            <img src="/ECommerce/img/slide1.jpg" alt="Slider 1">
                        </div>
                        <div class="content">
                            <h2>Magic Man</h2>
                            <p>Blablabla</p>
                            <p>5€</p>
                            <form acion="IndexControleur" method="post">
<<<<<<< HEAD
                                <input type="hidden" name="article_id" value="1"/>
=======
                                <input type="hidden" name="article_nom" value="You are here"/>
>>>>>>> 5646f3ed5cf1a7a7b46f43fc364a3602095ea614
                                <input type="hidden" name="article_prix" value="5"/>
                                <button type="submit" name="action" value="Ajouter" >
                                    <img src="/ECommerce/icon/add.png" alt="Slider 1">
                                    Ajouter au panier
                                </button>
                            </form>
                        </div>
                    </div>
                    
                    <!-- DEUXIEME SLIDE -->
                    <div class="slide" data-blurred="/ECommerce/img/slide2_blurred.jpg">
                           <div class="image">
                                <img src="/ECommerce/img/slide2.png" alt="Slider 2">
                            </div>
                        <div class="content">
                            <h2>Hunter Hunted</h2>
                            <p>Blablabla</p>
                            <p>10€</p>
                            <form acion="IndexControleur" method="post">
                                <input type="hidden" name="article_id" value="3"/>
                                <input type="hidden" name="article_prix" value="10"/>
                                <button type="submit" name="action" value="Ajouter" >
                                    <img src="/ECommerce/icon/add.png" alt="Slider 2">
                                    Ajouter au panier
                                </button>
                            </form>
                        </div>
                    </div>
                    
                    <!-- TROISIEME SLIDE -->
                    <div class="slide" data-blurred="/ECommerce/img/slide3_blurred.jpg">
                        <div class="image">
                            <img src="/ECommerce/img/slide3.png" alt="Slider 3">
                        </div>
                        <div class="content">
                            <h2>The Colourist</h2>
                            <p>Blablabla</p>
                            <p>10€</p>
                            <form acion="IndexControleur" method="post">
<<<<<<< HEAD
                                <input type="hidden" name="article_id" value="2"/>
=======
                                <input type="hidden" name="article_nom" value="Lido"/>
>>>>>>> 5646f3ed5cf1a7a7b46f43fc364a3602095ea614
                                <input type="hidden" name="article_prix" value="10"/>
                                <button type="submit" name="action" value="Ajouter" >
                                    <img src="/ECommerce/icon/add.png" alt="Slider 3">
                                    Ajouter au panier
                                </button>
                            </form>
                        </div>
                    </div>

                    <a href="#" class="is-prev">&laquo;</a>
                    <a href="#" class="is-next">&raquo;</a>
                </div>
            </div>
        </div>
        <!-- FIN SLIDER -->

        <section>
            <h2>Indie-Pop</h2>
            <% /* Affichage de la liste d'articles */
            List<Article> affichageListArticle = (List<Article>) session.getAttribute("affichageListArticle");
            if(affichageListArticle!=null) {
                String html = "";
                for(Article article : affichageListArticle) {
                    html += "<article>";
                    html += "    <form acion=\"IndexControleur\" method=\"post\">";
                    html += "        <input type=\"hidden\" name=\"article_nom\" value=\""+article.getNom()+"\"/>";
                    html += "        <input type=\"hidden\" name=\"article_prix\" value=\""+article.getPrix()+"\"/>";
                    html += "        <button type=\"submit\" name=\"action\" value=\"Ajouter\" >";
                    html += "            <img src=\"icon/add.png\" alt=\"article\">";
                    html += "        </button>";
                    html += "        <img src=\""+article.getUrl_image()+"\" alt=\"article\"/>";
                    html += "        <h3>"+article.getNom()+"</h3>";
                    html += "        <p>"+article.getDescription()+"</p>";
                    html += "        <p>"+article.getPrix()+"€</p>";
                    html += "    </form>";
                    html += "</article>";
                }
                out.println(html);
            }
            else out.println("Panier NULL");
            %>
        </section>

        <script type="text/javascript" src="/ECommerce/js/jquery.js"></script>
        <script type="text/javascript" src="/ECommerce/js/jquery.immersive-slider.min.js"></script>
        <script type="text/javascript">$(document).ready( function() {$("#immersive_slider").immersive_slider({container: ".main"});});</script>
    </body>
</html>
