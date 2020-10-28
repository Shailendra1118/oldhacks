package com.dp.test;

import java.util.Arrays;
import java.util.Comparator;

public class SortBinary {

	public static void main(String[] args) {

		Integer arr[] = { 5, 3, 7, 10, 14 };
		printSorted(arr);

		int val = bitCount(5);
		System.out.println(val);

	}

	private static void printSorted(Integer[] arr) {
		Arrays.sort(arr, new BinComparator());
		System.out.println(Arrays.toString(arr));
	}

	static class BinComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			// if (Integer.bitCount(o1) < Integer.bitCount(o2)) {
			if (bitCount(o1) < bitCount(o2)) {
				return -1;
			} else {
				if (bitCount(o1) > bitCount(o2)) {
					return +1;
				} else {
					return Integer.compare(o1, o2);
				}
			}
		}

	}

	private static int bitCount(Integer n) {
		int count = 0;
		while (n > 0) {
			n = (n - 1) & n;
			count++;
		}
		return count;
	}

	static class Binary implements Comparable<Binary> {
		String bin;
		int val;

		public Binary(String bin, int val) {
			this.bin = bin;
			this.val = val;
		}

		@Override
		public int compareTo(Binary o) {
			return 0;
		}
	}
}
