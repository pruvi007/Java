import java.io.File;
import java.lang.*;
import java.util.*;

public class MyTh2 extends Thread{
	Scanner scan = null;
	int c=0;
	public void run(){
		try{
			Thread.currentThread().sleep(1000);
			System.out.println(Thread.currentThread().getName()+" is Running");
			File fr = new File("/home/iiitg/work_2/CS251/src/RealTime.txt");
			scan = new Scanner(fr);
			String vowel = "aAeEiIoOuU";
			while(scan.hasNext())
			{
				String s = scan.next();
				for(int i=0;i<s.length();i++)
				{
					for(int j=0;j<vowel.length();j++)
					{
						if(s.charAt(i)==vowel.charAt(j))
						{
							c++;
							break;
						}
					}
				}
			}
			System.out.println("Number of Vowels:" +c);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
	}

}
