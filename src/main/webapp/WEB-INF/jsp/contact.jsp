<!DOCTYPE html>
<html lang="fr">

<head>
    <title>Blog &amp; expérience</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0" />
    <meta name="description" content="si vous voulez me contact" />

    <link rel="stylesheet" href="/CSS/accessibiliter.css" type="text/css" />
    <link rel="stylesheet" href="/CSS/normalize.css" type="text/css" />
    <link rel="stylesheet" href="/CSS/site.css" type="text/css" />

    <!-- menu petit ecran -->
    <script src="/js/jquery-3.5.0.js"></script>
    <script src="/js/menu.js"></script>

    <!-- fonction dynamique  -->
    <script src="/js/backgroundDynamique.js" defer></script>

    <!-- formulaire -->
    <script src="/js/formulaire.js" defer></script>


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

    <div id="mainbody">

        <main id="mainContant" class="formulaire">

            <header>
                <h2>Contactez-moi</h2>
                <p>Merci de compléter le formulaire suivant pour me contacter. Tout les champs de ce formulaire sont requis.</p>
            </header>
            <!-- novalidate : permet de ne pas verifier les champs -->
            <!-- a ajoute : method="POST" -->
            <form id="formContact" action="retourFormulaire.jsp" novalidate>

                <div>
                    <div>
                        <label for="nomFamille">Nom de Famille</label>
                        <input type="text" name="nomFamille" id="nomFamille" required autofocus tabindex="1" placeholder="votre nom" />

                    </div>
                    <div>
                        <label for="prenom">Prénom</label>
                        <input type="text" name="prenom" id="prenom" required tabindex="2" placeholder="Votre prenom" />
                    </div>
                    <div>
                        <label for="email">Adresse e-mail</label>
                        <input type="email" name="email" id="email" required tabindex="3" placeholder="votre.email@gmail.com" />
                    </div>
                </div>


                <div>
                    <div>

                        <label for="message">Votre Message</label>
                        <textarea name="message" id="message" required tabindex="4" title="Mettre votre message a notre attention"></textarea>

                    </div>
                </div>
                <div>
                    <button type="submit" tabindex="5">Envoyer</button>
                </div>

            </form>
            <!-- fin formContact -->


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