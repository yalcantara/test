package test;

import static java.lang.Math.pow;

import java.util.Arrays;

import com.yaison.cerebro.Loader;
import com.yaison.cerebro.learning.Learning;
import com.yaison.cerebro.learning.Regression;
import com.yaison.cerebro.structs.Data;

public class Homework {
	 
	public static void main(String[] args) {
		Data data = Loader.fromFile("files/ex1data1.txt");
		Regression reg = Learning.regress(data, 1);
		
		double[] theta = new double[]{3, 2};
		double ans = j(theta, data);
		System.out.println(ans);
	}
	
	static double h(double[] theta, Data data, int i){
		return theta[0] + theta[1]*((Number)data.get(i, 0)).doubleValue();
	}
	
	static double j(double[] theta, Data data){
		double sum = 0.0;
		int m = data.rows();
		for(int i =0; i < m; i++){
			
			sum += pow(h(theta, data, i) - ((Number)data.get(i, 1)).doubleValue(), 2);
		}
		
		return (1.0 / (2.0 * m)) * sum;
	}
}
