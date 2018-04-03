import java.util.*;

public class A2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		SR obj1 = new SR();
		obj1.display();
		System.out.println();
		SR obj2 = new SR(12);
		obj2.display();
		System.out.println();
		SR obj3 = new SR(14,"Praveen");
		obj3.display();
		System.out.println();
		SR obj4 = new SR(15,"Akshay","CSE");
		obj4.display();
		System.out.println();
		SR obj5 = new SR(obj2);
		obj5.display();
	}

}
