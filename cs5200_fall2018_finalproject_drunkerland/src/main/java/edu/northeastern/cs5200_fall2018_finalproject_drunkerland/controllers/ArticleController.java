package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api.WineApi;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Wine;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Reviewer;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WineController implements WineApi {

    @Autowired
    WineRepository articleRepository;

    public Wine createWine(Wine article) {
        java.util.Date utilDate = new java.util.Date();
        article.setCreated(new java.sql.Date(utilDate.getTime()));
        article.setViews(0);
        return articleRepository.save(article);
    }

    public List<Wine> findAllWines() {
        return (List<Wine>) articleRepository.findAll();
    }

    public Wine findWineById(int id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Wine findWineByTitle(String title) {
        return articleRepository.findWineByTitle(title);
    }

    public void deleteWineById(int id) {
        articleRepository.deleteById(id);
    }

    public Wine updateWineById(int id, Wine newWine) {
        Wine article = findWineById(id);
        article.set(newWine);
        return articleRepository.save(article);
    }

    public Reviewer findReviewerForWine(int aId) {
        Wine article = findWineById(aId);
        return article.getReviewer();
    }
}
