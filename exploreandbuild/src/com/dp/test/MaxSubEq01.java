package com.dp.test;

import java.util.Arrays;
import java.util.HashMap;

public class MaxSubEq01 {

	public static void main(String[] args) {
		// int arr[] = { 1, 0, 1, 1, 1, 0, 0 };
		// int arr[] = { 0, 0, 1, 1, 0, 0, 0, 1 };
		int arr[] = { 0, 0, 1, 1, 0 };
		int max = -1;
		int diff[] = new int[arr.length];
		HashMap<Integer, Integer> map = new HashMap<>();

		int zeros = 0;
		int ones = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				zeros++;
			} else {
				ones++;
			}
			diff[i] = ones - zeros;
		}

		System.out.println(Arrays.toString(diff));

		for (int i = 0; i < diff.length; i++) {
			if (map.containsKey(diff[i])) {
				int d = Math.abs(map.get(diff[i]) - i);
				if (d > max) {
					max = d;
				}
			} else {
				map.put(diff[i], i);
			}
		}
		System.out.println("Max: " + max);
	}

}
