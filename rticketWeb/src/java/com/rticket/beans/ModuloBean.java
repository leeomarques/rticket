package com.rticket.beans;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Modulo;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.util.Collection;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "moduloBean")
public class ModuloBean {
    
    IFachada fach = new Fachada();
    
    public void inserirModulo(Modulo modulo)
            throws CampoExistenteException, FormatoInvalidoException,
                CampoVazioException {
        fach.inserirModulo(modulo);
    }

    public Modulo buscarModulo(int id) {
        return fach.buscarModulo(id);
    }

    public void alterarModulo(Modulo modulo) {
        fach.alterarModulo(modulo);
    }

    public Collection<Modulo> listarModulo() {
        return fach.listarModulo();
    }
}
