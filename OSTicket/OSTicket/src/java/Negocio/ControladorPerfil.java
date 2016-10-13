package Negocio;

import ClassesBasicas.Perfil;
import DAO.DAOFactory;
import Dados.PerfilDAO;

public class ControladorPerfil {
    
    private PerfilDAO perfilDAO;
    
    public ControladorPerfil() {
        perfilDAO = DAOFactory.getPerfilDAO();
    }
    //Metodo para Inserir Perfil
    public void inserirPerfil(Perfil perfil) {
        perfilDAO.inserir(perfil);   
    }
               
    //Metodo para Buscar o Perfil pelo ID
    public Perfil buscarPerfil(int id){
        return perfilDAO.buscarPorChave(id);
    }
    
    //Metodo para Alterar Perfil
    public void alterarPerfil(Perfil perfil){
        perfilDAO.alterar(perfil);
    }
}
