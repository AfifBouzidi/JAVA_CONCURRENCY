package tn.abouzidi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClassTwo {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		CompletableFuture<Void> future = CompletableFuture.runAsync(new Task(5),executorService);
		executorService.shutdown();
	}

}
