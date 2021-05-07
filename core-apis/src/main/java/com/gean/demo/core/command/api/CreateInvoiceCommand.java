
package com.gean.demo.core.command.api;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateInvoiceCommand {

	@TargetAggregateIdentifier
	private String paymentId;

	private String orderId;

	public CreateInvoiceCommand() {}

	public CreateInvoiceCommand(final String paymentId, final String orderId) {
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

}
