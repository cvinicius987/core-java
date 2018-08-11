package br.com.cvinicius.carrinho;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class ItemTest {
	
	@Test
	public void valorTotalComUmItemTest(){
		
		Produto p1 = new Produto(1L, "TV");
		
		Item item = new Item(p1, new BigDecimal(1520.00), 1);
		
		Assert.assertEquals(new BigDecimal(1520.00), item.getValorTotal());
	}
	
	@Test
	public void valorTotalDosItemsTest(){
		
		Produto p1 = new Produto(1L, "TV");
		
		Item item = new Item(p1, new BigDecimal(1520.00), 2);
		
		Assert.assertEquals(new BigDecimal(3040.00), item.getValorTotal());
	}
	
	@Test
	public void itemEqualsTest(){
		
		Item item  = new Item(new Produto(1L, "TV"), new BigDecimal(1520.00), 2);
		Item item2 = new Item(new Produto(1L, "TV"), new BigDecimal(1520.00), 2);
		
		Assert.assertEquals(item, item2);
	}
	
	@Test
	public void itemNotEqualsTest(){
		
		Item item  = new Item(new Produto(1L, "TV"), new BigDecimal(1520.00), 2);
		Item item2 = new Item(new Produto(2L, "Geladeira"), new BigDecimal(1520.00), 2);
		
		Assert.assertNotEquals(item, item2);
	}
}