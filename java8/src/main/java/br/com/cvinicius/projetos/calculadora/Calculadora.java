package br.com.cvinicius.projetos.calculadora;

import java.math.BigDecimal;
import java.util.function.BiFunction;

/**
 * Calculadora Funcional Java
 * 
 * @author cvinicius
 *
 */
public class Calculadora {

	public final BiFunction<BigDecimal, BigDecimal, BigDecimal> soma	   = (v1, v2) -> v1.add(v2);
	
	public final BiFunction<BigDecimal, BigDecimal, BigDecimal> subtracao  = (v1, v2) -> v1.subtract(v2);
	
	public final BiFunction<BigDecimal, BigDecimal, BigDecimal> multicacao = (v1, v2) -> v1.multiply(v2);
	
	public final BiFunction<BigDecimal, BigDecimal, BigDecimal> divisao    = (v1, v2) -> v1.divide(v2);
}