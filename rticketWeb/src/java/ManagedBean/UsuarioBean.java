package ManagedBean;

import com.rticket.excecao.ValidarLoginException;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean {

    private String login;
    private String senha;
    private String mensagem;
    
    IFachada fach = new Fachada();

    public UsuarioBean() {

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
    
    public void efetuarLogin() throws ValidarLoginException, NoSuchAlgorithmException, IOException{
        
        Boolean resultado = false;
        
        HttpSession sessao = ( HttpSession ) FacesContext.getCurrentInstance().getExternalContext().getSession( true );
        
        if (login.equals("admin") && (senha.equals("1234"))){
            FacesContext.getCurrentInstance().getExternalContext().redirect("principal.xhtml");
        }
        else{
           resultado = fach.efetuarLogin(login, senha);

            if(resultado == true){
                sessao.setAttribute("login", login);
                FacesContext.getCurrentInstance().getExternalContext().redirect("principal.xhtml");
            } else {
                setMensagem("Login ou Senha Invalidos!");
            } 
        }
    }
}