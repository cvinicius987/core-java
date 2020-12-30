package br.com.cvinicius.performance;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Leitura com Java NIO.
 * 
 * @author cvinicius
 * @since 20/04/2017
 * @version 1.0
 */
public class ReadNIO{
	
	private static final Path FILE = Paths.get("files/performance.txt");
	
	public static void main(String[] args) 
	throws Exception{
		
		long initial = System.currentTimeMillis();
		
		try{
			Files.readAllLines(FILE)
				 .stream()
				 .forEach(str -> {});
			
		}finally{
			long end = System.currentTimeMillis();
			
			System.out.println(String.format(" >>>> Tempo de execução: %d segundos.", ((end - initial) / 1000)));
		}
	}
}