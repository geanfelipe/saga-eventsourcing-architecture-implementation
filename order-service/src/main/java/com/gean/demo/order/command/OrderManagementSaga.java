
package com.gean.demo.order.command;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gean.demo.core.command.api.CreateInvoiceCommand;
import com.gean.demo.core.command.api.CreateShippingCommand;
import com.gean.demo.core.command.api.InvoiceCreatedEvent;
import com.gean.demo.core.command.api.OrderShippedEvent;
import com.gean.demo.order.command.api.OrderCreatedEvent;
import com.gean.demo.order.command.api.OrderUpdatedEvent;
import com.gean.demo.order.command.api.UpdateOrderStatusCommand;

@Saga
public class OrderManagementSaga {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderManagementSaga.class);

	@Autowired
	private transient CommandGateway commandGateway;

	@StartSaga
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(final OrderCreatedEvent orderCreatedEvent) {
		final String paymentId = UUID.randomUUID().toString();
		LOGGER.info("OrderCreatedEvent - 1 Saga invoked {}", orderCreatedEvent);

		SagaLifecycle.associateWith("paymentId", paymentId);
		// send the commands
		commandGateway.send(new CreateInvoiceCommand(paymentId, orderCreatedEvent.getOrderId()));
	}

	@SagaEventHandler(associationProperty = "paymentId")
	public void handle(final InvoiceCreatedEvent invoiceCreatedEvent) {
		final String shippingId = UUID.randomUUID().toString();

		LOGGER.info("InvoiceCreatedEvent - 2 Saga continued {}", invoiceCreatedEvent);

		// associate Saga with shipping
		SagaLifecycle.associateWith("shippingId", shippingId);

		// send the create shipping command
		commandGateway.send(new CreateShippingCommand(shippingId,
		        invoiceCreatedEvent.getOrderId(),
		        invoiceCreatedEvent.getPaymentId()));
	}

	@SagaEventHandler(associationProperty = "orderId")
	public void handle(final OrderShippedEvent orderShippedEvent) {
		LOGGER.info("OrderShippedEvent - 3 Saga continued {}", orderShippedEvent);
		commandGateway.send(
		        new UpdateOrderStatusCommand(orderShippedEvent.getOrderId(), String.valueOf(OrderStatus.SHIPPED)));
	}

	@SagaEventHandler(associationProperty = "orderId")
	public void handle(final OrderUpdatedEvent orderUpdatedEvent) {
		LOGGER.info("OrderUpdatedEvent - 4 Saga finished {}", orderUpdatedEvent);
		SagaLifecycle.end();
	}

}
