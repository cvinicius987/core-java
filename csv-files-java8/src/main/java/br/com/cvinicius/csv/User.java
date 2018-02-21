package br.com.cvinicius.csv;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class User {
	
	private String name, cpf;
	private Integer age;
	private String phone, address;
}