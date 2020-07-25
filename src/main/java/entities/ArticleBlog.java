package entities;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;

@Slf4j
public class ArticleBlog {

    private Long id;
    private Timestamp timestamp;
    private String page;
    private String title;
    private String article;
    private String pathImage;
    private String commentImage;

    public ArticleBlog() {
    }

    public Long getId() {
        return id;
    }

    /**
     * Mutator for the id. Id is an identifier for articleBlog object.
     *
     * @param id Long type ( Object not a primitive )
     * @throws RuntimeException     if id is empty.
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * Mutator for the creation date of the article.
     *
     * @param timestamp type object to timestamp
     * @throws NullPointerException if timestamp is null.
     */
    public void setTimestamp(Timestamp timestamp) throws NullPointerException {

        if (timestamp == null) {
            log.debug("The Value of timestamp Article is " + timestamp);
            throw new NullPointerException("The timestamp Article Value is " + timestamp);
        }
        this.timestamp = timestamp;
    }

    public String getPage() {
        return page;
    }

    /**
     * Mutator for page article .
     *
     * @param page String type
     * @throws RuntimeException     if page is empty.
     * @throws NullPointerException if timestamp is null.
     */
    public void setPage(String page) throws RuntimeException, NullPointerException {

        if (page == null) {
            log.debug("The Value of page Article is " + page);
            throw new NullPointerException("The Value of page Article is " + page);
        }

        if (page.trim().isEmpty()) {
            log.debug("The Value of page Article is Empty ");
            throw new RuntimeException("The Value of page Article is Empty ");
        }

        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    /**
     * Mutator for title article .
     *
     * @param title
     * @throws RuntimeException     if title is empty.
     * @throws NullPointerException if title is null.
     */
    public void setTitle(String title) throws RuntimeException, NullPointerException {

        if (title == null) {
            log.debug("The Value of title Article is " + title);
            throw new NullPointerException("The title Article Value is " + title);
        }

        if (title.trim().isEmpty()) {
            log.debug("The Value of title Article is Empty ");
            throw new RuntimeException("The Value of title Article is Empty ");
        }

        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) throws RuntimeException, NullPointerException {

        if (article == null) {
            log.debug("The Value of Article is " + article);
            throw new NullPointerException("The title Article Value is " + article);
        }

        if (article.trim().isEmpty()) {
            log.debug("The Value of Article is Empty ");
            throw new RuntimeException("The Value of Article is Empty ");
        }
        this.article = article;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) throws RuntimeException, NullPointerException {

        if (pathImage == null) {
            log.debug("The Value of path Image Article is " + pathImage);
            throw new NullPointerException("The Value of path Image Article is " + pathImage);
        }

        if (pathImage.trim().isEmpty()) {
            log.debug("The Value of path Image Article is Empty ");
            throw new RuntimeException("The Value of path Image Article is Empty ");
        }


        this.pathImage = pathImage;
    }

    public String getCommentImage() {
        return commentImage;
    }

    public void setCommentImage(String commentImage) throws RuntimeException, NullPointerException {

        if (commentImage == null) {
            log.debug("The Value of comment Image Article is " + commentImage);
            throw new NullPointerException("The Value of comment Image Article is " + commentImage);
        }

        if (commentImage.trim().isEmpty()) {
            log.debug("The Value of comment Image Article is Empty ");
            throw new RuntimeException("The Value of comment Image Article is Empty ");
        }

        this.commentImage = commentImage;
    }

    @Override
    public String toString() {
        return "ArticleBlog{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", page='" + page + '\'' +
                ", title='" + title + '\'' +
                ", article='" + article + '\'' +
                ", pathImage='" + pathImage + '\'' +
                ", commentImage='" + commentImage + '\'' +
                '}';
    }
}
