package com.rticket.beans;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.TipoChamado;
import com.rticket.negocio.Fachada;
import com.rticket.negocio.IFachada;
import java.util.Collection;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "tipoChamadoBean")
public class TipoChamadoBean {
    
    IFachada fach = new Fachada();
    
    public void inserirTipoChamado(TipoChamado tipoChamado)
            throws FormatoInvalidoException, CampoExistenteException,
                CampoVazioException{
        fach.inserirTipoChamado(tipoChamado);
    }

    public TipoChamado buscarTipoChamado(int id) {
        return fach.buscarTipoChamado(id);
    }

    public void alterarTipoChamado(TipoChamado tipoChamado) {
        fach.alterarTipoChamado(tipoChamado);
    }

    public Collection<TipoChamado> listarTipoChamado() {
        return fach.listarTipoChamado();
    }
}
