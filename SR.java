
public class SR {
	public int roll=-1;
	public String name="000";
	public String dept="000";
	SR(){
		roll=-1;
		name="000";
		dept="000";
	}
	SR(int rollNo){
		roll = rollNo;
	}
	
	SR(int rollNo,String n){
		roll = rollNo;
		name = n;
	}
	SR(int rollNo,String n,String d){
		roll = rollNo;
		name = n;
		dept = d;
	}
	SR(SR obj2){
		this(obj2.roll,obj2.name,obj2.dept);
		
	}
	public void display(){
		System.out.println("Name: "+name);
		System.out.println("Roll-No: "+roll);
		System.out.println("Dept: "+dept);
	}

}
