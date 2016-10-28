package com.rticket.negocio;

import com.rticket.model.StatusChamado;
import com.rticket.dao.DAOFactory;
import com.rticket.dao.dados.StatusChamadoDAO;
import com.rticket.excecao.CampoExistenteException;
import com.rticket.excecao.CampoVazioException;
import com.rticket.excecao.FormatoInvalidoException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControladorStatusChamado {

    private StatusChamadoDAO statusChamadoDAO;
    private Boolean resultado;

    public ControladorStatusChamado() {
        statusChamadoDAO = DAOFactory.getStatusChamadoDAO();
    }

    //Metodo de Verificar Caracteres Especiais
    public Boolean verificarCaracteres(String nome){

        this.resultado = false;
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
        Matcher matcher = pattern.matcher(nome);

        if(matcher.find()){
            this.resultado = true;
        }

        return this.resultado;
    }

    //Metodo para verificar se o nome ja existe no banco
    public Boolean buscarNome(String nome){
        return this.resultado = statusChamadoDAO.buscarNome(nome);
    }

    //Metodo para Inserir StatusChamado
    public void inserirStatusChamado(StatusChamado statusChamado)
            throws FormatoInvalidoException, CampoExistenteException,
                CampoVazioException{

        if (statusChamado.getNome() == null){
            throw new CampoVazioException();
        }

        buscarNome(statusChamado.getNome());

        if (this.resultado == false){
            throw new CampoExistenteException();
        }

        verificarCaracteres(statusChamado.getNome());

        if (this.resultado == false){
            throw new FormatoInvalidoException();
        }
        else{
            statusChamadoDAO.inserir(statusChamado);
        }
    }

    //Metodo para Buscar o StatusChamado pelo ID
    public StatusChamado buscarStatusChamado(int id){
        return statusChamadoDAO.buscarPorChave(id);
    }

    //Metodo para Alterar StatusChamado
    public void alterarStatusChamado(StatusChamado statusChamado){
        statusChamadoDAO.alterar(statusChamado);
    }

    //Listar todos os StatusChamado
    public Collection<StatusChamado> listarStatusChamado(){
        return statusChamadoDAO.listarColecao();
    }
}
