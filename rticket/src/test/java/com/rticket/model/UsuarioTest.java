package com.rticket.model;

import com.rticket.negocio.ControladorUsuario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class UsuarioTest {

    ControladorUsuario user;

    @Before
    public void setUp() {
        user = new ControladorUsuario();
    }

    @Test
    public void testverificarCaracteres() {

        String nome = "Bruno";
        Boolean resultado = true;

        resultado = user.verificarCaracteres(nome);

        Assert.assertEquals(true, resultado);
    }

    @Ignore
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
