package in.conceptarchitect.animals;

public abstract class Cat extends Mammal implements Hunter {

	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return this+" is carnivour";
	}
	
	public String hunt() {
		return this+" is a great hunter";
	}
	
	
}
