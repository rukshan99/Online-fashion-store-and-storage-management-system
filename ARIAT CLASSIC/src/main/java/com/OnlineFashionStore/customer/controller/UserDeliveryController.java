package com.OnlineFashionStore.customer.controller;



	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.servlet.ModelAndView;

import com.OnlineFashionStore.customer.jpa.Delivery;
import com.OnlineFashionStore.customer.jpa.DeliveryRepository;

	@Controller
	@RestController

	public class UserDeliveryController {
		

		@Autowired
	    private DeliveryRepository deliveryRepository;

		
		@RequestMapping(value="/delivery",method = RequestMethod.GET)
		public ModelAndView DisplayRating(ModelAndView modelAndView , Delivery delivery) {
			
			modelAndView.addObject("delivery", delivery);
			modelAndView.setViewName("delivery");		
			
			return modelAndView;	
			
			
		}
		
	   @RequestMapping(value="/delivery", method = RequestMethod.POST)
	    public ModelAndView ratingUser(ModelAndView modelAndView, Delivery delivery)
	    {

	    	Delivery existingRating = deliveryRepository.findByOrderIdIgnoreCase(delivery.getOrderId());
	        if(existingRating != null)
	        {
	            modelAndView.addObject("message","This email already exists!");
	            modelAndView.setViewName("sucessfulDelivery"); 
	        }
	        else
	        {
	        	deliveryRepository.save(delivery);

	        }

	        return modelAndView;
	    }

	 
	    
		public DeliveryRepository getInventoryRepository() {
			return deliveryRepository;
		}
	    

		public void setDeliveryRepository(DeliveryRepository deliveryRepository) {
			this.deliveryRepository = deliveryRepository;
		}
		
}
