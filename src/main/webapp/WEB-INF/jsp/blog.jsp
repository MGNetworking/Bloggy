<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <c:import url="elements/headImport.jsp"></c:import>
    <%-- fin import head --%>
</head>

<body>

<header id="mainHearder">
    <c:import url="elements/navBar.jsp"></c:import>
    <%-- fin import nav bar --%>
</header>


<div id="mainbody" class="colonneMain">

    <main id="mainContant">
        <articletexte>

            <header>
                <h3>Titre 1 du blog</h3>
                <p><strong>JJ - MM - AAAA</strong> | Maxime Ghalem | 3 commentaire</p>
            </header>

            <p><img src="<c:url value="/static/image/article/pcDell1.png" />" alt="image dillustration"/>Lorem, ipsum
                dolor sit amet consectetur adipisicing elit. Perferendis dolor quas obcaecati iste facilis incidunt
                quasi odio porro, omnis corrupti ipsa beatae cumque natus
                praesentium et sequi sed ea consequuntur. Tempora repellendus fuga inventore id totam suscipit expedita
                doloribus vero laborum ducimus! Doloribus maxime amet voluptates magni quod totam itaque?</p>
            <p>
                <a href="<c:url value="/blog" />?articletexte=MyPc1">Lire la suite</a>
            </p>
        </articletexte>
        <!-- fin de la articletexte 1 -->


        <articletexte>

            <header>
                <h3>Titre 2 du blog</h3>
                <p><strong>JJ - MM - AAAA</strong> | Maxime Ghalem | 3 commentaire</p>
            </header>

            <p><img src="<c:url value="/static/image/article/pcDell1.png" />" alt="image dillustration"/>Lorem, ipsum
                dolor sit amet consectetur adipisicing elit. Perferendis dolor quas obcaecati iste facilis incidunt
                quasi odio porro, omnis corrupti ipsa beatae cumque natus
                praesentium et sequi sed ea consequuntur. Tempora repellendus fuga inventore id totam suscipit expedita
                doloribus vero laborum ducimus! Doloribus maxime amet voluptates magni quod totam itaque?</p>
            <p>
                <a href="<c:url value="/blog" />?articletexte=MyPc1">Lire la suite</a>
            </p>
        </articletexte>
        <!-- fin de la articletexte 2-->


        <articletexte>
            <header>
                <h3>Titre 3 du blog</h3>
                <p><strong>JJ - MM - AAAA</strong> | Maxime Ghalem | 3 commentaire</p>
            </header>
            <p>
                <img src="<c:url value="/static/image/article/pcDell1.png" />" alt="image dillustration"/>Lorem, ipsum
                dolor sit amet consectetur adipisicing elit. Perferendis dolor quas obcaecati iste facilis incidunt
                quasi odio porro, omnis corrupti ipsa beatae cumque natus
                praesentium et sequi sed ea consequuntur. Tempora repellendus fuga inventore id totam suscipit expedita
                doloribus vero laborum ducimus! Doloribus maxime amet voluptates magni quod totam itaque?</p>
            <p>
                <a href="<c:url value="/blog" />?articletexte=MyPc1">Lire la suite</a>
            </p>
        </articletexte>
        <!-- fin de la articletexte 3-->

        <p>

            <a href="#mainContant">
                <button class="bpRetour">
                    <img src="<c:url value="/static/jsp/icon/chevrons-up.svg" />" alt="retour en haut de la page">
                </button>
            </a>

        </p>
        <!-- fin bouton de retour  -->


    </main>
    <!-- fin du mainContant-->


    <aside id="colonneDroitAside">
        <c:import url="elements/asideSection.jsp"></c:import>
        <%-- fin import aside --%>
    </aside>
    <!-- fin colonneDroit-->

</div>
<!-- fin mainbody -->
</body>

<footer id="mainFooter">
    <p>&copy;Copyright Ghalem Maxime - 2020</p>
</footer>
<!-- fin mainFooter -->

</html>
