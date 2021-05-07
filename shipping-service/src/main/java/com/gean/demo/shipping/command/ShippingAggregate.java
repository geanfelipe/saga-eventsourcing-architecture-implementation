
package com.gean.demo.shipping.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.gean.demo.core.command.api.CreateShippingCommand;
import com.gean.demo.core.command.api.OrderShippedEvent;

@Aggregate
public class ShippingAggregate {

	@AggregateIdentifier
	private String shippingId;

	private String orderId;

	private String paymentId;

	public ShippingAggregate() {}

	@CommandHandler
	public ShippingAggregate(final CreateShippingCommand createShippingCommand) {
		AggregateLifecycle.apply(new OrderShippedEvent(createShippingCommand.getShippingId(),
		        createShippingCommand.getOrderId(),
		        createShippingCommand.getPaymentId()));
	}

	@EventSourcingHandler
	protected void on(final OrderShippedEvent orderShippedEvent) {
		shippingId = orderShippedEvent.getShippingId();
		orderId = orderShippedEvent.getOrderId();
		paymentId = orderShippedEvent.getPaymentId();

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

}
