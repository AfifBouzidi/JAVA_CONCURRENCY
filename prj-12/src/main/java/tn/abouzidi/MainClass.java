package tn.abouzidi;

import java.util.concurrent.ForkJoinPool;

public class MainClass {

	public static void main(String[] args) {
		CustomTask customTask = new CustomTask(
				new int[] { 0, 1, 2,3,4});
		ForkJoinPool pool = new ForkJoinPool();
		System.out.println("total = " + pool.invoke(customTask));
	}

}
