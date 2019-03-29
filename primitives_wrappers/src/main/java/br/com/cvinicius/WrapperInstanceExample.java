package br.com.cvinicius;

public class WrapperInstanceExample {

	public static void main(String[] args) {
		
		Integer oneWrapper = 1; //Autoboxing do valor <1> para a variavel oneWrapper
		Integer twoWrapper = new Integer(1); //Criação sem reaproveitar o objeto do pool
		
		System.out.println(" Comparação de Wrappers com Instância direta \n");
		System.out.println(oneWrapper == twoWrapper);
		System.out.println(oneWrapper != twoWrapper);
		System.out.println(oneWrapper.equals(twoWrapper));
	}
}