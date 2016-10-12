package ClassesBasicas;

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
    private String dataCriacao;
    private String dataFechamento;
    private String titulo;
    private String descricao;
    private String resposta;
    private String prioridade;
    private String notaChamado;
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuarios;
    @OneToMany(mappedBy = "logchamados")
    private Collection<LogChamado> logChamados;
    @ManyToOne
    @JoinColumn(name = "ID_TIPOCHAMADO")
    private TipoChamado tipoChamado;
    @ManyToOne
    @JoinColumn(name = "ID_STATUSCHAMADO")
    private StatusChamado statusChamado;

    @ManyToMany
    @JoinTable(name = "CHAMADOS_SERVICOS",
            joinColumns = {
                @JoinColumn(name = "ID_CHAMADO")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_SERVICOS")})
    private Collection<Servicos> servicos;

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

    public String getNotaChamado() {
        return notaChamado;
    }

    public void setNotaChamado(String notaChamado) {
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

    public TipoChamado getTipoChamado() {
        return tipoChamado;
    }

    public void setTipoChamado(TipoChamado tipoChamado) {
        this.tipoChamado = tipoChamado;
    }

    public StatusChamado getStatusChamado() {
        return statusChamado;
    }

    public void setStatusChamado(StatusChamado statusChamado) {
        this.statusChamado = statusChamado;
    }

    public Collection<Servicos> getServicos() {
        return servicos;
    }

    public void setServicos(Collection<Servicos> servicos) {
        this.servicos = servicos;
    }

}
