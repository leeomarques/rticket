package com.rticket.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOG_CHAMADO")
public class LogChamado {

    @Id
    @GeneratedValue
    @Column(name = "ID", length = 6, nullable = false, unique = true)
    private int id;

    @Column(name="DATA", length=10, nullable=false, unique=false)
    private Date data;

    @Column(name="ACAO", length=100, nullable=false, unique=false)
    private String acao;

    @Column(name="HISTORICO", length=800, nullable=false, unique=false)
    private String historico;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuarios;

    @ManyToOne
    @JoinColumn(name = "ID_CHAMADOS")
    private Chamados chamados;

    public LogChamado() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public void setUsuario(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    public Chamados getChamados() {
        return chamados;
    }

    public void setChamados(Chamados chamados) {
        this.chamados = chamados;
    }
}
