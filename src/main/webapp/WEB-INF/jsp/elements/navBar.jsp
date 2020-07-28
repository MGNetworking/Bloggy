<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 28/07/2020
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<a href="<c:url value="/home"/>#mainContant">

    <img src="<c:url value="/static/image/icon/max.png"/>"
         alt="image ico du site" title="retour a la page d'accueil"
         id="logo"/>
</a>

<h1>Le blog du Développeur</h1>

<nav id="mainNav">

    <h2 class="accessibiliter">Menu principale</h2>
    <p class="accessibiliter">
        <a href="#mainContant" title="Accéder directement au contenu principale de cette page ">Passer le menu</a>
    </p>
    <!-- raccourcie pour l'accessibiter des personne en situation de handicape -->

    <ul>
        <li><a href="<c:url value="/home" />" title="Vers la page d'accueil du site">Accueil</a></li>
        <li><a href="<c:url value="/galerie"/>" title="Vers la page des galeries de photographies">Galeries</a></li>
        <li><a href="<c:url value="/contact"/>" title="Vers la page de contact">Contact</a></li>
        <li><a href="<c:url value="/about" />" title="Vers la page de l'à propos">A propos</a></li>
        <li><a href="<c:url value="/blog"/>" title="Vers la page de mon Blog">Blog</a></li>
        <li><a href="https://github.com/MGNetworking" title="Vers Mon github">My github</a></li>
        <li><a href="<c:url value="/cv"/>" title="Vers la page de mon CV">CV</a></li>
    </ul>
</nav>
<button id="menuButton"><img src="<c:url value="/static/image/icon/hamburger.svg"/> "
                             alt="ouvrir / Fermer le menu"/></button>
