
package com.gean.demo.core.command.api;

public class OrderShippedEvent {
	private String shippingId;

	private String orderId;

	private String paymentId;

	public OrderShippedEvent() {}

	public OrderShippedEvent(final String shippingId, final String orderId, final String paymentId) {
		this.shippingId = shippingId;
		this.orderId = orderId;
		this.paymentId = paymentId;
	}

	public String getShippingId() {
		return shippingId;
	}

	public void setShippingId(final String shippingId) {
		this.shippingId = shippingId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(final String orderId) {
		this.orderId = orderId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(final String paymentId) {
		this.paymentId = paymentId;
	}

	@Override
	public String toString() {
		return "OrderShippedEvent [shippingId="
		        + shippingId
		        + ", orderId="
		        + orderId
		        + ", paymentId="
		        + paymentId
		        + "]";
	}
}
