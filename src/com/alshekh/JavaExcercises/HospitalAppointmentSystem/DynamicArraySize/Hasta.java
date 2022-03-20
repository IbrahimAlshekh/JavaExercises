package com.alshekh.JavaExcercises.HospitalAppointmentSystem.DynamicArraySize;/*
 * @file Doktor
 * @description
 * @assignment Hastane Randevu Sistemi uygulaması
 * @date Kodu 2022-01-20 00:18:34
 * @author ِIbrahim Alshekh
 */

public class Hasta extends Kisi
{
    private Liste randevular;

    public Hasta(){
        this.randevular = new Liste(new Randevu());
    }

    public Liste randevularAl()
    {
        return randevular;
    }

    public void randevularBelirle(Liste randevular)
    {
        this.randevular = randevular;
    }
}
