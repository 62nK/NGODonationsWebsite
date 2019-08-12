package com.andrea.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ketu.model.beans.User;
import com.tariq.models.services.UserService;

@Controller
@RequestMapping(path="/")
public class MainController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public ModelAndView validate(
			HttpServletRequest request) {
		
		User user = (User) request.getSession().getAttribute("user");
		if(user==null)
			return new ModelAndView("login");
		return new ModelAndView("index");
	}
	
	@RequestMapping(path="signin", method=RequestMethod.POST)
	public ModelAndView signin(
			HttpServletRequest request,
			@RequestParam("username") String username, 
			@RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView();
//		User user = userService.get(username, password);
		User user = userService.findByUsername(username);
		if(user.getPasswd().equals(password)) {
			request.getSession().setAttribute("authenticatedUser", user);
			mv.setViewName("home");
			return mv;
		}
		else {
			mv.addObject("AuthenticationException", "invalid user credentials");
		}
		return new ModelAndView("login");
	}
}
