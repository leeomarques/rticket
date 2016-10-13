package Negocio;

import ClassesBasicas.Modulo;
import java.util.Iterator;

public class GUITeste {
    public static void main(String[] args){
        IFachada fach = new Fachada();
        
        Iterator<Modulo> iterator;
        String sql = ("select m from Modulo m");
        iterator = fach.listarModulo(sql).iterator();
        
        //Laço para exibir a lista de Modulos.
        while(iterator.hasNext()) {
            Modulo item = (Modulo)iterator.next();
            System.out.println(item.getId()+" "+item.getNome());
        }      
    }
}
