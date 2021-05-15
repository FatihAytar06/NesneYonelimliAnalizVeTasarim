package com.proje.main;

import java.awt.Component;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public interface IObserver {
    public void update(Veritaban� veritaban�,boolean sogutucuDurumu);
    
}

class DataBaseSubscriber implements IObserver{

    @Override
    public void update(Veritaban� veritaban�, boolean sogutucuAcikMi) {
         Kullanici kullanici = Kullanici.getInstance();
    
    
    try {
            veritaban�.baglan();
            String sql= "INSERT INTO akillicihaz (akillicihazid,sicaklik,sogutucuacikmi,islemtarihi) VALUES (?,?,?,?)";
            
           
            /***** Sorgu �al��t�rma *****/
            PreparedStatement stmt= veritaban�.db.getConnection().prepareStatement(sql);
            stmt.setString(1, kullanici.getCihazId());
            stmt.setDouble(2, kullanici.getEvinSicakligi());
            stmt.setBoolean(3, sogutucuAcikMi);
           
            stmt.setDate(4,new Date(System.currentTimeMillis()));
            stmt.execute();
            
            
            System.out.println("Veritaban� g�ncellendi");
            
           
            
            
            /***** Ba�lant� sonland�rma *****/
            veritaban�.closeConnection();

            /***** Kaynaklar� serbest b�rak *****/
            stmt.close();
            
            
    } catch (SQLException ex) {
        Logger.getLogger(Metodlar.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }

   

    
}
class UserSubscriber implements IObserver{

    @Override
    public void update(Veritaban� veritaban�, boolean sogutucuDurumu) {
        
        if(sogutucuDurumu){
            System.out.println("So�utucu A��ld�");
        }
        else
            System.out.println("So�utucu Kapat�ld�");
        
        System.out.println("************************************");
        
    }

  

   

}