package com.dp.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CrossOver {

	public static void main(String[] args) {
		System.out.println((2 + 4) * 9 - 3);
		String s1 = new String("Hello");
		String s2 = new String("there");
		String s3 = s1 + s2;
		System.out.println(s3);

		Set<Integer> set = new HashSet<Integer>(Arrays.asList(1, 2, 2, 3, 3, 3,
				5));
		System.out.println(set.size());
		System.out.println(getSeasons("sep"));

		List<String> list = new ArrayList<>();
		list.add("X");
		list.addAll(new ArrayList<>(4));
		System.out.println("size: " + list.size());

		final Collection<? super Number> foo = new ArrayList<Number>();
		// Producer extends, Consumer super
		foo.add(new Integer(10));
		System.out.println(foo);

		final Collection<? extends Number> foo1 = new ArrayList<Number>();
		// Producer extends, Consumer super
		foo.add(new Integer(10));
		System.out.println(foo1);
	}

	static String getSeasons(String arg) {
		String res;

		switch (arg) {
		case "march":
		case "april":
		case "June":
			res = "Spring";
			break;
		case "sep":
		case "aug":
			res = "Summer";
			break;
		default:
			throw new IllegalArgumentException(); // compile time error because
													// of default case
		}
		return res;

	}

	static String getResult(String args) {
		String res = null;
		if (args == null) {
			res = "default";
		}
		return res;
	}

}
