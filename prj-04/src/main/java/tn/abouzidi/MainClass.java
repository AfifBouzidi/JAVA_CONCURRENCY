package tn.abouzidi;

public class MainClass {

	public static void main(String[] args) {

		Thread myThread=new Thread(new Runnable() {
			
			public void run() {
				while(true)
				{
					System.out.println("Hello World");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		myThread.start();
		
	}

}
