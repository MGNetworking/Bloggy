<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="util.TokenHelper" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
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

<div id="mainbody" class="colonneMain">

    <main id="mainContant">

        <c:if test="${requestScope.formulaire == 'creationArticle'}">
            <c:import url="../formulaireElement/formulaireArticle.jsp"></c:import>
        </c:if>

        <c:if test="${requestScope.formulaire == 'contact'}">
            <c:import url="../formulaireElement/formulaireContact.jsp"></c:import>
        </c:if>

        <c:if test="${requestScope.formulaire == 'connection'}">
            <c:import url="../formulaireElement/formulaireConnection.jsp"></c:import>
        </c:if>

        <c:if test="${requestScope.formulaire == 'inscription'}">
            <c:import url="../formulaireElement/formulaireInscription.jsp"></c:import>
        </c:if>

    </main>


    <aside id="colonneDroitAside">
        <c:import url="../elements/asideSection.jsp"></c:import>
    </aside>
    <!-- fin colonneDroit-->


</div>
<!-- fin mainbody -->

<c:import url="../elements/scriptImport.jsp"></c:import>
</body>

<footer id="mainFooter">
    <p>&copy;copyright ghalem maxime - 2020</p>
</footer>
<!-- fin mainFooter -->

</html>
