package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Consumer;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Follow;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Reviewer;

@RequestMapping("rest/api/follows")
public interface FollowApi {
	
	
	/**
	 * create follow
	 * @param follow
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
    Follow createFollow(@RequestBody Follow follow);
	
	
	/**
	 * retrieve all follows
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
    List<Follow> findAllFollows();
	
	
	/**
	 * retrieve follow by follow id 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	Follow findFollowById(@PathVariable int id);
	
	
	/**
	 * retrieve follow by consumer
	 * @param consumer
	 * @return
	 */
	@RequestMapping(value = "/consumer", method = RequestMethod.POST)
	List<Follow> findFollowsByConsumer(@RequestBody Consumer consumer);
	
	
	/**
	 * retrieve follow by reviewer
	 * @param reviewer
	 * @return
	 */
	@RequestMapping(value = "/reviewer", method = RequestMethod.POST)
	List<Follow> findFollowsByReviewer(@RequestBody Reviewer reviewer);
	
	
	/**
	 * delete follow by id
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteFollowById(@PathVariable("id") int id);

	
	/**
	 * update follow by id
	 * @param id
	 * @param newFollow
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Follow updateFollowById(@PathVariable("id") int id, @RequestBody Follow newFollow);

}
