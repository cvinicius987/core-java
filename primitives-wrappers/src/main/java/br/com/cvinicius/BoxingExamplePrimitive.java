package br.com.cvinicius;

public class BoxingExamplePrimitive {

	public static void main(String[] args) {
		
		long init = System.currentTimeMillis();
		
		long result = 0;
		
		for (long i = 0; i < 1000000000; i++) {
			result += i;
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(" Tempo: "+(end - init));	
	}
}