package com.example.logs_challenge.thread;

import com.example.logs_challenge.model.Event;
import com.example.logs_challenge.service.EventService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    EventService eventService;

    private static final Logger LOG = LoggerFactory.getLogger(EventService.class);

    @Override
    @Async("asyncExecutor")
    public void run(String... args) throws Exception {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Long eventDuration;
            List<Event> list = new ArrayList<>();
            Event eventFound = new Event();
            JsonParser parser;

            /*Jackson Streaming
            * Use log.json static file to Unit test*/
            if(args.length > 0){
                parser = objectMapper.getFactory().createParser(new File(args[0]));
            }else{
                parser = objectMapper.getFactory().createParser(new File("log.json"));
            }
            if(parser.nextToken() != JsonToken.START_ARRAY) {
                throw new IllegalStateException("Expected an array");
            }
            while(parser.nextToken() == JsonToken.START_OBJECT) {
                ObjectNode node = objectMapper.readTree(parser);
                Event event = objectMapper.treeToValue(node, Event.class);

                if(!list.isEmpty() && list != null){
                    for(Event e : list){
                        if(e.getId().equals(event.getId())){
                            eventFound = e;
                        }
                    }
                }

                if (eventFound.getId() != null) {
                    eventFound = eventService.findElement(eventFound.getId());
                    if ("FINISHED".equals(event.getState())) {
                        eventDuration = event.getTimestamp() - eventFound.getTimestamp();
                    } else {
                        eventDuration = eventFound.getTimestamp() - event.getTimestamp();
                    }

                    if(eventDuration > 4){
                        eventFound.setAlert(true);
                    }
                    eventFound.setTimestamp(eventDuration);
                    eventService.save(eventFound);

                } else {
                    LOG.info("Saving  ID: " + event.getId());
                    eventService.save(event);
                }
                list.add(event);

            }
            parser.close();

        } catch (IOException e) {
            LOG.info("Unable to save event: " + e.getMessage());
        }

    }
}
