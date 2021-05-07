
package com.gean.demo.order.command.api;

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

	@Override
	public String toString() {
		return "OrderUpdatedEvent [orderId=" + orderId + ", orderStatus=" + orderStatus + "]";
	}

}
