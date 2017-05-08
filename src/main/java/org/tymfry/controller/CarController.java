package org.tymfry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/add-car-by-customer", method = RequestMethod.GET)
	public ModelAndView showAddCarFormToCustomer(ModelMap modelMap) {
		boolean status = false;
		modelMap.addAttribute("carDto", new CarDto());
		modelMap.addAttribute("dealerCar", status);
		modelMap.addAttribute("accepted", status);
		return new ModelAndView("customer/addcarbycustomer", modelMap);
	}

	@RequestMapping(value = "/sell-car-by-customer", method = RequestMethod.GET)
	public ModelAndView showSellCarFormToCustomer(ModelMap modelMap) {
		boolean status = true;
		boolean active = false;
		modelMap.addAttribute("carDto", new CarDto());
		modelMap.addAttribute("dealerCar", status);
		modelMap.addAttribute("active", active);
		return new ModelAndView("customer/sellcarbycustomer", modelMap);
	}

	@RequestMapping(value = "/add-car", method = RequestMethod.GET)
	public ModelAndView showAddCarForm(ModelMap modelMap) {
		modelMap.addAttribute("carDto", new CarDto());
		return new ModelAndView("car/addcar", modelMap);
	}

	@RequestMapping(value = "/add-car", method = RequestMethod.POST)
	public String addCar(@ModelAttribute("carDto") CarDto carDto, ModelMap modelMap) {
		List<CarDto> soldCars = carService.getAllSoldCars();
		for (CarDto car : soldCars) {
			if (carDto.getVin().equals(car.getVin())) {
				System.out.println("yes");
			}
		}

		List<CarDto> presentCars = carService.getAllCars();
		for (CarDto car : presentCars) {
			if (carDto.getVin().equals(car.getVin())) {
				System.out.println("yes");
			}
		}

		carService.sellToDealer(carDto);
		return "redirect:/show-all-cars";
	}

	@RequestMapping(value = "/car-details/{id}", method = RequestMethod.GET)
	public ModelAndView carDetails(@PathVariable("id") int id, ModelMap modelMap) {
		CarDto carDto = carService.getCarById(id);
		modelMap.addAttribute("carDto", carDto);
		return new ModelAndView("car/cardetails", modelMap);
	}

	@RequestMapping(value = "/show-all-sold-cars", method = RequestMethod.GET)
	public ModelAndView showAllSoldCars(ModelMap modelMap) {
		modelMap.addAttribute("carDto", carService.getAllSoldCars());
		return new ModelAndView("car/soldcars", modelMap);
	}

	@RequestMapping(value = "/sell-car/{id}", method = RequestMethod.GET)
	public String sellCar(@PathVariable("id") int id) {
		carService.sellCar(id);
		return "redirect:/show-all-cars";
	}

	@RequestMapping(value = "/show-all-cessioned-cars", method = RequestMethod.GET)
	public ModelAndView showAllCessionedCars(ModelMap modelMap) {
		modelMap.addAttribute("carDto", carService.getAllCessionedCars());
		return new ModelAndView("car/cessionedcars", modelMap);
	}

	@RequestMapping(value = "/show-all-customer-cars", method = RequestMethod.GET)
	public ModelAndView showAllCustomerCars(ModelMap modelMap) {
		modelMap.addAttribute("carDto", carService.getAllCustomerCars());
		return new ModelAndView("car/customercars", modelMap);
	}

}
