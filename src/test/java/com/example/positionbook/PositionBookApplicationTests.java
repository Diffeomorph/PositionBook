package com.example.positionbook;

import com.example.positionbook.controllers.PositionBookController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
class PositionBookApplicationTests {

	@Autowired
	private PositionBookController positionBookController;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(positionBookController).build();
	}

	@Test
	void testTradeEventEndPoint() throws Exception {
		String newEventsJson = "{\"Events\":[{\"ID\":1,\"Action\":\"BUY1\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":12},{\"ID\":2,\"Action\":\"BUY1\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":24}]}";
		mockMvc.perform(post("/events").contentType(MediaType.APPLICATION_JSON).content(newEventsJson));

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/positions")).andReturn();
		String content = result.getResponse().getContentAsString();

		String expected = "[{\"account\":\"ACC1\",\"security\":\"SEC1\",\"quantity\":0,\"events\":[{\"ID\":1,\"Action\":\"BUY1\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":12},{\"ID\":2,\"Action\":\"BUY1\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":24}]}]";
		assertEquals(expected,content);
	}

}
