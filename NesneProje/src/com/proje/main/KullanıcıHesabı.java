package com.proje.main;

public class Kullan�c�Hesab� {
	private String kullaniciAdi;
ISubject publisher;


public Kullan�c�Hesab�(String kullaniciAdi, ISubject publisher) {
	this.kullaniciAdi=kullaniciAdi;
	this.publisher = publisher;
}

public String getKullaniciAdi() {
	return kullaniciAdi;
}

}
