
package com.gean.demo.core.command.api;

public class InvoiceCreatedEvent {

	private String paymentId;

	private String orderId;

	public InvoiceCreatedEvent() {}

	public InvoiceCreatedEvent(final String paymentId, final String orderId) {
		this.paymentId = paymentId;
		this.orderId = orderId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(final String paymentId) {
		this.paymentId = paymentId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(final String orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "InvoiceCreatedEvent [paymentId=" + paymentId + ", orderId=" + orderId + "]";
	}

}
