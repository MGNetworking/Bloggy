<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <c:import url="../elements/headImport.jsp"></c:import>

</head>

<body>

<header id="mainHearder">
    <c:import url="../elements/navBar.jsp"></c:import>
</header>
<!-- fin mainHearder -->

<div id="mainbody">

    <main id="mainContant" class="retrourForm">

        <%-- si c'est un retour d'ajout d'article--%>
        <c:if test="${requestScope.retour == 'article'}">

            <%-- teste l'article a etait ajouter --%>
            <c:if test="${requestScope.validation == true}">
                <h2>Successfully</h2>
                <p>Votre article de blog a été enregistré avec succès</p>
                <p>Merci de votre contribution au blog</p>
            </c:if>

            <c:if test="${requestScope.validation == false}">
                <h2>Echec</h2>
                <p>Votre article de blog n'a pas été enregistré</p>
                <p>Merci de contacter les services ADMIN de ce blog, Merci de votre compréhension</p>
            </c:if>
        </c:if>

        <%-- si un retour du formulaire de prise de contact --%>
        <c:if test="${requestScope.retour == 'contact'}">

            <h2>Merci</h2>
            <p>Merci de votre message. notre équipe reprendra contact avec vous dans les 3 jours ouvrables.</p>
            <p>A très bientôt.</p>

        </c:if>

    </main>
    <!-- fin mainContant-->

</div>
<!-- fin mainbody -->

</body>
<footer id="mainFooter">
    <p>&copy;Copyright Ghalem Maxime - 2020</p>
</footer>
<!-- fin mainFooter -->

</html>
