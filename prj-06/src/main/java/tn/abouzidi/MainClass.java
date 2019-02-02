package tn.abouzidi;

public class MainClass {

	public static void main(String[] args) {
		final Object lock = new Object();
		final Thread threadTwo = new Thread(new Runnable() {
			public void run() {
				synchronized (lock) {
					System.out.println("Two: Fine and you");
					try {
						lock.notify();
						lock.wait();
						System.out.println("Two: bye");
						lock.notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		Thread threadOne = new Thread(new Runnable() {
			public void run() {
				synchronized (lock) {
					System.out.println("One: How are you");
					threadTwo.start();
					try {
						lock.wait();
						System.out.println("One: Fine thanks");
						lock.notify();
						lock.wait();
						System.out.println("One: bye bye");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		threadOne.start();
	}

}
