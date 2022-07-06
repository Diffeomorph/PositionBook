package com.example.positionbook;

import com.example.positionbook.controllers.PositionBookController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
	void testBuyingSecurities() throws Exception {
		String newEventsJson = "{\"Events\":[{\"ID\":1,\"Action\":\"BUY1\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":12},{\"ID\":2,\"Action\":\"BUY1\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":24}]}";
		mockMvc.perform(post("/events").contentType(MediaType.APPLICATION_JSON).content(newEventsJson));

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/positions")).andReturn();
		String content = result.getResponse().getContentAsString();

		String expected = "[{\"account\":\"ACC1\",\"security\":\"SEC1\",\"quantity\":0,\"events\":[{\"ID\":1,\"Action\":\"BUY1\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":12},{\"ID\":2,\"Action\":\"BUY1\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":24}]}]";
		assertEquals(expected,content);
	}

	@Test
	void testBuyingDifferentSecurities2() throws Exception {
		String newEventsJson = "{\"Events\":[{\"ID\":1,\"Action\":\"BUY1\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":12},{\"ID\":2,\"Action\":\"BUY1\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":24}]}";
		mockMvc.perform(post("/events").contentType(MediaType.APPLICATION_JSON).content(newEventsJson));

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/positions")).andReturn();
		String content = result.getResponse().getContentAsString();

		String expected = "[{\"account\":\"ACC1\",\"security\":\"SEC1\",\"quantity\":0,\"events\":[{\"ID\":3,\"Action\":\"BUY1\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":12},{\"ID\":6,\"Action\":\"BUY1\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":20}]},{\"account\":\"ACC1\",\"security\":\"SECXYZ\",\"quantity\":0,\"events\":[{\"ID\":4,\"Action\":\"BUY1\",\"Account\":\"ACC1\",\"Security\":\"SECXYZ\",\"Quantity\":50}]},{\"account\":\"ACC2\",\"security\":\"SECXYZ\",\"quantity\":0,\"events\":[{\"ID\":5,\"Action\":\"BUY1\",\"Account\":\"ACC2\",\"Security\":\"SECXYZ\",\"Quantity\":33}]}]";
		assertEquals(expected,content);
	}

	@Test
	void testBuyingAndSellingSecurities() throws Exception {
		String newEventsJson = "{\"Events\":[{\"ID\":7,\"Action\":\"BUY\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":100},{\"ID\":8,\"Action\":\"SELL\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":50}]}";
		mockMvc.perform(post("/events").contentType(MediaType.APPLICATION_JSON).content(newEventsJson));

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/positions")).andReturn();
		String content = result.getResponse().getContentAsString();

		String expected = "[{\"account\":\"ACC1\",\"security\":\"SEC1\",\"quantity\":50,\"events\":[{\"ID\":7,\"Action\":\"BUY\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":100},{\"ID\":8,\"Action\":\"SELL\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":50}]}]";
		assertEquals(expected,content);
	}

	@Test
	void testCancellingEvents() throws Exception {
		String newEventsJson = "{\"Events\":[{\"ID\":9,\"Action\":\"BUY\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":100},{\"ID\":9,\"Action\":\"CANCEL\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":0},{\"ID\":10,\"Action\":\"BUY\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":5}]}";
		mockMvc.perform(post("/events").contentType(MediaType.APPLICATION_JSON).content(newEventsJson));

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/positions")).andReturn();
		String content = result.getResponse().getContentAsString();

		String expected = "[{\"account\":\"ACC1\",\"security\":\"SEC1\",\"quantity\":5,\"events\":[{\"ID\":9,\"Action\":\"BUY\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":100},{\"ID\":9,\"Action\":\"CANCEL\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":0},{\"ID\":10,\"Action\":\"BUY\",\"Account\":\"ACC1\",\"Security\":\"SEC1\",\"Quantity\":5}]}]";
		assertEquals(expected,content);
	}

}
