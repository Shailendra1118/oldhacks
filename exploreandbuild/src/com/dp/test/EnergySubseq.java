package com.dp.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class EnergySubseq {
	public static void main(String args[]) throws FileNotFoundException {

		// Scanner
		Scanner s = new Scanner(new File(
				"D:\\Keppler\\exploreandbuild\\src\\com\\dp\\test\\energy.txt"));
		int n = s.nextInt();
		int k = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		System.out.println("Length: " + k);
		System.out.println(Arrays.toString(arr));

		findMaxEnergy(arr, k);

		int[] arr1 = { 10, 22, 9, 33, 21, 50, 41, 60 };
		System.out.println(LISRec(arr1, 0));
		s.close();
	}

	private static void empty() {
		// TODO Auto-generated method stub

	}

	private static void findMaxEnergy(int[] arr, int k) {
		// longest inreasing subsequence
		// length can be found with DP solutions, how to print longest
		// increasing subseq ?
		// recursive

	}

	private static int LISRec(int arr[], int n) {
		if (n == 0)
			return 0;
		int m = 1;
		for (int i = 1; i <= n - 1; i++) {
			if (arr[i] < arr[n]) {
				m = Math.max(m, 1 + LISRec(arr, i));
			}
		}
		return m;
	}
}
