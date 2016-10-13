package Negocio;

import ClassesBasicas.Chamados;
import DAO.DAOFactory;
import Dados.ChamadosDAO;
import java.util.Collection;

public class ControladorChamados {
    
    private ChamadosDAO chamadosDAO;
    
    public ControladorChamados() {
        chamadosDAO = DAOFactory.getChamadosDAO();
    }
    
    //Metodo para Inserir Chamados
    public void inserirChamados(Chamados chamado){
        chamadosDAO.inserir(chamado);   
    }
    
    //Metodo para Buscar o Chamados pelo ID
    public Chamados buscarChamados(int id){
        return chamadosDAO.buscarPorChave(id);
    }
    
    //Metodo para Alterar Chamados
    public void alterarChamados(Chamados chamado){
        chamadosDAO.alterar(chamado);
    }
    
    //Listar todos os Chamados
    public Collection<Chamados> listarChamados(){
        return chamadosDAO.listarColecao();
    }
}
