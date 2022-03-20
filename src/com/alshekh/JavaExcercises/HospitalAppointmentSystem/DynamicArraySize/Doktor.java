package com.alshekh.JavaExcercises.HospitalAppointmentSystem.DynamicArraySize;/*
 * @file Doktor
 * @description
 * @assignment Hastane Randevu Sistemi uygulaması
 * @date Kodu 2022-01-20 00:18:34
 * @author ِIbrahim Alshekh
 */

public class Doktor extends Kisi
{
    private Klinik klinik;
    private Liste hastalar;
    private int maxHastalar;

    public Doktor(){
        this.hastalar = new Liste(new Hasta());
    }

    public Klinik klinikAl() {
        return klinik;
    }

    public void klinikBelirle(Klinik klinik) {
        this.klinik = klinik;
    }

    public Liste hastalerAl()
    {
        return this.hastalar;
    }

    public void hastalarBelirle(Liste hastalar)
    {
        this.hastalar = hastalar;
    }

    public int maxHastalarAl()
    {
        return maxHastalar;
    }

    public void maxHastalarBelirle(int maxHastalar)
    {
        this.maxHastalar = maxHastalar;
    }
}
