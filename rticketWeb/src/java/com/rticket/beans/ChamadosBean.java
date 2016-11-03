package com.rticket.beans;

import com.rticket.excecao.CampoVazioException;
import com.rticket.model.Chamados;
import com.rticket.model.StatusChamado;
import com.rticket.model.TipoChamado;
import com.rticket.model.Usuario;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.faces.bean.ManagedBean;
import javax.swing.JOptionPane;

@ManagedBean(name = "/chamadosBean")
public class ChamadosBean {

    private int id;
    private Date dataCriacao;
    private Date dataFechamento;
    private String titulo;
    private String descricao;
    private String resposta;
    private String prioridade;
    private int notaChamado;
    private Usuario usuarios;
    private TipoChamado tipoChamados;
    private StatusChamado statusChamados;
    private String mensagem;
    private Chamados chamado;
    
    IFachada fach = new Fachada();

    public ChamadosBean() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public int getNotaChamado() {
        return notaChamado;
    }

    public void setNotaChamado(int notaChamado) {
        this.notaChamado = notaChamado;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    public TipoChamado getTipoChamados() {
        return tipoChamados;
    }

    public void setTipoChamados(TipoChamado tipoChamados) {
        this.tipoChamados = tipoChamados;
    }

    public StatusChamado getStatusChamados() {
        return statusChamados;
    }

    public void setStatusChamados(StatusChamado statusChamados) {
        this.statusChamados = statusChamados;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
       
    public Chamados getChamado() {
        return chamado;
    }

    public void setChamado(Chamados chamado) {
        this.chamado = chamado;
    }

    //Metodo para inserir chamados
    public void inserirChamados(Chamados chamado) {
        try {
            fach.inserirChamados(chamado);
        } catch (CampoVazioException ex) {
            setMensagem("Usuario ou Senha Invalidos!");
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
        
        while(iterator.hasNext()) {
            
           Chamados item = (Chamados)iterator.next();
            
            System.out.println(item.getId());
             
         }
        
        return listChamado;
    }
}
