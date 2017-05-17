package org.tymfry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.tymfry.dto.CustomerDto;
import org.tymfry.repository.UserRepository;

@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelMap modelMap) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String name = authentication.getName();

			if (userRepository.findByUsername(name).getCustomer() == null) {
				modelMap.addAttribute("customerDto", new CustomerDto());
				return new ModelAndView("customer/addcustomer", modelMap);
			} else {
				modelMap.addAttribute("name", name);
				return new ModelAndView("home", modelMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("home", modelMap);
	}

}
