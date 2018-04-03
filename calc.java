import java.util.*;

public class calc {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		for(int i=0;;i++)
		{
			System.out.println("Num1: ");
			int n = s.nextInt();
			System.out.println("Opr: ");
			char ss = s.next().charAt(0);
			System.out.println("Num2: ");
			int m = s.nextInt();
			opr obj = new opr(n,ss,m);
			obj.calR();
			obj.display();
			System.out.println("-1 to exit: ");
			int z = s.nextInt();
			if(z==-1)
				break;
		}
	}

}
