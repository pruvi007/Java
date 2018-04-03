import java.sql.*;
import java.io.*;
import java.util.Scanner;
//import com.mysql.jdbc.Driver;
public class JDBC_A {

	public static void main(String[] args)throws Exception {//SQLException, ClassNotFoundException, IOException {
		
		Connection connect= null;
		Statement stmt = null;
		ResultSet res=null;
		PreparedStatement prep= null;
		
		Class.forName("com.mysql.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Diablo","root","pagal.com");
		stmt = connect.createStatement();
		stmt.executeUpdate("drop table Student");
		stmt.executeUpdate("drop table Person");
 		stmt.executeUpdate("create table Student ( ID int, DEPARTMENT varchar(50),MARKS int)");
 		
 		prep = connect.prepareStatement("insert into Student values (?,?,?)");
 		
 		File f1 = new File("/home/iiitg/work_2/CS251/bin/Student.txt");
 		FileReader fr= new FileReader(f1);
 		Scanner sc =new Scanner(fr);
 		
 		while(sc.hasNextLine()){
 			String s1[] = sc.nextLine().split(" ");
 			int c1 = Integer.parseInt(s1[0]);
 			String s = s1[1];
 			int c2 = Integer.parseInt(s1[2]);
 			prep.setInt(1, c1);
 			prep.setString(2,s);
 			prep.setInt(3,c2);
 			int x = prep.executeUpdate();
 			System.out.println(x);
 		}
 		
 		stmt.executeUpdate ("create table Person ( ID int, NAME varchar(50),ADDRESS varchar(50))");

 		prep = connect.prepareStatement("insert into Person values (?,?,?)");
 		File f2 = new File("/home/iiitg/work_2/CS251/bin/Person.txt");
 		FileReader fr2= new FileReader(f2);
 		Scanner sc1 =new Scanner(fr2);
 		
 		while(sc1.hasNextLine()){
 			String str1[] = sc1.nextLine().split(" ");
 			int c1 = Integer.parseInt(str1[0]);
 			String s = str1[1];
 			String s2 = str1[2];
 			prep.setInt(1, c1);
 			prep.setString(2,s);
 			prep.setString(3,s2);
 			prep.executeUpdate();
 		}
 		
 		sc.close();
 		sc1.close();
 		fr.close();
 		fr2.close();
 		ResultSet table = null;
 		
 		
 		
 		
 		res=stmt.executeQuery("select name from Student s ,Person p where s.ID=p.ID and p.ADDRESS='Nagpur'");
 		System.out.println("Names from city Nagpur: ");
 		while(res.next()){
 			String t = res.getString("name");
 			System.out.println(t);
 		}
 		System.out.println();
 		System.out.println("Names From DEPT CSE: ");
 		res=stmt.executeQuery("select name from Student s ,Person p where s.ID=p.ID and s.DEPARTMENT='CSE'");
 		while(res.next()){
 			String t = res.getString("name");
 			System.out.println(t);
 		}
 		int max=0;
 		String m2="";
 		System.out.println();
 		System.out.print("Highest Marks->");
 		res=stmt.executeQuery("select id,marks from Student s");
 		int id = 0,id2=0;
 		while(res.next()){
 			
 			int t = res.getInt("marks");
 			id = res.getInt("id");
 			if(max<t)
 			{
 				max=t;
 				
 				id2 = id;
 			}
 		}	
 		
 		System.out.print("ID: "+id2+" Marks: "+max);
 		/*res=stmt.executeQuery("select name from Student ,Person where Student.ID=Person.ID and Person.id= i ");
 		while(res.next()){
 			String t1 = res.getString("name");
 			System.out.println(t1);
 		}*/
 		int sum=0,i=0;
 		float avg;
 		System.out.println();
 		System.out.print("Average: ");
 		res=stmt.executeQuery("select marks from Student");
 		while(res.next()){
 			int t = res.getInt("marks");
 	        sum=sum+t;
 	        i++;
 		}	
 		
 		avg=(float)sum/i;
 		
 		System.out.print(avg);
 		
 		
}
	}
