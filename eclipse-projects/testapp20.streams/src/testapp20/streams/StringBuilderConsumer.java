package testapp20.streams;

public class StringBuilderConsumer {
	StringBuilder builder=new StringBuilder();


	public void add(Object o) {
		builder.append(o);
		builder.append("\t");
	}
	
	

}
