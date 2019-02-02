package tn.abouzidi;

public class MainClass {

	public static void main(String[] args) {
		CustomThread customThread = new CustomThread();
		customThread.start();
		Thread.yield();
		System.out.println(Thread.currentThread().getName());
		// Output may vary in machine to machine but chances of execution of yield()
		// thread first is higher than the other thread because main thread is always
		// pausing its execution and giving chance to child thread(with same priority)
	}

}
