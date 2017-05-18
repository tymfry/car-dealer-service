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
import org.tymfry.repository.PurchaseRepository;
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
	@Autowired
	private PurchaseRepository purchaseRepository;

	public void cession(int customerId, String content) {
		Renouncement renouncement = new Renouncement();
		Agreement agreement = new Agreement();
		renouncement.setDate(new Date());
		Customer customer = customerRepository.findOne(customerId);
		Car car = customer.getCar();
		renouncement.setCar(car);
		agreement.setContent(content);
		agreement.setRenouncement(renouncement);

		renouncementRepository.save(renouncement);
		agreementRepository.save(agreement);
	}

	public void approveCar(int carId, String content) {
		Car car = carRepository.findOne(carId);

		if (car.isDealerCar() == true) {
			Agreement agreement = new Agreement();
			Purchase purchase = new Purchase();
			purchase.setValue(car.getOldValue());
			purchase.setDate(new Date());
			purchase.setCar(car);
			agreement.setContent("treść umowy kupna");
			agreement.setPurchase(purchase);
			agreement.setBigDecimal(car.getOldValue());

			purchaseRepository.save(purchase);
			agreementRepository.save(agreement);

		} else {

			Renouncement renouncement = new Renouncement();
			Agreement agreement = new Agreement();
			renouncement.setDate(new Date());
			renouncement.setCar(car);
			agreement.setContent(content);
			agreement.setRenouncement(renouncement);

			agreementRepository.save(agreement);
			renouncementRepository.save(renouncement);
		}

	}

	public void buyCarAsDealer(int carId, String content) {
		Purchase purchase = new Purchase();
		Agreement agreement = new Agreement();
		purchase.setDate(new Date());
		Car car = carRepository.getCarById(carId);
		purchase.setCar(car);
		agreement.setContent(content);
		agreement.setPurchase(purchase);
		BigDecimal value = car.getValue();
		purchase.setValue(value);

		purchaseRepository.save(purchase);
		agreementRepository.save(agreement);
	}

	public void cessionForDealer(int carId, String content) {
		Renouncement renouncement = new Renouncement();
		Agreement agreement = new Agreement();
		Car car = carRepository.getCarById(carId);
		renouncement.setCar(car);
		renouncement.setDate(new Date());
		agreement.setContent(content);
		agreement.setRenouncement(renouncement);

		renouncementRepository.save(renouncement);
		agreementRepository.save(agreement);
	}

	public void sellCar(int carId, String content) {
		Car car = carRepository.findOne(carId);
		if (car.isDealerCar() == true) {
			Sale sale = new Sale();
			BigDecimal amount = null;
			BigDecimal oldValue = car.getOldValue();
			BigDecimal value = car.getValue();
			BigDecimal temp = value.subtract(oldValue);
			amount = temp;
			temp.multiply(new BigDecimal(0.19));

			Agreement agreement = new Agreement();
			sale.setValue(value);
			sale.setDate(new Date());
			sale.setCar(car);
			agreement.setContent("content");
			agreement.setBigDecimal(amount.subtract(temp)); 
			agreement.setSale(sale);

			saleRepository.save(sale);
			agreementRepository.save(agreement);

		} else {
			Sale sale = new Sale();
			Agreement agreement = new Agreement();
			BigDecimal carValue = car.getValue();
			BigDecimal comissionTemp = carValue.multiply(new BigDecimal(0.2));
			BigDecimal comission = comissionTemp.multiply(new BigDecimal(0.19));
			sale.setCar(car);
			sale.setDate(new Date());
			sale.setValue(car.getValue());
			agreement.setContent("content");
			agreement.setBigDecimal(comission);
			agreement.setSale(sale);

			saleRepository.save(sale);
			agreementRepository.save(agreement);

		}
	}

}
