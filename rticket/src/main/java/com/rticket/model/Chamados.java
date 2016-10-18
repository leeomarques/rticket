package com.rticket.model;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CHAMADOS")
public class Chamados {

    @Id
    @GeneratedValue
    @Column(name = "ID", length = 6, nullable = false, unique = true)
    private int id;

    @Column(name = "DATA_CRIACAO",
            length = 10, nullable = false, unique = false)
    private String dataCriacao;

    @Column(name = "DATA_FECHAMENTO",
            length = 10, nullable = false, unique = false)
    private String dataFechamento;

    @Column(name = "TITULO", length = 100, nullable = false, unique = false)
    private String titulo;

    @Column(name = "DESCRICAO", length = 500, nullable = false, unique = false)
    private String descricao;

    @Column(name = "RESPOSTA", length = 500, nullable = true, unique = false)
    private String resposta;

    @Column(name = "PRIORIDADE", length = 10, nullable = true, unique = false)
    private String prioridade;

    @Column(name = "NOTA_CHAMADO", length = 1, nullable = true, unique = false)
    private int notaChamado;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuarios;

    @OneToMany(mappedBy = "chamados")
    private Collection<LogChamado> logChamados;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_CHAMADO")
    private TipoChamado tipoChamados;

    @ManyToOne
    @JoinColumn(name = "ID_STATUS_CHAMADO")
    private StatusChamado statusChamados;

    @ManyToMany
    @JoinTable(name = "CHAMADOS_SERVICOS",
            joinColumns = {
                @JoinColumn(name = "ID_CHAMADO")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_SERVICO")})
    private Collection<Servicos> servicos;

    public Chamados() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(String dataFechamento) {
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

    public Collection<LogChamado> getLogChamados() {
        return logChamados;
    }

    public void setLogChamados(Collection<LogChamado> logChamados) {
        this.logChamados = logChamados;
    }

    public TipoChamado getTipoChamados() {
        return tipoChamados;
    }

    public void setTipoChamado(TipoChamado tipoChamados) {
        this.tipoChamados = tipoChamados;
    }

    public StatusChamado getStatusChamados() {
        return statusChamados;
    }

    public void setStatusChamado(StatusChamado statusChamados) {
        this.statusChamados = statusChamados;
    }

    public Collection<Servicos> getServicos() {
        return servicos;
    }

    public void setServicos(Collection<Servicos> servicos) {
        this.servicos = servicos;
    }
}
