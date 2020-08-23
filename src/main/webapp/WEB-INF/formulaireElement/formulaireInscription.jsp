<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 22/08/2020
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="util.TokenHelper" %>
<h2>Inscription au compte utilisateur</h2>

<form action="<c:url value="/inscription" />" method="post">

    <c:set var="csrfToken" value="${ TokenHelper.generateCsrfToken() }"/>
    <c:set var="_csrfToken" value="${csrfToken}" scope="session"/>
    <input type="hidden" value="${csrfToken}" name="${ TokenHelper.CSRF_TOKEN_VALUE_NAME }"/>

    <div>
        <p>Entre vos indentifiant utilisateur </p>
       <%-- <span class="messageFormulaire">${}</span>--%>
    </div>

    <div>
        <P>Votre nom doit comporter entre 4 est 100 caractère</p>
        <label for="name" class="name">Nom :</label>
        <input name="name" type="text" minlength="4" maxlength="100"
               required autofocus tabindex="1">

    </div>

    <div>
        <P>Votre Prenom doit comporter entre 4 est 100 caractère</p>
        <label for="firstName" class="firstName">Prenom :</label>
        <input name="firstName" type="text" minlength="4" maxlength="100"
               required autofocus tabindex="2">
    </div>

    <div>
        <p>L'avatar est le nom utilisé scéne sur le site.<br>
            Votre Avatar doit comporter entre 4 est 25 caractère</p>
        <label for="avatar" class="avatar">Avatar :</label>
        <input name="avatar" type="text" minlength="4" maxlength="25"
               required autofocus tabindex="3">
    </div>

    <div>
        <P>Votre mot de passe doit comporter entre 6 est 20 caractère</p>
        <label for="password" class="password">Password :</label>
        <input name="password" type="password" minlength="6" maxlength="100"
               required autofocus tabindex="4">
    </div>

    <div>
        <P>Votre adresse Email doit être valide <br>
            Dans le cas contraire vous serais inscrit <br>
            mais vous n'aurais aucun droit attribué sur le site </p>
        <label for="email" class="email">Email :</label>
        <input name="email" type="email"
               required autofocus tabindex="5">
    </div>


    <button type="submit" tabindex="6">Envoyer</button>

</form>

