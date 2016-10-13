package Dados;

import ClassesBasicas.Servicos;
import DAO.DAOGenerico;
import javax.persistence.EntityManager;

public class ServicosDAO extends DAOGenerico<Servicos>{
    
    public ServicosDAO(EntityManager em) {
	super(em);
    }
}
