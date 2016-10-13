package ClassesBasicas;

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
@Table(name = "SERVICOS")
public class Servicos {

    @Id
    @GeneratedValue
    @Column(name = "ID", length = 6, nullable = false, unique = true)
    private int id;
    @Column(name = "NOME", length = 100, nullable = false, unique = false)
    private String nome;
    @Column(name = "ATIVO", length = 1, nullable = true, unique = false)
    private String ativo;
    @ManyToMany
    @JoinTable(name = "CHAMADOS_SERVICOS",
               joinColumns = {@JoinColumn(name = "ID_SERVICO")},
               inverseJoinColumns = {@JoinColumn(name = "ID_CHAMADO")})
    private Collection<Chamados> chamados;

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

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public Servicos() {
        
    }

    public Servicos(int id, String nome, String ativo, Collection<Chamados> chamados) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
        this.chamados = chamados;
    }
}
