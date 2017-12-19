package br.com.cvinicius.projetos.calculadora;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.cvinicius.projetos.calculadora.Calculadora;

public class CalculadoraTest {

	private Calculadora calculadora;
	
	@Before
	public void prepare(){
		this.calculadora = new Calculadora();
	}
	
	@Test
	public void somaTest(){
		
		BigDecimal valor1 = BigDecimal.valueOf(1000.00);
		BigDecimal valor2 = BigDecimal.valueOf(3000.00);
		BigDecimal result = BigDecimal.valueOf(4000.00);
		
		Assert.assertEquals(result, this.calculadora.soma.apply(valor1, valor2));
	}
	
	@Test
	public void subtracaoTest(){
		
		BigDecimal valor1 = BigDecimal.valueOf(15000.00);
		BigDecimal valor2 = BigDecimal.valueOf(3000.00);
		BigDecimal result = BigDecimal.valueOf(12000.00);
				
		Assert.assertEquals(result, this.calculadora.subtracao.apply(valor1, valor2));
	}
	
	@Test
	public void multiplicacaoTest(){
		
		BigDecimal valor1 = BigDecimal.valueOf(2000.00);
		BigDecimal valor2 = BigDecimal.valueOf(3);
		BigDecimal result = BigDecimal.valueOf(6000.00);
		
		Assert.assertEquals(result, this.calculadora.multicacao.apply(valor1, valor2));
	}
	
	@Test
	public void divisaoTest(){
		
		BigDecimal valor1 = BigDecimal.valueOf(40000.00);
		BigDecimal valor2 = BigDecimal.valueOf(2);
		BigDecimal result = BigDecimal.valueOf(20000.00);
				
		Assert.assertEquals(result, this.calculadora.divisao.apply(valor1, valor2));
	}
}