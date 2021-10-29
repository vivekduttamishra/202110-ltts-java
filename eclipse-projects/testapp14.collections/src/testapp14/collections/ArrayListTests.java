package testapp14.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ArrayListTests {

	@Test
	public void testCanCreateAnArrayListOfStrings() {
		ArrayList<String>  names=new ArrayList<String>();
		assertEquals(0, names.size());
	}

	@Test
	public void canAddNewItems() {
		ArrayList<String>  names=new ArrayList<String>();
		for(int i=0;i<10;i++)
			names.add("name"+i);
		
		assertEquals(10,names.size());
	}
	
	
	@Test
	public void canFindAnItemIntTheArray() {
		List<String> names= Arrays.asList("India","USA","France","Japan");
		
		assertTrue(names.contains("India"));
		assertFalse(names.contains("Germany"));
		
		
	}
	
	
	@Test
	public void canFindRemoveItemFromTheArray() {
		List<String> names= new ArrayList();
				
		names.add("India");
		names.add("USA");
		names.add("France");
		names.add("Japan");
		
		names.remove("France");
		
		assertFalse(names.contains("France"));
		
	}
	
	
	@Test
	public void canClearTheList() {
		List<String> names= new ArrayList();
				
		names.add("India");
		names.add("USA");
		names.add("France");
		names.add("Japan");

		names.clear();
		assertEquals(0, names.size());
		
	}
	
	
	@Test
	public void canAccessEachItemUsingforEachLoop() {
		
		String []array= {"India","USA","France","Japan"};
		List<String> names= new ArrayList();
		
		for(var value :array)
			names.add(value);
				
		int i=0;
		for(var value : names) {
			assertEquals(array[i], value);
			i++;
		}

				
	}
	
	@Test
	public void canInsertAndGetByPosition() {
		
		List<String> names= new ArrayList();
		
		names.add("India");
		names.add("USA");
		names.add("France");
		names.add("Japan");
		
		names.add(1,"UK");
		
		assertEquals("UK",names.get(1));
		assertEquals("USA",names.get(2));
		
		

				
	}
	
	
}
