package edu.northeastern.cs5200_fall2018_finalproject_drunkerland;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.ArticleController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Article;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by danlinjia on 12/2/18.
 */
public class ArticleControllerTests extends DemoApplicationTests {

    @Autowired
    ArticleController articleController;

    @Test
    public void testCreateArticle() {
        Article article = new Article("Article 1", null, null, 0);
        articleController.createArticle(article);
    }

    @Test
    public void testFindAllArticles() {
        articleController.findAllArticles();
    }


    @Test
    public void testFindArticleByName() {
        articleController.findArticleByTitle("Article 1");
    }

    @Test
    public void findArticleById(){
        int id = 1;
        articleController.findArticleById(id);
    }


    @Test
    public void testUpdateArticleById() {
        int id = 1;
        Article test = new Article("Article 0");
        articleController.updateArticleById(id, test);
    }

     @Test
    public void testDeleteArticleById() {
        int id = 1;
        articleController.deleteArticleById(id);
    }

    @Test
    public  void testFindReviewerForArticle() {
        int id = 2;
        articleController.findReviewerForArticle(id);
    }
}
