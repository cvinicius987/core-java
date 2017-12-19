package br.com.cvinicius.api.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Manipulação da API JavaTime - Dates
 * 
 * @author cvinicius
 * @since 15/11/2016
 * @version 1.0
 */
public class ManipulacaoDatas {

	/**
	 * Operação de subtracao de dias.
	 * 
	 * @param format
	 * @param days
	 * @return String
	 */
	public String subtrairDias(String format, int days){
		
		return LocalDate.now()
						.minusDays(days)
						.format(DateTimeFormatter.ofPattern(format));
	}
	
	/**
	 * Retorna todos os meses como uma Collection.
	 * 
	 * @return List<Month>
	 */
	public List<Month> listMeses(){
		
		return Stream.of(Month.values())
						.collect(Collectors.toList());
	}
	
	/**
	 * Retorna todos os meses terminados em 31.
	 * 
	 * @return Long
	 */
	public Long getMesesComFinal31(){
		
		return Stream.of(Month.values())
						.filter(m -> m.maxLength() == 31)
						.count();
	}
}