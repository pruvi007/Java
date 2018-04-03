import java.util.*;

public class jan_cir_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		long k = scan.nextLong();
		long c = 0;
		//k = k %n;
		long ceil = (long)Math.ceil((double)n/2);
		//System.out.println(ceil);
		if(k==1)
		{
			c = n*(n-1)/2;
			System.out.println(c);
		}
		else if(k>=n)
			System.out.println("0");
		else if(k>=(ceil) && k<n)
		{ 
			System.out.println(n-k);
		}
		else
		{
			long x1 = (long)Math.ceil((double)n/k);
			long x2 = n/k;
			//System.out.println(x1+" "+x2);
			long g1 = x1*(x1-1)/2;
			long g2 = x2*(x2-1)/2;
			long sum=0;
			long s1 = (k-(n%(k*x2)))*g2;
			long s2 = (n%(k*x2))*g1;
			//System.out.println(s1+" "+s2);
			sum = s1+s2;
			//System.out.println(g1+" "+g2);
			System.out.println(sum);
			
		}
			
			
		
			
		
		
		
	}

}
