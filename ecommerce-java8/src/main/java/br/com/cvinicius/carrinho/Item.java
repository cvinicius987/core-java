package br.com.cvinicius.carrinho;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;
    
    /**
     * Construtor da classe Item.
     * 
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
    	
    	Objects.requireNonNull(produto,() -> "Produto invalido.");
    	Objects.requireNonNull(valorUnitario, () -> "Valor unitario invalido.");
    	
    	this.produto 		= produto;
    	this.valorUnitario 	= valorUnitario;
    	
    	//Impede de contem itens com quantidade menor que 1
    	this.quantidade = Optional.of(Integer.valueOf(quantidade)).map(i -> i <= 0 ? 1 : i).orElse(1);
    }
    
    /**
     * Retorna o produto.
     *
     * @return Produto
     */
    public Produto getProduto() {
    	return produto;
    }

	/**
     * Retorna o valor unitário do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorUnitario() {
    	return valorUnitario;
    }

	/**
     * Retorna a quantidade dos item.
     *
     * @return int
     */
    public int getQuantidade() {
    	return quantidade;
    }

    /**
     * Retorna o valor total do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
    	return this.valorUnitario.multiply(new BigDecimal(this.quantidade));
    }
	
    /**
     * Realiza a logica de troca de valor unitario,
     * e aumento da quantidade de itens
     * 
     * @param valorUnitario - Novo valor unitario
     * @param quantidade 	- Quantidade a ser somada a quantidade atual
     */
    public Item alterarProdutoAtual(BigDecimal valorUnitario, int quantidade) {
		
		if(valorUnitario != this.getValorUnitario()){
			this.valorUnitario = valorUnitario;
		}
		
		this.quantidade += quantidade;
		
		return this;
    }
    
    /**
     * Verifica se o Item possui o produto
     * 
     * @param produto - Produto que sera analisado
     * @return boolean
     */
    public boolean temProduto(Produto produto){
    	return this.getProduto().equals(produto);
    }
    
    @Override
	public int hashCode() {
    	return produto.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
				
		if(this != null && obj != null && obj instanceof Item){
			
			 final Item other = (Item) obj;
			 
			if(this.produto != null && other.produto != null){
				return this.produto.equals(other.produto);
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}   
	
	@Override
	public String toString() {
		return "{produto:{ " + produto + "}, valorUnitario: " + valorUnitario + ", quantidade: "+quantidade+"}";
	} 
}