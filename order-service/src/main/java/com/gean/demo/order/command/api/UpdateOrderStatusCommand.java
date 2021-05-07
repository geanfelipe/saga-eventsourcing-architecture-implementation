
package com.gean.demo.order.command.api;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateOrderStatusCommand {

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

}
