package in.conceptarchitect.animals;

public class Mammal extends Animal {
	
	@Override	
	public String breed() {
		// TODO Auto-generated method stub
		return this+" gives birth";
	}
	
	@Override
	public String move() {
		// TODO Auto-generated method stub
		return this+" walks on land";
	}

}
