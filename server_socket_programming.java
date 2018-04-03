import java.io.*;  
import java.net.*;  
public class server {  
public static void main(String[] args){  
    try{  
    	ServerSocket ss=new ServerSocket(5000);
	//System.out.println(ss.getLocalPort());  
    	Socket s=ss.accept();//establishes connection   
    	DataInputStream dis=new DataInputStream(s.getInputStream()); 
	DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
	File wr = new File("/home/iiitg/Downloads/Java_endSem/ans.txt");
	
	FileWriter writer = null;
	writer = new FileWriter(wr);
	int count = Integer.parseInt(dis.readUTF());
	int i=0;
	while(i<count)
	{
 		String str=(String)dis.readUTF();
		char sym[] = new char[str.length()];
		int k=0,k1=0;
		int num[] = new int[str.length()];
		for(int j=str.length()-1;j>=0;j--)
		{
			if(str.cha=='+' || str.charArIndex(j)=='-')
				  sym[k++] = str.charAtIndex(j);
			else
				num[k1++] = str.charAtIndex(j)-'0';
		}
		int sum = 0;
		for(int j=0;j<k1;j++)
		{
			if(sym[j]=='+')
			{
				sum = sum + num[j];
			}
			else
				sum = sum - num[j];
		}
		String sc = "";
		sc = sc + sum;
		dout.writeUTF(sc); 
	}
	ss.close();  
    }
	catch(Exception e)
	{	
		System.out.println(e);
	}  
}  
}  
