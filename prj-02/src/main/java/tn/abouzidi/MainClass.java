package tn.abouzidi;

public class MainClass {

	public static void main(String[] args) {
       Thread customThread =new Thread(new CustomRunnable());
       customThread.start();
	}

}
