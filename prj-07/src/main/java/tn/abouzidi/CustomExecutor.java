package tn.abouzidi;

import java.util.concurrent.Executor;

public class CustomExecutor implements Executor {

	public void execute(Runnable command) {
		new Thread(command).start();
	}

}
