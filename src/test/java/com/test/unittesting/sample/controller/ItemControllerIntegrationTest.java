package com.test.unittesting.sample.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.test.unittesting.sample.model.Item;
import com.test.unittesting.sample.repository.ItemRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	//@MockBean
	//private ItemRepository itemRepo;
	
	@Test
	public void contextLoads() throws JSONException {
		String response = this.restTemplate.getForObject("/getAllItems", String.class);
		JSONAssert.assertEquals("[{\"id\":1001,\"name\":\"Item1\",\"price\":10,\"quantity\":30,\"value\":300},{\"id\":1002,\"name\":\"Item2\",\"price\":20,\"quantity\":40,\"value\":800},{\"id\":1003,\"name\":\"Item3\",\"price\":5,\"quantity\":80,\"value\":400},{\"id\":1004,\"name\":\"Item4\",\"price\":15,\"quantity\":50,\"value\":750},{\"id\":1005,\"name\":\"Item5\",\"price\":30,\"quantity\":60,\"value\":1800}]", 
				response, false);
	}
	
	/*
	@Test
	public void testMockRepo() throws JSONException {
		List<Item> list = new ArrayList<>();
		list.add(new Item(2, "bat", 20, 80));
		list.add(new Item(2, "bat", 20, 80));
		list.add(new Item(2, "bat", 20, 80));
		list.add(new Item(2, "bat", 20, 80));
		list.add(new Item(2, "bat", 20, 80));
		
		when(itemRepo.findAll()).thenReturn(list);
		String response = this.restTemplate.getForObject("/getAllItems", String.class);
		JSONAssert.assertEquals("[{\"id\":1001,\"name\":\"Item1\",\"price\":10,\"quantity\":30,\"value\":300},{\"id\":1002,\"name\":\"Item2\",\"price\":20,\"quantity\":40,\"value\":800},{\"id\":1003,\"name\":\"Item3\",\"price\":5,\"quantity\":80,\"value\":400},{\"id\":1004,\"name\":\"Item4\",\"price\":15,\"quantity\":50,\"value\":750},{\"id\":1005,\"name\":\"Item5\",\"price\":30,\"quantity\":60,\"value\":1800}]", 
				response, false);
	}
	*/
}
