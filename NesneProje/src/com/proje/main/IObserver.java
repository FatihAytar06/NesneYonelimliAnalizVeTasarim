package com.proje.main;

import java.awt.Component;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public interface IObserver {
    public void update(Veritabaný veritabaný,boolean sogutucuDurumu);
    
}

class DataBaseSubscriber implements IObserver{

    @Override
    public void update(Veritabaný veritabaný, boolean sogutucuAcikMi) {
         Kullanici kullanici = Kullanici.getInstance();
    
    
    try {
            veritabaný.baglan();
            String sql= "INSERT INTO akillicihaz (akillicihazid,sicaklik,sogutucuacikmi,islemtarihi) VALUES (?,?,?,?)";
            
           
            /***** Sorgu çalýþtýrma *****/
            PreparedStatement stmt= veritabaný.db.getConnection().prepareStatement(sql);
            stmt.setString(1, kullanici.getCihazId());
            stmt.setDouble(2, kullanici.getEvinSicakligi());
            stmt.setBoolean(3, sogutucuAcikMi);
           
            stmt.setDate(4,new Date(System.currentTimeMillis()));
            stmt.execute();
            
            
            System.out.println("Veritabaný güncellendi");
            
           
            
            
            /***** Baðlantý sonlandýrma *****/
            veritabaný.closeConnection();

            /***** Kaynaklarý serbest býrak *****/
            stmt.close();
            
            
    } catch (SQLException ex) {
        Logger.getLogger(Metodlar.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }

   

    
}
class UserSubscriber implements IObserver{

    @Override
    public void update(Veritabaný veritabaný, boolean sogutucuDurumu) {
        
        if(sogutucuDurumu){
            System.out.println("Soðutucu Açýldý");
        }
        else
            System.out.println("Soðutucu Kapatýldý");
        
        System.out.println("************************************");
        
    }

  

   

}