package com.test.web.helper;

import java.sql.Connection;

import java.sql.DriverManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    
       private static Logger logger = Logger.getLogger(DBConnection.class.getName());
       private static final String username = "hr";
       private static final String password = "oracle";
       private static final String url = "jdbc:oracle:thin:@localhost:1521/orcl";
       private static final String classDriver = "oracle.jdbc.driver.OracleDriver";
       private Connection connection;

       public Connection getConnection() {
           return connection;
       }

       private static DBConnection databaseConnection = null;
       
       private DBConnection(){
           try {
               Class.forName(classDriver);
               connection = DriverManager.getConnection(url, username, password);
           } catch (Exception e) {
               logger.log(Level.ALL, "Connection Fail");
           }

       }
       
       public static DBConnection getInstance(){
           if(databaseConnection == null){
               databaseConnection = new DBConnection();   
           }
           return databaseConnection;
       }
}
