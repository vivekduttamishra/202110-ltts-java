package testapp09.inheritance;

public class Employee {

	private int employeeId;
	protected String name;
	private double salary;	
	
//	public Employee() {
//		System.out.println("Employee Default constructor called");		
//	}
	
	public Employee(int id, String name, double salary) {
		System.out.println("Emplyoee details constructor called");
		employeeId=id;
		this.name=name;
		this.salary=salary;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String info() {
		return String.format("Employee [Id=%d, Name=%s,Salary=%f]", employeeId, name, salary);
	}
	
	public void work() {
		System.out.printf("%s works as employee#%d for salary of Rs %f\n",name,employeeId,salary);
	}
}
