package com.java.rticket.dao.dados;

import com.java.rticket.model.Chamados;
import com.java.rticket.dao.DAOGenerico;
import javax.persistence.EntityManager;

public class ChamadosDAO extends DAOGenerico<Chamados>{
    
    public ChamadosDAO(EntityManager em) {
	super(em);
    }
}
