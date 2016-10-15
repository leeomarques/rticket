package com.java.rticket.excecao;

import java.sql.SQLException;

public class ValidarLoginException extends Exception{
    
    public String mensagem;
    
    public ValidarLoginException() {

    }

    public ValidarLoginException(SQLException e) {
        super(e);
    }

    public ValidarLoginException(String e) {
        this.mensagem = e;
    }
}