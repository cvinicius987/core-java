package br.com.improving.carrinho;

import org.junit.Assert;
import org.junit.Test;

public class ProdutoTest {
	
	@Test
	public void produtoEqualsTest(){
		
		Produto p1 = new Produto(1L, "TV");
		Produto p2 = new Produto(1L, "TV 26");
		
		Assert.assertEquals(p1, p2);
	}
	
	@Test
	public void produtoNotEqualsTest(){
		
		Produto p1 = new Produto(1L, "TV");
		Produto p2 = new Produto(2L, "Geladeira");
		
		Assert.assertNotEquals(p1, p2);
	}
}