<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 01/08/2020
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="util.TokenHelper" %>
<h2>Creation d'un article</h2>

<form action="<c:url value="/article"/>" method="post" enctype="multipart/form-data">


    <c:set var="csrfToken" value="${ TokenHelper.generateCsrfToken() }"/>
    <c:set var="_csrfToken" value="${csrfToken}" scope="session"/>
    <input type="hidden" value="${csrfToken}" name="${ TokenHelper.CSRF_TOKEN_VALUE_NAME }"/>


    <div>
        <p>Nom du createur de l'article : ${sessionScope.user.name}</p>
        <input type="hidden" name="id" value="${sessionScope.user.id}">
        <input type="hidden" name="page" value="articleProjet">
    </div>

    <div>
        <label for="title" class="name">Titre de la page de bienvenue</label>
        <input name="title" type="text" required autofocus tabindex="1">
    </div>

    <div>
        <label for="article" class="name">Le texte</label>
        <textarea name="article" id="article" cols="30" rows="10" required tabindex="2"></textarea>
    </div>

    <div>
        <label for="file">Ajouté une image png ou jpeg au Texte</label>
        <input type="file" name="image-article" accept="image/png, image/jpeg" tabindex="3">
    </div>

    <div>
        <label for="file">Ajouté un commentaire a l'image</label>
        <input type="commentaire" name="image-commentaire" tabindex="4">
    </div>

    <button type="submit" tabindex="5">Envoyer</button>

</form>
