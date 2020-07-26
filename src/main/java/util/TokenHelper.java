package util;

import java.util.Random;

public final class TokenHelper {
    public static final String CSRF_TOKEN_VALUE_NAME = "_csrfToken";
    public static final int CSRF_TOKEN_LENGTH = 100;

    private TokenHelper() {
        throw new UnsupportedOperationException(
                "This class is not meant to be instanciated");
    }

    /**
     * allows to generate a token on a size of request
     *
     * @param length
     * @return
     */
    public static final String generateToken(int length) {
        Random rng = new Random();

        String charPool = "0123456789"
                + "abcdefghijklmnopqrstuvwxyz"
                + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            // renvoi aleatoirment un chiffre sur la taille de charPool
            int randIndex = rng.nextInt(charPool.length());

            // ajoute le caractére qui fait refférence au chiffre trouver aléatoirment
            builder.append(charPool.charAt(randIndex));
        }

        return builder.toString();
    }

    /**
     * Allows to generate a token on a size of 100 characters
     *
     * @return
     */
    public static final String generateCsrfToken() {

        return generateToken(CSRF_TOKEN_LENGTH);
    }
}
