package Negocio;

import ClassesBasicas.Modulo;
import DAO.DAOFactory;
import Dados.ModuloDAO;
import Excecoes.*;

public class ControladorModulo {
    
    private ModuloDAO moduloDAO;
    
    public ControladorModulo() {
        moduloDAO = DAOFactory.getModuloDAO();
    }
    
    //Metodo para Inserir Modulo
    public void inserirModulo(Modulo modulo) throws CampoVazioException{
        if (modulo.getNome() == null){
            throw new CampoVazioException();
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
}
