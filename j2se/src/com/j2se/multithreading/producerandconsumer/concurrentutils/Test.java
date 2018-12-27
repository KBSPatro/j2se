package com.j2se.multithreading.producerandconsumer.concurrentutils;

public class Test {
	public static void main(String[] args) {
		Product p = new Product();

		new Producer(p, 10);
		new Consumer(p, 10);
	}
}
