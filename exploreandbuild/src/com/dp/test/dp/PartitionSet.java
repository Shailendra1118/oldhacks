/**
 * 
 */
package com.dp.test.dp;

import java.util.Arrays;
import java.util.List;

/**
 * @author Shailendra
 *
 */
public class PartitionSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer arr[] = { 1, 3, 2, 5 };
		// { 1, 6, 11, 5 };
		// { 3, 1, 4, 2, 2, 1 };

		List<Integer> list = Arrays.asList(arr);
		int sum = list.stream().reduce(0, (a, b) -> a + b);
		System.out.println(sum);

		int totalSum = sum;
		int curSum = 0;
		int res = partition(arr, arr.length, totalSum, curSum);
		System.out.println("Res:" + res);
	}

	/**
	 * @param arr
	 * @param length
	 * @param totalSum
	 * @param curSum
	 * @return
	 */
	private static int partition(Integer[] arr, int n, int totalSum, int curSum) {

		if (n == 0) {
			// what is expected here
			// sum of one subset is curSum, sum of other subset is ?
			return Math.abs((totalSum - curSum) - curSum);
		}
		return Math.min(partition(arr, n - 1, totalSum, curSum + arr[n - 1]),
				partition(arr, n - 1, totalSum, curSum));
	}
}
