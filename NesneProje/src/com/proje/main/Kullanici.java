package com.proje.main;

public class Kullanici {
    
    private String cihazId;
    private String port;
    private String adminId;
    private String DBpassword;
    double evinSicakligi;
    private static Kullanici kullanici=null;
    private Kullanici() {
        
    }
    public void setBuilder(KullaniciBuilder builder){
        getInstance().cihazId = builder.cihazId;
        getInstance().port = builder.port;
        getInstance().adminId = builder.adminId;
        getInstance().DBpassword = builder.DBpassword;
        getInstance().evinSicakligi=builder.evinSicakligi;
        
    }

    public String getCihazId() {
        return cihazId;
    }

    public void setCihazId(String cihazId) {
        this.cihazId = cihazId;
    }

    

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getDBpassword() {
        return DBpassword;
    }

    public void setDBpassword(String DBpassword) {
        this.DBpassword = DBpassword;
    }

    public double getEvinSicakligi() {
        return evinSicakligi;
    }

    public void setEvinSicakligi(double evinSicakligi) {
        this.evinSicakligi = evinSicakligi;
    }
    
    
    public static Kullanici getInstance(){
        if (kullanici==null) {
            kullanici=new Kullanici();
        }
        return kullanici;
    
    }
    
    
    
    
    
    
    public static class KullaniciBuilder{
        private String cihazId;
        private String port;
        private String adminId;
        private String DBpassword;
        private double evinSicakligi;
        
        public KullaniciBuilder(){
        
        }
        public KullaniciBuilder cihazId(String cihazId){
            this.cihazId=cihazId;
            return this;
        }
        public KullaniciBuilder port(String port){
            this.port=port;
            return this;
        }
        public KullaniciBuilder adminId(String adminId){
            this.adminId=adminId;
            return this;
        }
        public KullaniciBuilder DBpassword(String dbPassword){
            this.DBpassword=dbPassword;
            return this;
        }
        public KullaniciBuilder evSicakligi(double sicaklik){
            this.evinSicakligi=sicaklik;
            return this;
        }
        public Kullanici build(){
            Kullanici kullanici = new Kullanici();
            kullanici.setBuilder(this);
            return kullanici;
        }
        
        


}
}