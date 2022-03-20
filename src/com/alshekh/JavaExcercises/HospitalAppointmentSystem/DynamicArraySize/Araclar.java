package com.alshekh.JavaExcercises.HospitalAppointmentSystem.DynamicArraySize;/*
 * @file Doktor
 * @description
 * @assignment Hastane Randevu Sistemi uygulaması
 * @date Kodu 2022-01-20 00:18:34
 * @author ِIbrahim Alshekh
 */

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Araclar
{

  private final int HASTANE = 1;
  private final String HASTANE_TASARIM = "| %3s | %25s | %15s | %20s |\n";
  private final int KLINIK = 2;
  private final String KLINIK_TASARIM = "| %3s | %25s | %15s | %18s | %15s | %18s | %15s | %18s |\n";
  private final int HASTA = 3;
  private final String HASTA_TASARIM = "| %3s | %15s | %5s | %20s | %15s |\n";
  private final int DOKTOR = 4;
  private final String DOKTOR_TASARIM = "| %3s | %15s | %5s | %16s | %15s | %15s |\n";
  private final int RANDEVU = 5;
  private final String RANDEVU_TASARIM = "| %3s | %16s | %16s | %16s | %16s | %16s |\n";
  private final int TABLO_BASLIK = 1;
  private final int TABLO_ALTBILGI = 2;
  private final int TABLO_AYRICI = 3;

  public int getRandomIndex(int max)
  {
    return new Random().nextInt(max);
  }

  public int sayiGirisAl(String mesaj)
  {
    Scanner scanner = new Scanner(System.in);
    System.out.print("\n" + mesaj + ": ");

    int sonuc = -1;
    boolean islemDurum = true;
    do
    {
      try
      {
        if (!islemDurum) System.out.print("\nLütfen tekrar deneyin: ");
        sonuc = scanner.nextInt();
      } catch (InputMismatchException e)
      {
        System.out.println("Girdiğiniz geçerli değil, lütfen bir sayı girin");
        islemDurum = false;
      }
      scanner.nextLine();
    } while (sonuc < 0);

    return sonuc;
  }

  public String diziGirisAl(String mesaj)
  {
    Scanner scanner = new Scanner(System.in);
    System.out.print("\n " + mesaj + ": ");
    return scanner.nextLine();
  }

  public void detaylariYazdir(Object object)
  {
    if (object instanceof Hastane)
    {
      this.hastaneDetaylariYazdir(object);
    } else if (object instanceof Klinik)
    {
      this.klinikDetaylariYazdir(object);
    } else if (object instanceof Doktor)
    {
      this.doctorDetaylariYazdir(object);
    } else if (object instanceof Hasta)
    {
      this.hastaDetaylariYazdir(object);
    } else if (object instanceof Randevu)
    {
      this.randevuDetaylariYazdir(object);
    }
  }

  public void listeleme(Liste liste)
  {
    Object listeElemnet = liste.al(0);

    if (liste.boyut() > 0 && listeElemnet != null)
    {
      if (listeElemnet instanceof Hastane)
      {
        this.hastaneListeleme(liste);
      } else if (listeElemnet instanceof Klinik)
      {
        this.klinikListeleme(liste);
      } else if (listeElemnet instanceof Doktor)
      {
        this.doctorListeleme(liste);
      } else if (listeElemnet instanceof Hasta)
      {
        this.hastaListeleme(liste);
      } else if (listeElemnet instanceof Randevu)
      {
        this.randevuListeleme(liste);
      }
    } else
    {
      System.out.println("Liste boş, yazdırılacak bir şey yok");
    }
  }

  private void randevuDetaylariYazdir(Object object)
  {
    Randevu randevu = (Randevu) object;
    System.out.printf(
        this.tabloTasarimAl(RANDEVU, TABLO_BASLIK) + RANDEVU_TASARIM + this.tabloTasarimAl(RANDEVU, TABLO_AYRICI),
        "ID", "Tarih", "Durum", "Hasta Adi", "Klinik Adi", "Doktor Adi"
    );
    System.out.printf(
        RANDEVU_TASARIM,
        randevu.idAl(),
        randevu.tarihAl(),
        randevu.durumAl(),
        randevu.doktorAl().adAl(),
        randevu.klinikAl().adAl(),
        randevu.doktorAl().adAl()
    );
    System.out.println(this.tabloTasarimAl(RANDEVU, TABLO_ALTBILGI));
  }

  private void hastaDetaylariYazdir(Object object)
  {
    Hasta hasta = (Hasta) object;
    System.out.printf(
        this.tabloTasarimAl(HASTA, TABLO_BASLIK) + HASTA_TASARIM + this.tabloTasarimAl(HASTA, TABLO_AYRICI),
        "ID", "Hasta Adi", "Yaş", "Telefon", "Randevu sayısı"
    );
    System.out.printf(
        HASTA_TASARIM,
        hasta.idAl(),
        hasta.adAl(),
        hasta.yasAl(),
        hasta.telefoneAl(),
        hasta.randevularAl().boyut()
    );
    System.out.println(this.tabloTasarimAl(HASTA, TABLO_ALTBILGI));
  }

  private void doctorDetaylariYazdir(Object object)
  {
    Doktor doktor = (Doktor) object;
    System.out.printf(
        this.tabloTasarimAl(DOKTOR, TABLO_BASLIK) + DOKTOR_TASARIM + this.tabloTasarimAl(DOKTOR, TABLO_AYRICI),
        "ID", "Doktor Adi", "Yaş", "Telefon", "Klinik", "Hastalar sayısı"
    );
    System.out.printf(
        DOKTOR_TASARIM,
        doktor.idAl(),
        doktor.adAl(),
        doktor.yasAl(),
        doktor.telefoneAl(),
        doktor.klinikAl().adAl(),
        doktor.hastalerAl().boyut()
    );
    System.out.println(this.tabloTasarimAl(DOKTOR, TABLO_ALTBILGI));
  }

  private void klinikDetaylariYazdir(Object object)
  {
    Klinik klinik = (Klinik) object;
    System.out.printf(
        this.tabloTasarimAl(KLINIK, TABLO_BASLIK) + KLINIK_TASARIM + this.tabloTasarimAl(KLINIK, TABLO_AYRICI),
        "ID", "Klinik Adi", "Doktor sayısı", "Max doktor sayısı", "Hasta sayısı", "Max hasta sayısı", "Randevu sayısı", "Max randevu sayısı"
    );
    System.out.printf(
        KLINIK_TASARIM,
        klinik.idAl(),
        klinik.adAl(),
        klinik.doktorlarAl().boyut(),
        klinik.maxDoktorlarAl(),
        klinik.hastalarAl().boyut(),
        klinik.maxHastalarAl(),
        klinik.randevularAl().boyut(),
        klinik.maxRandevularAl()
    );
    System.out.println(this.tabloTasarimAl(KLINIK, TABLO_ALTBILGI));

    if (klinik.doktorlarAl().boyut() > 0)
    {
      System.out.println("-------- Doktor Bigileri -----------");
      this.doctorListeleme(klinik.doktorlarAl());
    }
    if (klinik.hastalarAl().boyut() > 0)
    {
      System.out.println("-------- Hasta Bigileri -----------");
      this.hastaListeleme(klinik.hastalarAl());
    }
    if (klinik.randevularAl().boyut() > 0)
    {
      System.out.println("-------- Randevu Bigileri -----------");
      this.randevuListeleme(klinik.randevularAl());
    }
  }

  private void hastaneDetaylariYazdir(Object object)
  {
    Hastane hastane = (Hastane) object;
    System.out.printf(
        this.tabloTasarimAl(HASTANE, TABLO_BASLIK) + HASTANE_TASARIM + this.tabloTasarimAl(HASTANE, TABLO_AYRICI),
        "ID", "Hastane Adi", "Klinik sayısı", "Max klinik sayısı"
    );
    System.out.printf(HASTANE_TASARIM, hastane.idAl(), hastane.adiAl(), hastane.kliniklerAl().boyut(), hastane.maxKliniklerAl());
    System.out.println(this.tabloTasarimAl(HASTANE, TABLO_ALTBILGI));

    if (hastane.kliniklerAl().boyut() > 0)
    {
      System.out.println("-------- Klinik Bigileri -----------");
      for (int i = 0; i < hastane.kliniklerAl().boyut(); i++)
      {
        this.klinikDetaylariYazdir(hastane.kliniklerAl().al(i));
      }
    }
  }


  private void randevuListeleme(Liste liste)
  {
    System.out.printf(
        this.tabloTasarimAl(RANDEVU, TABLO_BASLIK) + RANDEVU_TASARIM + this.tabloTasarimAl(RANDEVU, TABLO_AYRICI),
        "ID", "Tarih", "Durum", "Hasta Adi", "Klinik Adi", "Doktor Adi"
    );

    for (int i = 0; i < liste.boyut(); i++)
    {
      Randevu randevu = (Randevu) liste.al(i);
      System.out.printf(
          RANDEVU_TASARIM,
          randevu.idAl(),
          randevu.tarihAl(),
          randevu.durumAl(),
          randevu.doktorAl().adAl(),
          randevu.klinikAl().adAl(),
          randevu.doktorAl().adAl()
      );
    }
    System.out.println(this.tabloTasarimAl(RANDEVU, TABLO_ALTBILGI));
  }

  private void hastaListeleme(Liste liste)
  {
    System.out.printf(
        this.tabloTasarimAl(HASTA, TABLO_BASLIK) + HASTA_TASARIM + this.tabloTasarimAl(HASTA, TABLO_AYRICI),
        "ID", "Hasta Adi", "Yaş", "Telefon", "Randevu sayısı"
    );
    for (int i = 0; i < liste.boyut(); i++)
    {
      Hasta hasta = (Hasta) liste.al(i);
      System.out.printf(
          HASTA_TASARIM,
          hasta.idAl(),
          hasta.adAl(),
          hasta.yasAl(),
          hasta.telefoneAl(),
          hasta.randevularAl().boyut()
      );
    }
    System.out.println(this.tabloTasarimAl(HASTA, TABLO_ALTBILGI));
  }

  private void doctorListeleme(Liste liste)
  {
    System.out.printf(
        this.tabloTasarimAl(DOKTOR, TABLO_BASLIK) + DOKTOR_TASARIM + this.tabloTasarimAl(DOKTOR, TABLO_AYRICI),
        "ID", "Doktor Adi", "Yaş", "Telefon", "Klinik", "Hastalar sayısı"
    );
    for (int i = 0; i < liste.boyut(); i++)
    {
      Doktor doktor = (Doktor) liste.al(i);
      System.out.printf(
          DOKTOR_TASARIM,
          doktor.idAl(),
          doktor.adAl(),
          doktor.yasAl(),
          doktor.telefoneAl(),
          doktor.klinikAl().adAl(),
          doktor.hastalerAl().boyut()
      );
    }
    System.out.println(this.tabloTasarimAl(DOKTOR, TABLO_ALTBILGI));
  }

  private void klinikListeleme(Liste liste)
  {
    System.out.printf(
        this.tabloTasarimAl(KLINIK, TABLO_BASLIK) + KLINIK_TASARIM + this.tabloTasarimAl(KLINIK, TABLO_AYRICI),
        "ID", "Klinik Adi", "Doktor sayısı", "Max doktor sayısı", "Hasta sayısı", "Max hasta sayısı", "Randevu sayısı", "Max randevu sayısı"
    );
    for (int i = 0; i < liste.boyut(); i++)
    {
      Klinik klinik = (Klinik) liste.al(i);
      System.out.printf(
          KLINIK_TASARIM,
          klinik.idAl(),
          klinik.adAl(),
          klinik.doktorlarAl().boyut(),
          klinik.maxDoktorlarAl(),
          klinik.hastalarAl().boyut(),
          klinik.maxHastalarAl(),
          klinik.randevularAl().boyut(),
          klinik.maxRandevularAl()
      );
    }
    System.out.println(this.tabloTasarimAl(KLINIK, TABLO_ALTBILGI));
  }

  private void hastaneListeleme(Liste liste)
  {
    System.out.printf(
        this.tabloTasarimAl(HASTANE, TABLO_BASLIK) + HASTANE_TASARIM + this.tabloTasarimAl(HASTANE, TABLO_AYRICI),
        "ID", "Hastane Adi", "Klinik sayısı", "Max klinik sayısı"
    );
    for (int i = 0; i < liste.boyut(); i++)
    {
      Hastane hastane = (Hastane) liste.al(i);
      System.out.printf(
          HASTANE_TASARIM,
          hastane.idAl(),
          hastane.adiAl(),
          hastane.kliniklerAl().boyut(),
          hastane.maxKliniklerAl()
      );
    }
    System.out.println(this.tabloTasarimAl(HASTANE, TABLO_ALTBILGI));
  }

  private String tabloTasarimAl(int tip, int varyant)
  {
    switch (tip)
    {
      case HASTANE:
      {
        switch (varyant)
        {
          case TABLO_BASLIK:  return "┌─────┬───────────────────────────┬─────────────────┬──────────────────────┐\n";
          case TABLO_AYRICI:  return "├─────┼───────────────────────────┼─────────────────┼──────────────────────┤\n";
          case TABLO_ALTBILGI:return "└─────┴───────────────────────────┴─────────────────┴──────────────────────┘";
        }
      }
      case HASTA:
      {
        switch (varyant)
        {
          case TABLO_BASLIK:  return "┌─────┬─────────────────┬───────┬──────────────────────┬─────────────────┐\n";
          case TABLO_AYRICI:  return "├─────┼─────────────────┼───────┼──────────────────────┼─────────────────┤\n";
          case TABLO_ALTBILGI:return "└─────┴─────────────────┴───────┴──────────────────────┴─────────────────┘";
        }
      }
      case KLINIK:
      {
        switch (varyant)
        {
          case TABLO_BASLIK:  return "┌─────┬───────────────────────────┬─────────────────┬────────────────────┬─────────────────┬────────────────────┬─────────────────┬────────────────────┐\n";
          case TABLO_AYRICI:  return "├─────┼───────────────────────────┼─────────────────┼────────────────────┼─────────────────┼────────────────────┼─────────────────┼────────────────────┤\n";
          case TABLO_ALTBILGI:return "└─────┴───────────────────────────┴─────────────────┴────────────────────┴─────────────────┴────────────────────┴─────────────────┴────────────────────┘";
        }
      }
      case DOKTOR:
      {
        switch (varyant)
        {
          case TABLO_BASLIK:  return "┌─────┬─────────────────┬───────┬──────────────────┬─────────────────┬─────────────────┐\n";
          case TABLO_AYRICI:  return "├─────┼─────────────────┼───────┼──────────────────┼─────────────────┼─────────────────┤\n";
          case TABLO_ALTBILGI:return "└─────┴─────────────────┴───────┴──────────────────┴─────────────────┴─────────────────┘";
        }
      }
      case RANDEVU:
      {
        switch (varyant)
        {
          case TABLO_BASLIK:  return "┌─────┬──────────────────┬──────────────────┬──────────────────┬──────────────────┬──────────────────┐\n";
          case TABLO_AYRICI:  return "├─────┼──────────────────┼──────────────────┼──────────────────┼──────────────────┤──────────────────┤\n";
          case TABLO_ALTBILGI:return "└─────┴──────────────────┴──────────────────┴──────────────────┴──────────────────┴──────────────────┘";
        }
      }
      default: return "";
    }
  }

}
