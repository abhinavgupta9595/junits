package com.test.unittesting.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.unittesting.sample.model.Item;
import com.test.unittesting.sample.service.ItemBusinessService;

@RestController
public class ItemController {

	@Autowired
	private ItemBusinessService itemService;
	
	@GetMapping("/dummy-item")
	public Item getItem() {
		return new Item(1, "Ball", 10, 100);
	}
	
	@GetMapping("/dummy-item-from-business-service")
	public Item getItemFromBusinessService() {
		return itemService.retrieveHardCodedItem();
	}
	
	@GetMapping("/getAllItems")
	public List<Item> getAllItems(){
		return itemService.getAllItems();
	}
	
}
