package Dados;

import ClassesBasicas.Perfil;
import DAO.DAOGenerico;
import javax.persistence.EntityManager;

public class PerfilDAO extends DAOGenerico<Perfil>{
    
    public PerfilDAO(EntityManager em) {
	super(em);
    }
}