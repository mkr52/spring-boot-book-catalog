package com.mohit.bookstore.orders.domain;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String message) {
        super(message);
    }

    public static OrderNotFoundException forOrderNumber(String orderNumber) {
        return new OrderNotFoundException(String.format("Order with order number %s not found", orderNumber));
    }
}
