package Negocio;

import ClassesBasicas.LogChamado;
import DAO.DAOFactory;
import Dados.LogChamadoDAO;
import java.util.Collection;

public class ControladorLogChamado {
    
    private LogChamadoDAO logChamadoDAO;
    
    public ControladorLogChamado() {
        logChamadoDAO = DAOFactory.getLogChamadoDAO();
    }
    
    //Metodo para Inserir LogChamado
    public void inserirLogChamado(LogChamado logChamado){
        logChamadoDAO.inserir(logChamado);   
    }
    
    //Metodo para Buscar o LogChamado pelo ID
    public LogChamado buscarLogChamado(int id){
        return logChamadoDAO.buscarPorChave(id);
    }
    
    //Metodo para Alterar LogChamado
    public void alterarLogChamado(LogChamado logChamado){
        logChamadoDAO.alterar(logChamado);
    }
    
    //Listar todos os LogChamados
    public Collection<LogChamado> listarLogChamados(){
        return logChamadoDAO.listarColecao();
    }
}
