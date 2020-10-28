package com.dp.test;

public class MaxSumSub {

	// Recursive way
	public static void main(String[] args) {

		// int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int arr[] = { -5, 2, 3, -4, 5 };
		maxSum(arr, arr.length - 1);
		System.out.println("recursive: " + maxTillNow);

		int dpRes = maxSumDp(arr, arr.length + 1);
		System.out.println(dpRes);

		// geeks
		System.out.println("Geeks: " + maxSubArraySum(arr, arr.length));

	}

	private static int maxSumDp(int[] arr, int n) {
		int sol[] = new int[n];
		sol[0] = 0; // first element is 0, not arr's first value
		for (int i = 1; i < n; i++) {
			sol[i] = Math.max(sol[i - 1] + arr[i - 1], arr[i - 1]);
		}

		System.out.println("array of DP");
		for (int i = 0; i < sol.length; i++) {
			System.out.print(sol[i] + " ");
		}
		System.out.println();
		int result = sol[0];
		for (int j = 1; j < sol.length; j++) {
			if (result < sol[j])
				result = sol[j];
		}

		return result;// sol[n-1];
	}

	// similar to DP, here we are keep tracking of max element simultanously
	static int maxSubArraySum(int a[], int size) {
		int max_so_far = a[0];
		int curr_max = a[0]; // Integer.MIN_VALUE;//

		for (int i = 1; i < size; i++) {
			curr_max = Math.max(a[i], curr_max + a[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}

	private static int maxTillNow = 0;

	private static int maxSum(int[] arr, int n) {
		if (n == 0) {
			return arr[n];
		}

		maxTillNow = Math.max(maxTillNow,
				Math.max(arr[n], arr[n] + maxSum(arr, n - 1)));

		return Math.max(arr[n], arr[n] + maxSum(arr, n - 1));
	}

}
