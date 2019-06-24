package com.example.logs_challenge.service;

import com.example.logs_challenge.model.Event;
import com.example.logs_challenge.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public void save(Event event) {
        eventRepository.saveAndFlush(event);
    }

    public Event findElement(String id) {
        return eventRepository.findElement(id);
    }


}
