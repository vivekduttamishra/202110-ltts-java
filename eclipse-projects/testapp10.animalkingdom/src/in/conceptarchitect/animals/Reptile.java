package in.conceptarchitect.animals;

public class Reptile extends Animal {

	@Override
	public String breed() {
		// TODO Auto-generated method stub
		return this+" lays eggs";
	}
	
	@Override
	public String move() {
		// TODO Auto-generated method stub
		return this+" crawls ";
	}	
	
	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return this+" is omnivour";
	}
	
	public String hunt() {
		return this+" hunts somehow";
	}
}
