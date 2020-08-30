<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="entities.RoleUser" %>
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

        <c:if test="${requestScope.retourUser == 'connection'}">
        <h2>Connection Reussi</h2>
        <p>Vous etez connecter en tant que :
            <c:forEach var="role" items="${sessionScope.user.listeRole}">
                <c:out value="${role.value}"></c:out>
            </c:forEach>
        </p>

        </c:if>

        <c:if test="${requestScope.retourUser == 'inscription'}">
            <h2>Inscription Reussi</h2>
            <p>Vous etez inscrit en tant que ${requestScope.user.avatar}<br>
                Aprés verification au prét de nos service vos droits vous seront donnée dans 24H <br>
                Merci de votre compréhension.
            </p>

        </c:if>


    </main>
    <!-- fin mainContant-->

</div>
<!-- fin mainbody -->

<c:import url="../elements/scriptImport.jsp"></c:import>
</body>

<footer id="mainFooter">
    <p>&copy;Copyright Ghalem Maxime - 2020</p>
</footer>
<!-- fin mainFooter -->

</html>
