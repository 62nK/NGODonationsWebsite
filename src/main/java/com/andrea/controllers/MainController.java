package com.andrea.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.andrea.model.info.GiftForm;
import com.andrea.model.info.UserLoginForm;
import com.ketu.model.beans.Donation;
import com.ketu.model.beans.User;
import com.tariq.models.services.DonationService;
import com.tariq.models.services.UserService;

@Controller
@Transactional
public class MainController {

	@Autowired
	UserService userService;
	@Autowired
	DonationService donationService;
	
	@Value("${exception.authentication.invalidUser}") 
	String invalidUser;
	@Value("${exception.authentication.invalidCredentials}") 
	String invalidCredentials;
	@Value("${exception.privileges.insufficientPrivileges}") 
	String insufficientPrivileges;
	@Value("${failure.user.deletion}") 
	String userDeletionFailure;
	@Value("${failure.user.edition}") 
	String userEditionFailure;
	@Value("${success.user.insertion}") 
	String userAdditionSuccess;
	@Value("${success.user.deletion}") 
	String userDeletionSuccess;
	@Value("${success.donation.emptylist}") 
	String emptyDonationList;
	@Value("${failure.donation.edition}") 
	String donationEditionFailure;
	@Value("${failure.donation.deletion}") 
	String donationDeletionFailure;
	@Value("${success.donation.insertion}") 
	String donationAdditionSuccess;
	@Value("${success.donation.deletion}") 
	String donationDeletionSuccess;
	
	@RequestMapping(path = "/")
	public ModelAndView validate(HttpServletRequest request,
			@ModelAttribute("UserLoginForm") UserLoginForm userLoginForm) {
		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if (authenticatedUser == null) {
			mv.setViewName("login");
		} else {
			if(authenticatedUser.getRole().equals(User.role1)) {
				mv.addObject("users", userService.findAll());
				mv.addObject("displayAdd", true);
				mv.setViewName("UserManagement");
			} else {
				List<Donation> donations = donationService.findAll();
				mv.addObject("donations", donations);
				if(donations.isEmpty())
					mv.addObject("Success", emptyDonationList);
				mv.setViewName("UserView");
			}
		}
		return mv;
	}
	@RequestMapping(path = "/usermanagement", method=RequestMethod.GET)
	public ModelAndView userManagement(HttpServletRequest request,
			@ModelAttribute("UserLoginForm") UserLoginForm userLoginForm) {
		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if (authenticatedUser == null) {
			mv.setViewName("login");
		} else {
			if(authenticatedUser.getRole().equals(User.role1)) {
				mv.addObject("users", userService.findAll());
				mv.addObject("displayAdd", true);
				mv.setViewName("UserManagement");
			} else {
				List<Donation> donations = donationService.findAll();
				mv.addObject("donations", donations);
				if(donations.isEmpty())
					mv.addObject("Success", emptyDonationList);
				mv.setViewName("UserView");
			}
		}
		return mv;
	}
	@RequestMapping(path = "/donationmanagement", method=RequestMethod.GET)
	public ModelAndView donationManagement(HttpServletRequest request,
			@ModelAttribute("UserLoginForm") UserLoginForm userLoginForm) {
		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if (authenticatedUser == null) {
			mv.setViewName("login");
		} else {
			if(authenticatedUser.getRole().equals(User.role1)) {
				List<Donation> donations = donationService.findAll();
				mv.addObject("donations", donations);
				if(donations.isEmpty())
					mv.addObject("Success", emptyDonationList);
				mv.addObject("displayAdd", true);
				mv.setViewName("DonationManagement");
			} else {
				List<Donation> donations = donationService.findAll();
				mv.addObject("donations", donations);
				if(donations.isEmpty())
					mv.addObject("Success", emptyDonationList);
				mv.setViewName("UserView");
			}
		}
		return mv;
	}
	@RequestMapping(path = "/userview", method=RequestMethod.GET)
	public ModelAndView userView(HttpServletRequest request,
			@ModelAttribute("UserLoginForm") UserLoginForm userLoginForm) {
		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if (authenticatedUser == null) {
			mv.setViewName("login");
		} else {
			List<Donation> donations = donationService.findAll();
			mv.addObject("donations", donations);
			if(donations.isEmpty())
				mv.addObject("Success", emptyDonationList);
			mv.setViewName("UserView");
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
			mv.addObject("Exception", insufficientPrivileges);
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
			mv.addObject("Exception", invalidUser);
		} else {
			if (user.getPassword().equals(userLoginForm.getPassword())) {
				request.getSession().setAttribute("authenticatedUser", user);
				if (user.getRole().equals(User.role1)) {
					mv.addObject("users", userService.findAll());
					mv.setViewName("UserManagement");
					mv.addObject("displayAdd", true);
				} else if (user.getRole().equals(User.role2)) {
					List<Donation> donations = donationService.findAll();
					mv.addObject("donations", donations);
					if(donations.isEmpty())
						mv.addObject("Exception", emptyDonationList);
					mv.setViewName("UserView");
				}
				return mv;
			} else {
				mv.setViewName("login");
				mv.addObject("Exception", invalidCredentials);
			}
		}
		return mv;
	}
	
