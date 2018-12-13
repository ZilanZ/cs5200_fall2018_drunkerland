package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api.ArticleApi;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Article;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Reviewer;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    @Autowired
    ArticleRepository articleRepository;

    public Article createArticle(Article article) {
        java.util.Date utilDate = new java.util.Date();
        article.setCreated(new java.sql.Date(utilDate.getTime()));
        return articleRepository.save(article);
    }

    public List<Article> findAllArticles() {
        return (List<Article>) articleRepository.findAll();
    }

    public Article findArticleById(int id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article findArticleByTitle(String title) {
        return articleRepository.findArticleByTitle(title);
    }

    public void deleteArticleById(int id) {
        articleRepository.deleteById(id);
    }

    public Article updateArticleById(int id, Article newArticle) {
        Article article = findArticleById(id);
        article.set(newArticle);
        return articleRepository.save(article);
    }

    public Reviewer findReviewerForArticle(int aId) {
        Article article = findArticleById(aId);
        return article.getReviewer();
    }
}
