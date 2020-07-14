/*Ce script est utiliser pour le changement d'image du background
    utilisation de l'API Fetch*/



    // envoi une requet sur le serveur pour la récupération du fichier Json
    fetch("./static/json/check_background.json").then(function(response) {

        //console.log('leture check_background.json')

        // si la reponse est ok , renvoi du fichier Json
        if (response.ok) {
            return response.json();

        } else {
            console.warn("problème sur la requete : le fichier n'a pas était trouver")
        }


        // 2eme parti ajout de l'image
    }).then(function(monFichierJson) {

        //console.log(monFichierJson)
        // création d'un nombre aléatoire sur taille du fichier
        let imagerecherche = Math.floor(Math.random() * monFichierJson.image.length);

        let pathImage = monFichierJson.image[imagerecherche].path;

        // recherche de l'élément id mainbody pour l'ajout de l'image
        let mainbody = document.querySelector("#mainbody");

        // modification du background en passante par l'objet style du DOM
        mainbody.style.backgroundImage = `url(./static/image/background/${pathImage})`;

    })


