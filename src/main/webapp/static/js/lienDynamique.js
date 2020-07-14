/* creation des éléments pour la page galeriImage.html 
Ce sript fait : 
    ajoute un listener sur la page ecoute le chargement 
    recherche le fichier Json qui contient tout les reférences des images
    créer les éléments pour l'ajout de ces images
    ajoute un listner pour l'agrandissement est le retour de celui-ci pour chaque image
*/
var villegalerie;
// listener d'ecoute
window.addEventListener('load', () => {

    console.log(window.location.href)
    console.log(window.location.host)
    console.log(window.location.pathname)
    console.log(window.location.protocol)
    console.log(window.location.search)

    // recuépration de la recherche lié au choix utilisateur
    let recherche = new URLSearchParams(window.location.search);

    /*si un élement id est contenu dans la 
    recherche lancer par le choix utilisateur*/
    if (recherche.has('id')) {

        villegalerie = recherche.get('id');
        constructionFichier(villegalerie);

        /*si non je le renvoie sur la page de la recherche*/
    } else {

        console.error("les éléments d'affichage n'ont pas était trouver")

        // redirection vers la page galerie.jsp
        window.location.href= window.location.href.replace(window.location.search,"")
    }

}, false);

// fonction qui recherche le fichier Json d'affichage
function constructionFichier(villeRecherche) {

    // requete permettant d'aller cherché le fichier
    fetch(`./static/json/${villeRecherche}.json`).then(function(fetchReponse) {

        // si le fichier et trouver 
        if (fetchReponse.ok) {

            console.log(fetchReponse.ok)

            // renvoie du fichier
            return fetchReponse.json();

        } else {

            // si non message log 
            console.error("le fichier permettant l'affichage n'a pas etait trouver");
        }

        // recup fichier Json
    }).then(function(fichierJson) {

        console.log(fichierJson)

        console.log(villegalerie)

        // créer header et un titre h1
        let elementHeader = document.createElement('header')
        let elementH1 = document.createElement('h2');

        // ajout du titre
        elementHeader.appendChild(elementH1);

        elementH1.appendChild(document.createTextNode(villegalerie + " " + fichierJson.ville[0].annees));

        // recherche pour ajout locale
        let tagAjout = document.querySelector('.galleries main');
        tagAjout.appendChild(elementHeader);

        // créer element ul
        let elementUl = document.createElement('ul');

        for (let i = 0; i < fichierJson.ville.length; i++) {

            //créer element img
            let elementIMG = document.createElement('img');

            // ajoute des attributs img
            elementIMG.src = fichierJson.ville[i].href;
            elementIMG.alt = fichierJson.ville[i].alt;
            elementIMG.title = fichierJson.ville[i].title;

            elementIMG.addEventListener('click', imageAction, false);

            // créer element li
            let elementLi = document.createElement('li');
            elementLi.appendChild(elementIMG);

            // ajoute de li a ul
            elementUl.appendChild(elementLi);

            // recherche local des element a ajouté
            let tagAjout = document.querySelector('.galleries main');

            // ajout a  de ul dans balise main
            tagAjout.appendChild(elementUl);
        }

    })

}

// evenement image
function imageAction(event) {

    // recupération de la cible (image click)
    let image = event.target;

    // recup de l'id agrandissement
    let idAgrandissement = document.querySelector('#agrandissement');

    //console.log(idAgrandissement);
    // recup la balise img
    let tagImg = idAgrandissement.querySelector('img');

    // ajoute a la source clické la nouvelle soucre
    tagImg.src = image.src;

    // ajout de la classe visible en fonction de l'etat
    idAgrandissement.classList.toggle('visible');
    // ajout de l'evenement pour la fermeture
    idAgrandissement.addEventListener('click', fermetureImage, false);

}

// fonction d'agrandissement
function fermetureImage() {

    // recup de l'id agrandissement
    let idAgrandissement = document.getElementById('agrandissement');

    // ici il enléve la classe agrandissement situé dans ficgure 
    // cela a pour effet de faire disparaitre les propriétés d'affichage
    idAgrandissement.classList.toggle('visible');
}
