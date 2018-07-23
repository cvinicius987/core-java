package br.com.cvinicius.examples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MainTime {

	public static void main(String[] args) {
		
		//Criação de um objeto LocalDateTime, LocalDate, LocalTime
		LocalDate localDate 		= LocalDate.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		LocalTime localTime 		= LocalTime.now();
		
		System.out.println(localDate);
		System.out.println(localDateTime);
		System.out.println(localTime);
		
		//Criação de um objeto LocalDateTime
		//Realizando a formatação para dd/MM/yyyy HH:mm:ss
		LocalDateTime localDateTime2 = LocalDateTime.now();
		
		System.out.println(localDateTime2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		
		//Criação de um objeto LocalDateTime
		//Adicionando um dia na data
		LocalDateTime localDateTime3 = LocalDateTime.now().plusDays(1);

		System.out.println(localDateTime3.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		
		//Criação de um objeto Calendar
		//Adicionando um dia na data
		//Subtraindo 4 horas
		LocalDateTime localDateTime4 = LocalDateTime.now().plusDays(1).minusHours(4);
		
		System.out.println(localDateTime4.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
				
		//Criação de um objeto Calendar com data/hora especifica
		LocalDateTime localDateTime5 =  LocalDateTime.of(2018, 07, 22, 10, 00, 00);
		
		System.out.println(localDateTime5.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
	}
}