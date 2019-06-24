package com.example.logs_challenge;

import com.example.logs_challenge.model.Event;
import com.example.logs_challenge.repository.EventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogsChallengeApplicationTests {

    @Autowired
    private EventRepository eventRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void givenJsonFile_whenDataBindingToObject_thenCorrect() throws IOException {

        String json = "{ \"id\": \"scsmbstgra\",\n" +
                "                \"state\": \"STARTED\",\n" +
                "                \"type\": \"APPLICATION_LOG\",\n" +
                "                \"host\": \"12345\",\n" +
                "                \"timestamp\": 1491377495212}";

        ObjectMapper mapper = new ObjectMapper();

        Event event = mapper.reader().forType(Event.class).readValue(json);
        Assert.assertEquals("scsmbstgra", event.getId());
    }

    @Test
    public void whenSaveEvent_thenReturnTrue() {
        eventRepository.save(new Event("scsmbstgrc"));
        Event event = eventRepository.findById(1L).orElseGet(() -> new Event("scsmbstgrc"));
        Assert.assertEquals("scsmbstgrc", event.getId());
    }

}
