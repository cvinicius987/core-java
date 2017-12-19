package br.com.cvinicius.projetos.basico;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Manipulação de Strings.
 * 
 * @author cvinicius
 * @since 10/12/2016
 * @version 1.0
 */
public class ManipulacaoString{
	
	private List<String> list;
	
	public ManipulacaoString(List<String> list){
		this.list = list;
	}
	
	/**
	 * Retorna o total de palavras contidas na List.
	 * 
	 * @return Long
	 */
	public Long getTotalStrings(){
		
		return this.list.stream().count();
	}
	
	/**
	 * Retorna o total de palavras que contenham o Character correspondente.
	 * 
	 * @param Character charr
	 * @return Long
	 */
	public Long getTotalStringsComFilter(Character charr){
		
		return this.list.stream()
					.filter(l -> l.contains(String.valueOf(charr)))
					.count();
	}
	
	/**
	 * Retorna o total de palavras não repetidas.
	 * 
	 * @return Long
	 */
	public Long getTotalStringsDistinct(){
		
		return list.stream()
					.map(str -> str.toUpperCase())
					.distinct()
					.count();
	}
	
	/**
	 * Realiza a criação de uma String com os elementos
	 * não repetidas e separados por _
	 * 
	 * @return String
	 */
	public String getJoinStrPorUnderline(){
		
		return this.list.stream()
					.map(String::toUpperCase)
					.distinct()
					.collect(Collectors.joining("_"));
	}
	
	/**
	 * Retorna uma primeira palavra que contenha um Char.
	 * 
	 * @param charr
	 * @return String
	 */
	public String getPrimeiraPalavraPorChar(Character charr){
		
		return this.list.stream()
					.filter(str -> str.toUpperCase().contains(String.valueOf(charr).toUpperCase()))
					.findFirst()
					.get();
	}
	
	/**
	 * Realiza a conversão de uma List em Set.
	 * 
	 * @return Set<String>
	 */
	public Set<String> transformaListEmSet(){
		
		return this.list.stream().collect(Collectors.toSet());
	}
	
	/**
	 * Realiza a conversão de uma List em Set utilizando operação de Redução.
	 * 
	 * @return Set<String>
	 */
	public Set<String> transformaListEmSetComReduce(){
		
		return this.list.stream().reduce(new HashSet<String>(), 
										(Set<String> acc, String str) -> {
												acc.add(str); 
												return acc;
										},
										(Set<String> list1, Set<String> list2) -> {
											list1.addAll(list2);
											
											return list1;
										});
	}
		
	/**
	 * Retorna uma palavra e seu total de caracteres.
	 * 
	 * @return Map<String, Integer>
	 */
	public Map<String, Integer> getMapStrComTotalChars(){
		
		return this.list.stream().collect(Collectors.toMap(String::toString, String::length));
	}
	
	/**
	 * Criação de String a partir de uma List
	 * 
	 * @return String
	 */
	public String criaStrList(){
		
		return this.list.stream()
						.map(str -> str.concat(", "))
						.reduce("Frase da a partir da List: ", (acc, current) -> acc.concat(current));
	}
}