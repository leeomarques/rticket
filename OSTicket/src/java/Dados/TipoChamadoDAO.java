package Dados;

import ClassesBasicas.TipoChamado;
import DAO.DAOGenerico;
import javax.persistence.EntityManager;

public class TipoChamadoDAO extends DAOGenerico<TipoChamado>{
    
    public TipoChamadoDAO(EntityManager em) {
	super(em);
    }
}
