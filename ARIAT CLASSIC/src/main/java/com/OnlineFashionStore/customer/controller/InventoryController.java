package com.OnlineFashionStore.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.OnlineFashionStore.customer.jpa.Inventory;
import com.OnlineFashionStore.customer.jpa.InventoryRepository;

@Controller
public class InventoryController {
	
	
	@Autowired
    private InventoryRepository InventoryRepository;
	
  @RequestMapping(value="/inventory", method = RequestMethod.GET)
    public ModelAndView displayInventory(ModelAndView modelAndView, Inventory inventory)
    {
        modelAndView.addObject("inventory", inventory);
        modelAndView.setViewName("inventory");
        return modelAndView;
    }
    
    
    @RequestMapping(value="/inventory", method = RequestMethod.POST)
    public ModelAndView inventoryUser(ModelAndView modelAndView, Inventory inventory)
    {

    	Inventory existingInventory = InventoryRepository.findByItemNameIgnoreCase(inventory.getItemName());
        if(existingInventory == null)
    	//if(existingInventory.getInventoryid()==null)
        {
    		InventoryRepository.save(inventory);
        	modelAndView.setViewName("successfulInventory");
        	
    		
        	/*modelAndView.addObject("message","This  already exists!");
            modelAndView.setViewName("wrongDetails");*/
             
        }
        else
        {
        	
        	modelAndView.addObject("message","This  already exists or inputs are error !!");
            modelAndView.setViewName("wrongInventory");
        	
        /*	InventoryRepository.save(inventory);
        	modelAndView.setViewName("successfulInventory");*/
        	
          /* modelAndView.addObject("inventoryid", inventory.getInventoryid() );

            modelAndView.setViewName("successfulInventory");*/
        }

        return modelAndView;
    }
    
    @RequestMapping(value="/inventoryDetails", method = RequestMethod.GET)
    public ModelAndView displayInventoryList(ModelAndView modelAndView)
    {
        modelAndView.addObject("inventoryList", InventoryRepository.findAll());
        modelAndView.setViewName("InventoryDetails");
        return modelAndView;
    }

    // getters and setters
	public InventoryRepository getInventoryRepository() {
		return InventoryRepository;
	}
	
	public void setUserRepository(InventoryRepository userRepository) {
		this.InventoryRepository = userRepository;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void setInventoryRepository(InventoryRepository InventoryRepository) {
		this.InventoryRepository = InventoryRepository;
	}
   

}
