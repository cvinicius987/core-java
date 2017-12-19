package br.com.cvinicius.projetos.basico;

import java.util.Arrays;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.cvinicius.projetos.basico.ManipulacaoString;

/**
 * Testes sobre aos exemplos de manipulação de Strings.
 * 
 * @author cvinicius
 * @since 20/01/2017
 * @version 1.0
 */
public class ManipulacaoStringTest{

	private ManipulacaoString manipulacaoStrings;
	
	@Before
	public void prepare(){
		this.manipulacaoStrings = new ManipulacaoString(Arrays.asList("Caio", "Fernanda", "Carlos", "Gabriela"));
	}
	
	@Test
	public void getTotalStringsTest(){
		
		Assert.assertSame(4L, this.manipulacaoStrings.getTotalStrings());
	}
	
	@Test
	public void getTotalStringsComFilterTest(){
		
		Assert.assertSame(2L, this.manipulacaoStrings.getTotalStringsComFilter('C'));
	}
	
	@Test
	public void getTotalStringsDistinctTest(){
		
		Assert.assertSame(4L, this.manipulacaoStrings.getTotalStringsDistinct());
	}
	
	
	@Test
	public void getJoinStrPorUnderlineUpperTest(){
		
		Assert.assertEquals("CAIO_FERNANDA_CARLOS_GABRIELA", this.manipulacaoStrings.getJoinStrPorUnderline());
	}
	
	@Test
	public void getPrimeiraPalavraPorCharTest(){
		
		Assert.assertEquals("Fernanda", this.manipulacaoStrings.getPrimeiraPalavraPorChar('N'));
	}
	
	@Test
	public void transformaListEmSetTest(){
		
		Assert.assertSame(4, this.manipulacaoStrings.transformaListEmSet().size());
	}
	
	@Test
	public void transformaListEmSetComReduceTest(){
		
		Assert.assertSame(4, this.manipulacaoStrings.transformaListEmSetComReduce().size());
	}
	
	@Test
	public void getMapStrComTotalCharsTest(){
		
		Map<String, Integer> map = this.manipulacaoStrings.getMapStrComTotalChars();
		
		Assert.assertSame(4, map.keySet().size());
	}
	
	@Test
	public void criaStrDeListTest(){
		
		String frase = this.manipulacaoStrings.criaStrList();
		
		System.out.println(frase);
	}
}