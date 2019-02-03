package tn.abouzidi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CustomTask extends RecursiveTask<Integer> {

	private int[] values;
	private static final int maxSize = 5;

	public CustomTask(int[] values) {
		super();
		this.values = values;
	}

	@Override
	protected Integer compute() {

		if (values.length <= maxSize) {
			return sum();
		} else {
			CustomTask customTaskOne = new CustomTask(Arrays.copyOfRange(values, 0, values.length / 2));
			CustomTask customTaskTwo = new CustomTask(Arrays.copyOfRange(values, values.length / 2, values.length));
			return customTaskOne.compute() + customTaskTwo.join();
		}

	}

	private Integer sum() {
		int result = 0;
		for (int i : values) {
			result = result + i;
		}
		System.out.println("This result - (" + result + ") - was processed by " + Thread.currentThread().getName());
		return result;
	}

}
