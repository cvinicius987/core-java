package br.com.improving.carrinho;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Operações de Testes sobre o CarrinhoFactory.
 * 
 * @author Caio
 * @since 22/01/2017
 * @version 1.0
 */
public class CarrinhoFactoryTest {

	private CarrinhoComprasFactory factory;
	
	@Before
	public void prepare(){
		this.factory = new CarrinhoComprasFactory();
	}
	
	/**
	 * Testa o processamento de criar 2 carrinhos para o mesmo Cliente.
	 */
	@Test
	public void criarCarrinhoIgualTest(){
		
		String cliente = "0123456789";
		
		CarrinhoCompras carrinho  = this.factory.criar(cliente);
		CarrinhoCompras carrinho2 = this.factory.criar(cliente);
		
		Assert.assertSame(1L, this.factory.totalDeCarrinhos());
		Assert.assertEquals(carrinho, carrinho2);
	}
	
	/**
	 * Testa a criação de Carrinhos para clientes diferentes
	 */
	@Test
	public void criarCarrinhoParaClienteDiferenteTest(){
		
		CarrinhoCompras carrinho  = this.factory.criar("0123456789");
		CarrinhoCompras carrinho2 = this.factory.criar("1010101010");
		
		Assert.assertSame(2L, this.factory.totalDeCarrinhos());
		
		Assert.assertNotEquals(carrinho, carrinho2);
	}
	
	/**
	 * Testa o valor medio dos itens dos carrinhos
	 */
	@Test
	public void getValorTicketMedioTest(){
		
		/*
		 * Valor esperado no resultado = //3014,016 (Soma dos 3 carrinhos)
		 */
		BigDecimal valorEsperado = BigDecimal.valueOf(3014.02); 
		
		//1
		CarrinhoCompras carrinho  = this.factory.criar("0123456789");
		carrinho.adicionarItem(new Produto(10L, "TV 32 Polegadas"), new BigDecimal(1000.00), 1);
		
		//2
		CarrinhoCompras carrinho2  = this.factory.criar("1010101010");
		carrinho2.adicionarItem(new Produto(10L, "TV 32 Polegadas"), new BigDecimal(3520.20), 1);
		
		//3
		CarrinhoCompras carrinho3  = this.factory.criar("9874563210");
		carrinho3.adicionarItem(new Produto(10L, "TV 32 Polegadas"), new BigDecimal(4521.85), 1);
		
		Assert.assertEquals(valorEsperado, this.factory.getValorTicketMedio());
	}
	
	/**
	 * Testa a operação de invalidar os carrinhos de um determinado Cliente
	 */
	@Test
	public void invalidarCarrinhoTest(){
		
		this.factory.criar("0123456789");
		this.factory.criar("1010101010");
		
		Assert.assertSame(2L, this.factory.totalDeCarrinhos());
		
		Assert.assertTrue(this.factory.invalidar("1010101010"));
		
		Assert.assertFalse(this.factory.invalidar("1010101010"));
		
		Assert.assertSame(1L, this.factory.totalDeCarrinhos());
	}
}