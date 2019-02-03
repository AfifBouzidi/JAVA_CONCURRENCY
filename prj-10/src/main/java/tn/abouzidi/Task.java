package tn.abouzidi;

public class Task implements Runnable {

	private int i;

	Task(int i) {
		this.i = i;
	}

	public void run() {

		int k = 0;
		while (k < i) {
			try {
				System.out.println("Hello World");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			++k;
		}
	}

}
