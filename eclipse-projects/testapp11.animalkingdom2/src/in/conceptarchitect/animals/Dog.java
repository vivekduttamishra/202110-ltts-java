package in.conceptarchitect.animals;

public class Dog extends Mammal implements Hunter , Domestic{

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return this+" is carnivour";
	}
	
	public String hunt() {
		return this+" is a great hunter";
	}
	
	
}
