package org.tymfry.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tymfry.entity.Agreement;
import org.tymfry.entity.Car;
import org.tymfry.entity.Customer;
import org.tymfry.entity.Purchase;
import org.tymfry.entity.Renouncement;
import org.tymfry.entity.Sale;
import org.tymfry.repository.AgreementRepository;
import org.tymfry.repository.CarRepository;
import org.tymfry.repository.CustomerRepository;
import org.tymfry.repository.RenouncementRepository;
import org.tymfry.repository.SaleRepository;

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
	@Autowired
	private SaleRepository saleRepository;
	
	
	
	public void cession(int customerId, String content) {
		Renouncement renouncement = new Renouncement();
		Agreement agreement = new Agreement();
		renouncement.setDate(new Date());
		Customer customer = customerRepository.findOne(customerId);
		Car car = customer.getCar();
		renouncement.setCar(car);
		//renouncement.setAgreement(agreement);
		agreement.setContent(content);
		agreement.setRenouncement(renouncement);
		
		renouncementRepository.save(renouncement);
		agreementRepository.save(agreement);
	}
	
	public void approveCar(int carId, String content) {
		Car car = carRepository.findOne(carId);
		
		if(car.isDealerCar() == true) {
			Agreement agreement = new Agreement();
			Purchase purchase = new Purchase();
			purchase.setValue(car.getValue()); //if w kontrolerze ?
			purchase.setDate(new Date());
			purchase.setCar(car);
			agreement.setContent("treść umowy kupna");
			agreement.setPurchase(purchase);
			//TODO cena pojazdu musi się zmienić (musi być zaktualizowana)
		}
		
		
		
		
		
		
		
		Renouncement renouncement = new Renouncement();
		Agreement agreement = new Agreement();
		renouncement.setDate(new Date());
		
		renouncement.setCar(car);
		agreement.setContent(content);
		agreement.setRenouncement(renouncement);
		
		agreementRepository.save(agreement);
		renouncementRepository.save(renouncement);
		
	}
	
	public void sellDealerCar(int carId, String content) {
		Sale sale = new Sale();
		Agreement agreement = new Agreement();
		sale.setDate(new Date());
		Car car = carRepository.getCarById(carId);
		sale.setCar(car);
		agreement.setContent(content);
		agreement.setSale(sale);
		
		
		saleRepository.save(sale);
		agreementRepository.save(agreement);
	}
	
	public void sellCustomerCar(int carId, String content) {
		BigDecimal amount = null;
		Sale sale = new Sale();
		Agreement agreement = new Agreement();
		sale.setDate(new Date());
		Car car = carRepository.getCarById(carId);
		sale.setCar(car);
		agreement.setContent(content);
		agreement.setSale(sale);
		BigDecimal valueOfCar = car.getValue();
		amount = valueOfCar.multiply(new BigDecimal(0.2));
		agreement.setBigDecimal(amount);
		
		saleRepository.save(sale);
		agreementRepository.save(agreement);
	}
	

}
