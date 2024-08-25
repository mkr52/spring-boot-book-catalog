// package com.mohit.bookstore.orders.web.controllers;
//
// import com.mohit.bookstore.orders.ApplicationProperties;
// import org.springframework.amqp.rabbit.core.RabbitTemplate;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
//
// @RestController
// public class RabbitMQDemoController {
//
//    private final RabbitTemplate rabbitTemplate;
//    private final ApplicationProperties properties;
//
//    public RabbitMQDemoController(RabbitTemplate rabbitTemplate, ApplicationProperties properties) {
//        this.rabbitTemplate = rabbitTemplate;
//        this.properties = properties;
//    }
//
//     /**
//      * Publishes a message to the RabbitMQ exchange.
//      * @param message the message to be published, containing the routing key and payload
//      */
//    @PostMapping("/send")
//    public void publish(@RequestBody MyMessage message) {
//        rabbitTemplate.convertAndSend(
//                properties.orderEventsExchange(),
//                message.routingKey(),
//                message.payload());
//    }
//
//    record MyMessage(String routingKey, MyPayload payload) {
//    }
//
//    record MyPayload(String content) {
//    }
// }
