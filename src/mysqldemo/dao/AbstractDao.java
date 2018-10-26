/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldemo.dao;

import mysqldemo.exception.DatabaseException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysqldemo.connection.ConnectionFactory;

/**
 *
 * @author 2018200724
 */
public abstract class AbstractDao {
    
    protected Connection getConnection() throws SQLException {
        return ConnectionFactory.getInstance().getConnection();
    }
    
    protected void closeConnection(Connection conn) throws DatabaseException{
        if (conn != null) try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AbstractDao.class.getName()).log(Level.SEVERE, null, ex);
                throw new DatabaseException(ex.getMessage());
            }
    }
}
