
package com.gean.demo.order.command.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gean.demo.order.command.OrderStatus;
import com.gean.demo.order.command.api.CreateOrderCommand;

@Component
public class OrderCommandServiceImpl implements OrderCommandService {

	@Autowired
	private CommandGateway commandGateway;

	@Override
	public CompletableFuture<String> createOrder(final OrderCreateDTO orderCreateDTO) {
		return commandGateway.send(new CreateOrderCommand(UUID.randomUUID().toString(),
		        orderCreateDTO.getItemType(),
		        orderCreateDTO.getPrice(),
		        orderCreateDTO.getCurrency(),
		        String.valueOf(OrderStatus.CREATED)));
	}

}
