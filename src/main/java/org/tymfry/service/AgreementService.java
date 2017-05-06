package org.tymfry.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tymfry.entity.Agreement;
import org.tymfry.entity.Car;
import org.tymfry.entity.Customer;
import org.tymfry.entity.Renouncement;
import org.tymfry.repository.AgreementRepository;
import org.tymfry.repository.CarRepository;
import org.tymfry.repository.CustomerRepository;
import org.tymfry.repository.RenouncementRepository;

@Service
public class AgreementService {

	@Autowired
	private AgreementRepository agreementRepository;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private RenouncementRepository renouncementRepository;
	
	public void sellCustomerCar(int id) {
		//TODO sprzedaż pojazdu klienta
	}
	
	public void cession(int customerId, String content) {
		Renouncement renouncement = new Renouncement();
		Agreement agreement = new Agreement();
		renouncement.setDate(new Date());
		Customer customer = customerRepository.findOne(customerId);
		Car car = customer.getCar();
		renouncement.setCar(car);
		renouncement.setAgreement(agreement);
		agreement.setContent(content);
		agreement.setRenouncement(renouncement);
		
		agreementRepository.save(agreement);
		renouncementRepository.save(renouncement);
	}
}
