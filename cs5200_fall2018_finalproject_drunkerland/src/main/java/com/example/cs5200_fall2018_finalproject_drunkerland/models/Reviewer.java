package com.example.cs5200_fall2018_finalproject_drunkerland.models;

import java.sql.Date;
import java.util.List;


import javax.persistence.*;

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
	@OneToMany(mappedBy="reviewer")
	private List<Article> articles;
	@OneToMany
	private List<Mark> marks;
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
	public List<Mark> getMarks() {
		return marks;
	}

	@OneToMany(mappedBy="reviewer", fetch= FetchType.EAGER)
	private List<Follow> follows;

	public void addFollow(Follow follow)
	{
		this.follows.add(follow);
		if(follow.getReviewer()!=this)
			follow.setReviewer(this);
	}

	public void removeFollow(Follow follow)
	{
		this.follows.remove(follow);
	}

	public List<Follow> getFollows() {
		return follows;
	}
	public void setllows(List<Follow> follows) {
		this.follows = follows;
	}
	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}
	public void addArticle(Article article) {
		this.articles.add(article);
		if (article.getReviewer()!=this) {
			article.setReviewer(this);
		}
	}
	public void removeArticle(Article article) {
		this.articles.remove(article);
	}

}
