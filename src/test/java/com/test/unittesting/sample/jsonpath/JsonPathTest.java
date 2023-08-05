package com.test.unittesting.sample.jsonpath;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	@Test
	public void testJsonPath() {
		String responseFromService = "[\r\n"
				+ "{\"id\":1000, \"name\":\"Pencil\", \"quantity\":5},"
				+ "{\"id\":1001, \"name\":\"Pen\", \"quantity\":15},"
				+ "{\"id\":1002, \"name\":\"Eraser\", \"quantity\":10}"
				+ "]";
		
		DocumentContext context = JsonPath.parse(responseFromService);
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
		
		List<Integer> listOfIds = context.read("$..id");
		
		assertThat(listOfIds).containsExactly(1000,1001,1002);
		
		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[0:1]").toString());
		System.out.println("--------------------------------");
		System.out.println(context.read("$.[?(@.name=='Eraser')]").toString());
		System.out.println("--------------------------------");
		System.out.println(context.read("$.[?(@.quantity==5)]").toString());
	}
}
