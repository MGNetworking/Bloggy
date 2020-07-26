<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <title>Blog &amp; expérience</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <meta name="description" content="Découvrez mon Matériel"/>

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


    <a href="<c:url value="/home"/>#mainContant"><img src="<c:url value="/static//image/icon/max.png" />"
                                                      alt="image ico du site" title="retour a la page d'accueil"
                                                      id="logo"/></a>


    <h1>Le blog du Développeur</h1>

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
    <button id="menuButton"><img src="<c:url value="/static/image/icon/hamburger.svg"/>"
                                 alt="ouvrir / Fermer le menu"/></button>
</header>
<!-- fin mainHearder -->


<div id="mainbody" class="colonneMain">

    <main id="mainContant">
        <articletexte>

            <header>
                <h3>Titre 1 du blog</h3>
                <p><strong>JJ - MM - AAAA</strong> | Maxime Ghalem | 3 commentaire</p>
            </header>

            <p><img src="<c:url value="/static/image/articletexte/pcDell1.png" />" alt="image dillustration"/>Lorem, ipsum
                dolor sit amet consectetur adipisicing elit. Perferendis dolor quas obcaecati iste facilis incidunt
                quasi odio porro, omnis corrupti ipsa beatae cumque natus
                praesentium et sequi sed ea consequuntur. Tempora repellendus fuga inventore id totam suscipit expedita
                doloribus vero laborum ducimus! Doloribus maxime amet voluptates magni quod totam itaque?</p>
            <p>
                <a href="<c:url value="/blog" />?articletexte=MyPc1">Lire la suite</a>
            </p>
        </articletexte>
        <!-- fin de la articletexte 1 -->


        <articletexte>

            <header>
                <h3>Titre 2 du blog</h3>
                <p><strong>JJ - MM - AAAA</strong> | Maxime Ghalem | 3 commentaire</p>
            </header>

            <p><img src="<c:url value="/static/image/articletexte/pcDell1.png" />" alt="image dillustration"/>Lorem, ipsum
                dolor sit amet consectetur adipisicing elit. Perferendis dolor quas obcaecati iste facilis incidunt
                quasi odio porro, omnis corrupti ipsa beatae cumque natus
                praesentium et sequi sed ea consequuntur. Tempora repellendus fuga inventore id totam suscipit expedita
                doloribus vero laborum ducimus! Doloribus maxime amet voluptates magni quod totam itaque?</p>
            <p>
                <a href="<c:url value="/blog" />?articletexte=MyPc1">Lire la suite</a>
            </p>
        </articletexte>
        <!-- fin de la articletexte 2-->


        <articletexte>
            <header>
                <h3>Titre 3 du blog</h3>
                <p><strong>JJ - MM - AAAA</strong> | Maxime Ghalem | 3 commentaire</p>
            </header>
            <p>
                <img src="<c:url value="/static/image/articletexte/pcDell1.png" />" alt="image dillustration"/>Lorem, ipsum
                dolor sit amet consectetur adipisicing elit. Perferendis dolor quas obcaecati iste facilis incidunt
                quasi odio porro, omnis corrupti ipsa beatae cumque natus
                praesentium et sequi sed ea consequuntur. Tempora repellendus fuga inventore id totam suscipit expedita
                doloribus vero laborum ducimus! Doloribus maxime amet voluptates magni quod totam itaque?</p>
            <p>
                <a href="<c:url value="/blog" />?articletexte=MyPc1">Lire la suite</a>
            </p>
        </articletexte>
        <!-- fin de la articletexte 3-->

        <p>

            <a href="#mainContant">
                <button class="bpRetour">
                    <img src="<c:url value="/static/jsp/icon/chevrons-up.svg" />" alt="retour en haut de la page">
                </button>
            </a>

        </p>
        <!-- fin bouton de retour  -->


    </main>
    <!-- fin du mainContant-->


    <aside id="colonneDroitAside">


        <section id="blogRecherche">
            <h2><label for="search">Recherche</label></h2>
            <input type="search" name="search" id="search"/>
        </section>
        <!-- fin moteur de blogRecherche -->

        <section id="categories">
            <h2>Categories</h2>
            <ul>
                <li><a href="#">Matériel<span>11</span></a></li>
                <li><a href="#">Lightroom<span>2</span></a></li>
                <li><a href="#">Technique<span>4</span></a></li>
                <li><a href="#">Voyage<span>8</span></a></li>
            </ul>
        </section>
        <!-- fin Categories -->

        <section id="blogAchives">
            <h2>Archive</h2>
            <div>
                <h3><a href="#">Années 2019&nbsp;<span>7</span></a></h3>
                <ul>
                    <li><a href="#">Janvier 2019&nbsp;<span>3</span></a></li>
                    <li><a href="#">Février 2019&nbsp;<span>2</span></a></li>
                    <li><a href="#">Mars 2019&nbsp;<span>1</span></a></li>
                    <li><a href="#">Avril 2019&nbsp;<span>1</span></a></li>
                </ul>
            </div>
            <div>
                <h3><a href="#">Années 2020&nbsp;<span>9</span></a></h3>
                <ul>
                    <li><a href="#">Janvier 2020&nbsp;<span>2</span></a></li>
                    <li><a href="#">Février 2020&nbsp;<span>4</span></a></li>
                    <li><a href="#">Mars 2020&nbsp;<span>2</span></a></li>
                    <li><a href="#">Avril 2020&nbsp;<span>1</span></a></li>
                </ul>

            </div>

        </section>
        <!-- fin blogAchives -->

    </aside>
    <!-- fin colonneDroit-->

</div>
<!-- fin mainbody -->

<footer id="mainFooter">
    <p>&copy;Copyright Ghalem Maxime - 2020</p>
</footer>
<!-- fin mainFooter -->


</body>

</html>
