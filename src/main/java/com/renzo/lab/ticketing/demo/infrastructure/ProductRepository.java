package com.renzo.lab.ticketing.demo.infrastructure;

import com.renzo.lab.ticketing.demo.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Spring Data JPA repository for Product entities.
 * 
 * Provides database access operations for Product management
 * including custom queries and standard CRUD operations.
 * 
 * @author Renzo Labs Team
 * @version 1.0.0
 * @since 2026-04-11
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    /**
     * Find Product by name.
     * 
     * @param name the name to search for
     * @return optional containing the Product if found
     */
    Optional<Product> findByName(String name);

    /**
     * Find all Products with a specific status.
     * 
     * @param status the status to filter by
     * @return list of Products with the specified status
     */
    List<Product> findByStatus(Product.ProductStatus status);

    /**
     * Find Products by name containing the given string (case-insensitive).
     * 
     * @param name the name fragment to search for
     * @return list of matching Products
     */
    @Query("SELECT e FROM Product e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Product> findByNameContainingIgnoreCase(@Param("name") String name);

    /**
     * Find Products created after a specific date.
     * 
     * @param date the date to filter by
     * @return list of Products created after the date
     */
    @Query("SELECT e FROM Product e WHERE e.createdAt > :date")
    List<Product> findByCreatedAtAfter(@Param("date") java.time.LocalDateTime date);

    /**
     * Count Products by status.
     * 
     * @param status the status to count
     * @return the count of Products with the specified status
     */
    long countByStatus(Product.ProductStatus status);

    /**
     * Check if a Product with the given name exists.
     * 
     * @param name the name to check
     * @return true if a Product with the name exists, false otherwise
     */
    boolean existsByName(String name);
}
