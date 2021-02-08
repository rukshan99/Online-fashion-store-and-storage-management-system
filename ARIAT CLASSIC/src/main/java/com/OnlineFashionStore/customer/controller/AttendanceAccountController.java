package com.OnlineFashionStore.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.OnlineFashionStore.customer.jpa.Attendance;
import com.OnlineFashionStore.customer.jpa.AttendanceRepository;



@Controller
public class AttendanceAccountController {
	@Autowired
    private AttendanceRepository attendenceRepository;
	
	@RequestMapping(value="/attendance", method = RequestMethod.GET)
    public ModelAndView displayRegistration(ModelAndView modelAndView, Attendance attendance)
    {
        modelAndView.addObject("attendance",attendance);
        modelAndView.setViewName("attendance");
        return modelAndView;
    }
	
	@RequestMapping(value="/attendance", method = RequestMethod.POST)
    public ModelAndView registerUser(ModelAndView modelAndView, Attendance attendance)
    {

		Attendance existingUser = attendenceRepository.findByEmployeeIdIgnoreCase(attendance.getEmployeeId());
		if(existingUser == null)
        //if(existingUser != null)
        {
			attendenceRepository.save(attendance);
			modelAndView.setViewName("success");
			
            /*modelAndView.addObject("message","This attendance id already exists!");
            modelAndView.setViewName("error"); */
        }
        else
        {
            attendenceRepository.save(attendance);

        }

        return modelAndView;
    }

	public AttendanceRepository getAttendenceRepository() {
		return attendenceRepository;
	}

	public void setAttendenceRepository(AttendanceRepository attendenceRepository) {
		this.attendenceRepository = attendenceRepository;
	}


}
