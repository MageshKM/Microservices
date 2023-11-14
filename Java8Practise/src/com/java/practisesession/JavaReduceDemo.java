package com.java.practisesession;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class JavaReduceDemo {

	public static void main(String[] args) {

		List<Invoice> invoices = Arrays.asList(new Invoice("A01", BigDecimal.valueOf(9.99), BigDecimal.valueOf(1)),
				new Invoice("A02", BigDecimal.valueOf(19.99), BigDecimal.valueOf(1.5)),
				new Invoice("A03", BigDecimal.valueOf(4.99), BigDecimal.valueOf(2)));

		BigDecimal sum = invoices.stream().map(x -> x.getQty().multiply(x.getPrice())) // map
				.reduce(BigDecimal.ZERO, BigDecimal::add); // reduce

		System.out.println(sum); // 49.955
		System.out.println(sum.setScale(2, RoundingMode.HALF_UP)); // 49.96

		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int max = Arrays.stream(numbers).reduce(0, (a, b) -> a > b ? a : b); // 10
		int max1 = Arrays.stream(numbers).reduce(0, Integer::max); // 10

		System.out.println("MAX -> " + max + "--" + max1);

		int min = Arrays.stream(numbers).reduce(0, (a, b) -> a < b ? a : b); // 0
		int min1 = Arrays.stream(numbers).reduce(0, Integer::min);
		System.out.println("MIN -> " + min + "--" + min1);

		System.out.println("-------Suming Technique-------------");
		int sum0 = Arrays.stream(numbers).reduce(0, (a, b) -> a + b); // 55
		System.out.println("a + b :" + sum0);
		int sum2 = Arrays.stream(numbers).reduce(0, Integer::sum); // 55
		System.out.println("Integer::sum :" + sum2);

		int sum3 = Arrays.stream(numbers).reduce(0, (a, b) -> a - b); // -55
		System.out.println(" a - b :" + sum3);
		int sum4 = Arrays.stream(numbers).reduce(0, (a, b) -> a * b); // 0, initial is 0, 0 * whatever = 0
		System.out.println(" a * b :" + sum4);
		int sum5 = Arrays.stream(numbers).reduce(0, (a, b) -> a / b);
		System.out.println(" a / b :" + sum5);
	}

}

class Invoice {

	String invoiceNo;
	BigDecimal price;
	BigDecimal qty;

	public Invoice(String invoiceNo, BigDecimal price, BigDecimal qty) {
		super();
		this.invoiceNo = invoiceNo;
		this.price = price;
		this.qty = qty;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	// getters, stters n constructor
}
