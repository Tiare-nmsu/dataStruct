import java.util.*;

public class Employee {
	
// 1	private??? instance variables
	
	private String name;
	private int no;
	private int age;
	private String state;
	private int zip;
	private int[] advisors = new int[3];
	
// 2.1	constructor

	public Employee() {
		
		name = null;
		no = 0;
		age = 0;
		state = null;
		zip = 0;
		Arrays.fill(advisors, 0); // default is zero???
	
	}// default constructor
	
// 2.2	copy constructor
	
	public Employee(Object obj) {

		name = ((Employee) obj).getName();
		no = ((Employee) obj).getNo();
		age = ((Employee) obj).getAge();
		state = ((Employee) obj).getState();
		zip = ((Employee) obj).getZip();
		advisors[0] = ((Employee) obj).getAdvisor0();
		advisors[1] = ((Employee) obj).getAdvisor1();
		advisors[2] = ((Employee) obj).getAdvisor2();
	
	}// copy constructor

// 2.3	get and set for all variables
	
	public String getName() {
		String currName;
		currName = name;
		return currName;
	}
	
	public int getNo() {
		return no;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getState() {
		String currState;
		currState = state;
		return currState;
	}

	public int getZip() {
		return zip;
	}
	
	public int getAdvisor0() {
		if(advisors[0] != 0)
			return advisors[0];
		else
			return 0;
	}
	
	public int getAdvisor1() {
		if(advisors[1] != 0)
			return advisors[1];
		else
			return 0;
	}

	public int getAdvisor2() {
		if(advisors[2] != 0)
			return advisors[2];
		else
			return 0;
	}
	
	public void setName(String a) {
		name = a;
	}
	
	public void setNo(int b) {
		no = b;
	}
  
	public void setAge(int c) {
		age = c;
	}
	
	public void setState(String d) {
		state = d;
	}
	
	public void setZip(int e) {
		zip = e;
	}
	
	public void setAdvisor0(int f) {
		advisors[0] = f;
	}
	
	public void setAdvisor1(int g) {
		advisors[1] = g;
	}

	public void setAdvisor2(int h) {
		advisors[2] = h;
	}

// 2.4	toString method
	
	public String toString() {
		
		String results;
		String data;
		String ad1;
		String ad2;
		String ad3;
		
		
		data = String.format("Name: " + getName() + "	" 
				+ "No. " + getNo() + "\n" 
				+ "Age: " + getAge() + "\n" 
				+ "State: " + getState() + "\n" 
				+ "Zip: " + getZip());
		
		if(advisors[0] != 0)
			ad1 = String.format("Advisor 1 no: " + getAdvisor0());
		else
			ad1 = "Advisor 1 no: None";
		
		if(advisors[1] != 0)
			ad2 = String.format("Advisor 2 no: " + getAdvisor1());
		else
			ad2 = "Advisor 2 no: None";
		
		if(advisors[2] != 0)
			ad3 = String.format("Advisor 3 no: " + getAdvisor2());
		else
			ad3 = "Advisor 3 no: None";
		
		results = String.format("Employee Data:\n" + data + "\n" + ad1 + "\n" + ad2 + "\n" + ad3);
		
		return results;
	}// to String
	
// 2.5	equals method (true if employee no are equal)
	
	public boolean equals(Object obj) {
		if(no == ((Employee) obj).getNo())
			return true;
		else
			return false;
	}// equals
	
// 2.6	getAllAdvisors
	public static int[] getAllAdvisors(Employee e1, Employee e2) {
		
		int unique[] = new int[6];
		int cnt = 0;
		int a, b, c, x, y, z;
		a = e1.getAdvisor0();
		b = e1.getAdvisor1();
		c = e1.getAdvisor2();
		x = e2.getAdvisor0();
		y = e2.getAdvisor1();
		z = e2.getAdvisor2();
		
		if(a != x && a != y && a != z) {
			unique[0] = a;
			cnt++;
		}
		if (b != x && b != y && b != z) {
			unique[1] = b;
			cnt++;
		}
		if (c != x && c != y && c != z) {
			unique[2] = c;
			cnt++;
		}
		if(x != a && x != b && x != c) {
			unique[3] = x;
			cnt++;
		}
		if (y != a && y != b && y != c) {
			unique[4] = y;
			cnt++;
		}
		if (z != a && z != b && z != c) {
			unique[5] = z;
			cnt++;
		}
		
		return unique;
		
	}// getAllAdvisors
	
// 2.7 	main method TODO main
	
	public static void main(String[] args) {
		
		System.out.println("CREATED EMPLOYEE LUIGI");
		Employee Luigi = new Employee();
		System.out.println(Luigi.toString());
		System.out.println();
		
		System.out.println("INITIALIZING LUIGI");
		Luigi.setName("Luigi");
		Luigi.setAge(43);
		Luigi.setState("New Mexico");
		Luigi.setNo(2);
		Luigi.setZip(22222);
		Luigi.setAdvisor0(1000);
		Luigi.setAdvisor1(2000);
		Luigi.setAdvisor2(3000);
		System.out.println(Luigi.toString());
		System.out.println();
		
		System.out.println("COPY CONSTRUCTING MARIO");
		Employee Mario = new Employee(Luigi);
		System.out.println(Mario.toString());
		System.out.println();
		
		System.out.println("UPDATING MARIO");
		Mario.setName("Mario");
		Mario.setAge(43);
		Mario.setState("New York");
		Mario.setNo(1);
		Mario.setZip(11111);
		Mario.setAdvisor0(40);
		Mario.setAdvisor1(50);
		Mario.setAdvisor2(60);
		System.out.println(Mario.toString());
		System.out.println();
		
		System.out.println("CHECKING ON LUIGI");
		System.out.println(Luigi.toString());
		System.out.println();
		
		System.out.println("MAKING GOOIGI(luigi copy) & UPDATING VALUES");
		Employee Gooigi = new Employee(Luigi);
		Gooigi.setName("Gooigi");
		Gooigi.setAge(01);
		Gooigi.setState("E.Gadd's Lab");
		Gooigi.setZip(8000);
		Gooigi.setAdvisor1(1234);
		Gooigi.setAdvisor2(5678);
		System.out.println(Gooigi.toString());
		System.out.println();
		
		System.out.println("LUIGI NO == GOOIGI NO? TEST #1");
		System.out.println("Luigi no:	" + Luigi.getNo());
		System.out.println("Gooigi no:	" + Gooigi.getNo());
		System.out.println("Are the employee no. the same?");
		System.out.println("RESULTS:	" + Luigi.equals(Gooigi));
		System.out.println();
		
		System.out.println("LUIGI NO == GOOIGI NO? TEST #2");
		Luigi.setNo(4);
		Gooigi.setNo(6);
		System.out.println("Luigi no:	" + Luigi.getNo());
		System.out.println("Gooigi no:	" + Gooigi.getNo());
		System.out.println("Are the employee no. the same?");
		System.out.println("RESULTS:	" + Gooigi.equals(Luigi));
		System.out.println();
		
		System.out.println("UNIQUE ADVISORS: Luigi & Gooigi");
		int[] unAdv = getAllAdvisors(Luigi, Gooigi);
		System.out.println("Unique Advisors: ");
		for(int i = 0; i < 6; i++) {
			System.out.println(unAdv[i]);
		}
		System.out.println();
		
		System.out.println("UNIQUE ADVISORS: Luigi & Mario");
		unAdv = getAllAdvisors(Luigi, Mario);
		System.out.println("Unique Advisors: ");
		for(int i = 0; i < 6; i++) {
			System.out.println(unAdv[i]);
		}
		System.out.println();
		
		System.out.println("UNIQUE ADVISORS: Gooigi & Mario");
		Mario.setAdvisor0(10);
		Mario.setAdvisor1(11);
		Mario.setAdvisor2(12);
		Gooigi.setAdvisor0(13);
		Gooigi.setAdvisor1(12);
		Gooigi.setAdvisor2(11);
		unAdv = getAllAdvisors(Gooigi, Mario);
		System.out.println("Unique Advisors: ");
		for(int i = 0; i < 6; i++) {
			System.out.println(unAdv[i]);
		}
		System.out.println();
		
	}// main
	
}// Employee
