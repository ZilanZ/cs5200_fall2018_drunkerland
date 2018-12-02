package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Article;

public interface ArticleRepository extends CrudRepository<Article, Integer>{

}
