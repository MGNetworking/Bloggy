<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">

    <c:import url="../elements/headImport.jsp"></c:import>
    <%-- fin import head --%>

<body>

<header id="mainHearder">
    <c:import url="../elements/navBar.jsp"></c:import>
    <%-- fin import nav bar --%>
</header>
<!-- fin mainHearder -->

<div id="mainbody" class="galleries">

    <main id="mainContant">


    </main>
    <!-- fin main -->

</div>
<!-- fin mainbody -->

<figure id="agrandissement">
    <img src="" alt="agrandissament de l'image click">
</figure>

<c:import url="../elements/scriptImport.jsp"></c:import>
<%-- fin import script JS --%>
<script src="<c:url value="/static/js/lienDynamique.js" />"></script>

</body>

<footer id="mainFooter">
    <p>&copy;Copyright Ghalem Maxime - 2020</p>
</footer>
<!-- fin mainFooter -->

</html>
