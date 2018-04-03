import java.io.File;
import java.io.FileWriter;
import java.lang.*;
import java.util.*;

public class MyTh_2 extends Thread{
	Scanner scan = null;
	public void run(){
		try{
			File fr = new File("/home/iiitg/work_2/CS251/src/test.txt");
			scan = new Scanner(fr);
			File wr = new File("/home/iiitg/work_2/CS251/src/op2.txt");
			FileWriter writer = null;
			writer = new FileWriter(wr);
			ArrayList<String> a = new ArrayList<String>();
			while(scan.hasNextLine()){
				String s[] = scan.nextLine().split(" ");
				a.add(s[0]);
			}
			for(int i=0;i<a.size()-1;i++)
			{
				for(int j=i+1;j<a.size();j++)
				{
					if(a.get(i).equals(a.get(j)))
					{
						a.set(j, "-1");
					}
				}
				
			}
			for(int i=0;i<a.size();i++)
			{
				if(a.get(i)!="-1")
				{
					System.out.println(a.get(i));
					writer.write(a.get(i)+"\n");
					writer.flush();
				}
					
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}

}
