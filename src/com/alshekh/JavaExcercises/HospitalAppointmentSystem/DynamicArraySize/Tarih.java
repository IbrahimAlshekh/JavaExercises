package com.alshekh.JavaExcercises.HospitalAppointmentSystem.DynamicArraySize;/*
 * @file Doktor
 * @description
 * @assignment Hastane Randevu Sistemi uygulaması
 * @date Kodu 2022-01-20 00:18:34
 * @author ِIbrahim Alshekh
 */

public class Tarih
{
  private int yil;
  private int ay;
  private int gun;
  private int saat;
  private int dakika;
  private final char tarihaYirici = '/';
  private final char zamanYirici = ':';
  private final char uzayYirici = ' ';
  private String hataMesaji;
  private boolean saatYoksay;

  public Tarih(String tarih, boolean saatyoksay)
  {
    if (tarihFormatiKontrolEt(tarih))
    {
      this.parseDate(tarih);
    }else {
      System.out.println(this.hataMesaji);
    }
    this.saatYoksay = saatyoksay;
  }

  //12/03/2022 15:30
  private void parseDate(String tarih)
  {
    this.gun = Integer.parseInt("" + tarih.charAt(0) + tarih.charAt(1));
    this.ay = Integer.parseInt("" + tarih.charAt(3) + tarih.charAt(4));
    this.yil = Integer.parseInt("" + tarih.charAt(6) + tarih.charAt(7) + tarih.charAt(8) + tarih.charAt(9));
    if(!this.saatYoksay){
      this.saat = Integer.parseInt("" + tarih.charAt(11) + tarih.charAt(12));
      this.dakika = Integer.parseInt("" + tarih.charAt(14) + tarih.charAt(15));
    }

  }

  private boolean tarihFormatiKontrolEt(String tarih)
  {
    //check length
    if (tarih.length() != 16 || (this.saatYoksay && tarih.length() != 10))
    {
      this.hataMesaji = "girilen tarih geçerli değil , lütfen kontrol edin";
      return false;
    }
    //check separators
    int tarihaYirici = 0;
    int zamanYirici = 0;
    int uzay = 0;
    for (int i = 0; i < tarih.length(); i++)
    {
      if (tarih.charAt(i) == this.tarihaYirici) tarihaYirici++;
      if (tarih.charAt(i) == this.zamanYirici) zamanYirici++;
      if (tarih.charAt(i) == this.uzayYirici) uzay++;
    }
    if (tarihaYirici != 2 || zamanYirici != 1 || uzay != 1)
    {
      this.hataMesaji = "Girilen tarih doğru biçimde değil, lütfen kontrol edin, (doğru formati: GG/AA/YYYY SS:DD)";
      return false;
    }

    return true;
  }

  public int getYil()
  {
    return yil;
  }

  public int getAy()
  {
    return ay;
  }

  public int getGun()
  {
    return gun;
  }

  public int getSaat()
  {
    return saat;
  }

  public int getDakika()
  {
    return dakika;
  }

  public int karsilastir(Tarih karsilikliTarih, boolean saatYoksay)
  {
    if (this.yil > karsilikliTarih.getYil())
    {
      return 1;
    } else if (this.yil < karsilikliTarih.getYil())
    {
      return -1;
    } else
    {
      if (this.ay > karsilikliTarih.getAy())
      {
        return 1;
      } else if (this.ay < karsilikliTarih.getAy())
      {
        return -1;
      } else
      {
        if (this.gun > karsilikliTarih.getGun())
        {
          return 1;
        } else if (this.gun < karsilikliTarih.getGun())
        {
          return -1;
        } else
        {
          if(this.saatYoksay || saatYoksay){
            return 0;
          }else {
            if (this.saat > karsilikliTarih.getSaat())
            {
              return 1;
            } else if (this.saat < karsilikliTarih.getSaat())
            {
              return -1;
            } else
            {
              if (this.dakika > karsilikliTarih.getDakika())
              {
                return 1;
              } else if (this.dakika < karsilikliTarih.getDakika())
              {
                return -1;
              } else
              {
                return 0;
              }
            }
          }
        }
      }
    }
  }

  public String toString()
  {
    return sayiDizeye(this.gun) + this.tarihaYirici + sayiDizeye(this.ay) + this.tarihaYirici + sayiDizeye(this.yil) + this.uzayYirici + sayiDizeye(this.saat) + this.zamanYirici + sayiDizeye(this.dakika);
  }

  public String saatsizAl()
  {
    return sayiDizeye(this.gun) + this.tarihaYirici + sayiDizeye(this.ay) + this.tarihaYirici + sayiDizeye(this.yil);
  }

  private String sayiDizeye(int sayi)
  {
    if (sayi < 10)
    {
      return "0" + sayi;
    } else
    {
      return "" + sayi;
    }
  }

}
