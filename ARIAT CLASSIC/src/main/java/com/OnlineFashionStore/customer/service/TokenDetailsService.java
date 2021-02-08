package com.OnlineFashionStore.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.OnlineFashionStore.customer.jpa.ConfirmationToken;
import com.OnlineFashionStore.customer.jpa.ConfirmationTokenRepository;

@Service
public class TokenDetailsService implements UserDetailsService{
	
    @Autowired
    private ConfirmationTokenRepository tokenRepository;

	/*
	 * Search function implementation for admin dashboard, confirmation token details.
	 */    
    public List<ConfirmationToken> listAll(String keyword) {
        if (keyword != null) {
            return tokenRepository.search(keyword);
        }
        return (List<ConfirmationToken>) tokenRepository.findAll();
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
