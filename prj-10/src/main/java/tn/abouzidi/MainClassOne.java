package tn.abouzidi;

import java.util.concurrent.CompletableFuture;

public class MainClassOne {

	public static void main(String[] args) throws Exception {

		CompletableFuture<Void> future = CompletableFuture.runAsync(new Task(5));
		future.get();
		System.out.println("CompletableFuture use ForkJoinPool.commonPool()");
	}

}
