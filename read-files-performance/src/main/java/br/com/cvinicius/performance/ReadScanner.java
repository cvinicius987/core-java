package br.com.cvinicius.performance;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Leitura com Scanner.
 * 
 * @author cvinicius
 * @since 20/04/2017
 * @version 1.0
 */
public class ReadScanner{
	
	private static final Path FILE = Paths.get("files/performance.txt");
	
	public static void main(String[] args) 
	throws Exception{
		
		long initial = System.currentTimeMillis();
		
		try(Scanner sc = new Scanner(FILE)){
			
		    while(sc.hasNextLine()){
		    	sc.nextLine();
		    }
		   			
		}finally{
			
			long end = System.currentTimeMillis();
			
			System.out.println(String.format(" >>>> Tempo de execução: %d segundos.", ((end - initial) / 1000)));
		}
	}
}