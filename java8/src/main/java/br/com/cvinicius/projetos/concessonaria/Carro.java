package br.com.cvinicius.projetos.concessonaria;

import java.math.BigDecimal;
import java.time.Year;

public class Carro{

	private String nome;
	private Year ano;
	private BigDecimal valor;
	private Marca marca;
	
	public Carro(String nome, Year ano, BigDecimal valor, Marca marca){
		this.nome  = nome;
		this.ano   = ano;
		this.valor = valor;
		this.marca = marca;
	}
	
	public String getNome(){
		return nome;
	}
	
	public Year getAno(){
		return ano;
	}

	public BigDecimal getValor(){
		return valor;
	}
	
	public Marca getMarca(){
		return marca;
	}
	
	@Override
	public String toString() {
		return "{nome: "+this.nome+", ano: "+this.ano+", valor: "+this.valor+"}";
	}	
}