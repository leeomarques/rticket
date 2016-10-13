package Negocio;

import ClassesBasicas.Usuario;
import DAO.DAOFactory;
import Dados.UsuarioDAO;
import java.util.Collection;

public class ControladorUsuario {
    
    private UsuarioDAO usuarioDAO;
    
    public ControladorUsuario() {
        usuarioDAO = DAOFactory.getUsuarioDAO();
    }
    
    //Metodo para Inserir Usuario
    public void inserirUsuario(Usuario usuario){
        usuarioDAO.inserir(usuario);   
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
