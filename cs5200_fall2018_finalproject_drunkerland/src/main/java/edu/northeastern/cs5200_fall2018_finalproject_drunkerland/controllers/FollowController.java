package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api.FollowApi;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Consumer;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Follow;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Reviewer;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.FollowRepository;

@RestController
public class FollowController implements FollowApi{

	@Autowired
	FollowRepository followRepository;

	@Override
	public Follow createFollow(Follow follow) {
		
		return followRepository.save(follow);
	}

	@Override
	public List<Follow> findAllFollows() {
		
		return (List<Follow>) followRepository.findAll();
	}

	@Override
	public Follow findFollowById(int id) {
		
		return followRepository.findById(id).orElse(null);
	}

	@Override
	public List<Follow> findFollowsByConsumer(Consumer consumer) {
		
		return followRepository.findFollowsByConsumer(consumer);
	}

	@Override
	public List<Follow> findFollowsByReviewer(Reviewer reviewer) {
		
		return followRepository.findFollowsByReviewer(reviewer);
	}

	@Override
	public void deleteFollowById(int id) {
		followRepository.deleteById(id);
		
	}

	@Override
	public Follow updateFollowById(int id, Follow newFollow) {
		Follow follow = findFollowById(id);
		follow.set(newFollow);
		return followRepository.save(follow);
	}
	
	
}
