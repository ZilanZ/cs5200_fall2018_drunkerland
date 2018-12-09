package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models;

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
	@OneToMany(mappedBy="sponsorRelationship")
	private List<Sponsorship> sponsorships;
	@ManyToOne
	private Wine wineRelationship;
	public Article getArticleRelation() {
		return articleRelationship;
	}

	public Article getArticleRelationship() {
		return articleRelationship;
	}

	public List<Sponsorship> getSponsorships() {
		return sponsorships;
	}
	public void setSponsorships(List<Sponsorship> sponsorships) {
		this.sponsorships = sponsorships;
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
	public void addSponsorRelation(Sponsorship sponsorship) {
		this.getSponsorships().add(sponsorship) ;
		if(sponsorship.getSponsorRelationship()!=this) {
			sponsorship.setSponsorRelationship(this);
		}
	}
	public void removeSponsorRelation(Sponsorship sponsorship){
		this.sponsorships.remove(sponsorship);
	}
	public void setWine(Wine wine){
		this.setWineRelationship(wine);
		if(!wine.getWineReviewerRelationships().contains(this)) {
			wine.getWineReviewerRelationships().add(this);
		}
	}
}
