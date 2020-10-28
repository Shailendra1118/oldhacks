package com.interview.asked;

public class ThreadJoin extends Thread {

	static String value = "testify";
	static int value1 = 25;

	static {
		value1 = 50;
		System.out.println(value);
		System.out.println(value1);
	}

	public static void main(String[] args) {
		Thread t1 = new Thread("T1");
		Thread t2 = new Thread("T2");
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			System.out.println("Main Thread interrupted.");
		}
	}

	public void run() {
		System.out.println("Run executed");
	}
}