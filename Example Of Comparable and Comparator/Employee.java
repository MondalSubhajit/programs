import java.util.*;

class EmployeeEntity implements Comparable<EmployeeEntity>
{
	String name;
	String desig;
	
	EmployeeEntity(String name, String desig){
		this.name = name;
		this.desig = desig;
	}

	public int compareTo(EmployeeEntity e1){
		return this.desig.compareTo(e1.desig);
	}

	public String toString(){
		return "[name:"+this.name+", desig:"+this.desig+"]";
	}
}

class EmployeeSortByDesig implements Comparator<EmployeeEntity>
{
	public int compare(EmployeeEntity arg0, EmployeeEntity arg1){
		return arg0.desig.compareTo(arg1.desig);
	}
}

class EmployeeSortByName implements Comparator<EmployeeEntity>
{
	public int compare(EmployeeEntity arg0, EmployeeEntity arg1){
		return arg0.name.compareTo(arg1.name);
	}
}

public class Employee
{
	public static void main(String[] args) {
		ArrayList<EmployeeEntity> emps = new ArrayList();
		ArrayList<EmployeeEntity> emps2 = new ArrayList();

		EmployeeEntity e1 = new EmployeeEntity("Saroj","sd");
		EmployeeEntity e2 = new EmployeeEntity("Ankit","seo");
		EmployeeEntity e3 = new EmployeeEntity("Vishnu","ceo");
		EmployeeEntity e4 = new EmployeeEntity("Harry","z");

		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		emps.add(e4);

		//copy of unsorted emps
		emps2 = emps;

		System.out.println("Before Sort By Designation");
		for(EmployeeEntity e: emps) System.out.println(e);

		Collections.sort(emps);

		System.out.println("After Sort By Designation by Comparable");
		for(EmployeeEntity e: emps) System.out.println(e);

		Collections.sort(emps2, new EmployeeSortByDesig());

		System.out.println("After Sort By Designation by Comparator");
		for(EmployeeEntity e: emps2) System.out.println(e);
		
		Collections.sort(emps2, new EmployeeSortByName());

		System.out.println("After Sort By Name by Comparator");
		for(EmployeeEntity e: emps2) System.out.println(e);
	}
}
