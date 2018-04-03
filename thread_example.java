import java.lang.*;

class MyThread extends Thread{
	public void run(){
		
		System.out.println("Thread Running: "+Thread.currentThread().getName());
		System.out.println();
		for(int i=1;i<10;i++)
			System.out.print(i+" ");
	}
}
class MyThread2 extends Thread{
	public void run(){
		try{
			System.out.println(Thread.currentThread().getName()+" is sleeping");
			Thread.currentThread().sleep(1000);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("\nThread Running: "+Thread.currentThread().getName());
		
		for(int i=0;i<2;i++)
			System.out.println(Thread.currentThread().getName());
	}
}
class MyRunnable implements Runnable{
	public void run(){
		System.out.println("Create Thread: "+Thread.currentThread().getName());
		try{
			System.out.println("TH-2 is sleeping: ");
			Thread.currentThread().sleep(1000);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("\nTH-2, Woken up after: ");
		for(int i=10;i>0;i--)
			System.out.print(i+" ");
	}
}
public class thread_example {
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.setName("TH-1");
		MyThread2 t3 = new MyThread2();
		t3.setName("TH-3");
		Thread t2 = new Thread(new MyRunnable(),"TH-2");
		t1.start();
		t2.start();
		//t1.stop();
		t3.start();
		//t2.stop();
		//t3.stop();
		
	}
}
