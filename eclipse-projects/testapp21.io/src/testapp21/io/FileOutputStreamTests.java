package testapp21.io;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileOutputStreamTests {

	String sourcePath="D:\\MyWorks\\Corporate\\202110-ltts-java\\gandhi.txt";
	String targetPath="D:\\MyWorks\\Corporate\\202110-ltts-java\\test-output.txt";
	
	
	File sourceFile,targetFile;
	
	@BeforeEach
	void setUp() throws Exception {
		
		sourceFile=new File(sourcePath);		
		targetFile=new File(targetPath);
		assumeTrue(sourceFile.exists());
		
		if(targetFile.exists())
			targetFile.delete();	
		
	}
	@Test
	public void canCopyFileUsingFileOuputStream() throws IOException {
		
		var in= new FileInputStream(sourceFile);
		var out=new FileOutputStream(targetFile);
		
		
		int data;
		
		while((data=in.read())!=-1)
			out.write(data);
		
		in.close();
		out.close();
		
		assertEquals(sourceFile.length(),targetFile.length());		
		
	}
	
	@Test	
	public void canPrintToACharArray() {
		
		var arrayWriter=new CharArrayWriter();
		var printWriter=new PrintWriter(arrayWriter);
		
		String originalText="मेरा भारत महान";
		
		printWriter.print(originalText);
		
		printWriter.close();
		arrayWriter.close();
		
		var output=new String(arrayWriter.toCharArray());
		
		
		assertEquals(originalText,output);
	}
	
	
	
	
	

}
