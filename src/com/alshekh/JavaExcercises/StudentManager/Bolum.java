package com.alshekh.JavaExcercises.StudentManager;

import java.util.Scanner;

import static com.alshekh.JavaExcercises.StudentManager.Main.ScanIntInput;

public class Bolum {

    private final int bolNo;
    private final String bolAd;
    private Ogrenci[] ogrenciler;
    private Ders[] dersler;

    public Bolum(int bolNo, String bolAd) {
        this.bolNo = bolNo;
        this.bolAd = bolAd;
    }

    public int GetBolNo() {
        return this.bolNo;
    }

    public String GetBolAd() {
        return this.bolAd;
    }

    public Ogrenci[] GetOgrenciler() {
        return this.ogrenciler;
    }

    public Ders[] getDersler() {
        return this.dersler;
    }

    public void SetOgrenciler(int bolNo, int adet) {

        this.ogrenciler = new Ogrenci[adet];

        Scanner scanner = new Scanner(System.in);

        int ogrID;

        for (int i = 0; i < adet; i++) {
            ogrID = i + 1;

            System.out.println("lütfen " + ogrID + ". öğrencinin verilerini ayarlayın");

            System.out.print("Ad: ");

            String ad = scanner.next();

            System.out.print("Soyad: ");

            String soyAd = scanner.next();

            this.ogrenciler[i] = new Ogrenci(ogrID, ad, soyAd, bolNo, ScanIntInput(scanner, "Sinif: "));
        }
    }

    public void SetDersler(int bolNo, int adet) {

        this.dersler = new Ders[adet];

        Scanner scanner = new Scanner(System.in);

        int dersID;

        for (int i = 0; i < adet; i++) {

            dersID = i + 1;

            System.out.println("lütfen " + dersID + ". dersini verilerini ayarlayın");

            System.out.print("Ad: ");

            String dersAd = scanner.next();

            this.dersler[i] = new Ders(bolNo, dersID, dersAd, ScanIntInput(scanner, "Kredi: "));
        }
    }
}
