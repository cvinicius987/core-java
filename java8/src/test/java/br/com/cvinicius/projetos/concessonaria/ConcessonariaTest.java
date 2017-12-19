package br.com.cvinicius.projetos.concessonaria;

import java.math.BigDecimal;
import java.time.Year;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.cvinicius.projetos.concessonaria.Carro;
import br.com.cvinicius.projetos.concessonaria.Concessonaria;
import br.com.cvinicius.projetos.concessonaria.Marca;

/**
 * Testes sobre os exemplos de manipulação da Concessonaria.
 * 
 * @author cvinicius
 * @since 20/01/2017
 * @version 1.0
 */
public class ConcessonariaTest{

	private Concessonaria concessonaria;
	
	@Before
	public void prepare(){
		
		Marca fiat 		= new Marca("Fiat", "Italia");
		Marca ford 		= new Marca("Ford", "Estados Unidos");
		Marca renault 	= new Marca("Renault", "França");
		
		List<Carro> carros = new ArrayList<>();
		
		carros.add(new Carro("Uno", Year.parse("2012"), BigDecimal.valueOf(10000.00), fiat));
		carros.add(new Carro("Palio", Year.parse("2013"), BigDecimal.valueOf(20000.00), fiat));
		carros.add(new Carro("Fiesta", Year.parse("2014"), BigDecimal.valueOf(30000.00), ford));
		carros.add(new Carro("Focus", Year.parse("2015"), BigDecimal.valueOf(40000.00), ford));
		carros.add(new Carro("Fluence", Year.parse("2016"), BigDecimal.valueOf(50000.00), renault));
		carros.add(new Carro("Duster", Year.parse("2017"), BigDecimal.valueOf(60000.00), renault));
		
		this.concessonaria = new Concessonaria(carros);
	}
	
	@Test
	public void getGroupMarcaComCarrosTest(){
		
		Map<Marca, List<Carro>> map = this.concessonaria.getGroupMarcaComCarros(); 
		
		Assert.assertSame(3, map.keySet().size());
	}

	@Test
	public void getCarrosPorPrecoTest() {
		
		BigDecimal valor = BigDecimal.valueOf(20000.00);
				
		List<Carro> resultCars = this.concessonaria.getCarrosPorPreco(valor);
		
		Assert.assertSame(4, resultCars.size());
		
		resultCars.forEach(System.out::println);
	}

	@Test
	public void getCarrosPorAnoTest() {
		
		List<Carro> resultCars = this.concessonaria.getCarrosPorAno(Year.of(2014));
		
		Assert.assertSame(1, resultCars.size());
		
		resultCars.forEach(System.out::println);
	}

	@Test
	public void getCarroMaisCaroTest(){
		
		BigDecimal valor = BigDecimal.valueOf(60000.00);
		
		Carro carroMaisCaro = this.concessonaria.getCarroMaisCaro();
		
		Assert.assertNotNull(carroMaisCaro);
		Assert.assertEquals(valor, carroMaisCaro.getValor());
	}
	
	@Test
	public void getCarroMaisBaratoTest(){
		
		BigDecimal valor = BigDecimal.valueOf(10000.00);
		
		Carro carroMaisBarato = this.concessonaria.getCarroMaisBarato();
		
		Assert.assertNotNull(carroMaisBarato);
		Assert.assertEquals(valor, carroMaisBarato.getValor());
	}
		
	@Test
	public void getPatrominioTest(){
		
		BigDecimal valor = BigDecimal.valueOf(210000.00);
		
		BigDecimal sum = this.concessonaria.getPatrominio();
		
		Assert.assertNotNull(sum);
		Assert.assertEquals(valor, sum);
	}
		
	@Test
	public void getEstatisticaValorTest(){
		
		DoubleSummaryStatistics result = this.concessonaria.getEstatisticaValor();
				
		long count 		= 6L;
		double sum 		= 210000.00;
		double min 		= 10000.00;
		double average 	= 35000.00;
		double max 		= 60000.00;
				
		Assert.assertEquals(count, result.getCount());
		Assert.assertEquals(sum, result.getSum(), 0.0);
		Assert.assertEquals(min, result.getMin(), 0.0);
		Assert.assertEquals(average, result.getAverage(), 0.0);
		Assert.assertEquals(max, result.getMax(), 0.0);
	}
	
	@Test
	public void getAnosComCarrosTest(){
		
		Map<Year, List<Carro>> map = this.concessonaria.getGroupAnoComCarros();
		
		Assert.assertNotNull(map);
		Assert.assertSame(6, map.keySet().size());
	}
}