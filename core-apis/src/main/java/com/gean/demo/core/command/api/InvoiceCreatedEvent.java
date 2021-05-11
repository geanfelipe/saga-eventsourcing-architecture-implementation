
package com.gean.demo.core.command.api;

import java.io.Serializable;

import org.axonframework.serialization.Revision;

@Revision("1.0")
public class InvoiceCreatedEvent implements Serializable {

	private static final long serialVersionUID = -9043091763704844558L;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (orderId == null ? 0 : orderId.hashCode());
		result = prime * result + (paymentId == null ? 0 : paymentId.hashCode());
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
		final InvoiceCreatedEvent other = (InvoiceCreatedEvent) obj;
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
		return true;
	}

}
