/*
ce script permet la validation du formlaire  apres voir
vérifier que les champs ont bien etait compléter
*/

// recup de l'élément formulaire
let eltForm = document.getElementById('formContact');
console.log(document.getElementsByTagName('main'));
// recup les éléments du contenu formulaire
let champsForm = document.querySelectorAll('input[required],textarea[required]');
console.log(champsForm);
// gestion evenement par élément
champsForm.forEach((eltChamps) => {

    // recoit le focus sur le champs du formualire
    eltChamps.addEventListener('focus', () => resteValidation(eltChamps), false);
    // perd le focus sur le champs du formulaire
    eltChamps.addEventListener('blur', () => validation(eltChamps), false);
})

// gestion des evenements par submit
eltForm.addEventListener('submit', (event) => {
    // suprime l'envoi par defaut
    event.preventDefault();

    // supprime les messages précédant
    champsForm.forEach((elementReset) => {
        resteValidation(elementReset);
    })

    let testeChamps = true;
    // pour chaque éléments
    champsForm.forEach((formElement) => {

        // verif validation champs
        if (!validation(formElement)) {
            testeChamps = false;

        }
    });

    // envoi si tout les champs sont ok
    if (testeChamps) {
        event.target.submit();
    }

}, false);

// check
function validation(formElement) {

    // checkValidity est une methode de HTMLSelection
    if (formElement.checkValidity()) {

        return true;

    } else {

        // ajout de la classe invalid
        formElement.classList.add('invalid');
        // report du message d'erreur
        formElement.previousElementSibling.insertAdjacentHTML('beforeend', `<span class="erreurMessage">${formElement.validationMessage}<span/>`);

        return false;
    }
}

// remise a 0 des champs utilisé pour l'invalidation
function resteValidation(formElement) {

    // suprime la classe invalide
    formElement.classList.remove('invalid');
    let champsLabel = formElement.previousElementSibling;

    // pour chaque 1 élément children
    while (champsLabel.firstElementChild) {
        // suprime le 1er éléments
        champsLabel.removeChild(champsLabel.firstElementChild);
    }
    // mise a true de propriete voir interface validityState
    formElement.valid = true;
    console.log(formElement.valid)
}