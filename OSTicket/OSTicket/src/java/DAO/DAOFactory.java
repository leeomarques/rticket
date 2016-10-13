package DAO;

import Dados.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAOFactory {

    private static EntityManager manager;
    private static final EntityManagerFactory factory;

    static {
	factory = Persistence.createEntityManagerFactory("dbosticket");
	if (manager == null || !manager.isOpen()) {
            manager = factory.createEntityManager();
	}
    }
    
    public static UsuarioDAO getUsuarioDAO(){
	UsuarioDAO dao = new UsuarioDAO(manager);
	return dao;
    }
    
    public static PerfilDAO getPerfilDAO(){
	PerfilDAO dao = new PerfilDAO(manager);
	return dao;
    }
    
    public static ModuloDAO getModuloDAO(){
	ModuloDAO dao = new ModuloDAO(manager);
	return dao;
    }
}
