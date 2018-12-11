package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Mark;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Reviewer;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Wine;

@RequestMapping("rest/api/mark")
public interface MarkApi {
	
	
	 /**
	  * create mark
	  * @param mark
	  * @return
	  */
	 @RequestMapping(method = RequestMethod.POST)
	 Mark createMark(@RequestBody Mark mark);
	 
	 
	 
	 /**
	  * retrieve all marks
	  * @return
	  */
	 @RequestMapping(method = RequestMethod.GET)
	 List<Mark> findAllMarks();
	 
	 
	 /**
	  * retrieve mark by id
	  * @param id
	  * @return
	  */
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 Mark findMarkById(@PathVariable int id);
	 
	 
	 /**
	  * retrieve mark by reviewer
	  * @param reviewer
	  * @return
	  */
	 @RequestMapping(value = "/reviewer", method = RequestMethod.POST)
	 List<Mark> findMarksByReviewer(@RequestBody Reviewer reviewer);
	 
	 
	 
	 /**
	  * retrieve mark by wine
	  * @param wine
	  * @return
	  */
	 @RequestMapping(value = "/wine", method = RequestMethod.POST)
	 List<Mark> findMarksByWine(@RequestBody Wine wine);
	 
	 
	 /**
	  * delete mark by id
	  * @param id
	  */
	 @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	 void deleteMarkById(@PathVariable("id") int id);
	 
	 
	 
	 /**
	  * update mark by id
	  * @param id
	  * @param newMark
	  * @return
	  */
	 @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	 Mark updateMarkById(@PathVariable("id") int id, @RequestBody Mark newMark);

}
