import java.util.Scanner;

public class Grade {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Student[] ob = new Student[3];
		for(int i=0;i<3;i++)
		{
			ob[i] = new Student();
			System.out.print("Enter Name: ");
			String s = scan.next();
			ob[i].setN(s);
			System.out.print("Marks1: ");
			int m1 = scan.nextInt();
			ob[i].setM1(m1);
			System.out.print("Marks2: ");
			int m2 = scan.nextInt();
			ob[i].setM2(m2);
			double pr = (ob[i].getM1()+ob[i].getM2())/2;
			System.out.println("Name: "+ob[i].getN());
			System.out.println("Marks1: "+ob[i].getM1());
			System.out.println("Marks2 "+ob[i].getM2());
			System.out.println("Percentage: "+ob[i].per());
			System.out.println("Grade: "+ob[i].grade(pr));
			System.out.println();
		}
		
	}

}