package Negocio;

import ClassesBasicas.*;
import Excecoes.*;
import static Negocio.ControladorUsuario.*;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

public class Fachada implements IFachada {

    private ControladorModulo        novoModulo;
    private ControladorPerfil        novoPerfil;
    private ControladorUsuario       novoUsuario; 
    private ControladorChamados      novoChamado;
    private ControladorLogChamado    novoLogChamado;
    private ControladorServicos      novoServico;
    private ControladorStatusChamado novoStatusChamado;
    private ControladorTipoChamado   novoTipoChamado;

    public Fachada() {
        this.novoUsuario       = new ControladorUsuario();
        this.novoPerfil        = new ControladorPerfil();
        this.novoModulo        = new ControladorModulo();
        this.novoChamado       = new ControladorChamados();
        this.novoLogChamado    = new ControladorLogChamado();
        this.novoServico       = new ControladorServicos();
        this.novoStatusChamado = new ControladorStatusChamado();
        this.novoTipoChamado   = new ControladorTipoChamado();
    }

    //<editor-fold defaultstate="collapsed" desc="Metodos para Modulos">
    public void inserirModulo(Modulo modulo) throws CampoExistenteException {
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
    public void inserirPerfil(Perfil perfil) throws CampoExistenteException{
        this.novoPerfil.inserirPerfil(perfil);
    }

    public Perfil buscarPerfil(int id) {
        return this.novoPerfil.buscarPerfil(id);
    }

    public void alterarPerfil(Perfil perfil) {
        this.novoPerfil.alterarPerfil(perfil);
    }
//</editor-fold>
    
    public Boolean efetuarLogin(String login, String senha) throws ValidarLoginException, NoSuchAlgorithmException{
        return this.novoUsuario.efetuarLogin(login, senha);
    }
    
    //<editor-fold defaultstate="collapsed" desc="Metodos para Usuarios">
    public void inserirUsuario(Usuario usuario) throws CampoVazioException, CampoExistenteException, NoSuchAlgorithmException{
        this.novoUsuario.inserirUsuario(usuario);
    }

    public Usuario buscarUsuario(int id) {
        return this.novoUsuario.buscarUsuario(id);
    }

    public void alterarUsuario(Usuario usuario) {
        this.novoUsuario.alterarUsuario(usuario);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos para Chamados">
    public void inserirChamados(Chamados chamado) {
        this.novoChamado.inserirChamados(chamado);
    }

    public Chamados buscarChamados(int id) {
        return this.novoChamado.buscarChamados(id);
    }

    public void alterarChamados(Chamados chamado) {
        this.novoChamado.alterarChamados(chamado);
    }

    public Collection<Chamados> listarChamados() {
        return novoChamado.listarChamados();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos para LogChamados">
    public void inserirLogChamados(LogChamado logChamado) {
        this.novoLogChamado.inserirLogChamado(logChamado);
    }

    public LogChamado buscarLogChamados(int id) {
        return this.novoLogChamado.buscarLogChamado(id);
    }

    public void alterarLogChamados(LogChamado LogChamado) {
        this.novoLogChamado.alterarLogChamado(LogChamado);
    }

    public Collection<LogChamado> listarLogChamados() {
        return novoLogChamado.listarLogChamados();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos para Servicos">
    public void inserirServicos(Servicos servicos) {
        this.novoServico.inserirServicos(servicos);
    }

    public Servicos buscarServicos(int id) {
        return this.novoServico.buscarServicos(id);
    }

    public void alterarServicos(Servicos servicos) {
        this.novoServico.alterarServicos(servicos);
    }

    public Collection<Servicos> listarServicos() {
        return novoServico.listarServicos();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos para StatusChamado">
    public void inserirStatusChamado(StatusChamado statusChamado) {
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
    public void inserirTipoChamado(TipoChamado tipoChamado) {
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
