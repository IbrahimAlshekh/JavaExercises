package com.alshekh.JavaExcercises.HospitalAppointmentSystem.DynamicArraySize;/*
 * @file Doktor
 * @description
 * @assignment Hastane Randevu Sistemi uygulaması
 * @date Kodu 2022-01-20 00:18:34
 * @author ِIbrahim Alshekh
 */

public class YeniDizi
{
  private int uzunlik;
  private char[] dizi;

  public YeniDizi(String s)
  {
    setDizi(s);
  }

  private void setDizi(String s)
  {
    this.uzunlik = s.length();
    char[] ch = new char[this.uzunlik];
    for (int i = 0; i < s.length(); i++)
    {
      ch[i] = s.charAt(i);
    }
    this.dizi = ch;
  }

  public void kucukHarf()
  {
    for (int i = 0; i < this.uzunlik; i++)
    {
      this.dizi[i] = harfKucuket(this.dizi[i]);
    }
  }

  public boolean esitir(YeniDizi dizi)
  {
    if (dizi.uzunlik != this.uzunlik) return false;

    for (int i = 0; i < this.uzunlik; i++)
    {
      if (this.dizi[i] != dizi.charAt(i)) return false;
    }
    return true;
  }

  private char harfKucuket(char ch)
  {
    int c = (int) ch;
    if (c >= 65 && c <= 90 || c >= 192 && c <= 222)
    {
      return (char) (c + 32);
    }
    return ch;
  }

  public boolean icerir(YeniDizi s, boolean harfDurumYoksay)
  {
    boolean icerir = false;
    for (int i = 0; i < this.dizi.length; i++)
    {
      char sKarakter = harfDurumYoksay ? harfKucuket(s.charAt(0)) : s.charAt(0);
      char diziKarakter = harfDurumYoksay ? harfKucuket(this.dizi[i]) : this.dizi[i];

      if (sKarakter == diziKarakter && s.uzunlik <= (this.dizi.length - i))
      {
        icerir = true;
        for (int j = 0; j < s.uzunlik; j++)
        {
          sKarakter = harfDurumYoksay ? harfKucuket(s.charAt(j)) : s.charAt(j);
          diziKarakter = harfDurumYoksay ? harfKucuket(this.dizi[i + j]) : this.dizi[i + j];
          if (sKarakter != diziKarakter)
          {
            return false;
          }
        }
      }
      if(icerir) return true;
    }
    return icerir;
  }

  public String toString()
  {
    String s = "";

    for (char c : this.dizi)
    {
      s += c;
    }

    return s;
  }

  public boolean ilkKarakter(char ch)
  {
    return this.harfKucuket(ch) == this.harfKucuket(this.dizi[0]);
  }

  public boolean sonKarakter(char ch)
  {
    return  this.harfKucuket(ch) == this.harfKucuket(this.dizi[this.dizi.length - 1]);
  }

  public char charAt(int index)
  {
    return this.dizi[index];
  }

  public int uzunlik()
  {
    return this.uzunlik;
  }
}
