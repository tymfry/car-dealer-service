package org.tymfry.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String vin;
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
	private BigDecimal value;
	@Column
	private boolean active;
	@Column
	private TypeOfVehicle typeOfVehicle;
	@Column
	private boolean dealerCar;
	@Column
	private boolean accepted;
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@Column
	private BigDecimal oldValue;

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

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public enum TypeOfFuel {

		GASOLINE("Benzyna"), DIESEL("Diesel"), LPG("LPG");

		private String description;

		TypeOfFuel(final String description) {
			this.description = description;
		}

		public String getDescription() {
			return this.description;
		}

	}

	public BigDecimal getOldValue() {
		return oldValue;
	}

	public void setOldValue(BigDecimal dealerValue) {
		this.oldValue = dealerValue;
	}

	public enum TypeOfVehicle {

		CAR("Osobowy"), TRUCK("Ciężarowy"), HATCHBACK("Hatchback"), KOMBI("Kombi"), CABRIO("Cabrio"), SEDAN(
				"Sedan"), LIMOUSINE("Limuzyna");

		private String description;

		TypeOfVehicle(final String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}

	}

	public enum Gearbox {
		MANUAL("Manualna"), AUTOMATIC("Automatyczna");

		private String description;

		Gearbox(final String description) {
			this.description = description;

		}

		public String getDescription() {
			return description;
		}

	}

}
