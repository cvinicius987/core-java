package br.com.cvinicius.projetos.concessonaria;

public class Marca {

	private String nome;
	private String pais;
		
	public Marca(String nome, String pais){
		this.nome = nome;
		this.pais = pais;
	}

	public String getNome() {
		return nome;
	}

	public String getPais() {
		return pais;
	}

	@Override
	public String toString() {
		return "{nome: "+this.nome+", pais: "+this.pais+"}";
	}		
}