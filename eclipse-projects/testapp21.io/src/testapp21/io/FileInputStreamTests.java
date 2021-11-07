package testapp21.io;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileInputStreamTests {

	String path="D:\\MyWorks\\Corporate\\202110-ltts-java\\gandhi.txt";
	
	File file;
	
	@BeforeEach
	void setUp() throws Exception {
		
		file=new File(path);
		
		assumeTrue(file.exists());
	}

	@Test
	void canReadFileContentByByByte() throws IOException {
		
		var stream= new FileInputStream(file);
		long count=0;
		int data;
		while(true) {
			data= stream.read();
			if(data==-1) //end of file
				break;
			count++;
		}
		stream.close();
		assertEquals(file.length(), count);
		
	}
	
	@Test 
	public void canReadAnArrayUsingStream() throws IOException{
		
		String data="India is great";
		var byteArray=data.getBytes();
		
		var stream= new ByteArrayInputStream(byteArray);
		
		String output="";
		
		int b;
		
		while((b=stream.read())!=-1) {
			output+=(char)b;
		}
		
		stream.close();
		
		assertEquals(data,output);
		
	}
	
	

}
