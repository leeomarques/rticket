package com.rticket.model;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PERFIL")
public class Perfil {

    @Id
    @GeneratedValue
    @Column(name="ID", length=6, nullable=false, unique=true)
    private int id;

    @Column(name="NOME", length=100, nullable=false, unique=true)
    private String nome;

    @ManyToMany
    @JoinTable(name="PERFIL_MODULO",
               joinColumns={@JoinColumn(name="ID_PERFIL")},
               inverseJoinColumns={@JoinColumn(name="ID_MODULO")})
    private Collection<Modulo> modulos;

    @OneToMany(mappedBy = "perfil")
    private Collection<Usuario> usuarios;

    @Column(name="ATIVO", length=1, nullable=true, unique=false)
    private String ativo;

    public Perfil() {

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

    public Collection<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Collection<Modulo> modulos) {
        this.modulos = modulos;
    }

    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
}
