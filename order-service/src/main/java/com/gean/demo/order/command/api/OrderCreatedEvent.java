
package com.gean.demo.order.command.api;

import java.math.BigDecimal;

public class OrderCreatedEvent {

	private String orderId;
	private String itemType;
	private BigDecimal price;
	private String currency;
	private String orderStatus;

	public OrderCreatedEvent() {}

	public OrderCreatedEvent(final String orderId,
	        final String itemType,
	        final BigDecimal price,
	        final String currency,
	        final String orderStatus) {
		this.orderId = orderId;
		this.itemType = itemType;
		this.price = price;
		this.currency = currency;
		this.orderStatus = orderStatus;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(final String orderId) {
		this.orderId = orderId;
	}

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

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(final String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "OrderCreatedEvent [orderId="
		        + orderId
		        + ", itemType="
		        + itemType
		        + ", price="
		        + price
		        + ", currency="
		        + currency
		        + ", orderStatus="
		        + orderStatus
		        + "]";
	}

}
