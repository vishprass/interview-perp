class Threading extends Thread{
	private String msg;
	public Threading(String msg){
		this.msg = msg;
	}
	public void run(){
		synchronized(this){
		int Count = 1;
		while(Count < 10){
			System.out.println(msg);
			Count++;
			try{
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				return;
			}
		}
		}
	}
}
public class pingpong{
	public static void main(String args[]){
		Threading th1 = new Threading("ping ");
		Threading th2 = new Threading("pong ");
		th1.start();
		th2.start();
	}
}
