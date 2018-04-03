import java.io.File;
import java.lang.*;
import java.util.*;
public class MyTh extends Thread{
	Scanner scan = null;
	int c=0;
	public void run(){
		try{
			System.out.println(Thread.currentThread().getName()+" is Running");
			File fr = new File("/home/iiitg/work_2/CS251/src/RealTime.txt");
			scan = new Scanner(fr);
			while(scan.hasNext())
			{
				scan.next();
				c++;
			}
			System.out.println("Number of Words are:"+c);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}

}
