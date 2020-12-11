<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        <h2>bienvenu sur le site de Ghalem Maxime</h2>
        <%--        <figure class="imgFigure">--%>
        <div >
            <img class="imgFigure" src="<c:url value="/static/image/galeries/paris/IMG_7_Paris.jpg" />"
                 alt="image de l'arc de triomphe"/>
            <figcaption>L'arc de triomphe</figcaption>

            <p>Bonjour est bienvenu sur mon blog. Ce blog a été conçu pour être une vitre de mes activités .Les
                activités
                seront de type informatique principalement mais pas que. Sur ce site vous avez mes coordonnées ainsi que
                mon
                curriculum Vitae au format
                PDF
            </p>

            <p>Actuellement ce site est en cours de construction.</p>
            <p>Il n'est terminer, mais m'a service beaucoup a apprendre le Java et aussi l'intergation continue avec jenkins</p>

            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Hic tempore sed consectetur nisi quas magnam.
                Ab
                adipisci velit laboriosam eveniet sunt, porro accusantium a delectus nulla beatae error harum eligendi
                rem
                perferendis cumque laudantium
                natus alias veniam! Optio repellat, obcaecati temporibus eveniet nisi cum, nostrum ipsam aspernatur,
                eaque
                natus reiciendis!</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Hic tempore sed consectetur nisi quas magnam.
                Ab
                adipisci velit laboriosam eveniet sunt, porro accusantium a delectus nulla beatae error harum eligendi
                rem
                perferendis cumque laudantium
                natus alias veniam! Optio repellat, obcaecati temporibus eveniet nisi cum, nostrum ipsam aspernatur,
                eaque
                natus reiciendis!</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Hic tempore sed consectetur nisi quas magnam.
                Ab
                adipisci velit laboriosam eveniet sunt, porro accusantium a delectus nulla beatae error harum eligendi
                rem
                perferendis cumque laudantium
                natus alias veniam! Optio repellat, obcaecati temporibus eveniet nisi cum, nostrum ipsam aspernatur,
                eaque
                natus reiciendis!</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Hic tempore sed consectetur nisi quas magnam.
                Ab
                adipisci velit laboriosam eveniet sunt, porro accusantium a delectus nulla beatae error harum eligendi
                rem
                perferendis cumque laudantium
                natus alias veniam! Optio repellat, obcaecati temporibus eveniet nisi cum, nostrum ipsam aspernatur,
                eaque
                natus reiciendis!</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Hic tempore sed consectetur nisi quas magnam.
                Ab
                adipisci velit laboriosam eveniet sunt, porro accusantium a delectus nulla beatae error harum eligendi
                rem
                perferendis cumque laudantium
                natus alias veniam! Optio repellat, obcaecati temporibus eveniet nisi cum, nostrum ipsam aspernatur,
                eaque
                natus reiciendis!</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Hic tempore sed consectetur nisi quas magnam.
                Ab
                adipisci velit laboriosam eveniet sunt, porro accusantium a delectus nulla beatae error harum eligendi
                rem
                perferendis cumque laudantium
                natus alias veniam! Optio repellat, obcaecati temporibus eveniet nisi cum, nostrum ipsam aspernatur,
                eaque
                natus reiciendis!</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Hic tempore sed consectetur nisi quas magnam.
                Ab
                adipisci velit laboriosam eveniet sunt, porro accusantium a delectus nulla beatae error harum eligendi
                rem
                perferendis cumque laudantium
                natus alias veniam! Optio repellat, obcaecati temporibus eveniet nisi cum, nostrum ipsam aspernatur,
                eaque
                natus reiciendis!</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Hic tempore sed consectetur nisi quas magnam.
                Ab
                adipisci velit laboriosam eveniet sunt, porro accusantium a delectus nulla beatae error harum eligendi
                rem
                perferendis cumque laudantium
                natus alias veniam! Optio repellat, obcaecati temporibus eveniet nisi cum, nostrum ipsam aspernatur,
                eaque
                natus reiciendis!</p>            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Hic tempore sed consectetur nisi quas magnam.
            Ab
            adipisci velit laboriosam eveniet sunt, porro accusantium a delectus nulla beatae error harum eligendi
            rem
            perferendis cumque laudantium
            natus alias veniam! Optio repellat, obcaecati temporibus eveniet nisi cum, nostrum ipsam aspernatur,
            eaque
            natus reiciendis!</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Hic tempore sed consectetur nisi quas magnam.
                Ab
                adipisci velit laboriosam eveniet sunt, porro accusantium a delectus nulla beatae error harum eligendi
                rem
                perferendis cumque laudantium
                natus alias veniam! Optio repellat, obcaecati temporibus eveniet nisi cum, nostrum ipsam aspernatur,
                eaque
                natus reiciendis!</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Hic tempore sed consectetur nisi quas magnam.
                Ab
                adipisci velit laboriosam eveniet sunt, porro accusantium a delectus nulla beatae error harum eligendi
                rem
                perferendis cumque laudantium
                natus alias veniam! Optio repellat, obcaecati temporibus eveniet nisi cum, nostrum ipsam aspernatur,
                eaque
                natus reiciendis!</p>


        </div>
            <%--        </figure>--%>

        <p>
            <a href="#mainContant">
                <button class="bpRetour">
                    <img src="<c:url value="/static/image/icon/chevrons-up.svg" />" alt="retour en haut de la page">
                </button>
            </a>

        </p>
        <!-- fin bouton de retour  -->

    </main>
    <!-- fin colonneGauche-->

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
