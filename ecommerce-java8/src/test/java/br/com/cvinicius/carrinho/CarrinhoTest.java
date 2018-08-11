package br.com.improving.carrinho;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Casos de testes sobre o Carrinho de Compras.
 * 
 * @author Caio
 * @since 22/01/2017
 * @version 1.0
 */
public class CarrinhoTest {

	private CarrinhoComprasFactory factory = new CarrinhoComprasFactory();
	
	@Before
	public void prepare(){
		this.factory = new CarrinhoComprasFactory();
	}
		
	/**
	 * Adiciona items ao carrinho de compras
	 */
	@Test
	public void adicionarItensTest(){
		
		CarrinhoCompras carrinho = this.factory.criar("0123456789");

		carrinho.adicionarItem(new Produto(10L, "TV 32 Polegadas"), BigDecimal.valueOf(1000.00), 1);
		carrinho.adicionarItem(new Produto(11L, "Impressora"), BigDecimal.valueOf(300.00), 1);
		carrinho.adicionarItem(new Produto(12L, "Mesa"), BigDecimal.valueOf(500.00), 1);
		
		Assert.assertSame(3, carrinho.getItens().size());
	}
	
	/**
	 * Adiciona items ao carrinho de compras
	 */
	@Test
	public void adicionarItensComValoresDiferentesTest(){
		
		CarrinhoCompras carrinho = this.factory.criar("0123456789");
		
		carrinho.adicionarItem(new Produto(10L, "TV 32 Polegadas"), BigDecimal.valueOf(1000.00), 1);
		carrinho.adicionarItem(new Produto(10L, "TV 32 Polegadas"), BigDecimal.valueOf(2000.00), 1);
		carrinho.adicionarItem(new Produto(11L, "Impressora"), BigDecimal.valueOf(300.00), 1);
		carrinho.adicionarItem(new Produto(12L, "Mesa"), BigDecimal.valueOf(500.00), 1);
		carrinho.adicionarItem(new Produto(13L, "Notebook"), BigDecimal.valueOf(2000.00), 1);
		carrinho.adicionarItem(new Produto(13L, "Notebook"), BigDecimal.valueOf(2000.00), 3);
		
		Assert.assertSame(4, carrinho.getItens().size());
	}
	
	/**
	 * Adicionar um Item sem Produto.
	 */
	@Test(expected = RuntimeException.class)
	public void adicionarSemProdutoTest() {
		
		CarrinhoCompras carrinho = this.factory.criar("0123456789");
		
		carrinho.adicionarItem(null, BigDecimal.valueOf(1000.00), 1);
	}
	
	/**
	 * Adiciona items repetidos no carrinho de compras
	 */
	@Test
	public void adicionarItensRepetidosTest(){
		
		CarrinhoCompras carrinho = this.factory.criar("0123456789");
		
		//Produto 1
		Produto produto  = new Produto(10L, "TV 32 Polegadas");

		carrinho.adicionarItem(produto, BigDecimal.valueOf(1000.00), 1);
		carrinho.adicionarItem(produto, BigDecimal.valueOf(2000.00), 2);
		carrinho.adicionarItem(produto, BigDecimal.valueOf(2000.00), 3);
		carrinho.adicionarItem(produto, BigDecimal.valueOf(2000.00), 4);
		carrinho.adicionarItem(produto, BigDecimal.valueOf(2000.00), 5);
		carrinho.adicionarItem(produto, BigDecimal.valueOf(2000.00), 6);
		
		Assert.assertSame(1, carrinho.getItens().size());
			
		//Produto 2
		Produto produto2 = new Produto(12L, "Geladeira");
				
		carrinho.adicionarItem(produto2, BigDecimal.valueOf(3000.00), 1);
		carrinho.adicionarItem(produto2, BigDecimal.valueOf(4000.10), 2);
		
		Assert.assertSame(2, carrinho.getItens().size());
	}
	
