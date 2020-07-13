<!DOCTYPE html>
<html lang="fr">

<head>
    <title>Blog &amp; expérience</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0" />
    <meta name="description" content="Découvrez les lieux visité" />
    <!-- 160 char max utiliser les mots explicites-->

    <link rel="stylesheet" href="/CSS/accessibiliter.css" type="text/css" />
    <link rel="stylesheet" href="/CSS/normalize.css" type="text/css" />
    <link rel="stylesheet" href="/CSS/site.css" />

    <!-- menu petit ecran -->
    <script src="/js/jquery-3.5.0.js"></script>
    <script src="/js/menu.js"></script>

    <!-- fonction dynamique  -->
    <script src="/js/backgroundDynamique.js" async></script>
    <script src="/js/gallerieDynamique.js" defer></script>


</head>

<body>

    <header id="mainHearder">

        <a href="/webPage/index.html#mainContant"><img src="/image/icon/max.png" alt="image ico du site" title="retour a la page d'accueil" id="logo" /></a>

        <h1>Le blog du Développeur</h1>

        <nav id="mainNav">

            <ul>
                <li> <a href="/webPage/index.html" title="Vers la page d'accueil du site">Accueil</a> </li>
                <li> <a href="/webPage/galeries.html" title="Vers la page des galeries de photographies">Galeries</a></li>
                <li> <a href="/webPage/contact.html" title="Vers la page de contact">Contact</a></li>
                <li> <a href="/webPage/about.html" title="Vers la page de l'à propos">A propos</a></li>
                <li> <a href="/webPage/blog.html" title="Vers la page de mon Blog">Blog</a></li>
                <li> <a href="https://github.com/MGNetworking" title="Vers Mon github">My github</a></li>
                <li> <a href="/webPage/CV.html" title="Vers la page de mon CV">CV</a></li>
            </ul>
        </nav>
        <button id="menuButton"><img src="/image/icon/hamburger.svg" alt="ouvrir / Fermer le menu"/></button>
    </header>
    <!-- fin mainHearder -->

    <div id="mainbody" class="galleries">


        <main id="mainContant">

            <header>
                <h2>Galeries</h2>
            </header>

            <ul>
                <li>
                    <a href="/webPage/webGaleries/gallerieImage.html?id=nancy">
                        <h3>Nancy 2020</h3>
                        <img src="/image/galeries/nancy/IMG_1_Nancy.jpg" alt="image de nancy">
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae amet adipisci eveniet consequatur, animi aspernatur labore maxime? Quidem perferendis corporis, eveniet fugit magni dolores animi, totam pariatur voluptas aspernatur
                            modi.
                        </p>
                    </a>
                </li>
                <li>
                    <a href="/webPage/webGaleries/gallerieImage.html?id=paris">
                        <h3>Paris 2019</h3>
                        <img src="/image/galeries/paris/IMG_1_Paris.jpg" alt="image de paris">
                        <p>Ullam amet a, temporibus ad veniam dicta, minima consequuntur ipsa nam doloribus aliquam, alias modi debitis distinctio vero magnam necessitatibus. Autem veritatis ipsum sed ipsam voluptas exercitationem hic maiores sapiente?</p>
                    </a>
                </li>

            </ul>

            <p>

                <a href="#mainContant">
                    <button class="bpRetour">
                        <img src="/image/icon/chevrons-up.svg" alt="retour en haut de la page">
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