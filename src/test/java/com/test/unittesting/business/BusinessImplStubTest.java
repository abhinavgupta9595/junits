package com.test.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.test.unittesting.data.DataService;

//created a stub class for DataService
//for different test scenarios we would need to create multiple stubs, such as empty array, or an array with one element
class DataServiceStubImpl implements DataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {1,2,3,4,5};
	}
	
}
class BusinessImplStubTest {

	@Test
	void testSumUsingDataService_usingStub() {
		BusinessImpl businessImpl = new BusinessImpl();
		businessImpl.setDataService(new DataServiceStubImpl());
		int actualSum = businessImpl.sumUsingDataService();
		int expectedSum = 15;
		assertEquals(expectedSum, actualSum);
	}
}
