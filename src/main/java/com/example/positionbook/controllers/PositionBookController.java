package com.example.positionbook.controllers;

import com.example.positionbook.services.Events;
import com.example.positionbook.services.Position;
import com.example.positionbook.services.Positions;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PositionBookController {

    @Autowired
    private Positions positions;

    // Get all position book
    @GetMapping("/positions")
    List<Position> getPositionBook() throws JsonProcessingException {
        return positions.getPositions();
    }

    @PostMapping("/events")
    void sendTradeEvents(@RequestBody Events newEvents) {
        positions.processNewEvents(newEvents);
    }

}


