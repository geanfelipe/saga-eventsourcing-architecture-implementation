
package com.gean.demo.core.command.api;

import java.io.Serializable;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateOrderStatusCommand implements Serializable {

	private static final long serialVersionUID = -3974677692836153156L;

	@TargetAggregateIdentifier
	private String orderId;

	private String orderStatus;

	public UpdateOrderStatusCommand() {}

	public UpdateOrderStatusCommand(final String orderId, final String orderStatus) {
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
		final UpdateOrderStatusCommand other = (UpdateOrderStatusCommand) obj;
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
}
