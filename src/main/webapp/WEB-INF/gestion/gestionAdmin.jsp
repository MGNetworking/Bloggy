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
        <form action="<c:url value="/gestionAdmin" />" method="post">

            <c:set var="csrfToken" value="${ TokenHelper.generateCsrfToken() }"/>
            <c:set var="_csrfToken" value="${csrfToken}" scope="session"/>
            <input type="hidden" value="${csrfToken}" name="${ TokenHelper.CSRF_TOKEN_VALUE_NAME }"/>

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

                <c:forEach var="user" items="${requestScope.ListUser}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.firstName}</td>
                        <td>${user.avatar}</td>
                        <td>${user.email}</td>

                        <c:if test="${ not empty user.listeRole}">


                            <c:if test="${fn:contains(user.listeRole ,'ADMIN')}">
                                <td>
                                    <input type='checkbox' name="ADMIN" value="${user.name}" checked tabindex="1">
                                </td>

                            </c:if>

                            <c:if test="${not fn:contains(user.listeRole ,'ADMIN')}">
                                <td>
                                    <input type='checkbox' name="ADMIN" tabindex="1">
                                </td>

                            </c:if>

                            <c:if test="${fn:contains(user.listeRole ,'USER_ARTICLE')}">
                                <td>
                                    <input type='checkbox' name="USER_ARTICLE" checked tabindex="2">
                                </td>

                            </c:if>

                            <c:if test="${not fn:contains(user.listeRole ,'USER_ARTICLE')}">
                                <td>
                                    <input type='checkbox' name="USER_ARTICLE" tabindex="2">
                                </td>
                            </c:if>


                        </c:if>

                        <c:if var="list" test="${ empty user.listeRole}">
                            <td>
                                <input type='checkbox' name="ADMIN" tabindex="1">
                            </td>

                            <td>
                                <input type='checkbox' name="USER_ARTICLE" tabindex="2">
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