	@RequestMapping(path = "/edituser", method = RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request, @ModelAttribute("UserInsertion") User newUser, @RequestParam("id") long id) {
		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if (authenticatedUser.getRole().equals(User.role1)) {
			User user = userService.findById(id);
			if (authenticatedUser.getId() == id) {
				mv.addObject("users", userService.findAll());
				mv.addObject("displayAdd", true);
				mv.addObject("Failure", userEditionFailure);
			} else {
				mv.addObject("newUser", user);
				mv.addObject("users", userService.findAll());
				mv.addObject("displayAdd", false);
			}
		} else {
			mv.addObject("Exception", insufficientPrivileges);
			mv.addObject("displayAdd", false);
		}
		mv.setViewName("UserManagement");
		return mv;
	}
	@RequestMapping(path = "/saveuser", method = RequestMethod.POST)
	public ModelAndView saveUser(HttpServletRequest request, @RequestParam("id") long id,
			@ModelAttribute("UserForm") User user) {

		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if (authenticatedUser.getRole().equals(User.role1)) {
			userService.save(user);
			if(authenticatedUser.getId() ==id)
				request.getSession().setAttribute("authenticatedUser", user);
			mv.addObject("Success", userAdditionSuccess);
			mv.addObject("displayAdd", true);
		} else {
			mv.addObject("Exception", insufficientPrivileges);
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
				mv.addObject("Failure", userDeletionFailure);
			} else {
				userService.deleteById(id);
				mv.addObject("Success", userDeletionSuccess);
			}
		} else {
			mv.addObject("Exception", insufficientPrivileges);
			mv.addObject("displayAdd", false);
		}
		mv.addObject("users", userService.findAll());
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

