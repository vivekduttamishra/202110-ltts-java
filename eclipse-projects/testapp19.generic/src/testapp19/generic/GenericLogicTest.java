package testapp19.generic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenericLogicTest {
	
	List<Integer> values;
	int total;
	

	@BeforeEach
	void setUp() throws Exception {
		int [] array={2,9,11,8,26,31, 52, 20, 55, 5, 11, 40 };
		values=new ArrayList<Integer>();
		for(var item: array) {
			values.add(item);
		}
		
		total=values.size();
	}

	@Test
	public void testCounterTask() {
		var counter=new ItemCounter<Integer>();
		
		Helper.process(values, counter);
		
		assertEquals(total, counter.getCount());
		
	}
	
	@Test
	public void findAllOddReturnsAllOdds() {
		
		var odds = Helper.findAllOdd(values);
		
		for(var value:odds)
			assertTrue(value%2!=0);
	}
	
	@Test
	public void findAllValuesGreaterThan30() {
		var bigValues= Helper.findAllValueGreaterThan30(values);
		
		assertEquals(4,bigValues.size());
	}
	
	@Test
	public void findMultiplesOf5() {
		
		class MultipleOf5 implements Matcher<Integer>{
			@Override
			public boolean match(Integer value) {
				// TODO Auto-generated method stub
				return value%5==0;
			}		
			
		}
		
		var m5=new MultipleOf5();
		
		var result= Helper.findAll(values, m5);
		
		assertEquals(4,result.size());
	}
	
	
	@Test
	public void findAllValuesGreaterThan40() {
		
		var matcher=new Matcher<Integer>() {

			@Override
			public boolean match(Integer value) {
				// TODO Auto-generated method stub
				return value>40;
			}
			
		};
		
		var result= Helper.findAll(values, matcher);
		
		assertEquals(52,result.get(0));
		assertEquals(55, result.get(1));
		
	}
	
	
	
	
	
	
	

}
