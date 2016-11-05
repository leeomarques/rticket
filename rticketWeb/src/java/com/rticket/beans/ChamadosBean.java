package com.rticket.beans;

import com.rticket.excecao.CampoVazioException;
import com.rticket.model.Chamados;
import com.rticket.model.TipoChamado;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.swing.JOptionPane;

@ManagedBean(name = "chamadosBean")
public class ChamadosBean {

    private Collection<Chamados> listarChamados;
    private Collection<TipoChamado> listarTipoChamado;
    private Chamados chamado;
    
    IFachada fach = new Fachada();
    
    public Collection<Chamados> getListarChamados() {
                             
        this.listarChamados = fach.listarChamados();
        return this.listarChamados;
    }

    public void setListarChamados(Collection<Chamados> listarChamados) {
        this.listarChamados = listarChamados;
    }

    public Collection<TipoChamado> getListarTipoChamado() {
        
        this.listarTipoChamado = fach.listarTipoChamado();
        return this.listarTipoChamado;
    }

    public void setListarTipoChamado(Collection<TipoChamado> listarTipoChamado) {
        this.listarTipoChamado = listarTipoChamado;
    }
    
    public Chamados getChamado() {
        return chamado;
    }

    public void setChamado(Chamados chamado) {
        this.chamado = chamado;
    }
    
    public void inserirChamados(Chamados chamado){
        try {
            fach.inserirChamados(chamado);
        } catch (CampoVazioException ex) {
            JOptionPane.showMessageDialog(null, "Favor preencher todos os Campos");
        }
    }
}