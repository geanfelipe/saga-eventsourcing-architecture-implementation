
package com.gean.demo.core.command.api;

import java.io.Serializable;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateShippingCommand implements Serializable {

	private static final long serialVersionUID = 2572097286928114587L;

	@TargetAggregateIdentifier
	private String shippingId;

	private String orderId;

	private String paymentId;

	public CreateShippingCommand() {}

	public CreateShippingCommand(final String shippingId, final String orderId, final String paymentId) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (orderId == null ? 0 : orderId.hashCode());
		result = prime * result + (paymentId == null ? 0 : paymentId.hashCode());
		result = prime * result + (shippingId == null ? 0 : shippingId.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final CreateShippingCommand other = (CreateShippingCommand) obj;
		if (orderId == null) {
			if (other.orderId != null) {
				return false;
			}
		} else if (!orderId.equals(other.orderId)) {
			return false;
		}
		if (paymentId == null) {
			if (other.paymentId != null) {
				return false;
			}
		} else if (!paymentId.equals(other.paymentId)) {
			return false;
		}
		if (shippingId == null) {
			if (other.shippingId != null) {
				return false;
			}
		} else if (!shippingId.equals(other.shippingId)) {
			return false;
		}
		return true;
	}

}
