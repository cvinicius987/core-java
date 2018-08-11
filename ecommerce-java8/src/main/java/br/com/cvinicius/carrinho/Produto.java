package br.com.improving.carrinho;

import java.util.Objects;

/**
 * Classe que representa um produto que pode ser adicionado
 * como item ao carrinho de compras.
 *
 * Importante: Dois produtos são considerados iguais quando ambos possuem o
 * mesmo código.
 */
public class Produto {

    private Long codigo;
    private String descricao;

    /**
     * Construtor da classe Produto.
     *
     * @param codigo
     * @param descricao
     */
    public Produto(Long codigo, String descricao) {
    	Objects.requireNonNull(codigo, () -> "Codigo obrigatorio");
    	Objects.requireNonNull(descricao, () -> "Descriçao do produto é obrigatoria.");
    	
    	this.codigo 	= codigo;
    	this.descricao 	= descricao;
    }

    /**
     * Retorna o código da produto.
     *
     * @return Long
     */
    public Long getCodigo() {
    	return codigo;
    }

    /**
     * Retorna a descrição do produto.
     *
     * @return String
     */
    public String getDescricao() {
    	return descricao;
    }

	@Override
	public int hashCode() {
		
		final int prime = 31;
		
		return prime * ((codigo == null) ? 0 : codigo.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
				
		if(this != null && obj != null && obj instanceof Produto){
			
			 final Produto other = (Produto) obj;
			 
			if(this.codigo != null && other.codigo != null){
				return this.codigo.equals(other.codigo);
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
		return "{codigo: " + codigo + ", descricao: " + descricao + "}";
	} 
}