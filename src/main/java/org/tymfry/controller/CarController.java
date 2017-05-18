package org.tymfry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.tymfry.dto.CarDto;
import org.tymfry.entity.Customer;
import org.tymfry.repository.UserRepository;
import org.tymfry.service.AgreementService;
import org.tymfry.service.CarService;

@Controller
public class CarController {

	@Autowired
	private CarService carService;
	@Autowired
	private AgreementService agreementService;
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/add-car/{type}", method = RequestMethod.GET)
	public ModelAndView addCarForm(@PathVariable("type") int type, ModelMap modelMap) {
		if (type == 1) {
			String status = "userCession";
			boolean dealerCar = false;
			boolean accepted = false;
			int numberOfTestDrives = 0;
			modelMap.addAttribute("carDto", new CarDto());
			modelMap.addAttribute("status", status);
			modelMap.addAttribute("dealerCar", dealerCar);
			modelMap.addAttribute("accepted", accepted);
			modelMap.addAttribute("numberOfTestDrives", numberOfTestDrives);
		}
		if (type == 2) {
			String status = "userSell";
			boolean dealerCar = true;
			boolean accepted = false;
			int numberOfTestDrives = 0;
			modelMap.addAttribute("carDto", new CarDto());
			modelMap.addAttribute("status", status);
			modelMap.addAttribute("dealerCar", dealerCar);
			modelMap.addAttribute("accepted", accepted);
			modelMap.addAttribute("numberOfTestDrives", numberOfTestDrives);
		}
		if (type == 3) {
			String status = "employee";
			modelMap.addAttribute("carDto", new CarDto());
			modelMap.addAttribute("status", status);
		}
		return new ModelAndView("car/addcar", modelMap);
	}

	@RequestMapping(value = "/add-car", method = RequestMethod.POST)
	public String addCar(@ModelAttribute("carDto") CarDto carDto) {
		List<CarDto> soldCars = carService.getAllSoldCars();
		for (CarDto car : soldCars) {
			if (carDto.getVin().equals(car.getVin())) {
				// TODO komunikat o samochodzie który nie może zostać ponownie
				// zakupiony przez komis
			}
		}

		List<CarDto> presentCars = carService.getAllCars();
		for (CarDto car : presentCars) {
			if (carDto.getVin().equals(car.getVin())) {
				// TODO komunikat o duplikacie pojazdu w widoku
			}
		}
		carService.saveCar(carDto);
		return "redirect:/show-cars/1";
	}

	@RequestMapping(value = "/show-cars/{type}", method = RequestMethod.GET)
	public ModelAndView showAllCars(@PathVariable("type") int type, ModelMap modelMap) {
		if (type == 1) {
			String status = "customersCars";
			modelMap.addAttribute("carDto", carService.getAllCustomerCars());
			modelMap.addAttribute("status", status);
		}
		if (type == 2) {
			String status = "dealerCars";
			modelMap.addAttribute("carDto", carService.getAllDealerCars());
			modelMap.addAttribute("status", status);
		}
		if (type == 3) {
			modelMap.addAttribute("carDto", carService.getAllSoldCars());
		}                                                                 
		if (type == 4) {
			String status = "employee";
			modelMap.addAttribute("carDto", carService.getAllCarsForApproval());
			modelMap.addAttribute("status", status);
		}
		if (type == 5) {
			String status = "userCar";
			modelMap.addAttribute("carDto", carService.getUserCar());
			modelMap.addAttribute("status", status);
			return new ModelAndView("car/cardetailsforcustomer", modelMap);
		}
		
		return new ModelAndView("car/showcars", modelMap);
	}
	
	@RequestMapping(value = "/show-all-cars-to-sell", method = RequestMethod.GET)
	public ModelAndView getAllCarsToSell(ModelMap modelMap) {
		modelMap.addAttribute("carDto", carService.getAllCars());
		return new ModelAndView("car/allcarstosell", modelMap);
	}

	@RequestMapping(value = "/car-details/{id}", method = RequestMethod.GET)
	public ModelAndView carDetailsForCustomer(@PathVariable("id") int id, ModelMap modelMap) {
		CarDto carDto = carService.getCarById(id);
		modelMap.addAttribute("carDto", carDto);
		return new ModelAndView("car/cardetailsforcustomer", modelMap);
	}
	
	@RequestMapping(value = "/car-details-employee/{id}", method = RequestMethod.GET)
	public ModelAndView carDetailsForEmployee(@PathVariable("id") int id, ModelMap modelMap) {
		CarDto carDto = carService.getCarById(id);
		modelMap.addAttribute("carDto", carDto);
		return new ModelAndView("car/cardetailsforemployee", modelMap);
	}//TODO możliwość edycji przed wystawieniem pojazdu do sprzedaży (koniecznie kwota i reszta danych)
	
	@RequestMapping(value = "/approve-car/{id}", method = RequestMethod.GET)
	public String sellCar(@PathVariable("id") int id) {
		carService.approveCar(id);
		return "redirect:/show-cars/4";
	}
	
	@RequestMapping(value = "/car-details-sell/{id}", method = RequestMethod.GET)
	public ModelAndView carDetailsSell(@PathVariable("id") int id, ModelMap modelMap) {
		CarDto carDto = carService.getCarById(id);
		modelMap.addAttribute("carDto", carDto);
		return new ModelAndView("car/selldetails", modelMap);
	}
	
	@RequestMapping(value = "/sell-car/{id}", method = RequestMethod.GET)
	public String sellCar(@PathVariable("id") int id, ModelMap modelMap) {
		carService.sellCar(id);
		return "redirect:/show-all-cars-to-sell";
		
	}

}
