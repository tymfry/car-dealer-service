package org.tymfry.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.tymfry.dto.CarDto;
import org.tymfry.dto.CustomerDto;

@Controller
public class TestController {

	@RequestMapping("/new")
	public String home() {
		return "new/home";
	}
	
	@RequestMapping(value = "/add-car-new", method = RequestMethod.GET)
	public ModelAndView showAddCarForm(ModelMap modelMap) {
		modelMap.addAttribute("carDto", new CarDto());
		return new ModelAndView("new/car/addcar", modelMap);
		
		//HttpServletRequestWrapper request = new HttpServletRequestWrapper(request).ge
	}
	
	@GetMapping("/adduser")
	public ModelAndView addUser(ModelMap modelMap) {
		modelMap.addAttribute("customerDto", new CustomerDto());
		return new ModelAndView("customer/addcustomer", modelMap);
	}
	
	@PostMapping("/adduser")
	public ModelAndView saveUser(@ModelAttribute("customerDto") @Valid CustomerDto customerDto, BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("customer/addcustomer");
		}
		return new ModelAndView("redirect:/");
	}
}
