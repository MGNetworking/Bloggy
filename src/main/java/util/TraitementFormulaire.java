package util;

import entities.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class TraitementFormulaire {

    public static User FormulaireInscription(HttpServletRequest request)throws RuntimeException {
        User user = new User();

        try{

            user.setName(request.getParameter("name"));
            user.setFirstName(request.getParameter("firstName"));
            user.setAvatar(request.getParameter("avatar"));
            user.setPassword(request.getParameter("password"));
            user.setEmail(request.getParameter("email"));

        }catch (RuntimeException re){

            String message = "Erreur sur : " + re.getMessage();
            log.error(message);

            throw new RuntimeException(message);
        }


        return user ;
    }
}
