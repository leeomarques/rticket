package Negocio;

import ClassesBasicas.Modulo;
import DAO.DAOFactory;
import Dados.ModuloDAO;
import Excecoes.*;
import java.util.Collection;

public class ControladorModulo {
    
    private ModuloDAO moduloDAO;
    private Boolean verificaNome;
    
    public ControladorModulo() {
        moduloDAO = DAOFactory.getModuloDAO();
    }
    
    //Metodo para buscar o Modulo pelo Nome
    public Boolean buscarModuloNome(String nome){
        return this.verificaNome = moduloDAO.buscarModuloNome(nome);
    }
    
    //Metodo para Inserir Modulo
    public void inserirModulo(Modulo modulo) throws CampoExistenteException{
        buscarModuloNome(modulo.getNome());
        if (verificaNome == false){
            throw new CampoExistenteException();
        }
        else{
            moduloDAO.inserir(modulo);
        }   
    }
    
    //Metodo para Buscar o Modulo pelo ID
    public Modulo buscarModulo(int id){
        return moduloDAO.buscarPorChave(id);
    }
    
    //Metodo para Alterar Modulo
    public void alterarModulo(Modulo modulo){
        moduloDAO.alterar(modulo);
    }
    
    //Listar todos os Modulos
    public Collection<Modulo> listarModulo(){
        return moduloDAO.listarColecao();
    }
}
