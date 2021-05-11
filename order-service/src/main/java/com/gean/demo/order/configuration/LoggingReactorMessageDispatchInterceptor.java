
package com.gean.demo.order.configuration;

import org.axonframework.extensions.reactor.messaging.ReactorMessageDispatchInterceptor;
import org.axonframework.messaging.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reactor.core.publisher.Mono;

public class LoggingReactorMessageDispatchInterceptor<M extends Message<?>> implements
        ReactorMessageDispatchInterceptor<M> {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingReactorMessageDispatchInterceptor.class);

	@Override
	public Mono<M> intercept(final Mono<M> monoMessage) {
		return monoMessage
		        .doOnNext(message -> LOGGER.info("Dispatched message: [{}]", message.getPayloadType().getSimpleName()));
	}

}
