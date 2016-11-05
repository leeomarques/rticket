package com.rticket.beans;

import com.rticket.excecao.CampoVazioException;
import com.rticket.model.Chamados;
import com.rticket.model.TipoChamado;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

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

    public void inserirChamados(Chamados chamado) {
        try {
            fach.inserirChamados(chamado);
        } catch (CampoVazioException ex) {
            JOptionPane.showMessageDialog(null, "Favor preencher todos os Campos");
        }
    }

    //Metodo para buscar por id
    public Chamados buscarChamados(int id) {
        return fach.buscarChamados(id);
    }

    //Metodo para alterar Chamados
    public void alterarChamados(Chamados chamado) {
        fach.alterarChamados(chamado);
    }

    public Collection<Chamados> listarChamados() {

        JOptionPane.showMessageDialog(null, "Entrou no Metodo");
        System.out.println("XXXXXXXXXXXXXXXXXX");
        Collection<Chamados> listChamado = new ArrayList();

        Iterator<Chamados> iterator;

        iterator = fach.listarChamados().iterator();

        while (iterator.hasNext()) {

            Chamados item = (Chamados) iterator.next();

            System.out.println(item.getId());

        }

        return listChamado;
    }

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();

        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }

}
