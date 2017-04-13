package com.resume.controller;

import java.io.FileNotFoundException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.resume.model.UserModel;
import com.resume.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/userRegister")
	public ModelAndView userRegister(@ModelAttribute("user") UserModel user){
		System.out.println("Incoming Data:"+user.toString());
		ModelAndView result = new ModelAndView("Success");
		userService.userRegister(user);
		return result;
	}
	
	@RequestMapping("/register")
	public ModelAndView callRegister(){
		System.out.println("Loading Registration Page:");
		return new ModelAndView("register","user",new UserModel());
	}
	 
	@RequestMapping(value = "/staticPage", method = RequestMethod.GET)
	   public String redirect() {
	      return "redirect:/html/index.htm";
	   }
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(Locale locale, Model model) {
        // (...)

        return new ModelAndView("/someurl/resources/home.html");
	}
}
