package br.com.cvinicius.estudo_lombok;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Cliente {
	private String nome;
	private String cnpj;
	private String endereco;
}