package com.tek.interview.question;

import java.math.BigDecimal;
import java.util.Map;

public class Calculator {

	public static double rounding(double value, int roundingMode) {
		return new BigDecimal(value).setScale(2, roundingMode).doubleValue();
	}

	/**
	 * receives a collection of orders. For each order, iterates on the order lines
	 * and calculate the total price which is the item's price * quantity * taxes.
	 * <p>
	 * For each order, print the total Sales Tax paid and Total price without taxes
	 * for this order
	 */
	public static void calculate(Map<String, Order> orderMap) {

		double grandtotal = 0;

		// Iterate through the orders
		for (Map.Entry<String, Order> entry : orderMap.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");

			Order order = entry.getValue();

			double totalTax = 0;
			double total = 0;

			boolean isImported = false;

			// Iterate through the items in the order
			for (int i = 0; i < order.size(); i++) {

				// Calculate the taxes
				double tax = 0;

				if (order.get(i).getItem().getDescription().toLowerCase().contains("imported")) {
					tax = order.get(i).getItem().getPrice() * order.get(i).getQuantity() * 0.15; // Extra 5% tax on
					isImported = true;
					// imported items
				} else {

					tax = order.get(i).getItem().getPrice() * order.get(i).getQuantity() * 0.10;
				}

				// Calculate the total price
				double totalprice = order.get(i).getItem().getPrice() * order.get(i).getQuantity() + tax;
				// Print out the item's total price
				System.out.println(order.get(i).getQuantity() + " " + order.get(i).getItem().getDescription() + ": "
						+ rounding(totalprice, BigDecimal.ROUND_UP));

				// Keep a running total
				totalTax += tax;
				total += totalprice - tax;
			}

			// Print out the total taxes
			if (isImported)
				System.out.println("Sales Tax: " + rounding(totalTax, BigDecimal.ROUND_DOWN));
			else
				System.out.println("Sales Tax: " + rounding(totalTax, BigDecimal.ROUND_UP));

			// Print out the total amount
			System.out.println("Total: " + rounding(total, BigDecimal.ROUND_UP));
			grandtotal += total;
		}

		System.out.println("Sum of orders: " + rounding(grandtotal, BigDecimal.ROUND_UP));
	}
}
