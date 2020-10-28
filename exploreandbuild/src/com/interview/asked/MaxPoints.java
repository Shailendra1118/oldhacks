package com.interview.asked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxPoints {

	public static void main(String[] args) {
		Integer x[] = { 1, 2, 4, 2, 3, 3, 5, 4 };
		Integer y[] = { 3, 2, 3, 4, 5, 1, 4, 6 };
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		a = Arrays.asList(x);
		b = Arrays.asList(y);

		int res = maxPoints(a, b);
		System.out.println(res);
	}

	private static int maxPoints(List<Integer> a, List<Integer> b) {
		List<Point> points = new ArrayList<>();
		for (int i = 0; i < a.size(); i++) {
			points.add(new Point(a.get(i), b.get(i)));
		}
		points.stream().forEach(System.out::println);
		// calculate slop and y-intercept of 2 points to check if they fall into
		// same line, y = m*x+a
		Map<SameLine, Integer> map = new HashMap<>();
		for (int i = 0; i < points.size(); i++) {
			Point p1 = points.get(i);
			for (int j = 0; j < points.size(); j++) {
				Point p2 = points.get(j);
				int div = (p1.x - p2.x);
				int m = 0, k = 0;
				if (div != 0) {
					m = (p1.y - p2.y) / div;
					k = p1.y - m * p1.x;
					SameLine same = new SameLine(m, k);
					if (map.containsKey(same)) {
						map.put(same, map.get(same) + 1);
					} else
						map.put(same, 1);
				}

			}
		}

		map.entrySet()
				.stream()
				.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				.collect(
						Collectors.toMap(Map.Entry::getKey,
								Map.Entry::getValue, (e1, e2) -> e1,
								LinkedHashMap::new)).entrySet()
				.forEach(System.out::println);

		return 0;
	}

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return this.x + "," + this.y;
		}
	}

	static class SameLine {
		int m;
		int a;

		SameLine(int m, int a) {
			this.m = m;
			this.a = a;
		}

		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			SameLine other = (SameLine) obj;
			if (other.m == this.m && other.a == this.a)
				return true;
			else
				return false;

		}

		public int hashCode() {
			int h = 1;
			return 31 * h + m + a;

		}

		public String toString() {
			return this.m + "," + this.a;
		}
	}
}
