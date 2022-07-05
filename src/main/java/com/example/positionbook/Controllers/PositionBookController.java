package com.example.positionbook.Controllers;

import com.example.positionbook.Services.Events;
import com.example.positionbook.Services.Positions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class PositionBookController {

    @Autowired
    private Positions positions;

    // Get all position book
    @GetMapping("/positions")
    String getPositionBook() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
            try {
            String json = mapper.writeValueAsString(positions);
            return json;
        } catch (JsonProcessingException e) {
                e.printStackTrace();
            return "";
        }
    }

    @PostMapping("/events")
    void sendTradeEvents(@RequestBody Events newEvents) {
        positions.processNewEvents(newEvents);
    }

}


