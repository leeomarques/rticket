package Excecoes;

import java.sql.SQLException;

public class LoginExistenteException extends Exception{
    
    public String mensagem;
    
    public LoginExistenteException() {

    }

    public LoginExistenteException(SQLException e) {
        super(e);
    }

    public LoginExistenteException(String e) {
        this.mensagem = e;
    }
}
