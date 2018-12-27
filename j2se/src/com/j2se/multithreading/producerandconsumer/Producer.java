package com.j2se.multithreading.producerandconsumer;

public class Producer implements Runnable {
	private int limit = 0;
	private Product product = null;

	public Producer(Product product, int limit) {
		this.limit = limit;
		this.product = product;
		
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (product.getNo() < limit) {
			product.produce();
		}
	}
}