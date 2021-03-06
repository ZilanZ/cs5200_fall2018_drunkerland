package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Wine {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonProperty(value = "id")
	private int id;
	private String name;
	private String nameUrl;
	private String appellation;
	private String color;
	private String region;
	private String country;
	private String vintage;
	private Date date;
	private Boolean isPrimeurs;
	private float score;

	@ManyToOne
	@JsonIgnore
	private Supplier supplier;

	@OneToMany(mappedBy="wineRelationship")
	private List<WineReviewerRelationship> wineReviewerRelationships;

	@OneToMany(mappedBy="wine")
	private List<Stock> stocks;

	@OneToMany(mappedBy="wine")
	private List<Mark> marks;

	public Wine() {
	}

	public Wine(String name, String nameUrl, String appellation, String color, String region, String country, String vintage, Date date, Boolean isPrimeurs, float score) {
		this.name = name;
		this.nameUrl = nameUrl;
		this.appellation = appellation;
		this.color = color;
		this.region = region;
		this.country = country;
		this.vintage = vintage;
		this.date = date;
		this.isPrimeurs = isPrimeurs;
		this.score = score;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getIsPrimeurs() {
		return isPrimeurs;
	}

	public void setIsPrimeurs(Boolean isPrimeurs) {
		this.isPrimeurs = isPrimeurs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameUrl() {
		return nameUrl;
	}

	public void setNameUrl(String nameUrl) {
		this.nameUrl = nameUrl;
	}

	public String getAppellation() {
		return appellation;
	}

	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getVintage() {
		return vintage;
	}

	public void setVintage(String vintage) {
		this.vintage = vintage;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getPrimeurs() {
		return isPrimeurs;
	}

	public void setPrimeurs(Boolean primeurs) {
		isPrimeurs = primeurs;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public Supplier getSupplier() {

		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
		if(!supplier.getWines().contains(this)) {
			supplier.getWines().add(this);
		}
	}

	public List<WineReviewerRelationship> getWineReviewerRelationships() {
		return wineReviewerRelationships;
	}

	public void setWineReviewerRelationships(List<WineReviewerRelationship> wineReviewerRelationships) {
		this.wineReviewerRelationships = wineReviewerRelationships;
	}

	public void addWineReviewerRelationship(WineReviewerRelationship relationship) {
		this.getWineReviewerRelationships().add(relationship);
		if(relationship.getWineRelationship()!=this) {
			relationship.setWineRelationship(this);
		}
	}

	public  void removeWineReviewerRelationship(WineReviewerRelationship relationship){
		this.wineReviewerRelationships.remove(relationship);
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public void addStock(Stock stock){
		this.stocks.add(stock);
		if (stock.getWine()!=this){
			stock.setWine(this);
		}
	}

	public void removeStock(Stock stock) {

		this.stocks.remove(stock);
	}

	public List<Mark> getMarks() {
		return marks;
	}

	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}

	public void addMark(Mark mark){
		this.marks.add(mark);
		if (mark.getWine()!=this){
			mark.setWine(this);
		}
	}

	public void removeMark(Mark mark) {

		this.marks.remove(mark);
	}

	public void set(Wine newWine) {
		this.name = newWine.name;
		this.appellation = newWine.appellation;
		this.color = newWine.color;
		this.region = newWine.region;
		this.country = newWine.country;
		this.vintage = newWine.vintage;
		this.date = newWine.date;
		this.isPrimeurs = newWine.isPrimeurs;
		this.score = newWine.score;
		this.stocks = newWine.stocks;
		this.marks = newWine.marks;
		this.wineReviewerRelationships = newWine.wineReviewerRelationships;
	}
}

