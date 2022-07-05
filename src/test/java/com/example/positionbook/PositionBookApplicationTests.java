package com.example.positionbook;

import com.example.positionbook.controllers.PositionBookController;
import com.example.positionbook.services.Events;
import com.example.positionbook.services.Positions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest
class PositionBookApplicationTests {

	@Autowired
	private Positions positionsTest;

	@Test
	void contextLoads() {
	}

	@Test
	void testTradeEventEndPoint(){
		PositionBookController pbcTest = new PositionBookController();
		String newEventsJson = new String("{\n" +
				"    \"Events\": [\n" +
				"        {\n" +
				"            \"ID\": 1,\n" +
				"            \"Action\": \"BUY1\",\n" +
				"            \"Account\": \"ACC1\",\n" +
				"            \"Security\": \"SEC1\",\n" +
				"            \"Quantity\": 12\n" +
				"        },\n" +
				"        {\n" +
				"            \"ID\": 2,\n" +
				"            \"Action\": \"BUY1\",\n" +
				"            \"Account\": \"ACC1\",\n" +
				"            \"Security\": \"SEC1\",\n" +
				"            \"Quantity\": 24\n" +
				"        }\n" +
				"    ]\n" +
				"}");
		pbcTest.sendTradeEvents(newEventsJson);
		assertArrayEquals(positionsTest., true);
	}

}
