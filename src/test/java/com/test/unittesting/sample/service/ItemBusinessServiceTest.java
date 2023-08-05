package com.test.unittesting.sample.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.unittesting.sample.model.Item;
import com.test.unittesting.sample.repository.ItemRepository;

//@RunWith(MockitoJUnitRunner.class) //@RunWith is for Junit 4, use @ExtendWith for Junit 5
@ExtendWith(MockitoExtension.class)
//@SpringBootTest
class ItemBusinessServiceTest {

	@InjectMocks
	private ItemBusinessService itemBusinessService;
	
	@Mock
	private ItemRepository itemRepository;
	
	@Test
	void getAllItemsTest() {
		
		List<Item> items = new ArrayList<>();
		items.add(new Item(1,"Item1", 10, 20));
		items.add(new Item(2,"Item2", 20, 40));
		items.add(new Item(2,"Item2", 20, 40));
		items.add(new Item(2,"Item2", 20, 40));
		items.add(new Item(2,"Item2", 20, 40));
		items.add(new Item(2,"Item2", 20, 40));
		items.add(new Item(2,"Item2", 20, 40));
		items.add(new Item(2,"Item2", 20, 40));
		items.add(new Item(2,"Item2", 20, 40));
		items.add(new Item(2,"Item2", 20, 40));
		items.add(new Item(2,"Item2", 20, 40));
		
		when(itemRepository.findAll()).thenReturn(items);
		
		List<Item> itemsList = itemBusinessService.getAllItems();
		assertEquals(11, itemsList.size());
	}

}
