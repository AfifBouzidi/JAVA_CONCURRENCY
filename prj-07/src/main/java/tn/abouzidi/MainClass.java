package tn.abouzidi;

public class MainClass {

	public static void main(String[] args) {
	   CustomExecutor customExecutor=new CustomExecutor();
		
       Task taskOne=new Task("Hello World");
       Task taskTwo=new Task("Bonjour tout le monde");
       
       customExecutor.execute(taskOne);
       customExecutor.execute(taskTwo);
       
	}

}
