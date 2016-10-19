package com.java.rticket.negocio;

import com.java.rticket.model.Chamados;
import com.java.rticket.dao.DAOFactory;
import com.java.rticket.dao.dados.ChamadosDAO;
import com.java.rticket.excecao.CampoVazioException;
import com.java.rticket.model.LogChamado;
import java.util.Collection;

public class ControladorChamados {
    
    private ChamadosDAO chamadosDAO;
    private ControladorLogChamado logChamado;
    
    public ControladorChamados() {
        chamadosDAO = DAOFactory.getChamadosDAO();
    }
    
    //Metodo para Inserir Chamados
    public void inserirChamados(Chamados chamado) throws CampoVazioException{
        
        if (chamado.getDataCriacao().isEmpty() || 
                chamado.getDescricao().isEmpty() || 
                chamado.getLogChamados().isEmpty() || 
                chamado.getServicos().isEmpty() || 
                chamado.getTitulo().isEmpty() || 
                chamado.getStatusChamados().getNome().isEmpty() || 
                chamado.getUsuarios().getNome().isEmpty()){
            throw new CampoVazioException();
        }      
        else{
            chamadosDAO.inserir(chamado);
            logChamado.inserirLogChamado(chamado);
        }      
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
