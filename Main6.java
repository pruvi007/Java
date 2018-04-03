import java.io.IOException;
import java.util.*;

public class Main6 {
	public static void main(String[] args)throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("Initial List.");
		
		System.out.println("itemCod"+"\t"+"itemName"+"\t"+"unitPr"+
		"\t"+"stockRem\titemLimit");
		System.out.println("1\tTV\t\t10000\t3\t\t2");
		System.out.println("2\tMouse\t\t1000\t7\t\t3");
		System.out.println("3\tHeadPhone\t2000\t1\t\t6");
		System.out.println("4\tMobile\t\t5000\t5\t\t1");
		User u = new User("Diablo",15000);
		System.out.println("Initial Budget = 15000");
		items it[] = new items[4];
		it[0] = new items(1,"TV",10000,3,2);
		it[1] = new items(2,"Mouse",1000,7,3);
		it[2] = new items(3,"HeadPhone",2000,1,6);
		it[3] = new items(4,"Mobile",5000,5,1);
		System.out.println();
		
			for(int i=0;;i++)
			{
				System.out.println("\n1. Display Items\n" +
						"2.But Item\n3. Exit\n");
				System.out.print("Enter your Option: ");
				int x = scan.nextInt();
				if(x==1)
				{
					for(int j=0;j<4;j++)
					{
						System.out.println(it[j].toString());
					}
				}
				if(x==3)
				{
					System.out.println("ThankYou For Shopping!!");
					break;
				}
				else if(x>3)
				{
					System.out.println("Wrong Choice...");
					break;
				}
				try{
					 if(x==2)
					{
						System.out.print("Enter item Code: ");
						int ic = scan.nextInt();
						if(ic<1 || ic>4)
						{
							throw new Exception("Item Not Found");
						}
						System.out.println("Enter quantity: ");
						int q = scan.nextInt();
						if((q*it[ic-1].unitPrice)>u.budget)
						{
							throw new Exception("Over Budget");
						}
						if(q>it[ic-1].itemLimit)
						{
							throw new Exception("Item Limit Exceeded");
						}
						if(q>it[ic-1].stockRemaining)
						{
							throw new Exception("Out Of Stock");
						}
						u.budget = u.budget - (q*it[ic-1].unitPrice);
						it[ic-1].stockRemaining=it[ic-1].stockRemaining-q;
						System.out.println("Current Budget: "+u.budget);
					}
					
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					System.out.println("Current Budget: "+u.budget);
				}
				
			}
		
	}

}
