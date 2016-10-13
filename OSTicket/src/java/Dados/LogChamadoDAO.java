package Dados;

import ClassesBasicas.LogChamado;
import DAO.DAOGenerico;
import javax.persistence.EntityManager;

public class LogChamadoDAO extends DAOGenerico<LogChamado>{
    
    public LogChamadoDAO(EntityManager em) {
	super(em);
    }
}
