package com.mohit.bookstore.catalog;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

// Add annotation here
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(ContainersConfig.class)
public class CatalogServiceApplicationTest {

    // Add test cases here
    @Test
    public void contextLoads() {}
}
