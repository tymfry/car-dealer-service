package org.tymfry.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CustomerDto {

	private Integer id;
	private String customerNumber;
	@NotEmpty(message = "Podaj nazwisko")
	private String surname;
	@NotEmpty(message = "Podaj imię")
	private String name;
	@NotEmpty(message = "Podaj adres")
	private String address;
	@NotEmpty(message = "Podaj NIP")
	private String nip;
	@NotNull(message = "Wpisz PESEL")
	@Digits(integer = 11, fraction = 0, message = "Podaj prawidłowy numer PESEL")
	private Long pesel;
	@NotEmpty(message = "Podaj numer kontaktowy")
	private String telephoneNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Long getPesel() {
		return pesel;
	}

	public void setPesel(Long pesel) {
		this.pesel = pesel;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

}
