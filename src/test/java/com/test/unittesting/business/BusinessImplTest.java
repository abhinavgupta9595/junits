package com.test.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BusinessImplTest {
	
	@Test
	void testSum() {
		BusinessImpl businessImpl = new BusinessImpl();
		int[] nums = {1,2,3,4,5};
		int actualSum = businessImpl.sum(nums);
		int expectedSum = 15;
		assertEquals(expectedSum, actualSum);
	}

}
