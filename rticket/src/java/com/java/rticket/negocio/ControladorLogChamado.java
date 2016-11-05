package com.java.rticket.negocio;

import com.java.rticket.model.LogChamado;
import com.java.rticket.dao.DAOFactory;
import com.java.rticket.dao.dados.LogChamadoDAO;
import com.java.rticket.excecao.CampoVazioException;
import com.java.rticket.model.Chamados;
import java.util.Collection;

public class ControladorLogChamado {
    
    private LogChamadoDAO logChamadoDAO;
    private Chamados chamado;
    private LogChamado logChamados;
    private Boolean resultado;
    
    public ControladorLogChamado() {
        logChamadoDAO = DAOFactory.getLogChamadoDAO();
    }
    
    //Metodo que recebe os dados do Chamado
    public Boolean inserirLogChamado(Chamados chamado) 
            throws CampoVazioException {
        this.resultado = false;
        logChamados.setUsuario(chamado.getUsuarios());
        logChamados.setChamados(chamado);
        logChamados.setCampo(chamado.getStatusChamados().toString());
        logChamados.setData(chamado.getDataCriacao());
        logChamados.setHistorico("Novo Chamado Criado");
        
        inserirLogChamado(logChamados);
        
        return this.resultado;
    }
    
    //Metodo para Inserir LogChamado
    public void inserirLogChamado(LogChamado logChamado) 
            throws CampoVazioException{
        
        if (logChamados.getUsuarios().getId() == 0 || 
            logChamados.getChamados().getId() == 0 || 
            logChamados.getCampo().isEmpty() || 
            logChamados.getData().isEmpty() || 
            logChamados.getHistorico().isEmpty()){
            
            throw new CampoVazioException();
        }
        logChamadoDAO.inserir(logChamado);
        this.resultado = true;
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
