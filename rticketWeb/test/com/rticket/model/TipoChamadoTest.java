package com.rticket.model;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.negocio.ControladorTipoChamado;
import com.rticket.negocio.ControladorUsuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TipoChamadoTest {
    
    private ControladorTipoChamado controladorTChamado = new ControladorTipoChamado();
    private TipoChamado tipoChamado = new TipoChamado();
    private Collection<TipoChamado> colecaoTChamado = new ArrayList();
    
    public TipoChamadoTest() {
        
    }
    
    @Before
    public void setUp() {
        
    }
    
    @Test
    public void verificarCaracteres(){
        
        boolean resultado = false;
        String nome = "Novo";

        resultado = controladorTChamado.verificarCaracteres(nome);

        Assert.assertEquals(true, resultado);
    }

    @Test
    public void buscarNome(){
        
        String nome = "novo";
        boolean resultado = false;
        
        resultado = controladorTChamado.buscarNome(nome);
        
        Assert.assertEquals(true, resultado);       
    }

    @Test
    public void inserirTipoChamado(){
         
        try {
            tipoChamado.setNome("Em Andamento");
            boolean resultado = false;
            
            controladorTChamado.inserirTipoChamado(tipoChamado);
            
            resultado = controladorTChamado.buscarNome(tipoChamado.getNome());
            
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
    public void buscarTipoChamado() {
        int id = 1;
        boolean resultado = false;
        
        tipoChamado = controladorTChamado.buscarTipoChamado(id);
        
        if(tipoChamado != null){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void alterarTipoChamado() {

        tipoChamado.setId(2);
        tipoChamado.setNome("Novo");
        tipoChamado.setAtivo("I");
        TipoChamado tipoChamadoResul = new TipoChamado();
        boolean resultado = false;
        
        controladorTChamado.alterarTipoChamado(tipoChamado);
        
        tipoChamadoResul = controladorTChamado.buscarTipoChamado(2);
        
        if(tipoChamadoResul.getNome().equals(tipoChamado.getNome())){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void listarTipoChamado() {
        
        boolean resultado = false;
        colecaoTChamado = controladorTChamado.listarTipoChamado();
        
        if(colecaoTChamado != null){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }   
}