package com.java.rticket.dao.dados;

import com.java.rticket.model.LogChamado;
import com.java.rticket.dao.DAOGenerico;
import javax.persistence.EntityManager;

public class LogChamadoDAO extends DAOGenerico<LogChamado>{
    
    public LogChamadoDAO(EntityManager em) {
	super(em);
    }
}
