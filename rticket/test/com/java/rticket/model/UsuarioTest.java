/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.rticket.model;

import com.java.rticket.negocio.ControladorUsuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 *
 * @author TI-ANTONIO
 */
public class UsuarioTest {
    
    ControladorUsuario user;
    
    @Before
    public void setUp() {
        user = new ControladorUsuario();
    }
    
    @Test
    public void testverificarCaracteres() {
        
        String nome = "Bruno";
        Boolean resultado;
        
        resultado = user.verificarCaracteres(nome);
        
        Assert.assertEquals(true, resultado);
    } 
    
    @Test
    public void efetuarLogin(){
        
        try{
            String login  = "PPYQASW";
            String senha = "Senha1";
            Boolean resultado = false;
        
            resultado = user.efetuarLogin(login, senha);
        
            Assert.assertEquals(false, resultado);
        }catch(Exception e){
            Assert.fail();
        }
    }
}
