package com.OnlineFashionStore.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.OnlineFashionStore.customer.jpa.Product;
import com.OnlineFashionStore.customer.jpa.ProductRepository;

	
	@Controller
	public class StoreController {
		
		@Autowired
	    private ProductRepository productRepository;
		
	
		@RequestMapping(value="/AddProduct", method = RequestMethod.GET)
	    public ModelAndView displayRegistration(ModelAndView modelAndView, Product product)
	    {
	        modelAndView.addObject("Product", product);
	        modelAndView.setViewName("AddProduct");
	        return modelAndView;
	    }
		
		
		
		@RequestMapping(value="/AddProduct", method = RequestMethod.POST)
	    public ModelAndView registerUser(ModelAndView modelAndView, Product product)
	    {

	        Product existingUser = productRepository.findByProductCodeIgnoreCase(product.getProduct_code());
	        if(existingUser != null)
	        {
	            modelAndView.addObject("message","This email already exists!");
	            modelAndView.setViewName("error"); 
	        }
	        else
	        {
	            productRepository.save(product);
	            modelAndView.setViewName("Succes"); 
	        }

	        return modelAndView;
	        
	    }
		
		@RequestMapping(value="/ProductDetails",method = RequestMethod.GET)
		public ModelAndView displayProductList(ModelAndView modelAndView) 
		{
			modelAndView.addObject("productList", productRepository.findAll());		
			modelAndView.setViewName("ProductDetails");
			return modelAndView;
			
		}



		public ProductRepository getProductRepository() {
			return productRepository;
		} 

		public void setProductRepository(ProductRepository productRepository) {
			this.productRepository = productRepository;
		}
	}
	

