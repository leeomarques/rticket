package com.java.rticket.dao.dados;

import com.java.rticket.model.StatusChamado;
import com.java.rticket.dao.DAOGenerico;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class StatusChamadoDAO extends DAOGenerico<StatusChamado>{
    
    Collection<StatusChamado> statusChamados = new ArrayList();
    
    public StatusChamadoDAO(EntityManager em) {
	super(em);
    }
    
    public Boolean buscarNome(String nome){
        String sql;
        Boolean verificaNome = false;
        sql = ("SELECT m FROM StatusChamado m WHERE m.nome = :nome");
        Query q = getEntityManager().createQuery(sql, StatusChamado.class);
        q.setParameter("nome", nome);
        statusChamados = q.getResultList();
        if (statusChamados.isEmpty()){
            verificaNome = true;
        }      
        return verificaNome;
    }
}
