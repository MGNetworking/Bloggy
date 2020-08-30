<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 01/08/2020
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="util.TokenHelper" %>

<header>
    <h2>Contactez-moi</h2>
    <p>Merci de compléter le formulaire suivant pour me contacter. Tout les champs de ce formulaire sont
        requis.</p>
</header>
<!-- novalidate : permet de ne pas verifier les champs -->
<form id="formContact" action="<c:url value="/contact"/>?retour=contact" method="post" novalidate>

    <c:set var="csrfToken" value="${ TokenHelper.generateCsrfToken() }"/>
    <c:set var="_csrfToken" value="${csrfToken}" scope="session"/>
    <input type="hidden" value="${csrfToken}" name="${ TokenHelper.CSRF_TOKEN_VALUE_NAME }"/>

    <div>
        <div>
            <label for="nomFamille">Nom de Famille</label>
            <input type="text" name="nomFamille" id="nomFamille" required autofocus tabindex="1"
                   placeholder="votre name"/>

        </div>
        <div>
            <label for="firstName">Prénom</label>
            <input type="text" name="firstName" id="firstName" required tabindex="2"
                   placeholder="Votre firstName"/>
        </div>
        <div>
            <label for="email">Adresse e-mail</label>
            <input type="email" name="email" id="email" required tabindex="3"
                   placeholder="votre.email@gmail.com"/>
        </div>
    </div>


    <div>
        <div>

            <label for="message">Votre Message</label>
            <textarea name="message" id="message" required tabindex="4"
                      title="Mettre votre message a notre attention"></textarea>

        </div>
    </div>
    <div>
        <button type="submit" tabindex="5">Envoyer</button>
    </div>

</form>
<!-- fin formContact -->
<script src="<c:url value="/static/js/formulaire.js" />"></script>
