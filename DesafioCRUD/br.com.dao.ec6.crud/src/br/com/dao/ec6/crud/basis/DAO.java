/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.ec6.crud.basis;

import br.com.comuns.ec6.crud.basis.Entidade;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *Classe ancestral para configurar a comunicação entre a base de dados e o Software
 * @author gabriell
 * @param <E>
 */
public abstract class DAO <E extends Entidade> {
    
    protected Class<E> entityClass;

    public DAO(Class<E> entityClass){
        this.entityClass = entityClass;
    }
    
    public abstract E seleciona(int id); //Classe abstrata para retornar um objeto busacando pelo ID
    public abstract E localiza(String codigo) throws SQLException; //Classe abstrata para retornar um objeto pelo código
    public abstract ArrayList<E> lista() throws SQLException; //Classe abstrata que retornar uma lista de objetos
    
    protected E getInstanceOfE()
    {
        try
        {
            return entityClass.newInstance();
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            // Oops, no default constructor
            throw new RuntimeException(e);
        }
    }
}
