package com.renzo.labs.ticketing.event.infrastructure;

import com.renzo.labs.ticketing.event.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByOrderByDateAsc();
}
