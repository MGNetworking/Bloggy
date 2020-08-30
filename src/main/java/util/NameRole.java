package util;

public enum NameRole {

    ADMIN("ADMIN"),
    USER_ARTICLE("USER_ARTICLE");

    private String name;

    NameRole(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
