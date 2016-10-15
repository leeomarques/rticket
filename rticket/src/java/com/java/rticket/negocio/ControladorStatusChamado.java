package com.java.rticket.negocio;

import com.java.rticket.model.StatusChamado;
import com.java.rticket.dao.DAOFactory;
import com.java.rticket.dao.dados.StatusChamadoDAO;
import java.util.Collection;

public class ControladorStatusChamado {
    
        private StatusChamadoDAO statusChamadoDAO;
    
    public ControladorStatusChamado() {
        statusChamadoDAO = DAOFactory.getStatusChamadoDAO();
    }
    
    //Metodo para Inserir StatusChamado
    public void inserirStatusChamado(StatusChamado statusChamado){
        statusChamadoDAO.inserir(statusChamado);   
    }
    
    //Metodo para Buscar o StatusChamado pelo ID
    public StatusChamado buscarStatusChamado(int id){
        return statusChamadoDAO.buscarPorChave(id);
    }
    
    //Metodo para Alterar StatusChamado
    public void alterarStatusChamado(StatusChamado statusChamado){
        statusChamadoDAO.alterar(statusChamado);
    }
    
    //Listar todos os StatusChamado
    public Collection<StatusChamado> listarStatusChamado(){
        return statusChamadoDAO.listarColecao();
    }
}
