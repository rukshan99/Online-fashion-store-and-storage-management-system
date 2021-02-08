package com.OnlineFashionStore.customer.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.OnlineFashionStore.customer.jpa.*;
import com.OnlineFashionStore.customer.service.CustomerDetailsService;
import com.OnlineFashionStore.customer.service.EmailSenderService;
import com.OnlineFashionStore.customer.service.TokenDetailsService;

@RestController
@Controller
public class UserAccountController {

    @Autowired
    private TokenDetailsService tokenService;
    
    @Autowired
    private CustomerDetailsService customerService;
    
	@Autowired
    private CustomerRepository userRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailSenderService emailSenderService;
    
    @Autowired
	private PasswordEncoder passwordEncoder;

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView displayRegistration(ModelAndView modelAndView, Customer user)
    {
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView registerUser(ModelAndView modelAndView, Customer user)
    {

        Customer existingUser = userRepository.findByEmailIdIgnoreCase(user.getEmailId());
        if(existingUser != null)
        {
            modelAndView.addObject("message","This email already exists!");
            modelAndView.setViewName("error"); 
        }
        else
        {
        	
        	user.setPassword(passwordEncoder.encode(user.getPassword()));
        	
            userRepository.save(user);

            ConfirmationToken confirmationToken = new ConfirmationToken(user);

            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmailId());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("rukshan033@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
            +"http://localhost:8082/confirm-account?token="+confirmationToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);

            modelAndView.addObject("emailId", user.getEmailId());

            modelAndView.setViewName("successfulRegisteration");
        }

        return modelAndView;
    }

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken)
    {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
        	Customer user = token.getCustomer();
            user.setEnabled(true);
            userRepository.save(user);
            modelAndView.setViewName("accountVerified");
        }
        else
        {
            modelAndView.addObject("message","The link is invalid or broken!");
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }
   
  
    

    @RequestMapping(value="/customerDetails", method = RequestMethod.GET)
    public ModelAndView displayCustomerList(ModelAndView modelAndView, @Param("keyword") String keyword)
    {
        List<Customer> listCustomer = customerService.listAll(keyword);
        modelAndView.addObject("customerList", listCustomer);
        modelAndView.addObject("keyword", keyword);
        
           
        modelAndView.setViewName("customerDetails");
        
        return modelAndView;
    }
    
    @RequestMapping(value="/tokenDetails", method = RequestMethod.GET)
    public ModelAndView displayTokenList(ModelAndView modelAndView, @Param("keyword") String keyword)
    {
        List<ConfirmationToken> listToken = tokenService.listAll(keyword);
        modelAndView.addObject("tokenList", listToken);
        modelAndView.addObject("keyword", keyword);
        
           
        modelAndView.setViewName("tokenDetails");
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
     
    
    // getters and setters
	public CustomerRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(CustomerRepository userRepository) {
		this.userRepository = userRepository;
	}

	public ConfirmationTokenRepository getConfirmationTokenRepository() {
		return confirmationTokenRepository;
	}

	public void setConfirmationTokenRepository(ConfirmationTokenRepository confirmationTokenRepository) {
		this.confirmationTokenRepository = confirmationTokenRepository;
	}

	public EmailSenderService getEmailSenderService() {
		return emailSenderService;
	}

	public void setEmailSenderService(EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}

	public CustomerDetailsService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerDetailsService customerService) {
		this.customerService = customerService;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
    
    
}

