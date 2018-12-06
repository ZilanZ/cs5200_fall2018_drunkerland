package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api;


import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Article;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Reviewer;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @PathVariable passing by URL eg. /{id}
 * @RequestParam passing by URL eg. ?key1=value1&key2=value2
 * @RequestBody passing by body [type: (default) json]
 *
 * we use @RestController here, @ResponseBody is not required. default: Json
 */
@RequestMapping("rest/api/articles")
public interface ArticleApi {

    /**
     * create
     * @param article
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    Article createArticle(@RequestBody Article article);

    /**
     * retrieve all articles
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    List<Article> findAllArticles();

    /**
     * retrieve article by id
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Article findArticleById(@PathVariable int id);

    /**
     * retrieve article by title
     * @param title
     * @return
     */
    @RequestMapping(value = "/title", method = RequestMethod.GET)
    Article findArticleByTitle(@RequestParam("title") String title);


    /**
     * delete article by id
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteArticleById(@PathVariable("id") int id);

    /**
     * update article by id
     * @param id
     * @param newArticle
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Article updateArticleById(@PathVariable("id") int id, @RequestBody Article newArticle);

    /**
     * Find the reviewer who writes the article
     * @param aId
     * @return
     */
    @RequestMapping(value = "/{aId}/reviewer", method = RequestMethod.GET)
    Reviewer findReviewerForArticle(@PathVariable("aId") int aId);
}
