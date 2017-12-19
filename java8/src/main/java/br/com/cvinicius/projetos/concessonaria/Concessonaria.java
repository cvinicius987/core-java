package br.com.cvinicius.projetos.concessonaria;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Concessonaria.
 * 
 * @author cvinicius
 * @since 23/01/2017
 * @version 1.0
 */
public class Concessonaria{
	
	private List<Carro> carros;
	
	public Concessonaria(List<Carro> carros){
		this.carros = carros;
	}
	
	/**
	 * Retorna um Map de Marca com seus Carros.
	 * 
	 * @return Map<Marca, List<Carro>
	 */
	public Map<Marca, List<Carro>> getGroupMarcaComCarros(){
		
		return this.carros.stream().collect(Collectors.groupingBy(Carro::getMarca));
	}
	
	/**
	 * Retorna uma lista de carros com valor maior que o parametro.
	 * 
	 * @param valor
	 * @return List<Carro>
	 */
	public List<Carro> getCarrosPorPreco(BigDecimal valor){
		
		return this.carros.stream()
				   			.filter(carro -> carro.getValor().compareTo(valor) == 1)
				   			.sorted(Comparator.comparing(Carro::getValor))
				   			.collect(Collectors.toList());
	}
	
	/**
	 * Retorna uma lista de carros de um determinado ANO.
	 * 
	 * @param year
	 * @return List<Car>
	 */
	public List<Carro> getCarrosPorAno(Year year){
		
		return this.carros.stream()
				   			.filter(car -> car.getAno().equals(year))
				   			.sorted(Comparator.comparing(Carro::getValor))
				   			.collect(Collectors.toList());
	}
	
	/**
	 * Retorna o Carro mais CARO.
	 * 
	 * @return Carro
	 */
	public Carro getCarroMaisCaro(){
		
		return this.carros.stream()
				   			.reduce((current, next) -> current.getValor().compareTo(next.getValor()) == 1 ? current : next)
				   			.get();
	}
	
	/**
	 * Retorna o carro mais BARATO.
	 * 
	 * @return Carro
	 */
	public Carro getCarroMaisBarato() {
		
		return this.carros.stream()
							.reduce((current, next) -> current.getValor().compareTo(next.getValor()) != 1 ? current : next)
							.get();
						
	}	
	
	/**
	 * Retorna o valor do patrimonio da Concessonaria,
	 * que é a soma de todas os carros.
	 * 
	 * @return BigDecimal
	 */
	public BigDecimal getPatrominio(){
		
		return this.carros.stream()
					   		.map(carro -> carro.getValor())
					   		.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	/**
	 * Retorna estatiscas sobre os valores dos carros.
	 * 
	 * @return DoubleSummaryStatistics
	 */
	public DoubleSummaryStatistics getEstatisticaValor(){
		
		return this.carros.stream()
							.mapToDouble(carro -> carro.getValor().doubleValue())
							.summaryStatistics();
	}
	
	/**
	 * Retorna os carros aagrupados pro Ano.
	 * 
	 * @return  Map<Year, List<Carro>>
	 */
	public Map<Year, List<Carro>> getGroupAnoComCarros(){
		
		return this.carros.stream().collect(Collectors.groupingBy(Carro::getAno));
	}
}