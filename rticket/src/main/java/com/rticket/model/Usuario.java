package com.rticket.model;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "ID", length = 6, nullable = false, unique = true)
    private int id;

    @Column(name = "NOME", length = 100, nullable = false, unique = false)
    private String nome;

    @Column(name = "LOGIN", length = 20, nullable = false, unique = true)
    private String login;

    @Column(name = "SENHA", length = 50, nullable = false, unique = false)
    private String senha;

    @Column(name = "ATIVO", length = 1, nullable = true, unique = false)
    private String ativo;

    @ManyToMany
    @JoinTable(name = "USUARIO_PERFIL",
               joinColumns = {@JoinColumn(name = "ID_USUARIO")},
               inverseJoinColumns = {@JoinColumn(name = "ID_PERFIL")})
    private Collection<Perfil> perfis;

    @OneToMany(mappedBy = "usuarios")
    private Collection<Chamados> chamados;

    @OneToMany(mappedBy = "usuarios")
    private Collection<LogChamado> logChamados;

    public Usuario() {

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public Collection<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Collection<Perfil> perfis) {
        this.perfis = perfis;
    }

    public Collection<Chamados> getChamados() {
        return chamados;
    }

    public void setChamados(Collection<Chamados> chamados) {
        this.chamados = chamados;
    }

    public Collection<LogChamado> getLogChamados() {
        return logChamados;
    }

    public void setLogChamados(Collection<LogChamado> logChamados) {
        this.logChamados = logChamados;
    }
}
