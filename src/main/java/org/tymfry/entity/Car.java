package org.tymfry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private Long vin;
	@Column
	private int yearOfProduction;
	@Column
	private String brand;
	@Column
	private String model;
	@Column
	private Long insurancePolicyNumber;
	@Column
	private String registrationNumber;
	@Column
	private TypeOfFuel typeOfFuel;
	@Column
	private int mileage;
	@Column
	private int ccm;
	@Column
	private int horsePower;
	@Column
	private Gearbox gearbox;
	@Column
	private String description;
	@Column
	private int numberOfTestDrives;
	@Column
	private double value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Long getVin() {
		return vin;
	}

	public void setVin(Long vin) {
		this.vin = vin;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public enum TypeOfFuel {

		GASOLINE, DIESEL, LPG
	}

	public enum TypeOfVehicle {

		CAR, TRUCK, HATCHBACK, KOMBI, CABRIO, SEDAN, LIMOUSINE
	}

	public enum Gearbox {
		MANUAL, AUTOMATIC

	}

}
