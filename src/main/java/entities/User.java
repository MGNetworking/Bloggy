package entities;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * This class allows to create a user for the connection to the webblog site
 */
@Slf4j
public class User {

    private Long id;
    private String name;
    private String firstName;
    private String avatar;
    private String password;
    private String email;
    private int attemp;

    private String cooki;

    List<RoleUser> listeRole = new ArrayList<>(5);

    public User() {
    }

    public User(String name, String password) {
        this.setName(name);
        this.setPassword(password);
    }

    /**
     * Accessor for id value.
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Mutator for the id. Id is an identifier for user object.
     *
     * @param id Long type ( Object not a primitive )
     * @throws RuntimeException     if the id is empty.
     * @throws NullPointerException if id is null.
     */
    public void setId(Long id) throws RuntimeException, NullPointerException {

        if (id == null) {
            log.debug("The id Value for type long is " + id);
            throw new NullPointerException("The id Value for type long is " + id);
        }

        if (id <= 0) {
            log.debug("The id Value is : " + id);
            throw new RuntimeException("The id Value is : " + id);
        }

        this.id = id;
    }

    /**
     * Accessor for the name value.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Mutator for the name value.
     *
     * @param name String type
     * @throws RuntimeException     if the name is empty and non matching with
     *                              regular expression '<'^[a-z A-Z]{4,}$'>'
     * @throws NullPointerException if the name is null.
     */
    public void setName(String name) throws RuntimeException, NullPointerException {

        if (name == null) {
            log.debug("The String Value is NULL");
            throw new NullPointerException("The String Value is NULL");
        }

        if (name.isEmpty()) {
            log.debug("The String Value is empty");
            throw new RuntimeException("The String Value is empty ");
        }

        // si champs moin de 4 lettre uniquement
        if (!(name.matches("^[a-z A-Z]{4,}$"))) {
            log.debug("The name not matching character");
            throw new RuntimeException("The name not matching");
        }

        this.name = name;
    }

    /**
     * Accessor for the first name value.
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Mutator for the first name value.
     *
     * @param firstName String type
     * @throws RuntimeException     if first name is empty and non matching with
     *                              regular expression '<'^[a-z A-Z]{4,}$'>'
     * @throws NullPointerException if first name is null.
     */
    public void setFirstName(String firstName) throws RuntimeException, NullPointerException {

        if (firstName == null) {
            log.debug("The String Value is " + firstName);
            throw new NullPointerException("The String Value is NULL");
        }

        if (firstName.isEmpty()) {
            log.debug("The String Value is empty");
            throw new RuntimeException("The String Value is empty ");
        }

        // si champs moin de 4 lettre uniquement
        if (!(firstName.matches("^[a-z A-Z]{4,}$"))) {
            log.debug("The first name not matching character " + firstName);
            throw new RuntimeException("The first name not matching character " + firstName);
        }
        this.firstName = firstName;
    }

    /**
     * Accessor for the avatar value.
     *
     * @return
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * Mutator for the avatar value.
     * Test avatar value with 6 character minimum
     *
     * @param avatar String type
     * @throws RuntimeException     if first name is empty and non matching with
     *                              regular expression '<'^[a-z A-Z]{4,}$'>'
     * @throws NullPointerException if first name is null.
     */
    public void setAvatar(String avatar) throws RuntimeException, NullPointerException {

        if (avatar == null) {
            log.debug("The String Value password is " + avatar);
            throw new NullPointerException("The String Value is NULL");
        }

        if (avatar.isEmpty()) {
            log.debug("The String Value password is empty");
            throw new RuntimeException("The String Value is empty ");
        }

        if (!(avatar.matches("^[a-z A-Z]{4,}$"))) {
            log.debug("The password not matching " + avatar);
            throw new RuntimeException("The password not matching " + avatar);
        }
        this.avatar = avatar;
    }

    /**
     * Accessor for password value.
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Mutator for the password value.
     * Test password with 6 character minimum
     *
     * @param password String type
     * @throws RuntimeException     if password is empty and non matching with
     *                              regular expression :
     *                              '<'^[A-Za-z0-9 @ÀÁÂÃÄÅàáâãäåÒÓÔÕÖØòóôõöøÈÉÊËèéêëÇçÌÍÎÏìíîïÙÚÛÜùúûüÿÑñ]{6,}$'>'
     * @throws NullPointerException if password is null.
     */
    public void setPassword(String password) throws RuntimeException, NullPointerException {

        if (password == null) {
            log.debug("The String Value password is NULL");
            throw new NullPointerException("The String Value is NULL");
        }

        if (password.isEmpty()) {
            log.debug("The String Value password is empty");
            throw new RuntimeException("The String Value is empty ");
        }

        if (!(password.matches("^[A-Za-z0-9 @ÀÁÂÃÄÅàáâãäåÒÓÔÕÖØòóôõöøÈÉÊËèéêëÇçÌÍÎÏìíîïÙÚÛÜùúûüÿÑñ]{6,}$"))) {
            log.debug("The password not matching");
            throw new RuntimeException("The password not matching");
        }

        this.password = password;
    }

    /**
     * Accessor for email value.
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Mutator for the email value.
     *
     * @param email String type
     * @throws RuntimeException     if password is empty and non matching with
     *                              regular expression '<'^(.+)@(.+)$'>'
     * @throws NullPointerException if password is null.
     */
    public void setEmail(String email) throws RuntimeException, NullPointerException {

        if (email == null) {
            log.debug("The String Value email is NULL");
            throw new NullPointerException("The String Value is NULL");
        }

        if (email.isEmpty()) {
            log.debug("The String Value email is empty");
            throw new RuntimeException("The String Value is empty ");
        }

        if (!(email.matches("^(.+)@(.+)$"))) {
            log.debug("The email not matching");
            throw new RuntimeException("The email not matching");
        }
        this.email = email;
    }

    /**
     * This Accessor allows to ckeck the attempts to connect to web site
     *
     * @return String type
     */
    public int getAttemp() {
        return attemp;
    }

    /**
     * Allows to add attempts connect.
     *
     * @param attemp int primitive type
     * @throws RuntimeException if attemp less than or equal to zero.
     */
    public void setAttemp(int attemp) throws RuntimeException {

        if (attemp <= 0) {
            log.debug("the attemp value : " + attemp + " is not good");
            throw new RuntimeException("the attemp value : " + attemp + " is not good");
        }

        this.attemp = +attemp;
    }

    /**
     * allows access to the liste of role.
     *
     * @return List<RoleUser> type.
     */
    public List<RoleUser> getListeRole() {
        return listeRole;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", attemp=" + attemp +
                ", cooki='" + cooki + '\'' +
                ", listeRole=" + listeRole +
                '}';
    }
}

