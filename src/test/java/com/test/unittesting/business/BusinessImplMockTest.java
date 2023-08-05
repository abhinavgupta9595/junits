package com.test.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.unittesting.data.DataService;

//ExtendWith annotation is needed if we want to use @InjectMocks, @Mock annotation instead of mock() method
@ExtendWith(MockitoExtension.class)
class BusinessImplMockTest {
	
	@InjectMocks
	private BusinessImpl businessImpl = new BusinessImpl();
	
	@Mock
	private DataService dataServiceMock;
	
	@BeforeEach
	public void impl() {
		//if we use @InjectMocks in businessImpl obj above, no need to set using below method, hence commenting
		//businessImpl.setDataService(dataServiceMock);
	}
	
	@Test
	void testSumUsingDataService_basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3,4});
		int actualSum = businessImpl.sumUsingDataService();
		int expectedSum = 10;
		assertEquals(expectedSum, actualSum);
	}
	
	@Test
	void testSumUsingDataService_emptyArray() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		int actualSum = businessImpl.sumUsingDataService();
		int expectedSum = 0;
		assertEquals(expectedSum, actualSum);
	}

}
