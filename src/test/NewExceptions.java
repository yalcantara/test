package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class NewExceptions implements AutoCloseable {

	public void close(){
		throw new NullPointerException("weo klk");
	}
	
	public static BufferedReader openReader(String path) throws FileNotFoundException{
		return new BufferedReader(new FileReader(path));
	}
	
	public static void main(String[] args) {
		
		try(NewExceptions e=new NewExceptions()){
			
		}
	}
	
	

	public static void rethrow() throws Sub2Exception, SubException {

		
		try {
			call();
		} catch (Exception ex) {
			
			throw ex;
		}
	}

	public static void accept(SuperException e) {
		System.out.println(e);
	}

	
	public static void call() throws Sub2Exception, SubException {
		throw new Sub2Exception();
	}

}
