package com.rticket.model;

import com.rticket.negocio.ControladorLogChamado;
import java.util.ArrayList;
import java.util.Collection;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LogChamadoTest {
    
    private ControladorLogChamado controladorLogChamado = new ControladorLogChamado();
    private LogChamado logChamado = new LogChamado();
    private Collection<LogChamado> colecaoLogChamado = new ArrayList();
    
    public LogChamadoTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void buscarLogChamado(){
        
        int id = 1;
        boolean resultado = false;
        
        logChamado = controladorLogChamado.buscarLogChamado(id);
        
        if(logChamado != null){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void listarLogChamados(){
        
        boolean resultado = false;
        colecaoLogChamado = controladorLogChamado.listarLogChamados();
        
        if(colecaoLogChamado != null){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }
}