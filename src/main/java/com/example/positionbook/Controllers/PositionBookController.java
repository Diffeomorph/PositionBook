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
        return positions.toString();
    }

    @PostMapping("/events")
    void sendTradeEvents(@RequestBody Events newEvents) {
        positions.processNewEvents(newEvents);
    }

}


