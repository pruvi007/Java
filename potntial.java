import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class potntial {
	public static void main(String[] args) throws IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		String s[] = scan.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int q = Integer.parseInt(s[1]);
		String s1[] = scan.readLine().split(" ");
		String s2[] = scan.readLine().split(" ");
		long x[] = new long[n];
		long p[] = new long[n];
		for(int i=0;i<n;i++)
			x[i] = Integer.parseInt(s1[i]);
		for(int i=0;i<n;i++)
			p[i] = Integer.parseInt(s2[i]);
		while(q-->0)
		{
			String s3[] = scan.readLine().split(" ");
			int z = Integer.parseInt(s3[0]);
			if(z==1)
			{
				int ind = Integer.parseInt(s3[1]);
				long num = Long.parseLong(s3[2]);
				x[ind-1]=num;
			}
			else if(z==2)
			{
				int ind = Integer.parseInt(s3[1]);
				long num = Long.parseLong(s3[2]);
				p[ind-1]=num;
			}
			else if(z==3)
			{
				int a = Integer.parseInt(s3[1]);
				int b = Integer.parseInt(s3[2]);
				long find[] = new long[n];
				int k=0;
				for(int i=a-1;i<b;i++)
				{
					long c = i-a+1;
					long min = c>p[i]?p[i]:c;
					find[k++] = x[i] + min;
				}
				long max = 0;
				System.out.println();
				for(int i=0;i<k;i++)
					System.out.print(find[i]+" ");
				System.out.println();
				for(int i=0;i<k;i++)
				{
					if(find[i]>max)
						max = find[i];
				}
				System.out.println(max);
			}
		}
	}

}
