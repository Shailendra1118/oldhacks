package com.interview.asked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	private HashMap<Double, Integer> hashMap;

	public int maxPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

		hashMap = new HashMap<>();

		if (A == null || B == null)
			return -1;

		if (A.size() == 0)
			return 0;

		int n = A.size();
		int x1, y1, x2, y2;
		int val;
		int max = 0;

		for (int i = 0; i < n; i++) {

			x1 = A.get(i);
			y1 = B.get(i);
			hashMap.clear();

			for (int j = 0; j < n; j++) {

				if (i == j)
					continue;

				x2 = A.get(j);
				y2 = B.get(j);

				double slope = y2 - y1;
				int den = x2 - x1;

				if (den == 0)
					slope = Double.POSITIVE_INFINITY;
				else
					slope = slope / den;

				val = 1;

				if (hashMap.containsKey(slope)) {
					val = hashMap.get(slope) + 1;
				}

				hashMap.put(slope, val);

			}

			for (Map.Entry<Double, Integer> entry : hashMap.entrySet()) {
				val = entry.getValue();
				max = Math.max(max, val);
			}
		}

		return max + 1;
	}

}
