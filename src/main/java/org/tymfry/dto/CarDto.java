package org.tymfry.dto;

import java.math.BigDecimal;

import org.tymfry.entity.Car.Gearbox;
import org.tymfry.entity.Car.TypeOfFuel;
import org.tymfry.entity.Car.TypeOfVehicle;

public class CarDto {

	private Integer id;
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
	private String numberOfTestDrives;
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

	public String getNumberOfTestDrives() {
		return numberOfTestDrives;
	}

	public void setNumberOfTestDrives(String numberOfTestDrives) {
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

}
