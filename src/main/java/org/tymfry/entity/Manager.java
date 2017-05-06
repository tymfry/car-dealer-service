package org.tymfry.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Manager extends Employee {

	@Column
	private Integer manager_id;
	@Column
	private String managerNumber;
	@OneToMany
	private List<Sale> sales;

	public Integer getManager_id() {
		return manager_id;
	}

	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}

	public String getManagerNumber() {
		return managerNumber;
	}

	public void setManagerNumber(String managerNumber) {
		this.managerNumber = managerNumber;
	}

	public List<Sale> getSales() {
		return sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

}
