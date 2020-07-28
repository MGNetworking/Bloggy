<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <title>Blog &amp; expérience</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <meta name="description" content="Découvrez des information sur ghalem maxime son curriculum vitae"/>

    <link rel="stylesheet" href="<c:url value="/static/CSS/accessibiliter.css" />" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/static/CSS/normalize.css"/>" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/static/CSS/site.css"/> " type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/static/fonts/*"/> " type="font/ttf"/>
    <%--<c:import url="/jsp/elements/headImport.jsp"></c:import>--%>
</head>

<body>

<header id="mainHearder">
    <a href="<c:url value="/home"/>#mainContant">

        <img src="<c:url value="/static/image/icon/max.png"/>"
             alt="image ico du site" title="retour a la page d'accueil"
             id="logo"/>
    </a>

    <h1>Le blog du Développeur</h1>

    <nav id="mainNav">

        <h2 class="accessibiliter">Menu principale</h2>
        <p class="accessibiliter">
            <a href="#mainContant" title="Accéder directement au contenu principale de cette page ">Passer le menu</a>
        </p>
        <!-- raccourcie pour l'accessibiter des personne en situation de handicape -->

        <ul>
            <li><a href="<c:url value="/home" />" title="Vers la page d'accueil du site">Accueil</a></li>
            <li><a href="<c:url value="/galerie"/>" title="Vers la page des galeries de photographies">Galeries</a></li>
            <li><a href="<c:url value="/contact"/>" title="Vers la page de contact">Contact</a></li>
            <li><a href="<c:url value="/about" />" title="Vers la page de l'à propos">A propos</a></li>
            <li><a href="<c:url value="/blog"/>" title="Vers la page de mon Blog">Blog</a></li>
            <li><a href="https://github.com/MGNetworking" title="Vers Mon github">My github</a></li>
            <li><a href="<c:url value="/cv"/>" title="Vers la page de mon CV">CV</a></li>
        </ul>
    </nav>
    <button id="menuButton"><img src="<c:url value="/static/image/icon/hamburger.svg"/> "
                                 alt="ouvrir / Fermer le menu"/></button>
    <%--<c:import url="/jsp/elements/navBar.jsp"></c:import>--%>
</header>
<!-- fin mainHearder -->

<div id="mainbody" class="colonneMain">

    <main id="mainContant">

        <h2>Connextion au compte utilisateur</h2>

        <form action="<c:url value="/connection" />" method="post">

            <div>
                <label for="" class="name">Nom :</label>
                <input name="name" type="text" required autofocus tabindex="1">
            </div>

            <div>
                <label for="" class="name">Password :</label>
                <input name="password" type="password" required autofocus tabindex="2">
            </div>

            <div>
                <label for="remember">Remember Me</label>
                <input name="remember" type="checkbox" tabindex="3">
            </div>

            <button type="submit" tabindex="3">Envoyer</button>

        </form>

        <!-- fin bouton de retour  -->

    </main>
    <!-- fin colonneGauche-->


    <aside id="colonneDroitAside">
        <section id="connection">
            <h2>Connection</h2>
            <ul>
                <c:if test="${ not empty sessionScope.user.listeRole}">

                    <li>Identité : ${sessionScope.user.name}</li>

                    <c:if test="${sessionScope.user.listeRole == '[ADMIN, USER_ARTICLE]'}">
                        <li>Vos droit : ${sessionScope.user.listeRole}</li>
                        <li><a href="<c:url value="/A faire ...."/>">Gestion ADMIN</a></li>
                    </c:if>

                    <c:if test="${sessionScope.user.listeRole == '[USER_ARTICLE]'}">
                        <li>Vos droit : ${sessionScope.user.listeRole}</li>
                    </c:if>

                    <li><a href="<c:url value="/article"/>?page=indexArticle">Créer un article de blog</a></li>
                    <li><a href="<c:url value="/connection"/>?connect=deconnexion">Déconnexion</a></li>
                </c:if>

                <c:if test="${ empty sessionScope.user.listeRole}">
                    <li><a href="<c:url value="/connection"/>">Connection</a></li>
                </c:if>


            </ul>
        </section>

        <section id="blogRecherche">
            <h2><label for="search">recherche</label></h2>
            <input type="search" name="search" id="search"/>
        </section>
        <!-- fin moteur de blogRecherche -->


        <section id="categories">
            <h2>categories</h2>
            <ul>
                <li><a href="#">matériel&nbsp;<span>11</span></a></li>
                <li><a href="#">lightroom&nbsp;<span>2</span></a></li>
                <li><a href="#">technique&nbsp;<span>4</span></a></li>
                <li><a href="#">voyage&nbsp;<span>8</span></a></li>
            </ul>
        </section>


        <!-- fin Categories -->

        <section id="blogAchives">
            <h2>archive</h2>
            <div>
                <h3><a href="#">années 2019&nbsp;<span>7</span></a></h3>
                <ul>
                    <li><a href="#">janvier 2019&nbsp;<span>3</span></a></li>
                    <li><a href="#">février 2019&nbsp;<span>2</span></a></li>
                    <li><a href="#">mars 2019&nbsp;<span>1</span></a></li>
                    <li><a href="#">avril 2019&nbsp;<span>1</span></a></li>
                </ul>
            </div>
            <div>
                <h3><a href="#">années 2020&nbsp;<span>9</span></a></h3>
                <ul>
                    <li><a href="#">janvier 2020&nbsp;<span>2</span></a></li>
                    <li><a href="#">février 2020&nbsp;<span>4</span></a></li>
                    <li><a href="#">mars 2020&nbsp;<span>2</span></a></li>
                    <li><a href="#">avril 2020&nbsp;<span>1</span></a></li>
                </ul>
            </div>

        </section>
        <!-- fin blogAchives -->
        <%--<c:import url="/jsp/elements/asideSection.jsp"></c:import>--%>
    </aside>
    <!-- fin colonneDroit-->


</div>
<!-- fin mainbody -->

<!-- menu petit ecran -->
<script src="<c:url value="/static/js/jquery-3.5.0.js" />"></script>
<script src="<c:url value="/static/js/menu.js" />"></script>
<!-- fonction dynamique  -->
<script src="<c:url value="/static/js/backgroundDynamique.js" />" async></script>
<%--<c:import url="/jsp/elements/scriptImport.jsp"></c:import>--%>
</body>

<footer id="mainFooter">
    <p>&copy;copyright ghalem maxime - 2020</p>
</footer>
<!-- fin mainFooter -->

</html>
