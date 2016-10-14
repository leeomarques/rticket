package Negocio;

import ClassesBasicas.Perfil;
import DAO.DAOFactory;
import Dados.PerfilDAO;
import Excecoes.*;

public class ControladorPerfil {
    
    private PerfilDAO perfilDAO;
    private Boolean verificaNome;
    
    public ControladorPerfil() {
        perfilDAO = DAOFactory.getPerfilDAO();
    }
    
    //Metodo para buscar o Modulo pelo Nome
    public Boolean buscarPerfilNome(String nome){
        return this.verificaNome = perfilDAO.buscarPerfilNome(nome);
    }
    //Metodo para Inserir Perfil
    public void inserirPerfil(Perfil perfil) throws CampoExistenteException{
        buscarPerfilNome(perfil.getNome());
        if (verificaNome == false){
            throw new CampoExistenteException();
        }
        else{
            perfilDAO.inserir(perfil);
        }           
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
