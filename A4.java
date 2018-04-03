import java.util.*;
public class A4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		circle c = new circle(4);
		c.name="Circle";
		c.sides=0;
		System.out.println("***************");
		System.out.println(c.toString());
		System.out.println("Area: "+c.getArea()+"\nPerimetre: "+c.getPer());
		System.out.println();
		rectangle r = new rectangle(3,5);
		r.name="Rectangle";
		r.sides=4;
		System.out.println("***************");
		System.out.println(r.toString());
		System.out.println("Area: "+r.getArea()+"\nPerimetre: "+r.getPer());
		System.out.println("**********************************\n" +
							"*********************************");
		saving os = new saving(2000);
		PPF po = new PPF(3000);
		for(int i=0;;i++)
		{
			System.out.println("What type of Object: \n" +
					"If Exit press '-1'\n");
			String s = scan.next();
			if(s.equals("-1"))
				break;
			for(int j=0;;j++)
			{
				if(s.equals("savings"))
				{
					System.out.println("1. Calculate_Total\n" +
							"2. Get_Rate_of_Interest\n" +
							"3. Deposit_Money\n" +
							"4. Get_Total\n" +
							"5. Exit\n");
					System.out.println("Enter your choice: ");
					int z = scan.nextInt();
					if(z==1)
						System.out.println(os.calTotal());
					else if(z==2)
						System.out.println(os.getROI());
					else if(z==3)
						System.out.println(os.depositMoney(5000));
					else if(z==4)
						System.out.println(os.getTotal());
					else if(z==5)
						break;
				}
				else if(s.equals("ppf"))
				{
					System.out.println("1. Calculate_Total\n" +
							"2. Get_Rate_of_Interest\n" +
							"3. Deposit_Money\n" +
							"4. Get_Total\n" +
							"5. Exit\n");
					System.out.println("Enter your choice: ");
					int z = scan.nextInt();
					if(z==1)
						System.out.println(po.calTotal());
					else if(z==2)
						System.out.println(po.getROI());
					else if(z==3)
						System.out.println(po.depositMoney(5000));
					else if(z==4)
						System.out.println(po.getTotal());
					else if(z==5)
						break;
				}
				
			}
			
		}
	}

}
