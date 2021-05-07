
package com.gean.demo.order.command.service;

import java.util.concurrent.CompletableFuture;

public interface OrderCommandService {
	public CompletableFuture<String> createOrder(OrderCreateDTO orderCreateDTO);
}
