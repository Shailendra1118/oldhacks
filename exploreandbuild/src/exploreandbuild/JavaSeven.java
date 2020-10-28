package exploreandbuild;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JavaSeven {

	public static void main(String[] args) throws Exception {
		
		try{
			File file = new File("C:/Drive");
			FileReader read = new FileReader(file);
			int c = read.read();
			System.out.println(c);
			read.close();
			throw new XException();
			
		}catch(Exception  e){
			e = new IOException();
			throw e;
		}

	}
	
	static void rethrow(String s) throws FirstException, SecondException, ThirdException {
		try {
			if (s.equals("First"))
				throw new FirstException("First");
			else if (s.equals("Second"))
				throw new SecondException("Second");
			else
				throw new ThirdException("Third");
		} catch (Exception e) {
			// below assignment disables the improved rethrow exception type
			// checking feature of Java 7
			//e=new ThirdException("third");
			throw e;
		}
	}
	
	@SuppressWarnings("serial")
	static class FirstException extends Exception {

		public FirstException(String msg) {
			super(msg);
		}
	}

	static class SecondException extends Exception {

		public SecondException(String msg) {
			super(msg);
		}
	}

	static class ThirdException extends Exception {

		public ThirdException(String msg) {
			super(msg);
		}
	}

	
	
	static class XException extends Exception{
		public XException(){
			super();
		}
	}

}
