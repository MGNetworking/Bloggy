package entities;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

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
    @ValueSource(longs = {0, -1})
    @DisplayName("test SetId")
    public void testSetId(Long id) {

        assertThrows(RuntimeException.class,
                () -> user.setId(id), "format id user not respect " + id);

    }

    @Test
    @DisplayName("test SetId Null")
    public void testSetIdNull() {

        assertThrows(NullPointerException.class,
                () -> user.setId(null), "Erreur id est null");

    }


    /**
     * Check that the methode returns the expected exception.
     *
     * @param userName
     */
    @ParameterizedTest
    @ValueSource(strings = {"", "c", "C", "vf", "VF", "max", "MAX", "1", "123", " 0", "max4", "m@xime"})
    @DisplayName("test SetName")
    public void testSetName(String name) {

        assertThrows(RuntimeException.class,
                () -> user.setName(name), "format userName non respecter " + name);

    }

    @Test
    @DisplayName("test SetName Null")
    public void testSetNameNull() {

        assertThrows(NullPointerException.class,
                () -> user.setName(null), "Erreur nom est null");

    }

    /**
     * Check that the methode returns the expected exception.
     *
     * @param userName
     */
    @ParameterizedTest
    @ValueSource(strings = {"", "A", "a", "GT", "gt", "max", "MAX", "1", "123", " 0", "max4", "m@xime"})
    @DisplayName("test SetFirstName")
    public void testSetFirstName(String firstName) {

        assertThrows(RuntimeException.class,
                () -> user.setFirstName(firstName), "format first name not respect "
                        + firstName);

    }

    @Test
    @DisplayName("test SetFirstName Null")
    public void testSetFirstNameNull() {

        assertThrows(NullPointerException.class,
                () -> user.setFirstName(null), "Erreur first name est null");

    }


    /**
     * Check that the methode returns the expected exception.
     *
     * @param userName
     */
    @ParameterizedTest
    @ValueSource(strings = {"", "A", "a", "GT", "gt", "max", "MAX", "1", "123", " 0", "max4", "m@xime"})
    @DisplayName("test SetAvatar")
    public void testSetAvatar(String avatar) {

        assertThrows(RuntimeException.class,
                () -> user.setAvatar(avatar), "format avatar Name not respect "
                        + avatar);

    }

    @Test
    @DisplayName("test SetAvatar Null")
    public void testSetAvatarNull() {

        assertThrows(NullPointerException.class,
                () -> user.setAvatar(null), "Erreur avatar est null");

    }

    /**
     * Check that the methode returns the expected exception.
     *
     * @param password
     */
    @ParameterizedTest
    @ValueSource(strings = {"", " ","m@xi", "ÀÁÂ6"})
    @DisplayName("test setPassword")
    public void testSetPassword(String password) {

        assertThrows(RuntimeException.class,
                () -> user.setPassword(password), "format password not respect "
                        + password);

    }

    @Test
    @DisplayName("test SetPassword Null")
    public void testSetPasswordNull() {

        assertThrows(NullPointerException.class,
                () -> user.setPassword(null), "Erreur password est null");

    }

    /**
     * Check that the methode returns the expected exception.
     *
     * @param userfirstName
     */
    @ParameterizedTest
    @ValueSource(strings = {""," ","user#domain.com", "@yahoo.com"})
    @DisplayName("test SetEmail")
    public void testSetEmail(String email) {

        assertThrows(RuntimeException.class,
                () -> user.setEmail(email), "format email Name not respect "
                        + email);

    }

    @Test
    @DisplayName("test SetEmail Null")
    public void testSetEmailNull() {

        assertThrows(NullPointerException.class,
                () -> user.setEmail(null), "Erreur email est null");

    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("test SetAttemp")
    public void testSetAttemp(int attemp) {

        assertThrows(RuntimeException.class,
                () -> user.setAttemp(attemp), "non-compliant value : "
                        + attemp);

    }

}
