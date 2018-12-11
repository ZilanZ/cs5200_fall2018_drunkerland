package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api.WineApi;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Supplier;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Wine;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.dto.WineQueryDto;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.*;

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

    public List<Wine> findWineByName(String name) {
        name = '%' + name + '%';
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

    public List<Wine> findWineByRegion (String region){
        return  wineRepository.findWineByRegion(region);
    }

    public List<Wine> findWineByCountry( String country) {
        return wineRepository.findWineByCountry(country);
    }

    public List<Wine> findWineBetweenScore( String scoreScope){
        String[] scores = scoreScope.split(" ");
        return wineRepository.findWineBetweenScores(Float.parseFloat(scores[0]), Float.parseFloat(scores[1]));
    }

    public List<Wine> findWineByDate(Date startDate, Date endDate) {
        return wineRepository.findWineByDate(startDate, endDate);
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

    public List<Wine> multipleSearch( WineQueryDto wineQueryDto){
        List<String> searchFields = new ArrayList<>();
        List<Wine> wines = new ArrayList<>();
        if(wineQueryDto.getName()!=null){
            List<Wine> wineByName = this.findWineByName(wineQueryDto.getName());
            for (Wine wine : wineByName) {
                wines.add(wine);
            }
            return wines;
        }
        if (wineQueryDto.getAppellation()!=null)
            searchFields.add("appellation");
        if (wineQueryDto.getColor()!=null);
            searchFields.add("color");
        if (wineQueryDto.getRegion()!=null)
            searchFields.add("region");
        if (wineQueryDto.getCountry()!=null)
            searchFields.add("country");
        if (wineQueryDto.getVintage()!=null)
            searchFields.add("vintage");
        if (wineQueryDto.getLeastDate()!=null)
            searchFields.add("date");
        if (wineQueryDto.getLeastScore()!=0)
            searchFields.add("score");
        wines = this.findAllWines();
        for (String field: searchFields) {
            switch (field){
                case "appellation":
                    wines.retainAll(this.findWineByAppellation(wineQueryDto.getAppellation()));
                    break;
                case "color":
                    wines.retainAll(this.findWineByColor(wineQueryDto.getColor()));
                    break;
                case "region":
                    wines.retainAll(this.findWineByRegion(wineQueryDto.getRegion()));
                    break;
                case "country":
                    wines.retainAll(this.findWineByCountry(wineQueryDto.getCountry()));
                    break;
                case "vintage":
                    wines.retainAll(this.findWineByVintage(wineQueryDto.getVintage()));
                    break;
                case "date":
                    wines.retainAll(this.findWineByDate(wineQueryDto.getLeastDate(), wineQueryDto.getGreatestDate()));
                    break;
                case "score":
                    wines.retainAll(wineRepository.findWineBetweenScores(wineQueryDto.getLeastScore(), wineQueryDto.getGreatestScore()));
                    break;
            }
        }
        if (searchFields.size()==0)
            return null;
        return  wines;
    }
}
