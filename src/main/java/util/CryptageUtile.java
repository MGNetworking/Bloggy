package util;

import lombok.extern.log4j.Log4j2;
import org.mindrot.jbcrypt.BCrypt;

@Log4j2
public class CryptageUtile {

    /**
     * Allows to encrypt a password on 10 character
     * @param password String user password
     * @return String password
     */
    public static String hash(String password){

        return BCrypt.hashpw(password , BCrypt.gensalt());
    }

    /**
     * Allows you to verify a password with user input
     * @param password
     * @param hash
     * @return
     */
    public static boolean verifyHash(String password ,
                                     String hash){

        return BCrypt.checkpw(password , hash);
    }

}
