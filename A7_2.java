import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;
import java.util.Scanner;

public class A7_2 {
	public static void main(String[] args) throws FileNotFoundException {
		File fr = new File("/home/iiitg/work_2/CS251/src/test.txt");
		Scanner scan = new Scanner(fr);
		Person ob[] = new Person[100];
		int k=0;
		while(scan.hasNextLine())
		{
			String s[] = scan.nextLine().split(" ");
			double sal = Double.parseDouble(s[2]);
			int id = Integer.parseInt(s[1]);
			ob[k++] = new Person(s[0],sal,id);
			
		}
		
		MyTh_2 t3 = new MyTh_2();
		t3.setName("T3");
		t3.start();
		
	}

}
