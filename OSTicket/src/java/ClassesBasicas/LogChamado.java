package ClassesBasicas;

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
    private String data;
    @Column(name="CAMPO", length=100, nullable=false, unique=false)
    private String campo;
    @Column(name="HISTORIO", length=800, nullable=false, unique=false)
    private String historico;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuarios;
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

    public LogChamado() {
        
    }

    public LogChamado(int id, String data, String campo, String historico, Usuario usuarios, Chamados chamados) {
        this.id = id;
        this.data = data;
        this.campo = campo;
        this.historico = historico;
        this.usuarios = usuarios;
        this.chamados = chamados;
    }  
}
