package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Article {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private Date created;
	private Date updated;
//	private int views;

	@ManyToOne
	private Reviewer reviewer;

	@OneToMany(mappedBy="articleRelationship")
	private List<WineReviewerRelationship> wineReviewerRelationships;

	public Article() {

	}

	public Article(String title) {
		this.title = title;
		this.created = null;
		this.updated = null;
//		this.views = 0;
	}

	public Article(String title, Date created, Date updated, int views) {
		this.title = title;
		this.created = created;
		this.updated = updated;
//		this.views = views;
	}

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

//	public int getViews() {
//		return views;
//	}
//
//	public void setViews(int views) {
//		this.views = views;
//	}

	public Reviewer getReviewer() {
		return reviewer;
	}

	public void setReviewer(Reviewer reviewer) {
		this.reviewer = reviewer;
		if(!reviewer.getArticles().contains(this)) {
			reviewer.getArticles().add(this);
		}
	}

	public List<WineReviewerRelationship> getWineReviewerRelationships() {
		return wineReviewerRelationships;
	}

	public void setWineReviewerRelationships(List<WineReviewerRelationship> wineReviewerRelationships) {
		this.wineReviewerRelationships = wineReviewerRelationships;
	}

	public void addRelationship(WineReviewerRelationship relationship) {
		this.wineReviewerRelationships.add(relationship);
		if(relationship.getArticleRelation()!=this) {
			relationship.setArticleRelation(this);
		}
	}

	public  void  removeRelationship(WineReviewerRelationship relationship){
		this.wineReviewerRelationships.remove(relationship);
	}

	public void set(Article newArticle) {
		this.title = newArticle.title;
		// this.created = created; created will be fixed once it's created.
		java.util.Date utilDate = new java.util.Date();
		this.updated = new java.sql.Date(utilDate.getTime());
		// the number of views keep same;
	}
}
