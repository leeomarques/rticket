package com.rticket.negocio;

import com.rticket.excecao.ValidarLoginException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.CampoExistenteException;
import com.rticket.model.Usuario;
import com.rticket.dao.DAOFactory;
import com.rticket.dao.dados.UsuarioDAO;
import com.rticket.excecao.FormatoInvalidoException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorUsuario {

    private UsuarioDAO usuarioDAO;
    private Boolean resultado;
    private Usuario user;

    public ControladorUsuario() {
        usuarioDAO = DAOFactory.getUsuarioDAO();
    }

    //Metodo de Verificar Caracteres Especiais
    public Boolean verificarCaracteres(String nome){

        this.resultado = false;
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
        Matcher matcher = pattern.matcher(nome);

        if(matcher.find()){
            this.resultado = true;
        }

        return this.resultado;
    }

    //Metodo para EfetuarLogin
    public Boolean efetuarLogin(String login, String senha)
            throws ValidarLoginException, NoSuchAlgorithmException{
        this.resultado = false;
        senha = converterSenhaMD5(senha);
        return usuarioDAO.efetuarLogin(login, senha);
    }

    //Metodo para verificar se o login ja existe no banco
    public Boolean buscarLogin(String login){
        this.resultado = false;
        return this.resultado = usuarioDAO.buscarLogin(login);
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
                NoSuchAlgorithmException, FormatoInvalidoException{

        if (usuario.getNome().isEmpty() || usuario.getLogin().isEmpty() ||
                usuario.getSenha().isEmpty()){
            throw new CampoVazioException();
        }

        buscarLogin(usuario.getLogin());

        if (this.resultado == true){
            throw new CampoExistenteException();
        }

        verificarCaracteres(usuario.getNome());

        if(this.resultado == false){
            throw new FormatoInvalidoException();
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