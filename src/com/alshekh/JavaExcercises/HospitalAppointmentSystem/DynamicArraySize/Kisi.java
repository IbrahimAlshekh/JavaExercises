package com.alshekh.JavaExcercises.HospitalAppointmentSystem.DynamicArraySize;/*
 * @file Doktor
 * @description
 * @assignment Hastane Randevu Sistemi uygulaması
 * @date Kodu 2022-01-20 00:18:34
 * @author ِIbrahim Alshekh
 */

public class Kisi {
    private int id;
    private YeniDizi ad;
    private int yas;
    private String telefone;

    public int idAl() {
        return id;
    }

    public void idBelirle(int id) {
        this.id = id;
    }

    public int yasAl()
    {
        return yas;
    }

    public void yasBelirle(int yas)
    {
        this.yas = yas;
    }

    public String telefoneAl()
    {
        return telefone;
    }

    public void telefoneBelirle(String telefone)
    {
        this.telefone = telefone;
    }

    public YeniDizi adAl() {
        return ad;
    }

    public void adBelirle(YeniDizi ad) {
        this.ad = ad;
    }
}
