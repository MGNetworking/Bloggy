<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <title>Blog &amp; expérience</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <meta name="description" content="Si vous avez des questions"/>

    <link rel="stylesheet" href="<c:url value="static/CSS/accessibiliter.css" />" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="static/CSS/normalize.css"/>" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="static/CSS/site.css"/> " type="text/css"/>

    <!-- menu petit ecran -->
    <script src="<c:url value="static/js/jquery-3.5.0.js" />"></script>
    <script src="<c:url value="static/js/menu.js" />"></script>

    <!-- fonction dynamique  -->
    <script src="<c:url value="/static/js/backgroundDynamique.js" />" async></script>

</head>

<body>

<header id="mainHearder">

    <a href="<c:url value="/home"/>#mainContant">
        <img src="<c:url value="/static//image/icon/max.png" />" alt="image ico du site"
             title="retour a la page d'accueil" id="logo"/>
    </a>

    <h1>formulaire de contact</h1>

    <nav id="mainNav">
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
    <button id="menuButton">
        <img src="<c:url value="/static/image/icon/hamburger.svg"/> "
             alt="ouvrir / Fermer le menu"/></button>
</header>
<!-- fin mainHearder -->

<div id="mainbody">

    <main id="mainContant">
        <h1>Savoir sur ce blog</h1>
        <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Neque vero nihil vitae autem esse beatae
            laudantium. Similique repudiandae fugit, ipsa labore nisi, non impedit incidunt quae repellat ex eveniet
            adipisci?</p>

        <h2>Lorem.</h2>
        <p>Rem incidunt pariatur, ducimus doloribus iure aliquid fugit provident temporibus consequatur sed
            voluptatibus, praesentium, nesciunt delectus distinctio? Quia assumenda saepe eum alias ratione nihil, culpa
            earum adipisci cupiditate cumque
            quas!
        </p>
        <h2>Lorem, ipsum.</h2>
        <p>Molestias id fugit ea minus, magnam delectus ducimus quod reiciendis ipsa dolor explicabo excepturi
            perspiciatis. Eveniet facilis maiores minima? Omnis in exercitationem ullam inventore repellendus ducimus
            pariatur et architecto animi?</p>

        <h2>Lorem, ipsum dolor.</h2>
        <p>Similique deleniti doloremque aliquid totam accusantium dolorum qui iste sequi ipsum, placeat aliquam modi
            aperiam doloribus, vel expedita consectetur animi molestiae. Ex officia sunt sapiente iste ut at nihil
            delectus!</p>

        <h2>Lorem ipsum dolor sit.</h2>
        <p>Natus, asperiores modi! Nisi, adipisci nesciunt! Nisi deleniti debitis quas adipisci error perferendis
            suscipit, sequi totam quo nostrum quam eos excepturi. Exercitationem perferendis in nesciunt est commodi
            repellat porro tempora.</p>


        <p>

            <a href="#mainContant">
                <button class="bpRetour">
                    <img src="<c:url value="/static/image/icon/chevrons-up.svg"/>" alt="retour en haut de la page">
                </button>
            </a>

        </p>
        <!-- fin bouton de retour  -->

    </main>
    <!-- fin pageContent-->


</div>
<!-- fin mainbody -->


<footer id="mainFooter">
    <p>&copy;Copyright Ghalem Maxime - 2020</p>
</footer>
<!-- fin mainFooter -->


</body>

</html>
