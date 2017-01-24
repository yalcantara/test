package test;

import static java.lang.Math.exp;

public class AllTest {
	
	public static void main(String[] args) {
		System.out.println(g(-7));
		System.out.println(g(-6));
		System.out.println(g(0));
		System.out.println(g(6));
		System.out.println(g(7));
	}
	
	
	public static double g(double x){
		return 1.0 / (1.0 + exp(-(-6 +   (-1)*x)));
	}
}
