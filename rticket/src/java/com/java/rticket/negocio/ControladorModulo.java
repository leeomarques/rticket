package com.java.rticket.negocio;

import com.java.rticket.excecao.CampoExistenteException;
import com.java.rticket.model.Modulo;
import com.java.rticket.dao.DAOFactory;
import com.java.rticket.dao.dados.ModuloDAO;
import com.java.rticket.excecao.CampoVazioException;
import com.java.rticket.excecao.FormatoInvalidoException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorModulo {
    
    private ModuloDAO moduloDAO;
    private Boolean resultado;
    
    public ControladorModulo() {
        moduloDAO = DAOFactory.getModuloDAO();
    }
    
    //Metodo de Verificar Caracteres Especiais
    public Boolean verificarCaracteres(String nome){
        
        this.resultado = false;
        Pattern pattern = Pattern.compile("[A-Z][a-z]{1,}");
        Matcher matcher = pattern.matcher(nome);
        
        if(matcher.find()){
            this.resultado = true;
        }
        
        return this.resultado;
    }
    
    //Metodo para verificar se o nome ja existe no banco
    public Boolean buscarNome(String nome){
        return this.resultado = moduloDAO.buscarNome(nome);
    }
    
    //Metodo para Inserir Modulo
    public void inserirModulo(Modulo modulo) 
            throws CampoExistenteException, FormatoInvalidoException, 
                CampoVazioException{
        
        if (modulo.getNome() == null){
            throw new CampoVazioException(); 
        }
        
        buscarNome(modulo.getNome());
        
        if (this.resultado == false){
            throw new CampoExistenteException();
        }
        
        verificarCaracteres(modulo.getNome());
        
        if(this.resultado == false){
            throw new FormatoInvalidoException();
        }
        else{
            moduloDAO.inserir(modulo);
        }   
    }
    
    //Metodo para Buscar o Modulo pelo ID
    public Modulo buscarModulo(int id){
        return moduloDAO.buscarPorChave(id);
    }
    
    //Metodo para Alterar Modulo
    public void alterarModulo(Modulo modulo){
        moduloDAO.alterar(modulo);
    }
    
    //Listar todos os Modulos
    public Collection<Modulo> listarModulo(){
        return moduloDAO.listarColecao();
    }
}
