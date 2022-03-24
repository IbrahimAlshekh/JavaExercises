package com.alshekh.JavaExcercises.TextReader;

public class EKitap implements Okuma
{
  private String isim;

  private int[] sayfalar;

  private int SayfaNo;

  public EKitap(String isim, int[] sayfalar)
  {
    this.isim = isim;
    this.sayfalar = sayfalar;
    this.SayfaNo = sayfalar[0];
  }

  public String getIsim()
  {
    return isim;
  }

  public int sayfaSayisi()
  {
    return this.sayfalar.length;
  }

  @Override
  public String Oku()
  {
    return String.valueOf(SayfaNo);
  }

  public int sonrakiSayfa()
  {
    if(this.SayfaNo == this.sayfalar[this.sayfalar.length -1]){
      this.SayfaNo = this.sayfalar[0];
    }else {
      for (int i = 0; i < sayfalar.length; i++)
      {
        if(SayfaNo == sayfalar[i]){
          this.SayfaNo = this.sayfalar[i+1];
          break;
        }
      }
    }
    return this.SayfaNo;
  }

}
