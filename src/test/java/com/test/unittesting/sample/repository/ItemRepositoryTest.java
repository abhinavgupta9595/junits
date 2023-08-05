package com.test.unittesting.sample.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.test.unittesting.sample.model.Item;
import com.test.unittesting.sample.repository.ItemRepository;

@DataJpaTest
class ItemRepositoryTest {

	@Autowired
	ItemRepository itemRepo;
	
	@Test
	void getAllItems() {
		List<Item> items = itemRepo.findAll();
		assertEquals(5, items.size());
	}

}
