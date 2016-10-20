package com.rticket.dao.dados;

import com.rticket.model.Chamados;
import com.rticket.dao.DAOGenerico;
import com.rticket.model.LogChamado;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class ChamadosDAO extends DAOGenerico<Chamados>{
    
    public ChamadosDAO(EntityManager em) {
	super(em);
    }
    
    public void inserirChamados(Chamados objeto, LogChamado log) {
       
        EntityTransaction tx = getEntityManager().getTransaction();
        try {
            tx.begin();
            
            getEntityManager().persist(objeto);
            getEntityManager().persist(log);
            
            tx.commit();
        } catch (PersistenceException e) {
            tx.rollback();
        }
    }
    
    public Chamados alterarChamados(Chamados chamado, LogChamado logChamado) {
        
        EntityTransaction tx = getEntityManager().getTransaction();
        try {
            tx.begin();

            chamado = getEntityManager().merge(chamado);
            getEntityManager().persist(logChamado);
        
            tx.commit();
        }catch(PersistenceException e){
            tx.rollback();
        }
        
        return chamado;
    }
}
