package in.conceptarchitect.animals;

public class Crocodile extends Reptile {
	
	
	@Override
	public String move() {
		// TODO Auto-generated method stub
		return super.move()+ " and swims in water";
	}
	
	
      @Override
    public String hunt() {
    	// TODO Auto-generated method stub
    	return this+" is a great underwater hunter";
    }
}
