package com.java.rticket.negocio;

import com.java.rticket.excecao.ValidarLoginException;
import com.java.rticket.excecao.CampoVazioException;
import com.java.rticket.excecao.CampoExistenteException;
import com.java.rticket.excecao.FormatoInvalidoException;
import com.java.rticket.model.Chamados;
import com.java.rticket.model.LogChamado;
import com.java.rticket.model.Modulo;
import com.java.rticket.model.Perfil;
import com.java.rticket.model.Servicos;
import com.java.rticket.model.StatusChamado;
import com.java.rticket.model.TipoChamado;
import com.java.rticket.model.Usuario;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

public interface IFachada {

    //<editor-fold defaultstate="collapsed" desc="Assinaturas para Modulos">
    void inserirModulo(Modulo modulo) 
            throws CampoExistenteException, FormatoInvalidoException, 
                CampoVazioException;

    Modulo buscarModulo(int id);

    void alterarModulo(Modulo modulo);

    Collection<Modulo> listarModulo();
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Assinaturas para Perfis">
    void inserirPerfil(Perfil perfil) 
            throws CampoExistenteException, FormatoInvalidoException, 
                CampoVazioException;

    Perfil buscarPerfil(int id);

    void alterarPerfil(Perfil perfil);
    
    Collection<Perfil> listarPerfil();
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Assinaturas para Usuarios">
    Boolean efetuarLogin(String login, String senha) 
            throws ValidarLoginException, NoSuchAlgorithmException;
    
    void inserirUsuario(Usuario usuario) 
            throws CampoVazioException, CampoExistenteException, 
                NoSuchAlgorithmException, FormatoInvalidoException;

    Usuario buscarUsuario(int id);

    void alterarUsuario(Usuario usuario) throws NoSuchAlgorithmException;
    
    Collection<Usuario> listarUsuario();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Assinaturas para Chamados">
    void inserirChamados(Chamados chamado) throws CampoVazioException;

    Chamados buscarChamados(int id);

    void alterarChamados(Chamados chamado);

    Collection<Chamados> listarChamados();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Assinaturas para LogChamados">
    void inserirLogChamados(LogChamado logChamado) throws CampoVazioException;

    LogChamado buscarLogChamados(int id);

    void alterarLogChamados(LogChamado LogChamado);

    Collection<LogChamado> listarLogChamados();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Assinaturas para Servicos">
    public void inserirServicos(Servicos servicos) 
            throws FormatoInvalidoException, CampoExistenteException, 
                CampoVazioException;

    public Servicos buscarServicos(int id);

    public void alterarServicos(Servicos servicos);

    public Collection<Servicos> listarServicos();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Assinaturas para StatusChamado">
    public void inserirStatusChamado(StatusChamado statusChamado) 
            throws FormatoInvalidoException, CampoExistenteException, 
                CampoVazioException;

    public StatusChamado buscarStatusChamado(int id);

    public void alterarStatusChamado(StatusChamado statusChamado);

    public Collection<StatusChamado> listarStatusChamado();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Assinaturas para TipoChamado">
    public void inserirTipoChamado(TipoChamado tipoChamado) 
            throws FormatoInvalidoException, CampoExistenteException, 
                CampoVazioException;

    public TipoChamado buscarTipoChamado(int id);

    public void alterarTipoChamado(TipoChamado tipoChamado);

    public Collection<TipoChamado> listarTipoChamado();
    //</editor-fold>

}
