package com.proje.main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class GirisEkrani {
	public static void main(String[] args) {
        Connection conn;
        String port="jdbc:postgresql://localhost:5432/NYAProje";
        String adminId="postgres",password="147852";
        
        PostgreSqlDB db = new PostgreSqlDB(port,adminId,password);
        Veritabaný veritabaný=new Veritabaný(db);
        Metodlar metodlar = new Metodlar();
        
        DataBaseSubscriber dataBaseSubscriber = new DataBaseSubscriber();
        UserSubscriber userSubscriber = new UserSubscriber();
        
        Publisher publisher = new Publisher();
        publisher.attach(dataBaseSubscriber);
        publisher.attach(userSubscriber);
        
        String kullaniciAdi,parola;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Kullanýcý Adý:");
            kullaniciAdi = scanner.nextLine();
            System.out.println("");
            System.out.print("Parola:");
            parola=scanner.nextLine();
            boolean deneme = metodlar.baglantiDene(kullaniciAdi, parola, veritabaný);
            if (deneme) {
                break;
            }
        }
        boolean deger=true;
        Kullanici kullanici = Kullanici.getInstance();
        while(deger){
            
            System.out.println("1-Sýcaklýk Görüntüle\n"+
            		"2-Soðutucu Aç/Kapat\n"
                    + "3-Çýkýþ");
            System.out.print("Ýþlem:");
            String islem = scanner.nextLine();
            
            if(islem.equals("1")) {
            	System.out.println("Evin sýcaklýðý : "+kullanici.getEvinSicakligi());
            }
            else if(islem.equals("2")){
                System.out.print("Aç/Kapat(a/k):");
                String islem1 = scanner.nextLine();
                boolean sogutucuAcikMi = true;
                
                if(islem1.equals("a")){
                    sogutucuAcikMi=true;
                }
                else if(islem1.equals("k")){
                    sogutucuAcikMi=false;
                }
                
                publisher.notify(veritabaný, sogutucuAcikMi);
            }
            else if (islem.equals("3")) {
                System.out.println("Çýkýþ yapýldý...");
               deger=false;
            }
            
        } 
        
    }
}
