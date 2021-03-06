package org.tymfry.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.tymfry.dto.UserDto;
import org.tymfry.service.UserService;

@Controller
public class AccessController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	private ModelAndView registration(ModelMap modelMap) {
		modelMap.addAttribute("userDto", new UserDto());
		return new ModelAndView("log/registration", modelMap);
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String register(@ModelAttribute("userDto") @Valid UserDto userDto, BindingResult bindingResult, HttpServletRequest request) {
		
		if (bindingResult.hasErrors()) {
			return "log/registration";
		}
		userService.saveUser(userDto);
		try {
			request.login(userDto.getUsername(),userDto.getPassword());
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {	
		return "log/login";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
}
