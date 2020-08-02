<%--
  Created by IntelliJ IDEA.
  User: Maxime
  Date: 01/08/2020
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Connextion au compte utilisateur</h2>

<form action="<c:url value="/connection" />" method="post">

    <div>
        <label for="" class="name">Nom :</label>
        <input name="name" type="text" required autofocus tabindex="1">
    </div>

    <div>
        <label for="" class="name">Password :</label>
        <input name="password" type="password" required autofocus tabindex="2">
    </div>

    <div>
        <label for="remember">Remember Me</label>
        <input name="remember" type="checkbox" tabindex="3">
    </div>

    <button type="submit" tabindex="3">Envoyer</button>

</form>

<!-- fin bouton de retour  -->
