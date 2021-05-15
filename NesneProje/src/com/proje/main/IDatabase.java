package com.proje.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface IDatabase {
    void connect();
    Connection getConnection();
    String getUrl();
    String getAdminId();
    String getPassword();
    void closeConnection();
}
class PostgreSqlDB implements IDatabase{
    Connection conn ;
    String url,adminId,password;

    public PostgreSqlDB( String url, String adminId, String password) {
        this.url = url;
        this.adminId = adminId;
        this.password = password;
    }
    
    
    @Override
    public void connect() {
        try {
            conn = DriverManager.getConnection(url,adminId,password);
            
            if (conn != null) {
                System.out.println("Veritabanýna baðlandý!");
            } else {
                System.out.println("Baðlantý giriþimi baþarýsýz!");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSqlDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSqlDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Connection getConnection() {
        return conn;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getAdminId() {
        return adminId;
    }

    @Override
    public String getPassword() {
        return password;
    }

    

   

}
class Veritabaný{
    IDatabase db ;

    public Veritabaný(IDatabase db) {
        this.db = db;
    }
   public void baglan(){
       db.connect();
   }
   public void closeConnection(){
       db.closeConnection();
   }
    

}