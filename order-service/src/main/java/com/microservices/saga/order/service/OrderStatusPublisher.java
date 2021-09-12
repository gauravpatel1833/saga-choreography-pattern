package com.microservices.saga.order.service;

import com.microservices.saga.common.dto.OrderRequestDto;
import com.microservices.saga.common.event.OrderEvent;
import com.microservices.saga.common.event.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

@Service
public class OrderStatusPublisher {

    @Autowired
    private Sinks.Many<OrderEvent> orderSinks;

    /*This is springboot webflux : reactor programming*/

    public void publishOrderEvent(OrderRequestDto orderRequestDto,OrderStatus orderStatus){
        OrderEvent orderEvent = new OrderEvent(orderRequestDto,orderStatus);
        orderSinks.tryEmitNext(orderEvent);
    }
}
