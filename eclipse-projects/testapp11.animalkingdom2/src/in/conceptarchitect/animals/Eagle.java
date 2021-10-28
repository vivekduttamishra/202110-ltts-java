package in.conceptarchitect.animals;

public class Eagle extends Bird implements Hunter {
	
	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return this+" is a flesh eater";
	}

	
	public String hunt() {
		return this+" is a flying hunter";
	}
	
// can't override a final method
//	public String die() {	
//		
//		
//		return this+" dies of flying";
//	}
}
