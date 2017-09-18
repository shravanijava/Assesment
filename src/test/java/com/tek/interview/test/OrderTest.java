package com.tek.interview.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tek.interview.question.Item;
import com.tek.interview.question.Order;
import com.tek.interview.question.OrderLine;

public class OrderTest {

	@Test
	/**
	 * Test the order creation and different methods available in order class.
	 * 
	 * @throws Exception if something goes wrong
	 */
	public void testOrder() throws Exception {
		Order order = new Order();

		order.add(new OrderLine(new Item("book", (float) 12.49), 1));
		order.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		order.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		assertEquals(3, order.size());
		order.clear();
		assertEquals(0, order.size());
	}
	
}
