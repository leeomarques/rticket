package com.rticket.negocio;

import com.rticket.excecao.ValidarLoginException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.StatusChamado;
import com.rticket.model.Perfil;
import com.rticket.model.Modulo;
import com.rticket.model.Usuario;
import com.rticket.model.LogChamado;
import com.rticket.model.Chamados;
import com.rticket.model.TipoChamado;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

public class Fachada implements IFachada {

    private ControladorModulo        novoModulo;
    private ControladorPerfil        novoPerfil;
    private ControladorUsuario       novoUsuario;
    private ControladorChamados      novoChamado;
    private ControladorLogChamado    novoLogChamado;
    private ControladorStatusChamado novoStatusChamado;
    private ControladorTipoChamado   novoTipoChamado;

    public Fachada() {
        this.novoUsuario       = new ControladorUsuario();
        this.novoPerfil        = new ControladorPerfil();
        this.novoModulo        = new ControladorModulo();
        this.novoChamado       = new ControladorChamados();
        this.novoLogChamado    = new ControladorLogChamado();
        this.novoStatusChamado = new ControladorStatusChamado();
        this.novoTipoChamado   = new ControladorTipoChamado();
    }

    //<editor-fold defaultstate="collapsed" desc="Metodos para Modulos">
    public void inserirModulo(Modulo modulo)
            throws CampoExistenteException, FormatoInvalidoException,
                CampoVazioException {
        this.novoModulo.inserirModulo(modulo);
    }

    public Modulo buscarModulo(int id) {
        return this.novoModulo.buscarModulo(id);
    }

    public void alterarModulo(Modulo modulo) {
        this.novoModulo.alterarModulo(modulo);
    }

    public Collection<Modulo> listarModulo() {
        return novoModulo.listarModulo();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos para Perfis">
    public void inserirPerfil(Perfil perfil)
            throws CampoExistenteException, FormatoInvalidoException,
                CampoVazioException{
        this.novoPerfil.inserirPerfil(perfil);
    }

    public Perfil buscarPerfil(int id) {
        return this.novoPerfil.buscarPerfil(id);
    }

    public void alterarPerfil(Perfil perfil) {
        this.novoPerfil.alterarPerfil(perfil);
    }

    public Collection<Perfil> listarPerfil() {
        return novoPerfil.listarPerfil();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos para Usuarios">
    public Boolean efetuarLogin(String login, String senha)
            throws ValidarLoginException, NoSuchAlgorithmException{
        return this.novoUsuario.efetuarLogin(login, senha);
    }

    public void inserirUsuario(Usuario usuario)
            throws CampoVazioException, CampoExistenteException,
                NoSuchAlgorithmException, FormatoInvalidoException{
        this.novoUsuario.inserirUsuario(usuario);
    }

    public Usuario buscarUsuario(int id) {
        return this.novoUsuario.buscarUsuario(id);
    }

    public void alterarUsuario(Usuario usuario) throws NoSuchAlgorithmException{
        this.novoUsuario.alterarUsuario(usuario);
    }

    public Collection<Usuario> listarUsuario() {
        return novoUsuario.listarUsuario();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos para Chamados">
    public void inserirChamados(Chamados chamado) throws CampoVazioException{
        this.novoChamado.inserirChamados(chamado);
    }

    public Chamados buscarChamados(int id) {
        return this.novoChamado.buscarChamados(id);
    }

    public void alterarChamados(Chamados chamado){
        this.novoChamado.alterarChamados(chamado);
    }

    public Collection<Chamados> listarChamados() {
        return novoChamado.listarChamados();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos para LogChamados">
<<<<<<< HEAD:rticket/src/main/java/com/rticket/negocio/Fachada.java
=======
    public void inserirLogChamados(LogChamado logChamado) 
            throws CampoVazioException{
        this.novoLogChamado.inserirLogChamado(logChamado);
    }

>>>>>>> origin:rticket/src/java/com/java/rticket/negocio/Fachada.java
    public LogChamado buscarLogChamados(int id) {
        return this.novoLogChamado.buscarLogChamado(id);
    }

    public Collection<LogChamado> listarLogChamados() {
        return novoLogChamado.listarLogChamados();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos para StatusChamado">
    public void inserirStatusChamado(StatusChamado statusChamado)
            throws FormatoInvalidoException, CampoExistenteException,
                CampoVazioException{
        this.novoStatusChamado.inserirStatusChamado(statusChamado);
    }

    public StatusChamado buscarStatusChamado(int id) {
        return this.novoStatusChamado.buscarStatusChamado(id);
    }

    public void alterarStatusChamado(StatusChamado statusChamado) {
        this.novoStatusChamado.alterarStatusChamado(statusChamado);
    }

    public Collection<StatusChamado> listarStatusChamado() {
        return novoStatusChamado.listarStatusChamado();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos para TipoChamado">
    public void inserirTipoChamado(TipoChamado tipoChamado)
            throws FormatoInvalidoException, CampoExistenteException,
                CampoVazioException{
        this.novoTipoChamado.inserirTipoChamado(tipoChamado);
    }

    public TipoChamado buscarTipoChamado(int id) {
        return this.novoTipoChamado.buscarTipoChamado(id);
    }

    public void alterarTipoChamado(TipoChamado tipoChamado) {
        this.novoTipoChamado.alterarTipoChamado(tipoChamado);
    }

    public Collection<TipoChamado> listarTipoChamado() {
        return novoTipoChamado.listarTipoChamado();
    }
//</editor-fold>
}
