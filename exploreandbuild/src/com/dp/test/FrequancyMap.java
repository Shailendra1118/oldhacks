package com.dp.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequancyMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<>();
		map.put("Pears", 21);
		map.put("Apple", 100);
		map.put("Orange", 32);
		map.put("Banana", 1);

		// Integer freq =
		map.entrySet()
				.stream()
				// .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				// OR
				.sorted(Map.Entry.comparingByValue())
				.collect(
						Collectors.toMap(Map.Entry::getKey,
								Map.Entry::getValue, (e1, e2) -> e2,
								LinkedHashMap::new)).entrySet()
				.forEach(System.out::println);

		// System.out.println(freq);

	}
}
