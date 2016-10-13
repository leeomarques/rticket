package Dados;

import ClassesBasicas.Chamados;
import DAO.DAOGenerico;
import javax.persistence.EntityManager;

public class ChamadosDAO extends DAOGenerico<Chamados>{
    
    public ChamadosDAO(EntityManager em) {
	super(em);
    }
}
