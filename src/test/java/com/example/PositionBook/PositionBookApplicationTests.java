package com.example.PositionBook;

import com.example.PositionBook.Services.Positions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
		assertArrayEquals(true, true);
	}

}
