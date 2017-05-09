package org.tymfry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.tymfry.dto.CarDto;

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
	}
}
