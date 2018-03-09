package br.com.cvinicius.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Csv {
	
	public static void main(String[] args) 
	throws IOException {
		
		/*
		 * Leitura do arquivo
		 */
		System.out.println("============ Leitura do arquivo: \n");
		
		Files.lines(Paths.get("file.csv"))
			 .forEach(System.out::println);
		
		System.out.println("\n============ Leitura do arquivo sem cabecalho: \n");
		
		/*
		 * Leitura do arquivo sem cabecalho
		 */
		Files.lines(Paths.get("file.csv"))
			 .skip(1)
			 .forEach(System.out::println);
		
		/*
		 * Conversão em um objeto do Tipo User
		 */
		System.out.println("\n============ Conversão em um objeto do Tipo User: \n");
		
		Files.lines(Paths.get("file.csv"))
		 	 .skip(1)
		 	 .map(line -> line.split(";"))
		 	 .map(str -> new User(str[0], str[1], Integer.parseInt(str[2]), str[3], str[4]))
		 	 .forEach(System.out::println);
		
		/*
		 * Exibindo somente usuários com maiores de 30 anos
		 */
		System.out.println("\n============ Exibindo somente usuários com maiores de 30 anos: \n");
		
		Files.lines(Paths.get("file.csv"))
				.skip(1)
				.map(list -> list.split(";"))
				.map(str -> new User(str[0], str[1], Integer.parseInt(str[2]), str[3], str[4]))
				.filter(usr -> usr.getAge() > 30)
				.forEach(System.out::println);
	}
}