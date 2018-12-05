package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Reviewer;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Reviewer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ReviewerRepository extends CrudRepository<Reviewer, Integer>{
    @Query("select u from Reviewer u where u.firstName=:firstName and u.lastName=:lastName and dtype=Reviewer")
    List<Reviewer> findReviewerByName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("select u from Reviewer u where u.username=:username and dtype=Reviewer")
    Reviewer findReviewerByReviewername(@Param("username") String username);

    @Query("select u from Reviewer u where u.username=:username and u.password=:password and dtype=Reviewer")
    Reviewer findReviewerByCredential(@Param("username") String username, @Param("password") String password);

}
