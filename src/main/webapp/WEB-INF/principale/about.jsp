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

<div id="mainbody">

    <main id="mainContant">
        <h1>Savoir sur ce blog</h1>
        <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Neque vero nihil vitae autem esse beatae
            laudantium. Similique repudiandae fugit, ipsa labore nisi, non impedit incidunt quae repellat ex eveniet
            adipisci?</p>

        <h2>Lorem.</h2>
        <p>Rem incidunt pariatur, ducimus doloribus iure aliquid fugit provident temporibus consequatur sed
            voluptatibus, praesentium, nesciunt delectus distinctio? Quia assumenda saepe eum alias ratione nihil, culpa
            earum adipisci cupiditate cumque
            quas!
        </p>
        <h2>Lorem, ipsum.</h2>
        <p>Molestias id fugit ea minus, magnam delectus ducimus quod reiciendis ipsa dolor explicabo excepturi
            perspiciatis. Eveniet facilis maiores minima? Omnis in exercitationem ullam inventore repellendus ducimus
            pariatur et architecto animi?</p>

        <h2>Lorem, ipsum dolor.</h2>
        <p>Similique deleniti doloremque aliquid totam accusantium dolorum qui iste sequi ipsum, placeat aliquam modi
            aperiam doloribus, vel expedita consectetur animi molestiae. Ex officia sunt sapiente iste ut at nihil
            delectus!</p>

        <h2>Lorem ipsum dolor sit.</h2>
        <p>Natus, asperiores modi! Nisi, adipisci nesciunt! Nisi deleniti debitis quas adipisci error perferendis
            suscipit, sequi totam quo nostrum quam eos excepturi. Exercitationem perferendis in nesciunt est commodi
            repellat porro tempora.</p>


        <p>

            <a href="#mainContant">
                <button class="bpRetour">
                    <img src="<c:url value="/static/image/icon/chevrons-up.svg"/>" alt="retour en haut de la page">
                </button>
            </a>

        </p>
        <!-- fin bouton de retour  -->

    </main>
    <!-- fin pageContent-->


</div>
<!-- fin mainbody -->

</body>

<footer id="mainFooter">
    <p>&copy;Copyright Ghalem Maxime - 2020</p>
</footer>
<!-- fin mainFooter -->
</html>
