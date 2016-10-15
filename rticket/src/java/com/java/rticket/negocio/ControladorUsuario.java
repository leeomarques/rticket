package com.java.rticket.negocio;

import com.java.rticket.excecao.ValidarLoginException;
import com.java.rticket.excecao.CampoVazioException;
import com.java.rticket.excecao.CampoExistenteException;
import com.java.rticket.model.Usuario;
import com.java.rticket.dao.DAOFactory;
import com.java.rticket.dao.dados.UsuarioDAO;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

public class ControladorUsuario {
    
    private UsuarioDAO usuarioDAO;
    private Boolean verificaLogin;
    
    public ControladorUsuario() {
        usuarioDAO = DAOFactory.getUsuarioDAO();
    }
    
    //Metodo para EfetuarLogin
    public Boolean efetuarLogin(String login, String senha) 
            throws ValidarLoginException, NoSuchAlgorithmException{
        senha = converterSenhaMD5(senha);
        return this.verificaLogin = usuarioDAO.efetuarLogin(login, senha);
    }
    //Metodo para buscar o Usuario pelo Login
    public Boolean buscarLogin(String login){
        return this.verificaLogin = usuarioDAO.buscarLogin(login);
    }
    //Metodo para Encriptar a Senha do Usuario
    public static String converterSenhaMD5(String password) 
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));
        
        return String.format("%32x", hash);
    }
    
    //Metodo para Inserir Usuario
    public void inserirUsuario(Usuario usuario)
            throws CampoVazioException, CampoExistenteException, 
                NoSuchAlgorithmException{
        if (usuario.getNome() == null || usuario.getLogin() == null || 
                usuario.getSenha() == null){
            throw new CampoVazioException(); 
        }
        buscarLogin(usuario.getLogin());
        if (verificaLogin == false){
            throw new CampoExistenteException();
        }
        else{          
            usuario.setSenha(converterSenhaMD5(usuario.getSenha())) ;
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
