package com.proje.main;

public class KullanýcýHesabý {
	private String kullaniciAdi;
ISubject publisher;


public KullanýcýHesabý(String kullaniciAdi, ISubject publisher) {
	this.kullaniciAdi=kullaniciAdi;
	this.publisher = publisher;
}

public String getKullaniciAdi() {
	return kullaniciAdi;
}

}
