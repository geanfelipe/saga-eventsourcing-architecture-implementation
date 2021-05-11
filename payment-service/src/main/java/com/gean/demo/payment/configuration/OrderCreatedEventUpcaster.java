
package com.gean.demo.payment.configuration;

import org.axonframework.serialization.SimpleSerializedType;
import org.axonframework.serialization.upcasting.event.IntermediateEventRepresentation;
import org.axonframework.serialization.upcasting.event.SingleEventUpcaster;

import com.gean.demo.core.command.api.OrderCreatedEvent;

public class OrderCreatedEventUpcaster extends SingleEventUpcaster {

	private static SimpleSerializedType targetType =
	        new SimpleSerializedType(OrderCreatedEvent.class.getTypeName(), "1.0");

	@Override
	protected boolean canUpcast(final IntermediateEventRepresentation intermediateRepresentation) {
		intermediateRepresentation.getType().getName();
		final String aggregateType = intermediateRepresentation.getAggregateType().orElse("");
		if (aggregateType.equals("OrderAggregate")) {
			return intermediateRepresentation.canConvertDataTo(OrderCreatedEvent.class);
		}
		return false;
	}

	@Override
	protected IntermediateEventRepresentation
	        doUpcast(final IntermediateEventRepresentation intermediateRepresentation) {
		return intermediateRepresentation.upcastPayload(new SimpleSerializedType(targetType.getName(), "2.0"),
		        org.dom4j.Document.class,
		        document -> {
			        document.getRootElement().addElement("orderStatus").setText("Come from upcaster"); // Default
			                                                                                           // value
			        return document;
		        });
	}
}
