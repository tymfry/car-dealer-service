package org.tymfry.dto;

import org.tymfry.entity.Car.Gearbox;
import org.tymfry.entity.Car.TypeOfFuel;

public class CarDto {

	private Integer id;
	private Long vin;
	private int yearOfProduction;
	private String brand;
	private String model;
	private Long insurancePolicyNumber;
	private String registrationNumber;
	private TypeOfFuel typeOfFuel;
	private int mileage;
	private int ccm;
	private int horsePower;
	private Gearbox gearbox;
	private String description;
	private int numberOfTestDrives;
	private double value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getVin() {
		return vin;
	}

	public void setVin(Long vin) {
		this.vin = vin;
	}

	public int getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(int yearOfProduction) {
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

	public Long getInsurancePolicyNumber() {
		return insurancePolicyNumber;
	}

	public void setInsurancePolicyNumber(Long insurancePolicyNumber) {
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

	public void setTypeOfFuel(TypeOfFuel typeOfFuel) {
		this.typeOfFuel = typeOfFuel;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getCcm() {
		return ccm;
	}

	public void setCcm(int ccm) {
		this.ccm = ccm;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
