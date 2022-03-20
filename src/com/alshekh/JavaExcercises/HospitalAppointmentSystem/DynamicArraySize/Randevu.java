package com.alshekh.JavaExcercises.HospitalAppointmentSystem.DynamicArraySize;/*
 * @file Doktor
 * @description
 * @assignment Hastane Randevu Sistemi uygulaması
 * @date Kodu 2022-01-20 00:18:34
 * @author ِIbrahim Alshekh
 */

public class Randevu
{
  private int id;
  private Tarih tarih;
  private Hasta hasta;
  private Doktor doktor;
  private Klinik klinik;
  private YeniDizi durum;

  public int idAl()
  {
    return id;
  }

  public void idBelirle(int id)
  {
    this.id = id;
  }

  public Tarih tarihAl()
  {
    return tarih;
  }

  public void tarihBelirle(Tarih tarih)
  {
    this.tarih = tarih;
  }

  public YeniDizi durumAl()
  {
    return durum;
  }

  public void durumBelirle(YeniDizi durum)
  {
    this.durum = durum;
  }

  public Doktor doktorAl()
  {
    return doktor;
  }

  public void doktorBelirle(Doktor doktor)
  {
    this.doktor = doktor;
  }

  public Klinik klinikAl()
  {
    return klinik;
  }

  public void klinikBelirle(Klinik klinik)
  {
    this.klinik = klinik;
  }

  public Hasta hastaAl()
  {
    return hasta;
  }

  public void hastaBelirle(Hasta hasta)
  {
    this.hasta = hasta;
  }
}
