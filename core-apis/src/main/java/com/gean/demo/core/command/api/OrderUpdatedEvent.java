
package com.gean.demo.core.command.api;

public class OrderUpdatedEvent {

	private String orderId;

	private String orderStatus;

	public OrderUpdatedEvent() {}

	public OrderUpdatedEvent(final String orderId, final String orderStatus) {
		this.orderId = orderId;
		this.orderStatus = orderStatus;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(final String orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(final String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
