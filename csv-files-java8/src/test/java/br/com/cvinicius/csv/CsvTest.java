package br.com.cvinicius.csv;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class CsvTest {
	
	private Csv fileCsv;
	
	@Before
	public void prepare(){
		this.fileCsv = new Csv();
	}
	
	@Test
	public void getColumnsTest() throws IOException{
		
		fileCsv.getColumns().forEach(System.out::println);
	}
	
	@Test
	public void getColumnsWithoutFirstLineTest() throws IOException{
		
		fileCsv.getColumnsWithoutFirstLine().forEach(System.out::println);
	}
	
	@Test
	public void getColumnsToObjTest() throws IOException{
		
		fileCsv.getColumnsToObj().forEach(System.out::println);
	}
	
	@Test
	public void getUserAgeBigger30Test() throws IOException{
		
		fileCsv.getUserAgeBigger30().forEach(System.out::println);
	}
}