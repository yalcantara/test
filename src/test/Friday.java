package test;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;

public class Friday {
	
	public static void main(String[] args)throws Exception {
		Calendar c = Calendar.getInstance();
		c.set(2015, Calendar.JANUARY, 1);
		PrintWriter pw = new PrintWriter("files/fridays_time.csv");
		PrintWriter pw2 = new PrintWriter("files/fridays_bin.csv");
		for(;;){
			
			
			long t = c.getTime().getTime();
			int day = c.get(Calendar.DAY_OF_WEEK);
			int friday = (day == Calendar.FRIDAY)?1:0;
			pw.println(t +","+t +","+t +","+t +","+t);
			pw2.println(friday);
			
			if(c.get(Calendar.MONTH) == Calendar.DECEMBER && c.get(Calendar.DAY_OF_MONTH) == 31){
				break;
			}
			c.add(Calendar.DAY_OF_YEAR, 1);
		}
		
		pw.close();
		pw2.close();
	}
	
}
