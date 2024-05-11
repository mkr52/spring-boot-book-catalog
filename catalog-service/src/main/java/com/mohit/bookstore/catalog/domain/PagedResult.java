package com.mohit.bookstore.catalog.domain;

import java.util.List;

public record PagedResult<T>(
        List<T> content,
        long totalElements,
        int pageNumber,
        int totalPages,
        boolean isFirst,
        boolean isLast,
        boolean hasNext,
        boolean hasPrevious) {}
