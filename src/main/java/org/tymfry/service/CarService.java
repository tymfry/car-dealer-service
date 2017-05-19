package org.tymfry.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.tymfry.dto.CarDto;
import org.tymfry.entity.Car;
import org.tymfry.entity.Customer;
import org.tymfry.entity.User;
import org.tymfry.repository.CarRepository;
import org.tymfry.repository.CustomerRepository;
import org.tymfry.repository.UserRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	@Autowired
	private AgreementService agreementService;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private UserRepository userRepository;

	public void saveCar(CarDto carDto) {
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
		car.setValue(carDto.getValue());
		car.setOldValue(carDto.getValue());
		car.setTypeOfVehicle(carDto.getTypeOfVehicle());
		car.setActive(true);
		car.setDealerCar(carDto.isDealerCar());
		car.setAccepted(carDto.isAccepted());

		if (carDto.isDealerCar() == false) {
			Customer customer = new Customer();
			customer.setCar(car);
			customer.setName(carDto.getName());
			customer.setSurname(carDto.getSurname());
			customer.setAddress(carDto.getAddress());
			customer.setPesel(Long.valueOf(carDto.getPesel()));
			customer.setNip(carDto.getNip());
			customer.setTelephoneNumber(carDto.getTelephoneNumber());
			car.setCustomer(customer);
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String name = authentication.getName();
			User user = userRepository.findByUsername(name);
			user.setCustomer(customer);
			customer.setUser(user);
			
			customerRepository.save(customer);
			userRepository.save(user);
			
		}
		carRepository.save(car);

	}

	public List<CarDto> getAllCars() {
		List<Car> cars = carRepository.findAll();
		List<CarDto> carsDto = new ArrayList<>();
		for (Car car : cars) {
			if (car.isActive() == true && car.isAccepted() == true) {
				CarDto carDto = new CarDto();
				carDto.setId(car.getId());
				carDto.setVin(String.valueOf(car.getVin()));
				carDto.setYearOfProduction(car.getYearOfProduction());
				carDto.setBrand(car.getBrand());
				carDto.setModel(car.getModel());
				carDto.setInsurancePolicyNumber(String.valueOf(car.getInsurancePolicyNumber()));
				carDto.setRegistrationNumber(car.getRegistrationNumber());
				carDto.setTypeOfFuel(car.getTypeOfFuel());
				carDto.setMileage(car.getMileage());
				carDto.setCcm(car.getCcm());
				carDto.setHorsePower(car.getHorsePower());
				carDto.setGearbox(car.getGearbox());
				carDto.setDescription(car.getDescription());
				carDto.setNumberOfTestDrives(car.getNumberOfTestDrives());
				carDto.setValue(car.getValue());
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
				carDto.setYearOfProduction(car.getYearOfProduction());
				carDto.setBrand(car.getBrand());
				carDto.setModel(car.getModel());
				carDto.setInsurancePolicyNumber(String.valueOf(car.getInsurancePolicyNumber()));
				carDto.setRegistrationNumber(car.getRegistrationNumber());
				carDto.setTypeOfFuel(car.getTypeOfFuel());
				carDto.setMileage(car.getMileage());
				carDto.setCcm(car.getCcm());
				carDto.setHorsePower(car.getHorsePower());
				carDto.setGearbox(car.getGearbox());
				carDto.setDescription(car.getDescription());
				carDto.setNumberOfTestDrives(car.getNumberOfTestDrives());
				carDto.setValue(car.getValue());
				carDto.setTypeOfVehicle(car.getTypeOfVehicle());
				carDto.setDealerCar(car.isDealerCar());

				soldCarsDto.add(carDto);
			}
		}
		return soldCarsDto;

	}

	// do usunięcia
	public List<CarDto> getAllCarsForCustomers() {
		List<Car> cars = carRepository.findAll();
		List<CarDto> soldCarsDto = new ArrayList<>();
		for (Car car : cars) {
			if (car.isActive() == true && car.isAccepted() == true) {
				CarDto carDto = new CarDto();
				carDto.setId(car.getId());
				carDto.setVin(car.getVin());
				carDto.setYearOfProduction(car.getYearOfProduction());
				carDto.setBrand(car.getBrand());
				carDto.setModel(car.getModel());
				carDto.setInsurancePolicyNumber(String.valueOf(car.getInsurancePolicyNumber()));
				carDto.setRegistrationNumber(car.getRegistrationNumber());
				carDto.setTypeOfFuel(car.getTypeOfFuel());
				carDto.setMileage(car.getMileage());
				carDto.setCcm(car.getCcm());
				carDto.setHorsePower(car.getHorsePower());
				carDto.setGearbox(car.getGearbox());
				carDto.setDescription(car.getDescription());
				carDto.setNumberOfTestDrives(car.getNumberOfTestDrives());
				carDto.setValue(car.getValue());
				carDto.setTypeOfVehicle(car.getTypeOfVehicle());
				carDto.setDealerCar(car.isDealerCar());

				soldCarsDto.add(carDto);
			}
		}
		return soldCarsDto;

	}

	public List<CarDto> getAllCarsForApproval() {
		List<Car> cars = carRepository.findAll();
		List<CarDto> soldCarsDto = new ArrayList<>();
		for (Car car : cars) {
			if (car.isActive() == true && car.isAccepted() == false) {
				CarDto carDto = new CarDto();
				carDto.setId(car.getId());
				carDto.setVin(car.getVin());
				carDto.setYearOfProduction(car.getYearOfProduction());
				carDto.setBrand(car.getBrand());
				carDto.setModel(car.getModel());
				carDto.setInsurancePolicyNumber(String.valueOf(car.getInsurancePolicyNumber()));
				carDto.setRegistrationNumber(car.getRegistrationNumber());
				carDto.setTypeOfFuel(car.getTypeOfFuel());
				carDto.setMileage(car.getMileage());
				carDto.setCcm(car.getCcm());
				carDto.setHorsePower(car.getHorsePower());
				carDto.setGearbox(car.getGearbox());
				carDto.setDescription(car.getDescription());
				carDto.setNumberOfTestDrives(car.getNumberOfTestDrives());
				carDto.setValue(car.getValue());
				carDto.setTypeOfVehicle(car.getTypeOfVehicle());
				carDto.setDealerCar(car.isDealerCar());

				soldCarsDto.add(carDto);
			}
		}
		return soldCarsDto;

	}

	public void approveCar(int id) {
		Car car = carRepository.getCarById(id);
		car.setAccepted(true);
		if (car.isDealerCar() == true) {
			agreementService.buyCarAsDealer(id, "content"); //  umowa kupna
															// pojazdu jako
															// dealer
		} else {
			agreementService.cessionForDealer(id, "content"); //  umowa
																// odstąpienia
																// pojazdu
		}
		carRepository.save(car);
	}

	public void setValue(CarDto carDto) {
		Car car = carRepository.getCarById(carDto.getId());
		car.setValue(carDto.getValue());
		carRepository.save(car);
	}

	/*
	 * A method that saves the car from customer.
	 */

	/*
	 * Get car from data base by id.
	 */
	public CarDto getCarById(int id) {
		Car car = carRepository.getCarById(id);
		CarDto carDto = new CarDto();
		carDto.setId(car.getId());
		carDto.setVin(String.valueOf(car.getVin()));
		carDto.setYearOfProduction(car.getYearOfProduction());
		carDto.setBrand(car.getBrand());
		carDto.setModel(car.getModel());
		carDto.setInsurancePolicyNumber(String.valueOf(car.getInsurancePolicyNumber()));
		carDto.setRegistrationNumber(car.getRegistrationNumber());
		carDto.setTypeOfFuel(car.getTypeOfFuel());
		carDto.setMileage(car.getMileage());
		carDto.setCcm(car.getCcm());
		carDto.setHorsePower(car.getHorsePower());
		carDto.setGearbox(car.getGearbox());
		carDto.setDescription(car.getDescription());
		carDto.setNumberOfTestDrives(car.getNumberOfTestDrives());
		carDto.setValue(car.getValue());
		carDto.setTypeOfVehicle(car.getTypeOfVehicle());
		carDto.setDealerCar(car.isDealerCar());
		if (car.isDealerCar() == false) {
			carDto.setTelephoneNumber(car.getCustomer().getTelephoneNumber());
		}
		return carDto;
	}

	public List<CarDto> getAllDealerCars() {
		List<Car> cars = carRepository.findAll();
		List<CarDto> soldCarsDto = new ArrayList<>();
		for (Car car : cars) {
			if (car.isActive() == true && car.isDealerCar() == true && car.isAccepted() == true) {
				CarDto carDto = new CarDto();
				carDto.setId(car.getId());
				carDto.setVin(car.getVin());
				carDto.setYearOfProduction(car.getYearOfProduction());
				carDto.setBrand(car.getBrand());
				carDto.setModel(car.getModel());
				carDto.setInsurancePolicyNumber(String.valueOf(car.getInsurancePolicyNumber()));
				carDto.setRegistrationNumber(car.getRegistrationNumber());
				carDto.setTypeOfFuel(car.getTypeOfFuel());
				carDto.setMileage(car.getMileage());
				carDto.setCcm(car.getCcm());
				carDto.setHorsePower(car.getHorsePower());
				carDto.setGearbox(car.getGearbox());
				carDto.setDescription(car.getDescription());
				carDto.setNumberOfTestDrives(car.getNumberOfTestDrives());
				carDto.setValue(car.getValue());
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
			if (car.isActive() == true && car.isDealerCar() == false && car.isAccepted() == true) {
				CarDto carDto = new CarDto();
				carDto.setId(car.getId());
				carDto.setVin(car.getVin());
				carDto.setYearOfProduction(car.getYearOfProduction());
				carDto.setBrand(car.getBrand());
				carDto.setModel(car.getModel());
				carDto.setInsurancePolicyNumber(String.valueOf(car.getInsurancePolicyNumber()));
				carDto.setRegistrationNumber(car.getRegistrationNumber());
				carDto.setTypeOfFuel(car.getTypeOfFuel());
				carDto.setMileage(car.getMileage());
				carDto.setCcm(car.getCcm());
				carDto.setHorsePower(car.getHorsePower());
				carDto.setGearbox(car.getGearbox());
				carDto.setDescription(car.getDescription());
				carDto.setNumberOfTestDrives(car.getNumberOfTestDrives());
				carDto.setValue(car.getValue());
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
		agreementService.sellCar(id, "content");
	}
	
	public CarDto getUserCar() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String name = authentication.getName();
		User user = userRepository.findByUsername(name);
		Car car = user.getCustomer().getCar();
		CarDto carDto = new CarDto();
		carDto.setId(car.getId());
		carDto.setVin(car.getVin());
		carDto.setYearOfProduction(car.getYearOfProduction());
		carDto.setBrand(car.getBrand());
		carDto.setModel(car.getModel());
		carDto.setInsurancePolicyNumber(String.valueOf(car.getInsurancePolicyNumber()));
		carDto.setRegistrationNumber(car.getRegistrationNumber());
		carDto.setTypeOfFuel(car.getTypeOfFuel());
		carDto.setMileage(car.getMileage());
		carDto.setCcm(car.getCcm());
		carDto.setHorsePower(car.getHorsePower());
		carDto.setGearbox(car.getGearbox());
		carDto.setDescription(car.getDescription());
		carDto.setNumberOfTestDrives(car.getNumberOfTestDrives());
		carDto.setValue(car.getValue());
		carDto.setTypeOfVehicle(car.getTypeOfVehicle());
		carDto.setDealerCar(car.isDealerCar());
		
		return carDto;
		
	}

}
