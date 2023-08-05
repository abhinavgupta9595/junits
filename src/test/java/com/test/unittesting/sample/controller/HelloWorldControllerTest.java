package com.test.unittesting.sample.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


//either use @WebMvcTest or use both @SpringBootTest and @AutoConfigureMockMvc
@WebMvcTest(HelloWorldController.class)
//@SpringBootTest
//@AutoConfigureMockMvc
class HelloWorldControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void helloWorld_basic() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/hello-world")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mvc.perform(request)
				.andExpect(status().isOk())  //use this or below any one is fine, use below for specific statuses
				.andExpect(status().is(200))
				.andExpect(content().string("Hello World!"))
				.andReturn();
		
		//no need for below as we are asserting it above using andExpect() method
		//assertEquals("Hello World!", result.getResponse().getContentAsString());
	}

}
