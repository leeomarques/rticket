package Negocio;

import ClassesBasicas.*;

public class Fachada implements IFachada{
    
    private ControladorUsuario novoUsuario;
    private ControladorPerfil novoPerfil;
    private ControladorModulo novoModulo;
    
    public Fachada() {
        this.novoUsuario = new ControladorUsuario();
        this.novoPerfil = new ControladorPerfil();
        this.novoModulo = new ControladorModulo();
    }
    
    //<editor-fold defaultstate="collapsed" desc="Metodos para Usuarios">
    public void inserirUsuario(Usuario usuario) {
        this.novoUsuario.inserirUsuario(usuario);
    }
    
    public Usuario buscarUsuario(int id){
        return this.novoUsuario.buscarUsuario(id);
    }
    
    public void alterarUsuario(Usuario usuario){
        this.novoUsuario.alterarUsuario(usuario);
    }
//</editor-fold>
  
    //<editor-fold defaultstate="collapsed" desc="Metodos para Perfis">
    public void inserirPerfil(Perfil perfil) {
        this.novoPerfil.inserirPerfil(perfil);
    }
    
    public Perfil buscarPerfil(int id){
        return this.novoPerfil.buscarPerfil(id);
    }
    
    public void alterarPerfil(Perfil perfil){
        this.novoPerfil.alterarPerfil(perfil);
    }
//</editor-fold>
      
    //<editor-fold defaultstate="collapsed" desc="Metodos para Modulos">
    public void inserirModulo(Modulo modulo) {
        this.novoModulo.inserirModulo(modulo);
    }
    
    public Modulo buscarModulo(int id){
        return this.novoModulo.buscarModulo(id);
    }
    
    public void alterarModulo(Modulo modulo){
        this.novoModulo.alterarModulo(modulo);
    }
//</editor-fold>
   
}
