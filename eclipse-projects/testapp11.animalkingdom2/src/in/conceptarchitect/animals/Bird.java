package in.conceptarchitect.animals;

public abstract class Bird extends Animal {

	@Override
	public String breed() {
		// TODO Auto-generated method stub
		return this+" lays eggs";
	}
	
	@Override
	public String move() {
		// TODO Auto-generated method stub
		return this+" fly";
	}
	
	
}
