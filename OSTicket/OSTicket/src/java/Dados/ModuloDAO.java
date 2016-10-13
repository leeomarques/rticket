package Dados;

import ClassesBasicas.Modulo;
import DAO.DAOGenerico;
import javax.persistence.EntityManager;

public class ModuloDAO extends DAOGenerico<Modulo>{
    
    public ModuloDAO(EntityManager em) {
	super(em);
    }
}
