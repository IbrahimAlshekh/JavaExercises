package com.alshekh.JavaExcercises.HospitalAppointmentSystem.DynamicArraySize;/*
 * @file Doktor
 * @description
 * @assignment Hastane Randevu Sistemi uygulaması
 * @date Kodu 2022-01-20 00:18:34
 * @author ِIbrahim Alshekh
 */

public class Hastane
{
  private int id;
  private YeniDizi ad;
  private Liste klinikler;
  private int maxKlinikler;
  private boolean islemDurumu;

  public Hastane()
  {
    this.klinikler = new Liste(new Klinik());
    this.maxKlinikler = 10;
  }

  public int idAl()
  {
    return id;
  }

  public void idBelirle(int id)
  {
    this.id = id;
  }

  public YeniDizi adiAl()
  {
    return ad;
  }

  public void adiBelirle(YeniDizi ad)
  {
    this.ad = ad;
  }

  public int maxKliniklerAl()
  {
    return maxKlinikler;
  }

  public void maxKliniklerBelirle(int maxKlinikler)
  {
    this.maxKlinikler = maxKlinikler;
  }

  public Liste kliniklerAl()
  {
    return klinikler;
  }

  public void kliniklerBelirle(Liste klinikler)
  {
    this.klinikler = klinikler;
  }

  public Klinik klinikAl(Klinik klinik)
  {
    return (Klinik) this.klinikler.al(klinik);
  }

  public Klinik klinikAl(int klinikId)
  {
    for (int i = 0; i < this.klinikler.boyut(); i++)
    {
      Klinik klinik = (Klinik) this.klinikler.al(i);
      if (klinik.idAl() == klinikId)
      {
        return klinik;
      }
    }
    return null;
  }

  public void klinikEkle(Klinik klinik)
  {
    if (this.klinikler.boyut() == this.maxKlinikler)
    {
      System.out.println("Maksimum klinik sayısına ulaştınız, ilerleme hatası");
      this.islemDurumu = false;
      return;
    }
    klinik.idBelirle(this.klinikler.idAl());
    this.klinikler.ekle(klinik);
    this.islemDurumu = true;
  }

  public void klinikSil(Klinik klinik)
  {
    this.klinikler.sil(klinik);
  }

  public boolean islemDurumu()
  {
    return this.islemDurumu;
  }

  public Hasta hastaAl(int hastaId)
  {
    for (int i = 0; i < this.klinikler.boyut(); i++)
    {
      Klinik klinik = (Klinik) this.klinikler.al(i);
      for (int j = 0; j < klinik.hastalarAl().boyut(); j++)
      {
        Hasta hasta = (Hasta) klinik.hastalarAl().al(j);
        if (hasta.idAl() == hastaId) return hasta;
      }
    }
    return null;
  }

  public Liste hastaArama(YeniDizi hastaAdi)
  {
    Liste bulunnusHastalar = new Liste(new Hasta());
    for (int i = 0; i < this.klinikler.boyut(); i++)
    {
      Klinik klinik = (Klinik) this.klinikler.al(i);
      for (int j = 0; j < klinik.hastalarAl().boyut(); j++)
      {
        Hasta hasta = (Hasta) klinik.hastalarAl().al(j);
        System.out.println(hasta.adAl());
        if (hasta.adAl().icerir(hastaAdi, true))
        {
          bulunnusHastalar.ekle(hasta);
        }
      }
    }
    return bulunnusHastalar;
  }

  public Liste hastaArama(YeniDizi dizi, char ilkHarf, char sonHarf)
  {
    Liste bulunnusHastalar = new Liste(new Hasta());
    for (int i = 0; i < this.klinikler.boyut(); i++)
    {
      Klinik klinik = (Klinik) this.klinikler.al(i);
      for (int j = 0; j < klinik.hastalarAl().boyut(); j++)
      {
        Hasta hasta = (Hasta) klinik.hastalarAl().al(j);
        if (
          (hasta.adAl().ilkKarakter(ilkHarf) || ilkHarf == '*') &&
          (hasta.adAl().sonKarakter(sonHarf) || sonHarf == '*') &&
          hasta.adAl().icerir(dizi, true)
        ){
          bulunnusHastalar.ekle(hasta);
        }
      }
    }
    return bulunnusHastalar;
  }

  public Hasta enyYuksekHastaRandevu()
  {
    int enYuksekRandevuSayisi = 0;
    Hasta hasta = null;
    for (int i = 0; i < this.klinikler.boyut(); i++)
    {
      Klinik klinik = (Klinik) this.klinikler.al(i);
      for (int j = 0; j < klinik.hastalarAl().boyut(); j++)
      {
        Hasta h = (Hasta) klinik.hastalarAl().al(j);
        if (h.randevularAl().boyut() > enYuksekRandevuSayisi)
        {
          hasta = h;
          enYuksekRandevuSayisi = h.randevularAl().boyut();
        }
      }
    }
    return hasta;
  }

  public Doktor enyYuksekDoktorHastalar()
  {
    int enYuksekHastaSayisi = 0;
    Doktor doktor = null;
    for (int i = 0; i < this.klinikler.boyut(); i++)
    {
      Klinik klinik = (Klinik) this.klinikler.al(i);
      for (int j = 0; j < klinik.doktorlarAl().boyut(); j++)
      {
        Doktor dok = (Doktor) klinik.doktorlarAl().al(j);
        if (dok.hastalerAl().boyut() > enYuksekHastaSayisi)
        {
          doktor = dok;
          enYuksekHastaSayisi = dok.hastalerAl().boyut();
        }
      }
    }
    return doktor;
  }

  public Liste doktorlarAl()
  {
    Liste docktorlar = new Liste(new Doktor());
    for (int i = 0; i < this.klinikler.boyut(); i++)
    {
      Klinik klinik = (Klinik) this.klinikler.al(i);
      for (int j = 0; j < klinik.doktorlarAl().boyut(); j++)
      {
        Doktor doktor = (Doktor) klinik.doktorlarAl().al(j);
        docktorlar.ekle(doktor);
      }
    }
    return docktorlar;
  }

  public Liste randevularAl()
  {
    Liste randevular = new Liste(new Randevu());
    for (int i = 0; i < this.klinikler.boyut(); i++)
    {
      Klinik klinik = (Klinik) this.klinikler.al(i);
      for (int j = 0; j < klinik.randevularAl().boyut(); j++)
      {
        Randevu randevu = (Randevu) klinik.randevularAl().al(j);
        randevular.ekle(randevu);
      }
    }
    return randevular;
  }
}
