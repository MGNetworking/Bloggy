<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <title>Blog &amp; expérience</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0" />
    <meta name="description" content="Découvrez les lieux visité" />
    <!-- 160 char max utiliser les mots explicites-->

    <link rel="stylesheet" href="<c:url value="static/CSS/accessibiliter.css" />" type="text/css" />
    <link rel="stylesheet" href="<c:url value="static/CSS/normalize.css"/>" type="text/css" />
    <link rel="stylesheet" href="<c:url value="static/CSS/site.css"/> " type="text/css" />

    <!-- menu petit ecran -->
    <script src="<c:url value="static/js/jquery-3.5.0.js" />"></script>
    <script src="<c:url value="static/js/menu.js" />"></script>


    <!-- fonction dynamique  -->
    <script src="<c:url value="/static/js/backgroundDynamique.js" />"async></script>
    <script src="<c:url value="/static/js/gallerieDynamique.js" />"></script>


</head>

<body>

    <header id="mainHearder">

        <a href="<c:url value="/home"/>#mainContant"><img src="<c:url value="/static//image/icon/max.png" />" alt="image ico du site" title="retour a la page d'accueil" id="logo" /></a>

        <h1>Le blog du Développeur</h1>

        <nav id="mainNav">

            <ul>
                <li> <a href="<c:url value="/home" />" title="Vers la page d'accueil du site">Accueil</a> </li>
                <li> <a href="<c:url value="/galerie"/>" title="Vers la page des galeries de photographies">Galeries</a></li>
                <li> <a href="<c:url value="/contact"/>" title="Vers la page de contact">Contact</a></li>
                <li> <a href="<c:url value="/about" />" title="Vers la page de l'à propos">A propos</a></li>
                <li> <a href="<c:url value="/blog"/>" title="Vers la page de mon Blog">Blog</a></li>
                <li> <a href="https://github.com/MGNetworking" title="Vers Mon github">My github</a></li>
                <li> <a href="<c:url value="/cv"/>" title="Vers la page de mon CV">CV</a></li>
            </ul>
        </nav>
        <button id="menuButton">
            <img src="<c:url value="/static/image/icon/hamburger.svg"/> " alt="ouvrir / Fermer le menu"/>
        </button>
    </header>
    <!-- fin mainHearder -->

    <div id="mainbody" class="galleries">


        <main id="mainContant">

            <header>
                <h2>Galeries</h2>
            </header>

            <ul>
                <li>
                    <a href="<c:url value="/galerie" />?id=nancy">
                        <h3>Nancy 2020</h3>
                        <img src="<c:url value="/static/image/galeries/nancy/IMG_1_Nancy.jpg" />" alt="image de nancy">
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae amet adipisci eveniet consequatur, animi aspernatur labore maxime? Quidem perferendis corporis, eveniet fugit magni dolores animi, totam pariatur voluptas aspernatur
                            modi.
                        </p>
                    </a>
                </li>
                <li>
                    <a href="<c:url value="/galerie" />?id=paris">
                        <h3>Paris 2019</h3>
                        <img src="<c:url value="/static/image/galeries/paris/IMG_1_Paris.jpg" />" alt="image de paris">
                        <p>Ullam amet a, temporibus ad veniam dicta, minima consequuntur ipsa nam doloribus aliquam, alias modi debitis distinctio vero magnam necessitatibus. Autem veritatis ipsum sed ipsam voluptas exercitationem hic maiores sapiente?</p>
                    </a>
                </li>

            </ul>

            <p>

                <a href="#mainContant">
                    <button class="bpRetour">
                        <img src="<c:url value="/static/image/icon/chevrons-up.svg" />" alt="retour en haut de la page">
                    </button>
                </a>

            </p>
            <!-- fin bouton de retour  -->

        </main>
        <!-- fin mainContant-->


    </div>
    <!-- fin mainbody -->

    <footer id="mainFooter">
        <p>&copy;Copyright Ghalem Maxime - 2020</p>
    </footer>
    <!-- fin mainFooter -->


</body>

</html>
