package br.com.cvinicius.projetos.basico;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.cvinicius.projetos.basico.ManipulacaoWrapper;

/**
 * Testes sobre aos exemplos de manipulação de Numbers.
 * 
 * @author cvinicius
 * @since 20/01/2017
 * @version 1.0
 */
public class ManipulacaoWrapperTest{

	private ManipulacaoWrapper manipulacaoNumeros;

	@Before
	public void prepare(){
		this.manipulacaoNumeros = new ManipulacaoWrapper(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	}
	
	@Test
	public void getSomaNumerosTest(){
		
		Integer number = this.manipulacaoNumeros.getSomaNumeros(); 
		
		Assert.assertSame(45, number);
	}
	
	@Test
	public void somaNumerosParesTest(){
		
		Integer number = this.manipulacaoNumeros.somaNumerosPares(); 
		
		Assert.assertSame(20, number);
	}
	
	@Test
	public void getMaiorNumeroTest(){
		
		Integer number = this.manipulacaoNumeros.getMaiorNumero(); 
		
		Assert.assertSame(9, number);
	}
		
	@Test
	public void getNumerosParesTest(){
	
		List<Integer> listNumbers = this.manipulacaoNumeros.getNumerosPares(); 
		
		Assert.assertSame(4, listNumbers.size());
	}
}