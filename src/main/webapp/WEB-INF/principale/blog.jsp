<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="util.TokenHelper" %>
<%@ page import="util.NameRole" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <c:import url="../elements/headImport.jsp"></c:import>
    <%-- fin import head --%>
</head>

<body>

<header id="mainHearder">
    <c:import url="../elements/navBar.jsp"></c:import>
    <%-- fin import nav bar --%>
</header>


<div id="mainbody" class="colonneMain">

    <main id="mainContant">
        <c:set var="csrfToken" value="${TokenHelper.generateCsrfToken()}"/>

        <c:forEach var="article" items="${requestScope.listArticle}">
            <articletexte>

                <header>
                    <h3>${article.title}</h3>
                    <p><strong>${article.date}</strong> | ${article.avatar} </p>
                </header>

                <p>
                    <img src="<c:url value="${article.pathImage}" />" alt="image dillustration"/>
                        ${article.articletexte}
                </p>


                <c:if test="${article.name eq sessionScope.user.name or fn:contains(user.listeRole ,NameRole.ADMIN)}">

                    <form action="<c:url value="/article" />?page=modifier" method="post">

                        <c:set var="_csrfToken" value="${csrfToken}" scope="session"/>
                        <input type="hidden" value="${csrfToken}" name="${ TokenHelper.CSRF_TOKEN_VALUE_NAME }"/>

                        <input type="hidden" value="${ article.id_article }" name="id_article"/>

                        <button type="submit">Modifier</button>
                    </form>

                    <form action="<c:url value="/article" />?page=supprimer" method="post">

                        <c:set var="_csrftoken" value="${csrfToken}" scope="session"></c:set>
                        <input type="hidden" value="${csrfToken}" name="${TokenHelper.CSRF_TOKEN_VALUE_NAME}"/>

                        <input type="hidden" value="${ article.id_article }" name="id_article"/>

                        <button type="submit">Supprimer</button>
                    </form>
                </c:if>

            </articletexte>
        </c:forEach>

        <c:forEach var="page" end="${requestScope.numberOfPage}" begin="0" step="1">
            <a href="<c:url value="/article"/>?paginable=${page}&page=visite">${page}</a>
        </c:forEach>

        <!-- fin bouton de retour  -->

        <p>

            <a href="#mainContant">
                <button class="bpRetour">
                    <img src="<c:url value="/static/jsp/icon/chevrons-up.svg" />" alt="retour en haut de la page">
                </button>
            </a>

        </p>
    </main>
    <!-- fin du mainContant-->


    <aside id="colonneDroitAside">
        <c:import url="../elements/asideSection.jsp"></c:import>
    </aside>
    <!-- fin colonneDroit-->

</div>

</body>
<!-- fin mainbody -->

<footer id="mainFooter">
    <p>&copy;Copyright Ghalem Maxime - 2020</p>
</footer>
<!-- fin mainFooter -->

</html>
