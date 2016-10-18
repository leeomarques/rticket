package com.java.rticket.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * PSC
 *
 * @param <Entidade, PK>
 */
public abstract class DAOGenerico<Entidade> {

    private EntityManager entityManager;
    private Class<Entidade> classePersistente;

    @SuppressWarnings("unchecked")
    public DAOGenerico(EntityManager em) {
        this.setEntityManager(em);
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        classePersistente = (Class<Entidade>) parameterizedType.getActualTypeArguments()[0];
    }

    /**
     * Executa o merge do objeto que se encontra em memória.
     *
     * @param objeto a ser realizado o merge
     * @return objeto que foi executado o merge
     */
    public void alterar(Entidade objeto) {

        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();

        getEntityManager().merge(objeto);

        tx.commit();
    }

    /**
     * Salva o objeto atual na base de dados.
     *
     * @param objeto a ser salvo
     */
    public void inserir(Entidade objeto) {
        EntityTransaction tx = getEntityManager().getTransaction();
        try {
            tx.begin();
            getEntityManager().persist(objeto);
            tx.commit();
        } catch (PersistenceException e) {
            tx.rollback();
        }
    }

    /**
     * Salva o objeto atual na base de dados.
     *
     * @param objeto a ser salvo
     */
    public final void inserirColecao(Collection<Entidade> colecao) {
        try {
            EntityTransaction tx = getEntityManager().getTransaction();
            tx.begin();

            for (Entidade entidade : colecao) {
                getEntityManager().persist(entidade);
            }

            tx.commit();

            System.out.println(classePersistente.getSimpleName() + " salvos com sucesso: " + colecao.size());
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }
    
    //Listar Colecao
    public final Collection<Entidade> listarColecao(){
        Collection<Entidade> colecao = null;
        String sql = "";
        sql = ("select m from " + getClassePersistente().getName() +" m");
        try {
            Query q = getEntityManager().createQuery(sql, getClassePersistente());           
            colecao = q.getResultList();
        } catch (RuntimeException re) {
            re.printStackTrace();
        }
        return colecao;
    }
    /**
     * Remove o objeto da base de dados.
     *
     * @param objeto a ser removido
     */
    public final void remover(Entidade objeto) {
        EntityTransaction tx = getEntityManager().getTransaction();
        tx.begin();

        // Este merge foi incluido para permitir a exclusao de objetos no estado Detached
        objeto = getEntityManager().merge(objeto);

        getEntityManager().remove(objeto);

        tx.commit();

        System.out.println(classePersistente.getSimpleName() + " removido com sucesso");
    }

    /**
     * Busca o objeto uma vez passado sua chave como parâmetro.
     *
     * @param chave identificador
     * @return Objeto do tipo T
     */
    public final Entidade buscarPorChave(Serializable chave) {
        Entidade instance = null;
        try {
            instance = (Entidade) getEntityManager().find(getClassePersistente(), chave);
        } catch (RuntimeException re) {
            re.printStackTrace();
        }
        return instance;
    }

    /**
     * Atualiza o objeto que se encontra em memória.
     *
     * @param object objeto a ser atualizado
     */
    public final void refresh(Entidade object) {
        getEntityManager().refresh(object);
    }

    /**
     * Utilizado para se injetar o Entity manager no DAO.
     *
     * @param entityManager entity manager
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Busca a classe persistente do objeto utilizado na classe.
     *
     * @return classe persistente
     */
    protected final Class<Entidade> getClassePersistente() {
        return classePersistente;
    }
}
