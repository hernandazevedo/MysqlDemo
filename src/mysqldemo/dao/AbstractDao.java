/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldemo.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import java.net.UnknownHostException;
import mysqldemo.exception.DatabaseException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysqldemo.connection.ConnectionFactory;
import mysqldemo.connection.ConnectionFactoryMongo;

/**
 *
 * @author 2018200724
 */
public abstract class AbstractDao {
    
    protected Connection getConnection() throws SQLException {
        return ConnectionFactory.getInstance().getConnection();
    }
    
    protected DB getMongoConnection() throws SQLException, UnknownHostException {
        return ConnectionFactoryMongo.getInstance().getConnection();
    }
    
    protected Object getNextMongoSequence(String name) throws Exception{
        // Now connect to your databases
        DB db = getMongoConnection();
        DBCollection collection = db.getCollection("counters");
        BasicDBObject find = new BasicDBObject();
        find.put("_id", name);
        BasicDBObject update = new BasicDBObject();
          
        update.put("$inc", new BasicDBObject("seq", 1));
        DBObject obj = collection.findAndModify(find, find,find,false,update,true,true);
        return obj.get("seq");
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
