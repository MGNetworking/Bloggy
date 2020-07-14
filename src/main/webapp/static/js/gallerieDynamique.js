/* script d'agrandissement de l'image sélection dans la galerie 
recherche element dans le DOM de mes images*/

let element = document.querySelectorAll('#mainContant ul li img');

for (let i = 0; i < element.length; i++) {

    element[i].addEventListener('click', imageAction, false);

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

    // ajout de la classe visible
    // toggle a pour fonction de mettre en fonction ce qu'il contient
    // ici il ajoute la classe visible a la balise figure
    // si la classe existe, il l'ajoute.si non il l'enlève
    idAgrandissement.classList.toggle('visible');
    // ajout de l'evenement pour la fermeture
    idAgrandissement.addEventListener('click', fermetureImage, false);

}

// fonction utiliser pour evenement
function fermetureImage() {

    // recup de l'id agrandissement
    let idAgrandissement = document.getElementById('agrandissement');

    // ici il enléve la classe agrandissement situé dans ficgure 
    // cela a pour effet de faire disparaitre les propriétés d'affichage
    idAgrandissement.classList.toggle('visible');
}