package com.java.rticket.model;

import com.java.rticket.negocio.ControladorUsuario;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class UsuarioTest {
    
    Collection<Usuario> colecaoUser;
    Usuario user, user1;
    ControladorUsuario controladorUser;
    
    @Before
    public void setUp() {
        
        colecaoUser = new ArrayList();
        user = new Usuario();
        controladorUser = new ControladorUsuario();
    }
    
    @Test
    public void testverificarCaracteres() {
        
        String nome = "Bruno";
        Boolean resultado;
        resultado = controladorUser.verificarCaracteres(nome);
        
        Assert.assertEquals(true, resultado);
    } 
    
    @Test
    public void efetuarLogin(){
        
        try{
            String login  = "toinhotony";
            String senha = "oioioi";
            Boolean resultado;
            resultado = controladorUser.efetuarLogin(login, senha);
        
            Assert.assertEquals(true, resultado);
        }catch(Exception e){
            Assert.fail();
        }
    }
    
    @Test
    public void buscarLogin(){
        
        String login = "PPYQASW";
        Boolean resultado;
        resultado = controladorUser.buscarLogin(login);
        
        Assert.assertEquals(true, resultado);
    }
    
    @Test
    public void converterSenhaMD5(){
        
        try{
            String senha = "Senha1";
            String senhaMD5 = "be6b9084a5dcdb09af8f433557a2119c";
            String resultado;
            resultado = controladorUser.converterSenhaMD5(senha);
            
            Assert.assertEquals(senhaMD5, resultado);
        }catch(Exception e){
            Assert.fail();
        }
    }

    @Test
    public void inserirUsuario(){
        
        try{
            user.setNome("Teste");
            user.setLogin("teste");
            user.setSenha("oioioi");
            controladorUser.inserirUsuario(user);                   
            
            Assert.assertEquals("Teste", user.getNome());
        }catch(Exception e){
            Assert.fail();
        }
    }
    
    @Test
    public void buscarUsuario(){
        
        int id = 1;
        user = controladorUser.buscarUsuario(id);
        
        Assert.assertEquals(id, user.getId());
    }
    
    @Test
    public void alterarUsuario(){
        
        try{
            String nome = "Antonio Correa";
            user.setId(2);
            user.setNome("Antonio Correa");
            user.setLogin("toinhotony");
            user.setSenha("oioioi");
            controladorUser.alterarUsuario(user);
        
        Assert.assertEquals(nome, user.getNome());
        }catch(Exception e){
            Assert.fail();
        }
    }
    
    @Test
    public void listarUsuario(){
        
        colecaoUser = controladorUser.listarUsuario();
        
        Assert.assertNotNull(colecaoUser);
    }
}
