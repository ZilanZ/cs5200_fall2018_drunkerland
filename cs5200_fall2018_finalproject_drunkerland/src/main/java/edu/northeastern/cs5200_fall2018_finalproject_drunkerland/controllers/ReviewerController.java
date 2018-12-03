package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api.ReviewerApi;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Reviewer;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.ReviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewerController implements ReviewerApi {

    @Autowired
    ReviewerRepository reviewerRepository;

    public Reviewer createReviewer(Reviewer reviewer) {
        return reviewerRepository.save(reviewer);
    }

    public List<Reviewer> findAllReviewers() {
        return (List<Reviewer>) reviewerRepository.findAll();
    }

    public Reviewer findReviewerById(int id) {
        return reviewerRepository.findById(id).orElse(null);
    }

    public List<Reviewer> findReviewerByName(String name) {
        String[] names = name.split(" ");
        return reviewerRepository.findReviewerByName(names[0], names[1]);
    }

    public Reviewer findReviewerByCredential(Reviewer reviewer) {
        return reviewerRepository.findReviewerByCredential(reviewer.getUsername(), reviewer.getPassword());
    }

    public void deleteReviewerById(int id) {
        reviewerRepository.deleteById(id);
    }

    public Reviewer updateReviewerById(int id, Reviewer newReviewer) {
        Reviewer reviewer = findReviewerById(id);
        reviewer.setReviewer(newReviewer);
        return reviewerRepository.save(reviewer);
    }
}
