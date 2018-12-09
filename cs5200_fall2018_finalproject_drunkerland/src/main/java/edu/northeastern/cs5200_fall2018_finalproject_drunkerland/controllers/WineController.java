package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api.WineApi;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Article;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Supplier;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Wine;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

/**
 * Created by danlinjia on 12/6/18.
 */
@RestController
public class WineController implements WineApi {

    @Autowired
    WineRepository wineRepository;

    public void save(List<Wine> wines) {
        for (Wine wine: wines)
            wineRepository.save(wine);
    }

    public Wine createWine(@RequestBody Wine wine){
        return wineRepository.save(wine);
    }

    public List<Wine> findAllWines() {
        List<Wine> result = (List<Wine>) wineRepository.findAll();
        return result;
    }

    public  Wine findWineById(int id) {
        return wineRepository.findById(id).orElse(null);
    }

    public Wine findWineByName(String name) {
        return wineRepository.findWineByName(name);
    }

    public List<Wine> findWineByVintage(String vintage) {
        return wineRepository.findWineByVintage(vintage);
    }

    public List<Wine> findWineByColor( String color) {
        return wineRepository.findWineByColor(color);
    }

    public List<Wine> findWineByAppellation(String appellation){
        return wineRepository.findWineByAppellation(appellation);
    }

    public List<Wine> findWineByCountry( String country) {
        return wineRepository.findWineByCountry(country);
    }

    public List<Wine> findWineBetweenScore( String scoreScope){
        String[] scores = scoreScope.split(" ");
        return wineRepository.findWineBetweenScores(Float.parseFloat(scores[0]), Float.parseFloat(scores[1]));
    }

    public List<Wine> findWineByDate( Date date) {
        return wineRepository.findWineByDate(date);
    }

    public void deleteWineById(int id) {
        wineRepository.deleteById(id);
    }

    public Wine updateWineById(int id, Wine newWine) {
        Wine wine = findWineById(id);
        wine.set(newWine);
        return wineRepository.save(wine);
    }

    public Supplier findSupplierForWine(int wId) {
        Wine wine = findWineById(wId);
        return  wine.getSupplier();
    }
}
