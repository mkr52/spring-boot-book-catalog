package com.mohit.bookstore.catalog;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

// Add test configuration annotation here
@TestConfiguration(proxyBeanMethods = false)
public class ContainersConfig {

    // Add boilerplate code here for postgres connection
    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgresTestContainer() {
        return new PostgreSQLContainer<>("postgres:16-alpine"); // fix this error
    }
}
