package com.java.rticket.dao.dados;

import com.java.rticket.model.Perfil;
import com.java.rticket.dao.DAOGenerico;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PerfilDAO extends DAOGenerico<Perfil>{
    
    Collection<Perfil> perfil = new ArrayList();
    
    public PerfilDAO(EntityManager em) {
	super(em);
    }
    
    public Boolean buscarPerfilNome(String nome){
        String sql;
        Boolean verificaNome = false;
        sql = ("SELECT p FROM Perfil p WHERE p.nome = :nomePerfil");
        Query q = getEntityManager().createQuery(sql, Perfil.class);
        q.setParameter("nomePerfil", nome);
        perfil = q.getResultList();
        if (perfil.isEmpty()){
            verificaNome = true;
        }      
        return verificaNome;
    }
}