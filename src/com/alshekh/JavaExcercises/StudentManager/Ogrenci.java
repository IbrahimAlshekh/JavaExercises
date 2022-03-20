package com.alshekh.JavaExcercises.StudentManager;

public class Ogrenci {

    private final int ogrID;
    private final String ogrAd;
    private final String ogrSoyad;
    private final int ogrSinif;
    private final int bolNo;

    public Ogrenci(int id, String ad, String soyAd, int bolNo, int sinif) {
        this.ogrID = id;
        this.ogrAd = ad;
        this.ogrSoyad = soyAd;
        this.bolNo = bolNo;
        this.ogrSinif = sinif;
    }

    public int GetOgrID() {
        return this.ogrID;
    }

    public String GetOgrAd() {
        return this.ogrAd;
    }

    public String GetOgrSoyad() {
        return this.ogrSoyad;
    }

    public int GetBolNo() {
        return this.bolNo;
    }

    public int GetOgrSinif() {
        return this.ogrSinif;
    }
}
