
package com.gean.demo.core.command.api;

import java.io.Serializable;

import org.axonframework.serialization.Revision;

@Revision("1.0")
public class OrderUpdatedEvent implements Serializable {

	private static final long serialVersionUID = 686080072782941441L;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (orderId == null ? 0 : orderId.hashCode());
		result = prime * result + (orderStatus == null ? 0 : orderStatus.hashCode());
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
		final OrderUpdatedEvent other = (OrderUpdatedEvent) obj;
		if (orderId == null) {
			if (other.orderId != null) {
				return false;
			}
		} else if (!orderId.equals(other.orderId)) {
			return false;
		}
		if (orderStatus == null) {
			if (other.orderStatus != null) {
				return false;
			}
		} else if (!orderStatus.equals(other.orderStatus)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "OrderUpdatedEvent [orderId=" + orderId + ", orderStatus=" + orderStatus + "]";
	}
}
