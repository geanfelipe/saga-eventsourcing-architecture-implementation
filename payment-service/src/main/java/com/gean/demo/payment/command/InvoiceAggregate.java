
package com.gean.demo.payment.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.gean.demo.core.command.api.CreateInvoiceCommand;
import com.gean.demo.core.command.api.InvoiceCreatedEvent;

@Aggregate
public class InvoiceAggregate {

	@AggregateIdentifier
	private String paymentId;

	private String orderId;

	private InvoiceStatus invoiceStatus;

	@CommandHandler
	public InvoiceAggregate(final CreateInvoiceCommand createInvoiceCommand) {
		AggregateLifecycle
		        .apply(new InvoiceCreatedEvent(createInvoiceCommand.getPaymentId(), createInvoiceCommand.getOrderId()));
	}

	@EventSourcingHandler
	protected void on(final InvoiceCreatedEvent invoiceCreatedEvent) {
		paymentId = invoiceCreatedEvent.getPaymentId();
		orderId = invoiceCreatedEvent.getOrderId();
		invoiceStatus = InvoiceStatus.PAID;
	}

	public InvoiceAggregate() {}

	public InvoiceAggregate(final String paymentId, final String orderId, final InvoiceStatus invoiceStatus) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.invoiceStatus = invoiceStatus;
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

	public InvoiceStatus getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(final InvoiceStatus invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

}
