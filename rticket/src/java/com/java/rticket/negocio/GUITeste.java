package com.java.rticket.negocio;

import com.java.rticket.excecao.CampoVazioException;
import com.java.rticket.excecao.CampoExistenteException;
import com.java.rticket.excecao.FormatoInvalidoException;
import com.java.rticket.excecao.ValidarLoginException;
import com.java.rticket.model.Modulo;
import com.java.rticket.model.Usuario;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class GUITeste {
    public static void main(String[] args) 
            throws FormatoInvalidoException, 
                NoSuchAlgorithmException, ValidarLoginException{
        IFachada fach = new Fachada();
        try{
            Usuario user = new Usuario();
            user.setId(17);
            user.setNome("Teste2");
            user.setLogin("toinhotony1");
            user.setSenha("1234");
            //fach.efetuarLogin("PPYQASW", "Senhssa1");
            fach.alterarUsuario(user);           
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
        /*}catch(CampoVazioException e){
            JOptionPane.showMessageDialog(null, "Preencher todos os campos");
        }catch(CampoExistenteException e){
            JOptionPane.showMessageDialog(null, "Login Existente");
        }catch(FormatoInvalidoException e){
            JOptionPane.showMessageDialog(null, "Formato Invalido");*/
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Login Invalido");
        }
        Iterator<Modulo> iterator;
        
        iterator = fach.listarModulo().iterator();
        
        //Laço para exibir a lista de Modulos.
        while(iterator.hasNext()) {
            Modulo item = (Modulo)iterator.next();
            System.out.println(item.getId()+" "+item.getNome());
        }
    }
}
