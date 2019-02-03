package tn.abouzidi;

import java.util.concurrent.Callable;

public class Task implements Callable<Integer> {

	private Integer a, b;

	public Task(Integer a, Integer b) {
		super();
		this.a = a;
		this.b = b;
	}

	public Integer call() throws Exception {
		System.out.println("performing operation "+a+"X"+b);
		Thread.sleep(2000);
		return a + b;
	}

}
