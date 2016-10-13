package Negocio;

import ClassesBasicas.TipoChamado;
import DAO.DAOFactory;
import Dados.TipoChamadoDAO;

public class ControladorTipoChamado {
    
    private TipoChamadoDAO tipoChamadoDAO;
    
    public ControladorTipoChamado() {
        tipoChamadoDAO = DAOFactory.getTipoChamadoDAO();
    }
    
    //Metodo para Inserir TipoChamado
    public void inserirTipoChamado(TipoChamado tipoChamado){
        tipoChamadoDAO.inserir(tipoChamado);   
    }
    
    //Metodo para Buscar o TipoChamado pelo ID
    public TipoChamado buscarTipoChamado(int id){
        return tipoChamadoDAO.buscarPorChave(id);
    }
    
    //Metodo para Alterar TipoChamado
    public void alterarTipoChamado(TipoChamado tipoChamado){
        tipoChamadoDAO.alterar(tipoChamado);
    }
}
