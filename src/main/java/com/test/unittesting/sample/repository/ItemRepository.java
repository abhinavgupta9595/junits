package com.test.unittesting.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.unittesting.sample.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

}
