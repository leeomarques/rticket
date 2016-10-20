package com.rticket.model;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STATUS_CHAMADO")
public class StatusChamado {

    @Id
    @GeneratedValue
    @Column(name = "ID", length = 6, nullable = false, unique = true)
    private int id;

    @Column(name = "NOME", length = 100, nullable = false, unique = false)
    private String nome;

    @Column(name = "FINALIZA_PROCESSO", length = 1, nullable = true, unique = false)
    private String finaliza;
    
    @Column(name = "ATIVO", length = 1, nullable = true, unique = false)
    private String ativo;

    @OneToMany(mappedBy = "statusChamados")
    private Collection<Chamados> chamados;

    public StatusChamado() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Chamados> getChamados() {
        return chamados;
    }

    public void setChamados(Collection<Chamados> chamados) {
        this.chamados = chamados;
    }

    public String getFinaliza() {
        return finaliza;
    }

    public void setFinaliza(String finaliza) {
        this.finaliza = finaliza;
    }
    
    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
}
