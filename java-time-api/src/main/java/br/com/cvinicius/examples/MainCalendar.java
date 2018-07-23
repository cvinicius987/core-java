package br.com.cvinicius.examples;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainCalendar {

	public static void main(String[] args) {
		
		//Criação de um objeto Calendar
		Calendar calendar = Calendar.getInstance();
		
		System.out.println(calendar.getTime());
		
		//Criação de um objeto Calendar
		//Realizando a formatação para dd/MM/yyyy HH:mm:ss
		Calendar calendar2 = Calendar.getInstance();
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println(format.format(calendar2.getTime()));
		
		//Criação de um objeto Calendar
		//Adicionando um dia na data
		Calendar calendar3 = Calendar.getInstance();
		
		calendar3.add(Calendar.DAY_OF_MONTH, 1);
		
		System.out.println(format.format(calendar3.getTime()));
		
		//Criação de um objeto Calendar
		//Adicionando um dia na data
		//Subtraindo 4 horas
		Calendar calendar4 = Calendar.getInstance();
		
		calendar4.add(Calendar.DAY_OF_MONTH, 1);
		calendar4.add(Calendar.HOUR_OF_DAY, -4);
		
		System.out.println(format.format(calendar4.getTime()));
		
		//Criação de um objeto Calendar com data/hora especifica
		Calendar calendar5 = Calendar.getInstance();
		
		calendar5.set(2018, 07, 22, 10, 00, 00);
		
		System.out.println(format.format(calendar5.getTime()));
	}
}