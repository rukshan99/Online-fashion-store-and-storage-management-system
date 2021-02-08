package com.OnlineFashionStore.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.OnlineFashionStore.customer.jpa.Payment;
import com.OnlineFashionStore.customer.jpa.PaymentReporsitory;

@Controller
public class PaymentController {
	@Autowired
	private PaymentReporsitory paymentReporsitory;

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView displayCart(ModelAndView modelAndView, Payment user) {
		modelAndView.addObject("user", user);
		modelAndView.setViewName("cart");
		return modelAndView;
	}
	
	@RequestMapping(value = "/paymentDetails", method = RequestMethod.GET)
	public ModelAndView displayPaymentlist(ModelAndView modelAndView) {
		modelAndView.addObject("paymentList", paymentReporsitory.findAll());
		modelAndView.setViewName("paymentDetails");
		return modelAndView;
	}

	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public ModelAndView addPayment(ModelAndView modelAndView, Payment user) {

		paymentReporsitory.save(user);
		return modelAndView;
	}
	
	 @GetMapping("/wishlist")
	    public String wishlist() {
	      return "wishlist";
	    }

	// getters and setters
	public PaymentReporsitory getPaymentRepository() {
		return paymentReporsitory;
	}

	public void setPaymentRepository(PaymentReporsitory paymentRepository) {
		this.paymentReporsitory = paymentRepository;
	}

}
