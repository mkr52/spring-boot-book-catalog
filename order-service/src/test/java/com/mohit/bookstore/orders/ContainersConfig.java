package com.mohit.bookstore.orders;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class ContainersConfig {

    //    @Bean
    //    @ServiceConnection
    //    PostgreSQLContainer<?> postgresContainer() {
    //        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:16-alpine"));
    //    }

    @Bean
    @Primary
    @ServiceConnection
    PostgreSQLContainer<?> postgresContainer() {
        PostgreSQLContainer<?> postgresContainer =
                new PostgreSQLContainer<>(DockerImageName.parse("postgres:16-alpine"));
        postgresContainer.start();
        return postgresContainer;
    }

    @Bean
    @ServiceConnection
    RabbitMQContainer rabbitContainer() {
        return new RabbitMQContainer(DockerImageName.parse("rabbitmq:3.12.11-alpine"));
    }
}
