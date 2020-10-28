package com.dp.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EigthAgain {

	public static void main(String[] args) {
		List<Integer> list = IntStream.range(1, 5).map(i -> i * i).boxed()
				.collect(Collectors.toList());

		list.forEach(System.out::println);

		HashMap<Character, Integer> map = new HashMap<>();
		map.put('c', 1);
		map.put('e', 2);
		map.put('a', 1);
		map.put('b', 4);
		map.put('z', 3);
		// int count = 0;
		map.entrySet().stream().forEach(e -> {
			int count = 0;
			if (e.getValue() > 0) {
				count = count + 2;
			}

			System.out.println("count-" + count);
		});

		long after = map.entrySet().stream().filter(e -> e.getValue() > 1)
				.count();
		System.out.println("Greater > 1:" + after);

		Map<Object, List<Map.Entry<Character, Integer>>> mapped = map
				.entrySet().stream()
				.collect(Collectors.groupingBy(e -> e.getValue()));

		mapped.forEach((k, v) -> {
			System.out.println(k);
			System.out.println("size: " + v);

		});

		List<Hosting> ll = new ArrayList<>();
		ll.add(new Hosting(1, "liquidweb.com", 80000));
		ll.add(new Hosting(2, "linode.com", 90000));
		ll.add(new Hosting(3, "digitalocean.com", 120000));
		ll.add(new Hosting(4, "aws.amazon.com", 200000));
		ll.add(new Hosting(5, "mkyong.com", 1));

		ll.add(new Hosting(6, "linode.com", 100000)); // new line

		// key = name, value - websites , but the key 'linode' is duplicated!?
		Map<String, Long> result1 = ll.stream().collect(
				Collectors.toMap(Hosting::getName, Hosting::getWebsites, (ov,
						nv) -> ov));

		System.out.println("Result 1 : " + result1);
	}

}

class Hosting {

	private int Id;
	private String name;
	private long websites;

	public Hosting(int id, String name, long websites) {
		Id = id;
		this.name = name;
		this.websites = websites;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the websites
	 */
	public long getWebsites() {
		return websites;
	}

	/**
	 * @param websites
	 *            the websites to set
	 */
	public void setWebsites(long websites) {
		this.websites = websites;
	}

	// getters, setters and toString()

}