
package com.gean.demo.order.configuration;

import java.util.concurrent.Executors;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.common.caching.Cache;
import org.axonframework.common.caching.WeakReferenceCache;
import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.EventCountSnapshotTriggerDefinition;
import org.axonframework.eventsourcing.Snapshotter;
import org.axonframework.extensions.reactor.commandhandling.gateway.ReactorCommandGateway;
import org.axonframework.messaging.interceptors.LoggingInterceptor;
import org.axonframework.spring.eventsourcing.SpringAggregateSnapshotterFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandConfiguration {

	private static final int SNAPSHOT_TRIGGER = 20;

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
	/* Aggregate snapshot configuration */
	/***************************************/

	@Bean
	public SpringAggregateSnapshotterFactoryBean snapshotter() {
		final var springAggregateSnapshotterFactoryBean = new SpringAggregateSnapshotterFactoryBean();
		// Setting async executors
		springAggregateSnapshotterFactoryBean.setExecutor(Executors.newSingleThreadExecutor());
		return springAggregateSnapshotterFactoryBean;
	}

	@Bean("orderSnapshotTriggerDefinition")
	EventCountSnapshotTriggerDefinition roomSnapshotTriggerDefinition(final Snapshotter snapshotter) {
		return new EventCountSnapshotTriggerDefinition(snapshotter, SNAPSHOT_TRIGGER);
	}

	@Autowired
	public void reactiveCommandGatewayConfiguration(final ReactorCommandGateway reactorCommandGateway) {
		reactorCommandGateway.registerDispatchInterceptor(new LoggingReactorMessageDispatchInterceptor<>());
	}

}
