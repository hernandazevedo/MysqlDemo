/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldemo.connection;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.sql.SQLException;

/**
 *
 * @author 2018200724
 */
public class ConnectionFactoryMongo {
    public static final String DEFAULT_URL = "localhost";
    public static final int DEFAULT_PORT = 27017;
    public static final String DEFAULT_DB_NAME = "testdb";
    
    private final String url;
    private final int port;
    private final String dbName;
    
    private static ConnectionFactoryMongo INSTANCE = null;
    
    private ConnectionFactoryMongo(String url, int port, String dbName) {
        this.url = url;
        this.port = port;
        this.dbName = dbName;
    }
    
    public DB getConnection() throws SQLException, UnknownHostException{    
        return new MongoClient(url, port).getDB(dbName);              
    }
    
    /**
     * Returns a singleton instance
     * @return 
     */
    public static ConnectionFactoryMongo getInstance() {
        if(INSTANCE == null)
            INSTANCE = new ConnectionFactoryMongo(DEFAULT_URL, DEFAULT_PORT, DEFAULT_DB_NAME);
        return INSTANCE;
    }
}
