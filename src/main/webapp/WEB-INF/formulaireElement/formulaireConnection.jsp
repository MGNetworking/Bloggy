<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 01/08/2020
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="util.TokenHelper" %>
<h2>Connextion au compte utilisateur</h2>

<form action="<c:url value="/connection" />" method="post">

    <c:set var="csrfToken" value="${ TokenHelper.generateCsrfToken() }"/>
    <c:set var="_csrfToken" value="${csrfToken}" scope="session"/>
    <input type="hidden" value="${csrfToken}" name="${ TokenHelper.CSRF_TOKEN_VALUE_NAME }"/>

    <div>
        <label for="name" class="name">Nom :</label>
        <input name="name" type="text" required autofocus tabindex="1">
    </div>

    <div>
        <label for="firstName" class="firstName">Prenom :</label>
        <input name="firstName" type="text" required autofocus tabindex="2">
    </div>

    <div>
        <label for="password" class="password">Password :</label>
        <input name="password" type="password" required autofocus tabindex="3">
    </div>

    <div>
        <label for="remember">Remember Me</label>
        <input name="remember" type="checkbox" tabindex="3">
    </div>

    <button type="submit" tabindex="4">Envoyer</button>

    <div>
        <p>Si vous etez nouveau sur le site, créer votre espace utilisateur ci-dessous</p>
        <a href="<c:url value="/inscription">Nouvelle inscription</c:url>">
            <button type="button">inscrit toi ICI</button>
        </a>
    </div>

</form>

<!-- fin bouton de retour -->
