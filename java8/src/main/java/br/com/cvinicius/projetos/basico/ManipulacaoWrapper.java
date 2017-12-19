package br.com.cvinicius.projetos.basico;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Manipulação de números e tipos Wrapper.
 * 
 * @author cvinicius
 * @since 10/12/2016
 * @version 1.0
 */
public class ManipulacaoWrapper{
	
	private List<Integer> list;
	
	public ManipulacaoWrapper(List<Integer> list){
		this.list = list;
	}
	
	/**
	 * Soma os valores de uma List
	 * 
	 * @param list
	 * @return Integer
	 */
	public Integer getSomaNumeros(){

		return this.list.stream().reduce(0, (acc, current) -> acc + current);
	}
	
	/**
	 * Cria Set a partir de um range de ints.
	 * 
	 * @param list
	 * @return Set<Integer>
	 */
	public Set<Integer> getSetPorRange(int initial, int finall){

		return IntStream.range(initial, finall)
							.mapToObj(Integer::valueOf)
							.collect(Collectors.toSet());
	}
	
	/**
	 * Soma os números pares de uma Collection.
	 * 
	 * @param list
	 * @return Integer
	 */
	public Integer somaNumerosPares(){

		return this.list.stream().reduce(0, (acc, current) -> current % 2 == 0 ? acc + current : acc);
	}
	
	/**
	 * Utiliza redução para recuperar o maior número da List.
	 * 
	 * @param list
	 * @return Integer
	 */
	public Integer getMaiorNumero(){

		return this.list.stream()
					  		.reduce((current, nextNumber) -> current > nextNumber ? current : nextNumber)
					  		.orElse(0);
	}
	
	/**
	 * Retorna um List de números pares.
	 * 
	 * @param list
	 * @return List<Integer>
	 */
	public List<Integer> getNumerosPares(){

		return this.list.stream()
				   			.filter(num -> num % 2 == 0)
				   			.collect(Collectors.toList());
	}
}