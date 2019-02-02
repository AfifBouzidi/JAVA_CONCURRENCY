package tn.abouzidi;

public class MainClass {

	public static void main(String[] args) {

		final Thread myThreadOne=new Thread(new Runnable() {
			private int i=0;
			public void run() {
				while(i<5)
				{
					System.out.println("Hello");
					++i;
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		myThreadOne.start();
		
		
		Thread myThreadTwo=new Thread(new Runnable() {
			private int i=0;
			public void run() {
				while(i<5)
				{
					System.out.println("Bonjour [wait Hello Thread]");
					++i;
					try {
						myThreadOne.join();
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		myThreadTwo.start();
		
	}

}
