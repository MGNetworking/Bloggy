package entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ArticleBlog {

    private Long id;
    private Timestamp timestamp;
    private String page;
    private String titre;
    private String article;
    private String pathImage;
    private String commentImage;

    public ArticleBlog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
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
        return "ArticleBlog{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", page='" + page + '\'' +
                ", titre='" + titre + '\'' +
                ", article='" + article + '\'' +
                ", pathImage='" + pathImage + '\'' +
                ", commentImage='" + commentImage + '\'' +
                '}';
    }
}
