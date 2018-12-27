package com.j2se.multithreading.producerandconsumer;

public class Product {
	private int no = 0;
	private boolean flag = false;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public synchronized void produce() {
		try {
			if (flag)
				wait();
			else {
				no++;
				System.out.println("Produced : " + no);
				flag = true;
				notify();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void consume() {
		try {
			if (!flag)
				wait();
			else {
				System.out.println("Consumed : " + no);
				flag = false;
				notify();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
