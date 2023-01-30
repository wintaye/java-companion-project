
package com.organization.mvcproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.organization.mvcproject.model.Game;
import com.organization.mvcproject.model.Review;
import com.organization.mvcproject.service.GameService;

@Controller
public class GameController {


	@GetMapping(value = "/")
	public String home() {
		return "index";
	}
	
	@GetMapping(value="/review")
	public ModelAndView review() {

		return new ModelAndView("reviewCreatePage", "command", new Review());
	}

	@PostMapping(value="/addReview")
	public ModelAndView addReview(Review review, ModelMap model) {
		if(review.getAuthor().equals("")) {
			review.setAuthor("anonymous");
		}
	
		return new ModelAndView("reviewDetailPage", "submittedReview", review);
	}

	
	@GetMapping(value = "/games")
	public String game() {
	
		return "gamesPage";
	}

	

}