package com.rticket.beans;

import com.rticket.model.Chamados;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.util.Collection;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "chamadosBean")
public class ChamadosBean {
    
    IFachada fach = new Fachada();
    
    public void inserirChamados(Chamados chamado) {
        fach.inserirChamados(chamado);
    }

    public Chamados buscarChamados(int id) {
        return fach.buscarChamados(id);
    }

    public void alterarChamados(Chamados chamado){
        fach.alterarChamados(chamado);
    }

    public Collection<Chamados> listarChamados() {
        return fach.listarChamados();
    }
}
