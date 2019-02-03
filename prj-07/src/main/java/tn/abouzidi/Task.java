package tn.abouzidi;

public class Task implements Runnable {
	
    private String message;

	public Task(String message) {
		super();
		this.message = message;
	}

	public void run() {
		System.out.println(message);
	}

}
