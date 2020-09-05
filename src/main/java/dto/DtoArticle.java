package dto;

import java.sql.Timestamp;

public class DtoArticle {

    private String name;
    private String firstname;
    private String avatar;
    private Long id_user;
    private Long id_article;
    private Timestamp date;
    private String page;
    private String title;
    private String articletexte;
    private String pathImage;
    private String commentImage;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Long getId_article() {
        return id_article;
    }

    public void setId_article(Long id_article) {
        this.id_article = id_article;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticletexte() {
        return articletexte;
    }

    public void setArticletexte(String articletexte) {
        this.articletexte = articletexte;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public String getCommentImage() {
        return commentImage;
    }

    public void setCommentImage(String commentImage) {
        this.commentImage = commentImage;
    }

    @Override
    public String toString() {
        return "DtoArticle{" +
                "name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", id_user=" + id_user +
                ", id_article=" + id_article +
                ", date=" + date +
                ", page='" + page + '\'' +
                ", title='" + title + '\'' +
                ", articletexte='" + articletexte + '\'' +
                ", pathImage='" + pathImage + '\'' +
                ", commentImage='" + commentImage + '\'' +
                '}';
    }
}
