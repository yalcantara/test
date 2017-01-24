package test;

import java.text.NumberFormat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Pecs<E> {
	
	public static void main(String[] args) {
		Pecs p = new Pecs();

		
		
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(7);
		nf.setMinimumFractionDigits(7);
		
		NumberFormat cf = NumberFormat.getInstance();
		cf.setGroupingUsed(true);
		cf.setMaximumFractionDigits(0);
		
		ScheduledExecutorService srv = null;
		
		
		
		
		for (int i = 0; i < 10; i++) {
			long now = System.nanoTime();
			p.setVal("hola");
			long time = System.nanoTime() - now;
			
			String s = String.valueOf(time);
			String pad = "     ";
			pad = pad.substring(0, pad.length()-s.length()) + s;
			double seg = (time / (1000 * 1000 * 1000.0));
			System.out.println("took: " + pad +"    " + nf.format(seg) +"s" +"   calls: " + cf.format(1/seg));
		}
	}

	private String val = null;

	public synchronized void setVal(String val) {
		this.val = val;
	}

	public void call(E e) {

	}

	public E set() {
		return null;
	}

	public static void pop(Pecs<? super String> list) {
		list.call("");
	}

}
