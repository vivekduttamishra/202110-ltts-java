package testapp20.streams;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class StreamTest {

	List<Integer> numbers;
	List<String> names;
	@Before
	public void setUp() throws Exception {
		numbers=Arrays.asList(2,9,11,18,4,5,15,22,29,23,35,17,12);
		names=Arrays.asList("India","USA", "France","Japan","Netherlands","UAE","UK","Germany");
	}

	@Test
	public void collection_canReturnAStream() {
	
		var x = numbers.stream();
		
		assertTrue(x instanceof Stream);
	}
	
	@Test
	public void stream_contentCanBePrinted() {
		StringBuilderConsumer b=new StringBuilderConsumer();
		
		var names= Arrays.asList("India","Usa","France");
		
		//names.stream().forEach( number -> b.add(number));
		
		names.stream().forEach(b::add);
		
		assertEquals("India\tUsa\tFrance\t", b.builder.toString());
		
		
	}
	
	@Test
	public void streamCanBeFiltered() {
		
		var count= names									//collection
						.stream()							//stream
						.filter( name -> name.length()<5)	//inermediate operation
						.count();							//terminal operation
		
		
		assertEquals(3, count);
		
		
	}
	
	@Test
	public void streamCanHaveMultipleIntermediatesElement() {
		
		var consumer= new StringBuilderConsumer();
		
		names									//collection ["India","USA", "France","Japan","Netherlands","UAE","UK","Germany"]
			.stream()							//stream   ("India","USA", "France","Japan","Netherlands","UAE","UK","Germany")
					//intermediate operations
			
			.filter(name-> name.length()>=5)	// stream of ("India", "France","Japan","Netherlands","Germany")
			.limit(2)							  // stream of ("India", "France")
			.map(name -> name.toUpperCase())	 // stream of ("INDIA","FRANCE")
				//terminal operation
			.forEach(consumer::add);			//data pushed to consumer
		
		
		assertEquals("INDIA\tFRANCE\t", consumer.builder.toString());
	}
	
	@Test(expected=IllegalStateException.class)
	public void cantConsumeAStreamTwice() {
		var stream = names.stream();
		
		long count=stream.count(); //stream has be consumed during count
		
		stream.forEach(System.out::println); //can't consume a second time
	}
	
	
	@Test
	public void streamIntermediateFunctionsDontExecuteWithoutATerminal(){
		
		int oddFilterCounter[]= {0};		
		int m5FilterCounter[]= {0};
		int doublerCounter[]= {0};
		
		var stream= numbers
					.stream()            			//(2,9,11,18,4,5,15,22,29,23,35,17,12)
					.filter(n->{
						oddFilterCounter[0]++;
						return n%2!=0;
					})								//(9,11,5,15,29,23,35,17)
					.filter(n->{
						m5FilterCounter[0]++;
						return n%5==0;
					})								//(5,15,35)
					.map(n->{
						doublerCounter[0]++;
						return n*2;
					});								//(10,30,70) <--- returned
		
		
		
		//intermediate operations don't execute till you apply a terminal
		assertEquals(0, oddFilterCounter[0]);
		assertEquals(0, m5FilterCounter[0]);
		assertEquals(0, doublerCounter[0]);
		
		stream.count(); //apply a terminal to execute the stream intermediates
		
		assertEquals(numbers.size(), oddFilterCounter[0]);
		assertEquals(8, m5FilterCounter[0]);
		assertEquals(3, doublerCounter[0]);

		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
