package com.rticket.dao.dados;

import com.rticket.model.Chamados;
import com.rticket.dao.DAOGenerico;
import javax.persistence.EntityManager;

public class ChamadosDAO extends DAOGenerico<Chamados>{

    public ChamadosDAO(EntityManager em) {
	super(em);
    }
}
