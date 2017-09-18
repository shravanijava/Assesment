package com.tek.interview.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.tek.interview.question.Calculator;

public class CalculatorTest {

	@Test
	/**
	 * Test the rounding operation with two options ROUNDING_UP and ROUNDING_DOWN.
	 * This rounding operation is done for two decimal points
	 * 
	 * @throws Exception if something goes wrong.
	 */
	public void testRound() throws Exception {
		assertEquals(13.54, Calculator.rounding(13.538970123, BigDecimal.ROUND_UP), 0);
		assertEquals(13.53, Calculator.rounding(13.538970123, BigDecimal.ROUND_DOWN), 0);

	}

}
