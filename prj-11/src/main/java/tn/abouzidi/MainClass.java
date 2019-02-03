package tn.abouzidi;

import java.util.concurrent.ForkJoinPool;

public class MainClass {

	public static void main(String[] args) {

		CustomTask CusomTask = new CustomTask("absdqfqhsbeldhsfejjksskkfdeuualkdsvchdejkelkelkelednndnd");
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(CusomTask);
	}

}
