package com.test.unittesting.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.unittesting.sample.model.Item;
import com.test.unittesting.sample.repository.ItemRepository;

@Service
public class ItemBusinessService {

	@Autowired
	private ItemRepository itemRepo;
	
	public Item retrieveHardCodedItem() {
		return new Item(2, "Bat", 20, 50);
	}
	
	public List<Item> getAllItems(){
		List<Item> items = itemRepo.findAll();
		
		for(Item item : items) {
			item.setValue(item.getPrice()* item.getQuantity());
		}
		return items;
	}
}
