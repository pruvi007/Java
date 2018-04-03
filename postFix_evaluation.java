import java.util.*;
public class postFix_evaluation {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s[] = scan.nextLine().split(" ");
		Stack<Integer> stack = new Stack<Integer>();
		String sign = "+-*/";
		for(int i=0;i<s.length;i++)
		{
			if(!s[i].equals("+") && !s[i].equals("-") && !s[i].equals("*") && !s[i].equals("/"))
			{
				int x = Integer.parseInt(s[i]);
				stack.push(x);
			}
			else{
				
				if(s[i].equals("+"))
				{
					int a1 = stack.pop();
					int a2 = stack.pop();
					stack.push(a1+a2);
				}
				else if(s[i].equals("-"))
				{
					int a1 = stack.pop();
					int a2 = stack.pop();
					stack.push(a2-a1);
				}
				else if(s[i].equals("*"))
				{
					int a1 = stack.pop();
					int a2 = stack.pop();
					stack.push(a2*a1);
				}
				else if(s[i].equals("/"))
				{
					int a1 = stack.pop();
					int a2 = stack.pop();
					stack.push(a2/a1);
				}
			}
		}
		System.out.println(stack.pop());
	}

}
