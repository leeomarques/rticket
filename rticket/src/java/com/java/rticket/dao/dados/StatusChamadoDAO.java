package com.java.rticket.dao.dados;

import com.java.rticket.model.StatusChamado;
import com.java.rticket.dao.DAOGenerico;
import javax.persistence.EntityManager;

public class StatusChamadoDAO extends DAOGenerico<StatusChamado>{
    
    public StatusChamadoDAO(EntityManager em) {
	super(em);
    }
}
