package testapp09.inheritance;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Manager manager=new Manager(2,"Sanjay",50000,"L&D");
		
		manager.work();
		
		Employee employee=manager;//allowed
		
		employee.work(); //allowed
		
		
		
		//setEmployeeDetails(manager,"Sanjay",2,10000);
		useEmployee(manager);
		
		
		
	}

	private static void useEmployee(Employee employee) {
		System.out.println(employee.info());
		employee.work();
	}

	private static void setEmployeeDetails(Employee employee,String name, int id, double salary) {
		employee.setName(name);
		employee.setEmployeeId(id);
		employee.setSalary(salary);
	}

}
