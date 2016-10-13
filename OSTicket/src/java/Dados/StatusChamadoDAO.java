package Dados;

import ClassesBasicas.StatusChamado;
import DAO.DAOGenerico;
import javax.persistence.EntityManager;

public class StatusChamadoDAO extends DAOGenerico<StatusChamado>{
    
    public StatusChamadoDAO(EntityManager em) {
	super(em);
    }
}
