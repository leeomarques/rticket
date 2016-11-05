package com.rticket.beans;

import com.rticket.model.LogChamado;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.util.Collection;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "logChamadoBean")
public class LogChamadoBean {
    
    IFachada fach = new Fachada();
    
    public LogChamado buscarLogChamados(int id) {
        return fach.buscarLogChamados(id);
    }

    public Collection<LogChamado> listarLogChamados() {
        return fach.listarLogChamados();
    }
}
