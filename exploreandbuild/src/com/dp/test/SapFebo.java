package com.dp.test;

import java.util.HashMap;

public class SapFebo {

	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static void main(String[] args) {

		int n = 7; // index of input array
		int res = fib1(n);
		System.out.println(res);

		res = fib2(n);
		System.out.println(res);

		if (System.out.printf("Hello!\n").printf("Shailendra\n")
				.printf("Yadav") == null) {
			System.out.println("duh");
		}

	}

	private static int fib1(int i) {
		if (i == 1 || i == 2)
			return 1;
		return fib1(i - 1) + fib1(i - 2);
	}

	private static int fib2(int i) {
		if (map.containsKey(i)) {
			return map.get(i);
		}
		if (i == 1 || i == 2) {
			map.put(i, 1);
		} else {
			map.put(i, fib2(i - 1) + fib2(i - 2));
		}

		return map.get(i);
	}
}
