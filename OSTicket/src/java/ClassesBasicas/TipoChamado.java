package ClassesBasicas;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TIPOCHAMADO")
public class TipoChamado {

    @Id
    @GeneratedValue
    @Column(name = "ID", length = 6, nullable = false, unique = true)
    private int id;
    private String nome;
    @OneToMany(mappedBy = "chamados")
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
}
