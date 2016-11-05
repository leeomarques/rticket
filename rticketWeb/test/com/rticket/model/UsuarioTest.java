package com.rticket.model;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.excecao.ValidarLoginException;
import com.rticket.negocio.ControladorUsuario;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
    
    private ControladorUsuario controladorUsuario = new ControladorUsuario();
    private Usuario user = new Usuario();
    private Collection<Usuario> colecaoUser = new ArrayList();
    
    public UsuarioTest() {
        
    }
    
    @Before
    public void setUp() {
        
    }
    
    @Test
    public void verificarCaracteres(){
        
        boolean resultado = false;
        String nome = "Pedro";

        resultado = controladorUsuario.verificarCaracteres(nome);

        Assert.assertEquals(true, resultado);
    }

    @Test
    public void efetuarLogin(){
        
        try {
            String login = "toinho";
            String senha = "1234";
            boolean resultado = false;
        
            resultado = controladorUsuario.efetuarLogin(login, senha);
            if (user != null){
                resultado = true;
            }
        
        Assert.assertEquals(true, resultado);
            
        } catch (ValidarLoginException ex) {
            Assert.fail();
        } catch (NoSuchAlgorithmException ex) {
            Assert.fail();
        }       
    }

    @Test
    public void buscarLogin(){
        
        String login = "toinho";
        boolean resultado = false;
        
        resultado = controladorUsuario.buscarLogin(login);
        
        Assert.assertEquals(true, resultado);       
    }
  
    @Test
    public void converterSenhaMD5(){
 
        try {
            String senha = "1234";
            String senhaConvertida = "81dc9bdb52d04dc20036dbd8313ed055";
            String senhaMD5;
            boolean resultado = false;
       
            senhaMD5 = controladorUsuario.converterSenhaMD5(senha);
            
            if (senhaConvertida.equals(senhaMD5)){
                resultado = true;
            }
                    
            Assert.assertEquals(true, resultado);
                    
        } catch (NoSuchAlgorithmException ex) {
            Assert.fail();
        }    
    }

    @Test
    public void inserirUsuario(){
       
        try {
            user.setNome("Antonio");
            user.setLogin("testetete");
            user.setSenha("1234");
            boolean resultado = false;
            
            controladorUsuario.inserirUsuario(user);
            
            resultado = controladorUsuario.buscarLogin(user.getLogin());
            
            Assert.assertEquals(true, resultado);
            
        } catch (CampoVazioException ex) {
             Assert.fail();
        } catch (CampoExistenteException ex) {
             Assert.fail();
        } catch (NoSuchAlgorithmException ex) {
             Assert.fail();
        } catch (FormatoInvalidoException ex) {
             Assert.fail();
        }      
    }

    @Test
    public void buscarUsuario(){
        
        int id = 1;
        boolean resultado = false;
        
        user = controladorUsuario.buscarUsuario(id);
        
        if(user != null){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void alterarUsuario(){
        
        user.setId(1);
        user.setNome("Antonio Correa de Oliveira");
        user.setLogin("TESTEDD");
        user.setSenha("1234");
        Usuario userResul = new Usuario();
        boolean resultado = false;
        
        controladorUsuario.alterarUsuario(user);
        
        userResul = controladorUsuario.buscarUsuario(1);
        
        if(userResul.getNome().equals(user.getNome())){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }

    @Test
    public void listarUsuario(){
        
        boolean resultado = false;
        colecaoUser = controladorUsuario.listarUsuario();
        
        if(colecaoUser != null){
            resultado = true;
        }
        
        Assert.assertEquals(true, resultado);
    }
}