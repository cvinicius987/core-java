package br.com.cvinicius.api.date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.cvinicius.api.date.ManipulacaoDatas;

public class ManipulacaoDatasTest {

	private ManipulacaoDatas dates;
	
	@Before
	public void prepare(){
		this.dates = new ManipulacaoDatas();
	}
	
	@Test
	public void subtrairDiasTest(){
		
		String date = this.dates.subtrairDias("dd/MM/yyyy", 2);
		
		System.out.println(date);
	}
	
	@Test
	public void listMesesTest(){
		
		int total = 12;
		
		Assert.assertEquals(total, this.dates.listMeses().size());
	}
	
	@Test
	public void getMesesComFinal31Test(){
		
		Long total = 7L;
		
		Assert.assertSame(total, this.dates.getMesesComFinal31());
	}
}