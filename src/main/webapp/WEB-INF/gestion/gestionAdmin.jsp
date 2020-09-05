<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 23/08/2020
  Time: 00:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="util.TokenHelper" %>
<%@ page import="util.NameRole" %>

<html>
<head>
    <title>gestion</title>
    <c:import url="../elements/headImport.jsp"></c:import>
</head>

<body>

<header id="mainHearder">
    <c:import url="../elements/navBar.jsp"></c:import>
</header>
<div id="mainbody" class="colonneMain">

    <main id="mainContant">
        <h1>Gestion des droits administrateur</h1>




        <table name="tb">
            <thead>
            <tr>
                <th>Id user</th>
                <th>Name</th>
                <th>Firstname</th>
                <th>Avatar</th>
                <th>email</th>
                <th>Droit Admin</th>
                <th>Droit User_Article</th>

            </tr>
            </thead>



            <form action="<c:url value="/gestionAdmin" />" method="post">

                <c:set var="csrfToken" value="${ TokenHelper.generateCsrfToken() }"/>
                <c:set var="_csrfToken" value="${csrfToken}" scope="session"/>
                <input type="hidden" value="${csrfToken}" name="${ TokenHelper.CSRF_TOKEN_VALUE_NAME }"/>

                    <input type="hidden" value="${requestScope.ListUser}" name="ListeUser" />

                <c:forEach var="user" items="${requestScope.ListUser}">

                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.firstName}</td>
                    <td>${user.avatar}</td>
                    <td>${user.email}</td>


                    <c:if test="${ not empty user.listeRole}">


                        <c:if test="${fn:contains(user.listeRole ,NameRole.ADMIN)}">
                            <td>
                                <input type='checkbox' name="${user.id}${NameRole.ADMIN}"  checked tabindex="1">
                            </td>

                        </c:if>

                        <c:if test="${not fn:contains(user.listeRole ,NameRole.ADMIN)}">
                            <td>
                                <input type='checkbox' name="${user.id}${NameRole.ADMIN}" tabindex="1">
                            </td>

                        </c:if>

                        <c:if test="${fn:contains(user.listeRole ,NameRole.USER_ARTICLE)}">
                            <td>
                                <input type='checkbox' name="${user.id}${NameRole.USER_ARTICLE}"  checked tabindex="2">
                            </td>

                        </c:if>

                        <c:if test="${not fn:contains(user.listeRole ,NameRole.USER_ARTICLE)}">
                            <td>
                                <input type='checkbox' name="${user.id}${NameRole.USER_ARTICLE}" tabindex="2">
                            </td>
                        </c:if>


                    </c:if>

                    <c:if var="list" test="${ empty user.listeRole}">
                        <td>
                            <input type='checkbox' name="${user.name}${NameRole.ADMIN.name()}"  tabindex="1">
                        </td>

                        <td>
                            <input type='checkbox' name="${user.name}${NameRole.USER_ARTICLE.name()}" tabindex="2">
                        </td>

                    </c:if>

                </tr>
                </c:forEach>

        </table>
        <button type="submit" tabindex="3">Envoyer</button>
        </form>
    </main>

    <aside id="colonneDroitAside">
        <c:import url="../elements/asideSection.jsp"></c:import>
    </aside>

</div>
<!-- fin mainbody -->

</body>
</html>
