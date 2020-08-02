<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <p>&copy;Copyright Ghalem Maxime - 2020</p>
</footer>
<!-- fin mainFooter -->

</html>
