
public class Student_A5 {
	private String name;
	private int roll;
	private int m1;
	private int m2;
	private int m3;
	private char grade;
	public int p = 0;
	Student_A5(String n,int r,int M1,int M2,int M3){
		this.name = n;
		this.roll = r;
		this.m1 = M1;
		this.m2 = M2;
		this.m3 = M3;
	}
	String getName(){
		return name;
	}
	int getRoll(){
		return roll;
	}
	void findGrade(){
		p = (m1+m2+m3)*100/3;
	}
	char getGrade(){
		if(p>=90)
			return 'A';
		else if(p<90 && p>=80)
			return 'B';
		else if(p<80 && p>=60)
			return 'C';
		else if(p<60 && p>=40)
			return 'D';
		else
			return 'F';
	}
	
}
