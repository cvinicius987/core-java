package br.com.cvinicius.api.date;

import java.time.Duration;
import java.time.LocalTime;

/**
 * Manipulação da API JavaTime - Times
 * 
 * @author cvinicius
 * @since 15/11/2016
 * @version 1.0
 */
public class ManipulacaoTime {

	/**
	 * Somar a quantidade de horas entre 2 LocalTime.
	 * 
	 * @param time
	 * @param timeTwo
	 * @return Long
	 */
	public Long getTotalHoras(LocalTime time, LocalTime timeTwo){
		
		return Duration.between(time, timeTwo).toHours();
	}
	
	/**
	 * Realiza o parse de um String para LocalTime
	 * 
	 * @param strTime
	 * @return LocalTime
	 */
	public LocalTime parseHoras(String strTime){
		
		return LocalTime.parse(strTime);
	}
}