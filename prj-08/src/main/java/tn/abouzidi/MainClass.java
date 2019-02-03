package tn.abouzidi;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.submit(new Task(4, 6));
		executorService.submit(new Task(7, 5));
		try {
			executorService.invokeAll(Arrays.asList(new Task(3, 3),new Task(4, 4),new Task(6, 6)));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executorService.shutdown();
	}

}
