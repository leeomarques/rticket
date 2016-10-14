package Excecoes;

import java.sql.SQLException;

public class CampoExistenteException extends Exception{
    
    public String mensagem;
    
    public CampoExistenteException() {

    }

    public CampoExistenteException(SQLException e) {
        super(e);
    }

    public CampoExistenteException(String e) {
        this.mensagem = e;
    }
}
