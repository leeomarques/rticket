package com.rticket.negocio;

import com.rticket.excecao.ValidarLoginException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Chamados;
import com.rticket.model.LogChamado;
import com.rticket.model.Modulo;
import com.rticket.model.Perfil;
import com.rticket.model.StatusChamado;
import com.rticket.model.TipoChamado;
import com.rticket.model.Usuario;
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

<<<<<<< HEAD:rticket/src/main/java/com/rticket/negocio/IFachada.java
    void alterarUsuario(Usuario usuario);

=======
    void alterarUsuario(Usuario usuario) throws NoSuchAlgorithmException;
    
>>>>>>> origin:rticket/src/java/com/java/rticket/negocio/IFachada.java
    Collection<Usuario> listarUsuario();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Assinaturas para Chamados">
    void inserirChamados(Chamados chamado) throws CampoVazioException;

    Chamados buscarChamados(int id);

    void alterarChamados(Chamados chamado);

    Collection<Chamados> listarChamados();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Assinaturas para LogChamados">
<<<<<<< HEAD:rticket/src/main/java/com/rticket/negocio/IFachada.java
=======
    void inserirLogChamados(LogChamado logChamado) throws CampoVazioException;

>>>>>>> origin:rticket/src/java/com/java/rticket/negocio/IFachada.java
    LogChamado buscarLogChamados(int id);

    Collection<LogChamado> listarLogChamados();
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
