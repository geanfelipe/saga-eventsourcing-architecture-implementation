
package com.gean.demo.shipping.configuration;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.common.caching.Cache;
import org.axonframework.common.caching.WeakReferenceCache;
import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.extensions.reactor.commandhandling.gateway.ReactorCommandGateway;
import org.axonframework.messaging.interceptors.LoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandConfiguration {

	/************************************************/
	/* Register interceptors on the bus */
	/************************************************/

	@Autowired
	public void registerCommandInterceptorsOnBus(final CommandBus commandBus) {
		commandBus.registerHandlerInterceptor(new LoggingInterceptor<>());
	}

	@Autowired
	public void registerEventInterceptors(final EventBus eventBus) {
		eventBus.registerDispatchInterceptor(new LoggingInterceptor<>());
	}

	@Autowired
	public void configure(final EventProcessingConfigurer config) {
		config.registerDefaultHandlerInterceptor((t, u) -> new LoggingInterceptor<>(u));
	}

	/***************************************/
	/* Aggregate cache configuration */
	/***************************************/

	@Bean("cache")
	public Cache cache() {
		return new WeakReferenceCache();
	}

	/***************************************/
	/* Interceptor configuration */
	/***************************************/

	@Autowired
	public void reactiveCommandGatewayConfiguration(final ReactorCommandGateway reactorCommandGateway) {
		reactorCommandGateway.registerDispatchInterceptor(new LoggingReactorMessageDispatchInterceptor<>());
	}

}
