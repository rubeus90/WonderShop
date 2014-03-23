<%-- 
    Document   : header
    Created on : 22 mars 2014, 14:47:31
    Author     : Martin
--%>
<header>
    <div id="header">
        <ul>
            <li><a href="/ECommerce/Categorie/Indie-Pop">Indie-Pop</a></li>
            <li><a href="/ECommerce/Categorie/Pop-Rock">Pop-Rock</a></li>
            <li><a href="/ECommerce/Categorie/Punk-Rock">Punk-Rock</a></li>
            <li><a href="/ECommerce/Categorie/Alternatif">Alternatif</a></li>
            <li><a href="/ECommerce/MonCompte">Se Connecter</a></li>
        </ul>
        <div id="logo"><a href="/ECommerce/">
            <img src="/ECommerce/icon/logo.png" alt="logo">
            <h1>WonderSHOP</h1>
        </a></div>
    </div>
    <div id="cart"><a href="/ECommerce/PanierControleur">
        <div id="shop">
            <img src="/ECommerce/icon/cart.png" alt="cart">
            <span>(<c:out value="${ sessionScope.panier.getEffectif() }"/>)</span>
        </div>
    </a></div>
</header>
