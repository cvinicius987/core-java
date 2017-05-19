package br.com.cvinicius.estudo_lombok;

public class CriacaoCliente {

	public static void main(String[] args){
	
		Cliente cliente = Cliente.builder()
								.nome("Titulo Cliente")
								.cnpj("1234567890")
								.endereco("Endereço Cliente")
								.build();
		
		System.out.println(cliente);
	}
}