package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@OneToMany(mappedBy="reviewed", fetch=FetchType.EAGER)
	private Set<Mark> marks;
	
	public void addMark(Mark mark)
	{
		this.marks.add(mark);
		if(mark.getReviewed()!=this)
			mark.setReviewed(this);
		
	}
	
	public void removeMark(Mark mark)
	{
		this.marks.remove(mark);
	}
	
	@OneToMany(mappedBy="reviewer", fetch=FetchType.EAGER)
	private Set<Follow> follows;
	
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public Set<Mark> getMarks() {
		return marks;
	}
	public void setMarks(Set<Mark> marks) {
		this.marks = marks;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	

	public Set<Follow> getFollows() {
		return follows;
	}
	public void setFollows(Set<Follow> follows) {
		this.follows = follows;
	}
	
	public void addArticle(Article article) {
		this.articles.add(article);
		if (article.getReviewed()!=this) {
			article.setReviewed(this);
		}
	}
	
	public void removeArticle(Article article)
	{
		this.articles.remove(article);
	}
}
