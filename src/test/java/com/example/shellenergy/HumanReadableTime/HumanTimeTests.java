package com.example.shellenergy.HumanReadableTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HumanTimeTests {
	@Test
	public void shouldReturnZerosWhenZeroSecondsIsInput(){
		HumanTime humanTime = new HumanTime();
		String expected = "00:00:00";
		String actual = humanTime.getReadableTime(0);
		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnErrorWhenNegativeNumberIsInput(){
		HumanTime humanTime = new HumanTime();

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			humanTime.getReadableTime(-1);
		});

		String expectedMessage = "Input is invalid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.equals(expectedMessage));
	}

	@Test
	public void shouldReturnErrorWhenNumberLimitIsExceeded(){
		HumanTime humanTime = new HumanTime();

		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			humanTime.getReadableTime(360000);
		});

		String expectedMessage = "Input is invalid";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.equals(expectedMessage));
	}

	@Test
	public void shouldReturnFiftyInTheSecondsColumnOnly(){
		HumanTime humanTime = new HumanTime();
		String expected = "00:00:50";
		String actual = humanTime.getReadableTime(50);
		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnZeroOneThirtyInTheMinutesAndSecondsColumnOnly(){
		HumanTime humanTime = new HumanTime();
		String expected = "00:01:30";
		String actual = humanTime.getReadableTime(90);
		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnZeroOneZeroOneZeroOneInAllColumns(){
		HumanTime humanTime = new HumanTime();
		String expected = "01:01:01";
		String actual = humanTime.getReadableTime(3661);
		assertEquals(expected, actual);
	}

	@Test
	public void shouldReturnLargestPossibleNumber(){
		HumanTime humanTime = new HumanTime();
		String expected = "99:59:59";
		String actual = humanTime.getReadableTime(359999);
		assertEquals(expected, actual);
	}

}
