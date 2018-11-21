package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Article {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	public Article(String title, Date created, Date updated, int views) {
		super();
		this.title = title;
		this.created = created;
		this.updated = updated;
		this.views = views;
	}
	private String title;
	private Date created;
	private Date updated;
	private int views;
	
	@ManyToOne
	private Reviewer reviewed;
	
	@OneToMany(mappedBy="articleRelation")
	private List<WineReviewerRelationship> wineReviewerRelationships;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public Reviewer getReviewed() {
		return reviewed;
	}
	public void setReviewed(Reviewer reviewed) {
		this.reviewed = reviewed;
	}
	public List<WineReviewerRelationship> getWineReviewerRelationships() {
		return wineReviewerRelationships;
	}
	public void setWineReviewerRelationships(List<WineReviewerRelationship> wineReviewerRelationships) {
		this.wineReviewerRelationships = wineReviewerRelationships;
	}
	public void setReviewer(Reviewer reviewer) {
		this.reviewed = reviewer;
		if(!reviewer.getArticles().contains(this)) {
			reviewer.getArticles().add(this);
		}
	}
	public void setRelationships(WineReviewerRelationship relationship) {
		this.wineReviewerRelationships.add(relationship);
		if(relationship.getArticleRelation()!=this) {
			relationship.setArticleRelation(this);
		}
	}
}
