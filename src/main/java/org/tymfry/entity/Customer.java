package org.tymfry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String customerNumber;
	@Column
	private String surname;
	@Column
	private String name;
	@Column
	private String adress;
	@Column
	private String nip;
	@Column
	private Long pesel;
	
}
