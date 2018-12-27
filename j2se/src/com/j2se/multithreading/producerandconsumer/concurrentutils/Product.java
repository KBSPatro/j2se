package com.j2se.multithreading.producerandconsumer.concurrentutils;

import java.util.concurrent.Semaphore;

public class Product {
	private int no = 0;

	Semaphore producerSem = new Semaphore(1);
	Semaphore consumerSem = new Semaphore(0);
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void produce() {
		try {
			producerSem.acquire();
			no++;
			System.out.println("Produced : " + no);
			consumerSem.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void consume() {
		try {
			consumerSem.acquire();
			System.out.println("Consumed : " + no);
			producerSem.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
