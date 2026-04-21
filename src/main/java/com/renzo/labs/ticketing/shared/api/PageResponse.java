package com.renzo.labs.ticketing.shared.api;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

/**
 * Paginated response wrapper for API responses.
 *
 * @param <T> the type of content in the page
 */
@Getter
@Builder
public class PageResponse<T> {

    private final List<T> content;
    private final int page;
    private final int size;
    private final long totalElements;
    private final int totalPages;

    /**
     * Creates a page response from Spring Data Page.
     *
     * @param page  the Spring Data Page
     * @param <T>   the type of content
     * @return PageResponse built from the Page
     */
    public static <T> PageResponse<T> from(org.springframework.data.domain.Page<T> page) {
        return PageResponse.<T>builder()
                .content(page.getContent())
                .page(page.getNumber())
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .build();
    }
}
