package com.rticket.dao.dados;

import com.rticket.model.LogChamado;
import com.rticket.dao.DAOGenerico;
import javax.persistence.EntityManager;

public class LogChamadoDAO extends DAOGenerico<LogChamado>{

    public LogChamadoDAO(EntityManager em) {
	super(em);
    }
}
