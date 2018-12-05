package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Article;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Integer>{
    @Query("select a from Article a where a.title=:title")
    Article findArticleByTitle(@Param("title") String title);

}
