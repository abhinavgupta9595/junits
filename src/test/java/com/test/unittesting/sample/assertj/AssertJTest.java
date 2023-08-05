package com.test.unittesting.sample.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AssertJTest {

	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(10,12,14,16,18);
		
		assertThat(numbers).hasSize(5).contains(12,14);
		assertThat(numbers).allMatch(num -> num>5).allMatch(num -> num < 100).noneMatch(num -> num < 0);
	}
}
