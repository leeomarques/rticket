package com.java.rticket.dao.dados;

import com.java.rticket.model.TipoChamado;
import com.java.rticket.dao.DAOGenerico;
import javax.persistence.EntityManager;

public class TipoChamadoDAO extends DAOGenerico<TipoChamado>{
    
    public TipoChamadoDAO(EntityManager em) {
	super(em);
    }
}
