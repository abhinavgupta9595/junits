package com.test.unittesting.sample.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.test.unittesting.sample.model.Item;
import com.test.unittesting.sample.service.ItemBusinessService;

//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(ItemController.class)
class ItemControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ItemBusinessService businessServ;
	
	@Test
	void getItemTest_basic() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				//.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}", true))
				.andReturn();
		
		// if we use string there should not be any spaces, and should be excat same json by json
		//for json responses use json() method instead of string() method
	}
	
	
	@Test
	void getItemTest_businessService() throws Exception {
		
		when(businessServ.retrieveHardCodedItem()).thenReturn(new Item(2, "Bat", 20, 80));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":2,\"name\":\"Bat\",\"price\":20,\"quantity\":80}"))
				//.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}", true))
				.andReturn();
		
		// if we use string there should not be any spaces, and should be excat same json by json
		//for json responses use json() method instead of string() method
	}
	
	@Test
	void getAllItems_fromDB() throws Exception {
		
		List<Item> items = new ArrayList<>();
		items.add(new Item(2, "Bat", 20, 80));
		
		when(businessServ.getAllItems()).thenReturn(items);
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/getAllItems")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":2,\"name\":\"Bat\",\"price\":20,\"quantity\":80}]"))
				//.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}", true))
				.andReturn();
		
		// if we use string there should not be any spaces, and should be excat same json by json
		//for json responses use json() method instead of string() method
	}

}
