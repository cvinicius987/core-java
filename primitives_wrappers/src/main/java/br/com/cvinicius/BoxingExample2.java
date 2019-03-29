package br.com.cvinicius;

public class BoxingExample2 {

	public static void main(String[] args) {
		
		long init = System.currentTimeMillis();
		
		int result = 0;
				
		for (int i = 0; i < 1000000000; i++)
			result = i + 1;
		
		long end = System.currentTimeMillis();
		
		System.out.println("Resultado: "+result+" Tempo: "+(end - init));
	}
}