package tn.abouzidi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class CustomTask extends RecursiveAction {

	private String message;

	private static final int maxSize = 5;

	public CustomTask(String message) {
		this.message = message;
	}

	@Override
	protected void compute() {
		if (this.message.length() <= 5) {
			System.out
					.println("This result - (" + message.toUpperCase() + ") - was processed by " + Thread.currentThread().getName());
		} else {
			List<CustomTask> subtasks = new ArrayList<CustomTask>();
			String partOne = message.substring(0, message.length() / 2);
			String partTwo = message.substring(message.length() / 2, message.length());
			subtasks.add(new CustomTask(partOne));
			subtasks.add(new CustomTask(partTwo));
			ForkJoinTask.invokeAll(subtasks);
		}

	}

}
