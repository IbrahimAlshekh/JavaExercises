package com.alshekh.JavaExcercises.StudentManager;

import java.util.Scanner;

import static com.alshekh.JavaExcercises.StudentManager.Main.ScanIntInput;

public class Bolumler {

    private final int bolumlerSyisi;
    private Bolum[] bolumler;

    public Bolumler(int bolumlerSyisi) {
        this.bolumlerSyisi = bolumlerSyisi;
    }

    public void BolumAra(String bolumAdi) {

        Bolum[] temp = new Bolum[50];
        int sira = 0;
        for (Bolum bolum : this.bolumler) {
            if (bolumAdi.equalsIgnoreCase(bolum.GetBolAd())) {
                temp[sira] = bolum;
                sira++;
            }
        }

        Bolum[] sunuc = new Bolum[sira];

        for (int i = 0; i < sira; i++) {
            sunuc[i] = temp[i];
        }

        if(sunuc.length > 0){
            System.out.println("Arama Sonuçları:");
            this.BolumlerBilgileriniYazdir(sunuc,true);
        }else {
            System.out.println("Öğe bulunamadı");
        }
    }

    public Bolum BolumAra(int bolumNo) {
        for (Bolum bolum : this.bolumler) {
            if (bolumNo == bolum.GetBolNo()) {
                return bolum;
            }
        }
        return null;
    }

    public void OgrenciAra(int sinif) {
        Ogrenci[] temp = new Ogrenci[50];
        int sira = 0;
        for (Bolum bolum : this.bolumler) {
            for (Ogrenci ogrenci : bolum.GetOgrenciler()) {
                if (sinif == ogrenci.GetOgrSinif()) {
                    temp[sira] = ogrenci;
                    sira++;
                }
            }
        }

        Ogrenci[] sunuc = new Ogrenci[sira];

        for (int i = 0; i < sira; i++) {
            sunuc[i] = temp[i];
        }

        if(sunuc.length > 0){
            System.out.println("Arama Sonuçları:");
            this.OgrencilerBilgileriniYazdir(sunuc,0);
        }else {
            System.out.println("Öğe bulunamadı");
        }
    }

    public void OgrenciAra(String ogrenciAd) {

        Ogrenci[] temp = new Ogrenci[50];
        int sira = 0;
        for (Bolum bolum : this.bolumler) {
            for (Ogrenci ogrenci : bolum.GetOgrenciler()) {
                if (ogrenciAd.equalsIgnoreCase(ogrenci.GetOgrAd()) ||
                        ogrenciAd.equalsIgnoreCase(ogrenci.GetOgrSoyad()) ||
                        ogrenciAd.equalsIgnoreCase(ogrenci.GetOgrAd() + " " + ogrenci.GetOgrSoyad()) ||
                        ogrenciAd.equalsIgnoreCase(ogrenci.GetOgrSoyad() + " " + ogrenci.GetOgrAd())
                ) {
                    temp[sira] = ogrenci;
                    sira++;
                }
            }
        }

        Ogrenci[] sunuc = new Ogrenci[sira];

        for (int i = 0; i < sira; i++) {
            sunuc[i] = temp[i];
        }

        if(sunuc.length > 0){
            System.out.println("Arama Sonuçları:");
            this.OgrencilerBilgileriniYazdir(sunuc,0);
        }else {
            System.out.println("Öğe bulunamadı");
        }
    }

    public void DersAra(int kredi) {

        Ders[] temp = new Ders[50];
        int sira = 0;

        for (Bolum bolum : this.bolumler) {
            for (Ders ders : bolum.getDersler()) {
                if (kredi == ders.GetDersKredi()) {
                    temp[sira] = ders;
                    sira++;
                }
            }
        }

        Ders[] sunuc = new Ders[sira];

        for (int i = 0; i < sira; i++) {
            sunuc[i] = temp[i];
        }

        System.out.println("Arama Sonuçları:");
        this.DerslerBilgileriniYazdir(sunuc,0);
    }

