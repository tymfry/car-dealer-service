package org.tymfry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.tymfry.service.CarService;
import org.tymfry.service.EmployeeService;

@Controller
public class ActionsController {
	
	@Autowired
	private CarService carService;
	@Autowired
	private EmployeeService employeeService;
	
	

@RequestMapping(value = "/add-car-to-customer/{id}", method = RequestMethod.GET)
public ModelAndView getCustomerId(@PathVariable("id") Integer id, ModelMap modelMap) {
	 modelMap.addAttribute("customerId", id);
	 modelMap.addAttribute("carDto", carService.getAllCars());
	 return new ModelAndView("actions/assigncartocustomer", modelMap);
}

@RequestMapping(value = "/add-car-to-customer", method = RequestMethod.GET)
public String addPersonToInsurance(@RequestParam("customerId") int customerId, @RequestParam("carId") int carId) {
	employeeService.addCarToCustomer(customerId, carId);
	return "redirect:/";
}
	
}