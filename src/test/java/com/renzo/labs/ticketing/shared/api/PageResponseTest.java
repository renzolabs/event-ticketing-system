package com.renzo.labs.ticketing.shared.api;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PageResponseTest {

    @Test
    void from_withPage_shouldCreateResponse() {
        List<String> content = Arrays.asList("item1", "item2", "item3");
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<String> page = new PageImpl<>(content, pageRequest, 25);

        PageResponse<String> response = PageResponse.from(page);

        assertNotNull(response);
        assertEquals(content, response.getContent());
        assertEquals(0, response.getPage());
        assertEquals(10, response.getSize());
        assertEquals(25, response.getTotalElements());
        assertEquals(3, response.getTotalPages()); // 25 elements / 10 per page = 3 pages
    }

    @Test
    void from_withEmptyPage_shouldCreateResponse() {
        Page<String> emptyPage = Page.empty();

        PageResponse<String> response = PageResponse.from(emptyPage);

        assertNotNull(response);
        assertTrue(response.getContent().isEmpty());
        assertEquals(0, response.getPage());
        assertEquals(0, response.getSize());
        assertEquals(0, response.getTotalElements());
        assertEquals(1, response.getTotalPages());
    }

    @Test
    void from_withSecondPage_shouldCorrectlyCalculate() {
        List<String> content = Collections.singletonList("item11");
        PageRequest pageRequest = PageRequest.of(1, 10); // Second page
        Page<String> page = new PageImpl<>(content, pageRequest, 11);

        PageResponse<String> response = PageResponse.from(page);

        assertEquals(1, response.getPage());
        assertEquals(10, response.getSize());
        assertEquals(11, response.getTotalElements());
        assertEquals(2, response.getTotalPages());
    }

    @Test
    void builder_shouldCreateResponse() {
        List<Integer> content = Arrays.asList(1, 2, 3);

        PageResponse<Integer> response = PageResponse.<Integer>builder()
                .content(content)
                .page(2)
                .size(5)
                .totalElements(15)
                .totalPages(3)
                .build();

        assertEquals(content, response.getContent());
        assertEquals(2, response.getPage());
        assertEquals(5, response.getSize());
        assertEquals(15, response.getTotalElements());
        assertEquals(3, response.getTotalPages());
    }

    @Test
    void genericType_shouldWorkWithDifferentTypes() {
        List<String> stringContent = Arrays.asList("a", "b");
        Page<String> stringPage = new PageImpl<>(stringContent);
        PageResponse<String> stringResponse = PageResponse.from(stringPage);
        assertEquals(stringContent, stringResponse.getContent());

        List<Integer> intContent = Arrays.asList(1, 2);
        Page<Integer> intPage = new PageImpl<>(intContent);
        PageResponse<Integer> intResponse = PageResponse.from(intPage);
        assertEquals(intContent, intResponse.getContent());
    }
}
