package testapp14.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class HashMapTests {

	HashMap<String,String> map;
	
	@Before
	public void setup() {
		map=new HashMap<String, String>();
		map.put("in", "India");
		map.put("uk", "United Kingdom");
		map.put("fr", "France");
		map.put("jp", "Japan");
	}
	
	
	@Test
	public void mapHasASize() {
		assertEquals(4,map.size());
	}
	
	@Test
	public void canAccessValueByKey() {
		assertEquals("India",map.get("in"));		
	}
	
	@Test
	public void returnsNullWhenKeyIsNotFound() {
		var value=map.get("invalid-key");
		assertNull(value);
	}
	
	@Test
	public void keyIsCaseSensetive() {
		var value=map.get("IN");
		assertNull(value);
	}
	
	@Test
	public void putForExistingKeyReplacesValue() {
		map.put("in", "Bharat");
	
		assertEquals(4, map.size());
		
		assertEquals("Bharat",map.get("in"));
	}
	
	@Test
	public void canCheckIfKeyIsPresent() {
		assertTrue(map.containsKey("in"));
		assertFalse(map.containsKey("de"));
	}
	
	
	@Test
	public void canGetAllValues() {
		var values=map.values();
		
		assertTrue(values.contains("India"));
	}
	
	@Test
	public void canGetAllKeys() {
		var keys=map.keySet();
		System.out.println(keys);
		assertTrue(keys.contains("in"));
	}
	
	
	
	
	

}
