package com.rticket.beans;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.StatusChamado;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.util.Collection;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "statusChamadoBean")
public class StatusChamadoBean {
    
    IFachada fach = new Fachada();
    
    public void inserirStatusChamado(StatusChamado statusChamado)
            throws FormatoInvalidoException, CampoExistenteException,
                CampoVazioException{
        fach.inserirStatusChamado(statusChamado);
    }

    public StatusChamado buscarStatusChamado(int id) {
        return fach.buscarStatusChamado(id);
    }

    public void alterarStatusChamado(StatusChamado statusChamado) {
        fach.alterarStatusChamado(statusChamado);
    }

    public Collection<StatusChamado> listarStatusChamado() {
        return fach.listarStatusChamado();
    }
}
