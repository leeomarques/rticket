package com.rticket.negocio;

import com.rticket.model.TipoChamado;
import com.rticket.dao.DAOFactory;
import com.rticket.dao.dados.TipoChamadoDAO;
import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorTipoChamado {

    private TipoChamadoDAO tipoChamadoDAO;
    private Boolean resultado;

    public ControladorTipoChamado() {
        tipoChamadoDAO = DAOFactory.getTipoChamadoDAO();
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
        return this.resultado = tipoChamadoDAO.buscarNome(nome);
    }

    //Metodo para Inserir TipoChamado
    public void inserirTipoChamado(TipoChamado tipoChamado)
            throws FormatoInvalidoException, CampoExistenteException,
                CampoVazioException{

        if (tipoChamado.getNome() == null){
            throw new CampoVazioException();
        }

        buscarNome(tipoChamado.getNome());

        if (this.resultado == false){
            throw new CampoExistenteException();
        }

        verificarCaracteres(tipoChamado.getNome());

        if(this.resultado == false){
            throw new FormatoInvalidoException();
        }
        else{
            tipoChamadoDAO.inserir(tipoChamado);
        }
    }

    //Metodo para Buscar o TipoChamado pelo ID
    public TipoChamado buscarTipoChamado(int id){
        return tipoChamadoDAO.buscarPorChave(id);
    }

    //Metodo para Alterar TipoChamado
    public void alterarTipoChamado(TipoChamado tipoChamado){
        tipoChamadoDAO.alterar(tipoChamado);
    }

    //Listar todos os TipoChamado
    public Collection<TipoChamado> listarTipoChamado(){
        return tipoChamadoDAO.listarColecao();
    }
}
