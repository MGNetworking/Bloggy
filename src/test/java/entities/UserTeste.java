package entities;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserTeste {

    static User user;

    /**
     * Create a new instance for each unit test
     */
    @BeforeAll
    public static void init() {
        user = new User();
    }

    /**
     * Check that the methode returns the expected exception.
     *
     * @param userName
     */
    @ParameterizedTest
    @ValueSource(strings = {"", "c", "C", "vf", "VF", "max","MAX","1","123"," 0","max4","m@xime"})
    @DisplayName("Listes de testes ")
    public void exceptionUserNom(String userName) {

        assertThrows(RuntimeException.class,
                () -> user.setName(userName), "format userName non respecter " + userName);

        assertThrows(NullPointerException.class,
                () -> user.setName(null), "Erreur nom est null");

    }

    /**
     * Check that the methode returns the expected exception.
     *
     * @param userName
     */
    @ParameterizedTest
    @ValueSource(strings = {"", "A","a", "GT","gt", "max","MAX","1","123"," 0","max4","m@xime"})
    @DisplayName("Listes de testes ")
    public void exceptionUserFirstName(String userfirstName) {

        assertThrows(RuntimeException.class,
                () -> user.setName(userfirstName), "format user First Name not respect " + userfirstName);

        assertThrows(NullPointerException.class,
                () -> user.setName(null), "Erreur nom est null");

    }
}
