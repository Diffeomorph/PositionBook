package com.example.PositionBook.Controllers;

import com.example.PositionBook.Services.Event;
import com.example.PositionBook.Services.Events;
import com.example.PositionBook.Services.Position;
import com.example.PositionBook.Services.Positions;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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

    @PostMapping("/events")
    void sendTradeEvents(@RequestBody Events newEvents) {
        HashMap<String,Position> curHashMap = new HashMap<>();
        System.out.println("here1");
        System.out.println(newEvents.getEvents());
        for (Event curEvent : newEvents.getEvents()){
            String curAccount = curEvent.getAccount();
            String curSecurity = curEvent.getSecurity();
            Position curPosition = curHashMap.getOrDefault(curAccount+curSecurity, new Position());
            curPosition.addEvent(curEvent);
            int curQuantity = curPosition.getQuantity();
            curQuantity += curEvent.getQuantity();
            curPosition.setQuantity(curQuantity);
            curHashMap.put(curAccount+curSecurity,curPosition);
        }
        for (var entry : curHashMap.entrySet()) {
            positions.addPosition(entry.getValue());
        }
    }

    @DeleteMapping("/events/{id}")
    void deletePayment(){
        // code
    }

    @PutMapping("/events/{id}")
    void updatePayment(){
        //code
    }
}


