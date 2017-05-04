package org.tymfry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.tymfry.dto.CarDto;
import org.tymfry.service.CarService;

@Controller
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@RequestMapping(value = "/show-all-cars", method = RequestMethod.GET)
	public ModelAndView showAllCars(ModelMap modelMap) {
		modelMap.addAttribute("carDto", carService.getAllCars());
		return new ModelAndView("car/allcars", modelMap);
	}
	
	@RequestMapping(value = "/add-car", method = RequestMethod.GET)
	public ModelAndView showAddCarForm(ModelMap modelMap) {
		modelMap.addAttribute("carDto", new CarDto());
		return new ModelAndView("car/addcar", modelMap);
	}

}
