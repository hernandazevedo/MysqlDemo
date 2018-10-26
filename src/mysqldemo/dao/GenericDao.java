/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldemo.dao;

import mysqldemo.exception.DatabaseException;
import java.util.List;

/**
 *
 * @author 2018200724
 */
public interface GenericDao<T> {
    /**
     * Inserts an object T
     * Return the affected rows
     * @param t
     * @return 
     * @throws mysqldemo.exception.DatabaseException 
     */
    int insert(T t) throws DatabaseException;
    /**
     * Deletes an object T
     * Return the affected rows
     * @param t
     * @return 
     * @throws mysqldemo.exception.DatabaseException 
     */
    int delete(T t) throws DatabaseException;
    
    /**
     * List all objects saved
     * @return 
     * @throws mysqldemo.exception.DatabaseException 
     */
    List<T> list() throws DatabaseException;
    /**
     * Updates an object T
     * Return the affected rows
     * @param t
     * @return 
     * @throws mysqldemo.exception.DatabaseException 
     */
    int update(T t) throws DatabaseException;
}
