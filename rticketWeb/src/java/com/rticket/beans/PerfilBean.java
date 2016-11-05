package com.rticket.beans;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Perfil;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.util.Collection;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "perfilBean")
public class PerfilBean {
    
    IFachada fach = new Fachada();
    
    public void inserirPerfil(Perfil perfil)
            throws CampoExistenteException, FormatoInvalidoException,
                CampoVazioException{
        fach.inserirPerfil(perfil);
    }

    public Perfil buscarPerfil(int id) {
        return fach.buscarPerfil(id);
    }

    public void alterarPerfil(Perfil perfil) {
        fach.alterarPerfil(perfil);
    }

    public Collection<Perfil> listarPerfil() {
        return fach.listarPerfil();
    }
}
