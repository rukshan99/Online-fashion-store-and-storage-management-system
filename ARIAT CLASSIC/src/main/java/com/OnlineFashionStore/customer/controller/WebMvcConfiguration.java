package com.OnlineFashionStore.customer.controller;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.OnlineFashionStore.customer.jpa.ConfirmationTokenRepository;
import com.OnlineFashionStore.customer.jpa.Customer;
import com.OnlineFashionStore.customer.jpa.CustomerRepository;
import com.OnlineFashionStore.customer.service.ReportService;

import net.sf.jasperreports.engine.JRException;




//@EnableWebMvc
@ComponentScan("com.OnlineFashionStore.customer.controller")
@Controller
//@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer  {

	@Autowired
    private CustomerRepository userRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
    
    @Autowired
	private PasswordEncoder passwordEncoder;
    
    @Autowired
    private ReportService reportService;
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    
    @Transactional
    @GetMapping("/deleteToken/{id}")
    public String deleteToken(@PathVariable("id") String id, Model model) {
        
        confirmationTokenRepository.deleteByConfirmationToken(id);
        model.addAttribute("tokenList", confirmationTokenRepository.findAll());
        return "tokenDetails";
    }
    
    @Transactional
    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id") String id, Model model) {
        
        userRepository.deleteByEmailId(id);
        model.addAttribute("customerList", userRepository.findAll());
        return "customerDetails";
    }

    
    @Transactional
	@GetMapping("/editCustomer/{id}")
	public String showUpdateForm(@PathVariable("id") String id, Model model) {
    Customer user = userRepository.findByEmailIdIgnoreCase(id);    
    	model.addAttribute("user", user);
    	return "editCustomer";
	}
    
    @Transactional
	@PostMapping("/updateCustomer/{id}")
	public String updateUser(@PathVariable("id") String id, Customer customer,  
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			customer.setEmailId(id);
			return "editCustomer";
    }
		
	//getting the user id and the password of the updating customer	
	Customer customer1 = userRepository.findByEmailIdIgnoreCase(id);
    long userid = customer1.getUserid();
    String password = customer1.getPassword();
    
    //assigning same user id as before in order to execute this as an update rather than a normal insertion. 
    customer.setUserid(userid);
    
    //assigning the previous password to the updated field. Because the admin can't change the user-password.
    customer.setPassword(password);
    
    //comparing emails to determine the value of 'is_enabled'
    if(customer1.getEmailId().equalsIgnoreCase(customer.getEmailId())==true && customer1.isEnabled()==true) {
   	 customer.setEnabled(true);
    }
    
    userRepository.save(customer);
    model.addAttribute("customerList", userRepository.findAll());
    return "customerDetails";
	}
	
    
    @GetMapping("/login")
	public ModelAndView login(Customer customer) {
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("user", customer);
		System.out.println("DEBUGGING 03");
	    mav.setViewName("login");
	    return mav;
        }
    
    @GetMapping("/customerAccount")
    public String customerAccount() {
    	return "customerAccount";
    }
    
    
    
    @GetMapping("/customerAccountEdit")
    public String currentUser(@ModelAttribute("user")  Customer cus, BindingResult result, Model model) {

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedInUser.getName(); 
         Customer user = userRepository.findByEmailIdIgnoreCase(email);
         
        model.addAttribute("user",user);

        return "customerAccountEdit"; 
    }
    
    
	/* Post mapping of user profile updating. */
    
    @Transactional
 	@PostMapping("/saveuser/{id}")
 	public ModelAndView saveUser(@PathVariable("id") String id, Customer customer,  
 			BindingResult result, ModelAndView model) {
 		if (result.hasErrors()) {
 			customer.setEmailId(id);
 			model.setViewName("editCustomer");
 			return model;
     }
 		
 	//getting the user id and the password of the updating customer	
 	 Customer customer1 = userRepository.findByEmailIdIgnoreCase(id);
     long userid = customer1.getUserid();
     String pass = customer1.getPassword();
     
    //assigning same user id as before in order to execute this as an update rather than a normal insertion. 
     customer.setUserid(userid);
     
    //assigning the same role, as this will allow to update admin details too if needed.
     customer.setRoleid(customer1.getRoleid());
     
     if(customer.getPassword()==null) {
    	 customer.setPassword(pass);
     }else {
    	 
    	 customer.setPassword(passwordEncoder.encode(customer.getPassword()));
     }
     
    //comparing emails to determine the value of 'is_enabled'
     if(customer1.getEmailId().equalsIgnoreCase(customer.getEmailId())==true && customer1.isEnabled()==true) {
    	 customer.setEnabled(true);
     }
     
     userRepository.save(customer);
    // model.addAttribute("customerList", userRepository.findAll());
     model.setViewName("login");
     return model;
 	}
    
    
    
    @GetMapping("/adminDashboard")
    public String adminDashboard() {
    	return "adminDashboard";
    }
    
    @GetMapping("/Category")
   public String Category() {
     return "Category";
   }
    @GetMapping("/Index")
   public String Index() {
     return "Index";
   }
    @GetMapping("/tipsTricks")
    public String tipsTricks() {
      return "tipsTricks";
    }
    
    @PostMapping("/RatingAccount")
    public String RatingAccount() {
      return "RatingAccount";
    }
    
    @GetMapping("/customerfulldetailreport/{format}")
    public String generateReport(@PathVariable String format, Model model) throws FileNotFoundException, JRException { 
        reportService.exportCustomerFullDetailReport(format);
        model.addAttribute("customerList", userRepository.findAll());
        return "customerDetails";
    }
    
    @GetMapping("/customerprovincesreport/{format}")
    public String generateChart(@PathVariable String format, Model model) throws FileNotFoundException, JRException, SQLException { 
        reportService.exportCustomerProvincesReport(format);
        model.addAttribute("customerList", userRepository.findAll());
        return "customerDetails";
    }
    
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/static/**").addResourceLocations("/resources/static/");
    } 
    

}