	//	Donations
	@RequestMapping(path = "/adddonation", method = RequestMethod.GET)
	public ModelAndView addDonation(HttpServletRequest request, @ModelAttribute("DonationInsertion") Donation newDonation) {
		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if (authenticatedUser.getRole().equals(User.role1)) {
			mv.addObject("newDonation", new Donation());
			List<Donation> donations = donationService.findAll();
			mv.addObject("donations", donations);
			if(donations.isEmpty())
				mv.addObject("Success", emptyDonationList);
		} else {
			mv.addObject("Exception", insufficientPrivileges);
		}
		mv.addObject("displayAdd", false);
		mv.setViewName("DonationManagement");
		return mv;
	}
	@RequestMapping(path = "/editdonation", method = RequestMethod.GET)
	public ModelAndView editDonation(HttpServletRequest request, @ModelAttribute("DonationInsertion") Donation newDonation, @RequestParam("id") long id) {
		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if (authenticatedUser.getRole().equals(User.role1)) {
			Donation donation = donationService.findById(id);
			if (authenticatedUser.getId() == id) {
				List<Donation> donations = donationService.findAll();
				mv.addObject("donations", donations);
				if(donations.isEmpty())
					mv.addObject("Success", emptyDonationList);
				mv.addObject("displayAdd", true);
				mv.addObject("Failure", donationEditionFailure);
			} else {
				mv.addObject("newDonation", donation);
				List<Donation> donations = donationService.findAll();
				mv.addObject("donations", donations);
				if(donations.isEmpty())
					mv.addObject("Success", emptyDonationList);
				mv.addObject("displayAdd", false);
			}
		} else {
			mv.addObject("Exception", insufficientPrivileges);
			mv.addObject("displayAdd", false);
		}
		mv.setViewName("DonationManagement");
		return mv;
	}
	@RequestMapping(path = "/deletedonation", method = RequestMethod.GET)
	public ModelAndView deleteDonation(HttpServletRequest request, @RequestParam("id") long id) {

		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if (authenticatedUser.getRole().equals(User.role1)) {
			mv.addObject("displayAdd", true);
			if (authenticatedUser.getId() == id) {
				mv.addObject("Failure", donationDeletionFailure);
			} else {
				donationService.deleteById(id);
				mv.addObject("Success", donationDeletionSuccess);
			}
		} else {
			mv.addObject("Exception", insufficientPrivileges);
			mv.addObject("displayAdd", false);
		}
		List<Donation> donations = donationService.findAll();
		mv.addObject("donations", donations);
		if(donations.isEmpty())
			mv.addObject("Success", emptyDonationList);
		mv.setViewName("DonationManagement");
		return mv;
	}
	@RequestMapping(path = "/savedonation", method = RequestMethod.POST)
	public ModelAndView saveDonation(HttpServletRequest request, @RequestParam("id") long id,
			@ModelAttribute("Donation") Donation donation) {

		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if (authenticatedUser.getRole().equals(User.role1)) {
			donationService.save(donation);
			mv.addObject("Success", donationAdditionSuccess);
			mv.addObject("displayAdd", true);
		} else {
			mv.addObject("Exception", insufficientPrivileges);
			mv.addObject("displayAdd", false);
		}
		List<Donation> donations = donationService.findAll();
		mv.addObject("donations", donations);
		if(donations.isEmpty())
			mv.addObject("Success", emptyDonationList);
		mv.setViewName("DonationManagement");
		return mv;
	}
	@RequestMapping(path="/makedonation", method=RequestMethod.POST)
	public ModelAndView makeDonation(HttpServletRequest request, @RequestParam("id") long id,
			@ModelAttribute("UserInfo") User user) {
		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		if (authenticatedUser!=null) {
			mv.addObject("userInfo", authenticatedUser);
			request.getSession().setAttribute("donationSelection", donationService.findById(id));
			mv.setViewName("personal");
		} else {
			mv.addObject("Exception", insufficientPrivileges);
			mv.setViewName("login");
		}
		return mv;
	}
	
	@RequestMapping(path="/makegift", method=RequestMethod.POST)
	public ModelAndView submitGifts(HttpServletRequest request, @RequestParam("action") String action, 
			@ModelAttribute("GiftForm") GiftForm sc) {
		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		Donation donation = (Donation) request.getSession().getAttribute("donationSelection");
		if (authenticatedUser!=null) {
			if(action.equals("continue")) {
				mv.addObject("userInfo", authenticatedUser);
				request.getSession().setAttribute("donationSelection", donation);
				mv.addObject("gifts", sc);
				mv.setViewName("shoppingCart");
			}else if(action.equals("cancel")) {
				List<Donation> donations = donationService.findAll();
				mv.addObject("donations", donations);
				if(donations.isEmpty())
					mv.addObject("Success", emptyDonationList);
				mv.setViewName("UserView");
			}
		} else {
			mv.addObject("Exception", insufficientPrivileges);
			mv.setViewName("login");
		}
		return mv;
	}
	@RequestMapping(path="/signout", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, @ModelAttribute("UserLoginForm") UserLoginForm userLoginForm) {
		request.getSession().invalidate();
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	@RequestMapping(path="/submituserinfo", method=RequestMethod.POST)
	public ModelAndView submitUserInfo(HttpServletRequest request, @RequestParam("action") String action,
			@ModelAttribute("GiftForm") GiftForm giftForm) {
		ModelAndView mv = new ModelAndView();
		User authenticatedUser = (User) request.getSession().getAttribute("authenticatedUser");
		Donation donation = (Donation) request.getSession().getAttribute("donationSelection");
		if (authenticatedUser!=null) {
			List<Donation> donations = donationService.findAll();
			mv.addObject("donations", donations);
			if(donations.isEmpty())
				mv.addObject("Success", emptyDonationList);
			if(action.equals("continue")) {
				mv.addObject("userInfo", authenticatedUser);
				request.getSession().setAttribute("donationSelection", donation);
				GiftForm gifts = new GiftForm();
				for(Donation d: donations) {
					gifts.put(d, 1d);
				}
				mv.addObject("gifts", gifts);
				mv.setViewName("gifts");
			}else if(action.equals("cancel")) {
				mv.setViewName("UserView");
			}
		} else {
			mv.addObject("Exception", insufficientPrivileges);
			mv.setViewName("login");
		}
		return mv;
	}
	
}
