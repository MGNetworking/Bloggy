package entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.TokenHelper;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArticleTest {

    static ArticleBlog articleBlog;

    @BeforeAll
    public static void initArticle() {
        articleBlog = new ArticleBlog();
    }

    @ParameterizedTest
    @ValueSource(longs = {0, -1})
    @DisplayName("test setId Article")
    public void testArticlesetId(Long id) {

        assertThrows(RuntimeException.class,
                () -> articleBlog.setId(id),
                "format id not respect " + id);

    }

    @Test
    @DisplayName("test SetId Article Null")
    public void testSetIdNull() {

        assertThrows(NullPointerException.class,
                () -> articleBlog.setId(null),
                "Error id is null");

    }

    @Test
    @DisplayName("test SetTimestamp Null")
    public void testSetTimestampNull() {

        assertThrows(NullPointerException.class,
                () -> articleBlog.setTimestamp(null),
                "Error timestamps is null");

    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("test setPage Article")
    public void testSetPage(String page) {

        assertThrows(RuntimeException.class,
                () -> articleBlog.setPage(page),
                "Error Article is empty");

    }

    @Test
    @DisplayName("test setPage Article Null")
    public void testSetPageNull() {

        assertThrows(NullPointerException.class,
                () -> articleBlog.setPage(null),
                "Error Article is null");

    }


    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("test setArticletexte")
    public void testSetArticle(String page) {

        assertThrows(RuntimeException.class,
                () -> articleBlog.setArticletexte(page),
                "Error Article is empty");

    }

    @Test
    @DisplayName("test setArticletexte to Article Null")
    public void testSetArticleNull() {

        assertThrows(NullPointerException.class,
                () -> articleBlog.setArticletexte(null),
                "Error article is null");

    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("test SetPathImage image")
    public void testSetPathImage(String page) {

        assertThrows(RuntimeException.class,
                () -> articleBlog.setPathImage(page),
                "Error Path Image is empty");

    }

    @Test
    @DisplayName("test SetPathImage Null")
    public void testSetPathImageNull() {

        assertThrows(NullPointerException.class,
                () -> articleBlog.setPathImage(null),
                "Error Path Image is null");

    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("test SetCommentImage ")
    public void testSetCommentImage(String page) {

        assertThrows(RuntimeException.class,
                () -> articleBlog.setCommentImage(page),
                "Error comment Image is empty");

    }

    @Test
    @DisplayName("test SetCommentImage Null")
    public void testSetCommentImageNull() {

        assertThrows(NullPointerException.class,
                () -> articleBlog.setCommentImage(null),
                "Error comment Image is null");

    }

    @Test
    public void teste(){

        System.out.println("resultat : "+ TokenHelper.generateToken(50));
    }

}
