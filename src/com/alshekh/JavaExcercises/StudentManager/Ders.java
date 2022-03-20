package com.alshekh.JavaExcercises.StudentManager;

public class Ders {
    private final int bolNo;
    private final int dersID;
    private final String dersAd;
    private final int dersKredi;

    public Ders(int bolNo, int dersID, String dersAd, int dersKredi) {
        this.bolNo = bolNo;
        this.dersID = dersID;
        this.dersAd = dersAd;
        this.dersKredi = dersKredi;
    }

    public int GetBolNo() {
        return this.bolNo;
    }

    public int GetDersID() {
        return this.dersID;
    }

    public String GetDersAd() {
        return this.dersAd;
    }

    public int GetDersKredi() {
        return this.dersKredi;
    }
}