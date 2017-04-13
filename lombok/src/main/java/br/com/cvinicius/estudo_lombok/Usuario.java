package br.com.cvinicius.estudo_lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario{

	private String nome;
	private String cpf;
	private String rg;
}