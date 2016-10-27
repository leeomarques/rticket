package ManagedBean;

import com.rticket.excecao.ValidarLoginException;
import com.rticket.model.Usuario;
import javax.faces.bean.ManagedBean;
import com.rticket.negocio.ControladorUsuario;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.security.NoSuchAlgorithmException;

@ManagedBean
public class LoginBean {

    private String login;
    private String senha;
    private String mensagem;
    
    IFachada fach = new Fachada();

    public LoginBean() {

    }
        
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
   /* public String efetuarLogin(){
	if(getLogin().equalsIgnoreCase(getSenha())){
	    setMensagem("Login válido");
	} else {
  	    setMensagem("Login ou Senha Invalidos. Tente novamente!");
	}
	return null;
    }*/
    
    public void efetuarLogin(String nome, String senha) throws ValidarLoginException, NoSuchAlgorithmException{
        
        Boolean resultado = false;
        resultado = fach.efetuarLogin(login, senha);
        
        if(resultado == true){
	    setMensagem("Login válido");
	} else {
  	    setMensagem("Login ou Senha Invalidos. Tente novamente!");
	}
    }
}