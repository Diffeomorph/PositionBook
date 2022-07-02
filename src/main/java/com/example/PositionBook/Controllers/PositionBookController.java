package com.example.PositionBook.Controllers;

import com.example.PositionBook.Services.PositionBook;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.TreeMap;

@RestController
public class PositionBookController {

    @Autowired
    private PositionBook positionBook;

    // Get all position book
    @GetMapping("/position_book")
    String getPositionBook() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
            try {
            String json = mapper.writeValueAsString(positionBook);
            return json;
        } catch (JsonProcessingException e) {
                e.printStackTrace();
            return "";
        }
    }

    // Process payment and receive true/false confirmation
    @PostMapping("/payments")


    @DeleteMapping("/payments/{id}")
    void deletePayment(){
        // code
    }

    @PutMapping("/payments/{id}")
    void updatePayment(){
        //code
    }
}




}

