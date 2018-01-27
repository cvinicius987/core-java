package br.com.cvinicius.carrinho;

/**
 * Contrato para criação de lambda para construtores com 3 argumentos
 * 
 * @author Caio
 *
 * @param <U>
 * @param <D>
 * @param <T>
 * @param <R>
 */
@FunctionalInterface
public interface TriArgumentsConstrutor<U, D, T, R> {

    /**
     * Manipulação de lambdas para construtoires com 3 argumentos
     * 
     * @param u
     * @param d
     * @param t
     * @return R
     */
    R apply(U u, D d, T t);
}