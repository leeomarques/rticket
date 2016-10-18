package com.java.rticket.excecao;

import java.sql.SQLException;

public class SenhaInvalidaException extends Exception{
    
    public String mensagem;
    
    public SenhaInvalidaException() {

    }

    public SenhaInvalidaException(SQLException e) {
        super(e);
    }

    public SenhaInvalidaException(String e) {
        this.mensagem = e;
    }
}