/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.ec6.crud.produto;

import br.com.comuns.crud.ec6.vos.conteudo.Produto;
import br.com.comuns.ec6.crud.basis.Entidade;
import br.com.dao.ec6.crud.basis.MySQLDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe especifica para retornar dados do produto
 * @author gabriell
 * @param <E>
 */
public class ProdutoMySQLDAO <E extends Entidade> extends MySQLDAO {
    
    public ProdutoMySQLDAO() {
        super(Produto.class);
    }

    /**
     * Método para localizar um produto pelo código sobreescrendo o metodo Localiza
     * @param codigo
     * @return
     * @throws SQLException
     */
    @Override
    public E localiza(String codigo) throws SQLException {
        return (E)super.localiza(codigo);
    }

    /**
     * Metodo para localizar um produto pelo código
     * @return
     */
    @Override
    protected String getLocalizaCommand() {
        return "select * from tbProduto where cod_pro = ?";
    }

    /**
     * Metodo para preencher um objeto com os dados do banco
     * @param rs
     * @return
     */
    @Override
    protected E preencheEntidade(ResultSet rs) {
        Produto entidade = (Produto)super.getInstanceOfE();
        try {
            entidade.setId(rs.getInt("cod_pro"));
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (E)entidade;
    }
}
