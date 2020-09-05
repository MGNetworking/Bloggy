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

<c:if test="${ empty requestScope.action}">
    <h2>Creation d'un article</h2>
    <form action="<c:url value="/article"/>?ActionArticle=create" method="post" enctype="multipart/form-data">
</c:if>

<c:if test="${ requestScope.action eq 'modifier'}">
    <h2>Modification d'un article</h2>
    <h2>Attention vous allez modifier cette article si vous cliquez sur envoyer.</h2>
</c:if>

<c:if test="${ requestScope.action eq 'supprimer'}">
    <h2>Suppression d'un article</h2>
    <h2>Attention vous allez supprimer cette article si vous cliquez sur envoyer.</h2>
</c:if>


<c:if test="${ requestScope.action eq 'modifier'}">
    <form action="<c:url value="/article"/>?ActionArticle=modifier&id_article=${requestScope.article.id}"
    method="post" enctype="multipart/form-data">
</c:if>

<c:if test="${ requestScope.action eq 'supprimer'}">
    <form action="<c:url value="/article"/>?ActionArticle=supprimer&id_article=${requestScope.article.id}"
    method="post" enctype="multipart/form-data">
</c:if>


<c:set var="csrfToken" value="${ TokenHelper.generateCsrfToken() }"/>
<c:set var="_csrfToken" value="${csrfToken}" scope="session"/>
<input type="hidden" value="${csrfToken}" name="${ TokenHelper.CSRF_TOKEN_VALUE_NAME }"/>


<div>
    <p>Nom du createur de l'article : ${sessionScope.user.name}</p>
    <input type="hidden" name="id" value="${sessionScope.user.id}">
    <input type="hidden" name="page" value="articleProjet">
</div>

<div>
    <label for="title" class="name">Titre de l'article</label>
    <c:if test="${empty requestScope.action}">
        <input name="title" type="text" value="" required autofocus tabindex="1">
    </c:if>
    <c:if test="${requestScope.action eq 'modifier' or requestScope.action eq 'supprimer'}">
        <input name="title" type="text" required autofocus tabindex="1"
               value="${ requestScope.article.title }"/>
    </c:if>
</div>

<div>
    <label for="article" class="name">Le texte</label>
    <c:if test="${empty requestScope.action}">
        <textarea name="article" value="vide" id="article" cols="30" rows="10" required tabindex="2"></textarea>
    </c:if>
    <c:if test="${requestScope.action eq 'modifier' or requestScope.action eq 'supprimer'}">
            <textarea name="article" id="article" cols="30" rows="10" required tabindex="2">
                    ${ requestScope.article.articletexte }
            </textarea>
    </c:if>
</div>

<div>

    <c:if test="${empty requestScope.action}">
        <label for="file">Ajouté une image png ou jpeg au Texte</label>
        <input type="file" value="" name="image-article" accept="image/png, image/jpeg" tabindex="3">
    </c:if>
    <c:if test="${requestScope.action eq 'modifier' or requestScope.action eq 'supprimer'}">
        <label for="file">Modification de l'image de l'article</label>
        <p>Gardé l'image precedente <input type="checkbox" name="image-article-befort" value="${ requestScope.article.pathImage }" checked> </p>
        <p>Pour changé d'image </p>
        <input type="file" value="" name="image-article" accept="image/png, image/jpeg" tabindex="3">

    </c:if>

</div>

<div>
    <label for="file">Ajouté un commentaire a l'image</label>
    <c:if test="${empty requestScope.action}">
        <input type="commentaire" value="" name="image-commentaire" tabindex="4">
    </c:if>
    <c:if test="${requestScope.action eq 'modifier' or requestScope.action eq 'supprimer'}">
        <input type="commentaire" name="image-commentaire" tabindex="4"
               value="${ requestScope.article.commentImage }"/>

    </c:if>

</div>

<button type="submit" tabindex="5">Envoyer</button>

</form>
