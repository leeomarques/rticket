package com.rticket.negocio;

import com.rticket.model.LogChamado;
import com.rticket.dao.DAOFactory;
import com.rticket.dao.dados.LogChamadoDAO;
import java.util.Collection;

public class ControladorLogChamado {

    private LogChamadoDAO logChamadoDAO;

    public ControladorLogChamado() {
        logChamadoDAO = DAOFactory.getLogChamadoDAO();
    }

    //Metodo para Buscar o LogChamado pelo ID
    public LogChamado buscarLogChamado(int id){
        return logChamadoDAO.buscarPorChave(id);
    }

    //Listar todos os LogChamados
    public Collection<LogChamado> listarLogChamados(){
        return logChamadoDAO.listarColecao();
    }
}
