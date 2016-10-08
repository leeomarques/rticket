package GUI;

import ClassesBasicas.Modulo;
import Negocio.IFachada;
import Negocio.Fachada;
import ClassesBasicas.*;
import Negocio.*;
import javax.swing.JOptionPane;

public class OSTicket {

    public static void main(String[] args) {
        
        try{
            IFachada fach = new Fachada();
            Modulo mod = new Modulo();
            
            fach.inserirModulo(mod);
            System.out.println("Salvo com Sucesso!!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Favor Preencher todos os Campos!!");
        }
    }  
}