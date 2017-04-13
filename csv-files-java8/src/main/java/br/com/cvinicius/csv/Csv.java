package br.com.cvinicius.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Csv {
	
	private final String columns = "{Name: %s, Cpf: %s, Age: %s, Phone: %s, Address: %s}";
	
	/***
	 * Leitura das colunas do arquivo.
	 * 
	 * @return List<String[]>
	 * @throws IOException
	 */
	public List<String> getColumns() throws IOException{
		
		return Files.lines(Paths.get("file.csv"))
					.map(list -> list.split(";"))
					.map(str -> String.format(columns, str[0], str[1], str[2], str[3], str[4]))
					.collect(Collectors.toList());
	}
	
	/***
	 * Leitura das colunas do arquivo, desprezando a linha do titulo.
	 * 
	 * @return List<String[]>
	 * @throws IOException
	 */
	public List<String> getColumnsWithoutFirstLine() throws IOException{
		
		return Files.lines(Paths.get("file.csv"))
					.skip(1)
					.map(list -> list.split(";"))
					.map(str -> String.format(columns, str[0], str[1], str[2], str[3], str[4]))
					.collect(Collectors.toList());
	}
	
	/***
	 * Leitura das colunas do arquivo, e transformando para objeto.
	 * 
	 * @return List<Usuario>
	 * @throws IOException
	 */
	public List<User> getColumnsToObj() throws IOException{
		
		return Files.lines(Paths.get("file.csv"))
					.skip(1)
					.map(list -> list.split(";"))
					.map(str -> new User(str[0], str[1], Integer.parseInt(str[2]), str[3], str[4]))
					.collect(Collectors.toList());
	}
	
	/***
	 * Leitura das colunas do arquivo, e transformando para objeto.
	 * 
	 * @return List<Usuario>
	 * @throws IOException
	 */
	public List<User> getUserAgeBigger30() throws IOException{
		
		return Files.lines(Paths.get("file.csv"))
					.skip(1)
					.map(list -> list.split(";"))
					.map(str -> new User(str[0], str[1], Integer.parseInt(str[2]), str[3], str[4]))
					.filter(usr -> usr.getAge() > 30)
					.collect(Collectors.toList());
	}
}