package com.andrea.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.andrea.model.info.UserLoginForm;
import com.ketu.model.beans.User;
import com.tariq.models.services.UserService;

@Controller
@RequestMapping(path="/admin")
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(path = "/edituser", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request,
			@RequestParam("id") int id) {
		
		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if(authenticatedUser.getRole().equals(User.role1)) {
			User user = userService.findById(id);
			mv.addObject("editUser", user);
			mv.addObject("displayAdd", true);
		} else {
			mv.addObject("invalidRoleException", "you are missing the privileges to perform this action");
			mv.addObject("displayAdd", false);
		}
		mv.setViewName("UserManagement");
		return mv;
	}
	@RequestMapping(path = "/canceluser", method = RequestMethod.GET)
	public ModelAndView cancelUser(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("displayAdd", true);
		mv.setViewName("UserManagement");
		return mv;
	}
	@RequestMapping(path = "/saveuser", method = RequestMethod.POST)
	public ModelAndView saveUser(HttpServletRequest request,
			@RequestParam("id") int id,
			@ModelAttribute("UserForm") User user) {
		
		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if(authenticatedUser.getRole().equals(User.role1)) {
			userService.save(user);
			mv.addObject("operationStatus", "user saved successfully!");
			mv.addObject("displayAdd", true);
		} else {
			mv.addObject("invalidRoleException", "you are missing the privileges to perform this action");
			mv.addObject("displayAdd", false);
		}
		mv.setViewName("UserManagement");
		return mv;
	}
	@RequestMapping(path = "/deleteuser", method = RequestMethod.POST)
	public ModelAndView deleteUser(HttpServletRequest request,
			@RequestParam("id") int id) {
		
		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if(authenticatedUser.getRole().equals(User.role1)) {
			userService.deleteById((long) id);
			mv.addObject("operationStatus", "user deleted successfully!");
			mv.addObject("displayAdd", true);
		} else {
			mv.addObject("invalidRoleException", "you are missing the privileges to perform this action");
			mv.addObject("displayAdd", false);
		}
		mv.setViewName("UserManagement");
		return mv;
	}
	
	@RequestMapping(path="/adduser", method=RequestMethod.GET)
	public ModelAndView addUser(HttpServletRequest request,
			@ModelAttribute("UserInsertion") User newUser) {
		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if(authenticatedUser.getRole().equals(User.role1)) {
			mv.addObject("newUser", new User());
			mv.addObject("users", userService.findAll());
		} else {
			mv.addObject("invalidRoleException", "you are missing the privileges to perform this action");
		}
		mv.addObject("displayAdd", false);
		mv.setViewName("UserManagement");
		return mv;
	}
}
