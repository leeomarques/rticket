package ClassesBasicas;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="CHAMADOS")
public class Chamados {
    
//    @Id
//    @GeneratedValue
//    @Column(name="ID", length=6, nullable=false, unique=true)
//    int id;
//    @ManyToOne
//    @JoinColumn(name="ID_USUARIO")
//    Usuario usuarios;
    private int id;
    private String dataCriacao;
    private String dataFechamento;
    private String titulo;
    private String descricao;
    private String resposta;
    private String prioridade;
    private String notaChamado;

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
    
    
}
