package com.rticket.model;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.negocio.ControladorPerfil;
import java.util.ArrayList;
import java.util.Collection;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class PerfilTest {
    
    private ControladorPerfil controladorPerfil = new ControladorPerfil();
    private Perfil perfil = new Perfil();
    private Collection<Perfil> colecaoPerfil = new ArrayList();
    
    public PerfilTest() {
        
    }
    
    @Before
    public void setUp() {
        
    }

    @Test
    public void verificarCaracteres(){

        boolean resultado = false;
        String nome = "Novo";

        resultado = controladorPerfil.verificarCaracteres(nome);

        Assert.assertEquals(true, resultado);
    }

    @Test
    public void buscarNome(){
        
        String nome = "novo";
        boolean resultado = false;
        
        resultado = controladorPerfil.buscarNome(nome);
        
        Assert.assertEquals(true, resultado);
    }
    
    @Test
    public void inserirPerfil(){
    
        try {
            perfil.setNome("CadastrarUsuario");

            boolean resultado = false;
            
            controladorPerfil.inserirPerfil(perfil);
            
            resultado = controladorPerfil.buscarNome(perfil.getNome());
            
            Assert.assertEquals(true, resultado);
            
        } catch (FormatoInvalidoException ex) {
            Assert.fail();
        } catch (CampoExistenteException ex) {
            Assert.fail();
        } catch (CampoVazioException ex) {
            Assert.fail();
        }        
    }

    @Test
    public void buscarPerfil(){
        
        int id = 1;
        boolean resultado = false;
        
        perfil = controladorPerfil.buscarPerfil(id);
        
        if(perfil != null){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void alterarPerfil(){
        
        perfil.setId(1);
        perfil.setNome("Novo");
        perfil.setAtivo("I");
        Perfil perfilResul = new Perfil();
        boolean resultado = false;
        
        controladorPerfil.alterarPerfil(perfil);
        
        perfilResul = controladorPerfil.buscarPerfil(1);
        
        if(perfilResul.getNome().equals(perfil.getNome())){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void listarPerfil(){
        
        boolean resultado = false;
        colecaoPerfil = controladorPerfil.listarPerfil();
        
        if(colecaoPerfil != null){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }
}