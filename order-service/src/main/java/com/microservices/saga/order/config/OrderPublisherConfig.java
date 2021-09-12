package com.microservices.saga.order.config;

import com.microservices.saga.common.event.OrderEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Supplier;

@Configuration
public class OrderPublisherConfig {

    @Bean
    public Sinks.Many<OrderEvent> orderSinks(){
        return Sinks.many().multicast().onBackpressureBuffer();
    }

    /*This will send message to kafka topic order-event based on configuration defined in application.yaml
    definitions will use method bean name order supplier*/

    @Bean
    public Supplier<Flux<OrderEvent>> orderSupplier(Sinks.Many<OrderEvent> sinks){
        return sinks::asFlux;
    }
}
