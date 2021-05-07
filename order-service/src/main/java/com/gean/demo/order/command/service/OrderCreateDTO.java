
package com.gean.demo.order.command.service;

import java.math.BigDecimal;

public class OrderCreateDTO {

	private String itemType;

	private BigDecimal price;

	private String currency;

	public String getItemType() {
		return itemType;
	}

	public void setItemType(final String itemType) {
		this.itemType = itemType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(final BigDecimal price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(final String currency) {
		this.currency = currency;
	}

}
