package Dados;

import ClassesBasicas.Usuario;
import DAO.DAOGenerico;
import javax.persistence.EntityManager;

public class UsuarioDAO extends DAOGenerico<Usuario>{
    
    public UsuarioDAO(EntityManager em) {
	super(em);
    }
}