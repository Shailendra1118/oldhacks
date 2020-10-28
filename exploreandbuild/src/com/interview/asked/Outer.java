package com.interview.asked;

import com.interview.asked.Outer.Input;

public class Outer {

	public static class Input {
		public static void foo() {
			System.out.println("Hello from Input foo");
		}
	}

	public static void main(String args[]) {
		Diff d = new Diff();
		d.disp();
	}
}

class Diff {

	public void disp() {
		Input obj = new Outer.Input();
		Input.foo();
	}
}