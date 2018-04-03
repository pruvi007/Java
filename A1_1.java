import java.util.*;

public class A1_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Name: ");
		String n = scan.next();
		System.out.println("Enter ID: ");
		int id = scan.nextInt();
		System.out.println("Salary: ");
		double sal = scan.nextDouble();
		System.out.println("Name: "+n);
		System.out.println("ID: "+id);
		System.out.println("Salary: "+sal);
		if(sal>=80000)
			System.out.println("Grade: "+"A");
		else if(sal>=50000 && sal<80000)
			System.out.println("Grade: "+"B");
		else if(sal>=30000 && sal<50000)
			System.out.println("Grade: "+"C");
		else if(sal<30000)
			System.out.println("Grade: "+"D");
	}

}
