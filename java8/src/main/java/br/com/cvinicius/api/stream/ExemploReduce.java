package br.com.cvinicius.api.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ExemploReduce {

	public static void main(String[] args) {
		
		System.out.println(" ------------- Exemplo 1");
		
		//Lista de Numeros
		List<Integer> nums = Arrays.asList(3,5,2,4,1);
		
		//Função Responsavel pela soma dos valores
		BinaryOperator<Integer> sum = (x, y) -> x+y;
	
		//Uso do reduce retornando um optional com os valores.
		nums.stream()
			.reduce(sum)
			.ifPresent(System.out::println);
		
		System.out.println(" ------------- Exemplo 2");
		
		//Uso do reduce retornando um optional com os valores.
		Integer result = nums.stream()
							 .reduce(0, (x, y) -> x+y);
			
		System.out.println(result);
	}
}