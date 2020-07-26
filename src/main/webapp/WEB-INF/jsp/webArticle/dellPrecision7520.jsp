<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="utf-8"/>
    <title>Blog &amp; expérience</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0"/>
    <meta name="description" content="Découvrez des information sur le matériel dont je dispose"/>

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
        <img src="<c:url value="/static/image/icon/max.png" />" alt="image ico du site"
             title="retour a la page d'accueil" id="logo"/>
    </a>


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
    <button id="menuButton"><img src="<c:url value="/static/image/icon/hamburger.svg"/> "
                                 alt="ouvrir / Fermer le menu"/></button>
</header>
<!-- fin mainHearder -->

<div id="mainbody" class="colonneMain">

    <main id="mainContant">
        <articletexte>
            <header>
                <h2>Dell precision 7520</h2>
            </header>
            <p>
                <img src="<c:url value="/static/image/articletexte/dellPrecision_7520.png" />" alt="image du dell precision"/>
                <span class="enteteParagraphe">
                <a href="https://ark.intel.com/content/www/fr/fr/ark/products/88970/intel-core-i7-6820hq-processor-8m-cache-up-to-3-60-ghz.html"
                   target="_blank">Processeurs </a>haut de gamme:&nbsp;</span> Nous savons que vous vous
                occupez de projets de grande envergure. C’est pourquoi nous vous proposons les meilleurs processeurs
                disponibles. La station de travail mobile Dell&nbsp;Precision&nbsp;7520 offre une puissance de
                traitement illimitée avec les performances
                exceptionnelles des processeurs Intel®&nbsp;Core™&nbsp;i5,&nbsp;i7 de 7e&nbsp;génération et des
                processeurs Intel®&nbsp;Xeon®. </p>

            <p><span class="enteteParagraphe">Des détails de génie:&nbsp;</span> La conception haut de gamme innovante
                offre jusqu’à quatre options d’affichage d’une qualité irréprochable allant jusqu’à la résolution Ultra
                HD avec une couverture Adobe
                RVB complète et 8 millions de pixels. Avec des détails aussi éclatants, vous profitez d’une superbe
                définition pour tout voir nettement.</p>

            <p><span class="enteteParagraphe">Graphiques hautes performances:&nbsp;</span> Choix entre 2 cartes
                graphiques Radeon Pro™ WX de qualité professionnelle et 2 cartes graphiques NVIDIA Quadro® avec jusqu’à
                4 Go de mémoire graphique. La mémoire
                DDR4 très haut débit à 2 400 MHz et 2 667 MHz vous permet d’exécuter des tâches de rendu 3D complexes et
                d’autres tâches graphiques.</p>

            <p><span class="enteteParagraphe">Une fiabilité optimale:&nbsp;</span> processus de test, d’optimisation et
                de certification basés sur des applications logicielles professionnelles et options de support avec
                délais d’intervention à la pointe
                du secteur.</p>

            <p><span class="enteteParagraphe">Prise en charge de l’affichage 8k :&nbsp;</span> les stations de travail
                Dell Precision 7520 et 7720 sont les premières à être équipées de la technologie DisplayPort 1.4, qui
                prend en charge la résolution
                8K et la fonctionnalité HDR dans un câble unique</p>
        </articletexte>
        <!-- Fin de l'articletexte sur Dell -->


        <p>

            <a href="#mainContant">
                <button class="bpRetour">
                    <img src="<c:url value="/static/image/icon/chevrons-up.svg" />" alt="retour en haut de la page">
                </button>
            </a>

        </p>
        <!-- fin bouton de retour  -->

    </main>

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
