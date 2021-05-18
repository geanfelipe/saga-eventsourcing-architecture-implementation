
package com.gean.demo.order.command;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.gean.demo.core.command.api.CreateOrderCommand;
import com.gean.demo.core.command.api.OrderCreatedEvent;
import com.gean.demo.core.command.api.OrderUpdatedEvent;
import com.gean.demo.core.command.api.UpdateOrderStatusCommand;
import com.gean.demo.order.command.exception.OrderUpdateEvenException;

@Aggregate(cache = "cache", snapshotTriggerDefinition = "orderSnapshotTriggerDefinition")
public class OrderAggregate {

	@AggregateIdentifier
	private String orderId;

	private ItemType itemType;

	private BigDecimal price;

	private String currency;

	private OrderStatus orderStatus;

	@CommandHandler
	public OrderAggregate(final CreateOrderCommand createOrderCommand) {
		AggregateLifecycle.apply(new OrderCreatedEvent(createOrderCommand.getOrderId(),
		        createOrderCommand.getItemType(),
		        createOrderCommand.getPrice(),
		        createOrderCommand.getCurrency(),
		        createOrderCommand.getOrderStatus()));
	}

	@EventSourcingHandler
	protected void on(final OrderCreatedEvent orderCreatedEvent) {
		orderId = orderCreatedEvent.getOrderId();
		itemType = ItemType.valueOf(orderCreatedEvent.getItemType());
		price = orderCreatedEvent.getPrice();
		currency = orderCreatedEvent.getCurrency();
		orderStatus = OrderStatus.valueOf(orderCreatedEvent.getOrderStatus());
	}

	@CommandHandler
	protected void on(final UpdateOrderStatusCommand updateOrderStatusCommand) {
		if (orderStatus.equals(OrderStatus.SHIPPED) || orderStatus.equals(OrderStatus.REJECTED)) {
			throw new OrderUpdateEvenException("Order has the status " + orderStatus + " and can no longer be updated");
		}
		AggregateLifecycle.apply(new OrderUpdatedEvent(updateOrderStatusCommand.getOrderId(),
		        updateOrderStatusCommand.getOrderStatus()));
	}

	@EventSourcingHandler
	protected void on(final OrderUpdatedEvent orderUpdatedEvent) {
		orderStatus = OrderStatus.valueOf(orderUpdatedEvent.getOrderStatus());
	}

	public OrderAggregate() {}

	public OrderAggregate(final String orderId,
	        final ItemType itemType,
	        final BigDecimal price,
	        final String currency,
	        final OrderStatus orderStatus) {
		super();
		this.orderId = orderId;
		this.itemType = itemType;
		this.price = price;
		this.currency = currency;
		this.orderStatus = orderStatus;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(final String orderId) {
		this.orderId = orderId;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(final ItemType itemType) {
		this.itemType = itemType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(final BigDecimal price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(final String currency) {
		this.currency = currency;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(final OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

}
