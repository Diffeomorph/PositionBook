package com.example.PositionBook.Controllers;

import com.example.PositionBook.Services.Events;
import com.example.PositionBook.Services.Positions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PositionBookController {

    @Autowired
    private Positions positions;

    // Get all position book
    @GetMapping("/position_book")
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

    // Process payment and receive true/false confirmation
    @PostMapping("/events")
    void sendTradeEvents(@RequestBody Events newEvents) {
        System.out.println("first");
        System.out.println(newEvents.getEvents());
        positions.addEventsListToPositionBook(newEvents);
        System.out.println("third");
    }

    @DeleteMapping("/payments/{id}")
    void deletePayment(){
        // code
    }

    @PutMapping("/payments/{id}")
    void updatePayment(){
        //code
    }
}


