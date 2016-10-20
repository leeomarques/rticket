package com.rticket.negocio;

import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import com.rticket.model.Chamados;
import com.rticket.model.StatusChamado;
import com.rticket.model.TipoChamado;
import com.rticket.model.Usuario;
import java.util.Date;
import javax.swing.JOptionPane;

public class GUITeste {
    public static void main(String[] args) 
            throws FormatoInvalidoException, CampoExistenteException{
        try{
        IFachada fach = new Fachada();
        IFachada fach1 = new Fachada();
        IFachada fach2 = new Fachada();
        IFachada fach3 = new Fachada();
        Chamados cham = new Chamados();
        StatusChamado statusChamado = new StatusChamado();
        TipoChamado tipoChamado = new TipoChamado();
        Usuario user = new Usuario();
        Date dt = new Date();
        
            tipoChamado.setId(1);
//            tipoChamado.setNome("TESTE");
//            fach.inserirTipoChamado(tipoChamado);
            statusChamado.setId(1);
//            statusChamado.setNome("TESTE");
            statusChamado.setFinaliza("S");
//            fach1.inserirStatusChamado(statusChamado);
            user.setId(1);
//            user.setNome("TESTEFSDF");
//            user.setLogin("TESTEDD");
//            user.setSenha("1234");
//            fach2.inserirUsuario(user);
            cham.setId(1);
            cham.setDataCriacao(dt);
            cham.setPrioridade("Alta");
            cham.setResposta("Testando Resposta");
            cham.setNotaChamado(3);
            cham.setDescricao("Teste Descricao51");
            cham.setTitulo("Teste Titulo51");
            cham.setTipoChamado(tipoChamado);
            cham.setStatusChamado(statusChamado);
            cham.setUsuarios(user);
            cham.setResposta("sfsdfkasdfsdhfjasdhfjkshbhvfjshf sffjkshfcasjk fhsdkjfhcsjkhfcasjkf hsjkcfhj");
//            fach3.inserirChamados(cham);
            fach3.alterarChamados(cham);
        /*}catch(CampoVazioException e){
            JOptionPane.showMessageDialog(null, "Para fechar o chamado tem que informar a resposta e a nota");*/
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        /*try{
            Usuario user = new Usuario();
            user.setNome("Yanne");
            user.setLogin("PPPYQASW");
            user.setSenha("Senhssa1");
            fach.efetuarLogin("PPYQASW", "Senhssa1");
            fach.inserirUsuario(user);
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
        }catch(CampoVazioException e){
            JOptionPane.showMessageDialog(null, "Preencher todos os campos");
        }catch(CampoExistenteException e){
            JOptionPane.showMessageDialog(null, "Login Existente");
        }catch(FormatoInvalidoException e){
            JOptionPane.showMessageDialog(null, "Formato Invalido");
        }catch(ValidarLoginException e){
            JOptionPane.showMessageDialog(null, "Login Invalido");
        }

         Iterator<Modulo> iterator;
        
         iterator = fach.listarModulo().iterator();
        
        Laço para exibir a lista de Modulos.
         while(iterator.hasNext()) {
             Modulo item = (Modulo)iterator.next();
             System.out.println(item.getId()+" "+item.getNome());
         }*/
    }
}
