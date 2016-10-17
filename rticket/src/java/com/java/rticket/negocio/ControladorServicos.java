package com.java.rticket.negocio;

import com.java.rticket.model.Servicos;
import com.java.rticket.dao.DAOFactory;
import com.java.rticket.dao.dados.ServicosDAO;
import com.java.rticket.excecao.CampoExistenteException;
import com.java.rticket.excecao.CampoVazioException;
import com.java.rticket.excecao.FormatoInvalidoException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorServicos {
    
    private ServicosDAO servicosDAO;
    private Boolean resultado;
    
    public ControladorServicos() {
        servicosDAO = DAOFactory.getServicosDAO();
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
        return this.resultado = servicosDAO.buscarNome(nome);
    }
    
    //Metodo para Inserir Servicos
    public void inserirServicos(Servicos servicos) 
            throws FormatoInvalidoException, CampoExistenteException, 
                CampoVazioException{
        
        if (servicos.getNome() == null){
            throw new CampoVazioException(); 
        }
                
        buscarNome(servicos.getNome());
        
        if (this.resultado == false){
            throw new CampoExistenteException();
        }
        
        verificarCaracteres(servicos.getNome());
        
        if(this.resultado == false){
            
        }
        else{
            servicosDAO.inserir(servicos);
        }
    }
    
    //Metodo para Buscar o Servicos pelo ID
    public Servicos buscarServicos(int id){
        return servicosDAO.buscarPorChave(id);
    }
    
    //Metodo para Alterar Servicos
    public void alterarServicos(Servicos servicos){
        servicosDAO.alterar(servicos);
    }
    
    //Listar todos os Servicos
    public Collection<Servicos> listarServicos(){
        return servicosDAO.listarColecao();
    }
}
