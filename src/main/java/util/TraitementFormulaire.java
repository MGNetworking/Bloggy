package util;

import dao.DaoUser;
import dao.DaoUserRole;
import entities.RoleUser;
import entities.User;

import static util.NameRole.USER_ARTICLE;
import static util.NameRole.ADMIN;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class TraitementFormulaire {

    public static User formulaireInscription(HttpServletRequest request) throws RuntimeException {
        User user = new User();

        try {

            user.setName(request.getParameter("name"));
            user.setFirstName(request.getParameter("firstName"));
            user.setAvatar(request.getParameter("avatar"));
            user.setPassword(request.getParameter("password"));
            user.setEmail(request.getParameter("email"));

        } catch (RuntimeException re) {

            String message = "Erreur sur : " + re.getMessage();
            log.error(message);

            throw new RuntimeException(message);
        }


        return user;
    }

    public static void formulaireGestionDroit(HttpServletRequest request, List<User> listUser, DaoUserRole daoUserRole)
            throws SQLException, Exception {

        try {
            RoleUser roleAdmin = new RoleUser(ADMIN.getName());
            RoleUser roleUSER = new RoleUser(USER_ARTICLE.getName());


            for (int i = 0; i < listUser.size(); i++) {

                log.info("---------------");
                log.info("User : " + listUser.get(i).getName());
                log.info("ID : " + listUser.get(i).getId());
                log.info("ADMIN : " + request.getParameter(listUser.get(i).getId() + ADMIN.getName()));
                log.info("USER_ARTICLE : " + request.getParameter(listUser.get(i).getId() + USER_ARTICLE.getName()));
                log.info("liste : " + listUser.get(i).getListeRole());


                // gestion du droit ADMIN
                // Si la valeur de l'input correspondant au User + ADMIN possede on ( ADMIN est checked )
                if (request.getParameter(listUser.get(i).getId() + ADMIN.getName()) != null) {

                    log.info("ADMIN : " + listUser.get(i));

                    //si le user ne possede pas le droit ADMIN, on lui ajoute
                    if (!listUser.get(i).getListeRole().containsKey(roleAdmin.getRole())) {
                        daoUserRole.create(listUser.get(i), roleAdmin);
                        log.info("create ADMIN : " + listUser.get(i));
                    }

                } else {

                    //si le user possede le droit ADMIN, on lui enlève
                    if (listUser.get(i).getListeRole().containsKey(roleAdmin.getRole())) {
                        daoUserRole.delete(listUser.get(i), roleAdmin);
                        log.info("delete ADMIN : " + listUser.get(i));
                    }

                }


                // Gestion du droit USER_ARTICLE
                // Si la valeur de l'input correspondant au User + USER_ARTICLE possede on ( ADMIN est checked )
                if (request.getParameter(listUser.get(i).getId() + USER_ARTICLE.getName()) != null) {

                    //si le user ne possede pas le droit USER_ARTICLE, on lui ajoute
                    if (!listUser.get(i).getListeRole().containsKey(roleUSER.getRole())) {
                        daoUserRole.create(listUser.get(i), roleUSER);
                        log.info("create USER_ARTICULE : " + listUser.get(i));
                    }

                } else {

                    //si le user possede le droit ADMIN, on lui enlève
                    if (listUser.get(i).getListeRole().containsKey(roleUSER.getRole())) {
                        daoUserRole.delete(listUser.get(i), roleUSER);
                        log.info("delete USER_ARTICULE : " + listUser.get(i));
                    }

                }

            }


        } catch (SQLException sqle) {

            String message = "Error query : " +
                    sqle.getMessage() + " | " +
                    sqle.getSQLState();

            log.error(message);
            throw new SQLException(message);

        } catch (Exception e) {

            String message = "Error to excution softwar : " +
                    e.getMessage() + " | " +
                    e.getStackTrace();
            log.error(message);

            throw new Exception(message);

        }


    }
}
