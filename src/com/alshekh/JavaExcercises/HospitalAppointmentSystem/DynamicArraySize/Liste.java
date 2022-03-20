package com.alshekh.JavaExcercises.HospitalAppointmentSystem.DynamicArraySize;/*
 * @file Doktor
 * @description
 * @assignment Hastane Randevu Sistemi uygulaması
 * @date Kodu 2022-01-20 00:18:34
 * @author ِIbrahim Alshekh
 */

public class Liste
{
  private Object[] liste;
  private int boyut;
  private int id;

  public Liste(Object object)
  {
    if (object instanceof Doktor)
    {
      this.liste = new Doktor[1];
    } else if (object instanceof Hasta)
    {
      this.liste = new Hasta[1];
    } else if (object instanceof Hastane)
    {
      this.liste = new Hastane[1];
    } else if (object instanceof Klinik)
    {
      this.liste = new Klinik[1];
    } else if (object instanceof Randevu)
    {
      this.liste = new Randevu[1];
    }
    this.boyut = 0;
    this.id = 1;
  }

  public void ekle(Object object)
  {
    this.boyutuBuyut();

    for (int i = 0; i < this.liste.length; i++)
    {
      if (this.liste[i] == null)
      {
        this.liste[i] = object;
        this.boyut = this.boyut + 1;
        this.id = this.id + 1;
        break;
      }
    }
  }

  public int boyut()
  {
    return this.boyut;
  }

  public Object al(int index)
  {
    return this.liste[index];
  }

  public Object al(Object object)
  {
    this.boyutuBuyut();

    for (Object o : this.liste)
    {
      if (o == object)
      {
        return object;
      }
    }
    return null;
  }

  public void sil(Object object)
  {
    for (int i = 0; i < this.boyut; i++)
    {
      if (this.liste[i].equals(object))
      {
        this.liste[i] = null;
        this.boyut = this.boyut - 1;
        if (this.liste.length > 1)
        {
          this.liseKaydir();
          this.boyutuKucult();
        }
        break;
      }
    }
  }

  private void liseKaydir()
  {
    for (int i = 0; i < this.liste.length; i++)
    {
      if (this.liste[i] == null)
      {
        for (int j = i; j < liste.length - 1; j++)
        {
          Object temp = this.liste[j];
          this.liste[j] = this.liste[j + 1];
          this.liste[j + 1] = temp;
        }
      }
    }
  }

  private void boyutuBuyut()
  {
    if (this.boyut < this.liste.length) return;

    int yeniBoyut = this.liste.length * 2;

    yeniListeEkle(yeniBoyut);
  }

  private void boyutuKucult()
  {
    if (this.liste.length < 4 || this.liste[(this.liste.length / 2)] != null) return;

    int yeniBoyut = this.liste.length / 2;

    yeniListeEkle(yeniBoyut);
  }

  private void yeniListeEkle(int listeBoyutu)
  {
    Object[] yeniListe = new Object[listeBoyutu];

    for (int i = 0; i < this.liste.length; i++)
    {
      if(this.liste[i] == null) break;
      yeniListe[i] = this.liste[i];
    }
    this.liste = yeniListe;
  }

  public int idAl()
  {
    return this.id;
  }
}
