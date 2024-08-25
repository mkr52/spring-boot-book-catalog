package com.mohit.bookstore.notifications.events;

import com.mohit.bookstore.notifications.domain.NotificationService;
import com.mohit.bookstore.notifications.domain.OrderEventEntity;
import com.mohit.bookstore.notifications.domain.OrderEventRepository;
import com.mohit.bookstore.notifications.domain.models.OrderCancelledEvent;
import com.mohit.bookstore.notifications.domain.models.OrderCreatedEvent;
import com.mohit.bookstore.notifications.domain.models.OrderDeliveredEvent;
import com.mohit.bookstore.notifications.domain.models.OrderErrorEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventHandler {

    // add logger
    private static final Logger log = LoggerFactory.getLogger(OrderEventHandler.class);

    private final OrderEventRepository orderEventRepository;
    private final NotificationService notificationService;

    public OrderEventHandler(OrderEventRepository orderEventRepository, NotificationService notificationService) {
        this.orderEventRepository = orderEventRepository;
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = "${notifications.new-orders-queue}")
    void handleOrderCreatedEvent(OrderCreatedEvent event) {
        log.info("Received OrderCreatedEvent with eventId: {}", event.eventId());
        if (orderEventRepository.existsByEventId(event.eventId())) {
            log.warn("OrderCreatedEvent with eventId: {} already exists", event.eventId());
            return;
        }
        notificationService.sendOrderCreatedNotification(event);
        OrderEventEntity orderEventEntity = new OrderEventEntity(event.eventId());
        orderEventRepository.save(orderEventEntity);
    }

    @RabbitListener(queues = "${notifications.delivered-orders-queue}")
    void handleOrderDeliveredEvent(OrderDeliveredEvent event) {
        log.info("Received OrderDeliveredEvent with eventId: {}", event.eventId());
        if (orderEventRepository.existsByEventId(event.eventId())) {
            log.warn("OrderDeliveredEvent with eventId: {} already exists", event.eventId());
            return;
        }
        notificationService.sendOrderDeliveredNotification(event);
        OrderEventEntity orderEventEntity = new OrderEventEntity(event.eventId());
        orderEventRepository.save(orderEventEntity);
    }

    @RabbitListener(queues = "${notifications.cancelled-orders-queue}")
    void handleOrderCancelledEvent(OrderCancelledEvent event) {
        log.info("Received OrderCancelledEvent with eventId: {}", event.eventId());
        if (orderEventRepository.existsByEventId(event.eventId())) {
            log.warn("OrderCancelledEvent with eventId: {} already exists", event.eventId());
            return;
        }
        notificationService.sendOrderCancelledNotification(event);
        OrderEventEntity orderEventEntity = new OrderEventEntity(event.eventId());
        orderEventRepository.save(orderEventEntity);
    }

    @RabbitListener(queues = "${notifications.error-orders-queue}")
    void handleOrderErrorEvent(OrderErrorEvent event) {
        log.info("Received OrderErrorEvent with eventId: {}", event.eventId());
        if (orderEventRepository.existsByEventId(event.eventId())) {
            log.warn("OrderErrorEvent with eventId: {} already exists", event.eventId());
            return;
        }
        notificationService.sendOrderErrorEventNotification(event);
        OrderEventEntity orderEventEntity = new OrderEventEntity(event.eventId());
        orderEventRepository.save(orderEventEntity);
    }
}
