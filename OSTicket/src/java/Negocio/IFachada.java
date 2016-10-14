package Negocio;

import ClassesBasicas.Chamados;
import ClassesBasicas.LogChamado;
import ClassesBasicas.Modulo;
import ClassesBasicas.Perfil;
import ClassesBasicas.Servicos;
import ClassesBasicas.StatusChamado;
import ClassesBasicas.TipoChamado;
import ClassesBasicas.Usuario;
import java.util.Collection;

public interface IFachada {

//<editor-fold defaultstate="collapsed" desc="Assinaturas para Usuarios">
    void inserirUsuario(Usuario usuario);

    Usuario buscarUsuario(int id);

    void alterarUsuario(Usuario usuario);
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Assinaturas para Perfis">
    void inserirPerfil(Perfil perfil);

    Perfil buscarPerfil(int id);

    void alterarPerfil(Perfil perfil);
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Assinaturas para Modulos">
    void inserirModulo(Modulo modulo);

    Modulo buscarModulo(int id);

    void alterarModulo(Modulo modulo);

    Collection<Modulo> listarModulo();
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Assinaturas para Chamados">
    void inserirChamados(Chamados chamado);

    Chamados buscarChamados(int id);

    void alterarChamados(Chamados chamado);

    Collection<Chamados> listarChamados();
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Assinaturas para LogChamados">
    void inserirLogChamados(LogChamado logChamado);

    LogChamado buscarLogChamados(int id);

    void alterarLogChamados(LogChamado LogChamado);

    Collection<LogChamado> listarLogChamados();
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Assinaturas para Servicos">
    public void inserirServicos(Servicos servicos);

    public Servicos buscarServicos(int id);

    public void alterarServicos(Servicos servicos);

    public Collection<Servicos> listarServicos();
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Assinaturas para StatusChamado">
    public void inserirStatusChamado(StatusChamado statusChamado);

    public StatusChamado buscarStatusChamado(int id);

    public void alterarStatusChamado(StatusChamado statusChamado);

    public Collection<StatusChamado> listarStatusChamado();
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Assinaturas para TipoChamado">
    public void inserirTipoChamado(TipoChamado tipoChamado);

    public TipoChamado buscarTipoChamado(int id);

    public void alterarTipoChamado(TipoChamado tipoChamado);

    public Collection<TipoChamado> listarTipoChamado();
//</editor-fold>

}
