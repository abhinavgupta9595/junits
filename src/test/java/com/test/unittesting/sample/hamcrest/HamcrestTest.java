package com.test.unittesting.sample.hamcrest;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.containsString;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class HamcrestTest {

	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(10,12,14,16,18);
		assertThat(numbers, hasSize(5));
		assertThat(numbers, hasItems(12,18));
		assertThat(numbers, everyItem(greaterThan(5)));
		assertThat(numbers, everyItem(lessThan(100)));
		
		assertThat("", isEmptyString());
		assertThat("ABCDE", containsString("BCD"));
	}
}
