package com.proje.main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Fatih
 */
class Metodlar{
public boolean baglantiDene(String kullaniciAdi,String parola,Veritaban� veritaban�){
    
    try {
            veritaban�.baglan();
            

            String sql = "SELECT kullaniciadi,parola,akillicihazid FROM kullanicilar WHERE kullaniciadi=?";

            /**
             * *** Sorgu �al��t�rma ****
             */
             
            PreparedStatement stmt = veritaban�.db.getConnection().prepareStatement(sql);
            stmt.setString(1, kullaniciAdi);
            ResultSet rs = stmt.executeQuery();

            /**s
             * *** Ba�lant� sonland�rma ****
             */
            veritaban�.closeConnection();

            String kullaniciAdiString = "";
            String password = "";
            String akilliCihazId = "";

            if (rs.next()) {
                /**
                 * *** Kayda ait alan de�erlerini de�i�kene ata ****
                 */

                kullaniciAdiString = rs.getString("kullaniciadi");
                password = rs.getString("parola");
                akilliCihazId=rs.getString("akillicihazid");
                if (kullaniciAdi.equals(kullaniciAdiString) && parola.equals(password)) {
                    Random random = new Random();
                    double sicaklik = 10+30*random.nextDouble();
                    sicaklik = BigDecimal.valueOf(sicaklik).setScale(1, RoundingMode.HALF_UP).doubleValue();
                    Kullanici kullanici = new Kullanici.KullaniciBuilder().cihazId(akilliCihazId).port(veritaban�.db.getUrl()).adminId(veritaban�.db.getAdminId()).DBpassword(veritaban�.db.getPassword())
                            .evSicakligi(sicaklik).build();
                    return true;
                    
                } else if (kullaniciAdi.equals(kullaniciAdiString) && !parola.equals(password)) {
                    System.out.println("Ge�ersiz �ifre...");
                    

                }

            } else {
                System.out.println("�yelik mevcut De�il");
            }

            /**
             * *** Kaynaklar� serbest b�rak ****
             */
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    
    
    
    
    return false;
    }



}
