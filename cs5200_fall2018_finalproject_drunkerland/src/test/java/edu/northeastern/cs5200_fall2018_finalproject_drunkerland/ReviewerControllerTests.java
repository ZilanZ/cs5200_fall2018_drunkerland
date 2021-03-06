package edu.northeastern.cs5200_fall2018_finalproject_drunkerland;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.ReviewerController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.*;

import java.util.*;

/**
 * Created by danlinjia on 12/2/18.
 */
public class ReviewerControllerTests extends DemoApplicationTests {
    @Autowired
    ReviewerController reviewerController;

//    @Test
//    public void createReviewerTest(){
//        Reviewer reviewer = new Reviewer("reviewer","reviewer","danlin","jia", Reviewer.ReviewerLevel.BEGINNER);
//        reviewerController.createReviewer(reviewer);
//    }

    @Test
    public void findReviewerById(){
        int id = 69;
        reviewerController.findReviewerById(id);
    }

    @Test
    public void findReviewerByName() {
        reviewerController.findReviewerByName("danlin jia");
    }

    @Test
    public void findAllReviewer() {
        reviewerController.findAllReviewers();
    }

    @Test
    public void findReviewerByCredential() {
        Reviewer newReviewer = new Reviewer("reviewer","reviewer","danlin","jia",Reviewer.ReviewerLevel.BEGINNER);
        reviewerController.findReviewerByCredential(newReviewer);
    }

    @Test
    public void testFindArticlesForReviewer() {
        int rId = 72;
        reviewerController.findArticleForReviewer(rId);
    }

    @Test
    public void updateReviewerById() {
        int id = 72;
        Reviewer newReviewer = new Reviewer("reviewer","reviewer","danlin","jia",Reviewer.ReviewerLevel.INTERMEDIATE);
        reviewerController.updateReviewerById(id, newReviewer);
    }

//    @Test
//    public void deleteReviewerById() {
//        int id = 69;
//        reviewerController.deleteReviewerById(id);
//    }


    @Test
    public void testFindArticleForReviewer(){
        int rId = 72;
        reviewerController.findArticleForReviewer(rId);
    }

    @Test
    public void addArticleToReviewer() {
        int rId = 72;
        int aId = 1;
        Reviewer r = reviewerController.addArticleToReviewer(rId, aId);
    }
}
