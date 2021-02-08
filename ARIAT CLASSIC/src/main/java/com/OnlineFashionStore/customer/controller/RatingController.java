package com.OnlineFashionStore.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.OnlineFashionStore.customer.jpa.*;


@Controller
@RestController

public class RatingController {
	

	@Autowired
    private RatingRepository ratingRepository;

	
	@RequestMapping(value="/rating",method = RequestMethod.GET)
	public ModelAndView DisplayRating(ModelAndView modelAndView , Rating rating) {
		
		modelAndView.addObject("rating", rating);
		modelAndView.setViewName("rating");		
		
		return modelAndView;	
		
		
	}
	
   @RequestMapping(value="/rating", method = RequestMethod.POST)
    public ModelAndView ratingUser(ModelAndView modelAndView, Rating rating)
    {

    	Rating existingRating = ratingRepository.findByEmailIgnoreCase(rating.getEmail());
        if(existingRating != null)
        {
            modelAndView.addObject("message","This email already exists!");
            modelAndView.setViewName("error"); 
        }
        else
        {
        	ratingRepository.save(rating);

        }

        return modelAndView;
    }

 
    

	
	/**
	@PostMapping("/rating")
	public String SubmitFeedback(@ModelAttribute ("rating") Rating rating) {
		System.out.println(rating);
		return "saved";}
		**/
	 
	/**
	@GetMapping(path="/all")
	  public @ResponseBody Iterable<Rating> getAllRatings() {
	    
	    return ratingRepository.findAll();
	  }
	**/
	
	@RequestMapping(value="/saved", method = RequestMethod.GET)
    public ModelAndView displayRatingList(ModelAndView modelAndView)
    {
        modelAndView.addObject("RatingList", ratingRepository.findAll());
        modelAndView.setViewName("saved");
        return modelAndView;
    }

	public RatingRepository getRatingRepository() {
		return ratingRepository;
	}
    

	public void setRatingRepository(RatingRepository ratingRepository) {
		this.ratingRepository = ratingRepository;
	}
}
   
    

