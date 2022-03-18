package com.alshekh.JavaExcercises.HospitalAppointmentSystem;

public class Klinik {
    private int id;
    private String ad;
    private Doktor[] doktorlar;
    private Hasta[] hastalar;
    private Randevu[] randevular;
    private Randevu[] eskiRandevular;

    public Klinik(int maxDoktorlar, int maxHastalar, int maxRandevular) {
        this.doktorlar = new Doktor[maxDoktorlar];
        this.hastalar = new Hasta[maxHastalar];
        this.randevular = new Randevu[maxRandevular];
        this.eskiRandevular = new Randevu[maxRandevular];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public void doktorEkle(Doktor doktor) {
        for (int i = 0; i < this.doktorlar.length; i++) {
            if (this.doktorlar[i] == null) {
                doktor.setId(i + 1);
                this.doktorlar[i] = doktor;
                return;
            }
        }
        System.out.println("Bu kliniğe daha fazla doktor ekleyemezsiniz");
    }

    public void doktorSil(Doktor doktor) {
        for (int i = 0; i < this.doktorlar.length; i++) {
            if (this.doktorlar[i] != null && this.doktorlar[i].getId() == doktor.getId()) {
                this.doktorlar[i] = null;
                diziyiYenidenSirala(this.doktorlar);
                System.out.println("Doktor \"" + doktor.getAd() + "\" başarıyla silindi");
                break;
            }
        }
    }

    public void doktorlarListeleme() {
        for (int i = 0; i < this.doktorlar.length; i++) {
            if (this.doktorlar[i] == null) break;
            System.out.println("ID: " + this.doktorlar[i].getId() + " - Ad: " + this.doktorlar[i].getAd());
        }
    }

    public Doktor[] getDoktorlar() {
        return doktorlar;
    }

    public Doktor getDoktor(int doktorId){
        for (int i = 0; i < this.doktorlar.length; i++) {
            if (this.doktorlar[i] != null && this.doktorlar[i].getId() == doktorId) {
                return this.doktorlar[i];
            }
        }
        return null;
    }

    public void randevuEkle(Randevu randevu) {
        for (int i = 0; i < this.randevular.length; i++) {
            if (this.randevular[i] == null) {
                randevu.setId(i + 1);
                this.randevular[i] = randevu;
                return;
            }
        }
        System.out.println("Bu kliniğe daha fazla randevu ekleyemezsiniz");
    }

    public void randevuSil(Randevu randevu) {
        for (int i = 0; i < this.randevular.length; i++) {
            if (this.randevular[i] != null && this.randevular[i].getId() == randevu.getId()) {
                this.randevular[i] = null;
                diziyiYenidenSirala(this.randevular);
                System.out.println( randevu.getTarih() + "\" tarihindeki randevu başarıyla silindi");
                return;
            }
        }
    }

    public Randevu[] getRandevular() {
        return randevular;
    }

    public Randevu[] getRandevular(Doktor doktor) {

        int sonucSayisi = 0;
        for (int j = 0; j < this.randevular.length; j++) {
            if(this.randevular[j] == null) break;
            if(this.randevular[j].getDoktor() == doktor) {
                sonucSayisi++;
            }
        }
        Randevu[] sonucRandevular = new Randevu[sonucSayisi];

        int index = 0;
        for (int j = 0; j < this.randevular.length; j++) {
            if(this.randevular[j] == null) break;
            if(this.randevular[j].getDoktor() == doktor) {
                sonucRandevular[index] = this.randevular[j];
                index++;
            }
        }
        return sonucRandevular;
    }

    public Randevu[] getRandevular(String durum) {
        int sayi = 0;
        for (int i = 0; i < this.randevular.length; i++) {
            if (this.randevular[i] == null) break;
            if(durum == null){
                if (this.randevular[i].getDurum().equals("iptaledildi")  || this.randevular[i].getDurum().equals("gelecek")) {
                    sayi++;
                }
            }else if (this.randevular[i].getDurum().equals(durum)) {
                sayi++;
            }

        }
        Randevu[] randevular = new Randevu[sayi];

        int index = 0;
        for (int i = 0; i < this.randevular.length; i++) {
            if (this.randevular[i] == null) break;
            if(durum == null){
                if (this.randevular[i].getDurum().equals("iptaledildi")  || this.randevular[i].getDurum().equals("gelecek")) {
                    randevular[index] = this.randevular[i];
                    index++;
                }
            }else if (this.randevular[i].getDurum().equals(durum)) {
                randevular[index] = this.randevular[i];
                index++;
            }
        }
        return randevular;
    }

    public int getHastaRadevularSayisi(String patientName) {
        int sonuc = 0;

        for (int j = 0; j < randevular.length; j++) {
            if (randevular[j] == null) break;
            if (randevular[j].getHasta().getAd().equals(patientName))
                sonuc++;
        }
        return sonuc;
    }

    public int getRandevuSayisi() {
        int sonuc = 0;

        for (int i = 0; i < this.randevular.length; i++) {
            if (this.randevular[i] == null) break;
            sonuc++;
        }
        return sonuc;
    }

    public void randevularGeuncelle(Randevu[] yeniRandevular) {

        for (int i = 0; i < this.randevular.length; i++) {
            if (this.randevular[i] == null) break;
            for (int j = 0; j < yeniRandevular.length; j++) {
                if (yeniRandevular[j] == null) continue;
                if (this.randevular[i].getId() == yeniRandevular[j].getId()) {
                    this.randevular[i] = yeniRandevular[j];
                }
            }
        }
    }

    public void randevularYazdir(String durum) {
        for (int i = 0; i < randevular.length; i++) {
            if (randevular[i] == null) break;
            if (randevular[i].getDurum().equals(durum) || durum.equals("tumu")) {
                System.out.print(
                    "ID: " + randevular[i].getId()
                    + " - Tarih: " + randevular[i].getTarih()
                    + " - Durum: " + randevular[i].getDurum()
                    + " - Hasta: " + randevular[i].getHasta().getAd()
                );
                if(randevular[i].getDoktor() != null){
                    System.out.println(" - Doktor: " + randevular[i].getDoktor().getAd());
                }
            }
        }
    }

    public void hastaEkle(Hasta hasta) {
        for (int i = 0; i < this.hastalar.length; i++) {
            if (this.hastalar[i] == null) {
                hasta.setId(i + 1);
                this.hastalar[i] = hasta;
                return;
            }
        }
        System.out.println("Bu kliniğe daha fazla hasta ekleyemezsiniz");
    }

    public void hastaSil(Hasta hasta) {
        for (int i = 0; i < this.hastalar.length; i++) {
            if (this.hastalar[i] != null && this.hastalar[i].getId() == hasta.getId()) {
                this.hastalar[i] = null;
                diziyiYenidenSirala(this.hastalar);
                System.out.println("Hasta \"" + hasta.getAd() + "\" başarıyla silindi");
                return;
            }
        }
    }

    public Hasta[] getHastalar() {
        return hastalar;
    }

    public void hastalarListeleme() {
        for (int i = 0; i < this.hastalar.length; i++) {
            if (this.hastalar[i] == null) break;
            System.out.println("ID: " + this.hastalar[i].getId() + " - Ad: " + this.hastalar[i].getAd());
        }
    }

    public Hasta getHasta(int patientId){
        for (int i = 0; i < this.hastalar.length; i++) {
            if (this.hastalar[i] != null && this.hastalar[i].getId() == patientId) {
                return this.hastalar[i];
            }
        }
        return null;
    }

    public Randevu[] getEskiRandevular() {
        return eskiRandevular;
    }

    public void setEskiRandevular(Randevu[] eskiRandevular) {
        this.eskiRandevular = eskiRandevular;
    }

    public void eskiRandevularListeleme() {
        for (int i = 0; i < this.eskiRandevular.length; i++) {
            if (this.eskiRandevular[i] == null) break;
            System.out.println(
                "ID: " + this.eskiRandevular[i].getId()
                + " - Tarih:  " + this.eskiRandevular[i].getTarih()
                + " - Durum: " + this.eskiRandevular[i].getDurum()
                + " - Hasta: " + this.eskiRandevular[i].getHasta().getAd()
                + " - Doktor: " + this.eskiRandevular[i].getDoktor().getAd()
            );
        }
    }

    public void istatistikleriYazdir(){
        System.out.println(this.ad + " kliniği için maksimum, ortalama, minimum randevusu sayısı şudur");
        System.out.println("maksimum: " + this.randevular.length);
        System.out.println("minimum: " + this.getRandevuSayisi());
        System.out.println("ortalama: " + this.randevular.length/this.getRandevuSayisi() );
        System.out.println("----");
    }

    private void diziyiYenidenSirala(Object[] object) {
        for (int i = 0; i < object.length; i++) {
            if (object[i] == null) {
                Object temp = object[i];
                for (int j = i; j < object.length - 1; j++) {
                    object[j] = object[j + 1];
                }
                object[object.length - 1] = temp;
            }
        }
    }

    public void eskiRandevularEkle(Randevu[] eskiRandevular)
    {
        for (int i = 0; i < this.eskiRandevular.length; i++) {
            if (this.eskiRandevular[i] == null) {
                for (int j = i; j < eskiRandevular.length; j++) {
                    if (eskiRandevular[j] == null) break;
                    this.eskiRandevular[j] = eskiRandevular[j];
                }
            }
        }
    }
}
