package br.com.cvinicius.carrinho;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Classe responsável pela criação e recuperação dos carrinhos de compras.
 */
public class CarrinhoComprasFactory {

	private List<CarrinhoCompras> carrinhos = new ArrayList<>();
	
	private Function<String, CarrinhoCompras> factoryrCarrinhos = CarrinhoCompras::new;
	
    /**
     * Cria e retorna um novo carrinho de compras para o cliente passado como parâmetro.
     *
     * Caso já exista um carrinho de compras para o cliente passado como parâmetro, este carrinho deverá ser retornado.
     *
     * @param identificacaoCliente
     * @return CarrinhoCompras
     */
    public CarrinhoCompras criar(String identificacaoCliente) {
    	 
    	return this.carrinhos.stream()
			    			   .filter(carrinho -> carrinho.temCarrinho(identificacaoCliente))
			    			   .findAny()
			    			   .orElseGet(() -> {
			    				   CarrinhoCompras c = this.factoryrCarrinhos.apply(identificacaoCliente);
			    						   
			    				   this.carrinhos.add(c);
			    				   
			    				   return c;
			    			   });
    }

    /**
     * Retorna o valor do ticket médio no momento da chamada ao método.
     * O valor do ticket médio é a soma do valor total de todos os carrinhos de compra dividido
     * pela quantidade de carrinhos de compra.
     * O valor retornado deverá ser arredondado com duas casas decimais, seguindo a regra:
     * 0-4 deve ser arredondado para baixo e 5-9 deve ser arredondado para cima.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTicketMedio() {
		
    	double result = this.carrinhos.stream()
										.map(CarrinhoCompras::getValorTotal)
										.mapToDouble(BigDecimal::doubleValue)
										.average()
										.orElse(0.00);
    	
		return BigDecimal.valueOf(result).setScale(2, RoundingMode.HALF_EVEN);
    }

    /**
     * Invalida um carrinho de compras quando o cliente faz um checkout ou sua sessão expirar.
     * Deve ser efetuada a remoção do carrinho do cliente passado como parâmetro da listagem de carrinhos de compras.
     *
     * @param identificacaoCliente
     * @return Retorna um boolean, tendo o valor true caso o cliente passado como parämetro tenha um carrinho de compras e
     * e false caso o cliente não possua um carrinho.
     */
    public boolean invalidar(String identificacaoCliente) {
    	
    	return this.carrinhos.removeIf(carrinho -> carrinho.temCarrinho(identificacaoCliente));
    }
    
    /**
     * Retorna o total de carrinhos por Factory
     * 
     * Usado para validar os testes.
     * 
     * @return Long
     */
    public Long totalDeCarrinhos(){
    	return this.carrinhos.stream().count();
    }
}