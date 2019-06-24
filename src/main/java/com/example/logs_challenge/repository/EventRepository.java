package com.example.logs_challenge.repository;

import com.example.logs_challenge.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

    @Query("SELECT e FROM Event e WHERE e.id = :id")
    Event findElement(@Param("id") String id);
}
