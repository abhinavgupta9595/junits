package com.test.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class ListMockTest {

	@Test
	void size_basic() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(5);
		assertEquals(5, mockList.size());
	}
	
	@Test
	void size_returnDiffValues() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mockList.size());
		assertEquals(10, mockList.size());
		
	}
	
	@Test
	void returnWithParameters() {
		List mockList = mock(List.class);
		when(mockList.get(0)).thenReturn(100);
		assertEquals(100, mockList.get(0));
		//below will fail as we have not declared mockito for mockList.get(1), we can use arguement matcher
		//refer to the method returnWithGenericParameters below
		assertEquals(100, mockList.get(1));
		
	}
	
	@Test
	void returnWithGenericParameters() {
		List mockList = mock(List.class);
		when(mockList.get(Mockito.anyInt())).thenReturn(100);
		assertEquals(100, mockList.get(1));		
	}
	
	//verify method to check how many times a mock is called.
	@Test
	void verificationBasics() {
		List<String> mockList = mock(List.class);
		String str = mockList.get(0);
		String str1 = mockList.get(1);
				
		//verify(mockList).get(0);
		//verify(mockList).get(anyInt());
		
		verify(mockList, times(2)).get(anyInt());
		//verify(mockList, times(2)).get(anyInt());
		verify(mockList, atLeast(1)).get(anyInt());
		verify(mockList, atMost(2)).get(anyInt());
		verify(mockList, never()).get(2);
	}
	
	@Test
	void argumentCapture() {
		List<String> mockList = mock(List.class);
		mockList.add("SomeString");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mockList).add(captor.capture());
		
		assertEquals("SomeString", captor.getValue());
	}
	
	@Test
	void multipleArgumentCapture() {
		List<String> mockList = mock(List.class);
		mockList.add("SomeString");
		mockList.add("SomeOtherString");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mockList, times(2)).add(captor.capture());
		
		List<String> list = captor.getAllValues();
		assertEquals("SomeOtherString", list.get(1));
		
	}
	
	//Spying is to retain original behavior of the class
	@Test
	void mocking() {
		List arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0)); //null
		System.out.println(arrayListMock.size()); //0
		arrayListMock.add("Test1");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size()); //0
		when(arrayListMock.size()).thenReturn(10);
		System.out.println(arrayListMock.size()); //10
	}
	
	@Test
	void spying() {
		List arrayListMock = spy(ArrayList.class);
		arrayListMock.add("Test0");
		System.out.println(arrayListMock.get(0)); //Test0
		System.out.println(arrayListMock.size()); //1
		arrayListMock.add("Test1");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size()); //3
		when(arrayListMock.size()).thenReturn(10);
		System.out.println(arrayListMock.size()); //10
	}
}
