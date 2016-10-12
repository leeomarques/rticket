package ClassesBasicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LOGCHAMADO")
public class LogChamado {

    @Id
    @GeneratedValue
    @Column(name = "ID", length = 6, nullable = false, unique = true)
    private int id;
    private String data;
    private String campo;
    private String historico;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "ID_CHAMADOS")
    private Chamados chamados;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Chamados getChamados() {
        return chamados;
    }

    public void setChamados(Chamados chamados) {
        this.chamados = chamados;
    }

}
