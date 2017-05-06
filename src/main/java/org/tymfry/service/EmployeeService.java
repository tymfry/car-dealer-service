package org.tymfry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tymfry.entity.Car;
import org.tymfry.entity.Customer;
import org.tymfry.repository.CarRepository;
import org.tymfry.repository.CustomerRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
	public void addCarToCustomer(int customerId, int carId) {
		Customer customer = customerRepository.findOne(customerId);
		Car car = carRepository.findOne(carId);
		customer.setCar(car);
		
		customerRepository.save(customer);
		
	}

}
