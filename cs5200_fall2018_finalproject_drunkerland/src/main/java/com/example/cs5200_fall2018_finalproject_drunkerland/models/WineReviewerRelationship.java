package com.example.cs5200_fall2018_finalproject_drunkerland.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class WineReviewerRelationship {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Article articleRelationship;
	@OneToMany(mappedBy="sponserRelationship")
	private List<Sponsership> sponsers;
	@ManyToOne
	private Wine wineRelationship;
	public Article getArticleRelation() {
		return articleRelationship;
	}

	public Article getArticleRelationship() {
		return articleRelationship;
	}
	public List<Sponsership> getSponsers() {
		return sponsers;
	}
	public void setSponsers(List<Sponsership> sponsers) {
		this.sponsers = sponsers;
	}
	public Wine getWineRelationship() {
		return wineRelationship;
	}
	public void setWineRelationship(Wine wineRelationship) {
		this.wineRelationship = wineRelationship;
	}
	public void setArticleRelation(Article article) {
		this.articleRelationship = article;
		if(!article.getWineReviewerRelationships().contains(this)) {
			article.getWineReviewerRelationships().add(this);
		}
	}
	public void addSponserRelation(Sponsership sponser) {
		this.getSponsers().add(sponser) ;
		if(sponser.getSponserRelationship()!=this) {
			sponser.setSponserRelationship(this);
		}
	}
	public void setWine(Wine wine){
		this.setWineRelationship(wine);
		if(!wine.getWineReviewerRelationship().contains(this)) {
			wine.getWineReviewerRelationship().add(this);
		}
	}
}
