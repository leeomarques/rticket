package Dados;

import ClassesBasicas.Usuario;
import DAO.DAOGenerico;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsuarioDAO extends DAOGenerico<Usuario>{
    
    public UsuarioDAO(EntityManager em) {
	super(em);
    }
    
    public Boolean buscarLogin(String login){
        String sql;
        Boolean verificaLogin = true;
        sql = ("select u from usuario u where u.nome = " + login);
        Query q = getEntityManager().createQuery(sql, Usuario.class);           
        if (q.getSingleResult() == null){
            verificaLogin = false;
        }      
        return verificaLogin;
    }
}