package testapp19.generic;

import java.util.ArrayList;
import java.util.List;

public class Helper {
	
	public static <T> void process(List<T> values, Task<T> task) {
		
		for(var value : values)
			
			task.execute(value);
	}
	
	public static  List<Integer>  findAllOdd(List<Integer> values){
		var result=new ArrayList<Integer> ();
		
		for(var value : values)
			if(value%2!=0)
				result.add(value);
		
		return result;
	}
	
	public static  List<Integer>  findAllValueGreaterThan30(List<Integer> values){
		var result=new ArrayList<Integer> ();
		
		for(var value : values)
			if(value>30)
				result.add(value);
		
		return result;
	}
	
	
	public static <T> List<T> findAll(List<T> values, Matcher<T> matcher){
		
		var result=new ArrayList<T>();
		
		for(var value : values) {
			
			if(matcher.match(value))
				result.add(value);
			
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	

}
