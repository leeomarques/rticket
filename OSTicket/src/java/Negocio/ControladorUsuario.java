package Negocio;

import ClassesBasicas.Usuario;
import DAO.DAOFactory;
import Dados.UsuarioDAO;
import Excecoes.*;
import java.util.Collection;

public class ControladorUsuario {
    
    private UsuarioDAO usuarioDAO;
    private Boolean verificaLogin;
    
    public ControladorUsuario() {
        usuarioDAO = DAOFactory.getUsuarioDAO();
    }
    
    //Metodo para buscar o Usuario pelo Login
    public Boolean buscarLogin(String login){
        return this.verificaLogin = usuarioDAO.buscarLogin(login);
    }
    //Metodo para Inserir Usuario
    public void inserirUsuario(Usuario usuario)throws CampoVazioException, LoginExistenteException{
        if (usuario.getNome() == null || usuario.getLogin() == null || usuario.getSenha() == null){
            throw new CampoVazioException(); 
        }
        buscarLogin(usuario.getLogin());
        if (verificaLogin == false){
            throw new LoginExistenteException();
        }
        else{
            usuarioDAO.inserir(usuario);
        }   
    }
    
    //Metodo para Buscar o Usuario pelo ID
    public Usuario buscarUsuario(int id){
        return usuarioDAO.buscarPorChave(id);
    }
    
    //Metodo para Alterar Usuario
    public void alterarUsuario(Usuario usuario){
        usuarioDAO.alterar(usuario);
    }
    
    //Listar todos os Usuarios
    public Collection<Usuario> listarUsuario(){
        return usuarioDAO.listarColecao();
    }
}
