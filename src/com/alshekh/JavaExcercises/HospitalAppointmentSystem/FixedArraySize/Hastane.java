package com.alshekh.JavaExcercises.HospitalAppointmentSystem;

public class Hastane {
    private int id;
    private String ad;
    private Klinik[] klinikler;

    public Hastane(int id, int maxKlinikler) {
        this.id = id;
        this.klinikler = new Klinik[maxKlinikler];
    }

    public int getHastaRandevularSayisi(String hastaAd) {
        int sonucler = 0;

        for (int i = 0; i < this.klinikler.length; i++) {
            if (this.klinikler[i] == null) break;
            for (int j = 0; j < this.klinikler[i].getRandevular().length; j++) {
                if (this.klinikler[i].getRandevular()[j] == null) break;
                if (this.klinikler[i].getRandevular()[j].getHasta().getAd().equals(hastaAd))
                    sonucler++;
            }
        }
        return sonucler;
    }

    public int getDoktorRandevularSayisi(String doktorName) {
        int sonucler = 0;

        for (int i = 0; i < this.klinikler.length; i++) {
            if (this.klinikler[i] == null) break;
            for (int j = 0; j < this.klinikler[i].getRandevular().length; j++) {
                if (this.klinikler[i].getRandevular()[j] == null) break;
                if (this.klinikler[i].getRandevular()[j].getDoktor().getAd().equals(doktorName))
                    sonucler++;
            }
        }
        return sonucler;
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

    public Klinik[] getKlinikler() {
        return klinikler;
    }

    public Klinik getKlinikler(int klinikId) throws Exception {
        for (int i = 0; i < this.klinikler.length; i++) {
            if (this.klinikler[i] != null && this.klinikler[i].getId() == klinikId) {
                return this.klinikler[i];
            }
        }
        throw new Exception("Exception mesaj: Klinik bulunmamadi");
    }

    public void setKlinikler(Klinik[] klinikler) {
        this.klinikler = klinikler;
    }

    public void klinikEkle(Klinik klinik) {
        for (int i = 0; i < this.klinikler.length; i++) {
            if (this.klinikler[i] == null) {
                klinik.setId(i + 1);
                this.klinikler[i] = klinik;
                break;
            }
        }
    }

    public void klinikSil(Klinik klinik) {
        for (int i = 0; i < this.klinikler.length; i++) {
            if (this.klinikler[i] != null && this.klinikler[i] == klinik) {
                this.klinikler[i] = null;
                diziyiYenidenSirala(this.klinikler);
                break;
            }
        }
    }

    public void klinikleriListeleme() {
        for (int i = 0; i < this.klinikler.length; i++) {
            if (this.klinikler[i] == null) break;
            System.out.println("ID: " + this.klinikler[i].getId() + " - Ad: " + this.klinikler[i].getAd());
        }
    }

    private void diziyiYenidenSirala(Klinik[] klinikler) {
        for (int i = 0; i < klinikler.length; i++) {
            if (klinikler[i] == null) {
                Klinik temp = klinikler[i];
                for (int j = i; j < klinikler.length - 1; j++) {
                    klinikler[j] = klinikler[j + 1];
                }
                klinikler[klinikler.length - 1] = temp;
            }
        }
    }
}
