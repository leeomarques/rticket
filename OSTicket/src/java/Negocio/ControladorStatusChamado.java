package Negocio;

import ClassesBasicas.StatusChamado;
import DAO.DAOFactory;
import Dados.StatusChamadoDAO;

public class ControladorStatusChamado {
    
        private StatusChamadoDAO statusChamadoDAO;
    
    public ControladorStatusChamado() {
        statusChamadoDAO = DAOFactory.getStatusChamadoDAO();
    }
    
    //Metodo para Inserir TipoChamado
    public void inserirStatusChamado(StatusChamado statusChamado){
        statusChamadoDAO.inserir(statusChamado);   
    }
    
    //Metodo para Buscar o TipoChamado pelo ID
    public StatusChamado buscarStatusChamado(int id){
        return statusChamadoDAO.buscarPorChave(id);
    }
    
    //Metodo para Alterar TipoChamado
    public void alterarStatusChamado(StatusChamado statusChamado){
        statusChamadoDAO.alterar(statusChamado);
    }
}
