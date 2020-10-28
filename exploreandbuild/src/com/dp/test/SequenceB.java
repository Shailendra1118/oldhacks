package com.dp.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class SequenceB {

	public static void main(String[] args) throws FileNotFoundException {

		// Scanner
		Scanner s = new Scanner(new File(
				"D:\\Keppler\\exploreandbuild\\src\\com\\dp\\test\\seqB.txt"));
		int n = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		int mid = -1;
		int l = 0;
		int hi = arr.length - 1;
		while (l <= hi) {
			mid = l + (hi - l) / 2;
			if ((arr[mid] > arr[mid - 1]) && (arr[mid] > arr[mid + 1])) {
				// System.out.println("Found mind: " + arr[mid] + ", at " +
				// mid);
				break;
			} else {
				if ((arr[mid] > arr[mid - 1]) && (arr[mid] < arr[mid + 1])) {
					l = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
		}

		TreeSet<Integer> t1 = new TreeSet<>();
		TreeSet<Integer> t2 = new TreeSet<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		for (int i = 0; i <= mid; i++) {
			t1.add(arr[i]);
		}
		for (int i = mid + 1; i < arr.length; i++) {
			t2.add(arr[i]);
		}

		// t1.forEach(e -> System.out.print(e + " "));
		// System.out.println();
		// t2.forEach(e -> System.out.print(e + " "));

		int max = arr[mid];
		int ops = s.nextInt();
		for (int i = 0; i < ops; i++) {
			int val = s.nextInt();

			// value is greater than max
			if (val > max) {
				max = val;
				t1.add(val);

			} else {
				if (val < max) {
					// check in first half
					if (t1.contains(val) && !t2.contains(val)) {
						t2.add(val);
					}

					if (!t1.contains(val)) {
						t1.add(val);
					}
				}
			}
			System.out.println((t1.size() + t2.size()));

		}
		t1.forEach(e -> System.out.print(e + " "));
		t2.forEach(e -> System.out.print(e + " "));

		s.close();
	}

}
