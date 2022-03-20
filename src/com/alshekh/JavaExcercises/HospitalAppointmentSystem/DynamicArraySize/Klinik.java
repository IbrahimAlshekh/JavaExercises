package com.alshekh.JavaExcercises.HospitalAppointmentSystem.DynamicArraySize;/*
 * @file Doktor
 * @description
 * @assignment Hastane Randevu Sistemi uygulaması
 * @date Kodu 2022-01-20 00:18:34
 * @author ِIbrahim Alshekh
 */

public class Klinik
{
  private int id;
  private YeniDizi ad;
  private Liste doktorlar;
  private Liste hastalar;
  private Liste randevular;
  private Liste eskiRandevular;
  private int maxDoktorlar;
  private int maxHastalar;
  private int maxRandevular;
  private boolean islemDurumu;

  public Klinik()
  {
    this.doktorlar = new Liste(new Doktor());
    this.hastalar = new Liste(new Hasta());
    this.randevular = new Liste(new Randevu());
    this.eskiRandevular = new Liste(new Randevu());
  }

  public int idAl()
  {
    return id;
  }

  public void idBelirle(int id)
  {
    this.id = id;
  }

  public YeniDizi adAl()
  {
    return ad;
  }

  public void adBelirle(YeniDizi ad)
  {
    this.ad = ad;
  }

  // Dokotrlar functionları
  public int maxDoktorlarAl()
  {
    return maxDoktorlar;
  }

  public void maxDoktorlarBelirle(int maxDoktorlar)
  {
    this.maxDoktorlar = maxDoktorlar;
  }

  public void doktorlarBelirle(Liste doktorlar)
  {
    this.doktorlar = doktorlar;
  }

  public void doktorEkle(Doktor doktor)
  {
    if (this.doktorlar.boyut() == this.maxDoktorlar)
    {
      System.out.println("Maksimum Dokotr sayısına ulaştınız, ilerleme hatası");
      this.islemDurumu = false;
      return;
    }
    doktor.idBelirle(this.doktorlar.idAl());
    this.doktorlar.ekle(doktor);
    this.islemDurumu = true;
  }

  public void doktorSil(Doktor doktor)
  {
    this.doktorlar.sil(doktor);
  }

  public Liste doktorlarAl()
  {
    return this.doktorlar;
  }

  public Doktor doktorAl(Doktor doktor)
  {
    return (Doktor) this.doktorlar.al(doktor);
  }

  public Doktor doktorAl(int doktorId)
  {
    for (int i = 0; i < this.doktorlar.boyut(); i++)
    {
      Doktor doktor = (Doktor) this.doktorlar.al(i);
      if (doktor.idAl() == doktorId)
      {
        return doktor;
      }
    }
    return null;
  }

  // Hastaler functionları
  public int maxHastalarAl()
  {
    return maxHastalar;
  }

  public void maxHastalarBelirle(int maxHastalar)
  {
    this.maxHastalar = maxHastalar;
  }

  public void hastalarBelirle(Liste hastalar)
  {
    this.hastalar = hastalar;
  }

  public Liste hastalarAl()
  {
    return hastalar;
  }

  public Hasta hastaAl(Hasta hasta)
  {
    return (Hasta) this.doktorlar.al(hasta);
  }

  public Hasta hastaAl(int hastaId)
  {
    for (int i = 0; i < this.hastalar.boyut(); i++)
    {
      Hasta hasta = (Hasta) this.hastalar.al(i);
      if (hasta.idAl() == hastaId)
      {
        return hasta;
      }
    }
    return null;
  }

  public void hastaSil(Hasta hasta)
  {
    this.hastalar.sil(hasta);
  }

  public void hastaEkle(Hasta hasta)
  {
    if (this.hastalar.boyut() == this.maxHastalar)
    {
      System.out.println("Maksimum Hasta sayısına ulaştınız, ilerleme hatası");
      this.islemDurumu = false;
      return;
    }
    hasta.idBelirle(this.hastalar.idAl());
    this.hastalar.ekle(hasta);
    this.islemDurumu = true;
  }

  // Randevular functionları
  public int maxRandevularAl()
  {
    return maxRandevular;
  }

  public void maxRandevularBelirle(int maxRandevular)
  {
    this.maxRandevular = maxRandevular;
  }

  public Liste randevularAl()
  {
    return this.randevular;
  }

  public void randevularBelirle(Liste randevular)
  {
    this.randevular = randevular;
  }

  public Randevu randevuAl(int randevuId)
  {
    for (int i = 0; i < this.hastalar.boyut(); i++)
    {
      Randevu randevu = (Randevu) this.hastalar.al(i);
      if (randevu.idAl() == randevuId)
      {
        return randevu;
      }
    }
    return null;

  }

  public void randevuEkle(Randevu randevu)
  {
    if (this.randevular.boyut() == this.maxRandevular)
    {
      System.out.println("Maksimum Randevu sayısına ulaştınız, ilerleme hatası");
      this.islemDurumu = false;
      return;
    }
    randevu.idBelirle(this.randevular.idAl());
    this.randevular.ekle(randevu);
    this.islemDurumu = true;
  }

  public void randevuSil(Randevu randevu)
  {
    this.hastalar.sil(randevu);
  }

  public Liste eskiRandevularAl()
  {
    return this.eskiRandevular;
  }

  public void randevuMusaitligiArama(Tarih tarih)
  {

      for (int j = 9; j < 17; j++)
      {
        boolean atla = false;
        String s = j < 10 ? "0" + j : "" + j;
        Tarih yeniTarih = new Tarih(tarih.saatsizAl() + " " + s + ":00",false);
        for (int i = 0; i < this.randevular.boyut(); i++)
        {
          Randevu randevu = (Randevu) this.randevular.al(i);

          if (randevu.tarihAl().karsilastir(yeniTarih, false) == 0)
          {
            atla = true;
          }
        }
        if (atla) continue;
        System.out.println(yeniTarih + " randevusu musaittir");
      }

  }

  public void eskiRandevularBelirle(Liste eskiRandevular)
  {
    this.eskiRandevular = eskiRandevular;
  }

  public boolean islemDurumu()
  {
    return this.islemDurumu;
  }
}
