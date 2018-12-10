package edu.northeastern.cs5200_fall2018_finalproject_drunkerland;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.ConsumerController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.FollowController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.ReviewerController;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Consumer;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Follow;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Item;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Reviewer;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FollowControllerTest {
	
	@Autowired
	FollowController followController;
	@Autowired
	ConsumerController consumerController;
	@Autowired
	ReviewerController reviewerController;
	
	
//	@Before
//	public void setUp()
//	{
//		Consumer consumer1 = consumerController.findConsumerById(10);
//		Consumer consumer2 = consumerController.findConsumerById(11);
//		
//		Reviewer reviewer1 = new Reviewer("charlie", "password", "Charlie", "Beckham", 
//				Reviewer.ReviewerLevel.BEGINNER);
//		Reviewer reviewer2 = new Reviewer("lily", "password", "Lily", "Stone", 
//				Reviewer.ReviewerLevel.SENIOR);
//		
//		reviewerController.createReviewer(reviewer1);
//		reviewerController.createReviewer(reviewer2);
//		
//		Follow follow1 = new Follow(consumer1, reviewer1);
//		Follow follow2 = new Follow(consumer2, reviewer2);
//		
//		followController.createFollow(follow1);
//		followController.createFollow(follow2);
//	}
	
	
	@Test
	public void testFindAllFollows()
	{
		List<Follow> follows = followController.findAllFollows();
		 for(Follow fo : follows)
	        {
	        	System.out.println(fo.getReviewer().getLevel());
	        }
				
	}
	
	
	@Test
	public void testFindFollowById()
	{
		Follow follow = followController.findFollowById(1);
		System.out.println(follow.getReviewer().getLevel());
		
	}
	
	
	@Test
	public void testFindFollowsByConsumer()
	{
		Consumer consumer = consumerController.findConsumerById(10);
		List<Follow> follows = followController.findFollowsByConsumer(consumer);
		for(Follow fo : follows)
	        {
	        	System.out.println(fo.getReviewer().getLevel());
	        }
		
	}
	
	

	@Test
	public void testFindFollowsByReviewer()
	{
		Reviewer reviewer = reviewerController.findReviewerById(22);
		List<Follow> follows = followController.findFollowsByReviewer(reviewer);
		for(Follow fo : follows)
	        {
	        	System.out.println(fo.getConsumer().getLastName());
	        }
		
	}
	
	
	@Test
	public void testDeleteFollowById()
	{
		followController.deleteFollowById(1);
	}

	
	@Test
	public void testUpdateFollowById()
	{
		Consumer consumer = consumerController.findConsumerById(10);
		Reviewer reviewer = reviewerController.findReviewerById(22);
		
		Follow newFollow = new Follow(consumer, reviewer);
		followController.updateFollowById(2, newFollow);
	}
}
