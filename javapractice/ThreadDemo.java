public class ThreadDemo implements Runnable{
	Thread T;
	ThreadDemo(){
		T = new Thread(this, "Child Thread");
		System.out.println("Child thread is "+ T);
		T.start();
	}
	
	public void run(){
		try{
			for(int i=0;i<5;i++){
				System.out.println("In Child Thread"+i);
				Thread.sleep(50);
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}	
	}
	
	public static void main(String args[]){
		new ThreadDemo();
		try{
			for(int i=0; i<5;i++){
				System.out.println("In Main Thread"+i);
                        	Thread.sleep(100);
                	}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
}

