package com.OnlineFashionStore.customer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.OnlineFashionStore.customer.service.CustomerDetailsService;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	 @Autowired 
	 private CustomerDetailsService customerService;
	
	 @Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			.antMatchers("/adminDashboard/**").hasAnyRole("ADMIN")
			//.antMatchers("/customerAccountEdit/**").hasAnyRole("USER")
			.antMatchers("/register/**"
					,"/Index/**"
		            ,"/Category**"
		            ,"/css/**"
		            ,"/cssTips/**"
		            ,"/slick/**"
		            ,"/webfonts/**"
		            ,"/fonts/**"
		            ,"/icon-fonts/**"
		            ,"/images/**"
		            ,"/img/**"
		            ,"/js/**"
		            ,"/Source/**"
		            ,"/confirm-account/**"
		            ,"/app-login/**").permitAll()
			.anyRequest().authenticated()
			.and().formLogin()  //login configuration
	                .loginPage("/login").permitAll() 
	                .loginProcessingUrl("/app-login")
	                .usernameParameter("app_username")
	                .passwordParameter("app_password")
	                .defaultSuccessUrl("/customerAccount")	
			.and().logout()    //logout configuration
			.logoutUrl("/app-logout") 
			.logoutSuccessUrl("/login")
			.and().exceptionHandling() //exception handling configuration
			.accessDeniedPage("/error");
			
			System.out.println("DEBUGGING 02");

		} 
	 
	 @Autowired
	   	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    	      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	              auth.userDetailsService(customerService).passwordEncoder(passwordEncoder);
		}
    
    
}
