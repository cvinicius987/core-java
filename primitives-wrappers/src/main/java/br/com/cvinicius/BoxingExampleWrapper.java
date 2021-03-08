package br.com.cvinicius;

public class BoxingExampleWrapper {

	public static void main(String[] args) {
		
		long init = System.currentTimeMillis();
		
		Long result = 0L;
		
		for (long i = 0; i < 1000000000; i++) {
			result += i;
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(" Tempo: "+(end - init));
	}
}