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
			if (car.isActive() == true) {
				CarDto carDto = new CarDto();
				carDto.setId(car.getId());
				carDto.setVin(String.valueOf(car.getVin()));
				carDto.setYearOfProduction(String.valueOf(car.getYearOfProduction()));
				carDto.setBrand(car.getBrand());
				carDto.setModel(car.getModel());
				carDto.setInsurancePolicyNumber(String.valueOf(car.getInsurancePolicyNumber()));
				carDto.setRegistrationNumber(car.getRegistrationNumber());
				carDto.setTypeOfFuel(car.getTypeOfFuel());
				carDto.setMileage(String.valueOf(car.getMileage()));
				carDto.setCcm(String.valueOf(car.getCcm()));
				carDto.setHorsePower(String.valueOf(car.getHorsePower()));
				carDto.setGearbox(car.getGearbox());
				carDto.setDescription(car.getDescription());
				carDto.setNumberOfTestDrives(String.valueOf(car.getNumberOfTestDrives()));
				carDto.setValue(String.valueOf(car.getValue()));
				carDto.setTypeOfVehicle(car.getTypeOfVehicle());
				carDto.setDealerCar(car.isDealerCar());

				carsDto.add(carDto);
			}
		}
		return carsDto;
	}

	public List<CarDto> getAllSoldCars() {
		List<Car> cars = carRepository.findAll();
		List<CarDto> soldCarsDto = new ArrayList<>();
		for (Car car : cars) {
			if (car.isActive() == false) {
				CarDto carDto = new CarDto();
				carDto.setId(car.getId());
				carDto.setVin(car.getVin());
				carDto.setYearOfProduction(String.valueOf(car.getYearOfProduction()));
				carDto.setBrand(car.getBrand());
				carDto.setModel(car.getModel());
				carDto.setInsurancePolicyNumber(String.valueOf(car.getInsurancePolicyNumber()));
				carDto.setRegistrationNumber(car.getRegistrationNumber());
				carDto.setTypeOfFuel(car.getTypeOfFuel());
				carDto.setMileage(String.valueOf(car.getMileage()));
				carDto.setCcm(String.valueOf(car.getCcm()));
				carDto.setHorsePower(String.valueOf(car.getHorsePower()));
				carDto.setGearbox(car.getGearbox());
				carDto.setDescription(car.getDescription());
				carDto.setNumberOfTestDrives(String.valueOf(car.getNumberOfTestDrives()));
				carDto.setValue(String.valueOf(car.getValue()));
				carDto.setTypeOfVehicle(car.getTypeOfVehicle());
				carDto.setDealerCar(car.isDealerCar());

				soldCarsDto.add(carDto);
			}
		}
		return soldCarsDto;

	}

	public void sellCar(int id) {
		Car car = carRepository.getCarById(id);
		car.setActive(false);
		carRepository.save(car);
	}

	/*
	 * A method that saves the car from customer.
	 */

	public void sellToDealer(CarDto carDto) {
		Car car = new Car();
		car.setVin(carDto.getVin());
		car.setYearOfProduction(Integer.valueOf(carDto.getYearOfProduction()));
		car.setBrand(carDto.getBrand());
		car.setModel(carDto.getModel());
		car.setInsurancePolicyNumber(Long.valueOf(carDto.getInsurancePolicyNumber()));
		car.setRegistrationNumber(carDto.getRegistrationNumber());
		car.setTypeOfFuel(carDto.getTypeOfFuel());
		car.setMileage(Integer.valueOf(carDto.getMileage()));
		car.setCcm(Integer.valueOf(carDto.getCcm()));
		car.setHorsePower(Integer.valueOf(carDto.getHorsePower()));
		car.setGearbox(carDto.getGearbox());
		car.setDescription(carDto.getDescription());
		car.setNumberOfTestDrives(Integer.valueOf(carDto.getNumberOfTestDrives()));
		car.setValue(Double.valueOf(carDto.getValue()));
		car.setTypeOfVehicle(carDto.getTypeOfVehicle());
		car.setActive(true);
		car.setDealerCar(carDto.isDealerCar());

		carRepository.save(car);
	}

	/*
	 * Get car from data base by id.
	 */
	public CarDto getCarById(int id) {
		Car car = carRepository.getCarById(id);
		CarDto carDto = new CarDto();
		carDto.setId(car.getId());
		carDto.setVin(String.valueOf(car.getVin()));
		carDto.setYearOfProduction(String.valueOf(car.getYearOfProduction()));
		carDto.setBrand(car.getBrand());
		carDto.setModel(car.getModel());
		carDto.setInsurancePolicyNumber(String.valueOf(car.getInsurancePolicyNumber()));
		carDto.setRegistrationNumber(car.getRegistrationNumber());
		carDto.setTypeOfFuel(car.getTypeOfFuel());
		carDto.setMileage(String.valueOf(car.getMileage()));
		carDto.setCcm(String.valueOf(car.getCcm()));
		carDto.setHorsePower(String.valueOf(car.getHorsePower()));
		carDto.setGearbox(car.getGearbox());
		carDto.setDescription(car.getDescription());
		carDto.setNumberOfTestDrives(String.valueOf(car.getNumberOfTestDrives()));
		carDto.setValue(String.valueOf(car.getValue()));
		carDto.setTypeOfVehicle(car.getTypeOfVehicle());
		carDto.setDealerCar(car.isDealerCar());
		
		return carDto;
	}
	
	public List<CarDto> getAllCessionedCars() {
		List<Car> cars = carRepository.findAll();
		List<CarDto> soldCarsDto = new ArrayList<>();
		for (Car car : cars) {
			if (car.isActive() == true && car.isDealerCar() == true) {
				CarDto carDto = new CarDto();
				carDto.setId(car.getId());
				carDto.setVin(car.getVin());
				carDto.setYearOfProduction(String.valueOf(car.getYearOfProduction()));
				carDto.setBrand(car.getBrand());
				carDto.setModel(car.getModel());
				carDto.setInsurancePolicyNumber(String.valueOf(car.getInsurancePolicyNumber()));
				carDto.setRegistrationNumber(car.getRegistrationNumber());
				carDto.setTypeOfFuel(car.getTypeOfFuel());
				carDto.setMileage(String.valueOf(car.getMileage()));
				carDto.setCcm(String.valueOf(car.getCcm()));
				carDto.setHorsePower(String.valueOf(car.getHorsePower()));
				carDto.setGearbox(car.getGearbox());
				carDto.setDescription(car.getDescription());
				carDto.setNumberOfTestDrives(String.valueOf(car.getNumberOfTestDrives()));
				carDto.setValue(String.valueOf(car.getValue()));
				carDto.setTypeOfVehicle(car.getTypeOfVehicle());
				carDto.setDealerCar(car.isDealerCar());

				soldCarsDto.add(carDto);
			}
		}
		return soldCarsDto;

	}
	
	public List<CarDto> getAllCustomerCars() {
		List<Car> cars = carRepository.findAll();
		List<CarDto> soldCarsDto = new ArrayList<>();
		for (Car car : cars) {
			if (car.isActive() == true && car.isDealerCar() == false) {
				CarDto carDto = new CarDto();
				carDto.setId(car.getId());
				carDto.setVin(car.getVin());
				carDto.setYearOfProduction(String.valueOf(car.getYearOfProduction()));
				carDto.setBrand(car.getBrand());
				carDto.setModel(car.getModel());
				carDto.setInsurancePolicyNumber(String.valueOf(car.getInsurancePolicyNumber()));
				carDto.setRegistrationNumber(car.getRegistrationNumber());
				carDto.setTypeOfFuel(car.getTypeOfFuel());
				carDto.setMileage(String.valueOf(car.getMileage()));
				carDto.setCcm(String.valueOf(car.getCcm()));
				carDto.setHorsePower(String.valueOf(car.getHorsePower()));
				carDto.setGearbox(car.getGearbox());
				carDto.setDescription(car.getDescription());
				carDto.setNumberOfTestDrives(String.valueOf(car.getNumberOfTestDrives()));
				carDto.setValue(String.valueOf(car.getValue()));
				carDto.setTypeOfVehicle(car.getTypeOfVehicle());
				carDto.setDealerCar(car.isDealerCar());

				soldCarsDto.add(carDto);
			}
		}
		return soldCarsDto;

	}
	

}
