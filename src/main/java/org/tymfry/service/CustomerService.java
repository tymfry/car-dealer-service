package org.tymfry.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.tymfry.dto.CustomerDto;
import org.tymfry.entity.Customer;
import org.tymfry.entity.User;
import org.tymfry.repository.CustomerRepository;
import org.tymfry.repository.UserRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private UserRepository userRepository;

	public List<CustomerDto> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerDto> customersDto = new ArrayList<>();
		for (Customer customer : customers) {
			CustomerDto customerDto = new CustomerDto();
			customerDto.setId(customer.getId());
			customerDto.setCustomerNumber(customer.getCustomerNumber());
			customerDto.setName(customer.getName());
			customerDto.setSurname(customer.getSurname());
			customerDto.setAddress(customer.getAddress());
			customerDto.setNip(customer.getNip());
			customerDto.setPesel(customer.getPesel());

			customersDto.add(customerDto);
		}
		return customersDto;
	}

	public void saveCustomer(CustomerDto customerDto) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String name = authentication.getName();

		Customer customer = new Customer();
		customer.setCustomerNumber(customerDto.getCustomerNumber());
		customer.setName(customerDto.getName());
		customer.setSurname(customerDto.getSurname());
		customer.setAddress(customerDto.getAddress());
		customer.setNip(customerDto.getNip());
		customer.setPesel(Long.valueOf(customerDto.getPesel()));
		customer.setTelephoneNumber(customerDto.getTelephoneNumber());
		
		User user = userRepository.findByUsername(name);
		user.setCustomer(customer);
		customer.setUser(user);
		
		customerRepository.save(customer);
		userRepository.save(user);
		

	}

}
