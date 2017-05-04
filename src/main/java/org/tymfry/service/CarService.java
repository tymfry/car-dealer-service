package org.tymfry.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tymfry.dto.CarDto;
import org.tymfry.entity.Car;
import org.tymfry.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	public List<CarDto> getAllCars() {
		List<Car> cars = carRepository.findAll();
		List<CarDto> carsDto = new ArrayList<>();
		for (Car car : cars) {
			CarDto carDto = new CarDto();
			carDto.setId(car.getId());
			carDto.setVin(car.getVin());
			carDto.setYearOfProduction(car.getYearOfProduction());
			carDto.setBrand(car.getBrand());
			carDto.setModel(car.getModel());
			carDto.setInsurancePolicyNumber(car.getInsurancePolicyNumber());
			carDto.setRegistrationNumber(car.getRegistrationNumber());
			carDto.setTypeOfFuel(car.getTypeOfFuel());
			carDto.setMileage(car.getMileage());
			carDto.setCcm(car.getCcm());
			carDto.setHorsePower(car.getHorsePower());
			carDto.setGearbox(car.getGearbox());
			carDto.setDescription(car.getDescription());
			carDto.setNumberOfTestDrives(car.getNumberOfTestDrives());
			carDto.setValue(car.getValue());
			
			carsDto.add(carDto);
		}
		return carsDto;
	}

}
