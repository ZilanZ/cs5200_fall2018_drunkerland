package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api;


import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Reviewer;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @PathVariable passing by URL eg. /{id}
 * @RequestParam passing by URL eg. ?key1=value1&key2=value2
 * @RequestBody passing by body [type: (default) json]
 *
 * we use @RestController here, @ResponseBody is not required. default: Json
 */
@RequestMapping("rest/api/reviewers")
public interface ReviewerApi {

    /**
     * create reviewer
     * @param reviewer
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    Reviewer createReviewer(@RequestBody Reviewer reviewer);

    /**
     * retrieve all reviewers
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    List<Reviewer> findAllReviewers();

    /**
     * retrieve reviewer by id
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Reviewer findReviewerById(@PathVariable int id);

    /**
     * retrieve reviewer by name
     * @param name
     * @return
     */
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    List<Reviewer> findReviewerByName(@RequestParam("name") String name);

    /**
     * reviewer authentication: retrieve reviewer by credential
     * @param reviewer
     * @return
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    Reviewer findReviewerByCredential(@RequestBody Reviewer reviewer);

    /**
     * delete reviewer by id
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteReviewerById(@PathVariable("id") int id);

    /**
     * update reviewer by id
     * @param id
     * @param newReviewer
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Reviewer updateReviewerById(@PathVariable("id") int id, @RequestBody Reviewer newReviewer);

}
