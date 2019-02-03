package tn.abouzidi;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainClass {

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<Integer> future = executorService.submit(new Task(4, 6));
		while (!future.isDone()) {
			System.out.println("Calculating...");
			Thread.sleep(2000);
		}
		System.out.println("result : " + future.get());
		executorService.shutdown();
	}

}
