package br.com.cvinicius.performance;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

/**
 * Leitura com Apache Commons.
 * 
 * @author cvinicius
 * @since 20/04/2017
 * @version 1.0
 */
public class ReadApacheCommons{
	
	private static final Path FILE = Paths.get("files/performance.txt");
	
	public static void main(String[] args) 
	throws Exception{
		
		long initial = System.currentTimeMillis();
		
		try{
			LineIterator it = FileUtils.lineIterator(FILE.toFile());
			
		    while(it.hasNext()){
		    	it.nextLine();
		    }
		
		    LineIterator.closeQuietly(it);
						
		}finally{
			long end = System.currentTimeMillis();
			
			System.out.println(String.format(" >>>> Tempo de execução: %d segundos.", ((end - initial) / 1000)));
		}
	}
}