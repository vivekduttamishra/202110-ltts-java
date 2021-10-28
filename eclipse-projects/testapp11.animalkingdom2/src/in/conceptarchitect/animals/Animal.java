package in.conceptarchitect.animals;

public abstract class Animal {
	
	
	public abstract String eat() ;
	
	public abstract String move() ;
	
	public abstract String breed() ;
	
	
	//not all method need to be abstract
	public final String die() {
		return this+" is dead";
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return this.getClass() +"#" + Integer.toHexString(hashCode());
		
		return this.getClass().getSimpleName();
	}
	
	public final boolean isDomestic() {
		return this instanceof Domestic;
	}

}