	/**
	 * Realiza a remoção de itens por produto
	 */
	@Test
	public void removerItemCarrinhoPorProdutoTest(){
		
		CarrinhoCompras carrinho = this.factory.criar("0123456789");
		
		Produto produto = new Produto(10L, "TV 32 Polegadas");

		carrinho.adicionarItem(produto, BigDecimal.valueOf(1000.00), 1);
	
		Assert.assertSame(1, carrinho.getItens().size());
		Assert.assertTrue(carrinho.removerItem(produto));
		Assert.assertFalse(carrinho.removerItem(new Produto(12L, "Aparelho de DVD")));
	}
	
	/**
	 * Realiza a remoção de itens do carrinho por indice.
	 */
	@Test
	public void removerItemCarrinhoPorIndiceTest(){

		CarrinhoCompras carrinho = this.factory.criar("0123456789");
		
		carrinho.adicionarItem(new Produto(10L, "TV 32 Polegadas"), BigDecimal.valueOf(1000.00), 1);
		carrinho.adicionarItem(new Produto(11L, "TV 42 Polegadas"), BigDecimal.valueOf(2000.00), 1);
		carrinho.adicionarItem(new Produto(12L, "TV 50 Polegadas"), BigDecimal.valueOf(3000.00), 1);
		carrinho.adicionarItem(new Produto(13L, "TV 60 Polegadas"), BigDecimal.valueOf(4000.00), 1);
		
		Assert.assertTrue(carrinho.removerItem(2));
		Assert.assertFalse(carrinho.removerItem(10));
	}
	
	/**
	 * Soma o valor total dos itens de um carrinho
	 */
	@Test
	public void getValorTotalTest(){
		
		BigDecimal result = BigDecimal.valueOf(7553.22);
		
		CarrinhoCompras carrinho = this.factory.criar("0123456789");
		
		carrinho.adicionarItem(new Produto(10L, "TV 32 Polegadas"), BigDecimal.valueOf(1000.00), 1);
		carrinho.adicionarItem(new Produto(11L, "TV 42 Polegadas"), BigDecimal.valueOf(2150.54), 1);
		carrinho.adicionarItem(new Produto(12L, "TV 50 Polegadas"), BigDecimal.valueOf(3144.32), 1);
		carrinho.adicionarItem(new Produto(13L, "TV 60 Polegadas"), BigDecimal.valueOf(1258.36), 1);
		
		Assert.assertEquals(result, carrinho.getValorTotal());
	}
	
	/**
	 * Soma o valor total dos itens de um carrinho
	 * contendo quantidade maiores que 1
	 */
	@Test
	public void getValorTotalComQuantidadeTest(){
		
		BigDecimal result = BigDecimal.valueOf(39000.00);
		
		CarrinhoCompras carrinho = this.factory.criar("0123456789");
		
		carrinho.adicionarItem(new Produto(10L, "TV 32 Polegadas"), BigDecimal.valueOf(1000.00), 2);
		carrinho.adicionarItem(new Produto(11L, "TV 42 Polegadas"), BigDecimal.valueOf(2000.00), 4);
		carrinho.adicionarItem(new Produto(12L, "TV 50 Polegadas"), BigDecimal.valueOf(3000.00), 3);
		carrinho.adicionarItem(new Produto(13L, "TV 60 Polegadas"), BigDecimal.valueOf(4000.00), 5);
		
		Assert.assertEquals(result, carrinho.getValorTotal());
	}
	
	@Test
	public void getItensTest(){
		
		CarrinhoCompras carrinho = this.factory.criar("0123456789");
		
		carrinho.adicionarItem(new Produto(10L, "TV 32 Polegadas"), BigDecimal.valueOf(1000.00), 1);
		carrinho.adicionarItem(new Produto(11L, "TV 42 Polegadas"), BigDecimal.valueOf(2000.00), 1);
		carrinho.adicionarItem(new Produto(12L, "TV 50 Polegadas"), BigDecimal.valueOf(3000.00), 1);
		carrinho.adicionarItem(new Produto(13L, "TV 60 Polegadas"), BigDecimal.valueOf(4000.00), 1);
		
		Assert.assertSame(4, carrinho.getItens().size());
	}
}