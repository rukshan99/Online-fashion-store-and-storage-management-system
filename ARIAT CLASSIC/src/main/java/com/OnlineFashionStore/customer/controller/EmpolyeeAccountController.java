package com.OnlineFashionStore.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.OnlineFashionStore.customer.jpa.Employee;
import com.OnlineFashionStore.customer.jpa.EmployeeRepository;




@Controller
public class EmpolyeeAccountController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	 @RequestMapping(value="/employee", method = RequestMethod.GET)
	    public ModelAndView displayRegistration(ModelAndView modelAndView,Employee employee)
	    {
	        modelAndView.addObject("employee", employee);
	        modelAndView.setViewName("employee");
	        return modelAndView;
	    }
	 @RequestMapping(value="/employee", method = RequestMethod.POST)
	    public ModelAndView registerEmployee(ModelAndView modelAndView, Employee employee)
	    {

	        Employee existingEmployee = employeeRepository.findByEmployeeEmailIgnoreCase(employee.getEmployeeEmail());
	        if(existingEmployee != null)
	        {
	            modelAndView.addObject("message","This email already exists!");
	            modelAndView.setViewName("error"); 
	        }
	        else
	        {
	        	employeeRepository.save(employee);

	        }
	        
	        return modelAndView;


	    }
}
