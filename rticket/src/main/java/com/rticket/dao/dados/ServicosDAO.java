package com.rticket.dao.dados;

import com.rticket.model.Servicos;
import com.rticket.dao.DAOGenerico;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ServicosDAO extends DAOGenerico<Servicos>{

    Collection<Servicos> servicos = new ArrayList();

    public ServicosDAO(EntityManager em) {
	super(em);
    }

    public Boolean buscarNome(String nome){
        String sql;
        Boolean verificaNome = false;
        sql = ("SELECT m FROM Servicos m WHERE m.nome = :nome");
        Query q = getEntityManager().createQuery(sql, Servicos.class);
        q.setParameter("nome", nome);
        servicos = q.getResultList();
        if (servicos.isEmpty()){
            verificaNome = true;
        }
        return verificaNome;
    }
}
