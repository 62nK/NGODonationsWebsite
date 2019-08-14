package com.andrea.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.andrea.model.info.UserLoginForm;
import com.ketu.model.beans.User;
import com.tariq.models.services.UserService;

@Controller
@Transactional
public class MainController {
	
	@Autowired
	UserService userService;

	@RequestMapping(path="/")
	public ModelAndView validate(HttpServletRequest request, 
			@ModelAttribute("UserLoginForm") UserLoginForm userLoginForm) {
		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if (authenticatedUser == null) {
			mv.setViewName("login");
		}
		else {
			mv.addObject("users", userService.findAll());
			mv.setViewName("UserManagement");
		}
		return mv;
	}

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, @ModelAttribute("UserLoginForm") UserLoginForm userLoginForm) {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("command", new UserLoginForm());
		mv.addObject("UserLoginForm", new UserLoginForm());
		return mv;
	}

	@RequestMapping(path = "/signin", method = RequestMethod.POST)
	public ModelAndView signin(HttpServletRequest request,
			@ModelAttribute("UserLoginForm") UserLoginForm userLoginForm) {
		ModelAndView mv = new ModelAndView();
		User user = userService.findByUsername(userLoginForm.getUsername());
		if (user == null) {
			mv.setViewName("login");
			mv.addObject("AuthenticationException", "The user \'"+userLoginForm.getUsername()+"\' does not exist");
		} else {
			if (user.getPassword().equals(userLoginForm.getPassword())) {
				request.getSession().setAttribute("authenticatedUser", user);
				mv.setViewName("UserManagement");
				return mv;
			} else {
				mv.setViewName("login");
				mv.addObject("AuthenticationException", "Invalid password Credentials");
			}
		}
		return mv;
	}
}
