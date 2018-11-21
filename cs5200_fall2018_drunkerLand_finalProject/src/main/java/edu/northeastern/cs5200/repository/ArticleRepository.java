package edu.northeastern.cs5200.repository;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Article;



public interface ArticleRepository  extends CrudRepository<Article, Integer>{

}
