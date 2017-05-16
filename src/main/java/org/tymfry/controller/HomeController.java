package org.tymfry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView home(SecurityContextHolderAwareRequestWrapper request, ModelMap modelMap) {
//		boolean role = request.isUserInRole("ROLE_ADMIN");
//		modelMap.addAttribute("role", role);
//		return new ModelAndView("home", modelMap);
//	}

}
