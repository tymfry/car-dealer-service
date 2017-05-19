package org.tymfry.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.tymfry.entity.Car.Gearbox;
import org.tymfry.entity.Car.TypeOfFuel;
import org.tymfry.entity.Car.TypeOfVehicle;

public class CarDto {

	private Integer id;
	@NotNull(message = "Wpisz numer VIN")
	@Size(min=17, max=20, message = "Numer Vin powinien składać się z 17 znaków")
	private String vin;
	private String yearOfProduction;
	private String brand;
	private String model;
	private String insurancePolicyNumber;
	private String registrationNumber;
	private TypeOfFuel typeOfFuel;
	private String mileage;
	private String ccm;
	private String horsePower;
	private Gearbox gearbox;
	private String description;
	private int numberOfTestDrives;
	private BigDecimal value;
	private boolean active; // car is available to buy when true, when false
							// employee can saw cars "/show-all-sold-cars",
							// always true when cutomer or employee appends car
	private TypeOfVehicle typeOfVehicle;
	private boolean dealerCar; // if true car is sold to dealer if not car is
								// cessioned by customer
	private boolean accepted; // vehicle added by user is always false, to show
								// vehicle on the sales list employee need to
								// check data implemented by user.
	private BigDecimal oldValue;

	private Integer customer_id;
	private String customerNumber;
	private String surname;
	private String name;
	private String address;
	private String nip;
	private String pesel;
	private String telephoneNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(String yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getInsurancePolicyNumber() {
		return insurancePolicyNumber;
	}

	public void setInsurancePolicyNumber(String insurancePolicyNumber) {
		this.insurancePolicyNumber = insurancePolicyNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public TypeOfFuel getTypeOfFuel() {
		return typeOfFuel;
	}

	public void setTypeOfFuel(final TypeOfFuel typeOfFuel) {
		this.typeOfFuel = typeOfFuel;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getCcm() {
		return ccm;
	}

	public void setCcm(String ccm) {
		this.ccm = ccm;
	}

	public String getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(String horsePower) {
		this.horsePower = horsePower;
	}

	public Gearbox getGearbox() {
		return gearbox;
	}

	public void setGearbox(Gearbox gearbox) {
		this.gearbox = gearbox;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberOfTestDrives() {
		return numberOfTestDrives;
	}

	public void setNumberOfTestDrives(int numberOfTestDrives) {
		this.numberOfTestDrives = numberOfTestDrives;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public TypeOfVehicle getTypeOfVehicle() {
		return typeOfVehicle;
	}

	public void setTypeOfVehicle(TypeOfVehicle typeOfVehicle) {
		this.typeOfVehicle = typeOfVehicle;
	}

	public boolean isDealerCar() {
		return dealerCar;
	}

	public void setDealerCar(boolean dealerCar) {
		this.dealerCar = dealerCar;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public BigDecimal getOldValue() {
		return oldValue;
	}

	public void setOldValue(BigDecimal dealerValue) {
		this.oldValue = dealerValue;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

}
