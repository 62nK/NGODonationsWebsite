package com.andrea.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ketu.model.beans.User;
import com.tariq.models.services.UserService;

@Controller
//@RequestMapping(path="/")
//@EnableWebMvc
@Transactional
public class MainController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String init(
//			HttpServletRequest request,
//			Model model
			) {
//		model.addAttribute("command", new User());
//		User user = (User) request.getSession().getAttribute("user");
//		if(user==null)
//			return "index";
		System.out.println("sup");
		return "index";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public ModelAndView validate(
			HttpServletRequest request) {
		
		User user = (User) request.getSession().getAttribute("user");
		if(user==null)
			return new ModelAndView("login");
		return new ModelAndView("");
	}
	
	@RequestMapping(path="/signin", method=RequestMethod.POST)
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
