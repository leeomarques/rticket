package com.rticket.dao;

import com.rticket.dao.dados.UsuarioDAO;
import com.rticket.dao.dados.PerfilDAO;
import com.rticket.dao.dados.TipoChamadoDAO;
import com.rticket.dao.dados.LogChamadoDAO;
import com.rticket.dao.dados.ModuloDAO;
import com.rticket.dao.dados.StatusChamadoDAO;
import com.rticket.dao.dados.ChamadosDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAOFactory {

    private static EntityManager manager;
    private static final EntityManagerFactory factory;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        factory = Persistence.createEntityManagerFactory("dbrticket");
        if (manager == null || !manager.isOpen()) {
            manager = factory.createEntityManager();
        }
    }

    public static ChamadosDAO getChamadosDAO() {
        ChamadosDAO dao = new ChamadosDAO(manager);
        return dao;
    }

    public static LogChamadoDAO getLogChamadoDAO() {
        LogChamadoDAO dao = new LogChamadoDAO(manager);
        return dao;
    }

    public static ModuloDAO getModuloDAO() {
        ModuloDAO dao = new ModuloDAO(manager);
        return dao;
    }

    public static PerfilDAO getPerfilDAO() {
        PerfilDAO dao = new PerfilDAO(manager);
        return dao;
    }

    public static StatusChamadoDAO getStatusChamadoDAO() {
        StatusChamadoDAO dao = new StatusChamadoDAO(manager);
        return dao;
    }

    public static TipoChamadoDAO getTipoChamadoDAO() {
        TipoChamadoDAO dao = new TipoChamadoDAO(manager);
        return dao;
    }

    public static UsuarioDAO getUsuarioDAO() {
        UsuarioDAO dao = new UsuarioDAO(manager);
        return dao;
    }
}
