/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqldemo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 2018200724
 */
public class ConnectionFactory {
    public static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/projeto5";
    public static final String DEFAULT_USER = "root";
    public static final String DEFAULT_PASSWORD = "root";
    
    private static ConnectionFactory INSTANCE = null;
    private final String url;
    private final String userName;
    private final String password;
    
    private ConnectionFactory(String url,String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }
    
    public Connection getConnection() throws SQLException{    
        return (Connection) DriverManager.getConnection(url, userName, password);              
    }
    
    /**
     * Returns a singleton instance
     * @return 
     */
    public static ConnectionFactory getInstance() {
        if(INSTANCE == null)
            INSTANCE = new ConnectionFactory(DEFAULT_URL, DEFAULT_USER, DEFAULT_PASSWORD);
        return INSTANCE;
    }
}
