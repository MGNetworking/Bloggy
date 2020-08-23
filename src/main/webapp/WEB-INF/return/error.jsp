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

        <c:if test="${requestScope.error == '400'}">
                <h2>ERROR 400</h2>
                <p>Bad Request, une erreur est sur venu pendant le traitement.</p>
        </c:if>

        <c:if test="${requestScope.error == '401'}">
            <h2>ERROR 401</h2>
            <p>Accès refusé au site</p>
        </c:if>

        <c:if test="${requestScope.error == '402'}">
            <h2>ERROR 402</h2>
            <p>Payement refuser</p>
        </c:if>

        <c:if test="${requestScope.error == '403'}">
            <h2>ERROR 403</h2>
            <p>Accèes interdit </p>
        </c:if>

        <c:if test="${requestScope.error == '500'}">
            <h2>ERROR 500</h2>
            <p>Un problème interne au serveur est survenu</p>
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
