import java.util.*;
import java.io.*;

public class A5 {
	public static void main(String[] args)  {
		Scanner scan = null;
		Student_A5 obj[] = new Student_A5[7];
		File fr = new File("/home/iiitg/work_2/CS251/src/student.txt");
		File wr = new File("/home/iiitg/work_2/CS251/src/output.txt");
		FileWriter writer = null;
		try{
			scan = new Scanner(fr);
			writer = new FileWriter(wr);
			int z=0;
			while(scan.hasNextLine()){
				String line[] = scan.nextLine().split(",");
				int roll = Integer.parseInt(line[1]);
				int m1 = Integer.parseInt(line[2]);
				int m2 = Integer.parseInt(line[3]);
				int m3 = Integer.parseInt(line[4]);
				if(m1>0 && m2>0 && m3>0)
				{
					obj[z] = new Student_A5(line[0],roll,m1,m2,m3);
					writer.write(line[0]+" ");
					writer.write(line[1]+" ");
					writer.write(obj[z].getGrade()+"\n");
					System.out.println();
				}
	
				
				z++;
				
				writer.flush();
			}
			
		}
		catch(FileNotFoundException e){
			System.out.println("File isn't there,Sorry!!");
			
		}
		catch(Exception e){
			System.out.println("You Entered (-)ve marks");
		}
		
		
		
	}

}
