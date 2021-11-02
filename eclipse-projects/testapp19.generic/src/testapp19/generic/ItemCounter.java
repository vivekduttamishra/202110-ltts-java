package testapp19.generic;

public class ItemCounter<V> implements Task<V> {

	int count;
	
	public int getCount() {
		return count;
	}

	@Override
	public void execute(V value) {
		// TODO Auto-generated method stub
		//System.out.println(value);
		count++;
	}

}
