package com.andrea.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.andrea.model.info.UserLoginForm;
import com.ketu.model.beans.User;
import com.tariq.models.services.UserService;

@Controller
@Transactional
public class MainController {

	@Autowired
	UserService userService;

	@RequestMapping(path = "/")
	public ModelAndView validate(HttpServletRequest request,
			@ModelAttribute("UserLoginForm") UserLoginForm userLoginForm) {
		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if (authenticatedUser == null) {
			mv.setViewName("login");
		} else {
			mv.addObject("users", userService.findAll());
			mv.addObject("displayAdd", true);
			mv.setViewName("UserManagement");
		}
		return mv;
	}

	@RequestMapping(path = "/adduser", method = RequestMethod.GET)
	public ModelAndView addUser(HttpServletRequest request, @ModelAttribute("UserInsertion") User newUser) {
		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if (authenticatedUser.getRole().equals(User.role1)) {
			mv.addObject("newUser", new User());
			mv.addObject("users", userService.findAll());
		} else {
			mv.addObject("invalidRoleException", "you are missing the privileges to perform this action");
		}
		mv.addObject("displayAdd", false);
		mv.setViewName("UserManagement");
		return mv;
	}

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request,
			@ModelAttribute("UserLoginForm") UserLoginForm userLoginForm) {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("UserLoginForm", new UserLoginForm());
		return mv;
	}

	@RequestMapping(path = "/signin", method = RequestMethod.POST)
	public ModelAndView signin(HttpServletRequest request, @ModelAttribute("UserLoginForm") UserLoginForm userLoginForm,
			@ModelAttribute("UserInsertion") User newUser) {
		ModelAndView mv = new ModelAndView();
		User user = userService.findByUsername(userLoginForm.getUsername());
		if (user == null) {
			mv.setViewName("login");
			mv.addObject("AuthenticationException", "The user \'" + userLoginForm.getUsername() + "\' does not exist");
		} else {
			if (user.getPassword().equals(userLoginForm.getPassword())) {
				request.getSession().setAttribute("authenticatedUser", user);
				if (user.getRole().equals(User.role1)) {
					mv.addObject("users", userService.findAll());
					mv.setViewName("UserManagement");
					mv.addObject("displayAdd", true);
				} else if (user.getRole().equals(User.role2)) {
					mv.setViewName("UserView");
				}
				return mv;
			} else {
				mv.setViewName("login");
				mv.addObject("AuthenticationException", "Invalid Credentials");
			}
		}
		return mv;
	}

	@RequestMapping(path = "/edituser", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request, @RequestParam("id") int id) {

		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if (authenticatedUser.getRole().equals(User.role1)) {
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
	public ModelAndView saveUser(HttpServletRequest request, @RequestParam("id") int id,
			@ModelAttribute("UserForm") User user) {

		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if (authenticatedUser.getRole().equals(User.role1)) {
			userService.save(user);
			mv.addObject("operationStatus", "user saved successfully!");
			mv.addObject("displayAdd", true);
		} else {
			mv.addObject("invalidRoleException", "you are missing the privileges to perform this action");
			mv.addObject("displayAdd", false);
		}
		mv.addObject("users", userService.findAll());
		mv.setViewName("UserManagement");
		return mv;
	}

	@RequestMapping(path = "/deleteuser", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request, @RequestParam("id") long id) {

		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if (authenticatedUser.getRole().equals(User.role1)) {
			mv.addObject("displayAdd", true);
			if (authenticatedUser.getId() == id) {
				mv.addObject("operationStatus", "user could not be deleted");
			} else {
				userService.deleteById(id);
				mv.addObject("operationStatus", "user deleted successfully!");
			}
		} else {
			mv.addObject("invalidRoleException", "you are missing the privileges to perform this action");
			mv.addObject("displayAdd", false);
		}
		mv.addObject("users", userService.findAll());
		mv.setViewName("UserManagement");
		return mv;
	}

}
