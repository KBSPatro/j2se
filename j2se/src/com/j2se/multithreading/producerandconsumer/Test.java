package com.j2se.multithreading.producerandconsumer;

public class Test {
	public static void main(String[] args) {
		Product product = new Product();

		new Producer(product, 10);
		new Consumer(product, 10);
	}
}
