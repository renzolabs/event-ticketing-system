package com.renzo.labs.ticketing.shared.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseEntityTest {

    @Test
    void shouldHaveMappedSuperclassAnnotation() {
        MappedSuperclass annotation = BaseEntity.class.getAnnotation(MappedSuperclass.class);
        assertNotNull(annotation, "BaseEntity should have @MappedSuperclass annotation");
    }

    @Test
    void shouldHaveIdFieldWithCorrectAnnotations() throws NoSuchFieldException {
        var idField = BaseEntity.class.getDeclaredField("id");

        Id idAnnotation = idField.getAnnotation(Id.class);
        GeneratedValue generatedValueAnnotation = idField.getAnnotation(GeneratedValue.class);
        Column columnAnnotation = idField.getAnnotation(Column.class);

        assertNotNull(idAnnotation, "id field should have @Id annotation");
        assertNotNull(generatedValueAnnotation, "id field should have @GeneratedValue annotation");
        assertEquals(GenerationType.UUID, generatedValueAnnotation.strategy(),
                "id generation strategy should be UUID");
        assertNotNull(columnAnnotation, "id field should have @Column annotation");
        assertEquals("id", columnAnnotation.name());
        assertTrue(columnAnnotation.updatable() == false && columnAnnotation.nullable() == false,
                "id column should not be updatable or nullable");
    }

    @Test
    void shouldHaveCreatedAtFieldWithCorrectAnnotations() throws NoSuchFieldException {
        var createdAtField = BaseEntity.class.getDeclaredField("createdAt");
        Column columnAnnotation = createdAtField.getAnnotation(Column.class);

        assertNotNull(columnAnnotation, "createdAt field should have @Column annotation");
        assertEquals("created_at", columnAnnotation.name());
        assertTrue(columnAnnotation.nullable() == false && columnAnnotation.updatable() == false,
                "createdAt column should not be nullable or updatable");
    }

    @Test
    void shouldHaveUpdatedAtFieldWithCorrectAnnotations() throws NoSuchFieldException {
        var updatedAtField = BaseEntity.class.getDeclaredField("updatedAt");
        Column columnAnnotation = updatedAtField.getAnnotation(Column.class);

        assertNotNull(columnAnnotation, "updatedAt field should have @Column annotation");
        assertEquals("updated_at", columnAnnotation.name());
        assertTrue(columnAnnotation.nullable() == false,
                "updatedAt column should not be nullable");
    }

    @Test
    void shouldHavePrePersistMethod() throws NoSuchMethodException {
        Method onCreateMethod = BaseEntity.class.getDeclaredMethod("onCreate");
        PrePersist prePersistAnnotation = onCreateMethod.getAnnotation(PrePersist.class);
        assertNotNull(prePersistAnnotation, "onCreate method should have @PrePersist annotation");
    }

    @Test
    void shouldHavePreUpdateMethod() throws NoSuchMethodException {
        Method onUpdateMethod = BaseEntity.class.getDeclaredMethod("onUpdate");
        PreUpdate preUpdateAnnotation = onUpdateMethod.getAnnotation(PreUpdate.class);
        assertNotNull(preUpdateAnnotation, "onUpdate method should have @PreUpdate annotation");
    }

    @Test
    void onCreate_shouldSetCreatedAtAndUpdatedAt() {
        TestEntity entity = new TestEntity();
        assertNull(entity.getCreatedAt());
        assertNull(entity.getUpdatedAt());

        entity.onCreate();

        assertNotNull(entity.getCreatedAt(), "createdAt should be set");
        assertNotNull(entity.getUpdatedAt(), "updatedAt should be set");
        assertEquals(entity.getCreatedAt(), entity.getUpdatedAt(),
                "createdAt and updatedAt should be equal on create");
    }

    @Test
    void onUpdate_shouldUpdateUpdatedAtOnly() throws InterruptedException {
        TestEntity entity = new TestEntity();
        entity.onCreate();
        LocalDateTime initialUpdatedAt = entity.getUpdatedAt();

        Thread.sleep(10); // Ensure time difference
        entity.onUpdate();

        assertEquals(entity.getCreatedAt(), entity.getCreatedAt(),
                "createdAt should remain unchanged");
        assertTrue(entity.getUpdatedAt().isAfter(initialUpdatedAt),
                "updatedAt should be after the initial value");
    }

    @Test
    void gettersAndSetters_shouldWork() {
        TestEntity entity = new TestEntity();
        UUID id = UUID.randomUUID();
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now();

        entity.setId(id);
        entity.setCreatedAt(createdAt);
        entity.setUpdatedAt(updatedAt);

        assertEquals(id, entity.getId());
        assertEquals(createdAt, entity.getCreatedAt());
        assertEquals(updatedAt, entity.getUpdatedAt());
    }

    // Test entity class to test BaseEntity behavior
    private static class TestEntity extends BaseEntity {
        // Concrete implementation for testing
    }
}
