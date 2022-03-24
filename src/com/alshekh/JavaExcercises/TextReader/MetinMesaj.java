package com.alshekh.JavaExcercises.TextReader;

public class MetinMesaj implements Okuma
{
  private String gonderen;

  private String icerik;

  public MetinMesaj(String gonderen, String icerik)
  {
    this.gonderen = gonderen;
    this.icerik = icerik;
  }

  @Override
  public String Oku()
  {
    return this.icerik;
  }

  public String getGinderen()
  {
    return this.gonderen;
  }

}
