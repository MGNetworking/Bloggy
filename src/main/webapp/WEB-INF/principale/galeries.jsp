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

<div id="mainbody" class="galleries">

    <main id="mainContant">

        <header>
            <h2>Galeries</h2>
        </header>

        <ul>
            <li>
                <a href="<c:url value="/galerie" />?id=nancy">
                    <h3>Nancy 2020</h3>
                    <img src="<c:url value="/static/image/galeries/nancy/IMG_1_Nancy.jpg" />" alt="image de nancy">
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae amet adipisci eveniet consequatur,
                        animi aspernatur labore maxime? Quidem perferendis corporis, eveniet fugit magni dolores animi,
                        totam pariatur voluptas aspernatur
                        modi.
                    </p>
                </a>
            </li>
            <li>
                <a href="<c:url value="/galerie" />?id=paris">
                    <h3>Paris 2019</h3>
                    <img src="<c:url value="/static/image/galeries/paris/IMG_1_Paris.jpg" />" alt="image de paris">
                    <p>Ullam amet a, temporibus ad veniam dicta, minima consequuntur ipsa nam doloribus aliquam, alias
                        modi debitis distinctio vero magnam necessitatibus. Autem veritatis ipsum sed ipsam voluptas
                        exercitationem hic maiores sapiente?</p>
                </a>
            </li>

        </ul>

        <p>

            <a href="#mainContant">
                <button class="bpRetour">
                    <img src="<c:url value="/static/image/icon/chevrons-up.svg" />" alt="retour en haut de la page">
                </button>
            </a>

        </p>
        <!-- fin bouton de retour  -->

    </main>
    <!-- fin mainContant-->


</div>
<!-- fin mainbody -->

<c:import url="../elements/scriptImport.jsp"></c:import>
<script src="<c:url value="/static/js/gallerieDynamique.js" />"></script>
<%-- fin script JS --%>

</body>

<footer id="mainFooter">
    <p>&copy;right Ghalem Maxime - 2020</p>
</footer>
<!-- fin mainFooter -->

</html>
