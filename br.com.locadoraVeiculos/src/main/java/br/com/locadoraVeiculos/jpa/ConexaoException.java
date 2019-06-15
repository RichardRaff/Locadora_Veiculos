package br.com.locadoraVeiculos.jpa;

public class ConexaoException extends Exception{
    
    public void JPAException(String ex){
        System.out.printf("Erro na conexão: \n" + ex);
    }
}
