package br.com.cvinicius.carrinho;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {
	
	/**
	 * Identificação do Cliente
	 */
	private String identificacaoCliente;
	
	/**
	 * Collection contendo os itens de um determinado carrinho de compras.
	 */
	private List<Item> itens;
	
	/**
	 * Criação de objetos Item
	 */
	private TriArgumentsConstrutor<Produto, BigDecimal, Integer, Item> factoryItens = Item::new;
	
	/**
	 * Criação de um carrinho de Compras a partir da identificação do cliente
	 * 
	 * @param identificacaoCliente
	 */
	public CarrinhoCompras(String identificacaoCliente){
		Objects.requireNonNull(identificacaoCliente, () -> "Identificação do Cliente inválida.");
		
		this.identificacaoCliente 	= identificacaoCliente;
		this.itens 					= new ArrayList<>();
	}
	
    /**
     * Permite a adição de um novo item no carrinho de compras.
     *
     * Caso o item já exista no carrinho para este mesmo produto, as seguintes regras deverão ser seguidas:
     * - A quantidade do item deverá ser a soma da quantidade atual com a quantidade passada como parâmetro.
     * - Se o valor unitário informado for diferente do valor unitário atual do item, o novo valor unitário do item deverá ser
     * o passado como parâmetro.
     *
     * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao carrinho de compras.
     *
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade){
    	
    	Objects.requireNonNull(produto, () -> "Produto invalido.");
    	Objects.requireNonNull(valorUnitario, () -> "Valor unitario invalido.");
    	
    	this.itens.stream()
					.filter(item -> item.temProduto(produto))
					.findFirst()
					.orElseGet(() -> {	
						Item item = this.factoryItens.apply(produto, valorUnitario, quantidade);
						
						this.itens.add(item);
						    					
						return item; 
					});
    }

    /**
     * Permite a remoção do item que representa este produto do carrinho de compras.
     *
     * @param produto
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removerItem(Produto produto) {
    	return this.itens.removeIf(item -> item.temProduto(produto));
    }

    /**
     * Permite a remoção do item de acordo com a posição.
     * Essa posição deve ser determinada pela ordem de inclusão do produto na 
     * coleção, em que zero representa o primeiro item.
     *
     * @param posicaoItem
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removerItem(int posicaoItem) {
    	
    	return IntStream.range(0, this.itens.size())
							.filter(indice -> indice == posicaoItem)
							.mapToObj(indice -> this.itens.get(indice).getProduto())
							.anyMatch(item -> this.removerItem(item));
 
    }

    /**
     * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais
     * de todos os itens que compõem o carrinho.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal(){
    	    	
    	return BigDecimal.valueOf(this.itens.stream()
							 			 	.mapToDouble(item -> item.getValorTotal().doubleValue())
							 			 	.sum());
    }

    /**
     * Retorna a lista de itens do carrinho de compras.
     *
     * @return itens
     */
    public Collection<Item> getItens() {
    	return this.itens;
    }
    
    /**
     * Retorna a identificação do Cliente.
     * 
     * @return String
     */
    public String getIdentificacaoCliente(){
    	return identificacaoCliente;
    }
    
    /**
     * Verifica se o cliente possui um carrinho
     * 
     * @param identificacaoCliente - Identeificação do Cliente
     * @return boolean
     */
    public boolean temCarrinho(String identificacaoCliente){
    	return this.getIdentificacaoCliente().equals(identificacaoCliente);
    }
    
    @Override
	public int hashCode() {
		
		final int prime = 31;
		
		return prime * ((this.identificacaoCliente == null) ? 0 : this.identificacaoCliente.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
				
		if(this != null && obj != null && obj instanceof CarrinhoCompras){
			
			final CarrinhoCompras other = (CarrinhoCompras) obj;
			 
			if(this.identificacaoCliente != null && other.identificacaoCliente != null){
				return this.identificacaoCliente.equals(other.identificacaoCliente);
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}   
}