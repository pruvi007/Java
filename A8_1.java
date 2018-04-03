import java.util.*;

public class A8_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0)
		{
			String a = scan.next();
			String s[] = a.split("[\\+-]");
			
			int number[] = new int[s.length];
			int k=0;
			for(int i=0;i<s.length;i++)
			{
				int num=0,c=0;
				for(int j=s[i].length()-1;j>=0;j--)
				{
					int x = s[i].charAt(j)-'0';
					num = num + x*(int)Math.pow(10, c++);
				}
				number[k++]=num;
			}
			
			int ans=0;
			k=number.length-1;
			for(int i=a.length()-1;i>=0;i--)
			{
				if(a.charAt(i)=='-' || a.charAt(i)=='+')
				{  
					if(a.charAt(i)=='+')
					{
						ans = ans + number[k];
						k--;
					}
					else
					{
						ans = ans - number[k];
						k--;
					}
				}
			}
			ans = ans+number[0];
			
			System.out.println(ans);
			
			
		}
	}

}
