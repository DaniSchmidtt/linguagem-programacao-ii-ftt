/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.ec6.crud.basis;

import br.com.comuns.crud.ec6.enums.EntidadesDisponiveis;
import br.com.comuns.crud.ec6.enums.TipoRepositorio;
import br.com.comuns.crud.ec6.vos.acesso.Usuario;
import br.com.dao.ec6.crud.acesso.UsuarioMySQLDAO;
import br.com.dao.ec6.crud.acesso.UsuarioTextoDAO;

/**
 *Classe que retorna os objetos Fábrica do MySQL e do arquivo txt, de acordo com o parametro recebido
 * @author gabriell
 */
public class FabricaDAOs {
    /**
     * Metodo que indica o tipo de conexão a ser utilizada
     * @param enumEntidade
     * @param repositorio
     * @return
     */
    public static DAO Fabrica(EntidadesDisponiveis enumEntidade, TipoRepositorio repositorio) {
        switch (repositorio)
        {
            case TEXTO:
                return montaDAOTexto(enumEntidade);
            case MYSQL:
                return montaDAOMySQL(enumEntidade);
            default:
                return null;
        }
       
    }

    /**
     * Metodo para montar uma DAO de aqrquivo texto
     * @param enumEntidade
     * @return
     */
    private static DAO montaDAOTexto(EntidadesDisponiveis enumEntidade) {
        DAO retorno;
        switch (enumEntidade)
        {
            case USUARIO:
                retorno = new UsuarioTextoDAO();
                break;            
            default:
                retorno = null;
                break;
        }
        return retorno;    
    }

    /**
     * Metodo para montar um DAO de MySQL
     * @param enumEntidade
     * @return
     */
    private static DAO montaDAOMySQL(EntidadesDisponiveis enumEntidade) {
        DAO retorno;
        switch (enumEntidade)
        {
            case USUARIO:
                retorno = new UsuarioMySQLDAO();
                break;            
            default:
                retorno = null;
                break;
        }
        return retorno;    
    }
    
}
