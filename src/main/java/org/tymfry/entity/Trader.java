package org.tymfry.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Trader extends Employee {

	@Column
	private Integer trader_id;
	@Column
	private String traderNumber;

	public Integer getTrader_id() {
		return trader_id;
	}

	public void setTrader_id(Integer trader_id) {
		this.trader_id = trader_id;
	}

	public String getTraderNumber() {
		return traderNumber;
	}

	public void setTraderNumber(String traderNumber) {
		this.traderNumber = traderNumber;
	}

}
