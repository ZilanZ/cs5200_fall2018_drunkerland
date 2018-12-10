package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.dto;

import java.sql.Date;

/**
 * Created by danlinjia on 12/9/18.
 */
public class WineQueryDto {
    private String name;
    private String appellation;
    private String color;
    private String region;
    private String country;
    private String vintage;
    private Date leastDate;
    private Date greatestDate;
    private float leastScore;
    private float greatestScore;

    public WineQueryDto(String name, String appellation, String color, String region, String country, String vintage, Date leastDate, Date greatestDate,  float leastScore, float greatestScore) {
        this.name = name;
        this.appellation = appellation;
        this.color = color;
        this.region = region;
        this.country = country;
        this.vintage = vintage;
        this.leastDate = leastDate;
        this.greatestDate = greatestDate;
        this.leastScore = leastScore;
        this.greatestScore = greatestScore;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setVintage(String vintage) {
        this.vintage = vintage;
    }

    public void setLeastDate(Date leastDate) {
        this.leastDate = leastDate;
    }

    public void setGreatestDate(Date greatestDate) {
        this.greatestDate = greatestDate;
    }


    public void setLeastScore(float leastScore) {
        this.leastScore = leastScore;
    }

    public void setGreatestScore(float greatestScore) {
        this.greatestScore = greatestScore;
    }

    public String getName() {
        return name;
    }


    public String getAppellation() {
        return appellation;
    }

    public String getColor() {
        return color;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getVintage() {
        return vintage;
    }

    public Date getLeastDate() {
        return leastDate;
    }

    public Date getGreatestDate() {
        return greatestDate;
    }


    public float getLeastScore() {
        return leastScore;
    }

    public float getGreatestScore() {
        return greatestScore;
    }
}
