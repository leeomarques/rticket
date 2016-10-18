package com.rticket.excecao;

import java.sql.SQLException;

public class FormatoInvalidoException extends Exception{

    public String mensagem;

    public FormatoInvalidoException() {

    }

    public FormatoInvalidoException(SQLException e) {
        super(e);
    }

    public FormatoInvalidoException(String e) {
        this.mensagem = e;
    }
}
