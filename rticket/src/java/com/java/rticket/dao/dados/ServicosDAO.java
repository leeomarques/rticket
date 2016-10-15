package com.java.rticket.dao.dados;

import com.java.rticket.model.Servicos;
import com.java.rticket.dao.DAOGenerico;
import javax.persistence.EntityManager;

public class ServicosDAO extends DAOGenerico<Servicos>{
    
    public ServicosDAO(EntityManager em) {
	super(em);
    }
}
