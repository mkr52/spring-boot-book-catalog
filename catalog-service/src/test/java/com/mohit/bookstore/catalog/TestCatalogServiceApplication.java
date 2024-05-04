package com.mohit.bookstore.catalog;

import org.springframework.boot.SpringApplication;

// Update this file as test-container added with postgresql connection
// Add annotation here
// @TestConfiguration(proxyBeanMethods = false)
public class TestCatalogServiceApplication {

    // Add boilerplate code here

    public static void main(String[] args) {
        // Add boilerplate code here
        SpringApplication.from(CatalogServiceApplication::main)
                .with(ContainersConfig.class)
                .run(args);
    }
}
