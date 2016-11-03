package com.rticket.model;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.negocio.ControladorChamados;
import com.rticket.negocio.ControladorUsuario;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChamadosTest {
    
    private ControladorChamados controladorChamados = new ControladorChamados();
    private Chamados chamado = new Chamados();
    private Collection<Chamados> colecaoChamados = new ArrayList();
    
    public ChamadosTest() {
        
    }
    
    @Before
    public void setUp() {
        
    }
    
    @Test
    public void inserirChamados(){
        
        try {
            Date dt = new Date();
            chamado.setDataCriacao(dt);
            chamado.setTitulo("Chamado Teste");
            chamado.setDescricao("Nao estou conseguindo emitir nota fiscal.");

            StatusChamado statusChamado = new StatusChamado();
            statusChamado.setId(1);       
            chamado.setStatusChamado(statusChamado);

            TipoChamado tipoChamado = new TipoChamado();
            tipoChamado.setId(1);
            chamado.setTipoChamado(tipoChamado);

            Usuario user = new Usuario();
            user.setId(1);
            chamado.setUsuarios(user);

            boolean resultado = false;
            
        
            controladorChamados.inserirChamados(chamado);
            
            chamado.setId(1);
        
            chamado = controladorChamados.buscarChamados(chamado.getId());
        
            if(chamado != null){
                resultado = true;
            }
            
            Assert.assertEquals(true, resultado); 
            
        } catch (CampoVazioException ex) {
            Assert.fail();
        }
        
              
    }

    @Test
    public void buscarChamados(){
        
        int id = 1;
        boolean resultado = false;
        
        chamado = controladorChamados.buscarChamados(id);
        
        if(chamado != null){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void alterarChamados(){
        
        Date dt = new Date();
        chamado.setId(2);
        chamado.setTitulo("Chamado Teste");
        chamado.setDescricao("Nao Teste Teste.");
        
        StatusChamado statusChamado = new StatusChamado();
        statusChamado.setId(2);       
        chamado.setStatusChamado(statusChamado);
        
        TipoChamado tipoChamado = new TipoChamado();
        tipoChamado.setId(1);
        chamado.setTipoChamado(tipoChamado);
        
        Usuario user = new Usuario();
        user.setId(2);
        chamado.setUsuarios(user);  
        
        boolean resultado = false;
        
        controladorChamados.alterarChamados(chamado);
        
        chamado = controladorChamados.buscarChamados(2);
        
        if (chamado.getStatusChamados().getId() == 2){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void listarChamados(){
        
        boolean resultado = false;
        colecaoChamados = controladorChamados.listarChamados();
        
        if(colecaoChamados != null){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }
}
