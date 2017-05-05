package org.tymfry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Agreement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String content;
	@OneToOne
	@JoinColumn(name = "renouncement_id")
	private Renouncement renouncement;
	@OneToOne
	@JoinColumn(name = "purchase_id")
	private Purchase purchase;
	@OneToOne
	@JoinColumn(name = "sale_id")
	private Sale sale;
}
