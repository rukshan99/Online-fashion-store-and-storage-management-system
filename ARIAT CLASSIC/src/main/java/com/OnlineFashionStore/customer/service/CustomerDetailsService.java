package com.OnlineFashionStore.customer.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.OnlineFashionStore.customer.jpa.Customer;
import com.OnlineFashionStore.customer.jpa.CustomerRepository;

@Service
public class CustomerDetailsService implements UserDetailsService{
	
    @Autowired
    private CustomerRepository customerRepository;
    
   // private Customer user;
    
     
	/*
	 * public CustomerDetailsService(Customer user) { this.user = user; }
	 */
 
	/*
	 * public String getFirstName() { return this.user.getFirstName(); }
	 */
    
    
    
    
	/*
	 * Search function implementation for admin dashboard, customer details.
	 */    
    public List<Customer> listAll(String keyword) {
        if (keyword != null) {
            return customerRepository.search(keyword);
        }
        return customerRepository.findAll();
    }
    


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Customer customer = customerRepository.findByEmailIdIgnoreCase(username);
		GrantedAuthority authority = new SimpleGrantedAuthority(customer.getRoleid());
		//System.out.println("DEBUGGING 01 " +customer.getEmailId()+" "+customer.getPassword()+" "+customer.getRoleid());/////////////////////////////////////////////////////////////////////////////////////
		UserDetails userDetails = (UserDetails)new User(customer.getEmailId(),
				customer.getPassword(), Arrays.asList(authority));
		return userDetails;


	}
	
	


}


