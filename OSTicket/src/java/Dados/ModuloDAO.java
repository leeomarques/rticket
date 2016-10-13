package Dados;

import ClassesBasicas.Modulo;
import DAO.DAOGenerico;
import javax.persistence.EntityManager;

public class ModuloDAO extends DAOGenerico<Modulo>{
    
    public ModuloDAO(EntityManager em) {
	super(em);
    }
    
    /*public Collection<Modulo> listarModulo(){
        
        Collection<Modulo> mod = new ArrayList();
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dbosticket");
        EntityManager manager = factory.createEntityManager();
        
        String sql = ("select m from Modulo m");
        Query q = manager.createQuery(sql, Modulo.class);
        
        mod = q.getResultList();

        return mod;
    }*/
}
