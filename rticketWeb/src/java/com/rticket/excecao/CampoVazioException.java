package com.rticket.excecao;

import java.sql.SQLException;

public class CampoVazioException extends Exception{

    public String mensagem;

    public CampoVazioException() {

    }

    public CampoVazioException(SQLException e) {
        super(e);
    }

    public CampoVazioException(String e) {
        this.mensagem = e;
    }
}
