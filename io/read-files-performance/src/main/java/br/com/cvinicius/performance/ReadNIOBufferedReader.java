package br.com.cvinicius.performance;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Leitura com BufferedReader.
 * 
 * @author cvinicius
 * @since 20/04/2017
 * @version 1.0
 */
public class ReadNIOBufferedReader{
	
	private static final Path FILE = Paths.get("files/performance.txt");
	
	public static void main(String[] args) 
	throws Exception{
		
		long initial = System.currentTimeMillis();
			
		try (BufferedReader br = Files.newBufferedReader(FILE, StandardCharsets.UTF_8)) {
			
			System.out.println(br.lines().count());
				    
		}finally{
			long end = System.currentTimeMillis();
			
			System.out.println(String.format(" >>>> Tempo de execução: %d segundos.", ((end - initial) / 1000)));
		}
	}
}