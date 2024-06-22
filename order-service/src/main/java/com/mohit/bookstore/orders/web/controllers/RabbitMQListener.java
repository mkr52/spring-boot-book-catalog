// package com.mohit.bookstore.orders.web.controllers;
//
// import org.springframework.amqp.rabbit.annotation.RabbitListener;
// import org.springframework.stereotype.Service;
//
// @Service
// public class RabbitMQListener {
//
//    @RabbitListener(queues = "${orders.new-orders-queue}")
//    void handleNewOrders(RabbitMQDemoController.MyPayload payload) {
//        System.out.println("New order received: " + payload.content());
//    }
//
//    @RabbitListener(queues = "${orders.delivered-orders-queue}")
//    void handleDeliveredOrders(RabbitMQDemoController.MyPayload payload) {
//        System.out.println("Delivered order received: " + payload.content());
//    }
//
//
// }
