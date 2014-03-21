<%-- 
    Document   : IndexControleur
    Created on : 20 mars 2014, 15:50:15
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" media="screen" href="/ECommerce/css/index.css" type="text/css" />
        <link rel="stylesheet" media="screen" href="/ECommerce/css/header.css" type="text/css" />
        <link rel="stylesheet" media="screen" href="/ECommerce/css/slider.css" type="text/css" />
        <title>WonderShop</title>
    </head>
    <body>
        <header>
            <div id="header">
                <ul>
                    <li><a href="IndiePop">Indie-Pop</a></li>
                    <li><a href="PopRock">Pop-Rock</a></li>
                    <li><a href="PunkRock">Punk-Rock</a></li>
                    <li><a href="Alternatif">Alternatif</a></li>
                </ul>
                <div id="logo"><a href="">
                    <img src="icon/logo.png" alt="logo">
                    <h1>WonderSHOP</h1>
                </a></div>
            </div>
            <div id="cart"><a href="PanierControleur">
                <div id="shop">
                    <img src="/ECommerce/icon/cart.png" alt="cart"><span>(0)</span>
                </div>
            </a></div>
        </header>

         <!-- SLIDER -->
        <div class="main">
            <div class="page_container">
                <div id="immersive_slider">
                    <div class="slide" data-blurred="/ECommerce/img/slide1_blurred.jpg">
                        <div class="image">
                            <img src="/ECommerce/img/slide1.jpg" alt="Slider 1">
                        </div>
                        <div class="content">
                            <h2>Magic Man</h2>
                            <p>Blablabla</p>
                            <p>10€</p>
                            <button>
                                <img src="/ECommerce/icon/add.png">
                                Ajouter au panier
                            </button>
                        </div>
                    </div>
                    <div class="slide" data-blurred="/ECommerce/img/slide2_blurred.jpg">
                           <div class="image">
                                <img src="/ECommerce/img/slide2.png" alt="Slider 1">
                            </div>
                        <div class="content">
                            <h2>Hunter Hunted</h2>
                            <p>Blablabla</p>
                            <p>10€</p>
                            <button>
                                <img src="/ECommerce/icon/add.png">
                                Ajouter au panier
                            </button>
                        </div>
                    </div>
                    <div class="slide" data-blurred="/ECommerce/img/slide3_blurred.jpg">
                        <div class="image">
                            <a href=""><img src="/ECommerce/img/slide3.png" alt="Slider 1">
                        </div>
                        <div class="content">
                            <h2>The Colourist</h2>
                            <p>Blablabla</p>
                            <p>10€</p>
                            <button>
                                <img src="/ECommerce/icon/add.png">
                                Ajouter au panier
                            </button>
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
            
        </section>

        <script type="text/javascript" src="/ECommerce/js/jquery.js"></script>
        <script type="text/javascript" src="/ECommerce/js/jquery.immersive-slider.js"></script>
        <script type="text/javascript">$(document).ready( function() {$("#immersive_slider").immersive_slider({container: ".main"});});</script>
    </body>
</html>
