package br.com.cvinicius.examples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ManipulacaoJavaTime {

	public static void main(String[] args) {
		
		//Criação de um objetos
		LocalDate localDate 		= LocalDate.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		LocalTime localTime 		= LocalTime.now();
		
		System.out.println(localDate);
		System.out.println(localDateTime);
		System.out.println(localTime+"\n");
		
		//Formatação
		String strLocalDate2 	 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String strLocalDateTime2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		String strLocalTime2 	 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		
		System.out.println(strLocalDate2);
		System.out.println(strLocalDateTime2);
		System.out.println(strLocalTime2+"\n");
		
		//Adicionando periodos
		LocalDate localDate3 		 = LocalDate.now().plusDays(1).plusMonths(1);
		LocalDateTime localDateTime3 = LocalDateTime.now().plusDays(1).plusMonths(1).plusHours(2);
		LocalTime localTime3 		 = LocalTime.now().plusHours(1);

		System.out.println(localDate3);
		System.out.println(localDateTime3);
		System.out.println(localTime3+"\n");
		
		//Subtraindo periodos
		LocalDate localDate4 		 = LocalDate.now().minusDays(1).plusMonths(1);
		LocalDateTime localDateTime4 = LocalDateTime.now().minusDays(1).minusMonths(1).minusHours(2);
		LocalTime localTime4 		 = LocalTime.now().minusHours(1);

		System.out.println(localDate4);
		System.out.println(localDateTime4);
		System.out.println(localTime4+"\n");
		
		//Criando objetos especificos
		LocalDate localDate5 		 = LocalDate.of(2018, 07, 22);
		LocalDateTime localDateTime5 = LocalDateTime.of(2018, 07, 22, 10, 15, 30);
		LocalTime localTime5 		 = LocalTime.of(10, 35, 12);

		System.out.println(localDate5);
		System.out.println(localDateTime5);
		System.out.println(localTime5+"\n");
		
		//Realizando parse
		LocalDate localDate6 		 = LocalDate.parse("2018-07-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDateTime localDateTime6 = LocalDateTime.parse("2018-07-22 10:35:10", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		LocalTime localTime6 		 = LocalTime.parse("11:40:02", DateTimeFormatter.ofPattern("HH:mm:ss"));
		
		System.out.println(localDate6);
		System.out.println(localDateTime6);
		System.out.println(localTime6+"\n");
		
		//Recuperando partes do Objeto Data
		int year    = LocalDate.now().getYear();
		Month month = LocalDateTime.now().getMonth();
		int hour    = LocalTime.now().getHour();
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(hour+"\n");
		
		//Comparando periodos
		LocalDate localDate8 = LocalDate.now();
		LocalDate localDate9 = LocalDate.now().minusDays(1);
		
		boolean isAfter  = localDate8.isAfter(localDate9);   //true
		boolean isBefore = localDate8.isBefore(localDate9); //false
		boolean isEqual  = localDate8.isEqual(localDate9); //false
		
		System.out.println(isAfter);
		System.out.println(isBefore);
		System.out.println(isEqual+"\n");
		
		//Usando a classe Period
		LocalDate localDate10 = LocalDate.now();
		LocalDate localDate11 = LocalDate.now().plusDays(2);
		
		Period period1 = Period.between(localDate10, localDate11);
		
		System.out.println(period1.get(ChronoUnit.DAYS)+"\n");
	
		//Usando a enum ChronoUnit
		LocalDateTime localDateTime12 = LocalDateTime.now();
		LocalDateTime localDateTime13 = LocalDateTime.now().plusDays(2);
		
		long periodAsMinutes = ChronoUnit.MINUTES.between(localDateTime12, localDateTime13);
		long periodAsHours 	 = ChronoUnit.HOURS.between(localDateTime12, localDateTime13);
		long periodAsDays 	 = ChronoUnit.DAYS.between(localDateTime12, localDateTime13);
		
		System.out.println(periodAsMinutes+" Minutos");
		System.out.println(periodAsHours+" Horas");
		System.out.println(periodAsDays+" Dias");
	}
}