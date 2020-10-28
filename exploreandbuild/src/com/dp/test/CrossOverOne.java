package com.dp.test;

public class CrossOverOne {

	public static void main(String[] args) {
		Logger log = new Logger();

		Thread t1 = new Thread(new XRunnable(log, 2000, "Hello"));
		Thread t2 = new Thread(new XRunnable(log, 1000, "Byee"));

		t1.start();
		t2.start();

	}
}

class Logger {
	// StringBuilder contents = new StringBuilder();
	StringBuffer contents = new StringBuffer();

	public void write(String str) {
		contents.append("\n" + Thread.currentThread().getName());
		contents.append(": " + str);
		// contents.append(" At " + new Date());
	}

	public String getContents() {
		return contents.toString();
	}

}

class XRunnable implements Runnable {
	Logger log = null;
	int sleep = 0;
	String txt = "";

	public XRunnable(Logger log, int sleep, String text) {
		this.log = log;
		this.sleep = sleep;
		this.txt = text;
	}

	public void run() {
		log.write(txt);
		try {
			Thread.sleep(sleep);
			System.out.println(log.getContents());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}