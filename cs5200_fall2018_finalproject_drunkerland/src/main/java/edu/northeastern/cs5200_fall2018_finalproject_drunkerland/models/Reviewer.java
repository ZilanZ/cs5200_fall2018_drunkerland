package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;

@Entity
public class Reviewer extends User {
	public enum ReviewerLevel{
		BEGINNER,
		INTERMEDIATE,
		SENIOR
	}
	@Enumerated(EnumType.STRING)
	private ReviewerLevel level;
	@OneToMany(mappedBy="reviewer")
	private List<Article> articles = new ArrayList<>();
	@OneToMany(mappedBy="reviewer")
	private List<Mark> marks = new ArrayList<>();
	@OneToMany(mappedBy="reviewer", fetch= FetchType.EAGER)
	private List<Follow> follows;
	public ReviewerLevel getLevel() {
		return level;
	}
	public void setLevel(ReviewerLevel level) {
		this.level = level;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticals(List<Article> articles) {
		this.articles = articles;
	}
	public List<Mark> getMarks() {
		return marks;
	}

	public Reviewer(){};
	public Reviewer(String username, String password, String lastname, String firstname, ReviewerLevel level) {
		super(username, password, lastname, firstname);
		this.level = level;
	}
	public Reviewer(String username, String password, String lastname, String firstname, String gender, String phone,
					String email, Date dob, ReviewerLevel level) {
		super(username, password, lastname, firstname, gender, phone, email, dob);
		this.level = level;
	}

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

	public void addMark(Mark mark){
		this.marks.add(mark);
		if(mark.getReviewer()!=this) {
			mark.setReviewer(this);
		}
	}

	public void removeMark(Mark mark) {
		this.marks.remove(mark);
	}

	public void setReviewer(Reviewer newReviewer) {
		this.set(newReviewer);
		this.level = newReviewer.level;
		this.articles = newReviewer.articles;
		this.marks = newReviewer.marks;
	}
}
