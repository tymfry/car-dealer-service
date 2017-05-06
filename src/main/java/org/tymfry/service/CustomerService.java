package org.tymfry.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tymfry.dto.CustomerDto;
import org.tymfry.entity.Customer;
import org.tymfry.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

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
			customerDto.setPesel(String.valueOf(customer.getPesel()));

			customersDto.add(customerDto);
		}
		return customersDto;
	}

	public void saveCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setCustomerNumber(customerDto.getCustomerNumber());
		customer.setName(customerDto.getName());
		customer.setSurname(customerDto.getSurname());
		customer.setAddress(customerDto.getAddress());
		customer.setNip(customerDto.getNip());
		customer.setPesel(Long.valueOf(customerDto.getPesel()));

		customerRepository.save(customer);

	}

}
