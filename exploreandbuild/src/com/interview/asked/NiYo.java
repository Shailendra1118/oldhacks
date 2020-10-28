package com.interview.asked;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NiYo {

	public static void main(String[] args) throws FileNotFoundException {
		Map<Phone, List<RatingPrice>> data = new java.util.HashMap<>();
		// Scanner
		Scanner s = new Scanner(new File(
				"D:/Keppler/exploreandbuild/src/com/interview/asked/input.txt"));
		int total = s.nextInt();

		for (int i = 0; i < total; i++) {
			String os = s.next();
			int ram = s.nextInt();
			int mem = s.nextInt();
			int price = s.nextInt();
			int rating = s.nextInt();
			Phone phone = new Phone(os, ram, mem);
			RatingPrice rp = new RatingPrice(rating, price);
			if (data.containsKey(phone)) {
				List<RatingPrice> l = data.get(phone);
				l.add(rp);
			} else {
				List<RatingPrice> l = new ArrayList<>();
				l.add(rp);
				data.put(phone, l);
			}
		}

		int query = s.nextInt();
		for (int i = 0; i < query; i++) {
			String os = s.next();
			int ram = s.nextInt();
			int mem = s.nextInt();
			int bud = s.nextInt();
			Phone phone = new Phone(os, ram, mem);
			List<RatingPrice> list = data.get(phone);
			if (null == list || list.isEmpty()) {
				System.out.println("-1");
			} else {
				List<RatingPrice> sorted = list
						.stream()
						.sorted((e1, e2) -> (e2.rating < e1.rating) ? -1
								: ((e2.rating == e1.rating) ? 0 : 1))
						.collect(Collectors.toList());
				Iterator<RatingPrice> iter = sorted.iterator();
				while (iter.hasNext()) {
					RatingPrice rp = iter.next();
					if (rp.price < bud) {
						System.out.println(rp.rating);
						break;
					}
				}
			}
		}

	}

	static class Phone {
		String os;
		int ram;
		int mem;

		public Phone(String o, int ram, int mem) {
			this.os = o;
			this.ram = ram;
			this.mem = mem;
		}

		public int hashCode() {
			int x = 1;
			return 31 * x + this.os.hashCode() + ram + mem;
		}

		public boolean equals(Object o) {
			if (o == null)
				return false;
			Phone other = (Phone) o;
			if (this.os.equals(other.os) && this.ram == other.ram
					&& this.mem == other.mem) {
				return true;
			} else
				return false;
		}
	}

	static class RatingPrice {
		int rating;
		int price;

		public RatingPrice(int rating, int price) {
			this.rating = rating;
			this.price = price;
		}
	}

}
