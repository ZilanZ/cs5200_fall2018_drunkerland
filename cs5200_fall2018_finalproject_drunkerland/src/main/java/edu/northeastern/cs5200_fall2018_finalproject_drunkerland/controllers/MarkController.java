package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api.MarkApi;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Mark;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Reviewer;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Wine;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.MarkRepository;

@RestController
public class MarkController implements MarkApi{
	
	@Autowired
	MarkRepository markRepository;

	@Override
	public Mark createMark(Mark mark) {
		
		return markRepository.save(mark);
	}

	@Override
	public List<Mark> findAllMarks() {
		
		return (List<Mark>) markRepository.findAll();
	}

	@Override
	public Mark findMarkById(int id) {
		
		return markRepository.findById(id).orElse(null);
	}

	@Override
	public List<Mark> findMarksByReviewer(Reviewer reviewer) {
		
		return markRepository.findMarksByReviewer(reviewer);
	}

	@Override
	public List<Mark> findMarksByWine(Wine wine) {
		
		return markRepository.findMarksByWine(wine);
	}

	@Override
	public void deleteMarkById(int id) {
		markRepository.deleteById(id);
		
	}

	@Override
	public Mark updateMarkById(int id, Mark newMark) {
		Mark mark = findMarkById(id);
		mark.set(newMark);
		return markRepository.save(mark);
	}

}
