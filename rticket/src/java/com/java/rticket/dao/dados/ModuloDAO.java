package com.java.rticket.dao.dados;

import com.java.rticket.model.Modulo;
import com.java.rticket.dao.DAOGenerico;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ModuloDAO extends DAOGenerico<Modulo>{
    
    Collection<Modulo> mod = new ArrayList();
    
    public ModuloDAO(EntityManager em) {
	super(em);
    }
    
    public Boolean buscarNome(String nome){
        String sql;
        Boolean verificaNome = false;
        sql = ("SELECT m FROM Modulo m WHERE m.nome = :nome");
        Query q = getEntityManager().createQuery(sql, Modulo.class);
        q.setParameter("nome", nome);
        mod = q.getResultList();
        if (mod.isEmpty()){
            verificaNome = true;
        }      
        return verificaNome;
    }
}
