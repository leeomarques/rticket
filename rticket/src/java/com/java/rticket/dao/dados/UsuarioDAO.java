package com.java.rticket.dao.dados;

import com.java.rticket.model.Usuario;
import com.java.rticket.dao.DAOGenerico;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsuarioDAO extends DAOGenerico<Usuario>{
    Collection<Usuario> user = new ArrayList();
    
    public UsuarioDAO(EntityManager em) {
	super(em);
    }
    
    public Boolean buscarLogin(String login){
        String sql;
        Boolean verificaLogin = false;
        sql = ("SELECT u FROM Usuario u WHERE u.login = :login");
        Query q = getEntityManager().createQuery(sql, Usuario.class);
        q.setParameter("login", login);
        user = q.getResultList();
        if (user.isEmpty()){
            verificaLogin = true;
        }      
        return verificaLogin;
    }
    
    public Boolean efetuarLogin(String login, String senha){
        String sql;
        Boolean verificaLogin = false;
        sql = ("SELECT u FROM Usuario u WHERE u.login = :usuarioLogin and u.senha = :usuarioSenha");
        Query q = getEntityManager().createQuery(sql, Usuario.class);
        q.setParameter("usuarioLogin", login);
        q.setParameter("usuarioSenha", senha);
        user = q.getResultList();
        if (user.isEmpty()){
            verificaLogin = true;
        }      
        return verificaLogin;
    }
}