package org.tymfry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	public String register(@ModelAttribute("userDto") UserDto userDto) {
		userService.saveUser(userDto);
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "log/login";
	}
}
