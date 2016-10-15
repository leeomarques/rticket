package com.java.rticket.model;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MODULO")
public class Modulo {
    
    @Id
    @GeneratedValue
    @Column(name="ID", length=6, nullable=false, unique=true)        
    private int id;
    
    @Column(name="NOME", length=100, nullable=false, unique=true)
    private String nome;
    
    @ManyToMany
    @JoinTable(name="PERFIL_MODULO",
               joinColumns={@JoinColumn(name="ID_MODULO")},
               inverseJoinColumns={@JoinColumn(name="ID_PERFIL")})
    private Collection<Perfil> perfis;
    
    @Column(name="ATIVO", length=1, nullable=true, unique=false)
    private String ativo;
    
    public Modulo() {
        
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

    public Collection<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(Collection<Perfil> perfis) {
        this.perfis = perfis;
    }
    
    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
}
