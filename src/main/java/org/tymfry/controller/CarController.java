package org.tymfry.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tymfry.dto.CarDto;
import org.tymfry.service.CarService;

@Controller
public class CarController {

	@Autowired
	private CarService carService;

	@RequestMapping(value = "/sell-car", method = RequestMethod.GET)
	public ModelAndView sellCarByCustomerForm(ModelMap modelMap) {
		modelMap.addAttribute("carDto", new CarDto());
		return new ModelAndView("car/sellcar", modelMap);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/add-car/{type}", method = RequestMethod.GET)
	public ModelAndView addCarForm(@PathVariable("type") int type, ModelMap modelMap) {
		if (type == 1) {
			if (!modelMap.containsAttribute("carDto")) {
				String status = "userCession";
				boolean dealerCar = false;
				boolean accepted = false;
				int numberOfTestDrives = 0;
				modelMap.addAttribute("carDto", new CarDto());
				modelMap.addAttribute("status", status);
				modelMap.addAttribute("dealerCar", dealerCar);
				modelMap.addAttribute("accepted", accepted);
				modelMap.addAttribute("numberOfTestDrives", numberOfTestDrives);
			} else {
				String status = "userCession";
				boolean dealerCar = false;
				boolean accepted = false;
				int numberOfTestDrives = 0;
				modelMap.addAttribute("status", status);
				modelMap.addAttribute("dealerCar", dealerCar);
				modelMap.addAttribute("accepted", accepted);
				modelMap.addAttribute("numberOfTestDrives", numberOfTestDrives);
			}
		}
		if (type == 2) {
			if (!modelMap.containsAttribute("carDto")) {
				String status = "userSell";
				boolean dealerCar = true;
				boolean accepted = false;
				int numberOfTestDrives = 0;
				modelMap.addAttribute("carDto", new CarDto());
				modelMap.addAttribute("status", status);
				modelMap.addAttribute("dealerCar", dealerCar);
				modelMap.addAttribute("accepted", accepted);
				modelMap.addAttribute("numberOfTestDrives", numberOfTestDrives);
			} else {
				String status = "userSell";
				boolean dealerCar = true;
				boolean accepted = false;
				int numberOfTestDrives = 0;
				modelMap.addAttribute("status", status);
				modelMap.addAttribute("dealerCar", dealerCar);
				modelMap.addAttribute("accepted", accepted);
				modelMap.addAttribute("numberOfTestDrives", numberOfTestDrives);
			}
		}
		if (type == 3) {
			if (!modelMap.containsAttribute("carDto")) {
				String status = "employee";
				boolean accepted = true;
				modelMap.addAttribute("carDto", new CarDto());
				modelMap.addAttribute("status", status);
				modelMap.addAttribute("accepted", accepted);
			} else {
				String status = "employee";
				boolean accepted = true;
				modelMap.addAttribute("status", status);
				modelMap.addAttribute("accepted", accepted);
			}
		}
		return new ModelAndView("car/addcar", modelMap);
	}

	@RequestMapping(value = "/add-car", method = RequestMethod.POST)
	public String addCar(@ModelAttribute("carDto") @Valid CarDto carDto, BindingResult bindingResult, ModelMap modelMap,
			RedirectAttributes attr) {

		if (bindingResult.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.carDto", bindingResult);
			attr.addFlashAttribute("carDto", carDto);
			if (carDto.isDealerCar() == false && !carDto.isAccepted() ) {
				return "redirect:/add-car/1";
			}
			if (carDto.isDealerCar() == true) {
				return "redirect:/add-car/2";
			}
			if (carDto.isAccepted() == true) {
				return "redirect:/add-car/3";
			}
		}

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
	}// TODO możliwość edycji przed wystawieniem pojazdu do sprzedaży
		// (koniecznie kwota i reszta danych)

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
