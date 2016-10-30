package com.rticket.model;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.negocio.ControladorStatusChamado;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatusChamadoTest {
    
    private ControladorStatusChamado controladorSChamado = new ControladorStatusChamado();
    private StatusChamado statusChamado = new StatusChamado();
    private Collection<StatusChamado> colecaoSChamado = new ArrayList();
    
    public StatusChamadoTest() {
        
    }
    
    @Before
    public void setUp() {
        
    }

    @Test
    public void verificarCaracteres(){
        
        boolean resultado = false;
        String nome = "Novo";

        resultado = controladorSChamado.verificarCaracteres(nome);

        Assert.assertEquals(true, resultado);
    }

    @Test
    public void buscarNome(){
        
        String nome = "novo";
        boolean resultado = false;
        
        resultado = controladorSChamado.buscarNome(nome);
        
        Assert.assertEquals(true, resultado);       
    }

    @Test
    public void inserirStatusChamado(){
         
        try {
            statusChamado.setNome("EmAndamento");
            boolean resultado = false;
            
            controladorSChamado.inserirStatusChamado(statusChamado);
            
            resultado = controladorSChamado.buscarNome(statusChamado.getNome());
            
            Assert.assertEquals(true, resultado);
            
        } catch (FormatoInvalidoException ex) {
            Logger.getLogger(TipoChamadoTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CampoExistenteException ex) {
            Logger.getLogger(TipoChamadoTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CampoVazioException ex) {
            Logger.getLogger(TipoChamadoTest.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    @Test
    public void buscarStatusChamado() {
        int id = 1;
        boolean resultado = false;
        
        statusChamado = controladorSChamado.buscarStatusChamado(id);
        
        if(statusChamado != null){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void alterarStatusChamado() {

        statusChamado.setId(1);
        statusChamado.setNome("Novo");
        statusChamado.setAtivo("I");
        StatusChamado statusChamadoResul = new StatusChamado();
        boolean resultado = false;
        
        controladorSChamado.alterarStatusChamado(statusChamado);
        
        statusChamadoResul = controladorSChamado.buscarStatusChamado(1);
        
        if(statusChamadoResul.getNome().equals(statusChamado.getNome())){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void listarStatusChamado() {
        
        boolean resultado = false;
        colecaoSChamado = controladorSChamado.listarStatusChamado();
        
        if(colecaoSChamado != null){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }
}