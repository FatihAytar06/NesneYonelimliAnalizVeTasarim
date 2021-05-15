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
        Veritaban� veritaban�=new Veritaban�(db);
        Metodlar metodlar = new Metodlar();
        
        DataBaseSubscriber dataBaseSubscriber = new DataBaseSubscriber();
        UserSubscriber userSubscriber = new UserSubscriber();
        
        Publisher publisher = new Publisher();
        publisher.attach(dataBaseSubscriber);
        publisher.attach(userSubscriber);
        
        String kullaniciAdi,parola;
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Kullan�c� Ad�:");
            kullaniciAdi = scanner.nextLine();
            System.out.println("");
            System.out.print("Parola:");
            parola=scanner.nextLine();
            boolean deneme = metodlar.baglantiDene(kullaniciAdi, parola, veritaban�);
            if (deneme) {
                break;
            }
        }
        boolean deger=true;
        Kullanici kullanici = Kullanici.getInstance();
        while(deger){
            
            System.out.println("1-S�cakl�k G�r�nt�le\n"+
            		"2-So�utucu A�/Kapat\n"
                    + "3-��k��");
            System.out.print("��lem:");
            String islem = scanner.nextLine();
            
            if(islem.equals("1")) {
            	System.out.println("Evin s�cakl��� : "+kullanici.getEvinSicakligi());
            }
            else if(islem.equals("2")){
                System.out.print("A�/Kapat(a/k):");
                String islem1 = scanner.nextLine();
                boolean sogutucuAcikMi = true;
                
                if(islem1.equals("a")){
                    sogutucuAcikMi=true;
                }
                else if(islem1.equals("k")){
                    sogutucuAcikMi=false;
                }
                
                publisher.notify(veritaban�, sogutucuAcikMi);
            }
            else if (islem.equals("3")) {
                System.out.println("��k�� yap�ld�...");
               deger=false;
            }
            
        } 
        
    }
}
