package testapp09.inheritance;

public class Manager extends Employee{
	
	@Override
	public void work() {
		super.work(); //call from super class
		manage();
	}

	private String project;
	public Manager(int id, String name, double salary,String project) {
		super(id,name,salary);
		this.project=project;
		
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	
	public void manage() {
		System.out.printf("Manager %s manages %s\n",name,project);
	}
	
	
	
	
	
	
	
	
	
}
