package Negocio;

import ClassesBasicas.Modulo;
import ClassesBasicas.Perfil;
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
    Collection<Modulo> listarModulo(String sql);
//</editor-fold>
}
