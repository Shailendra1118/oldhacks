package exploreandbuild;

import java.util.HashMap;
import java.util.Map;

public class TestStatic {

	private Integer id;

	public TestStatic(int id) {
		this.id = id;
	}

	public String toString() {
		return this.id.toString();
	}

	public int hashCode() {
		int res = 1;
		res = 31 + ((id == null) ? 0 : this.id.hashCode());
		System.out.println("returning " + res);
		return res;
	}

	public boolean equals(Object obj) {
		TestStatic t = (TestStatic) obj;
		Boolean ret = false;
		if (t.id.equals(this.id))
			ret = true;
		return ret;
	}

	public static void main(String[] args) {
		TestStatic t1 = new TestStatic(1);
		TestStatic t2 = new TestStatic(1);
		Map<TestStatic, Integer> map = new HashMap<>();
		map.put(t1, 1);
		map.put(t2, 2);
		System.out.println(map.size());
		map.forEach((k, v) -> System.out.println(k + " " + v));

		Employee e1 = new Employee("Aman", new Integer(10));
		Employee e2 = new Employee("Aman", new Integer(10));
		Map<Employee, String> map1 = new HashMap<>();
		map1.put(e1, "test");
		map1.put(e2, "test");

		System.out.println(map1.size());
		map1.forEach((k, v) -> System.out.println(k + " " + v));

		byte a = 127;
		byte b = 127;
		byte d = (byte) (a + b);
		a += b;
		byte c = a;
		System.out.println(a + " " + b + " " + c + " " + d);
	}
}

class Employee {
	Integer id;
	String name;

	public Employee(String name, Integer id) {
		this.id = id;
		this.name = name;
	}

	public int hashCode() {
		return 1;
	}

	public String toString() {
		return this.id + " " + this.name;
	}
}
