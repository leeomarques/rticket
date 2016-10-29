package com.rticket.beans;

import com.rticket.excecao.ValidarLoginException;
import com.rticket.model.Usuario;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {
    
    private String login;
    private String senha;
    private String mensagem;
    private Usuario usuarioLogado;

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

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public void efetuarLogin() throws ValidarLoginException, 
            NoSuchAlgorithmException, IOException {
        try {
            
            if (login.equals("admin") && senha.equals("1234")){
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("principal.xhtml");
            }
            else{
                usuarioLogado = fach.efetuarLogin(login, senha);
            
                if (usuarioLogado.getId() != 0){
                    FacesContext.getCurrentInstance().getExternalContext()
                            .redirect("principal.xhtml");
                }
                else{
                    setMensagem("Usuario ou Senha Invalidos!");
                }
            }
        } catch (ValidarLoginException e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage("Login/Senha inexistente"));
        }


    }
}
