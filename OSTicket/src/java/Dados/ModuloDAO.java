package Dados;

import ClassesBasicas.Modulo;
import DAO.DAOGenerico;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ModuloDAO extends DAOGenerico<Modulo>{
    
    Collection<Modulo> mod = new ArrayList();
    
    public ModuloDAO(EntityManager em) {
	super(em);
    }
    
    public Boolean buscarModuloNome(String nome){
        String sql;
        Boolean verificaNome = false;
        sql = ("SELECT m FROM Modulo m WHERE m.nome = :nomeModulo");
        Query q = getEntityManager().createQuery(sql, Modulo.class);
        q.setParameter("nomeModulo", nome);
        mod = q.getResultList();
        if (mod.isEmpty()){
            verificaNome = true;
        }      
        return verificaNome;
    }
}
