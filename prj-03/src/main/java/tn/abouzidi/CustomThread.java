package tn.abouzidi;


public class CustomThread extends Thread {
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}

	
}
