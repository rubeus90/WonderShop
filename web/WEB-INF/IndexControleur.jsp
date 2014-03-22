<%-- 
    Document   : IndexControleur
    Created on : 20 mars 2014, 15:50:15
    Author     : Alexandre
--%>

<%@page import="java.util.List"%>
<%@page import="pkgEntities.Article"%>
<%@page import="pkgFormManager.Panier"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <%@ include file="header.jsp" %>

         <!-- SLIDER -->
        <div class="main">
            <div class="page_container">
                <div id="immersive_slider">
                    
                    <!-- PREMIER SLIDE -->
                    <div class="slide" data-blurred="/ECommerce/img/slide1_blurred.jpg">
                        <div class="image">
                            <a href="/ECommerce/Article/1"><img src="/ECommerce/img/slide1.jpg" alt="Slider 1"></a>
                        </div>
                        <div class="content">
                            <a href="/ECommerce/Article/1"><h2>You Are Here</h2></a>
                            <p>Magic Man</p>
                            <p>10€</p>
                            <form action="IndexControleur" method="post">
                                <input type="hidden" name="article_id" value="1"/>
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
                               <a href="/ECommerce/Article/3"><img src="/ECommerce/img/slide2.png" alt="Slider 2"></a>
                            </div>
                        <div class="content">
                            <a href="/ECommerce/Article/3"><h2>Hunter Hunted</h2></a>
                            <p>Hunter Hunted</p>
                            <p>10€</p>
                            <form action="IndexControleur" method="post">
                                <input type="hidden" name="article_id" value="3"/>
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
                            <a href="/ECommerce/Article/2"><img src="/ECommerce/img/slide3.png" alt="Slider 3"></a>
                        </div>
                        <div class="content">
                            <a href="/ECommerce/Article/2"><h2>Lido</h2></a>
                            <p>The Colourist</p>
                            <p>10€</p>
                            <form action="IndexControleur" method="post">
                                <input type="hidden" name="article_id" value="2"/>
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
        
        <!-- JSTL -->
        <section>
            <h2>Articles en vedettes</h2>
            <c:forEach var="article" items="${sessionScope.listArticle}">
                <a href="/ECommerce/Article/${article.getId()}"><article>
                    <form action="IndexControleur" method="post">
                        <input type="hidden" name="article_id" value="${article.getId()}"/>
                        <img src="${article.getUrl_image()}" alt="article"/>
                        <button type="submit" name="action" value="Ajouter" >
                            <img src="/ECommerce/icon/add.png" alt="article">
                        </button>
                        <h3><c:out value="${ article.getAlbum() }"/></h3>
                        <p><c:out value="${ article.getArtiste() }"/></p>
                        <p><c:out value="${ article.getPrix() }"/>€</p>
                    </form>
                </article></a>
            </c:forEach>         
        </section>

        <script type="text/javascript" src="/ECommerce/js/jquery.js"></script>
        <script type="text/javascript" src="/ECommerce/js/jquery.immersive-slider.min.js"></script>
        <script type="text/javascript">$(document).ready( function() {$("#immersive_slider").immersive_slider({container: ".main"});});</script>
    </body>
</html>
