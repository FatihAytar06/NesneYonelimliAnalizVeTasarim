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
public boolean baglantiDene(String kullaniciAdi,String parola,Veritabanı veritabanı){
    
    try {
            veritabanı.baglan();
            

            String sql = "SELECT kullaniciadi,parola,akillicihazid FROM kullanicilar WHERE kullaniciadi=?";

            /**
             * *** Sorgu çalıştırma ****
             */
             
            PreparedStatement stmt = veritabanı.db.getConnection().prepareStatement(sql);
            stmt.setString(1, kullaniciAdi);
            ResultSet rs = stmt.executeQuery();

            /**s
             * *** Bağlantı sonlandırma ****
             */
            veritabanı.closeConnection();

            String kullaniciAdiString = "";
            String password = "";
            String akilliCihazId = "";

            if (rs.next()) {
                /**
                 * *** Kayda ait alan değerlerini değişkene ata ****
                 */

                kullaniciAdiString = rs.getString("kullaniciadi");
                password = rs.getString("parola");
                akilliCihazId=rs.getString("akillicihazid");
                if (kullaniciAdi.equals(kullaniciAdiString) && parola.equals(password)) {
                    Random random = new Random();
                    double sicaklik = 10+30*random.nextDouble();
                    sicaklik = BigDecimal.valueOf(sicaklik).setScale(1, RoundingMode.HALF_UP).doubleValue();
                    Kullanici kullanici = new Kullanici.KullaniciBuilder().cihazId(akilliCihazId).port(veritabanı.db.getUrl()).adminId(veritabanı.db.getAdminId()).DBpassword(veritabanı.db.getPassword())
                            .evSicakligi(sicaklik).build();
                    return true;
                    
                } else if (kullaniciAdi.equals(kullaniciAdiString) && !parola.equals(password)) {
                    System.out.println("Geçersiz Şifre...");
                    

                }

            } else {
                System.out.println("Üyelik mevcut Değil");
            }

            /**
             * *** Kaynakları serbest bırak ****
             */
            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    
    
    
    
    return false;
    }



}
