package br.com.cvinicius;

public class WrapperExample {

	public static void main(String[] args) {
		
		Integer oneWrapper = 1; //Autoboxing do valor <1> para a variavel oneWrapper
		Integer twoWrapper = 1; //Autoboxing do valor <1> para a variavel twoWrapper
		
		System.out.println(" Comparação de Wrappers \n");
		System.out.println(oneWrapper == twoWrapper);
		System.out.println(oneWrapper != twoWrapper);
		System.out.println(oneWrapper.equals(twoWrapper));
	}
}