package com.rticket.model;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.negocio.ControladorModulo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModuloTest {
    
    private ControladorModulo controladorModulo = new ControladorModulo();
    private Modulo modulo = new Modulo();
    private Collection<Modulo> colecaoModulo = new ArrayList();
    
    public ModuloTest() {
        
    }
    
    @Before
    public void setUp() {
        
    }

    @Test
    public void verificarCaracteres(){

        boolean resultado = false;
        String nome = "Novo";

        resultado = controladorModulo.verificarCaracteres(nome);

        Assert.assertEquals(true, resultado);
    }

    @Test
    public void buscarNome(){
        
        String nome = "novo";
        boolean resultado = false;
        
        resultado = controladorModulo.buscarNome(nome);
        
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void inserirModulo(){

        try {
            modulo.setNome("CadastrarUsuario");
            boolean resultado = false;
            
            controladorModulo.inserirModulo(modulo);
            
            resultado = controladorModulo.buscarNome(modulo.getNome());
            
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
    public void buscarModulo(){
        
        int id = 1;
        boolean resultado = false;
        
        modulo = controladorModulo.buscarModulo(id);
        
        if(modulo != null){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void alterarModulo(){
        
        modulo.setId(1);
        modulo.setNome("Novo");
        modulo.setAtivo("I");
        Modulo moduloResul = new Modulo();
        boolean resultado = false;
        
        controladorModulo.alterarModulo(modulo);
        
        moduloResul = controladorModulo.buscarModulo(1);
        
        if(moduloResul.getNome().equals(modulo.getNome())){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void listarModulo(){
        
        boolean resultado = false;
        colecaoModulo = controladorModulo.listarModulo();
        
        if(colecaoModulo != null){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }   
}