    public void DersAra(String dersAdi) {

        Ders[] temp = new Ders[50];
        int sira = 0;

        for (Bolum bolum : this.bolumler) {
            for (Ders ders : bolum.getDersler()) {
                if (dersAdi.equalsIgnoreCase(ders.GetDersAd())) {
                    temp[sira] = ders;
                    sira++;
                }
            }
        }

        Ders[] sunuc = new Ders[sira];

        for (int i = 0; i < sira; i++) {
            sunuc[i] = temp[i];
        }

        if(sunuc.length > 0){
            System.out.println("Arama Sonuçları:");
            this.DerslerBilgileriniYazdir(sunuc,0);
        }else {
            System.out.println("Öğe bulunamadı");
        }
    }

    public void BolumlerBilgileriniYazdir(Bolum[] bolumler, boolean tumBiligileri) {

        Bolum[] yazilcakBulomlar = bolumler != null ? bolumler : this.bolumler;

        int sira = 1;
        for (Bolum bolum : yazilcakBulomlar) {

            System.out.println(sira + " Bölüm No: " + bolum.GetBolNo() + " Bölüm Ad: " + bolum.GetBolAd());

            if(tumBiligileri){

                System.out.println("Öğrenciler:");

                this.OgrencilerBilgileriniYazdir(bolum.GetOgrenciler(), 1);

                System.out.println("Dersler");

                this.DerslerBilgileriniYazdir(bolum.getDersler(),1);
            }
            sira++;
        }
    }

    public void OgrencilerBilgileriniYazdir(Ogrenci[] ogrenciler, int nestingDepth) {

        String BoId = "";
        int sira = 1;
        for (Ogrenci ogrenci : ogrenciler) {

            if(nestingDepth < 1)
                BoId = "- Bölüm: " + BolumAra(ogrenci.GetBolNo()).GetBolAd();

            System.out.println(
                GetNestingDepth(nestingDepth)
                + sira
                + " Öğrenci: "
                + ogrenci.GetOgrID()
                + " "
                + ogrenci.GetOgrAd()
                + " "
                + ogrenci.GetOgrSoyad()
                + " "
                + ogrenci.GetOgrSinif()
                + " "
                + BoId
            );
            sira++;
        }
    }

    public void DerslerBilgileriniYazdir(Ders[] dersler, int nestingDepth) {

        String BoId = "";
        int sira = 1;
        for (Ders ders : dersler) {

            if(nestingDepth < 1)
                BoId = "- Bölüm: " +  BolumAra(ders.GetBolNo()).GetBolAd();

            System.out.println(
                GetNestingDepth(nestingDepth)
                + sira
                + " Ders: "
                + ders.GetDersID()
                + " "
                + ders.GetDersAd()
                + " "
                + ders.GetDersKredi()
                + " "
                + BoId
            );
            sira++;
        }
    }

    public void SetBolumler() {
        this.bolumler = new Bolum[this.bolumlerSyisi];

        Scanner scanner = new Scanner(System.in);
        int bolNo;
        Bolum bolum;
        for (int i = 0; i < this.bolumlerSyisi; i++) {
            bolNo = i + 1;

            System.out.println("lütfen " + bolNo + ". bölümünü adını ayarlayın");

            bolum = new Bolum(bolNo, scanner.next());

            System.out.println("Lütfen ogrenciler " + bolNo + ". bölümünü icin sayısını ayarlayın");

            bolum.SetOgrenciler(bolNo, ScanIntInput(scanner, "Sayi: "));

            System.out.println("Lütfen dersler " + bolNo + ". bölümünü icin sayısını ayarlayın");

            bolum.SetDersler(bolNo, ScanIntInput(scanner, "Sayi: "));

            this.bolumler[i] = bolum;
        }
    }

    private String GetNestingDepth(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }
}
