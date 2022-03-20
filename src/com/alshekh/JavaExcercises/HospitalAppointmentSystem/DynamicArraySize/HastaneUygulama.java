package com.alshekh.JavaExcercises.HospitalAppointmentSystem.DynamicArraySize;/*
 * @file Doktor
 * @description
 * @assignment Hastane Randevu Sistemi uygulaması
 * @date Kodu 2022-01-20 00:18:34
 * @author ِIbrahim Alshekh
 */

public class HastaneUygulama extends Araclar {

    private Liste hastaneler;
    private int maxHastaneler;
    private boolean islemDurumu;
    private Tarih gecerliTarih;

    public HastaneUygulama(Tarih gecerliTarih){
        this.hastaneler = new Liste(new Hastane());
        this.gecerliTarih = gecerliTarih;
    }

    public Tarih gecerliTarihAl()
    {
        return gecerliTarih;
    }

    public void gecerliTarihBelirle(Tarih gecerliTarih)
    {
        this.gecerliTarih = gecerliTarih;
    }

    // Dokotrlar functionları
    public int maxHastanelerAl()
    {
        return this.maxHastaneler;
    }

    public void maxHastanelerBelirle(int maxHastaneler)
    {
        this.maxHastaneler = maxHastaneler;
    }

    public void hastanelerBelirle(Liste hastaneler)
    {
        this.hastaneler = hastaneler;
    }

    public void hastaneEkle(Hastane hastane)
    {
        if (this.hastaneler.boyut() == this.maxHastaneler)
        {
            System.out.println("Maksimum Dokotr sayısına ulaştınız, ilerleme hatası");
            this.islemDurumu = false;
            return;
        }
        hastane.idBelirle(this.hastaneler.idAl());
        this.hastaneler.ekle(hastane);
        this.islemDurumu = true;
    }

    public void hastaneSil(Hastane hastane)
    {
        this.hastaneler.sil(hastane);
    }

    public Liste hastanelerAl()
    {
        return this.hastaneler;
    }

    public Hastane hastaneAl(Hastane hastane)
    {
        return (Hastane) this.hastaneler.al(hastane);
    }

    public Hastane hastaneAl(int hastaneId)
    {
        for (int i = 0; i < this.hastaneler.boyut(); i++)
        {
            Hastane hastane = (Hastane) this.hastaneler.al(i);
            if (hastane.idAl() == hastaneId)
            {
                return hastane;
            }
        }
        return null;
    }

    public boolean islemDurumu()
    {
        return islemDurumu;
    }
}
