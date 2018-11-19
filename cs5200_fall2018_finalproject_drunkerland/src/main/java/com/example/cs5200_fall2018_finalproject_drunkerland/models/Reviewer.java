package com.example.cs5200_fall2018_finalproject_drunkerland.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reviewer extends User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	public Reviewer(String username, String password, String lastname, String firstname, String level) {
		super(username, password, lastname, firstname);
		this.level = level;
	}
	public Reviewer(String username, String password, String lastname, String firstname, String gender, String phone,
			String email, Date dob, String level) {
		super(username, password, lastname, firstname, gender, phone, email, dob);
		this.level = level;
	}
	private String level;
	@OneToMany(mappedBy="reviewed")
	private List<Article> articles;
	
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public List<Article> getArticals() {
		return articles;
	}
	public void setArticals(List<Article> articles) {
		this.articles = articles;
	}
	public void addArticle(Article article) {
		this.articles.add(article);
		if (article.getReviewed()!=this) {
			article.setReviewed(this);
		}
	}
}
