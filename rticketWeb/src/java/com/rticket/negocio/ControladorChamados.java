package com.rticket.negocio;

import com.rticket.model.Chamados;
import com.rticket.dao.DAOFactory;
import com.rticket.dao.dados.ChamadosDAO;
import com.rticket.excecao.CampoVazioException;
import com.rticket.model.LogChamado;
import java.util.Collection;
import java.util.Date;

public class ControladorChamados {

    private ChamadosDAO chamadosDAO;

    public ControladorChamados() {
        chamadosDAO = DAOFactory.getChamadosDAO();
    }

    //Metodo para Inserir Chamados
    public void inserirChamados(Chamados chamado){
        
        LogChamado log = new LogChamado();
        Date dt = new Date();
        log.setData(dt);
        log.setAcao("Incluir");
        log.setUsuario(chamado.getUsuarios());
        log.setChamados(chamado);
        log.setHistorico("TIPO: "+chamado.getTipoChamados().getNome()+";"
               +" STATUS: "+chamado.getStatusChamados().getNome()+";"
               +" TITULO: "+chamado.getTitulo()+";"
               +" DESCRICAO: "+chamado.getDescricao()+";");
        
        chamadosDAO.inserirChamados(chamado, log);
    }

    //Metodo para Buscar o Chamados pelo ID
    public Chamados buscarChamados(int id){
        
        return chamadosDAO.buscarPorChave(id);
    }

    //Metodo para Alterar Chamados
    public void alterarChamados(Chamados chamado){
        
        Chamados cham = new Chamados();
        LogChamado logChamado = new LogChamado();
        Date data = new Date();
        String logHistorico = "";
        cham = chamadosDAO.buscarPorChave(chamado.getId());
        
        logChamado.setChamados(chamado);
        
        if(cham.getStatusChamados().getId() != chamado.getStatusChamados().getId()){
            
            logHistorico = ("Status: "+cham.getStatusChamados().getNome());
        }
        if(chamado.getStatusChamados().getFinaliza().equals("S")){
            
            /*if(chamado.getNotaChamado() == 0 || chamado.getResposta().isEmpty()){
                throw new CampoVazioException();
            }*/
            logChamado.setAcao("Fechar");
            chamado.setDataFechamento(data);
            logChamado.setData(data);
        }
        else{
            logChamado.setAcao("Alterar");
            logChamado.setData(data);
        }
        
        if(cham.getResposta() != chamado.getResposta()){
            
            logHistorico += (" Resposta: "+chamado.getResposta());
        }
        
        if(cham.getPrioridade() != chamado.getPrioridade()){
            
            logHistorico += (" Prioridade: "+chamado.getPrioridade());
        }
        
        if(cham.getNotaChamado() != chamado.getNotaChamado()){
            
            logHistorico += (" Nota_Chamado: "+chamado.getNotaChamado());
        }
        
        logChamado.setHistorico(logHistorico);
        chamadosDAO.alterarChamados(chamado, logChamado);
    }

    //Listar todos os Chamados
    public Collection<Chamados> listarChamados(){
        return chamadosDAO.listarColecao();
    }
}